package jhw

class 카드뭉치_jhw {
    fun solution(cards1: Array<String>, cards2: Array<String>, goal: Array<String>): String {
        var cards1_index = 0;
        var cards2_index = 0;
        for(element in goal) {
            if(cards1.contains(element)) {
                if(!cards1[cards1_index].equals(element)) {
                    return "NO";
                }
                cards1_index++
            }
            if(cards2.contains(element)) {
                if(!cards2[cards2_index].equals(element)) {
                    return "NO";
                }
                cards2_index++
            }
        }
        return "YES"
    }
}