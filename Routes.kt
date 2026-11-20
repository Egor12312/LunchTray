package com.example.lunchtray

import androidx.annotation.StringRes

enum class Routes(
    val route: String,
    @StringRes val titleRes: Int
) {
    START("start", R.string.app_name),
    ENTREE("entree", R.string.choose_entree),
    SIDE_DISH("side_dish", R.string.choose_side_dish),
    ACCOMPANIMENT("accompaniment", R.string.choose_accompaniment),
    CHECKOUT("checkout", R.string.order_checkout)
}