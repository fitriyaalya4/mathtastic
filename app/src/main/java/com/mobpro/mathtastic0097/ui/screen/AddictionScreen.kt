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
fun AdditionScreen(navController: NavController) {
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
                onClick = { /* Optional: Show menu */ },
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
            LevelButton(stringResource(R.string.easy)) { navController.navigate("addition_easy") }
            Spacer(modifier = Modifier.height(16.dp))
            LevelButton(stringResource(R.string.medium)) { navController.navigate("addition_medium") }
            Spacer(modifier = Modifier.height(16.dp))
            LevelButton(stringResource(R.string.hard)) { navController.navigate("addition_hard") }
        }
    }
}

@Composable
fun LevelButton(text: String, onClick: () -> Unit) {
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
fun AdditionEasyScreen(navController: NavController) {
    val quizList = listOf(
        QuizItem(
            numberImage = R.drawable.number1,
            leftImages = List(3) { R.drawable.orange },
            rightImages = List(2) { R.drawable.orange },
            questionText = R.string.question_addition,
            options = listOf(3, 4, 5, 2),
            correctAnswer = 5
        ),
        QuizItem(
            numberImage = R.drawable.number2,
            leftImages = List(3) { R.drawable.pineapple },
            rightImages = List(1) { R.drawable.pineapple },
            questionText = R.string.question_addition,
            options = listOf(4, 5, 3, 2),
            correctAnswer = 4
        ),
        QuizItem(
            numberImage = R.drawable.number3,
            leftImages = List(2) { R.drawable.carrot },
            rightImages = List(6) { R.drawable.carrot },
            questionText = R.string.question_addition,
            options = listOf(8, 6, 4, 3),
            correctAnswer = 8
        ),
        QuizItem(
            numberImage = R.drawable.number4,
            leftImages = List(5) { R.drawable.watermelon },
            rightImages = List(4) { R.drawable.watermelon },
            questionText = R.string.question_addition,
            options = listOf(3, 9, 4, 8),
            correctAnswer = 9
        ),
        QuizItem(
            numberImage = R.drawable.number5,
            leftImages = List(4) { R.drawable.turtle },
            rightImages = List(2) { R.drawable.turtle },
            questionText = R.string.question_addition,
            options = listOf(5, 6, 7, 8),
            correctAnswer = 6
        ),
        QuizItem(
            numberImage = R.drawable.number6,
            leftImages = List(2) { R.drawable.bee },
            rightImages = List(5) { R.drawable.bee },
            questionText = R.string.question_addition,
            options = listOf(8, 7, 5, 6),
            correctAnswer = 7
        ),
        QuizItem(
            numberImage = R.drawable.number7,
            leftImages = List(5) { R.drawable.chick },
            rightImages = List(5) { R.drawable.chick },
            questionText = R.string.question_addition,
            options = listOf(6, 7, 10, 8),
            correctAnswer = 10
        ),
        QuizItem(
            numberImage = R.drawable.number8,
            leftImages = List(2) { R.drawable.jellyfish },
            rightImages = List(2) { R.drawable.jellyfish },
            questionText = R.string.question_addition,
            options = listOf(3, 4, 5, 6),
            correctAnswer = 4
        ),
        QuizItem(
            numberImage = R.drawable.number9,
            leftImages = List(3) { R.drawable.elephant },
            rightImages = List(4) { R.drawable.elephant },
            questionText = R.string.question_addition,
            options = listOf(9, 8, 7, 6),
            correctAnswer = 7
        ),
        QuizItem(
            numberImage = R.drawable.number10,
            leftImages = List(3) { R.drawable.pear },
            rightImages = List(6) { R.drawable.pear },
            questionText = R.string.question_addition,
            options = listOf(5, 4, 9, 8),
            correctAnswer = 9
        )
    )
    QuizScreen(
        quizList = quizList,
        operationType = "addition",
        levelLabel = "Easy",
        navController = navController,
        routeToPop = "addition"
    )
}

@Composable
fun AdditionMediumScreen(navController: NavController) {
    val quizList = listOf(
        QuizItem(
            numberImage = R.drawable.number1,
            leftImages = List(7) { R.drawable.orange },
            rightImages = List(8) { R.drawable.orange },
            questionText = R.string.question_addition,
            options = listOf(15, 14, 16, 13),
            correctAnswer = 15
        ),
        QuizItem(
            numberImage = R.drawable.number2,
            leftImages = List(10) { R.drawable.pear },
            rightImages = List(7) { R.drawable.pear },
            questionText = R.string.question_addition,
            options = listOf(17, 16, 18, 15),
            correctAnswer = 17
        ),
        QuizItem(
            numberImage = R.drawable.number3,
            leftImages = List(9) { R.drawable.elephant },
            rightImages = List(9) { R.drawable.elephant },
            questionText = R.string.question_addition,
            options = listOf(16, 18, 15, 17),
            correctAnswer = 18
        ),
        QuizItem(
            numberImage = R.drawable.number4,
            leftImages = List(9) { R.drawable.strawberry },
            rightImages = List(4) { R.drawable.strawberry },
            questionText = R.string.question_addition,
            options = listOf(12, 13, 14, 15),
            correctAnswer = 13
        ),
        QuizItem(
            numberImage = R.drawable.number5,
            leftImages = List(10) { R.drawable.orange },
            rightImages = List(4) { R.drawable.orange },
            questionText = R.string.question_addition,
            options = listOf(13, 14, 15, 16),
            correctAnswer = 14
        ),
        QuizItem(
            numberImage = R.drawable.number6,
            leftImages = List(6) { R.drawable.paprika },
            rightImages = List(6) { R.drawable.paprika },
            questionText = R.string.question_addition,
            options = listOf(13, 11, 15, 12),
            correctAnswer = 12
        ),
        QuizItem(
            numberImage = R.drawable.number7,
            leftImages = List(11) { R.drawable.chick },
            rightImages = List(4) { R.drawable.chick },
            questionText = R.string.question_addition,
            options = listOf(14, 15, 16, 17),
            correctAnswer = 15
        ),
        QuizItem(
            numberImage = R.drawable.number8,
            leftImages = List(9) { R.drawable.watermelon },
            rightImages = List(7) { R.drawable.watermelon },
            questionText = R.string.question_addition,
            options = listOf(17, 16, 15, 18),
            correctAnswer = 16
        ),
        QuizItem(
            numberImage = R.drawable.number9,
            leftImages = List(7) { R.drawable.turtle },
            rightImages = List(9) { R.drawable.turtle },
            questionText = R.string.question_addition,
            options = listOf(16, 17, 18, 19),
            correctAnswer = 16
        ),
        QuizItem(
            numberImage = R.drawable.number10,
            leftImages = List(10) { R.drawable.jellyfish },
            rightImages = List(9) { R.drawable.jellyfish },
            questionText = R.string.question_addition,
            options = listOf(17, 18, 19, 20),
            correctAnswer = 19
        )
    )
    QuizScreen(
        quizList = quizList,
        operationType = "addition",
        levelLabel = "Medium",
        navController = navController,
        routeToPop = "addition"
    )
}

@Composable
fun AdditionHardScreen(navController: NavController) {
    val quizList = listOf(
        QuizItem(
            numberImage = R.drawable.number1,
            leftImages = List(9) { R.drawable.paprika },
            rightImages = List(9) { R.drawable.paprika },
            questionText = R.string.question_addition,
            options = listOf(18, 20, 21, 19),
            correctAnswer = 18
        ),
        QuizItem(
            numberImage = R.drawable.number2,
            leftImages = List(11) { R.drawable.bee },
            rightImages = List(12) { R.drawable.bee },
            questionText = R.string.question_addition,
            options = listOf(22, 23, 24, 25),
            correctAnswer = 23
        ),
        QuizItem(
            numberImage = R.drawable.number3,
            leftImages = List(10) { R.drawable.elephant },
            rightImages = List(10) { R.drawable.elephant },
            questionText = R.string.question_addition,
            options = listOf(19, 20, 21, 22),
            correctAnswer = 20
        ),
        QuizItem(
            numberImage = R.drawable.number4,
            leftImages = List(14) { R.drawable.orange },
            rightImages = List(10) { R.drawable.orange },
            questionText = R.string.question_addition,
            options = listOf(24, 25, 26, 27),
            correctAnswer = 24
        ),
        QuizItem(
            numberImage = R.drawable.number5,
            leftImages = List(15) { R.drawable.pear },
            rightImages = List(9) { R.drawable.pear },
            questionText = R.string.question_addition,
            options = listOf(24, 25, 26, 28),
            correctAnswer = 24
        ),
        QuizItem(
            numberImage = R.drawable.number6,
            leftImages = List(13) { R.drawable.turtle },
            rightImages = List(11) { R.drawable.turtle },
            questionText = R.string.question_addition,
            options = listOf(22, 23, 24, 25),
            correctAnswer = 24
        ),
        QuizItem(
            numberImage = R.drawable.number7,
            leftImages = List(10) { R.drawable.strawberry },
            rightImages = List(12) { R.drawable.strawberry },
            questionText = R.string.question_addition,
            options = listOf(21, 22, 23, 24),
            correctAnswer = 22
        ),
        QuizItem(
            numberImage = R.drawable.number8,
            leftImages = List(16) { R.drawable.chick },
            rightImages = List(11) { R.drawable.chick },
            questionText = R.string.question_addition,
            options = listOf(26, 27, 28, 29),
            correctAnswer = 27
        ),
        QuizItem(
            numberImage = R.drawable.number9,
            leftImages = List(12) { R.drawable.jellyfish },
            rightImages = List(12) { R.drawable.jellyfish },
            questionText = R.string.question_addition,
            options = listOf(23, 24, 25, 26),
            correctAnswer = 24
        ),
        QuizItem(
            numberImage = R.drawable.number10,
            leftImages = List(15) { R.drawable.watermelon },
            rightImages = List(13) { R.drawable.watermelon },
            questionText = R.string.question_addition,
            options = listOf(28, 29, 30, 31),
            correctAnswer = 28
        )
    )
    QuizScreen(
        quizList = quizList,
        operationType = "addition",
        levelLabel = "Hard",
        navController = navController,
        routeToPop = "addition"
    )
}
