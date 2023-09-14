package jhw

class 문자열나누기_jhw {

    fun solution(s: String): Int {
        if (s.length == 1) {
            return 1
        }
        var sameCount = 1
        var diffCount = 0
        var x = s[0] //첫글자
        var startIndex =0
        var endIndex = 0;
        var splitContainer = mutableListOf<String>()
        var isEnd = true
        var notEndIndex = 0;
        for(i in 1 until s.length) {
            if(endIndex == i) {
                isEnd = false
                notEndIndex = i
                continue
            }
            if(x.equals(s[i])) {
                sameCount++
            }else {
                diffCount++
            }
            if(sameCount == diffCount) {
                endIndex = i+1
                if(endIndex == s.length) {
                    splitContainer.add(s.substring(startIndex))
                }else {
                    splitContainer.add(s.substring(startIndex, endIndex))
                    x = s[endIndex]
                }
                isEnd = true
                sameCount = 1
                diffCount = 0
                startIndex = endIndex
            }
        }
        if(!isEnd || sameCount != 1) {
            splitContainer.add(s[notEndIndex].toString())
        }
        return splitContainer.size
    }
}