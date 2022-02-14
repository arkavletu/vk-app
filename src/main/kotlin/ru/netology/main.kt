package ru.netology
const val MINUTE = 60
const val HOUR = MINUTE * 60
const val DAY = HOUR * 24
const val TWO_DAYS = DAY * 2
const val THREE_DAYS = DAY * 3

fun main(){
    val userName = "Dobby"
    val secondsAgo = HOUR*4
    val wasHere = agoToText(secondsAgo)
    println(formattedMessage(userName, wasHere))
}
fun agoToText(time: Int): String{
 return  when {
     time >= THREE_DAYS -> "давно"
     time >= TWO_DAYS -> "вчера"
     time >= DAY-> "сегодня"
     time >= HOUR -> "${spell(time, one ="час", two = "часа", other = "часов")} назад"
     time >= MINUTE -> "${spell(time, one ="минуту", two = "минуты", other = "минут")} назад"
     else -> "только что"
    }
}

fun spell(amount: Int, one: String, two: String, other: String): String{
    val min = if(amount/MINUTE < 60) amount/MINUTE else amount/HOUR

    return  when {
        min % 10 == 1 && min != 11-> "$min $one"
        min % 10 in 2..4 -> "$min $two"
        else -> "$min $other"

    }
}

fun formattedMessage(userName: String, wasHere: String): String {
    return "$userName был(а) в сети $wasHere"
}

