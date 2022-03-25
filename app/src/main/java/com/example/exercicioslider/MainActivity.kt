package com.example.exercicioslider

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.exercicioslider.ui.theme.ExercicioSliderTheme
import androidx.compose.runtime.*
import androidx.compose.ui.text.input.KeyboardType
import androidx.core.text.isDigitsOnly
import com.example.exercicioslider.ui.theme.components.ComponenteValor
import java.text.DecimalFormat

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ExercicioSliderTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    App()
                }
            }
        }
    }
}

@Composable
fun App() {
    var valorState by remember {
        mutableStateOf(0)
    }
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.padding(15.dp)
    ) {
        ComponenteValor(valorState, onValorChange = { valorState = it })
        ShowValor(valorState)
        OutlinedTextField(
            value = valorState.toString(),
            onValueChange = {
                if (it.length == 0) {
                    valorState = 0
                } else {
                    if (it.isDigitsOnly() && it.length > 0) {
                        valorState = it.toInt()
                    }
                }
            },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
        )
    }
}

@Composable
fun ShowValor(valor: Int) {
    //val df = DecimalFormat("0.00")
    Text(text = "${valor}", style = MaterialTheme.typography.subtitle1)
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ExercicioSliderTheme {
        App()
    }
}