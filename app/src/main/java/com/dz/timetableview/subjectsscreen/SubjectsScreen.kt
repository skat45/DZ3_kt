package com.dz.timetableview.subjectsscreen

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.dz.timetableview.R


data class Subject(
    val name: String,
    val examType: String,
    val score: Int
)

val mySubjects: List<Subject> = listOf(
    Subject(
        name = "Иностранный язык",
        examType = "Зач",
        score = 66
    ),
    Subject(
        name = "Материаловедение и материалы электронных средств",
        examType = "рЭкз",
        score = 68
    ),
    Subject(
        name = "Метрология и технологические измерения в производстве электронных средств",
        examType = "Зач",
        score = 60
    ),
    Subject(
        name = "Основы автоматики и систем автоматического управления",
        examType = "Зач",
        score = 81
    ),
    Subject(
        name = "Правоведение",
        examType = "Зач",
        score = 77
    ),
    Subject(
        name = "Теория функция комплексной переменной и операционное исчисление",
        examType = "Экз",
        score = 43
    ),
    Subject(
        name = "Физика",
        examType = "Экз",
        score = 57
    ),
    Subject(
        name = "Физико-химические основы электронных средств",
        examType = "Зач",
        score = 86
    ),
    Subject(
        name = "Элективный курс по физической культуре и спорту",
        examType = "Зач",
        score = 60
    ),
    Subject(
        name = "Электротехника",
        examType = "рЭкз",
        score = 86
    ),
)


@Composable
fun RenderSubjectLabel() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 15.dp),
        contentAlignment = Alignment.Center
    ) {
        Text(text = "Предметы")
    }
}


@Composable
fun RenderCurrentSubject(subject: Subject, counter: Int) {
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
                .padding(10.dp)
        ) {
            Column {
                Text(
                    text = "${counter}. ${subject.name}",
                    fontWeight = FontWeight.Bold,
                )
                Text(text = "${subject.examType}, ${subject.score}/100")
            }
        }
    }
}


@Composable
fun RenderMySubjects() {
    LazyColumn (
        modifier = Modifier
            .padding(top = 15.dp)
            .background(colorResource(R.color.main_background))
            .fillMaxSize()
    ) {
        var counter = 1
        items(mySubjects) {
            RenderCurrentSubject(it, counter)
            counter++
        }
    }
}


@Composable
fun RenderSubjectsScreen() {
    Column {
        RenderSubjectLabel()
        RenderMySubjects()
    }
}


@Preview(showBackground = true)
@Composable
fun ViewSubjectsScreen() {
    RenderSubjectsScreen()
}