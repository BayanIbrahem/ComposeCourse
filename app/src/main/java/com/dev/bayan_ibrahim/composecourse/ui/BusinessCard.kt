package com.dev.bayan_ibrahim.composecourse.ui

import android.graphics.Paint.Align
import android.os.Bundle
import android.os.PersistableBundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.dev.bayan_ibrahim.composecourse.R
import com.dev.bayan_ibrahim.composecourse.ui.theme.ComposeCourseTheme

class BusinessCard: ComponentActivity() {
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
fun PersonInfo(name: String, job: String) {
    Column(
        modifier = Modifier,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        // name:
        Text(
            text = name,
            fontWeight = FontWeight.Light,
            fontSize = 40.sp,
            color = Color.White,
        )
        // job:
        Text(
            text = job,
            fontWeight = FontWeight.Bold,
            fontSize = 24.sp,
            color = Color(0xFF3DDC84)
        )
    }
}

@Composable
fun MainInfoWithLogo(modifier: Modifier) {
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
    ) {
        Image(
            modifier = Modifier.size(100.dp),
            painter = painterResource(id = R.drawable.android_logo),
            contentDescription = "Android Logo",
        )
        PersonInfo(name = "Bayan", job = "Junior Android Dev")
    }
}

@Composable
fun SingleContactInfoWithIcon(icon: Int, value: String) {
    Column {
        Divider(
            color = Color.White,
            thickness = 0.7.dp,
        )
        Row(
            modifier = Modifier
                .padding(bottom = 4.dp, start = 32.dp),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Image(painter = painterResource(id = icon), contentDescription = null)
            Text(
                modifier = Modifier
                    .padding(start = 16.dp),
                color = Color.White,
                text = value,
            )
        }
    }
}

@Composable
fun ContactInfo(modifier: Modifier) {
    Column (
        modifier = modifier,
    ) {
        // phone
        SingleContactInfoWithIcon(icon = R.drawable.phone, value = "+963996415631")
        // tag:
        SingleContactInfoWithIcon(icon = R.drawable.share, value = "@AndroidDev")
        // email:
        SingleContactInfoWithIcon(icon = R.drawable.email, value = "dev.bayan.ibrahim@gmail.com")
    }
}

@Composable
fun BusinessCardScreen () {
    Column (
        modifier = Modifier
            .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ){
        MainInfoWithLogo(Modifier.weight(5f))
        ContactInfo(Modifier.weight(1f))
    }
}
@Preview (showBackground = true)
@Composable
fun BusinessCardPreview() {
    ComposeCourseTheme() {
        Surface(
            color =  Color(0xFF073042),
        ) {
            BusinessCardScreen()
        }
    }
}