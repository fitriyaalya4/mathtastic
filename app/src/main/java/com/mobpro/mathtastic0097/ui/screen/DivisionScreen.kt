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
fun DivisionScreen(navController: NavController) {
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
            LevelButtonDivision(stringResource(R.string.easy)) { navController.navigate("division_easy") }
            Spacer(modifier = Modifier.height(16.dp))
            LevelButtonDivision(stringResource(R.string.medium)) { navController.navigate("division_medium") }
            Spacer(modifier = Modifier.height(16.dp))
            LevelButtonDivision(stringResource(R.string.hard)) { navController.navigate("division_hard") }
        }
    }
}

@Composable
fun LevelButtonDivision(text: String, onClick: () -> Unit) {
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
fun DivisionEasyScreen(navController: NavController) {
    val quizList = listOf(
        QuizItem(
            numberImage = R.drawable.number1,
            leftImages = List(8) { R.drawable.orange },
            rightImages = List(2) { R.drawable.orange },
            questionText = R.string.question_division,
            options = listOf(2, 4, 6, 8),
            correctAnswer = 4
        ),
        QuizItem(
            numberImage = R.drawable.number2,
            leftImages = List(6) { R.drawable.strawberry },
            rightImages = List(3) { R.drawable.strawberry },
            questionText = R.string.question_division,
            options = listOf(1, 2, 3, 4),
            correctAnswer = 2
        ),
        QuizItem(
            numberImage = R.drawable.number3,
            leftImages = List(9) { R.drawable.chick},
            rightImages = List(1) { R.drawable.chick},
            questionText = R.string.question_division,
            options = listOf(7, 9, 3, 2),
            correctAnswer = 9
        ),
        QuizItem(
            numberImage = R.drawable.number4,
            leftImages = List(5) { R.drawable.pear },
            rightImages = List(5) { R.drawable.pear },
            questionText = R.string.question_division,
            options = listOf(1, 5, 3, 2),
            correctAnswer = 1
        ),
        QuizItem(
            numberImage = R.drawable.number5,
            leftImages = List(10) { R.drawable.chick },
            rightImages = List(2) { R.drawable.chick },
            questionText = R.string.question_division,
            options = listOf(2, 4, 5, 6),
            correctAnswer = 5
        ),
        QuizItem(
            numberImage = R.drawable.number6,
            leftImages = List(12) { R.drawable.strawberry },
            rightImages = List(4) { R.drawable.strawberry },
            questionText = R.string.question_division,
            options = listOf(2, 4, 3, 6),
            correctAnswer = 3
        ),
        QuizItem(
            numberImage = R.drawable.number7,
            leftImages = List(7) { R.drawable.pineapple },
            rightImages = List(1) { R.drawable.pineapple },
            questionText = R.string.question_division,
            options = listOf(5, 7, 6, 3),
            correctAnswer = 7
        ),
        QuizItem(
            numberImage = R.drawable.number8,
            leftImages = List(18) { R.drawable.turtle },
            rightImages = List(3) { R.drawable.turtle },
            questionText = R.string.question_division,
            options = listOf(5, 7, 6, 9),
            correctAnswer = 6
        ),
        QuizItem(
            numberImage = R.drawable.number9,
            leftImages = List(10) { R.drawable.elephant },
            rightImages = List(5) { R.drawable.elephant },
            questionText = R.string.question_division,
            options = listOf(1, 3, 2, 5),
            correctAnswer = 2
        ),
        QuizItem(
            numberImage = R.drawable.number10,
            leftImages = List(8) { R.drawable.jellyfish },
            rightImages = List(4) { R.drawable.jellyfish },
            questionText = R.string.question_division,
            options = listOf(2, 4, 3, 1),
            correctAnswer = 2
        )
    )

    QuizScreen(
        quizList = quizList,
        operationType = "division",
        levelLabel = stringResource(R.string.easy),
        navController = navController,
        routeToPop = "division"
    )
}

@Composable
fun DivisionMediumScreen(navController: NavController) {
    val quizList = listOf(
        QuizItem(
            numberImage = R.drawable.number1,
            leftImages = List(15) { R.drawable.apple },
            rightImages = List(1) { R.drawable.apple },
            questionText = R.string.question_division,
            options = listOf(15, 12, 10, 13),
            correctAnswer = 15
        ),
        QuizItem(
            numberImage = R.drawable.number2,
            leftImages = List(12) { R.drawable.frog },
            rightImages = List(2) { R.drawable.frog },
            questionText = R.string.question_division,
            options = listOf(6, 5, 7, 8),
            correctAnswer = 6
        ),
        QuizItem(
            numberImage = R.drawable.number3,
            leftImages = List(10) { R.drawable.bird },
            rightImages = List(2) { R.drawable.bird },
            questionText = R.string.question_division,
            options = listOf(4, 5, 3, 6),
            correctAnswer = 5
        ),
        QuizItem(
            numberImage = R.drawable.number4,
            leftImages = List(21) { R.drawable.dog },
            rightImages = List(3) { R.drawable.dog },
            questionText = R.string.question_division,
            options = listOf(7, 6, 8, 9),
            correctAnswer = 7
        ),
        QuizItem(
            numberImage = R.drawable.number5,
            leftImages = List(24) { R.drawable.shrimp },
            rightImages = List(4) { R.drawable.shrimp },
            questionText = R.string.question_division,
            options = listOf(6, 5, 4, 3),
            correctAnswer = 6
        ),
        QuizItem(
            numberImage = R.drawable.number6,
            leftImages = List(18) { R.drawable.pencil },
            rightImages = List(3) { R.drawable.pencil },
            questionText = R.string.question_division,
            options = listOf(5, 6, 7, 4),
            correctAnswer = 6
        ),
        QuizItem(
            numberImage = R.drawable.number7,
            leftImages = List(13) { R.drawable.fish },
            rightImages = List(1) { R.drawable.fish },
            questionText = R.string.question_division,
            options = listOf(12, 14, 13, 11),
            correctAnswer = 13
        ),
        QuizItem(
            numberImage = R.drawable.number8,
            leftImages = List(9) { R.drawable.egg },
            rightImages = List(3) { R.drawable.egg },
            questionText = R.string.question_division,
            options = listOf(2, 3, 4, 5),
            correctAnswer = 3
        ),
        QuizItem(
            numberImage = R.drawable.number9,
            leftImages = List(8) { R.drawable.duck },
            rightImages = List(2) { R.drawable.duck },
            questionText = R.string.question_division,
            options = listOf(3, 2, 4, 1),
            correctAnswer = 4
        ),
        QuizItem(
            numberImage = R.drawable.number10,
            leftImages = List(14) { R.drawable.cake },
            rightImages = List(2) { R.drawable.cake },
            questionText = R.string.question_division,
            options = listOf(5, 6, 7, 8),
            correctAnswer = 7
        )
    )

    QuizScreen(
        quizList = quizList,
        operationType = "division",
        levelLabel = stringResource(R.string.medium),
        navController = navController,
        routeToPop = "division"
    )
}

@Composable
fun DivisionHardScreen(navController: NavController) {
    val quizList = listOf(
        QuizItem(
            numberImage = R.drawable.number1,
            leftImages = List(20) { R.drawable.strawberry },
            rightImages = List(2) { R.drawable.strawberry },
            questionText = R.string.question_division,
            options = listOf(20, 22, 18, 10),
            correctAnswer = 10
        ),
        QuizItem(
            numberImage = R.drawable.number2,
            leftImages = List(36) { R.drawable.elephant },
            rightImages = List(6) { R.drawable.elephant },
            questionText = R.string.question_division,
            options = listOf(8, 6, 7, 9),
            correctAnswer = 6
        ),
        QuizItem(
            numberImage = R.drawable.number3,
            leftImages = List(26) { R.drawable.pear },
            rightImages = List(2) { R.drawable.pear },
            questionText = R.string.question_division,
            options = listOf(13, 14, 16, 15),
            correctAnswer = 13
        ),
        QuizItem(
            numberImage = R.drawable.number4,
            leftImages = List(33) { R.drawable.carrot },
            rightImages = List(3) { R.drawable.carrot },
            questionText = R.string.question_division,
            options = listOf(11, 13, 15, 17),
            correctAnswer = 11
        ),
        QuizItem(
            numberImage = R.drawable.number5,
            leftImages = List(24) { R.drawable.pineapple },
            rightImages = List(2) { R.drawable.pineapple },
            questionText = R.string.question_division,
            options = listOf(12, 14, 15, 20),
            correctAnswer = 12
        ),
        QuizItem(
            numberImage = R.drawable.number6,
            leftImages = List(28) { R.drawable.orange },
            rightImages = List(2) { R.drawable.orange },
            questionText = R.string.question_division,
            options = listOf(11, 17, 14, 15),
            correctAnswer = 14
        ),
        QuizItem(
            numberImage = R.drawable.number7,
            leftImages = List(25) { R.drawable.pear },
            rightImages = List(1) { R.drawable.pear },
            questionText = R.string.question_division,
            options = listOf(24, 25, 26, 27),
            correctAnswer = 25
        ),
        QuizItem(
            numberImage = R.drawable.number8,
            leftImages = List(36) { R.drawable.jellyfish },
            rightImages = List(2) { R.drawable.jellyfish },
            questionText = R.string.question_division,
            options = listOf(15, 16, 17, 18),
            correctAnswer = 18
        ),
        QuizItem(
            numberImage = R.drawable.number9,
            leftImages = List(27) { R.drawable.cabbage },
            rightImages = List(3) { R.drawable.cabbage },
            questionText = R.string.question_division,
            options = listOf(9, 7, 8, 6),
            correctAnswer = 9
        ),
        QuizItem(
            numberImage = R.drawable.number10,
            leftImages = List(24) { R.drawable.banana },
            rightImages = List(1) { R.drawable.banana },
            questionText = R.string.question_division,
            options = listOf(22, 23, 24, 25),
            correctAnswer = 24
        )
    )

    QuizScreen(
        quizList = quizList,
        operationType = "division",
        levelLabel = stringResource(R.string.hard),
        navController = navController,
        routeToPop = "division"
    )
}
