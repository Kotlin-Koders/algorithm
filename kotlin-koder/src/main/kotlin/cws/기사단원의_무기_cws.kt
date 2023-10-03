package cws

import kotlin.math.min
import kotlin.math.sqrt

class 기사단원의_무기_cws {

    fun solution(number: Int, limit: Int, power: Int): Int {
        var answer = 0
        for (i in 1..number) {
            var attackPoint = getDivisorCount(i)
            if (attackPoint > limit) {
                answer += power
            } else {
                answer += attackPoint
            }
        }
        return answer
    }

    fun getDivisorCount(number: Int): Int {
        var divisorCount = 0

        for (i in 1..sqrt(number.toDouble()).toInt()) {
            if (number % i == 0) {
                divisorCount += 1
                if (number / i != i) {
                    divisorCount += 1
                }
            }
        }
        return divisorCount
    }
}