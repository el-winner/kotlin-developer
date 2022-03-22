import java.math.BigDecimal
import java.math.BigDecimal.ROUND_HALF_UP

class CarService {

    /**
     * Метод, который преобразует поля нашего класса
     * в описание на английском,
     * а цену преобразует в валюту,
     * и возвращает новую коллекцию,
     * отсортированную по возрастанию цены.
     */
    fun createDescriptionsInEnglish(list: List<Car>) =
        list.asSequence()
            .map {
                Car(
                    transliterator.convertCyrillicToLatin(it.name),
                    transliterator.convertCyrillicToLatin(it.brand),
                    transliterator.convertCyrillicToLatin(it.typeOfBody),
                    BigDecimal(it.price * DOLLAR_RATE).setScale(2, ROUND_HALF_UP).toDouble(),
                    it.gasMileage
                )
            }.sortedBy { it.price }
            .toList()

    /**
     * Метод, группирующий элементы списка по типу кузова.
     */
    fun groupCarsByTypeOfBody(list: List<Car>) =
        list.asSequence()
            .groupBy { it.typeOfBody }

    /**
     * Метод фильтрует элементы по условию,
     * преобразует лист в список названий
     * и возвращает первые 3 элемента
     */
    fun getFirstThreeFilteredItems(list: List<Car>, predicate: (Car) -> Boolean) =
        list.asSequence()
            .filter(predicate)
            .map { it.name }
            .take(3)
            .toList()

    companion object {
        private val transliterator = Transliterator()
        private const val DOLLAR_RATE = 0.0093
    }
}
