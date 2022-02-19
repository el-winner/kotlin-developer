class Dog(override val name: String) : Pet() {

    private var walksWithFamily = 0

    override fun eat() {
        energy += 50
        "is eating...".printAction()
    }

    override fun walk() {
        energy -= 50
        walksWithFamily++
        "is walking".printAction()
    }

    fun shakeTail() {
        energy -= 1
        "is shaking tail".printAction()
    }
}