import io.mockk.mockk
import io.mockk.spyk
import io.mockk.verify
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

/**
 * Задания 2-5.
 */
class HumanTest {

    @Test
    fun `при вызове feedPet() у человека кошка должна поесть 1 раз`() {
        // given
        val pet = mockk<Cat>(relaxUnitFun = true)
        val human = Human(pet)

        // when
        human.feedPet()

        // then
        verify(exactly = 1) { pet.eat() }
    }

    @Test
    fun `если после прогулки закончилась энергия, то собака идет спать и ее энергия восстанавливается`() {
        // given
        val pet = spyk(Dog("Vow", 10), recordPrivateCalls = true)
        val human = Human(pet)

        // when
        human.walkWithPet()

        // then
        assertEquals(100, pet.energy)
        verify(exactly = 1) { pet.walk() }
        verify(exactly = 1) { pet["sleep"]() }
    }

    @Test
    fun `если после прогулки остается энергия, то собака не идет спать`() {
        // given
        val pet = spyk(Dog("Vow", 100), recordPrivateCalls = true)
        val human = Human(pet)

        // when
        human.walkWithPet()

        // then
        assertEquals(50, pet.energy)
        verify(exactly = 1) { pet.walk() }
        verify(exactly = 0) { pet["sleep"]() }
    }
}
