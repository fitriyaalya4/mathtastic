package com.mobpro.mathtastic0097.ui.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.mobpro.mathtastic0097.R

@Composable
fun MoreMenuScreen(navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFFFCC99))
            .padding(16.dp)
    ) {
        IconButton(onClick = { navController.popBackStack() }) {
            Icon(Icons.AutoMirrored.Filled.ArrowBack, contentDescription = null, tint = Color.Red)

        }

        val menuItems = listOf(
            "HELP" to "help",
            "ABOUT" to "about"
        )

        menuItems.forEach { (title, route) ->
            Button(
                onClick = { navController.navigate(route) },
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFF5F5F5)),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 6.dp)
            ) {
                Text(title, color = Color.Red, fontWeight = FontWeight.Bold)
            }
        }
    }
}

@Composable
fun AboutScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFFFCC99))
            .padding(24.dp)
            .verticalScroll(rememberScrollState())
    ) {
        Text(
            text = stringResource(R.string.about_title),
            fontSize = 28.sp,
            fontWeight = FontWeight.Bold,
            color = Color.Red,
            modifier = Modifier.padding(bottom = 16.dp)
        )

        Card(
            modifier = Modifier.fillMaxWidth(),
            colors = CardDefaults.cardColors(containerColor = Color(0xFFF5F5F5)),
            elevation = CardDefaults.cardElevation(4.dp),
            shape = RoundedCornerShape(16.dp)
        ) {
            Column(modifier = Modifier.padding(16.dp)) {
                AboutItem(
                    stringResource(R.string.about_app_name_title),
                    stringResource(R.string.about_app_name_value)
                )
                AboutItem(
                    stringResource(R.string.about_purpose_title),
                    stringResource(R.string.about_purpose_value)
                )
                AboutItem(
                    stringResource(R.string.about_features_title),
                    stringResource(R.string.about_features_value)
                )
                AboutItem(
                    stringResource(R.string.about_developer_title),
                    stringResource(R.string.about_developer_value)
                )
                AboutItem(
                    stringResource(R.string.about_version_title),
                    stringResource(R.string.about_version_value)
                )
            }
        }
    }
}

@Composable
fun HelpScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFFFCC99))
            .padding(24.dp)
            .verticalScroll(rememberScrollState())
    ) {
        Text(
            text = stringResource(R.string.help_title),
            fontSize = 28.sp,
            fontWeight = FontWeight.Bold,
            color = Color.Red,
            modifier = Modifier.padding(bottom = 16.dp)
        )

        Card(
            modifier = Modifier.fillMaxWidth(),
            colors = CardDefaults.cardColors(containerColor = Color(0xFFF5F5F5)),
            elevation = CardDefaults.cardElevation(4.dp),
            shape = RoundedCornerShape(16.dp)
        ) {
            Column(modifier = Modifier.padding(16.dp)) {
                HelpItem(
                    stringResource(R.string.help_what_is),
                    stringResource(R.string.help_what_is_desc)
                )
                HelpItem(
                    stringResource(R.string.help_how_to_play),
                    stringResource(R.string.help_how_to_play_desc)
                )
                HelpItem(
                    stringResource(R.string.help_menu),
                    stringResource(R.string.help_menu_desc)
                )
                HelpItem(
                    stringResource(R.string.help_tips),
                    stringResource(R.string.help_tips_desc)
                )
            }
        }
    }
}

@Composable
fun AboutItem(title: String, value: String) {
    Column(modifier = Modifier.padding(bottom = 12.dp)) {
        Text(text = title, fontWeight = FontWeight.SemiBold, fontSize = 16.sp, color = Color.Red)
        Spacer(modifier = Modifier.height(4.dp))
        Text(text = value, fontSize = 14.sp, color = Color.DarkGray)
    }
}

@Composable
fun HelpItem(title: String, description: String) {
    Column(modifier = Modifier.padding(bottom = 12.dp)) {
        Text(text = title, fontWeight = FontWeight.SemiBold, fontSize = 16.sp, color = Color.Red)
        Spacer(modifier = Modifier.height(4.dp))
        Text(text = description, fontSize = 14.sp, color = Color.DarkGray)
    }
}
