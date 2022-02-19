abstract class Pet {
    abstract val name: String
    protected var energy = 100
    abstract fun eat()
    abstract fun walk()
    fun String.printAction() {
        print("$name ")
        println(this)
    }
}