package com.jetbrains.converters.big.`package`.name.created.solely.`for`.testing.purposes

/**
 * A simple object that converters F to C.
 * Package name, along with the structure of the project, is highly simple and used only for testing.
 */
object FahrenheitToCelsiusConverter {
    fun convert(fahrenheit: Double): Double {
        return (fahrenheit - 32) * 5 / 9
    }
}
