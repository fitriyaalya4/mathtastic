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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@Composable
fun OperationScreen(navController: NavController) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFF9C88F))
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
                onClick = { },
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

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 16.dp)
                .align(Alignment.Center),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = "MATH\nTASTIC",
                fontSize = 90.sp,
                lineHeight = 80.sp,
                fontWeight = FontWeight.ExtraBold,
                color = Color(0xFFD83A4E),
                textAlign = TextAlign.Center
            )

            Spacer(modifier = Modifier.height(40.dp))

            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(24.dp)
            ) {
                Row(horizontalArrangement = Arrangement.spacedBy(32.dp)) {
                    CircleButton(symbol = "+") {  }
                    CircleButton(symbol = "-") {  }
                }
                Row(horizontalArrangement = Arrangement.spacedBy(32.dp)) {
                    CircleButton(symbol = "×") {  }
                    CircleButton(symbol = "÷") {  }
                }
            }
        }
    }
}

@Composable
fun CircleButton(symbol: String, onClick: () -> Unit) {
    Button(
        onClick = onClick,
        shape = CircleShape,
        colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFE9E3DA)),
        modifier = Modifier.size(90.dp),
        contentPadding = PaddingValues(0.dp)
    ) {
        Text(
            text = symbol,
            color = Color(0xFFD83A4E),
            fontSize = 60.sp,
            fontWeight = FontWeight.Bold
        )
    }
}
