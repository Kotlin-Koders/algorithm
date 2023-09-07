package cws

class Solution {
    fun solution(cards1: Array<String>, cards2: Array<String>, goal: Array<String>): String {
        var goalIdx = 0
        var idx1 = 0
        var idx2 = 0
        var goalString: String

        while (goalIdx < goal.size) {
            goalString = goal[goalIdx]
            if (cards1.size > idx1 && cards1[idx1] == goalString) {
                idx1++
            } else if (cards2.size > idx2 && cards2[idx2] == goalString) {
                idx2++
            } else {
                return "No"
            }
            goalIdx++
        }

        return "Yes"
    }
}