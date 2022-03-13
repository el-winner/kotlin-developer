/**
 * Кастомная реализация очереди.
 * При полном заполнении очередь не расширяется.
 */
class MyQueue<T> {
    private var capacity = 16
    private var array = arrayOfNulls<Any>(capacity)
    private var lastElementIndex = -1

    /**
     * Добавляет элемент в конец,
     * если есть место.
     * Иначе - выбрасывает исключение
     * IllegalStateException
     */
    fun add(element: T): Boolean {
        if (size() == capacity)
            throw IllegalStateException()
        array[++lastElementIndex] = element
        return true
    }

    /**
     * Добавляет элемент в конец,
     * если есть место.
     */
    fun offer(element: T): Boolean {
        if (size() == capacity)
            return false
        array[++lastElementIndex] = element
        return true
    }

    /**
     * Достает и удаляет первый элемент очереди.
     * Возвращает этот элемент.
     * Если очередь пустая,
     * выбрасывается NoSuchElementException
     */
    fun remove(): T {
        if (size() == 0)
            throw NoSuchElementException()
        val firstElement = array[0]
        moveElements()
        return firstElement as T
    }

    /**
     * Достает и удаляет первый элемент очереди.
     * Возвращает этот элемент.
     * Если очередь пустая,
     * возвращается null.
     */
    fun poll(): T? {
        if (size() == 0)
            return null
        val firstElement = array[0]
        moveElements()
        return firstElement as T
    }

    /**
     * Достает первый элемент очереди.
     * Возвращает этот элемент.
     * Если очередь пустая,
     * выбрасывается NoSuchElementException
     */
    fun element(): T {
        if (size() == 0)
            throw NoSuchElementException()
        return array[0] as T
    }

    /**
     * Достает первый элемент очереди.
     * Возвращает этот элемент.
     * Если очередь пустая,
     * возвращает null.
     */
    fun peek(): T? {
        if (size() == 0)
            return null
        return array[0] as T
    }

    /**
     * Возвращает размер очереди.
     */
    fun size() = lastElementIndex + 1

    private fun moveElements() {
        for (i in 0 until lastElementIndex) {
            array[i] = array[i + 1]
        }
        array[lastElementIndex--] = null
    }
}