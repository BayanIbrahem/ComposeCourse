package com.dev.bayan_ibrahim.composecourse.ui

import android.icu.text.NumberFormat
import android.os.Build
import android.os.Bundle
import android.os.PersistableBundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.VisibleForTesting
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusDirection
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.dev.bayan_ibrahim.composecourse.R
import com.dev.bayan_ibrahim.composecourse.ui.theme.ComposeCourseTheme
import kotlin.math.roundToInt

class TibCalculator: ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
        setContent {
            Surface (modifier = Modifier.fillMaxSize(), color = MaterialTheme.colors.background) {
                TipCalculatorApp()
            }
        }
    }
}

@Composable
fun TipCalculatorApp() {
    TipCalculatorScreen(Modifier.fillMaxSize())
}
@Composable
private fun TipCalculatorScreen(modifier: Modifier = Modifier) {
    var billAmount by remember { mutableStateOf("100") }
    var tibPercentage by remember { mutableStateOf("15")}
    val focusManager = LocalFocusManager.current
    var roundTib: Boolean by remember { mutableStateOf(false) }
    Column (
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(8.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        TibCalculatorTitle()
        Spacer(modifier = Modifier.padding(16.dp))
        TibCalculatorInputAmount(
            amount = billAmount,
            onAmountChange = {newBillAmount ->
                billAmount = newBillAmount
            },
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Number,
                imeAction = ImeAction.Next,
            ),
            keyboardActions = KeyboardActions (
                onNext = {
                    focusManager.moveFocus(FocusDirection.Down)
                }
            )
        )
        TibCalculatorInputAmount(
            amount = tibPercentage,
            onAmountChange = {newTibPercentage ->
                tibPercentage = newTibPercentage
            },
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Number,
                imeAction = ImeAction.Done,
            ),
            keyboardActions = KeyboardActions (
                onDone = {
                    focusManager.clearFocus()
                }
            )
        )
        TibCalculatorRoundTibRow(
            modifier = Modifier
                .padding(horizontal = 16.dp)
                .fillMaxWidth(),
            text = "Round tib",
            checked = roundTib,
            onCheckedChange = { isSetRounded ->
                roundTib = isSetRounded
            },
        )
        Spacer(modifier = Modifier.padding(16.dp))
        TibCalculatorTotalAmount(amount = billAmount, tibPercentage = tibPercentage, roundTib)
    }
}

@Composable
private fun TibCalculatorTitle() {
    Text(
        text = stringResource(R.string.title),
        fontSize = 24.sp,
        fontWeight = FontWeight.Bold,
    )
}

@Composable
private fun TibCalculatorInputAmount(
    amount: String,
    onAmountChange: (String) -> Unit,
    keyboardOptions: KeyboardOptions,
    keyboardActions: KeyboardActions,
) {
    TextField(
        modifier = Modifier
            .padding(horizontal = 16.dp)
            .fillMaxWidth(),
        value = amount,
        onValueChange = onAmountChange,
        label = { Text(text = stringResource(R.string.bill_amount))},
        keyboardOptions = keyboardOptions,
        keyboardActions = keyboardActions,
        singleLine = true,
    )
}

@Composable
fun TibCalculatorRoundTibRow(
    modifier: Modifier = Modifier,
    text: String,
    checked: Boolean,
    onCheckedChange: (Boolean) -> Unit
) {
    Row (
        modifier = modifier,
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Text(
            text = text,
        )
        Switch(
            checked = checked,
            onCheckedChange = onCheckedChange,
            colors = SwitchDefaults.colors(
                uncheckedThumbColor = Color.Red,
                checkedThumbColor = Color.Green,
            )
        )
    }
}
@Composable
private fun TibCalculatorTotalAmount(amount: String, tibPercentage: String, roundTib: Boolean) {
    val bill = amount.toDoubleOrNull() ?: 0.0
    val tib = tibPercentage.toDoubleOrNull() ?: 15.0
    val totalAmount = calculateTib(bill, tib, roundTib)
    Text(
        text = stringResource(id = R.string.totalAmount, totalAmount),
        fontWeight = FontWeight.Bold,
    )
}

@VisibleForTesting
internal fun calculateTib(bill: Double, tibPercentage: Double, roundTib: Boolean): String {
    val tib = if (roundTib) {
        tibPercentage.roundToInt().toDouble()
    } else {
        tibPercentage
    }
    val totalAmount = bill + bill * tib / 100
    return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
        NumberFormat.getCurrencyInstance()
            .format(totalAmount)
    } else {
        "$totalAmount$"
    }
}


@Preview
@Composable
fun TibCalculatorPreview() {
    ComposeCourseTheme {
        Surface (color = MaterialTheme.colors.background) {
            TipCalculatorApp()
        }
    }
}