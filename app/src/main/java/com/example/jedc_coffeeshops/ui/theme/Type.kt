package com.example.jedc_coffeeshops.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.jedc_coffeeshops.R

// Set of Material typography styles to start with
val Typography = Typography(
    bodyLarge = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp,
        lineHeight = 24.sp,
        letterSpacing = 0.5.sp
    )
    /* Other default text styles to override
    titleLarge = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 22.sp,
        lineHeight = 28.sp,
        letterSpacing = 0.sp
    ),
    labelSmall = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Medium,
        fontSize = 11.sp,
        lineHeight = 16.sp,
        letterSpacing = 0.5.sp
    )
    */
)

val dandelionFamily = FontFamily(
    Font(R.font.dandelion, FontWeight.Light),
    Font(R.font.dandelion, FontWeight.Normal),
    Font(R.font.dandelion, FontWeight.Normal, FontStyle.Italic),
    Font(R.font.dandelion, FontWeight.Medium),
    Font(R.font.dandelion, FontWeight.Bold)
)

val babyroshanFamily = FontFamily(
    Font(R.font.babyroshandemoregular_e, FontWeight.Light),
    Font(R.font.babyroshandemoregular_e, FontWeight.Normal),
    Font(R.font.babyroshandemoregular_e, FontWeight.Normal, FontStyle.Italic),
    Font(R.font.babyroshandemoregular_e, FontWeight.Medium),
    Font(R.font.babyroshandemoregular_e, FontWeight.Bold)
)
val deckledFamily = FontFamily(
    Font(R.font.deckledregular, FontWeight.Light),
    Font(R.font.deckledregular, FontWeight.Normal),
    Font(R.font.deckledregular, FontWeight.Normal, FontStyle.Italic),
    Font(R.font.deckledregular, FontWeight.Medium),
    Font(R.font.deckledregular, FontWeight.Bold)
)
val midnightOctoberFamily = FontFamily(
    Font(R.font.midnightinoctoberregular, FontWeight.Light),
    Font(R.font.midnightinoctoberregular, FontWeight.Normal),
    Font(R.font.midnightinoctoberregular, FontWeight.Normal, FontStyle.Italic),
    Font(R.font.midnightinoctoberregular, FontWeight.Medium),
    Font(R.font.midnightinoctoberregular, FontWeight.Bold)
)
val nirmanaFamily = FontFamily(
    Font(R.font.nirmanafreepersonalusreg, FontWeight.Light),
    Font(R.font.nirmanafreepersonalusreg, FontWeight.Normal),
    Font(R.font.nirmanafreepersonalusreg, FontWeight.Normal, FontStyle.Italic),
    Font(R.font.nirmanafreepersonalusreg, FontWeight.Medium),
    Font(R.font.nirmanafreepersonalusreg, FontWeight.Bold)
)
val watermelonFamily = FontFamily(
    Font(R.font.watermelonscriptdemo, FontWeight.Light),
    Font(R.font.watermelonscriptdemo, FontWeight.Normal),
    Font(R.font.watermelonscriptdemo, FontWeight.Normal, FontStyle.Italic),
    Font(R.font.watermelonscriptdemo, FontWeight.Medium),
    Font(R.font.watermelonscriptdemo, FontWeight.Bold)
)