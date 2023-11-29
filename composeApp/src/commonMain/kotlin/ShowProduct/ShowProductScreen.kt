package ShowProduct

import InputProduct.InputProductScreen
import UIelement.TopBar
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Button
import androidx.compose.material.Card
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import data.ProductStore

class ShowProductScreen : Screen {
    @Composable
    override fun Content() {
        val navigator = LocalNavigator.currentOrThrow

        Scaffold(topBar = {
            TopBar(title = "Home", modifier = Modifier.fillMaxWidth(), onBackClick = {
                navigator.push(InputProductScreen())
            })
        }) {
            CreateProdScreen(onInputProdClick = {
                navigator.push(InputProductScreen())
            })
        }

    }
}

@Composable
private fun CreateProdScreen(onInputProdClick: () -> Unit) {
    val product = ProductStore.productData
    LazyColumn(
        Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        item {
            Row(
                Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center
            ) {
                CreateCard(
                    modifier = Modifier.background(Color.LightGray).padding(50.dp, 20.dp),
                    value = product.productName
                )
                Spacer(Modifier.padding(5.dp))
                CreateCard(
                    modifier = Modifier.background(Color.LightGray).padding(70.dp, 20.dp),
                    value = product.productInfo
                )
            }
        }
        item {
            Spacer(Modifier.padding(20.dp))
            Button(onClick = onInputProdClick) {
                Text("Input")
            }
        }
    }
}

@Composable
fun CreateCard(modifier: Modifier, value: String) {
    Card() {
        Text(
            value, modifier = modifier
        )
    }
}

