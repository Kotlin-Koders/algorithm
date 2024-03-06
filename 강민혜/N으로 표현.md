# N으로 표현

## 풀이 시간

1시간 반 동안 고민하다 답을 보았습니다..ㅜ 원리는 이해가 되었는데 코드를 어떻게 구현하는지는 아직 이해를 완벽히 못함

## 풀이

```js
function solution(N, number) {
  const memo = Array.from({ length: 9 }, () => new Set());
  if (N === number) return 1;
  memo.forEach((sets, i) => {
    if (i !== 0) sets.add(Number(String(N).repeat(i)));
  });
  for (let i = 1; i < 9; i++) {
    for (let j = 1; j < i; j++) {
      for (const origin of memo[j]) {
        for (const value of memo[i - j]) {
          memo[i].add(origin + value);
          memo[i].add(origin - value);
          memo[i].add(origin * value);
          memo[i].add(origin / value);
        }
      }
    }
    if (memo[i].has(number)) return i;
  }
  return -1;
}
```
