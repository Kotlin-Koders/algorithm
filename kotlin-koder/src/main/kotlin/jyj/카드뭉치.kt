class Solution {
    fun solution(cards1: Array<String>, cards2: Array<String>, goal: Array<String>): String {
        var cards11 = mutableListOf(*cards1)
        var cards22 = mutableListOf(*cards2)
        for (i in goal){
            if (cards11.isNotEmpty() && cards11[0] == i){
                cards11.removeAt(0)
            }else if (cards22.isNotEmpty() && cards22[0] == i){
                cards22.removeAt(0)
            }else {
                return "No"
            }
        }
        return  "Yes"
    }
}