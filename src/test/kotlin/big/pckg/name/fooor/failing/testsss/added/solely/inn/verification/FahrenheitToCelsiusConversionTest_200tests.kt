package big.pckg.name.fooor.failing.testsss.added.solely.inn.verification

import com.jetbrains.converters.big.pckg.a.really.looong.naaaaame.fooooor.teeeests.FahrenheitToCelsiusConverter
import org.testng.Assert.assertEquals
import org.testng.annotations.DataProvider
import org.testng.annotations.Test

class FahrenheitToCelsiusConversionTest_200tests {
    @Test(dataProvider = "conversionDataFahrenheitToCelsius")
    fun testFahrenheitToCelsiusConversion(fahrenheit: Double, expectedCelsius: Double) {
        val result = FahrenheitToCelsiusConverter.convert(fahrenheit)
        assertEquals(result, expectedCelsius, 0.001, "Conversion from Fahrenheit to Celsius is incorrect")
    }

    @DataProvider(name = "conversionDataFahrenheitToCelsius")
    fun conversionDataFahrenheitToCelsius(): Array<Array<Double>> {
        val testData = mutableListOf<Array<Double>>()

        // Add 200 test cases
        for (i in 0 until 200) {
            val fahrenheit = i * 10.0
            val celsius = (fahrenheit - 32) * 5 / 9
            testData.add(arrayOf(fahrenheit, celsius))
        }
        return testData.toTypedArray()
    }
}
