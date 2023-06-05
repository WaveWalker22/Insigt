package com.example.insigt;

public class Job {
    private String jobName;
    private long totalTime;
    private long currentTime;
    private boolean active;

    public Job(String jobName, long totalTime, long currentTime) {
        this.jobName = jobName;
        this.totalTime = totalTime;
        this.currentTime = currentTime;
        boolean active = false;
    }

    public Job(String jobName) {
        this.jobName = jobName;
        this.active = false;
    }

    public Job(String jobName, boolean active) {
        this.jobName = jobName;
        this.active = active;
    }


    public void setJobName(String jobName) {
        this.jobName = jobName;
    }

    public void setTotalTime(long totalTime) {
        this.totalTime = totalTime;
    }

    public void setCurrentTime(long currentTime) {
        this.currentTime = currentTime;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public String getJobName() {
        return jobName;
    }

    public long getTotalTime() {
        return totalTime;
    }

    public long getCurrentTime() {
        return currentTime;
    }


    public boolean isActive() {
        return active;
    }

    @Override
    public String toString() {
        return "Job{" +
                "jobName='" + jobName + '\'' +
                ", totalTime=" + totalTime +
                ", currentTime=" + currentTime +
                ", active=" + active +
                '}';
    }
}
