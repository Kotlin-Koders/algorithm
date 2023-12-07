package cws

import java.util.*

class 기능개발_cws {
    fun solution(progresses: IntArray, speeds: IntArray): IntArray {
        val answers = mutableListOf<Int>()

        val progressDays: Deque<Int> = LinkedList()
        for(i in progresses.indices) {
            progressDays.addLast(progressDay(progresses[i], speeds[i]))
        }

        var now = progressDays.removeFirst()
        var count = 1
        while(!progressDays.isEmpty()) {
            val next = progressDays.removeFirst()
            if (now >= next) {
                count += 1
            } else {
                answers.add(count)
                now = next
                count = 1
            }
        }
        answers.add(count)
        return answers.toIntArray()
    }

    private fun progressDay(progress:Int, speed:Int): Int {
        var result:Int = (100 - progress) / speed
        if ((100 - progress) % speed != 0) {
            result += 1
        }
        return result
    }
}