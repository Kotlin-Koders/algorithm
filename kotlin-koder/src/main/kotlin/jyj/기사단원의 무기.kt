package jyj

import kotlin.math.sqrt

/**
 * packageName    : jyj
 * fileName       : `기사단원의 무기`
 * author         : jang-yeongji
 * date           : 2023/09/19
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2023/09/19        jang-yeongji               최초 생성
 */

class Solution {
    fun solution(number: Int, limit: Int, power: Int): Int {
        var answer: Int = 0
        for (i in 1..number) {
            var count = i.getPowerCount()
            if (count <= limit) {
                answer += count
            } else {
                answer += power
            }
        }
        return answer
    }

    private fun Int.getPowerCount(): Int {
        var result = 0
        var s = sqrt(this.toDouble())
        for (i in 1..s.toInt()) {
            if (this % i == 0) {
                result += 1
                if (this / i != i) {
                    result += 1
                }
            }
        }
        return result
    }
}