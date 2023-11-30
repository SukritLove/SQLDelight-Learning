package Model

import data.Product

data class ProductListState(
    val products: List<Product> = emptyList(),
    val selectProduct: Product? = null,
    val isShowProductOpen: Boolean = false,
    val isInputProductOpen: Boolean = false,
    val isProductDetailOpen: Boolean = false,
    val productNameError: String? = null,
    val productInfoError: String? = null,

)
