```java
class Solution {
    public int solution(int[] arr) {
        int answer = 0;
        if (arr.length == 1){
            return arr[0];
        }
        int lcm = arr[0];
        for (int i = 1; i < arr.length; i++){
            lcm = getLeastCommonMultiple(lcm, arr[i]);
        }
        return lcm;
    }

    // 최대 공배수 구하기
    public int getLeastCommonMultiple(int a, int b){
        return (a*b) / getLeastCommonDivisor(a,b);
    }

    // 최소 공약수 구하기
    // 1. 두 정수 a와 b의 최대공약수는 b와 a를 b로 나눈 나머지의 최대공약수와 같다.
    // 2. 이를 반복해서 나머지가 0이 될 때까지 계속한다. 나머지가 0이 되면 그때의 b가 최대공약수가 된다.
    public int getLeastCommonDivisor(int a, int b){
        int r;
        while (b != 0){
            r = a % b;
            a = b;
            b = r;
        }
        return a;
    }
}
```
