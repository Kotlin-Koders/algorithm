```js
const solution = (N, number) => {
  const nCountArr = Array.from(new Array(9), (value, idx) =>
    idx === 0 ? new Set() : new Set([parseInt(`${N}`.repeat(idx))])
  );

  // 사칙연산은 총 4개
  // N은 정해져 있음.
  // 따라서 총 8번 이내에서 모든 것을 처리해야 하므로 count를 기준으로 DP를 진행
  const DP = Array.from({ length: 9 }, (_, index) => {
    if (!index) return new Set([0]);

    let value = 0;
    let n = N;

    for (let i = 1; i <= index; i += 1) {
      value += n;
      n *= 10;
    }

    return new Set().add(value);
  });

  // 1 - 1, 1 - 2, 1 - 3, 1 - 4, 1 - 5, 1 -6, 1 - 7
  for (let i = 1; i < 9; i += 1) {
    for (let j = i; j < 9 - i; j += 1) {
      const dp1 = DP[i];
      const dp2 = DP[j];

      dp1.forEach((value1) => {
        dp2.forEach((value2) => {
          DP[i + j].add(value2 + value1);

          DP[i + j].add(value1 - value2);
          DP[i + j].add(value2 - value1);

          DP[i + j].add(Math.floor(value2 / value1));
          DP[i + j].add(Math.floor(value1 / value2));

          DP[i + j].add(value2 * value1);
        });
      });
    }
  }

  return DP.findIndex((set) => set.has(number)) ?? -1;
};
```
