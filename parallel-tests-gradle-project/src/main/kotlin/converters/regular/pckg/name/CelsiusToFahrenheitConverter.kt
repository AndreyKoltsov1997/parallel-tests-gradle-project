package com.jetbrains.converters.regular.`package`.name

/**
 * A simple object that converters C to F.
 * Package name, along with the structure of the project, is highly simple and used only for testing.
 */
object CelsiusToFahrenheitConverter {
    fun convert(celsius: Double): Double {
        return celsius * 9 / 5 + 32
    }
}
