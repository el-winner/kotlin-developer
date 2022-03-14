/**
 * Кастомная реализация очереди.
 * При полном заполнении очередь не расширяется.
 */
class ArrayQueue<T>() : MyQueue<T> {
    private var capacity = 16
    private var array = arrayOfNulls<Any>(capacity)
    private var lastElementIndex = -1

    constructor(capacity: Int) : this() {
        this.capacity = capacity
    }

    /**
     * Добавляет элемент в конец, если есть место.
     * @throws IllegalStateException, если очередь заполнена.
     */
    override fun add(element: T): Boolean {
        if (size() == capacity)
            throw IllegalStateException("Невозможно добавить элемент. Очередь заполнена.")
        array[++lastElementIndex] = element
        return true
    }

    /**
     * Добавляет элемент в конец,
     * если есть место.
     */
    override fun offer(element: T): Boolean {
        if (size() == capacity)
            return false
        array[++lastElementIndex] = element
        return true
    }

    /**
     * Достает и удаляет первый элемент очереди.
     * Возвращает этот элемент.
     * @throws NoSuchElementException, если очередь пустая.
     */
    override fun remove(): T {
        if (size() == 0)
            throw NoSuchElementException("Очередь пустая.")
        val firstElement = array[0]
        System.arraycopy(array, 1, array, 0, size() - 1)
        lastElementIndex--
        return firstElement as T
    }

    /**
     * Достает и удаляет первый элемент очереди.
     * Возвращает этот элемент.
     * Если очередь пустая,
     * возвращается null.
     */
    override fun poll(): T? {
        if (size() == 0)
            return null
        val firstElement = array[0]
        System.arraycopy(array, 1, array, 0, size() - 1)
        lastElementIndex--
        return firstElement as T
    }

    /**
     * Достает первый элемент очереди.
     * Возвращает этот элемент.
     * @throws NoSuchElementException, если очередь пустая.
     */
    override fun element(): T {
        if (size() == 0)
            throw NoSuchElementException("Очередь пустая.")
        return array[0] as T
    }

    /**
     * Достает первый элемент очереди.
     * Возвращает этот элемент.
     * Если очередь пустая,
     * возвращает null.
     */
    override fun peek(): T? {
        if (size() == 0)
            return null
        return array[0] as T
    }

    /**
     * Возвращает размер очереди.
     */
    override fun size() = lastElementIndex + 1

    override fun capacity() = capacity
}