package src.restaurante;

public class Process {

    private String name;
    private int processId;
    private double duration;
    private boolean active;

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
}
