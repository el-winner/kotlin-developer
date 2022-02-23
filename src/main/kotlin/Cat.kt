class Cat(name: String, initialEnergy: Int) : Pet(name, initialEnergy) {

    private var itemsStolen = 0

    override fun eat() {
        energy += 20
        println(toStringPretty("is eating..."))
    }

    override fun walk() {
        energy -= 20
        println(toStringPretty("is walking..."))
        if (energy <= 0)
            sleep()
    }

    fun purr() {
        energy -= 5
        println(toStringPretty("is purring..."))
        if (energy <= 0)
            sleep()
    }

    fun stealFood(fish: Fish) {
        energy += 20
        itemsStolen++
        println(toStringPretty("omnomnom...tasty ${fish.name}"))
    }

    fun stealFood(fish: Fish, cheese: Cheese) {
        energy += 40
        itemsStolen += 2
        println(toStringPretty("omnomnomomnomnom...tasty ${fish.name} and ${cheese.name}"))
    }
}

sealed interface Food

class Fish(val name: String) : Food
class Cheese(val name: String) : Food
