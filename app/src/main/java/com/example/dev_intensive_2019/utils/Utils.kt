package com.example.dev_intensive_2019.utils

import java.util.*

fun parseFullName(fullName : String?) : Pair<String?, String?> {
    val myFullName : String? = fullName?.trimIndent()
    val arr : List<String>? = myFullName?.split(" ")
    return "${if (arr?.getOrNull(0).equals("")) null else arr?.getOrNull(0) }" to
            "${if (arr?.getOrNull(1).equals("")) null else arr?.getOrNull(1) }"
}

fun toInitials(firstName: String?, lastName: String?) : String? {
    val first = firstName?.trimIndent()?.toUpperCase(Locale.ROOT)
    val last = lastName?.trimIndent()?.toUpperCase(Locale.ROOT)
    return if (first == null || first == "") {
        if (last == null || last == "") {
            null
        } else {
            last[0].toString()
        }
    } else {
        if (last == null || last == "") {
            first[0].toString()
        } else {
            "${first[0]}${last[0]}"
        }
    }
}

fun transliteration(payload: String?, divider: String = " ") : String? {
    if (payload == null || payload == "") {
        return payload
    }
    return translitLetter(payload[0], divider) +
            transliteration(payload.substring(1), divider)
}

fun translitLetter(letter: Char, divider: String) : String {
    return when(letter) {
        'а' -> "a"
        'б' -> "b"
        'в' -> "v"
        'г' -> "g"
        'д' -> "d"
        'е' -> "e"
        'ё' -> "e"
        'ж' -> "zh"
        'з' -> "z"
        'и' -> "i"
        'й' -> "i"
        'к' -> "k"
        'л' -> "l"
        'м' -> "m"
        'н' -> "n"
        'о' -> "o"
        'п' -> "p"
        'р' -> "r"
        'с' -> "s"
        'т' -> "t"
        'у' -> "u"
        'ф' -> "f"
        'х' -> "h"
        'ц' -> "c"
        'ч' -> "ch"
        'ш' -> "sh"
        'щ' -> "sh'"
        'ъ' -> ""
        'ы' -> "i"
        'ь' -> ""
        'э' -> "e"
        'ю' -> "yu"
        'я' -> "ya"
        ' ' -> divider
        else -> letter.toString()
    }
}