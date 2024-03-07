# N으로 표현

```kotlin
import kotlin.math.*

class Solution {
    fun solution(N: Int, number: Int): Int {
        var answer = 0
        var dp = Array(9){mutableSetOf<Int>()}
        
        for (i in 1 .. 8) {
            var defaultNumber = 0
            for (j in 0 until i) {
                defaultNumber += N * 10.0.pow(j).toInt()
            }
            dp[i].add(defaultNumber)
            if (dp[i].contains(number)) {
                return i
            }
            
            for (k in 1 .. i) {
                if (k > i-k) {
                    break
                }
                var li1 = dp[i-k]
                var li2 = dp[k]
                for (a in li1) {
                    for (b in li2) {
                        add(dp, i, a + b)
                        add(dp, i, abs(a - b))
                        add(dp, i, a * b)
                        if (b != 0) {
                            add(dp, i, a / b)
                        }
                    }
                    if (dp[i].contains(number)) {
                        return i
                    }
                }
            }
        }
        return -1
    }
    
    fun add(dp: Array<MutableSet<Int>>, count: Int, number: Int) {
        if (32000 < number || 0 >= number) {
            return
        }
        dp[count].add(number)
    }
}

```