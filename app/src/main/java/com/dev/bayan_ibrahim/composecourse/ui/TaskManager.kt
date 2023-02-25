package com.dev.bayan_ibrahim.composecourse.ui

import android.os.Bundle
import android.os.PersistableBundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.dev.bayan_ibrahim.composecourse.R

class TaskManager: ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
        setContent {
            Surface(
                modifier = Modifier.fillMaxSize(),
                color = MaterialTheme.colors.background
            ) {

            }
        }
    }
}

@Composable
fun TaskCompletedScreen() {
    Column (
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Image(
            modifier = Modifier.size(200.dp),
            painter = painterResource(id = R.drawable.task_completed),
            contentDescription = "task completed",
            contentScale = ContentScale.Inside,
        )
        Text(
            modifier = Modifier
                .padding(top = 24.dp, bottom = 8.dp),
            text = "All tasks completed.",
            fontWeight = FontWeight.Bold,
            fontSize = 24.sp,
        )
        Text(
            text = "Nice work!",
            fontSize = 16.sp,
        )
    }
}


@Preview (showBackground = true)
@Composable
fun TaskManagerPreview () {
    TaskCompletedScreen()
}