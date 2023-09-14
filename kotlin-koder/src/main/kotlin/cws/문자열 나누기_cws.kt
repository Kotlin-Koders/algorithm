class Solution {
    fun solution(s: String): Int {
        var answer: Int = 0
        var nowChar = '0'
        var nowCharCnt = 0
        var anotherCharCnt = 0
        var map = mutableMapOf<Char, Int>()

        for(c in s) {
            if (nowChar == '0') {
                nowChar = c;
                nowCharCnt += 1
                continue
            }

            if (nowChar == c) {
                nowCharCnt += 1
            } else {
                anotherCharCnt += 1
            }

            if (nowCharCnt == anotherCharCnt) {
                answer += 1
                nowChar = '0'
                nowCharCnt = 0
                anotherCharCnt = 0
            }
        }

        if (nowChar != '0') {
            answer += 1
        }
        return answer
    }
}
