fun main() {
    println("--- part one ---")
    val cat = Cat("Murzik")
    val dog = Dog("Tuzik")
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
}

