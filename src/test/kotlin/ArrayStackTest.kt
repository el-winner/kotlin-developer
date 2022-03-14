import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import java.util.*

class ArrayStackTest {

    @Test
    fun `should push the element onto the top`() {
        // given
        val arrayStack = ArrayStack<Int>()
        val realStack = Stack<Int>()

        // when
        val actual = arrayStack.push(5)
        val expected = realStack.push(5)

        // then
        assertEquals(expected, actual)
        assertEquals(realStack.size, arrayStack.size())
        assertEquals(realStack[0], arrayStack[0])
    }

    @Test
    fun `should push the element onto the top after resizing inner array`() {
        // given
        val arrayStack = ArrayStack<Int>()
        val previousCapacity = arrayStack.capacity()

        // when
        for (i in 0 until 17)
            arrayStack.push(5)

        // then
        assertEquals(16, previousCapacity)
        assertEquals(24, arrayStack.capacity())
        assertEquals(17, arrayStack.size())
        assertEquals(5, arrayStack[16])
    }

    @Test
    fun `should pop an element successfully`() {
        // given
        val arrayStack = ArrayStack<Int>()
        arrayStack.push(5)

        // when
        val result = arrayStack.pop()

        // then
        assertEquals(5, result)
        assertEquals(0, arrayStack.size())
    }

    @Test
    fun `should throw EmptyStackException at pop() call when stack size is 0`() {
        // given
        val arrayStack = ArrayStack<Int>()

        // then
        assertThrows<EmptyStackException> {
            arrayStack.pop()
        }
    }

    @Test
    fun `should get last element from stack`() {
        // given
        val arrayStack = ArrayStack<Int>()
        arrayStack.push(5)
        arrayStack.push(3)

        // when
        val result = arrayStack.peek()

        // then
        assertEquals(3, result)
        assertEquals(3, arrayStack[1])
        assertEquals(2, arrayStack.size())
    }

    @Test
    fun `should throw EmptyStackException at peek() call when stack size is 0`() {
        // given
        val arrayStack = ArrayStack<Int>()

        // then
        assertThrows<EmptyStackException> {
            arrayStack.peek()
        }
    }

    @Test
    fun `should return true when stack is empty `() {
        // given
        val arrayStack = ArrayStack<Int>()

        // when
        val result = arrayStack.empty()

        // then
        assertTrue(result)
    }

    @Test
    fun `should return false when stack is not empty `() {
        // given
        val arrayStack = ArrayStack<Int>()
        arrayStack.push(1)

        // when
        val result = arrayStack.empty()

        // then
        assertFalse(result)
    }

    @Test
    fun `should create stack with secondary constructor`() {
        // given

        // when
        val arrayQueue = ArrayStack<Int>(20)

        // then
        assertEquals(20, arrayQueue.capacity())
    }
}
