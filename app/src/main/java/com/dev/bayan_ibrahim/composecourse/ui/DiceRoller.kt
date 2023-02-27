package com.dev.bayan_ibrahim.composecourse.ui

import android.os.Bundle
import android.os.PersistableBundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.dev.bayan_ibrahim.composecourse.R

class DiceRoller: ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
        setContent {
            Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colors.background) {

            }
        }
    }

}

@Composable
fun DiceRollerScreen() {
    DiceRollerButtonAndImage(Modifier.fillMaxSize())
}

@Composable
fun DiceRollerButtonAndImage(modifier: Modifier = Modifier) {
    var diceRollResult by remember {
        mutableStateOf (value = 1)
    }
    Column (
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
    ) {
        val imageResourceId = when (diceRollResult) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }
        Image(
            painter = painterResource(id = imageResourceId),
            contentDescription = diceRollResult.toString()
        )
        Spacer (modifier = Modifier.padding(all = 16.dp))
        Button (onClick = { diceRollResult = (1..6).random() }) {
            Text (text = "Roll", fontSize = 24.sp)
        }
    }
}

@Preview
@Composable
fun DiceRollerPreview() {
    Surface(color = MaterialTheme.colors.background) {
        DiceRollerScreen()
    }
}