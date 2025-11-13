import kotlin.math.PI
import kotlin.math.abs

fun seconds(hours: Int, minutes: Int, seconds: Int): Int {
    require(hours in 0..23) { "неправильное кол-во часов" }
    require(minutes in 0..59) { "неправильное кол-во минут" }
    require(seconds in 0..59) { "неправильное кол-во секунд" }

    return hours * 3600 + minutes * 60 + seconds
}

fun inRad(deg: Int, min: Int, sec: Int): Double {
    require(deg in -360..360) { "Градусы должны быть в диапазоне от -360 до 360" }
    require(min in 0..59) { "Минуты должны быть в диапазоне от 0 до 59" }
    require(sec in 0..59) { "Секунды должны быть в диапазоне от 0 до 59" }

    val decimalDeg: Double = (deg + min / 60 + sec / 3600).toDouble()
    val rad: Double = (decimalDeg * PI / 180)
    return rad
}

fun kDigit(number: Int, k: Int): Int {
    require(number.toString().length > k) { "неправильный номер цифры" }
    val numString: String = abs(number).toString()
    return numString[k - 1].toString().toInt()
}

fun bankPercent(initial: Double, percent: Int, year: Int): Double {
    var deposit: Double = initial
    for (i in 1..year) {
        deposit += (percent / 100.0) * deposit
    }
    return deposit
}

fun numRevert(number: Int): Int {
    val revNumber: String = abs(number).toString().reversed()
    return revNumber.toInt()
}

fun main() {
    println(seconds(5, 20, 56))
    println(inRad(45, 30, 15))
    println(kDigit(-2768439, 3))
    println(bankPercent(1000.0, 20, 5))
    println(numRevert(123456))
}