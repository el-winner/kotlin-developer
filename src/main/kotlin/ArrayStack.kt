import java.util.*

/**
 * Кастомная реализация стека.
 * При полном заполнении стек расширяется.
 */
class ArrayStack<T>() : MyStack<T> {
    private var capacity = 16
    private var array = arrayOfNulls<Any>(capacity)
    private var lastElementIndex = -1

    constructor(capacity: Int) : this() {
        this.capacity = capacity
        array = arrayOfNulls(capacity)
    }

    /**
     * Добавляет элемент в конец стека.
     * Если размер равен capacity,
     * capacity и внутренний массив
     * увеличиваются в 1,5 раза
     */
    override fun push(element: T): T {
        if (size() == capacity)
            resize()
        array[++lastElementIndex] = element
        return array[lastElementIndex] as T
    }

    /**
     * Достает и удаляет элемент с конца стека.
     * @throws EmptyStackException, если в стеке нет элементов.
     */
    override fun pop(): T {
        if (size() == 0)
            throw EmptyStackException()
        val lastElement = array[lastElementIndex]
        array[lastElementIndex--] = null
        return lastElement as T
    }

    /**
     * Достает элемент с конца стека.
     * @throws EmptyStackException, если в стеке нет элементов.
     */
    override fun peek(): T {
        if (size() == 0)
            throw EmptyStackException()
        return array[lastElementIndex] as T
    }

    /**
     * Проверяет, пустой ли стек
     */
    override fun empty(): Boolean {
        return size() == 0
    }

    /**
     * Возвращает размер стека.
     */
    override fun size() = lastElementIndex + 1

    /**
     * Возвращает вместимость стека.
     */
    override fun capacity() = capacity

    /**
     * Возвращает элемент с заданным индексом.
     * @throws NoSuchElementException, если элемента по этому индексу нет.
     */
    override operator fun get(index: Int): T {
        if (index > lastElementIndex)
            throw NoSuchElementException("Элемента по данному индексу нет.")
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
