import org.junit.Test

import org.junit.Assert.*

class MainKtTest {

    @Test
    fun getCommission() {
        var result: Double = 0.0
        result = getCommission("Maestro", 151_123.00, 74_000.0)
        assertEquals(/* expected = */ -2.0, /* actual = */ result, /* delta = */ 0.01)
        result = getCommission("Maestro", 74_000.00, 528_000.0)
        assertEquals(/* expected = */ -3.0, /* actual = */ result, /* delta = */ 0.01)
        result = getCommission("Maestro", 1_000.00, 74_000.0)
        assertEquals(/* expected = */ 0.0, /* actual = */ result, /* delta = */ 0.01)
        result = getCommission("Maestro", 3_000.00, 75_000.0)
        assertEquals(/* expected = */ 38.0, /* actual = */ result, /* delta = */ 0.01)
        result = getCommission("Maestro", 7_000.00, 70_000.0)
        assertEquals(/* expected = */ 32.0, /* actual = */ result, /* delta = */ 0.01)
        result = getCommission("Maestro", 1_000.00, 500_000.0)
        assertEquals(/* expected = */ 26.0, /* actual = */ result, /* delta = */ 0.01)
        result = getCommission("Мир", 60_000.00, 500_000.0)
        assertEquals(/* expected = */ 450.0, /* actual = */ result, /* delta = */ 0.01)
        result = getCommission("Visa", 100.00, 500_000.0)
        assertEquals(/* expected = */ 35.0, /* actual = */ result, /* delta = */ 0.01)
        result = getCommission("VK Pay", 100_000.00, 0.0)
        assertEquals(/* expected = */ -2.0, /* actual = */ result, /* delta = */ 0.01)
        result = getCommission("VK Pay", 10_001.00, 30_000.0)
        assertEquals(/* expected = */ -3.0, /* actual = */ result, /* delta = */ 0.01)
        result = getCommission("VK Pay", 10_001.00, 20_000.0)
        assertEquals(/* expected = */ 0.0, /* actual = */ result, /* delta = */ 0.01)
        result = getCommission("Халва", 10_001.00, 30_000.0)
        assertEquals(/* expected = */ -1.0, /* actual = */ result, /* delta = */ 0.01)
        result = getCommission("Халва", 10_001.00, 30_000.0)
        assertEquals(/* expected = */ 50.0, /* actual = */ result, /* delta = */ 0.01)
    }
}