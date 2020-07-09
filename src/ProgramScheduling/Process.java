package ProgramScheduling;


public class Process {
    private int arrivalTime;
    private int servicesTime;
    private int remainServiceTime;
    private int startTime;
    private int waitTime;
    private int completionTime;

    /**
     * turnAroundTime = completionTime - arrivalTime
     */
    private int turnAroundTime;

    /**
     * turnAroundTimeWithWeight = turnAroundTime / servicesTime
     */
    private double turnAroundTimeWithWeight;

    public Process() {
        ;
    }

    public int getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(int arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public int getServicesTime() {
        return servicesTime;
    }

    public void setServicesTime(int servicesTime) {
        this.servicesTime = servicesTime;
    }

    public int getRemainServiceTime() {
        return remainServiceTime;
    }

    public void setRemainServiceTime(int remainServiceTime) {
        this.remainServiceTime = remainServiceTime;
    }

    public int getStartTime() {
        return startTime;
    }

    public void setStartTime(int startTime) {
        this.startTime = startTime;
    }

    public int getWaitTime() {
        return waitTime;
    }

    public void setWaitTime(int waitTime) {
        this.waitTime = waitTime;
    }

    public int getCompletionTime() {
        return completionTime;
    }

    public void setCompletionTime(int completionTime) {
        this.completionTime = completionTime;
    }

    public int getTurnAroundTime() {
        return turnAroundTime;
    }

    public void setTurnAroundTime(int turnAroundTime) {
        this.turnAroundTime = turnAroundTime;
    }

    public double getTurnAroundTimeWithWeight() {
        return turnAroundTimeWithWeight;
    }

    public void setTurnAroundTimeWithWeight(double turnAroundTimeWithWeight) {
        this.turnAroundTimeWithWeight = turnAroundTimeWithWeight;
    }

    @Override
    public String toString() {
        return "Process [arrivalTime=" + arrivalTime + ", servicesTime="
                + servicesTime + ", remainServiceTime=" + remainServiceTime
                + ", startTime=" + startTime + ", waitTime=" + waitTime
                + ", completionTime=" + completionTime + ", turnAroundTime="
                + turnAroundTime + ", turnAroundTimeWithWeight="
                + turnAroundTimeWithWeight + "]";
    }
}
