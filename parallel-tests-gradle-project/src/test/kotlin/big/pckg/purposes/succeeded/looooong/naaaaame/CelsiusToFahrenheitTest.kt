package big.`package`.name.`for`.test.purposes

import com.jetbrains.converters.regular.`package`.name.CelsiusToFahrenheitConverter
import org.testng.Assert.assertEquals
import org.testng.annotations.DataProvider
import org.testng.annotations.Test

class CelsiusToFahrenheitTest {

    @Test(dataProvider = "conversionDataCelsiusToFahrenheit")
    fun testCelsiusToFahrenheitConversion(celsius: Double, expectedFahrenheit: Double) {
        val result = CelsiusToFahrenheitConverter.convert(celsius)
        assertEquals(result, expectedFahrenheit, 0.001, "Conversion from Celsius to Fahrenheit is incorrect")
    }

    @DataProvider(name = "conversionDataCelsiusToFahrenheit")
    fun conversionDataCelsiusToFahrenheit(): Array<Array<Double>> {
        return arrayOf(
            arrayOf(0.0, 32.0),
            arrayOf(100.0, 212.0),
            arrayOf(-40.0, -40.0),
            arrayOf(37.0, 98.6),
            arrayOf(-273.15, -459.67)
        )
    }
}
