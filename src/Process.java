package src;

public class Process {

    protected int processId;
    protected String name;
    protected double startTime;
    protected double duration;
    protected boolean active;

    public Process(int processId, String name, double duration) {
        this.processId = processId;
        this.name = name;
        this.duration = duration;
        this.active = true;
        this.startTime = 0;
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
        return this.startTime + this.duration;
    }

    public void executeOnStart() {

        SystemLog.writeInFile("PROCESSO EXECUTADO NO INICIO: "+this.toString());
    }

    public void executeOnEnd(){
        startTime += duration;

        SystemLog.writeInFile("PROCESSO EXECUTADO NO FINAL: "+this.toString()+ " TEMPO INICIAL: "+startTime);
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
                ", duration=" + duration +
                ", active=" + active +
                '}';
    }
}
