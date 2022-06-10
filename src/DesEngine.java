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
    Scheduler scheduler;

    public void simulate() {

    }

    public Resource createResource(Resource resource) {
        resources.add(resource);
        return resource;
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

    public Scheduler getScheduler() {
        return scheduler;
    }

    public EntitySet createEntitySet(EntitySet entitySet) {
        entitysets.add(entitySet);
        return entitySet;
    }

    public Process createProcess(Process process) {
        processes.add(process);
        return process;
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

}
