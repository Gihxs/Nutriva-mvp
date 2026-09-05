package com.github.gihxs.nutriva_mvp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.github.gihxs.nutriva_mvp.navigation.NutrivaNavGraph
import com.github.gihxs.nutriva_mvp.ui.theme.NutrivamvpTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NutrivamvpTheme {
                NutrivaNavGraph()
            }
        }
    }
}
