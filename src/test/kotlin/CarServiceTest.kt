import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class CarServiceTest {

    private lateinit var cars: List<Car>
    private val carService = CarService()

    @BeforeEach
    private fun setUp() {
        cars = listOf(
            Car("машина_5", "бренд_5", "тип_кузова_5", 500.0, 500.0),
            Car("машина_1", "бренд_1", "тип_кузова_1", 100.0, 200.0),
            Car("машина_3", "бренд_3", "тип_кузова_1", 300.0, 200.0),
            Car("машина_2", "бренд_2", "тип_кузова_1", 200.0, 200.0),
            Car("машина_4", "бренд_4", "тип_кузова_5", 400.0, 200.0)
        )
    }

    @Test
    fun `should transliterate description and convert to currency and sort`() {
        // given
        val expected = listOf(
            Car("mashina_1", "brend_1", "tip_kuzova_1", 0.93, 200.0),
            Car("mashina_2", "brend_2", "tip_kuzova_1", 1.86, 200.0),
            Car("mashina_3", "brend_3", "tip_kuzova_1", 2.79, 200.0),
            Car("mashina_4", "brend_4", "tip_kuzova_5", 3.72, 200.0),
            Car("mashina_5", "brend_5", "tip_kuzova_5", 4.65, 500.0),
        )

        // when
        val actual = carService.createDescriptionsInEnglish(cars)

        // then
        assertEquals(expected, actual)
    }

    @Test
    fun `should group cars by type of body`() {
        // given
        val expected = mapOf(
            "тип_кузова_5" to listOf(
                Car("машина_5", "бренд_5", "тип_кузова_5", 500.0, 500.0),
                Car("машина_4", "бренд_4", "тип_кузова_5", 400.0, 200.0)

            ),
            "тип_кузова_1" to listOf(
                Car("машина_1", "бренд_1", "тип_кузова_1", 100.0, 200.0),
                Car("машина_3", "бренд_3", "тип_кузова_1", 300.0, 200.0),
                Car("машина_2", "бренд_2", "тип_кузова_1", 200.0, 200.0)
            )
        )

        // when
        val actual = carService.groupCarsByTypeOfBody(cars)

        // then
        assertEquals(expected, actual)
    }

    @Test
    fun `should filter according to predicate and transform collection and take first 3`() {
        // given
        val expected = listOf(
            "машина_1",
            "машина_3",
            "машина_2"
        )

        // when
        val actual = carService.getFirstThreeFilteredItems(cars) { Car -> Car.gasMileage == 200.0 }

        // then
        assertEquals(expected, actual)
    }
}