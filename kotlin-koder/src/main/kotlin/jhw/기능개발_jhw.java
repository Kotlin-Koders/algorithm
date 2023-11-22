package jhw;

public class 기능개발_jhw {
    private final static int COMPLETE = 100;

    public int[] solution(int[] progresses, int[] speeds) {
        Queue<Integer> queueProgress = new LinkedList<>();
        for (int progress : progresses) {
            queueProgress.add(COMPLETE - progress);
        }
        int totalCompletedCount = 0;
        int targetIndex = 1;
        int baseSppedIndex = 0;
        List<Integer> count = new ArrayList<>();
        while (!queueProgress.isEmpty() && totalCompletedCount != progresses.length) {
            int completedCount = 1;
            int baseProgress = getProgress(speeds, queueProgress, baseSppedIndex);
            queueProgress.poll();
            //1
            for (int i = targetIndex; i < progresses.length; i++) {
                if (!queueProgress.isEmpty() && i < speeds.length) {
                    int compareProgress = getProgress(speeds, queueProgress, i);
                    if (compareProgress <= baseProgress) {
                        completedCount++;
                        queueProgress.poll();
                    } else {
                        baseSppedIndex = i;
                        targetIndex = i+1;
                        break;
                    }
                }
            }
            totalCompletedCount += completedCount;
            if(completedCount != 0) {
                count.add(completedCount);
            }
        }
        return count.stream().mapToInt(Integer::intValue).toArray();
    }

    private static int getProgress(int[] speeds, Queue<Integer> queueProgress, int i) {
        int compareProgress = queueProgress.peek() / speeds[i];
        if(queueProgress.peek() % speeds[i] != 0) {
            compareProgress += 1;
        }
        return compareProgress;
    }

}
