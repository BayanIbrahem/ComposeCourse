package com.dev.bayan_ibrahim.composecourse.ui

import android.icu.text.NumberFormat
import org.junit.Assert.assertEquals
import org.junit.Test

class CalculateTibsTests {
    @Test
    fun calculate_20_percent_tip_no_roundup() {
        val amount = 10.00
        val tipPercent = 20.00
        val expectedTip = NumberFormat.getCurrencyInstance().format(2)
        val actualTip = calculateTib(bill = amount, tibPercentage = tipPercent, roundTib = false)
        assertEquals(expectedTip, actualTip)
    }
}