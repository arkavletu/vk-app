package ru.netology

const val MINUTE = 60
const val HOUR = MINUTE * 60
const val DAY = HOUR * 24
const val TWO_DAYS = DAY * 2
const val THREE_DAYS = DAY * 3

fun main() {
    val userName = "Dobby"
    val secondsAgo = MINUTE * 12
    val wasHere = agoToText(secondsAgo)
    println(formattedMessage(userName, wasHere))
}

fun agoToText(time: Int): String {
    return when {
        time >= THREE_DAYS -> "давно"
        time >= TWO_DAYS -> "вчера"
        time >= DAY -> "сегодня"
        time >= HOUR -> "${spell(time, one = "час", two = "часа", other = "часов")} назад"
        time >= MINUTE -> "${spell(time, one = "минуту", two = "минуты", other = "минут")} назад"
        else -> "только что"
    }
}

fun spell(amount: Int, one: String, two: String, other: String): String {
    val timeAgo = convertSeconds(amount)
    val remainder = timeAgo % 10
    return when {
        remainder == 1 && timeAgo != 11 -> "$timeAgo $one"
        remainder in 2..4 && timeAgo != 12 -> "$timeAgo $two"
        else -> "$timeAgo $other"

    }
}

fun convertSeconds(amount: Int): Int{
    return if (amount < HOUR) amount / MINUTE else amount / HOUR
}

fun formattedMessage(userName: String, wasHere: String): String {
    return "$userName был(а) в сети $wasHere"
}

