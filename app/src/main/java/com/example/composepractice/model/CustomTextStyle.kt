package com.example.composepractice.model

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.runtime.compositionLocalOf
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.sp
import com.example.composepractice.R

data class CustomTextStyle(
    val smallTextStyle: TextStyle = TextStyle(fontFamily = FontFamily(Font(R.font.poppin_regular)), fontSize = 12.sp, color = Color.Black),
    val mediumTextStyle: TextStyle = TextStyle(fontFamily = FontFamily(Font(R.font.poppin_regular)), fontSize = 24.sp, color = Color.Green),
    val largeTextStyle: TextStyle = TextStyle(fontFamily = FontFamily(Font(R.font.poppin_regular)), fontSize = 48.sp, color = Color.Red),
    val extraLargeTextStyle: TextStyle = TextStyle(fontFamily = FontFamily(Font(R.font.poppin_regular)), fontSize = 96.sp, color = Color.Blue),
)

val LocalCustomTextStyle = compositionLocalOf { CustomTextStyle() }

val MaterialTheme.customTextStyle: CustomTextStyle
    @Composable
    @ReadOnlyComposable
    get() = LocalCustomTextStyle.current