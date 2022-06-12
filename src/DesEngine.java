package src;

import src.restaurante.Process;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class DesEngine {

    private List<Entity> entities = new ArrayList<>();
    private List<EntitySet> entitysets = new ArrayList<>();
    private List<Resource> resources = new ArrayList<>();
    private List<Process> processes = new ArrayList<>();
    private double time;
    private double maxTimeSimulate;

    public DesEngine() {
        this.time = 0;
    }

    public DesEngine(double time) {
        this.time = time;
    }

    public void simulate(){

        for (Process p : processes) {
            if (p.isActive() && p.getStartTime() >= time) {
                p.executeOnStart();
            }

            if (p.isActive() && p.getEndTime() <= time) {
                p.executeOnEnd();
            }
        }

    }

    public List<Entity> getEntities() {
        return entities;
    }

    public List<EntitySet> getEntitysets() {
        return entitysets;
    }

    public List<Resource> getResources() {
        return resources;
    }

    public double normal(double meanValue, double stdDeviationValue){
        double w = 2;
        double result = 0;

        while(w > 1) {
            double u1 = new Random().nextGaussian();
            double u2 = new Random().nextGaussian();

            double v1 = 2 * u1 - 1;
            double v2 = 2 * u2 - 2;

            w = v1*v1 + v2*v2;

            double y = Math.sqrt((-2 * Math.log(w) / w));

            double x1 = v1 * y;

            if(w <= 1) {
                result = meanValue + x1 * stdDeviationValue;
            }
        }
        return result;
    }

    public double uniform(double minValue, double maxValue){
        return new Random().nextDouble();
    }

    public double exponential(double meanValue){
        return meanValue*Math.log(1-new Random().nextDouble());
    }

    public double getTime() { return time; }

    public void startProcessNow(int processId){
        Process process = getProcess(processId);
        process.executeOnStart();
    }

    public  void startProcessIn(int processId, int timeToStart){
        Process process = getProcess(processId);
        process.setDuration(timeToStart);
    }

    public  void startProcessAt(int processId, int absoluteTime){
        Process process = getProcess(processId);
        process.setStartTime(absoluteTime);
    }

    public void waitFor(int time){}

    public void simulateOneStep(){}

    public void simulateBy(int duration){}

    public void simulateUntil(int absoluteTime){

    }

    //  criacao e destruicao

    public Entity getEntity(int id){
        for (Entity e :
                entities) {
            if (e.getId() == id) {
                return e;
            }
        }
        return null;
    }

    public int createResource(String name, int quantity){
        Resource resource = new Resource(getMaxResourceId(), name, quantity);
        return resource.getId();
    }

    public Resource getResource(int id){
        for (Resource r : resources) {
            if (r.getId() == id) {
                return r;
            }
        }
        return null;
    }

    public int createProcess(String name, int duration){
        Process process = new Process(getMaxProcessId(), name, duration);
        return process.getId();
    }

    public Process getProcess(int processId){
        for (Process p : processes) {
            if (p.getId() == processId) {
                return p;
            }
        }
        return null;
    }

    public int createEntitySet(String name, int mode, int maxPossibleSize){
        EntitySet entitySet = new EntitySet(getMaxEntitySetId(), name, mode, maxPossibleSize);
        return entitySet.getId();
    }

    private int getMaxProcessId() {
        if(processes.isEmpty()) {
            return 0;
        }

        int id = 1;
        for (Process p : processes) {
            if(id < p.getId()) {
                id = p.getId();
            }
        }
        return id;
    }

    private int getMaxResourceId() {
        if(resources.isEmpty()) {
            return 0;
        }

        int id = 1;
        for (Resource r : resources) {
            if(id < r.getId()) {
                id = r.getId();
            }
        }
        return id;
    }

    private int getMaxEntitySetId() {
        if(entitysets.isEmpty()) {
            return 0;
        }

        int id = 1;
        for (EntitySet es : entitysets) {
            if(id < es.getId()) {
                id = es.getId();
            }
        }
        return id;
    }

    public void setTime(double time) {
        this.time = time;
    }

    // coleta de estatisticas

    public int getEntityTotalQuantity(){
        return entities.size();
    }

    public int getEntityTotalQuantity(String name){
        int total = 0;
        for (Entity e : entities) {
            if (e.getName().equals(name)) {
                total++;
            }
        }
        return total;
    }

    public double averageTimeInModel(){
        double total = 0;
        for (Entity e : entities) {
            total += e.getEndTime() - e.getCreationTime();
        }
        return total / entities.size();
    }

    public int maxEntitiesPresent(){ return 0; }
}
