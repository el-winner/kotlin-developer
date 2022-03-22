class Transliterator {

    fun convertCyrillicToLatin(str: String): String {
        return str.map {
            if (map.containsKey(it)) {
                map[it]
            } else
                it
        }.joinToString("")
    }

    companion object {
        private val map = mapOf(
            'а' to "a",
            'б' to "b",
            'в' to "v",
            'г' to "g",
            'д' to "d",
            'е' to "e",
            'ё' to "o",
            'ж' to "zh",
            'з' to "z",
            'и' to "i",
            'й' to "y",
            'к' to "k",
            'л' to "l",
            'м' to "m",
            'н' to "n",
            'о' to "o",
            'п' to "p",
            'р' to "r",
            'с' to "s",
            'т' to "t",
            'у' to "u",
            'ф' to "f",
            'х' to "h",
            'ц' to "ts",
            'ч' to "ch",
            'ш' to "sh",
            'щ' to "shch",
            'ъ' to "",
            'ы' to "y",
            'ь' to "",
            'э' to "e",
            'ю' to "yu",
            'я' to "ya",
            'А' to "A",
            'Б' to "B",
            'В' to "V",
            'Г' to "G",
            'Д' to "D",
            'Е' to "YE",
            'Ё' to "YO",
            'Ж' to "ZH",
            'З' to "Z",
            'И' to "I",
            'К' to "K",
            'Л' to "L",
            'М' to "M",
            'Н' to "N",
            'О' to "O",
            'П' to "P",
            'Р' to "R",
            'С' to "S",
            'Т' to "T",
            'У' to "U",
            'Ф' to "F",
            'Х' to "H",
            'Ц' to "TS",
            'Ч' to "CH",
            'Ш' to "SH",
            'Щ' to "SHCH",
            'Ъ' to "",
            'Ы' to "Y",
            'Ь' to "",
            'Э' to "E",
            'Ю' to "YU",
            'Я' to "YA"
        )
    }
}
