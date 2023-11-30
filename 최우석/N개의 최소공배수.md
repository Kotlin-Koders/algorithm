# N개의 최소공배수

## 풀이 과정
1. `최소공배수 = 두 수의 곱 / 최대공약수`
2. 배열의 순서대로 2개의 숫자의 최소공배수를 구한다.
3. 앞서 구한 최소공배수와 다음 순서의 숫자와의 최소공배수를 구한다.
4. 이를 반복하여 실행하여 최종적으로 나온 최소공배수의 값을 응답한다.

> 느낀점
> - 위 수학 공식을 모를 경우 어떤 사고로 풀어야할까?
> - Java7은 병렬 스트림을 지원하지 않는다. 병렬 스트림을 할 경우 같은 인스턴스 변수에 값을 접근하기 때문에 정상적인 값이 응답되지 않을 것 같다.

## 풀이
```java
import java.util.*;

class Solution {
    public int solution(int[] arr) {
        LcmCalculator lcmCalculator = new LcmCalculator(arr[0]);    
        Arrays.stream(arr)
            .forEach(it -> lcmCalculator.calculate(it));
        return lcmCalculator.result();
    }
}

class LcmCalculator {
    
    private int result;
    
    public LcmCalculator(int result) {
        this.result = result;
    }
    
    public void calculate(int num) {
        int maxNum = Math.max(result, num);
        for (int i = maxNum; i > 0; i--) {
            if (result % i == 0 && num % i == 0) {
                this.result = result * num / i;
                return;
            }
        }
    }

    public int result() {
        return result;
    }
}
```