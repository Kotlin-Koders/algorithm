package cws

class 프로세스_cws {

    fun solution(priorities: IntArray, location: Int): Int {
        var answer = 0
        var nowLocation = location
        var maxValue: Int = priorities.maxOf { it }
        val queue = ArrayDeque(priorities.toList())

        while (!queue.isEmpty()) {
            val nowValue = queue.removeFirst()
            if (nowValue < maxValue) {
                queue.addLast(nowValue)
                if (nowLocation == 0) {
                    nowLocation = queue.size - 1
                } else {
                    nowLocation -= 1
                }
            } else {
                answer += 1
                if (nowLocation == 0) {
                    return answer
                } else {
                    nowLocation -= 1
                    if (!queue.isEmpty()) {
                        maxValue = queue.maxOf { it }
                    }
                }

            }

        }
        return answer
    }
}