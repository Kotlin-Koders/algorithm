package cws

class 개인정보_수집_유효기간_cws {

    fun solution(today: String, terms: Array<String>, privacies: Array<String>): IntArray {
        var answer: MutableList<Int> = mutableListOf()
        var termsMap: MutableMap<String, Int> = mutableMapOf()
        for (term in terms) {
            val split = term.split(" ")
            termsMap[split[0]] = split[1].toInt()
        }
        val todayMonthCount = getMonthCount(today, 0)
        for ((index, privacy) in privacies.withIndex()) {
            val split = privacy.split(" ")
            val date = split[0]
            val termValue: Int? = termsMap[split[1]]
            val privacyMonthCount = getMonthCount(date, termValue!!)
            if (todayMonthCount >= privacyMonthCount) {
                answer.add(index + 1)
            }

        }

        return answer.toIntArray()
    }

    fun getMonthCount(date: String, termValue: Int): Double {
        val split = date.split(".")
        val year = split[0].toInt() - 2000
        var month = split[1].toInt()
        val day = split[2].toInt()
        return (year * 12) + month + termValue + (day / 100.0)
    }
}