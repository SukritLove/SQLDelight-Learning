package ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import data.Product
import data.ProductStore

@Composable
fun ProductListItem(product: Product) {
    Row(
        Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center
    )
    {
        CreateCard(
            modifier = Modifier.background(Color.LightGray).padding(50.dp, 20.dp),
            value = ProductStore.productData.productName
        )
        Spacer(Modifier.padding(5.dp))
        CreateCard(
            modifier = Modifier.background(Color.LightGray).padding(70.dp, 20.dp),
            value = ProductStore.productData.productInfo
        )
    }
}

@Composable
private fun CreateCard(modifier: Modifier, value: String) {
    Card() {
        Text(
            value, modifier = modifier
        )
    }
}