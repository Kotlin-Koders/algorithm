package cws

/*
    1. 컬럼 기준으로 행렬 생성
    2. 유일성을 가진 컬럼이 아닌 것들 분류 (유일성 컬럼인 경우 answer +1)
    3. 유일성을 가지지 않은 컬럼끼리 조합 구하기
    4. 조합된 컬럼의 유일성 검증 (유일성 컬럼인 경우 answer +1) -> 구현 못함 ㅠㅠ
*/
class 후보키_cws {
    fun solution(relation: Array<Array<String>>): Int {
        var answer = 0

        // 1
        val pivot = mutableListOf<List<String>>()

        var rowSize = relation[0].size
        var columnSize = relation.size

        for (i in 0 until relation[0].size) {
            val pivotRow = mutableListOf<String>()
            for (element in relation) {
                pivotRow.add(element[i])
            }
            pivot.add(pivotRow)
        }

        // 2
        val notUniquePivot = mutableListOf<List<String>>()
        for (columns in pivot) {
            if (columns.size != columns.toSet().size) {
                notUniquePivot.add(columns)
            } else {
                answer += 1
            }
        }
        println(notUniquePivot)

        // 3
        val combinationIndexList = mutableListOf<List<Int>>()
        for (i in 2..notUniquePivot.size) {
            combinationIndexList.addAll(combination((0 until notUniquePivot.size).toList().toTypedArray(), i))
        }
        println(combinationIndexList)

        //4
        for (combinationIndex in combinationIndexList) {
            val tt = mutableListOf<String>()
            for (index in combinationIndex) {
                var vv = ""
                for (notUniqueColumn in notUniquePivot) {
                    vv += notUniqueColumn[index]
                }
                if (tt.contains(vv)) {

                }
            }

        }

        return answer
    }

    fun <T> combination(elements: Array<T>, r: Int): List<List<T>> {
        val n = elements.size
        val results = mutableListOf<List<T>>()

        val result = elements.sliceArray(0 until r)

        fun recursionCombination(depth: Int = 0, index: Int = 0) {
            if (depth == r) {
                results.add(result.toList())
                return
            }

            for (i in index until n) {
                result[depth] = elements[i]
                recursionCombination(depth + 1, i + 1)
            }
        }

        recursionCombination()
        return results
    }
}