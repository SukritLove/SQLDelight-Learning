package InputProduct

import ShowProduct.ShowProductScreen
import UIelement.TopBar
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
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
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.unit.dp
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.Navigator
import cafe.adriel.voyager.navigator.currentOrThrow
import data.ProductData
import data.ProductStore

class InputProductScreen : Screen {

    @Composable
    override fun Content() {
        val navigator = LocalNavigator.currentOrThrow

        Scaffold(topBar = {
            TopBar(title = "Add Product", modifier = Modifier.fillMaxWidth())
        }) {
            CreateInputScreen(onShowProdClick = {
                navigator.push(ShowProductScreen())
            })
        }

    }
}

@Composable
private fun CreateInputScreen(onShowProdClick: () -> Unit) {

    var productName by remember { mutableStateOf("") }
    var productInfo by remember { mutableStateOf("") }

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
                onValueChange = { productName = it },
                singleLine = true
            )
        }
        item {
            Spacer(modifierPadding)
            CreateTextField(
                label = "Product Info",
                value = productInfo,
                onValueChange = { productInfo = it },
                singleLine = false
            )
        }
        item {
            Spacer(modifierPadding)
            Button(onClick = onShowProdClick) {
                ProductStore.productData = ProductData(productName, productInfo)
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
    singleLine: Boolean
) {
    TextField(
        label = { Text(label) },
        value = value,
        onValueChange = onValueChange,
        singleLine = singleLine,
    )

}
