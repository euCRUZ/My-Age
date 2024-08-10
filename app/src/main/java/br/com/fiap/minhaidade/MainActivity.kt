package br.com.fiap.minhaidade

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.com.fiap.minhaidade.ui.theme.MinhaIdadeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MinhaIdadeTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    CounterScreen()
                }
            }
        }
    }
}

@Composable
    fun CounterScreen() {

        var idade = remember {
            mutableStateOf( 0)
        }

        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = "Qual a sua idade?",
                fontSize = 30.sp,
                color = Color(0xFFAD1F4E),
                fontWeight = FontWeight.Bold
            )
            Text(
                text = "Pressione os botões para informar sua idade.",
                fontSize = 15.sp
            )
            Spacer(modifier = Modifier.height(32.dp))
            Text(
                text = "${idade.value}",
                fontSize = 60.sp,
                fontWeight = FontWeight.Bold
            )
            Spacer(modifier = Modifier.height(32.dp))
            Row {
                Button(
                    onClick = { if ( idade.value > 0 ) idade.value-- },
                    modifier = Modifier.size(84.dp),
                    shape = RoundedCornerShape(8.dp),
                    colors = ButtonDefaults.buttonColors(Color(0xFFAD1F4E))
                ) {
                    Text(text = "-", fontSize = 40.sp)
                }
                Spacer(modifier = Modifier.width(32.dp))
                Button(
                    onClick = { if ( idade.value < 130 ) idade.value++ },
                    modifier = Modifier.size(84.dp),
                    shape = RoundedCornerShape(8.dp),
                    colors = ButtonDefaults.buttonColors(Color(0xFFAD1F4E))
                ) {
                    Text(text = "+", fontSize = 40.sp)
                }
            }
            Spacer(modifier = Modifier.height(75.dp))
            Text(
                text = "Você é ${if (idade.value < 18) "MENOR de idade!" else "MAIOR de idade!"}",
                fontSize = 30.sp,
                color = Color(0xFFAD1F4E),
                fontWeight = FontWeight.Bold
            )
        }
    }

@Preview(showBackground = true, showSystemUi = true)
@Composable
    fun CounterScreenPreview () {
        CounterScreen()
    }