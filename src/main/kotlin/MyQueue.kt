interface MyQueue<T> {
    fun add(element: T): Boolean
    fun element(): T
    fun remove(): T
    fun peek(): T?
    fun poll(): T?
    fun offer(element: T): Boolean
    fun size(): Int
    fun capacity(): Int
}