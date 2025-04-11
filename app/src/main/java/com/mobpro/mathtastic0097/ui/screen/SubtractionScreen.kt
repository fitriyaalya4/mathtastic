package com.mobpro.mathtastic0097.ui.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.mobpro.mathtastic0097.R

@Composable
fun SubtractionScreen(navController: NavController) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFF9C88F)),
        contentAlignment = Alignment.Center
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 32.dp, start = 16.dp, end = 16.dp)
                .align(Alignment.TopCenter),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            IconButton(
                onClick = { navController.popBackStack("operation", inclusive = false) },
                modifier = Modifier
                    .size(60.dp)
                    .background(Color(0xFFE9E3DA), shape = CircleShape)
            ) {
                Icon(
                    Icons.AutoMirrored.Filled.ArrowBack,
                    contentDescription = "Back",
                    tint = Color(0xFFD83A4E),
                    modifier = Modifier.size(30.dp)
                )
            }

            IconButton(
                onClick = { },
                modifier = Modifier
                    .size(60.dp)
                    .background(Color(0xFFE9E3DA), shape = CircleShape)
            ) {
                Icon(
                    Icons.Default.MoreVert,
                    contentDescription = "More",
                    tint = Color(0xFFD83A4E),
                    modifier = Modifier.size(30.dp)
                )
            }
        }

        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Text(
                text = stringResource(id = R.string.choose_level),
                style = TextStyle(
                    fontSize = 90.sp,
                    fontWeight = FontWeight.ExtraBold,
                    color = Color(0xFFD83A4E),
                    textAlign = TextAlign.Center
                )
            )

            Spacer(modifier = Modifier.height(32.dp))
            LevelButtonSubtraction(stringResource(R.string.easy)) { navController.navigate("subtraction_easy") }
            Spacer(modifier = Modifier.height(16.dp))
            LevelButtonSubtraction(stringResource(R.string.medium)) { navController.navigate("subtraction_medium") }
            Spacer(modifier = Modifier.height(16.dp))
            LevelButtonSubtraction(stringResource(R.string.hard)) { navController.navigate("subtraction_hard") }
        }
    }
}

@Composable
fun LevelButtonSubtraction(text: String, onClick: () -> Unit) {
    Button(
        onClick = onClick,
        modifier = Modifier
            .width(150.dp)
            .height(50.dp),
        colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFE9E3DA)),
        shape = CircleShape,
        contentPadding = PaddingValues(0.dp)
    ) {
        Text(
            text = text.uppercase(),
            fontSize = 25.sp,
            fontWeight = FontWeight.Bold,
            color = Color(0xFFD83A4E)
        )
    }
}

@Composable
fun SubtractionEasyScreen(navController: NavController) {
    val quizList = listOf(
        QuizItem(
            numberImage = R.drawable.number1,
            leftImages = List(6) { R.drawable.apple },
            rightImages = List(2) { R.drawable.apple },
            questionText = R.string.question_subtraction,
            options = listOf(3, 4, 5, 6),
            correctAnswer = 4
        ),
        QuizItem(
            numberImage = R.drawable.number2,
            leftImages = List(5) { R.drawable.orange },
            rightImages = List(3) { R.drawable.orange },
            questionText = R.string.question_subtraction,
            options = listOf(1, 2, 3, 4),
            correctAnswer = 2
        ),
        QuizItem(
            numberImage = R.drawable.number3,
            leftImages = List(7) { R.drawable.banana },
            rightImages = List(4) { R.drawable.banana },
            questionText = R.string.question_subtraction,
            options = listOf(2, 3, 4, 5),
            correctAnswer = 3
        ),
        QuizItem(
            numberImage = R.drawable.number4,
            leftImages = List(8) { R.drawable.grapes },
            rightImages = List(2) { R.drawable.grapes },
            questionText = R.string.question_subtraction,
            options = listOf(4, 5, 6, 7),
            correctAnswer = 6
        ),
        QuizItem(
            numberImage = R.drawable.number5,
            leftImages = List(2) { R.drawable.pear },
            rightImages = List(1) { R.drawable.pear },
            questionText = R.string.question_subtraction,
            options = listOf(1, 2, 4, 5),
            correctAnswer = 1
        ),
        QuizItem(
            numberImage = R.drawable.number6,
            leftImages = List(4) { R.drawable.carrot },
            rightImages = List(4) { R.drawable.carrot },
            questionText = R.string.question_subtraction,
            options = listOf(0, 1, 3, 4),
            correctAnswer = 0
        ),
        QuizItem(
            numberImage = R.drawable.number7,
            leftImages = List(6) { R.drawable.banana },
            rightImages = List(1) { R.drawable.banana },
            questionText = R.string.question_subtraction,
            options = listOf(4, 5, 6, 7),
            correctAnswer = 5
        ),
        QuizItem(
            numberImage = R.drawable.number8,
            leftImages = List(7) { R.drawable.strawberry },
            rightImages = List(3) { R.drawable.strawberry },
            questionText = R.string.question_subtraction,
            options = listOf(3, 4, 5, 6),
            correctAnswer = 4
        ),
        QuizItem(
            numberImage = R.drawable.number9,
            leftImages = List(4) { R.drawable.mango },
            rightImages = List(2) { R.drawable.mango },
            questionText = R.string.question_subtraction,
            options = listOf(1, 2, 3, 4),
            correctAnswer = 2
        ),
        QuizItem(
            numberImage = R.drawable.number10,
            leftImages = List(6) { R.drawable.tomato },
            rightImages = List(3) { R.drawable.tomato },
            questionText = R.string.question_subtraction,
            options = listOf(3, 4, 6, 7),
            correctAnswer = 3
        )
    )
    QuizScreen(
        quizList = quizList,
        operationType = "subtraction",
        levelLabel = stringResource(R.string.easy),
        navController = navController,
        routeToPop = "subtraction"
    )
}

@Composable
fun SubtractionMediumScreen(navController: NavController) {
    val quizList = listOf(
        QuizItem(
            numberImage = R.drawable.number1,
            leftImages = List(14) { R.drawable.apple },
            rightImages = List(4) { R.drawable.apple },
            questionText = R.string.question_subtraction,
            options = listOf(9, 10, 11, 12),
            correctAnswer = 10
        ),
        QuizItem(
            numberImage = R.drawable.number2,
            leftImages = List(18) { R.drawable.orange },
            rightImages = List(6) { R.drawable.orange },
            questionText = R.string.question_subtraction,
            options = listOf(12, 13, 14, 15),
            correctAnswer = 12
        ),
        QuizItem(
            numberImage = R.drawable.number3,
            leftImages = List(16) { R.drawable.banana },
            rightImages = List(5) { R.drawable.banana },
            questionText = R.string.question_subtraction,
            options = listOf(11, 12, 15, 16),
            correctAnswer = 11
        ),
        QuizItem(
            numberImage = R.drawable.number4,
            leftImages = List(20) { R.drawable.grapes },
            rightImages = List(9) { R.drawable.grapes },
            questionText = R.string.question_subtraction,
            options = listOf(10, 11, 12, 13),
            correctAnswer = 11
        ),
        QuizItem(
            numberImage = R.drawable.number5,
            leftImages = List(17) { R.drawable.pear },
            rightImages = List(4) { R.drawable.pear },
            questionText = R.string.question_subtraction,
            options = listOf(13, 14, 15, 16),
            correctAnswer = 13
        ),
        QuizItem(
            numberImage = R.drawable.number6,
            leftImages = List(19) { R.drawable.carrot },
            rightImages = List(5) { R.drawable.carrot },
            questionText = R.string.question_subtraction,
            options = listOf(14, 15, 18, 19),
            correctAnswer = 14
        ),
        QuizItem(
            numberImage = R.drawable.number7,
            leftImages = List(27) { R.drawable.banana },
            rightImages = List(7) { R.drawable.banana },
            questionText = R.string.question_subtraction,
            options = listOf(12, 13, 14, 15),
            correctAnswer = 15
        ),
        QuizItem(
            numberImage = R.drawable.number8,
            leftImages = List(21) { R.drawable.strawberry },
            rightImages = List(4) { R.drawable.strawberry },
            questionText = R.string.question_subtraction,
            options = listOf(17, 18, 19, 20),
            correctAnswer = 17
        ),
        QuizItem(
            numberImage = R.drawable.number9,
            leftImages = List(18) { R.drawable.mango },
            rightImages = List(5) { R.drawable.mango },
            questionText = R.string.question_subtraction,
            options = listOf(11, 12, 13, 14),
            correctAnswer = 14
        ),
        QuizItem(
            numberImage = R.drawable.number10,
            leftImages = List(20) { R.drawable.tomato },
            rightImages = List(1) { R.drawable.tomato },
            questionText = R.string.question_subtraction,
            options = listOf(18, 19, 20, 21),
            correctAnswer = 19
        )
    )
    QuizScreen(
        quizList = quizList,
        operationType = "subtraction",
        levelLabel = stringResource(R.string.medium),
        navController = navController,
        routeToPop = "subtraction"
    )
}

@Composable
fun SubtractionHardScreen(navController: NavController) {
    val quizList = listOf(
        QuizItem(
            numberImage = R.drawable.number1,
            leftImages = List(30) { R.drawable.apple },
            rightImages = List(6) { R.drawable.apple },
            questionText = R.string.question_subtraction,
            options = listOf(28, 24, 25, 31),
            correctAnswer = 24
        ),
        QuizItem(
            numberImage = R.drawable.number2,
            leftImages = List(30) { R.drawable.orange },
            rightImages = List(10) { R.drawable.orange },
            questionText = R.string.question_subtraction,
            options = listOf(20, 21, 22, 23),
            correctAnswer = 20
        ),
        QuizItem(
            numberImage = R.drawable.number3,
            leftImages = List(33) { R.drawable.banana },
            rightImages = List(8) { R.drawable.banana },
            questionText = R.string.question_subtraction,
            options = listOf(24, 25, 26, 27),
            correctAnswer = 25
        ),
        QuizItem(
            numberImage = R.drawable.number4,
            leftImages = List(29) { R.drawable.grapes },
            rightImages = List(7) { R.drawable.grapes },
            questionText = R.string.question_subtraction,
            options = listOf(21, 22, 23, 24),
            correctAnswer = 22
        ),
        QuizItem(
            numberImage = R.drawable.number5,
            leftImages = List(34) { R.drawable.pear },
            rightImages = List(6) { R.drawable.pear },
            questionText = R.string.question_subtraction,
            options = listOf(28, 29, 30, 31),
            correctAnswer = 28
        ),
        QuizItem(
            numberImage = R.drawable.number6,
            leftImages = List(31) { R.drawable.carrot },
            rightImages = List(4) { R.drawable.carrot },
            questionText = R.string.question_subtraction,
            options = listOf(26, 27, 28, 29),
            correctAnswer = 27
        ),
        QuizItem(
            numberImage = R.drawable.number7,
            leftImages = List(29) { R.drawable.banana },
            rightImages = List(5) { R.drawable.banana },
            questionText = R.string.question_subtraction,
            options = listOf(21, 22, 23, 24),
            correctAnswer = 24
        ),
        QuizItem(
            numberImage = R.drawable.number8,
            leftImages = List(36) { R.drawable.strawberry },
            rightImages = List(6) { R.drawable.strawberry },
            questionText = R.string.question_subtraction,
            options = listOf(29, 30, 31, 32),
            correctAnswer = 30
        ),
        QuizItem(
            numberImage = R.drawable.number9,
            leftImages = List(33) { R.drawable.mango },
            rightImages = List(5) { R.drawable.mango },
            questionText = R.string.question_subtraction,
            options = listOf(26, 27, 28, 29),
            correctAnswer = 28
        ),
        QuizItem(
            numberImage = R.drawable.number10,
            leftImages = List(33) { R.drawable.tomato },
            rightImages = List(2) { R.drawable.tomato },
            questionText = R.string.question_subtraction,
            options = listOf(28, 29, 30, 31),
            correctAnswer = 31
        )
    )
    QuizScreen(
        quizList = quizList,
        operationType = "subtraction",
        levelLabel = stringResource(R.string.hard),
        navController = navController,
        routeToPop = "subtractions"
    )
}


