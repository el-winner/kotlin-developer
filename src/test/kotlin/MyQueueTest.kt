import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class MyQueueTest {

    @Test
    fun `should add element to queue and return true`() {
        // given
        val myQueue = MyQueue<Int>()

        // when
        val result = myQueue.add(5)

        // then
        assertTrue(result)
        assertEquals(1, myQueue.size())
    }

    @Test
    fun `should throw IllegalStateException at add() because queue is full`() {
        // given
        val myQueue = MyQueue<Int>()
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
        val myQueue = MyQueue<Int>()

        // when
        val result = myQueue.offer(5)

        // then
        assertTrue(result)
        assertEquals(1, myQueue.size())
    }

    @Test
    fun `should throw IllegalStateException at offer() because queue is full`() {
        // given
        val myQueue = MyQueue<Int>()
        for (i in 0 until 16)
            myQueue.offer(5)

        //when
        val result = myQueue.offer(5)

        // then
        assertFalse(result)
        assertEquals(16, myQueue.size())
    }

    @Test
    fun `should remove and return element from queue`() {
        // given
        val myQueue = MyQueue<Int>()
        myQueue.add(5)

        // when
        val result = myQueue.remove()

        // then
        assertEquals(5, result)
        assertEquals(0, myQueue.size())
    }

    @Test
    fun `should throw NoSuchElementException at remove() because queue is empty`() {
        // given
        val myQueue = MyQueue<Int>()

        // then
        assertThrows<NoSuchElementException> {
            myQueue.remove()
        }
    }

    @Test
    fun `should poll element to queue`() {
        // given
        val myQueue = MyQueue<Int>()
        myQueue.offer(5)

        // when
        val result = myQueue.poll()

        // then
        assertEquals(5, result)
        assertEquals(0, myQueue.size())
    }

    @Test
    fun `should return null at at poll() because queue is empty`() {
        // given
        val myQueue = MyQueue<Int>()

        //when
        val result = myQueue.poll()

        // then
        assertNull(result)
    }


    @Test
    fun `should get first element`() {
        // given
        val myQueue = MyQueue<Int>()
        myQueue.add(5)

        // when
        val result = myQueue.element()

        // then
        assertEquals(5, result)
        assertEquals(1, myQueue.size())
    }

    @Test
    fun `should throw NoSuchElementException at element() because queue is empty`() {
        // given
        val myQueue = MyQueue<Int>()

        // then
        assertThrows<NoSuchElementException> {
            myQueue.element()
        }
    }

    @Test
    fun `should peek first element`() {
        // given
        val myQueue = MyQueue<Int>()
        myQueue.offer(5)

        // when
        val result = myQueue.peek()

        // then
        assertEquals(5, result)
        assertEquals(1, myQueue.size())
    }

    @Test
    fun `should return null at at peek() because queue is empty`() {
        // given
        val myQueue = MyQueue<Int>()

        //when
        val result = myQueue.peek()

        // then
        assertNull(result)
    }
}