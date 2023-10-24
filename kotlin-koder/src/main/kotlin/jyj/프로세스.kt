import java.util.*
class Solution {
    fun solution(priorities: IntArray, location: Int): Int {
        val q : Queue<Int> = LinkedList()
        val prioritiesList = priorities.toMutableList()
        val l = priorities.size
        for (i in 0..l-1){
            if( i == location){
                q.add(0)
            } else {
                q.add(1)
            }
        }
        println(q)
        var count = 0
        for (i in 1..l*l){
            val m = prioritiesList.maxOrNull()!!
            if (prioritiesList[0]!! == m){
                count += 1
                if (q.poll() == 0){
                    return count
                }
            }else {
                q.add(q.element())
                prioritiesList.add(prioritiesList[0]!!)
                q.poll()
            }
            prioritiesList.removeAt(0)
        }
        return 0
    }
}
