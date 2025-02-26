package my.destiny.studio.restaurantapp

import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application

fun main() = application {
    Window(
        onCloseRequest = ::exitApplication,
        title = "Kmp-RestaurantApp",
    ) {
        App()
    }
}