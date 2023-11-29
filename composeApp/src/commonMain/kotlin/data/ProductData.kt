package data

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue

data class ProductData(
    val productName: String,
    val productInfo: String
)

object ProductStore {
    var productData by mutableStateOf(ProductData("", ""))
}
