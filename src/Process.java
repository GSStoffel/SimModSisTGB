package src;

public class Process {

    protected int processId;
    protected String name;
    protected double startTime;
    protected double endTime;
    protected double duration;
    protected boolean active;

    public Process(int processId, String name, double duration) {
        this.processId = processId;
        this.name = name;
        this.duration = duration;
        this.startTime = 0;
        this.endTime = startTime+duration;
    }

    public Process(String name, double duration) {
        this.name = name;
        this.duration = duration;
    }

    public double getDuration() {
        return duration;
    }

    public void setDuration(double duration) {
        this.duration = duration;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public void setStartTime(double startTime) {
        this.startTime = startTime;
    }

    public double getStartTime() {
        return this.startTime;
    }

    public double getEndTime() {
        return this.endTime;
    }

    public void executeOnStart() {
        SystemLog.writeInFile("PROCESSO EXECUTADO NO INICIO: " + this.toString());
        startTime = getEndTime();
    }

    public void executeOnEnd() {
        SystemLog.writeInFile("PROCESSO EXECUTADO NO FINAL: " + this.toString());
        endTime += duration;
    }

    public int getProcessId() {
        return processId;
    }

    public String getName() {
        return name;
    }

    public void setProcessId(int processId) {
        this.processId = processId;
    }

    @Override
    public String toString() {
        return "Process{" +
                "processId=" + processId +
                ", name='" + name + '\'' +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                ", duration=" + duration +
                ", active=" + active +
                '}';
    }
}
