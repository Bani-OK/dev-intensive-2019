package com.example.dev_intensive_2019.extensions

import java.text.SimpleDateFormat
import java.util.*
import kotlin.math.min

const val SECOND = 1000L
const val MINUTE = 60 * SECOND
const val HOUR = 60 * MINUTE
const val DAY = 24 * HOUR

fun Date.format(pattern: String = "HH:mm:ss dd.MM.yy") : String {
    val dateFormat = SimpleDateFormat(pattern, Locale("ru"))
    return dateFormat.format(this)
}

fun Date.add(value: Int, units: TimeUnits = TimeUnits.SECOND) {
    var time = this.time
    time += when (units) {
        TimeUnits.SECOND -> value * SECOND
        TimeUnits.MINUTE -> value * MINUTE
        TimeUnits.HOUR -> value * HOUR
        TimeUnits.DAY -> value * DAY
    }
}

enum class TimeUnits {SECOND, MINUTE, HOUR, DAY}

fun Date.humanizeDiff(date: Date = Date()) : String {
    var diff: Long = Date().time - date.time
    val days: Long = diff / DAY
    diff %= DAY
    val hours: Long = diff / HOUR
    diff %= HOUR
    val minutes: Long = diff / MINUTE
    diff %= MINUTE
    val seconds: Long = diff / SECOND
    if (days > 360) {
        return "более года назад"
    } else if (days > 1 || (days == 1L && hours > 1)) {
        return "${TimeUnits.DAY.plural(days)} назад"
    } else if (days == 1L || hours > 22) {
        return "день назад"
    } else if (hours > 1 || (hours == 1L && minutes > 15)) {
        return "${TimeUnits.HOUR.plural(hours)} назад"
    } else if (hours == 1L || minutes > 45) {
        return "час назад"
    } else if (minutes > 1 || (minutes == 1L && seconds > 15)) {
        return "${TimeUnits.MINUTE.plural(minutes)} назад"
    } else if (minutes == 1L || seconds > 45) {
        return "минуту назад"
    } else if (seconds > 1) {
        return "несколько секунд назад"
    } else {
        return "только что"
    }
}

fun TimeUnits.plural(num: Long) : String {
    return if (num % 10 == 1L && num / 10 % 10 != 1L) {
        when (this) {
            TimeUnits.DAY -> "$num день"
            TimeUnits.HOUR -> "$num час"
            TimeUnits.MINUTE -> "$num минуту"
            TimeUnits.SECOND -> "$num секунду"
        }
    } else if ((num % 10 == 2L || num % 10 ==3L || num % 10 == 4L) && num / 10 % 10 != 1L) {
        when (this) {
            TimeUnits.DAY -> "$num дня"
            TimeUnits.HOUR -> "$num часа"
            TimeUnits.MINUTE -> "$num минуты"
            TimeUnits.SECOND -> "$num секунды"
        }
    } else {
        when (this) {
            TimeUnits.DAY -> "$num дней"
            TimeUnits.HOUR -> "$num часов"
            TimeUnits.MINUTE -> "$num минут"
            TimeUnits.SECOND -> "$num секунд"
        }
    }
}