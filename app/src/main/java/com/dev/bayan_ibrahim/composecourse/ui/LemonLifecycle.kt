package com.dev.bayan_ibrahim.composecourse.ui

import android.os.Bundle
import android.os.PersistableBundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.dev.bayan_ibrahim.composecourse.ui.theme.ComposeCourseTheme
import com.dev.bayan_ibrahim.composecourse.R

class LemonLifecycle: ComponentActivity() {
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
fun LemonLifecycleApp() {
    LemonLifecycleImageAndText(modifier = Modifier.fillMaxSize())
}

@Composable
private fun getTextValue(step: Int) = when (step) {
    2 -> stringResource(id = R.string.lemonSqueezeDescription)
    3 -> stringResource(id = R.string.lemonDrinkDescription)
    4 -> stringResource(id = R.string.lemonRestartDescription)
    else -> stringResource(id = R.string.lemonTreeDescription)
}

@Composable
private fun getResourceValue (step: Int) = when (step) {
    2 -> R.drawable.lemon_squeeze
    3 -> R.drawable.lemon_drink
    4 -> R.drawable.lemon_restart
    else -> R.drawable.lemon_tree
}
@Composable
private fun getHintValue (step: Int) = when (step) {
    2 -> stringResource(id = R.string.lemonSqueezeHint)
    3 -> stringResource(id = R.string.lemonDrinkHint)
    4 -> stringResource(id = R.string.lemonRestartHint)
    else -> stringResource(id = R.string.lemonTreeHint)
}

@Composable
fun LemonLifecycleImageAndText(modifier: Modifier = Modifier) {
    var stepIndex by remember { mutableStateOf (1) }
    var remainedSqueezing by remember { mutableStateOf (0) }
//    var maxSqueezingTimes = 2
//    var currentSqueezingIndex = 0
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        val textValue = getTextValue(step = stepIndex)
        val resourceValue = getResourceValue(step = stepIndex)
        Text (
            modifier = Modifier.padding(bottom = 16.dp),
            text = textValue,
            fontSize = 18.sp,
        )
        Image(
            painter = painterResource(id = resourceValue),
            contentDescription = getHintValue(step = stepIndex),
            modifier = Modifier
                .clickable {
                    if (stepIndex == 2 && remainedSqueezing != 1) {
                        remainedSqueezing--
                    } else {
                        stepIndex = stepIndex.mod(4).inc()
                        remainedSqueezing = (3..5).random()
                    }
                }
        )
        if (stepIndex == 2) {
            Text (text = "remained squeezing $remainedSqueezing")
        }
    }
}

@Preview
@Composable
fun LemonLifecyclePreview () {
    ComposeCourseTheme {
        Surface(
            color = MaterialTheme.colors.background
        ) {
            LemonLifecycleApp()
        }
    }

}
