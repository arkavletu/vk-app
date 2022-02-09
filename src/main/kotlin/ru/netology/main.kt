package ru.netology
const val MINUTE = 60
const val HOUR = MINUTE * 60
const val DAY = HOUR * 24
const val TWO_DAYS = DAY * 2
const val THREE_DAYS = DAY * 3

fun main(){
    val userName = "Dobby"
    val secondsAgo = TWO_DAYS
    val wasHere = agoToText(secondsAgo)
    val message = formattedMessage(userName, wasHere)
    println(message)
}
fun agoToText(time: Int): String{
    val minutes = time/60
    val hours = minutes/60

 return  when (time){
       in 0..60 -> "только что"
       in MINUTE until HOUR -> "$minutes ${spellMinutes(minutes)} назад"
       in HOUR until DAY -> "$hours ${spellHours(hours)} назад"
       in DAY until TWO_DAYS -> "сегодня"
       in TWO_DAYS until THREE_DAYS -> "вчера"
       else -> "давно"
    }
}

fun spellMinutes(time: Int): String {
    return when {
        time in 2..4 || time % 10 in 2..4 -> "минуты"
        time % 10 == 1 && time != 11 -> "минуту"
        else -> "минут"
    }
}

fun spellHours(time: Int): String {
    return when {
        time % 10 == 1 && time != 11 -> "час"
        time in 2..4 || time % 10 in 2..4 -> "часа"
        else -> "часов"
    }
}

fun formattedMessage(userName: String, wasHere: String): String {
    return "$userName был(а) в сети $wasHere"
}

