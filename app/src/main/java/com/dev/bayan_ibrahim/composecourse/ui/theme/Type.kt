package com.dev.bayan_ibrahim.composecourse.ui.theme

import androidx.compose.material.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.dev.bayan_ibrahim.composecourse.R

// Set of Material typography styles to start with
val AprilFatFace = FontFamily(
    Font(R.font.aprilfatface_regular)
)
val Montserrat = FontFamily(
    Font(R.font.montserrat_regular),
    Font(R.font.montserrat_bold, weight = FontWeight.Bold)
)
val Typography = Typography(
    body1 = TextStyle(
        fontFamily = Montserrat,
        fontWeight = FontWeight.Normal,
        fontSize = 14.sp,
    ),
    h1 = TextStyle(
        fontFamily = AprilFatFace,
        fontWeight = FontWeight.Normal,
        fontSize = 30.sp,
    ),
    h2 = TextStyle(
        fontFamily = AprilFatFace,
        fontWeight = FontWeight.Bold,
        fontSize = 20.sp,
    ),
    h3 = TextStyle(
        fontFamily = AprilFatFace,
        fontWeight = FontWeight.Bold,
        fontSize = 14.sp,
    ),

    /* Other default text styles to override
    button = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.W500,
        fontSize = 14.sp
    ),
    caption = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 12.sp
    )
    */
)