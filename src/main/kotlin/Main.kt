fun main() {
    println("--- part one ---")
    val cat = Cat("Murzik", 50)
    val dog = Dog("Tuzik", 100)
    val pets = listOf(cat, dog)
    pets.forEach {
        it.eat()
        it.walk()
    }
    cat.purr()
    dog.shakeTail()

    println("\n\n--- part two ---")
    val ivan = Human(cat)
    ivan.feedPet()
    ivan.walkWithPet()

    val masha = Human(dog)
    masha.feedPet()
    masha.walkWithPet()

    println("\n\n--- experiment with sealed class ---")
    val fish = Fish("okun")
    val cheese = Cheese("rossiysky cheese")
    cat.stealFood(fish)
    cat.stealFood(fish, cheese)
}
