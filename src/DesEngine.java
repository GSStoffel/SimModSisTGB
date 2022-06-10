package src;

import src.restaurante.Process;

import java.util.ArrayList;
import java.util.List;

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

}
