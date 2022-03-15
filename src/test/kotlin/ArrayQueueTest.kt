import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class ArrayQueueTest {

    @Test
    fun `should add element to queue and return true`() {
        // given
        val myQueue = ArrayQueue<Int>()

        // when
        val result = myQueue.add(5)

        // then
        assertTrue(result)
        assertEquals(1, myQueue.size())
    }

    @Test
    fun `should throw IllegalStateException at add() because queue is full`() {
        // given
        val myQueue = ArrayQueue<Int>()
        for (i in 0 until 16)
            myQueue.add(5)

        // then
        assertThrows<IllegalStateException> {
            myQueue.add(5)
        }
    }

    @Test
    fun `should insert element to queue and return true`() {
        // given
        val arrayQueue = ArrayQueue<Int>()

        // when
        val result = arrayQueue.offer(5)

        // then
        assertTrue(result)
        assertEquals(1, arrayQueue.size())
    }

    @Test
    fun `should throw IllegalStateException at offer() because queue is full`() {
        // given
        val arrayQueue = ArrayQueue<Int>()
        for (i in 0 until 16)
            arrayQueue.offer(5)

        //when
        val result = arrayQueue.offer(5)

        // then
        assertFalse(result)
        assertEquals(16, arrayQueue.size())
    }

    @Test
    fun `should remove and return element from queue`() {
        // given
        val arrayQueue = ArrayQueue<Int>()
        arrayQueue.offer(5)

        // when
        val result = arrayQueue.remove()

        // then
        assertEquals(5, result)
        assertEquals(0, arrayQueue.size())
    }

    @Test
    fun `should throw NoSuchElementException at remove() because queue is empty`() {
        // given
        val arrayQueue = ArrayQueue<Int>()

        // then
        assertThrows<NoSuchElementException> {
            arrayQueue.remove()
        }
    }

    @Test
    fun `should poll element to queue`() {
        // given
        val arrayQueue = ArrayQueue<Int>()
        arrayQueue.offer(5)

        // when
        val result = arrayQueue.poll()

        // then
        assertEquals(5, result)
        assertEquals(0, arrayQueue.size())
    }

    @Test
    fun `should return null at at poll() because queue is empty`() {
        // given
        val arrayQueue = ArrayQueue<Int>()

        //when
        val result = arrayQueue.poll()

        // then
        assertNull(result)
    }


    @Test
    fun `should get first element`() {
        // given
        val arrayQueue = ArrayQueue<Int>()
        arrayQueue.offer(5)

        // when
        val result = arrayQueue.element()

        // then
        assertEquals(5, result)
        assertEquals(1, arrayQueue.size())
    }

    @Test
    fun `should throw NoSuchElementException at element() because queue is empty`() {
        // given
        val arrayQueue = ArrayQueue<Int>()

        // then
        assertThrows<NoSuchElementException> {
            arrayQueue.element()
        }
    }

    @Test
    fun `should peek first element`() {
        // given
        val arrayQueue = ArrayQueue<Int>()
        arrayQueue.offer(5)

        // when
        val result = arrayQueue.peek()

        // then
        assertEquals(5, result)
        assertEquals(1, arrayQueue.size())
    }

    @Test
    fun `should return null at at peek() because queue is empty`() {
        // given
        val arrayQueue = ArrayQueue<Int>()

        //when
        val result = arrayQueue.peek()

        // then
        assertNull(result)
    }

    @Test
    fun `should create queue with secondary constructor`() {
        // given

        // when
        val arrayQueue = ArrayQueue<Int>(20)

        // then
        assertEquals(20, arrayQueue.capacity())
    }
}