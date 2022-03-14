interface MyStack<T> {
    fun push(element: T): T
    fun pop(): T
    fun peek(): T
    fun empty(): Boolean
    fun size(): Int
    fun capacity(): Int
    operator fun get(index: Int): T
}