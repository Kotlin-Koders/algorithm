package cws

import kotlin.math.ceil

fun String.toMinute(): Int {
    val split = this.split(":")
    return split[0].toInt() * 60 + split[1].toInt()
}

class 주차_요금_계산_cws {
    fun solution(fees: IntArray, records: Array<String>): IntArray {
        val carPark = CarPark(fees)
        for (record in records) {
            val recordItems = record.split(" ")
            if (recordItems[2] == "IN") {
                carPark.enter(recordItems[1], recordItems[0])
            } else {
                carPark.exit(recordItems[1], recordItems[0])
            }
        }
        return carPark.printReceipt()
    }
}


class CarPark(
    val defaultTime: Int,
    val defaultFee: Int,
    val unitMinute: Int,
    val feeByMinute: Int,
    val carToTime: MutableMap<String, String>,
    val carToDuringTime: MutableMap<String, Int>,
) {
    constructor(fees: IntArray): this(fees[0], fees[1], fees[2], fees[3], mutableMapOf(),  mutableMapOf())

    fun enter(car: String, enterTime: String) {
        carToTime[car] = enterTime
    }

    fun exit(car: String, exitTime: String) {
        carToDuringTime[car] = carToDuringTime.getOrDefault(car, 0) + exitTime.toMinute() - carToTime.getOrDefault(car, "00:00").toMinute()
        carToTime.remove(car)
    }

    fun printReceipt(): IntArray {
        for ((car, time) in carToTime) {
            carToDuringTime[car] = carToDuringTime.getOrDefault(car, 0) + "23:59".toMinute() - time.toMinute()
        }
        return carToDuringTime.toSortedMap()
            .map { it -> calculate(it.value) }
            .toIntArray()
    }

    private fun calculate(duringTime: Int): Int {
        var fee: Int = defaultFee
        if (defaultTime >= duringTime) {
            return fee
        }
        fee += (ceil((duringTime - defaultTime) / unitMinute.toDouble()) * feeByMinute).toInt()
        return fee
    }
}
