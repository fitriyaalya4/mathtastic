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
fun MultiplicationScreen(navController: NavController) {
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
                onClick = { navController.navigate("more") },
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
            LevelButtonMultiplication(stringResource(R.string.easy)) { navController.navigate("multiplication_easy") }
            Spacer(modifier = Modifier.height(16.dp))
            LevelButtonMultiplication(stringResource(R.string.medium)) { navController.navigate("multiplication_medium") }
            Spacer(modifier = Modifier.height(16.dp))
            LevelButtonMultiplication(stringResource(R.string.hard)) { navController.navigate("multiplication_hard") }
        }
    }
}

@Composable
fun LevelButtonMultiplication(text: String, onClick: () -> Unit) {
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
fun MultiplicationEasyScreen(navController: NavController) {
    val quizList = listOf(
        QuizItem(
            numberImage = R.drawable.number1,
            leftImages = List(2) { R.drawable.apple },
            rightImages = List(3) { R.drawable.apple },
            questionText = R.string.question_multiplication,
            options = listOf(6, 5, 4, 3),
            correctAnswer = 6
        ),
        QuizItem(
            numberImage = R.drawable.number2,
            leftImages = List(1) { R.drawable.orange },
            rightImages = List(4) { R.drawable.orange },
            questionText = R.string.question_multiplication,
            options = listOf(3, 4, 5, 6),
            correctAnswer = 4
        ),
        QuizItem(
            numberImage = R.drawable.number3,
            leftImages = List(3) { R.drawable.banana },
            rightImages = List(3) { R.drawable.banana },
            questionText = R.string.question_multiplication,
            options = listOf(6, 7, 9, 8),
            correctAnswer = 9
        ),
        QuizItem(
            numberImage = R.drawable.number4,
            leftImages = List(5) { R.drawable.grapes },
            rightImages = List(1) { R.drawable.grapes },
            questionText = R.string.question_multiplication,
            options = listOf(4, 5, 6, 7),
            correctAnswer = 5
        ),
        QuizItem(
            numberImage = R.drawable.number5,
            leftImages = List(2) { R.drawable.pear },
            rightImages = List(2) { R.drawable.pear },
            questionText = R.string.question_multiplication,
            options = listOf(2, 4, 6, 5),
            correctAnswer = 4
        ),
        QuizItem(
            numberImage = R.drawable.number6,
            leftImages = List(3) { R.drawable.carrot },
            rightImages = List(2) { R.drawable.carrot },
            questionText = R.string.question_multiplication,
            options = listOf(5, 6, 7, 8),
            correctAnswer = 6
        ),
        QuizItem(
            numberImage = R.drawable.number7,
            leftImages = List(1) { R.drawable.bunny},
            rightImages = List(6) { R.drawable.bunny },
            questionText = R.string.question_multiplication,
            options = listOf(5, 6, 7, 8),
            correctAnswer = 6
        ),
        QuizItem(
            numberImage = R.drawable.number8,
            leftImages = List(4) { R.drawable.strawberry },
            rightImages = List(2) { R.drawable.strawberry },
            questionText = R.string.question_multiplication,
            options = listOf(6, 8, 7, 9),
            correctAnswer = 8
        ),
        QuizItem(
            numberImage = R.drawable.number9,
            leftImages = List(3) { R.drawable.mango },
            rightImages = List(1) { R.drawable.mango },
            questionText = R.string.question_multiplication,
            options = listOf(2, 3, 4, 5),
            correctAnswer = 3
        ),
        QuizItem(
            numberImage = R.drawable.number10,
            leftImages = List(2) { R.drawable.tomato },
            rightImages = List(5) { R.drawable.tomato },
            questionText = R.string.question_multiplication,
            options = listOf(10, 9, 8, 7),
            correctAnswer = 10
        )
    )

    QuizScreen(
        quizList = quizList,
        operationType = "multiplication",
        levelLabel = stringResource(R.string.easy),
        navController = navController,
        routeToPop = "multiplication"
    )
}


@Composable
fun MultiplicationMediumScreen(navController: NavController) {
    val quizList = listOf(
        QuizItem(
            numberImage = R.drawable.number1,
            leftImages = List(2) { R.drawable.apple },
            rightImages = List(6) { R.drawable.apple },
            questionText = R.string.question_multiplication,
            options = listOf(10, 11, 12, 13),
            correctAnswer = 12
        ),
        QuizItem(
            numberImage = R.drawable.number2,
            leftImages = List(3) { R.drawable.orange },
            rightImages = List(5) { R.drawable.orange },
            questionText = R.string.question_multiplication,
            options = listOf(15, 14, 16, 13),
            correctAnswer = 15
        ),
        QuizItem(
            numberImage = R.drawable.number3,
            leftImages = List(4) { R.drawable.banana },
            rightImages = List(4) { R.drawable.banana },
            questionText = R.string.question_multiplication,
            options = listOf(16, 18, 12, 14),
            correctAnswer = 16
        ),
        QuizItem(
            numberImage = R.drawable.number4,
            leftImages = List(2) { R.drawable.grapes },
            rightImages = List(7) { R.drawable.grapes },
            questionText = R.string.question_multiplication,
            options = listOf(12, 14, 16, 18),
            correctAnswer = 14
        ),
        QuizItem(
            numberImage = R.drawable.number5,
            leftImages = List(3) { R.drawable.pear },
            rightImages = List(6) { R.drawable.pear },
            questionText = R.string.question_multiplication,
            options = listOf(17, 18, 19, 20),
            correctAnswer = 18
        ),
        QuizItem(
            numberImage = R.drawable.number6,
            leftImages = List(2) { R.drawable.carrot },
            rightImages = List(9) { R.drawable.carrot },
            questionText = R.string.question_multiplication,
            options = listOf(16, 18, 20, 22),
            correctAnswer = 18
        ),
        QuizItem(
            numberImage = R.drawable.number7,
            leftImages = List(5) { R.drawable.bunny },
            rightImages = List(3) { R.drawable.bunny },
            questionText = R.string.question_multiplication,
            options = listOf(15, 13, 17, 19),
            correctAnswer = 15
        ),
        QuizItem(
            numberImage = R.drawable.number8,
            leftImages = List(4) { R.drawable.strawberry },
            rightImages = List(5) { R.drawable.strawberry },
            questionText = R.string.question_multiplication,
            options = listOf(18, 19, 20, 21),
            correctAnswer = 20
        ),
        QuizItem(
            numberImage = R.drawable.number9,
            leftImages = List(3) { R.drawable.mango },
            rightImages = List(4) { R.drawable.mango },
            questionText = R.string.question_multiplication,
            options = listOf(10, 11, 12, 13),
            correctAnswer = 12
        ),
        QuizItem(
            numberImage = R.drawable.number10,
            leftImages = List(2) { R.drawable.tomato },
            rightImages = List(8) { R.drawable.tomato },
            questionText = R.string.question_multiplication,
            options = listOf(14, 15, 16, 17),
            correctAnswer = 16
        )

    )
    QuizScreen(
        quizList = quizList,
        operationType = "multiplication",
        levelLabel = stringResource(R.string.medium),
        navController = navController,
        routeToPop = "multiplication"
    )
}

@Composable
fun MultiplicationHardScreen(navController: NavController) {
    val quizList = listOf(
        QuizItem(
            numberImage = R.drawable.number1,
            leftImages = List(3) { R.drawable.apple },
            rightImages = List(9) { R.drawable.apple },
            questionText = R.string.question_multiplication,
            options = listOf(27, 26, 28, 29),
            correctAnswer = 27
        ),
        QuizItem(
            numberImage = R.drawable.number2,
            leftImages = List(3) { R.drawable.orange },
            rightImages = List(8) { R.drawable.orange },
            questionText = R.string.question_multiplication,
            options = listOf(22, 24, 25, 26),
            correctAnswer = 24
        ),
        QuizItem(
            numberImage = R.drawable.number3,
            leftImages = List(3) { R.drawable.banana },
            rightImages = List(7) { R.drawable.banana },
            questionText = R.string.question_multiplication,
            options = listOf(20, 21, 22, 23),
            correctAnswer = 21
        ),
        QuizItem(
            numberImage = R.drawable.number4,
            leftImages = List(3) { R.drawable.grapes },
            rightImages = List(10) { R.drawable.grapes },
            questionText = R.string.question_multiplication,
            options = listOf(30, 28, 27, 29),
            correctAnswer = 30
        ),
        QuizItem(
            numberImage = R.drawable.number5,
            leftImages = List(3) { R.drawable.pear },
            rightImages = List(6) { R.drawable.pear },
            questionText = R.string.question_multiplication,
            options = listOf(16, 18, 20, 21),
            correctAnswer = 18
        ),
        QuizItem(
            numberImage = R.drawable.number6,
            leftImages = List(3) { R.drawable.carrot },
            rightImages = List(7) { R.drawable.carrot },
            questionText = R.string.question_multiplication,
            options = listOf(19, 20, 21, 22),
            correctAnswer = 21
        ),
        QuizItem(
            numberImage = R.drawable.number7,
            leftImages = List(3) { R.drawable.owl },
            rightImages = List(8) { R.drawable.owl},
            questionText = R.string.question_multiplication,
            options = listOf(22, 23, 24, 25),
            correctAnswer = 24
        ),
        QuizItem(
            numberImage = R.drawable.number8,
            leftImages = List(3) { R.drawable.strawberry },
            rightImages = List(6) { R.drawable.strawberry },
            questionText = R.string.question_multiplication,
            options = listOf(17, 18, 19, 20),
            correctAnswer = 18
        ),
        QuizItem(
            numberImage = R.drawable.number9,
            leftImages = List(3) { R.drawable.mango },
            rightImages = List(9) { R.drawable.mango },
            questionText = R.string.question_multiplication,
            options = listOf(26, 27, 28, 29),
            correctAnswer = 27
        ),
        QuizItem(
            numberImage = R.drawable.number10,
            leftImages = List(3) { R.drawable.tomato },
            rightImages = List(8) { R.drawable.tomato },
            questionText = R.string.question_multiplication,
            options = listOf(23, 24, 25, 26),
            correctAnswer = 24
        )
    )
    QuizScreen(
        quizList = quizList,
        operationType = "multiplication",
        levelLabel = stringResource(R.string.hard),
        navController = navController,
        routeToPop = "multiplication"
    )
}

