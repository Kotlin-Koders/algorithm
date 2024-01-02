### N개의 최소공배수
- 구현 방식
  - 현재 인덱스와 현재 인덱스 + 1 인덱스의 최소공배수를 구하여 현재 인덱스 + 1에 구한 최소공배수를 삽입합니다.
```java
public int solution(int[] arr) {
    Arrays.sort(arr);
    for(int i = 0; i < arr.length -1 ; i++) {
        arr[i+1] = calc(arr[i], arr[i+1]);
    }
    
    return arr[arr.length-1];
}
    
private int calc(int first, int second) {
    int divideNum = 2;
    int mul = 1;
    if(first == second || first % second == 0) {
        return first;
    }
    if(second % first == 0) {
        return second;
    }
    while(true) {
        if(first < divideNum || second  < divideNum) {
            return first * second * mul;
        }
        if(first % divideNum == 0 && second % divideNum == 0) {
            first /= divideNum;
            second /= divideNum;
            mul *= divideNum;
            divideNum = 2;
        }else {
            divideNum++;
        }
    }
}
```