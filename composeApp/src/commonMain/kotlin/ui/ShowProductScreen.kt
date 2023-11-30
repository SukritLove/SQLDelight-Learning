package ui

import Model.ProductListEvent
import Model.ProductListState
import ui.InputProductScreen
import UIelement.TopBar
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
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
import data.Product
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
private fun CreateProdScreen(
    onInputProdClick: () -> Unit
) {
    val product = ProductStore.productData
    LazyColumn(
        Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        item { ProductListItem(product = Product(null, "","")) }
        item {
            Spacer(Modifier.padding(20.dp))
            Button(onClick = onInputProdClick) {
                Text("Input")
            }
        }
    }
}


