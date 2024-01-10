package com.dz.timetableview.mainscreen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.dz.timetableview.R


@Preview (showBackground = true)
@Composable
fun PreviewMainScreen() {
    RenderMainScreen()
}


@Composable
fun RenderMainScreen() {
    Column (
        modifier = Modifier
            .fillMaxWidth()
            .padding(15.dp)
    ) {
        RenderTitleAndStuddingGroup()
        RenderCalendarRowSwitch()
        RenderThisWeek()
        RenderDaysOfWeek()
        RenderTimeTableList()
    }
}


data class Time (
    val hours: String,
    val minutes: String,
)

data class TimeTableItem(
    val timeStart: Time,
    val timeEnd: Time,
    val type: String,
    val location: String,
    val teacher: String? = null,
    val name: String,
    val isActive: Boolean = false,
    val ETA: Time? = null
)

val timeTable = listOf<TimeTableItem>(
    TimeTableItem(
        timeStart = Time("10", "15"),
        timeEnd = Time("11", "50"),
        type = "Семинар",
        location = "каф.ФВ",
        teacher = "Запрыжкина Валерия Петровна",
        name = "Элективный курс по физической культуре и спорту"
    ),
    TimeTableItem(
        timeStart = Time("12", "00"),
        timeEnd = Time("13", "35"),
        type = "Лекция",
        location = "501ю",
        teacher = "Чресзаборногоперебрасов Павел Сергеевич",
        name = "Основы автоматики и систем автоматического управления"
    ),
    TimeTableItem(
        timeStart = Time("13", "50"),
        timeEnd = Time("15", "25"),
        type = "Лекция",
        location = "501ю",
        teacher = "Сыров Анатолий Кириллович",
        name = "Метрология и технические измерения в производстве электронных средств",
        isActive = true,
        ETA = Time("00", "32")
    ),
    TimeTableItem(
        timeStart = Time("15", "40"),
        timeEnd = Time("17", "15"),
        type = "Лабораторная работа",
        location = "216мт",
        name = "Метрология и технические измерения в производстве электронных средств"
    ),
    TimeTableItem(
        timeStart = Time("17", "25"),
        timeEnd = Time("19", "00"),
        type = "Лабораторная работа",
        location = "216мт",
        name = "Метрология и технические измерения в производстве электронных средств"
    )
)

@Composable
fun RenderSubjectInTT(item: TimeTableItem) {
    Column(
        modifier = Modifier
            .border(
                color = colorResource(R.color.day_blue),
                width = 2.dp,
                shape = RoundedCornerShape(dimensionResource(R.dimen.border_radius))
            )
            .background(
                colorResource(R.color.day_blue),
                shape = RoundedCornerShape(dimensionResource(R.dimen.border_radius))
            )
    ) {
        Row (
            modifier = Modifier
                .fillMaxWidth()
                .padding(2.dp),
            horizontalArrangement = Arrangement.SpaceAround,
        ) {
            Text(
                text = "${item.timeStart.hours}:${item.timeStart.minutes}",
                color = Color.White
            )
            Text(
                text = "${item.timeEnd.hours}:${item.timeEnd.minutes}",
                color = Color.White
            )
        }
        Column (
            modifier = Modifier
                .border(
                    color = colorResource(R.color.day_blue),
                    width = 2.dp,
                    shape = RoundedCornerShape(dimensionResource(R.dimen.border_radius))
                )
                .background(
                    color = colorResource(R.color.main_background),
                    shape = RoundedCornerShape(dimensionResource(R.dimen.border_radius))
                )
                .padding(10.dp)
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
            ) {
                Text(text = "${item.type}, ${item.location}")
                if (item.isActive) {
                    Text(
                        text = "Осталось ${item.ETA?.hours}:${item.ETA?.minutes}",
                        color = colorResource(R.color.day_blue),
                        fontWeight = FontWeight.Bold
                    )
                }
            }
            if (item.teacher != null) {
                Text(
                    text = item.teacher,
                    color = colorResource(R.color.teacher_name_blue),
                    textDecoration = TextDecoration.Underline
                )
            }
            else {
                Text(
                    text = "Преподаватель не указан",
                    color = colorResource(R.color.empty_teacher_grey)
                )
            }
            Text(
                text = item.name,
                fontWeight = FontWeight.Bold,
                fontSize = 20.sp
            )
        }
    }
}


@Composable
fun RenderTimeTableList() {
    LazyColumn (
        modifier = Modifier
            .padding(top = 15.dp)
    ) {
        items(timeTable) {
            Box(modifier = Modifier.padding(10.dp)) {
                RenderSubjectInTT(item = it)
            }
        }
    }
}


data class Day (
    val day: Int,
    val dayOfWeek: String,
    val isActive: Boolean = false
)

@Composable
fun RenderDaysOfWeek() {
    val pn = Day(11, "ПН")
    val vt = Day(12, "ВТ", isActive = true)
    val sr = Day(13, "СР")
    val cht = Day(14, "ЧТ")
    val pt = Day(15, "ПТ")
    val sb = Day(16, "СБ")

    val days = listOf<Day>(pn, vt, sr, cht, pt, sb)

    Row (
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 15.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
    ) {
        days.forEach { it ->
            RenderDayOfWeek(it)
        }
    }
}

@Composable
fun RenderDayOfWeek(day: Day) {
    val background: Color
    val textColor: Color
    if (day.isActive) {
        background = colorResource(R.color.day_blue)
        textColor = Color.White
    }
    else {
        background = colorResource(R.color.main_background)
        textColor = Color.Black
    }
    Box(
        modifier = Modifier
            .background(
                background,
                shape = RoundedCornerShape(dimensionResource(R.dimen.border_radius))
            )
    ) {
        Box(
            modifier = Modifier
                .border(
                    color = colorResource(R.color.day_blue),
                    width = 2.dp,
                    shape = RoundedCornerShape(dimensionResource(R.dimen.border_radius))
                )
                .width(50.dp)
                .padding(10.dp),
            contentAlignment = Alignment.Center
        ) {
            Column {
                Text(
                    text = day.day.toString(), color = textColor)
                Text(text = day.dayOfWeek, color = textColor)
            }
        }
    }
}


@Composable
fun RenderThisWeek() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 7.dp),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = "16 неделя, знаменатель",
            fontWeight = FontWeight.Bold,
        )
    }
}



@Composable
fun RenderCalendarRowSwitch() {
    Row(
        modifier = Modifier
            .background(
                colorResource(R.color.switch_blue),
                shape = CircleShape
            )
            .height(dimensionResource(R.dimen.switch_height))
            .fillMaxWidth()
            .padding(2.dp)
    ) {
        Box(
            modifier = Modifier
                .weight(0.666f)
                .background(
                    Color.White,
                    shape = CircleShape
                )
                .fillMaxHeight(),
            contentAlignment = Alignment.Center,
        ) {
            Text(
                text = "Календарь",
                fontWeight = FontWeight.Bold,
            )
        }
        Box(
            modifier = Modifier
                .weight(0.333f)
                .fillMaxHeight(),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = "Сетка",
                color = Color.White,
                fontWeight = FontWeight.Bold,
                )
        }
    }
}


@Composable
fun RenderTitleAndStuddingGroup() {
    Row (
        modifier = Modifier
            .fillMaxWidth()
            .padding(
                bottom = 15.dp
            ),
        horizontalArrangement = Arrangement.spacedBy(
            space = 16.dp,
            alignment = Alignment.Start
        ),
        verticalAlignment = Alignment.Bottom
    ) {
        Text(
            text = "Расписание",
            fontSize = 20.sp,
            fontFamily = FontFamily.SansSerif
        )

        Row (
            horizontalArrangement = Arrangement.spacedBy(
                space = 8.dp,
                alignment = Alignment.Start
            )
        ) {
            Text(
                text = "ИУ4-33Б",
                color = colorResource(R.color.group_and_pencil_blue),
                fontSize = 17.sp
            )
            Image(
                painter = painterResource(id =
                R.drawable.pencil),
                contentDescription = "Edit"
            )
        }
    }
}