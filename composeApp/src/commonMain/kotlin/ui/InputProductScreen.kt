package ui

import UIelement.TopBar
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Button
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.key.Key.Companion.K
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import data.ProductData
import data.ProductStore

class InputProductScreen : Screen {

    @Composable
    override fun Content() {
        val navigator = LocalNavigator.currentOrThrow

        var productName by remember { mutableStateOf("") }
        var productPrice by remember { mutableStateOf("") }
        var productInfo by remember { mutableStateOf("") }

        Scaffold(topBar = {
            TopBar(title = "Add Product", modifier = Modifier.fillMaxWidth())
        }) {
            CreateInputScreen(
                productName = productName,
                productPrice = productPrice,
                productInfo = productInfo,
                onProductNameChange = { productName = it },
                onProductPriceChange = {productPrice = it },
                onProductInfoChange = { productInfo = it },
                onShowProdClick = {
                    ProductStore.productData = ProductData(productName, productInfo)
                    navigator.push(ShowProductScreen())
                })
        }

    }
}

@Composable
private fun CreateInputScreen(
    productName: String,
    productPrice: String,
    productInfo: String,
    onProductNameChange: (String) -> Unit,
    onProductPriceChange: (String) -> Unit,
    onProductInfoChange: (String) -> Unit,
    onShowProdClick: () -> Unit
) {
    val modifierPadding = Modifier.padding(20.dp)

    LazyColumn(
        Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        item {
            Spacer(modifierPadding)
            CreateTextField(
                label = "Product Name",
                value = productName,
                onValueChange = onProductNameChange,
                singleLine = true,
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text)
            )
        }
        item {
            Spacer(modifierPadding)
            CreateTextField(
                label = "Product Price",
                value = productPrice,
                onValueChange = onProductPriceChange,
                singleLine = false,
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
            )
        }
        item {
            Spacer(modifierPadding)
            CreateTextField(
                label = "Product Info",
                value = productInfo,
                onValueChange = onProductInfoChange,
                singleLine = false,
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text)
            )
        }
        item {
            Spacer(modifierPadding)
            Button(onClick = onShowProdClick) {
                Text("Add Product")
            }
        }
        item {
            Spacer(modifierPadding)
            Button(onClick = onShowProdClick) {
                Text("Product")
            }
        }

    }
}

@Composable
private fun CreateTextField(
    label: String,
    value: String,
    onValueChange: (String) -> Unit,
    singleLine: Boolean,
    keyboardOptions: KeyboardOptions
) {
    TextField(
        label = { Text(label) },
        value = value,
        onValueChange = onValueChange,
        singleLine = singleLine,
        keyboardOptions = keyboardOptions
    )

}

@Composable
private fun CreateButton(onShowProdClick: () -> Unit) {
    Button(onClick = onShowProdClick) {
        Text("Product")
    }
}
