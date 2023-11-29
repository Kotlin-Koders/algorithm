package jhw


class 주차요금계산_jhw {
    fun solution(fees: IntArray, records: Array<String>): IntArray {
        var answer: IntArray = intArrayOf()
        var carFeeInfoTime = mutableMapOf<String, CarInfo>()
        for (record in records) {
            val split = record.split(" ")
            if(!carFeeInfoTime.containsKey(split[1])) {
                carFeeInfoTime.put(split[1], CarInfo(split[1], split[2],chageTime(split[0])))

            }else {
                val carInfo = carFeeInfoTime[split[1]]
                if(carInfo!!.inOrOut == "IN") {
                    carInfo.totalTime -= chageTime(split[0])
                }else {
                    carInfo.totalTime += chageTime(split[0])
                }
                carInfo!!.inOrOut = split[2]
            }
        }
        val toSortedMap = carFeeInfoTime.toSortedMap()
        for(carInfo in toSortedMap.values) {
            if(carInfo.inOrOut == "IN") {
                carInfo.totalTime -= chageTime("23:59")
            }
            carInfo.fee = calcFee(fees = fees, time = -carInfo.totalTime)
            answer = answer.plus(carInfo.fee)
        }
        return answer
    }

    fun chageTime(time: String): Int {
        val timeSplit = time.split(":")
        return timeSplit[0].toInt() * 60 + timeSplit[1].toInt()
    }

    fun calcFee(time: Int, fees: IntArray): Int {
        var calcResult = Math.ceil((time - fees[0]) / fees[2].toDouble()).toInt() * fees[3]
        if(calcResult < 0) {
            calcResult = 0
        }
        return fees[1] + calcResult
    }
}

data class CarInfo(val carNumber: String, var inOrOut: String, var totalTime: Int, var fee: Int = 0)

fun main () {
    val reuslt= 주차요금계산_jhw();
    val records = arrayOf("05:34 5961 IN", "06:00 0000 IN", "06:34 0000 OUT", "07:59 5961 OUT", "07:59 0148 IN", "18:59 0000 IN", "19:09 0148 OUT", "22:59 5961 IN", "23:00 5961 OUT")
    val fees = arrayOf(180, 5000, 10, 600).toIntArray()
    val solution = reuslt.solution(fees, records)
    for (i in solution) {
        print(i)
    }
}