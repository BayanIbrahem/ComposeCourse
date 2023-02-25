package com.dev.bayan_ibrahim.composecourse.ui

import android.os.Bundle
import android.os.PersistableBundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.dev.bayan_ibrahim.composecourse.R
import com.dev.bayan_ibrahim.composecourse.ui.theme.ComposeCourseTheme

class BirthdayCard: ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
        setContent {
            Surface(
                modifier = Modifier.fillMaxSize(),
                color = MaterialTheme.colors.background,
            ) {

            }
        }
    }
}

@Composable
fun HappyBirthdayCardWithText(name: String, sender: String) {
    Column(
        modifier = Modifier
            .padding(top = 16.dp)
            .fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top,
    ) {
        Text(
            fontSize = 36.sp,
            text = "Happy Birthday $name!",
        )
        Text(
            fontSize = 24.sp,
            text = "- From $sender",
            modifier = Modifier
                .align(Alignment.End)
                .padding(end = 16.dp),
            textAlign = TextAlign.End,
        )
    }

}

@Composable
fun HappyBirthdayCardWithImage(name: String, sender: String) {
    Box {
        val image = painterResource(id = R.drawable.birthday_card)
        Image(
            painter = image,
            contentDescription = "Birthday Image",
            contentScale = ContentScale.Crop,
        )
        HappyBirthdayCardWithText(name = name, sender = sender)
        Text(
            modifier = Modifier
                .align(Alignment.BottomEnd)
                .padding(end = 8.dp, bottom = 8.dp),
            text = "Powered By Android!",
        )
    }
}

@Preview (showBackground = true)
@Composable
fun BirthdayCardPreview () {
    ComposeCourseTheme {
        HappyBirthdayCardWithImage(name = "Sam" , sender = "Sami")
    }
}