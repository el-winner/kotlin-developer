import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

/**
 * Задание 1.
 */
class CatTest {

    @Test
    fun `если на прогулку достаточно энергии, она должна уменьшиться на 20`() {
        // given
        val cat = Cat("Cheese", 100)

        // when
        cat.walk()

        // then
        assertEquals(80, cat.energy)

    }

    @Test
    fun `если после прогулки недостаточно энергии, она должна увеличиться до 100`() {
        // given
        val cat = Cat("Cheese", 10)

        // when
        cat.walk()

        // then
        assertEquals(100, cat.energy)
    }
}
