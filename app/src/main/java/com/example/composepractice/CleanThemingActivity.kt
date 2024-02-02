package com.example.composepractice

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.example.composepractice.model.customTextStyle

class CleanThemingActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

            // Data class name is : Spacing. Please look on to this.

            // Define a data class Spacing and provides compositionLocalOf for Spacing class.
            // Then provides CompositionLocalProvider for Spacing class in Theme.kt file.
            // We can also create Material Theme extension function for Spacing class as implemented in spacing class.

//            MaterialTheme.spacing.Small

            Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                Text(text = "Usman", style = MaterialTheme.customTextStyle.extraLargeTextStyle)
            }
        }
    }
}