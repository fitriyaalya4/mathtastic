package com.mobpro.mathtastic0097.ui.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
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
import androidx.navigation.NavHostController
import com.mobpro.mathtastic0097.R
import kotlin.system.exitProcess

@Composable
fun HomeScreen(navController: NavHostController) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFF9C88F)),
        contentAlignment = Alignment.Center
    ) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Text(
                text = "MATH\nTASTIC",
                style = TextStyle(
                    fontSize = 90.sp,
                    lineHeight = 80.sp,
                    fontWeight = FontWeight.ExtraBold,
                    color = Color(0xFFD83A4E)
                ),
                textAlign = TextAlign.Center
            )

            Spacer(modifier = Modifier.height(40.dp))
            Button(
                onClick = { },
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFE9E3DA)),
                modifier = Modifier
                    .height(60.dp)
                    .width(180.dp),

                shape = RoundedCornerShape(40.dp)
            ) {
                Text(
                    text = stringResource(R.string.quiz),
                    color = Color(0xFFD83A4E),
                    fontSize = 36.sp,
                    fontWeight = FontWeight.Bold
                )
            }

            Spacer(modifier = Modifier.height(20.dp))
            Button(
                onClick = { exitProcess(0) },
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFE9E3DA)),
                modifier = Modifier
                    .height(60.dp)
                    .width(180.dp),
                shape = RoundedCornerShape(30.dp)
            ) {
                Text(
                    text = stringResource(R.string.logout),
                    color = Color(0xFFD83A4E),
                    fontSize = 36.sp,
                    fontWeight = FontWeight.Bold
                )
            }

        }
    }
}
