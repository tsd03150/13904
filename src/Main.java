import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

class Task implements Comparable<Task> {
    int day;
    int point;

    Task(int day, int point) {
        this.day = day;
        this.point = point;
    }

    @Override
    public int compareTo(Task t) {
        if (this.day == t.day) {
            return t.point - this.point;
        } else {
            return t.day - this.day;
        }
    }
}

class Main {

    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        ArrayList<Task> arr = new ArrayList<>();
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++) {
            int a = kb.nextInt();
            int b = kb.nextInt();

            arr.add(new Task(a, b));

            max = Math.max(max, a);
        }
        Collections.sort(arr);

        PriorityQueue<Integer> pQ = new PriorityQueue<>(Collections.reverseOrder());
        int j = 0;
        int answer = 0;
        for (int i = max; i > 0; i--) {

            for (; j < n; j++) {
                if (i <= arr.get(j).day) {
                    pQ.offer(arr.get(j).point);
                } else {
                    break;
                }
            }

            if (!pQ.isEmpty()) {
                answer += pQ.poll();
            }
        }
        System.out.println(answer);
    }
}
