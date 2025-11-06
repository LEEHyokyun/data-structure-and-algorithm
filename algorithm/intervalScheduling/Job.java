package algorithm.intervalScheduling;

public class Job {
    private String jobName;
    private String startTime;
    private String endTime;

    public Job(String jobName, String startTime, String endTime) {
        this.jobName = jobName;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public String getJobName() {
        return this.jobName;
    }

    //우선순위 큐의 비교조건을 추출하기 위한 함수
    public int getStart(){
        return Integer.parseInt(startTime.replace(":",""));
    }

    //우선순위 큐의 비교조건을 추출하기 위한 함수
    public int getEnd(){
        return Integer.parseInt(endTime.replace(":",""));
    }
}
