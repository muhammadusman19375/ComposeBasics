package com.example.composepractice

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.composepractice.model.ListItemModel

class MultiSelectLazyColumnActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            var items by remember {
                mutableStateOf((1..20).map {
                    ListItemModel(
                        title = "Option $it", isSelected = false
                    )
                })
            }

            LazyColumn(
                modifier = Modifier.fillMaxSize()
            ) {
                items(items.size) { i ->
                    Row(modifier = Modifier
                        .fillMaxWidth()
                        .clickable {
                            items = items.mapIndexed { index, listItemModel ->
                                if (i == index) {
                                    listItemModel.copy(isSelected = !listItemModel.isSelected)
                                } else listItemModel
                            }
                        }
                        .padding(16.dp), horizontalArrangement = Arrangement.SpaceBetween) {
                        Text(text = items[i].title)
                        if (items[i].isSelected) {
                            Icon(
                                imageVector = Icons.Default.Check,
                                contentDescription = "Selected",
                                tint = Color.Red,
                                modifier = Modifier.size(20.dp)
                            )
                        }
                    }
                }
            }
        }
    }
}