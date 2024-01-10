package com.dz.timetableview.auth

import android.content.Intent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.core.content.ContextCompat.startActivity
import com.dz.timetableview.R
import com.dz.timetableview.TimeTableActivity


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RenderAuthScreen() {
    val context = LocalContext.current
    var value by remember {
        mutableStateOf("")
    }
    var value2 by remember {
        mutableStateOf("")
    }
    Box (
        modifier = Modifier
            .fillMaxSize()
            .background(colorResource(R.color.main_background)),
        contentAlignment = Alignment.Center
    ) {
        Box(
            modifier = Modifier
                .background(Color.White)
                .fillMaxSize(0.8f)
        ) {
            Column (
                modifier = Modifier
                    .fillMaxSize(),
            ) {
                Box(
                    modifier = Modifier.fillMaxWidth(),
                    contentAlignment = Alignment.TopCenter
                ) {
                    Image(
                        painter = painterResource(id =
                        R.drawable.bmstulogo),
                        contentDescription = "bmstu_logo",
                        modifier = Modifier
                            .size(250.dp)
                    )
                }
                Box(
                    modifier = Modifier
                        .fillMaxWidth(),
                    contentAlignment = Alignment.TopCenter
                ) {
                    Text(
                        text = "Единая точка входа",
                        fontWeight = FontWeight.Bold,
                        fontSize = 25.sp
                    )
                }
                OutlinedTextField(
                    value = value,
                    label = { Text(text = "Логин") },
                    onValueChange = { newText ->
                        value = newText
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(colorResource(R.color.textfield_background_grey))
                )
                OutlinedTextField(
                    value = value2,
                    label = { Text(text = "Пароль") },
                    onValueChange = { newText ->
                        value2 = newText
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(colorResource(R.color.textfield_background_grey))
                )
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 15.dp)
                ) {
                    Button(
                        onClick = {
                            val intent = Intent(context, TimeTableActivity::class.java)
                            context.startActivity(intent)
                                  },
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(5.dp),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = colorResource(R.color.auth_button_blue),
                            contentColor = Color.White
                        )
                    ) {
                        Text(
                            text = "Войти",
                            fontSize = 20.sp
                            )
                    }
                }
            }
        }
    }
}


@Composable
@Preview (showBackground = true)
fun DisplayAuthScreen() {
    RenderAuthScreen()
}