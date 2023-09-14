package jyj

class 문자열_나누기 {
    fun solution(s: String): Int {
        var temps : String = s
        var answer: Int = 0
        while (temps.isNotBlank()){
            temps = splits(temps)
            answer += 1
        }
        return answer
    }
}

fun splits(s: String): String {
    val target = s[0]
    var sameCount = 0
    var diffCount = 0
    for (i in s.indices) {
        if (s[i] == target) {
            sameCount += 1
        } else {
            diffCount += 1
        }

        if (sameCount == diffCount){
            return s.substring(i)
        }
    }
    return ""
}