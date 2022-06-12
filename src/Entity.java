package src;

public class Entity {
    private String name;
    private int id;
    private double creationTime;
    private double endTime;
    private int priority;
    private PetriNet petriNet;

    public Entity(String name) {
        this.name = name;
    }

    public Entity(String name, PetriNet petriNet) {
        this.name = name;
        this.petriNet = petriNet;
    }
    
    public Entity(String name, PetriNet petriNet, double creationTime) {
        this.name = name;
        this.petriNet = petriNet;
        this.creationTime = creationTime;
    }
    
    public Entity(String name, PetriNet petriNet, double creationTime, int priority) {
        this.name = name;
        this.petriNet = petriNet;
        this.creationTime = creationTime;
        this.priority = priority;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public double getCreationTime() {
        return creationTime;
    }

    public double getEndTime() {
        return endTime;
    }

    public void setEndTime(double endTime) {
        this.endTime = endTime;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public PetriNet getPetriNet() {
        return petriNet;
    }

    public void setPetriNet(PetriNet petriNet) {
        this.petriNet = petriNet;
    }

    @Override
    public String toString() {
        return "Id: " + this.id + " " + 
            "Name: " + this.name + " " + 
            "CreationTime: " + this.creationTime + " " +
            "EndTime: " + this.creationTime + " " +
            "Priority: " + this.priority;
    }
}
