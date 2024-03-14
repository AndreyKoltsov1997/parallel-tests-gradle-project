package big.pckg.name.fooor.failing.testsss.added.solely.inn.verification

import com.jetbrains.converters.big.pckg.a.really.looong.naaaaame.fooooor.teeeests.FahrenheitToCelsiusConverter
import org.testng.Assert.assertEquals
import org.testng.annotations.DataProvider
import org.testng.annotations.Test

class FahrenheitToCelsiusConversionTest {
    @Test(dataProvider = "conversionDataFahrenheitToCelsius")
    fun testFahrenheitToCelsiusConversion(fahrenheit: Double, expectedCelsius: Double) {
        val result = FahrenheitToCelsiusConverter.convert(fahrenheit)
        assertEquals(result, expectedCelsius, 0.001, "Conversion from Fahrenheit to Celsius is incorrect")
    }

    @DataProvider(name = "conversionDataFahrenheitToCelsius")
    fun conversionDataFahrenheitToCelsius(): Array<Array<Double>> {
        return arrayOf(
            arrayOf(32.0, 0.0),
            arrayOf(212.0, 100.0),
            arrayOf(-40.0, -40.0),
            arrayOf(98.6, 37.0),
            // will fail
            arrayOf(-1111.0, -1111.0)
        )
    }
}
