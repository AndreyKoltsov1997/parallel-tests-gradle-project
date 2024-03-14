package big.pckg.dependent


import com.jetbrains.converters.big.pckg.a.really.looong.naaaaame.fooooor.teeeests.FahrenheitToCelsiusConverter
import org.testng.Assert.assertEquals
import org.testng.annotations.Test

/**
 * Multiple tests, each depends on the previous.
 */
class DependantTests {

    @Test
    fun testFahrenheitToCelsiusConversion_32F_to_0C() {
        val result = FahrenheitToCelsiusConverter.convert(32.0)
        assertEquals(result, 0.0, 0.001, "Conversion from 32F to 0C is incorrect")
    }

    @Test(dependsOnMethods = ["testFahrenheitToCelsiusConversion_32F_to_0C"])
    fun testFahrenheitToCelsiusConversion_212F_to_100C() {
        val result = FahrenheitToCelsiusConverter.convert(212.0)
        assertEquals(result, 100.0, 0.001, "Conversion from 212F to 100C is incorrect")
    }

    @Test(dependsOnMethods = ["testFahrenheitToCelsiusConversion_212F_to_100C"])
    fun testFahrenheitToCelsiusConversion_negative_40F_to_negative_40C() {
        val result = FahrenheitToCelsiusConverter.convert(-40.0)
        assertEquals(result, -40.0, 0.001, "Conversion from -40F to -40C is incorrect")
    }

    @Test(dependsOnMethods = ["testFahrenheitToCelsiusConversion_negative_40F_to_negative_40C"])
    fun failingTest() {
        val result = FahrenheitToCelsiusConverter.convert(98.6)
        assertEquals(result, -1111111111.0, 0.001, "The test that should fail.")
    }

    @Test(dependsOnMethods = ["failingTest"])
    fun `this is the last test that should not execute at all`() {
        val result = FahrenheitToCelsiusConverter.convert(-1111.0)
        assertEquals(result, -1111.0, 0.001, "Conversion from -1111F to -1111C is incorrect")
    }
}
