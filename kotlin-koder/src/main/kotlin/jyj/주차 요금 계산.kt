import kotlin.math.ceil

class Solution {
    fun solution(fees: IntArray, records: Array<String>): IntArray {
        // 결과를 담을 map
        var result = mutableMapOf<String, Int>()
        // 입차 기록을 담을 map
        var marked = mutableMapOf<String, String>()
        
        for(record in records){
            var data = record.split(" ")
            if (data[2] == "IN"){
                marked[data[1]] = data[0]
            }else{
                val outTime = stringTimeToIntTime(data[0])
                val inTime = stringTimeToIntTime(marked.get(data[1])!!)
                val accumulateTime = outTime - inTime 
                result[data[1]] = result.getOrDefault(data[1],0) + accumulateTime
                marked.remove(data[1])
            }
        }
        val lastTime = stringTimeToIntTime("23:59")
        for ((k,v) in marked){
            val inTime = stringTimeToIntTime(v)
            val accumulateTime = lastTime - inTime
            result[k] = result.getOrDefault(k,0) + accumulateTime
        }
         for ((k,v) in result){
           result[k] = calculateFee(v,fees)
        }
        return result.toSortedMap().values.toIntArray()
    }
    
    fun stringTimeToIntTime(str : String) : Int {
        val timeList = str.split(":")
        return timeList[0].toInt() * 60 + timeList[1].toInt()
    }
    
    fun calculateFee(accumulateTime : Int, fees: IntArray) : Int {
        return if (accumulateTime <= fees[0]){
                fees[1] 
            } else{
                fees[1] + ceil((accumulateTime - fees[0]).toDouble() / fees[2].toDouble()).toInt() *  fees[3]
            }
    }
}
