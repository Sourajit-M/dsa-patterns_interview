package heap;

import java.util.Arrays;
import java.util.PriorityQueue;

public class CourseScheduleIII {
    public static int scheduleCourse(int[][] courses){
        Arrays.sort(courses, (a, b) -> Integer.compare(a[1], b[1]));

        PriorityQueue<Integer> pq = new PriorityQueue<>(
            (a, b) -> Integer.compare(b, a)
        );

        int time = 0;

        for(int[] course : courses){
            int duration = course[0];
            int deadline = course[1];

            pq.offer(duration);
            time += duration;

            if(time > deadline){
                time -= pq.poll();
            }
        }
        return pq.size();
    }
    public static void main(String[] args) {
        int[][] courses = {
            {100,200},{200,1300},{1000,1250},{2000,3200}
        };

        System.out.println(scheduleCourse(courses));
    }
}
