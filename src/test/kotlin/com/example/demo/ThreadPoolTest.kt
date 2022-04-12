package com.example.demo

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class ThreadPoolTest {

    @Test
    fun `thread pool should turn array of zeroes into array of ones`() {
        val arraySize = 7
        val array = IntArray(arraySize)
        val pool = ThreadPool(4)

        for (i in 0 until arraySize) {
            pool.execute {
                array[i] = 1
            }
        }
        pool.shutdown()
        for (i in 0 until arraySize) {
            assertEquals(1, array[i])
        }
    }

    @Test
    fun `should throw illegal argument exception when thread number is wrong`() {
        val result = assertThrows<IllegalArgumentException> {
            ThreadPool(10)
        }
        assertEquals("Мин. кол-во потоков - 1, макс. - 5", result.message)
    }
}
