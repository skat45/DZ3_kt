package com.dz.timetableview

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.dz.timetableview.mainscreen.RenderMainScreen
import com.dz.timetableview.profilescreen.RenderProfileScreen
import com.dz.timetableview.shadow.shadow
import com.dz.timetableview.subjectsscreen.RenderSubjectsScreen
import com.dz.timetableview.ui.theme.TimeTableViewTheme

class TimeTableActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TimeTableViewTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    RenderApp()
                }
            }
        }
    }
}

data class BottomNavbarItem(
    var icon: Painter,
    val label: String
)


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RenderApp() {
    var thisScreenName by remember {
        mutableStateOf("time_table")
    }

    val bottomItems = listOf<BottomNavbarItem>(
        BottomNavbarItem(
            icon = painterResource(R.drawable.recordboockico),
            label = "Subjects"
        ),
        BottomNavbarItem(
            icon = painterResource(R.drawable.calendar),
            label = "Timetable"
        ),
        BottomNavbarItem(
            icon = painterResource(R.drawable.profileico),
            label = "Profile"
        )
    )
    
    Column {
        Box(
            modifier = Modifier
                .weight(1f)
                .fillMaxWidth()
                .background(colorResource(R.color.main_background))
        ) {
            if (thisScreenName == "time_table") {
                RenderMainScreen()
            }
            if (thisScreenName == "profile") {
                RenderProfileScreen()
            }
            if (thisScreenName == "subjects") {
                RenderSubjectsScreen()
            }
        }
        Box(modifier = Modifier
            .fillMaxWidth()
            .shadow(
                blurRadius = 2.dp,
                color = colorResource(R.color.border_bottom_blue)
            )
            .background(colorResource(R.color.main_background))
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(
                        top = 15.dp,
                        bottom = 15.dp
                    )
            ) {
                Row (
                    modifier = Modifier
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceEvenly,
                ){
                    bottomItems.forEach {
                        Image(
                            painter = it.icon,
                            contentDescription = it.label,
                            modifier = Modifier
                                .clickable {
                                    if (it.label == "Timetable") {
                                        thisScreenName = "time_table"
                                    }
                                    if (it.label == "Profile") {
                                        thisScreenName = "profile"
                                    }
                                    if (it.label == "Subjects") {
                                        thisScreenName = "subjects"
                                    }
                                }
                        )
                    }
                }
            }
        }
    }
}

@Composable
@Preview
fun viewApp() {
    RenderApp()
}
