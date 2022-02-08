package ru.netology

fun main(){
    val userName = "Dobby"
    val secondsAgo = 2
    val wasHere = agoToText(secondsAgo)
    val message = formattedMessage(userName, wasHere)
    println(message)
}
fun agoToText(time: Int): String{
    val minutes = time/60
    val hours = time/3600
    val minutesSpell = spellMinutes(minutes)
    val hoursSpell = spellHours(hours)

 return  when (time){
       in 0..60 -> "только что"
       in 61..60*59 -> "$minutes $minutesSpell назад"
       in 60 * 60..24 * 60 * 59 -> "$hours $hoursSpell назад"
       in 24 * 60 * 60..48 * 60 * 59 -> "сегодня"
       in 48 * 60 * 60..72 * 60 * 60 -> "вчера"
       else -> "давно"
    }
}

fun spellMinutes(time: Int): String {
    return when {
        time in 2..4 || time % 10 in 2..4 -> "минуты"
        time == 1 || time % 10 == 1 && time != 11 -> "минуту"
        else -> "минут"
    }
}

fun spellHours(time: Int): String {
    return when (time){
        1, 21 -> "час"
        2, 4, 22, 23 -> "часа"
        else -> "часов"
    }
}

fun formattedMessage(userName: String, wasHere: String): String {
    return "$userName был(а) в сети $wasHere"
}

