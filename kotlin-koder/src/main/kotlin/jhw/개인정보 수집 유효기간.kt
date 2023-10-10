package jhw

import java.time.LocalDate


class 개인정보수집유효기간_jhw {
    fun solution(today: String, terms: Array<String>, privacies: Array<String>): IntArray {
        var answer: IntArray = intArrayOf()
        for(term in terms) {
            val termSplit = term.split(" ")
            for((idx,privacy) in privacies.withIndex()) {
                val privacySplit = privacy.split(" ")

                if(termSplit[0] == privacySplit[1]) {
                    var privacyDate = privacySplit[0].toLocalDate().plusMonths(termSplit[1].toLong()).minusDays(1)

                    if(privacyDate.dayOfMonth == 30 || privacyDate.dayOfMonth == 31) {
                        privacyDate = LocalDate.of(privacyDate.year, privacyDate.month,28)
                    }
                    if(today.toLocalDate().isAfter(privacyDate)) {
                        answer = answer.plus(idx+1)
                    }
                }
            }
        }
        return answer.sortedArray()
    }
}
fun String.toLocalDate(): LocalDate {
    return LocalDate.of(this.substring(0, 4).toInt(),this.substring(5, 7).toInt(), this.substring(8).toInt())
}

fun main(){
    val results = 개인정보수집유효기간_jhw().solution(
        "2020.01.01",
        arrayOf("Z 3", "D 5"),
        arrayOf("2019.01.01 D", "2019.11.15 Z", "2019.08.02 D", "2019.07.01 D", "2018.12.28 Z")
    )
    for(result in results) {
        println(result)
    }
}