import java.util.*

/**
 * Кастомная реализация стека.
 * При полном заполнении стек расширяется.
 */
class MyStack<T> {
    private var capacity = 16
    private var array = arrayOfNulls<Any>(capacity)
    private var lastElementIndex = -1

    /**
     * Добавляет элемент в конец стека.
     * Если размер равен capacity,
     * capacity и внутренний массив
     * увеличиваются в 1,5 раза
     */
    fun push(element: T): T {
        if (size() == capacity)
            resize()
        array[++lastElementIndex] = element
        return array[lastElementIndex] as T
    }

    /**
     * Достает и удаляет элемент с конца стека.
     * Если в стеке нет элементов,
     * выбрасывается EmptyStackException
     */
    fun pop(): T {
        if (size() == 0)
            throw EmptyStackException()
        val lastElement = array[lastElementIndex]
        array[lastElementIndex--] = null
        return lastElement as T
    }

    /**
     * Достает элемент с конца стека.
     * Если в стеке нет элементов,
     * выбрасывается EmptyStackException
     */
    fun peek(): T {
        if (size() == 0)
            throw EmptyStackException()
        return array[lastElementIndex] as T
    }

    /**
     * Проверяет, пустой ли стек
     */
    fun empty(): Boolean {
        return size() == 0
    }

    /**
     * Возвращает размер стека.
     */
    fun size() = lastElementIndex + 1

    /**
     * Возвращает вместимость стека.
     */
    fun capacity() = capacity

    /**
     * Возвращает элемент с заданным индексом.
     * Если элемента по этому индексу нет,
     * выбрасывается NoSuchElementException
     */
    operator fun get(index: Int): T {
        if (index > lastElementIndex)
            throw NoSuchElementException()
        return array[index] as T
    }

    /**
     * Увеличиваем capacity в 1,5 раза.
     * Создаем новый массив размером capacity.
     * Копируем старый массив в новый.
     * Ссылаемся с помощью array на новый массив.
     */
    private fun resize() {
        capacity += capacity / 2
        val newArray = arrayOfNulls<Any>(capacity)
        System.arraycopy(array, 0, newArray, 0, lastElementIndex + 1)
        array = newArray
    }
}
