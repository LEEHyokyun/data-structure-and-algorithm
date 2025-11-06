package algorithm.intervalScheduling;

import java.util.*;

public class IntervalScheduler {
    private PriorityQueue<Job> pq;
    private ArrayList<Job> jobs;
    
    public IntervalScheduler() {
        //종료시각 기준으로 우선순위 큐를 정렬
        pq = new PriorityQueue<>(Comparator.comparingInt(Job::getEnd));
        jobs = new ArrayList<>();
    }

    public void addJob1(Job job) {
        pq.add(job);
    }

    public void addJob2(Job job) {
        jobs.add(job);
    }

    //priority queue 활용
    public void intervalScheduling1(){
        /*
        * 종료시각이 이른 순서로 정렬
        * */
        ArrayList<Job> jobs = new ArrayList<>();
        int lastEndTime = 0;

        while(!pq.isEmpty()){
            Job job = pq.poll();
            if(job.getStart() >= lastEndTime){
                jobs.add(job);
                lastEndTime = job.getEnd();
            }
        }

        jobs.stream().forEach(job -> System.out.println(job.getJobName()));
    }

    //배열만 활용
    public void intervalScheduling2(){
        jobs.sort(Comparator.comparingInt(Job::getEnd));

        List<Job> result = new ArrayList<>();
        int lastEndTime = 0;

        for(Job job : jobs){
            if(job.getStart() >= lastEndTime){
                result.add(job);
                lastEndTime = job.getEnd();
            }
        }

    }
}
