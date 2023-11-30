package Model

import data.Product

sealed interface ProductListEvent {
    object OnAddNewProductClick : ProductListEvent
    object DismissProduct : ProductListEvent

    data class OnProductNameChange(val value: String):ProductListEvent
    data class OnProductInfoChange(val value: String):ProductListEvent
    object SaveProduct: ProductListEvent

    data class SelectProduct(val product: Product): ProductListEvent
    object DeleteProduct: ProductListEvent
}