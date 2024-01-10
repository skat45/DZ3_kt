package com.dz.timetableview.profilescreen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.dz.timetableview.R


@Composable
fun RenderProfileTitles() {
    Box(
        modifier = Modifier
        .fillMaxWidth(),
        contentAlignment = Alignment.Center
    ) {
        Text(text = "Профиль")
    }
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 5.dp),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = "Иванов Иван Иванович",
            fontWeight = FontWeight.Bold,
            fontSize = 20.sp
        )
    }
    Box(
        modifier = Modifier
            .fillMaxWidth(),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = "ИУ4-33Б",
            fontWeight = FontWeight.Bold
        )
    }
}

@Composable
fun RenderQR() {
    Box(
        modifier = Modifier
            .padding(top = 15.dp)
            .fillMaxWidth()
            .background(
                color = Color.White,
                shape = RoundedCornerShape(dimensionResource(R.dimen.border_radius))
            ),
        contentAlignment = Alignment.Center
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth(0.8f)
                .padding(top = 15.dp, bottom = 15.dp)
        ) {
            Row {
                Image(
                    painter = painterResource(R.drawable.qr),
                    contentDescription = "Edit",
                    modifier = Modifier
                        .size(50.dp)
                )
                Column (
                    modifier = Modifier
                        .padding(start = 10.dp)
                ) {
                    Text(
                        text = "Пропуск",
                        fontWeight = FontWeight.Bold,
                        fontSize = 17.sp
                    )
                    Text(
                        text = "QR БауманID",
                        fontWeight = FontWeight.Bold,
                    )
                }
            }
        }
    }
}


@Composable
fun RenderSignOut() {
    Box(
        modifier = Modifier
            .padding(top = 15.dp)
            .fillMaxWidth()
            .background(
                color = Color.White,
                shape = RoundedCornerShape(dimensionResource(R.dimen.border_radius))
            ),
        contentAlignment = Alignment.Center
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth(0.8f)
                .padding(top = 15.dp, bottom = 15.dp)
        ) {
            Text(
                text = "Выйти из аккаунта",
                fontWeight = FontWeight.Bold,
            )
        }
    }
}



@Composable
fun RenderAboutAppLabel() {
    Box(
        modifier = Modifier
            .padding(top = 15.dp)
            .fillMaxWidth()
            .background(
                color = Color.White,
                shape = RoundedCornerShape(dimensionResource(R.dimen.border_radius))
            ),
        contentAlignment = Alignment.Center
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth(0.8f)
                .padding(top = 15.dp, bottom = 15.dp)
        ) {
            Text(
                text = "О приложении",
                fontWeight = FontWeight.Bold,
            )
        }
    }
}


@Composable
fun RenderProfileScreen() {
    Column (
        modifier = Modifier
            .fillMaxSize()
            .background(colorResource(R.color.main_background))
            .padding(15.dp)
    ) {
        RenderProfileTitles()
        RenderQR()
        RenderSignOut()
        RenderAboutAppLabel()
    }
}

@Composable
@Preview (showBackground = true)
fun DisplayProfileScreen() {
    RenderProfileScreen()
}