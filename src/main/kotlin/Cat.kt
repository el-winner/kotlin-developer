class Cat(override val name: String) : Pet() {

    private var itemsStolen = 0

    override fun eat() {
        energy += 20
        "is eating...".printAction()
    }

    override fun walk() {
        energy -= 20
        "is walking...".printAction()
    }

    fun purr() {
        energy -= 5
        "is purring...".printAction()
    }

    fun stealFood(fish: Fish) {
        energy += 20
        itemsStolen++
        "omnomnom...".printAction()
    }

    fun stealFood(fish: Fish, cheese: Cheese) {
        energy += 40
        itemsStolen += 2
        "omnomnom...".printAction()
    }
}

class Fish
class Cheese