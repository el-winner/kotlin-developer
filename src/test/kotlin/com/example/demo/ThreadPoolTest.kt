package com.example.demo

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertDoesNotThrow
import org.junit.jupiter.api.assertThrows

class ThreadPoolTest {

    @Test
    fun `should test ThreadPool`() {
        val pool = ThreadPool(5)

        assertDoesNotThrow {
            for (i in 0 until 11) {
                pool.execute {
                    println("task $i running ...")
                }
            }
            pool.shutdown()
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
