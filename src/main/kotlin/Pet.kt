abstract class Pet(
    val name: String,
    initialEnergy: Int) {

    var energy = initialEnergy

    abstract fun eat()

    abstract fun walk()

    protected fun sleep() {
        energy = 100
        println(toStringPretty("is sleeping..."))
    }

    protected fun toStringPretty(action: String): String {
        return "$name $action\n" +
            "energy level is $energy"
    }
}
