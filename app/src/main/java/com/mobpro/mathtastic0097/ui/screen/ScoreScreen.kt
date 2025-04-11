package com.mobpro.mathtastic0097.ui.screen

import android.content.Intent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.mobpro.mathtastic0097.R

@Composable
fun ScoreScreen(
    navController: NavController,
    trueCount: Int,
    falseCount: Int,
    point: Int,
    quizType: String
) {
    val context = LocalContext.current

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFF9C88F))
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            horizontalArrangement = Arrangement.End
        ) {
            IconButton(
                onClick = { navController.navigate("more") },
                modifier = Modifier
                    .size(48.dp)
                    .background(Color(0xFFE9E3DA), shape = RoundedCornerShape(50))
            ) {
                Icon(Icons.Default.MoreVert, contentDescription = "More", tint = Color(0xFFD83A4E))
            }
        }

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 24.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = stringResource(id = R.string.score),
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                color = Color(0xFFD83A4E),
                modifier = Modifier
                    .background(Color(0xFFE9E3DA), shape = RoundedCornerShape(20.dp))
                    .padding(horizontal = 32.dp, vertical = 12.dp)
            )

            Spacer(modifier = Modifier.height(24.dp))

            Column(
                modifier = Modifier
                    .background(Color(0xFFD83A4E), shape = RoundedCornerShape(20.dp))
                    .padding(horizontal = 36.dp, vertical = 20.dp),
                horizontalAlignment = Alignment.Start
            ) {
                ScoreItem(label = stringResource(id = R.string.true_label), value = trueCount)
                ScoreItem(label = stringResource(id = R.string.false_label), value = falseCount)
                ScoreItem(label = stringResource(id = R.string.point_label), value = point)
            }

            Spacer(modifier = Modifier.height(24.dp))

            Button(
                onClick = {
                    val shareMessage = context.getString(
                        R.string.share_quiz_result,
                        quizType,
                        trueCount,
                        falseCount,
                        point
                    )

                    val sendIntent = Intent().apply {
                        action = Intent.ACTION_SEND
                        putExtra(Intent.EXTRA_TEXT, shareMessage)
                        type = "text/plain"
                    }

                    val shareIntent = Intent.createChooser(sendIntent, context.getString(R.string.share_via))
                    context.startActivity(shareIntent)
                },
                shape = RoundedCornerShape(20.dp),
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFE9E3DA))
            ) {
                Text(
                    text = stringResource(id = R.string.share),
                    color = Color(0xFFD83A4E),
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold
                )
            }

            Spacer(modifier = Modifier.height(16.dp))

            Button(
                onClick = {
                    when (quizType) {
                        "addition" -> navController.navigate("addition")
                        "subtraction" -> navController.navigate("subtraction")
                        "division" -> navController.navigate("division")
                        "multiplication" -> navController.navigate("multiplication")
                        else -> navController.navigate("home")
                    }
                },
                shape = RoundedCornerShape(20.dp),
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFE9E3DA))
            ) {
                Text(
                    text = stringResource(id = R.string.next),
                    color = Color(0xFFD83A4E),
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold
                )
            }
        }
    }
}

@Composable
fun ScoreItem(label: String, value: Int) {
    Row(
        modifier = Modifier.padding(vertical = 4.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            text = "$label :",
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold,
            color = Color.White,
            modifier = Modifier.width(100.dp)
        )
        Text(
            text = value.toString(),
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold,
            color = Color.White
        )
    }
}
