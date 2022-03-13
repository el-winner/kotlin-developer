import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import java.util.*

class MyStackTest {

    @Test
    fun `should push the element onto the top`() {
        // given
        val myStack = MyStack<Int>()
        val realStack = Stack<Int>()

        // when
        val actual = myStack.push(5)
        val expected = realStack.push(5)

        // then
        assertEquals(expected, actual)
        assertEquals(realStack.size, myStack.size())
        assertEquals(realStack[0], myStack[0])
    }

    @Test
    fun `should push the element onto the top after resizing inner array`() {
        // given
        val myStack = MyStack<Int>()
        val previousCapacity = myStack.capacity()

        // when
        for (i in 0 until 17)
            myStack.push(5)

        // then
        assertEquals(16, previousCapacity)
        assertEquals(24, myStack.capacity())
        assertEquals(17, myStack.size())
        assertEquals(5, myStack[16])
    }

    @Test
    fun `should pop an element successfully`() {
        // given
        val myStack = MyStack<Int>()
        myStack.push(5)

        // when
        val result = myStack.pop()

        // then
        assertEquals(5, result)
        assertEquals(0, myStack.size())
    }

    @Test
    fun `should throw EmptyStackException at pop() call when stack size is 0`() {
        // given
        val myStack = MyStack<Int>()

        // then
        assertThrows<EmptyStackException> {
            myStack.pop()
        }
    }

    @Test
    fun `should get last element from stack`() {
        // given
        val myStack = MyStack<Int>()
        myStack.push(5)
        myStack.push(3)

        // when
        val result = myStack.peek()

        // then
        assertEquals(3, result)
        assertEquals(3, myStack[1])
        assertEquals(2, myStack.size())
    }

    @Test
    fun `should throw EmptyStackException at peek() call when stack size is 0`() {
        // given
        val myStack = MyStack<Int>()

        // then
        assertThrows<EmptyStackException> {
            myStack.peek()
        }
    }

    @Test
    fun `should return true when stack is empty `() {
        // given
        val myStack = MyStack<Int>()

        // when
        val result = myStack.empty()

        // then
        assertTrue(result)
    }

    @Test
    fun `should return false when stack is not empty `() {
        // given
        val myStack = MyStack<Int>()
        myStack.push(1)

        // when
        val result = myStack.empty()

        // then
        assertFalse(result)
    }
}
