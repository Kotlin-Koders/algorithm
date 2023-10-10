class Solution {
    fun solution(today: String, terms: Array<String>, privacies: Array<String>): IntArray {
        var answer = mutableListOf<Int>()
        var map = mutableMapOf<String, Int>()
        var todays = changeDays(today)
        for (term in terms){
            val temp = term.split(" ")
            map[temp[0]] = temp[1].toInt() * 28
        }
        for ((idx, values) in privacies.withIndex()){
            val temp = values.split(" ")
            if (todays - changeDays(temp[0]) - map.getOrDefault(temp[1],0) >= 0){
                answer.add(idx+1)
            }
        }
        return answer.toIntArray()
    }
}

fun changeDays(data: String) : Int {
    val dataList = data.split(".")
    var result = (dataList[0].toInt() - 2000) * 12 * 28
    result += dataList[1].toInt() * 28
    result += dataList[2].toInt()
    return result
}
