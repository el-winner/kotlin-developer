class Dog(name: String, initialEnergy: Int) : Pet(name, initialEnergy) {

    private var walksWithFamily = 0

    override fun eat() {
        energy += 50
        println(toStringPretty("is eating..."))
    }

    override fun walk() {
        energy -= 50
        walksWithFamily++
        println(toStringPretty("is walking..."))
        if (energy <= 0)
            sleep()
    }

    fun shakeTail() {
        energy -= 1
        println(toStringPretty("is shaking tail"))
        if (energy <= 0)
            sleep()
    }
}
