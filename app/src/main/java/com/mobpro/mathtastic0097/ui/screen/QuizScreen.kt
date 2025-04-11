package com.mobpro.mathtastic0097.ui.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

data class QuizItem(
    val numberImage: Int,
    val leftImages: List<Int>,
    val rightImages: List<Int>,
    val questionText: Int,
    val options: List<Int>,
    val correctAnswer: Int
)

@Composable
fun ImageGrid(images: List<Int>, columns: Int, imageSize: Dp) {
    Column(
        verticalArrangement = Arrangement.spacedBy(4.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxWidth()
    ) {
        images.chunked(columns).forEach { row ->
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
                row.forEach { imageRes ->
                    Image(
                        painter = painterResource(imageRes),
                        contentDescription = null,
                        modifier = Modifier
                            .size(imageSize)
                            .padding(2.dp)
                    )
                }
            }
        }
    }
}

@Composable
fun OptionButton(answer: Int, selectedOption: Int, onClick: (Int) -> Unit) {
    Box(
        modifier = Modifier
            .size(width = 120.dp, height = 60.dp)
            .clickable { onClick(answer) }
            .background(
                color = if (selectedOption == answer) Color(0xFFFFE0E0) else Color(0xFFE9E3DA),
                shape = RoundedCornerShape(30.dp)
            )
            .shadow(4.dp, RoundedCornerShape(30.dp))
            .padding(horizontal = 16.dp, vertical = 8.dp)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center,
            modifier = Modifier.fillMaxSize()
        ) {
            Box(
                modifier = Modifier
                    .size(24.dp)
                    .background(Color(0xFFD83A4E), shape = CircleShape)
            )
            Spacer(modifier = Modifier.width(12.dp))
            Text(text = answer.toString(), fontSize = 20.sp, fontWeight = FontWeight.Bold)
        }
    }
}

@Composable
fun CircleIconButton(icon: ImageVector, onClick: () -> Unit) {
    IconButton(
        onClick = onClick,
        modifier = Modifier
            .size(48.dp)
            .background(Color(0xFFE9E3DA), shape = CircleShape)
    ) {
        Icon(icon, contentDescription = null, tint = Color(0xFFD83A4E))
    }
}

@Composable
fun HandleEndOfQuiz(
    currentIndex: Int,
    quizSize: Int,
    points: Int,
    navController: NavController,
    routeToPop: String,
    operationType: String
) {
    if (currentIndex >= quizSize) {
        val trueCount = points / 10
        val falseCount = quizSize - trueCount
        LaunchedEffect(Unit) {
            navController.navigate("score/$operationType/$trueCount/$falseCount/$points") {
                popUpTo(routeToPop) { inclusive = true }
            }
        }
    }
}

@Composable
fun QuizScreen(
    quizList: List<QuizItem>,
    operationType: String,
    levelLabel: String,
    navController: NavController,
    routeToPop: String
) {
    var currentIndex by remember { mutableIntStateOf(0) }
    var points by remember { mutableIntStateOf(0) }
    var selectedOption by remember { mutableIntStateOf(-1) }

    HandleEndOfQuiz(currentIndex, quizList.size, points, navController, routeToPop, operationType)
    if (currentIndex >= quizList.size) return

    val currentQuiz = quizList[currentIndex]
    val gridColumns = when (levelLabel.lowercase()) {
        "easy" -> 2
        "medium" -> 3
        "hard" -> 4
        else -> 2
    }
    val imageSize = when (levelLabel.lowercase()) {
        "easy" -> 60.dp
        "medium" -> 35.dp
        "hard" -> 25.dp
        else -> 35.dp
    }

    val operatorSymbol = when (operationType.lowercase()) {
        "addition" -> "+"
        "subtraction" -> "-"
        "multiplication" -> "×"
        "division" -> "÷"
        else -> "?"
    }

    Box(modifier = Modifier.fillMaxSize().background(Color(0xFFF9C88F))) {
        Row(
            modifier = Modifier.fillMaxWidth().padding(top = 24.dp, start = 16.dp, end = 16.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            CircleIconButton(icon = Icons.AutoMirrored.Filled.ArrowBack) { navController.popBackStack() }
            Text(
                text = levelLabel,
                modifier = Modifier
                    .background(Color(0xFFE9E3DA), RoundedCornerShape(20.dp))
                    .padding(horizontal = 24.dp, vertical = 8.dp),
                fontWeight = FontWeight.Bold,
                fontSize = 18.sp,
                color = Color(0xFFD83A4E)
            )
            CircleIconButton(icon = Icons.Default.MoreVert) { navController.navigate("more") }
        }

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 16.dp)
                .align(Alignment.Center),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            Spacer(modifier = Modifier.height(100.dp))

            Box(
                modifier = Modifier
                    .size(70.dp)
                    .background(Color(0xFFE9E3DA), shape = CircleShape),
                contentAlignment = Alignment.Center
            ) {
                Image(
                    painter = painterResource(id = currentQuiz.numberImage),
                    contentDescription = null,
                    modifier = Modifier.size(40.dp)
                )
            }

            Box(
                modifier = Modifier
                    .sizeIn(maxWidth = 320.dp, maxHeight = 320.dp)
                    .aspectRatio(1f)
                    .background(Color(0xFFE9E3DA), RoundedCornerShape(20.dp))
                    .padding(12.dp)
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(8.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Box(
                        modifier = Modifier
                            .weight(1f),
                        contentAlignment = Alignment.Center
                    ) {
                        ImageGrid(currentQuiz.leftImages, columns = gridColumns, imageSize = imageSize)
                    }

                    Box(
                        modifier = Modifier
                            .width(40.dp),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(
                            text = operatorSymbol,
                            fontSize = 32.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color(0xFFD83A4E),
                            textAlign = TextAlign.Center
                        )
                    }

                    Box(
                        modifier = Modifier
                            .weight(1f),
                        contentAlignment = Alignment.Center
                    ) {
                        ImageGrid(currentQuiz.rightImages, columns = gridColumns, imageSize = imageSize)
                    }
                }
            }

            Box(
                modifier = Modifier
                    .background(Color(0xFFE9E3DA), RoundedCornerShape(20.dp))
                    .padding(horizontal = 20.dp, vertical = 8.dp)
            ) {
                Text(
                    text = stringResource(id = currentQuiz.questionText),
                    fontSize = 14.sp,
                    color = Color.Black,
                    textAlign = TextAlign.Center
                )
            }

            Column(verticalArrangement = Arrangement.spacedBy(16.dp)) {
                currentQuiz.options.chunked(2).forEach { row ->
                    Row(horizontalArrangement = Arrangement.spacedBy(24.dp)) {
                        row.forEach { answer ->
                            OptionButton(answer, selectedOption) { selectedOption = it }
                        }
                    }
                }
            }

            Spacer(modifier = Modifier.height(8.dp))

            Button(
                onClick = {
                    if (selectedOption == currentQuiz.correctAnswer) points += 10
                    currentIndex++
                    selectedOption = -1
                },
                enabled = selectedOption != -1,
                colors = ButtonDefaults.buttonColors(
                    containerColor = if (selectedOption != -1) Color(0xFFE9E3DA) else Color.Gray
                ),
                shape = RoundedCornerShape(30.dp)
            ) {
                Text("NEXT", color = Color(0xFFD83A4E), fontWeight = FontWeight.Bold, fontSize = 18.sp)
            }

            Spacer(modifier = Modifier.height(24.dp))
        }
    }
}
