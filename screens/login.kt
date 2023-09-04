package com.example.laboratorio6login.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.laboratorio6login.R
import com.example.laboratorio6login.navigation.AppNavigation
import com.example.laboratorio6login.navigation.AppScreens
import com.example.laboratorio6login.ui.theme.Laboratorio6loginTheme


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun login(navController: NavController) {

    var username by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var showError by remember { mutableStateOf(false) }

    Column(

    ) { Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(50.dp), // Ajusta la altura según tus necesidades
        //horizontalArrangement = Arrangement.Center
        horizontalArrangement = Arrangement.End
    ) {
        Text(
            text = "Sign in",
            modifier = Modifier.align(Alignment.CenterVertically),
            style = TextStyle(fontSize = 24.sp, fontWeight = FontWeight.Bold)
        )

        Image(
            painter = painterResource(R.drawable.image_card8),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier

                .height(150.dp)
                .width(150.dp)

        )
    }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(30.dp)
                .height(250.dp),

            ) {

            Image(
                painter = painterResource(R.drawable.image5),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier.fillMaxSize()
            )
        }

            TextField(modifier = Modifier .padding(20.dp).align(Alignment.CenterHorizontally),
                value = username,
                onValueChange = { username = it },
                label = { Text("Usuario") }

            )
            TextField(modifier = Modifier .align(Alignment.CenterHorizontally),
                value = password,
                onValueChange = { password = it },
                label = { Text("Contraseña") },
                visualTransformation = PasswordVisualTransformation()
            )

        Row(
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .width(150.dp)
                .height(100.dp), // Ajusta la altura según tus necesidades

        ) {
            Button(
                onClick = {
                    if (isValidCredentials(username, password)) {
                        navController.navigate(route = AppScreens.Galeria.route)
                    } else {
                        showError = true
                    }
                },
                modifier = Modifier
                    .align(Alignment.CenterVertically)
                    .width(150.dp)
            ) {
                Text("Login", style = TextStyle(fontSize = 16.sp, fontWeight = FontWeight.Bold))
            }
            if (showError) {
                Text(
                    text = "Credenciales incorrectas. Por favor, inténtalo de nuevo.",
                    color = Color.Red
                )
            }
        }

    }
}
fun isValidCredentials(username: String, password: String): Boolean {
    return username == "edwin" && password == "123"}
