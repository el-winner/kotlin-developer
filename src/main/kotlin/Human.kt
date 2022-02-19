class Human(private val pet: Pet) {
    fun feedPet() {
        pet.eat()
    }

    fun walkWithPet() {
        pet.walk()
    }
}