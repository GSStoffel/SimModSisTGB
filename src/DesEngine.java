package src;

import src.restaurante.entity.GrupoClientes;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public abstract class DesEngine {

    protected List<Entity> entities = new ArrayList<>();
    protected List<EntitySet> entitysets = new ArrayList<>();
    protected List<Resource> resources = new ArrayList<>();
    protected List<Process> processes = new ArrayList<>();
    protected double time;
    protected double maxTimeSimulate;
    protected boolean simulateOneStep;

    protected int totalPeoplePassedSim;

    public DesEngine() {
        this.time = 0;
    }

    public DesEngine(double time) {
        this.time = time;
    }

    public void simulate(){}

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
        SystemLog.writeInFile("PROCESSO INICIADO: "+ process.toString());
        process.executeOnStart();
    }

    public  void startProcessIn(int processId, int timeToStart){
        Process process = getProcess(processId);
        process.setDuration(timeToStart);
        SystemLog.writeInFile("PROCESSO INICIADO NO TEMPO: "+timeToStart+" | "+ process.toString());
    }

    public  void startProcessAt(int processId, int absoluteTime){
        Process process = getProcess(processId);
        process.setStartTime(absoluteTime);
        SystemLog.writeInFile("PROCESSO NO TEMPO: "+absoluteTime+" | "+ process.toString());
    }

//    public void waitFor(int time){}

//    public void simulateOneStep(){}

    public void simulateBy(int duration){}

    public void simulateUntil(int absoluteTime){
        this.maxTimeSimulate = absoluteTime;
    }


    public boolean isSimulateOneStep() {
        return simulateOneStep;
    }

    public void setSimulateOneStep(boolean simulateOneStep) {
        this.simulateOneStep = simulateOneStep;
    }

    //  criacao e destruicao

    public Entity getEntity(int id){
        for (Entity e : entities) {
            if (e.getId() == id) {
                return e;
            }
        }
        return null;
    }

    public int createEntity(String name){
        GrupoClientes grupoClientes = new GrupoClientes(getMaxEntityId()+1, name);

        entities.add(grupoClientes);

        SystemLog.writeInFile("CRIANDO ENTIDADE: "+grupoClientes.toString());

        totalPeoplePassedSim++;

        return grupoClientes.getId();
    }

    public Entity destroyEntity(int id){
        Entity removedEntity = getEntity(id);
        entities.remove(removedEntity);

        SystemLog.writeInFile("REMOVENDO ENTIDADE: "+removedEntity.toString());

        return removedEntity;
    }

    public int createResource(String name, int quantity){
        Resource resource = new Resource(getMaxResourceId()+1, name, quantity);
        resources.add(resource);

        SystemLog.writeInFile("CRIANDO RECURSO: "+resource.toString());

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

    public Process getProcess(int processId){
        for (Process p : processes) {
            if (p.getProcessId() == processId) {
                return p;
            }
        }
        return null;
    }

    public EntitySet getEntitySet(int entitySet){
        for (EntitySet es : entitysets) {
            if (es.getId() == entitySet) {
                return es;
            }
        }
        return null;
    }

    public int createEntitySet(String name, int mode, int maxPossibleSize){
        EntitySet entitySet = new EntitySet(getMaxEntitySetId()+1, name, mode, maxPossibleSize);
        entitysets.add(entitySet);

        SystemLog.writeInFile("CRIANDO FILA: "+entitySet.toString());

        return entitySet.getId();
    }

    protected int getMaxProcessId() {
        if(processes.isEmpty()) {
            return 0;
        }

        int id = 1;
        for (Process p : processes) {
            if(id < p.getProcessId()) {
                id = p.getProcessId();
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

    private int getMaxEntityId() {
        if(entities.isEmpty()) {
            return 0;
        }

        int id = 1;
        for (Entity e : entities) {
            if(id < e.getId()) {
                id = e.getId();
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

    public int maxEntitiesPresent(){
        int total = 0;
        for (Entity e : entities) {
            if (e.getEndTime() < time) {
                total++;
            }
        }
        return total;
    }

    public double allocationResourceRate(int resourceId) {
        for (Resource r : resources) {
            if (r.getId() == resourceId) {
                return r.getTotalTimeAllocated() / time;
            }
        }
        return 0;
    }

    public double avarageResourceAllocation(int resourceId) {
        for (Resource r : resources) {
            if (r.getId() == resourceId) {
                return r.getTotalAllocation() / time;
            }
        }
        return 0;
    }

    public int createProcess(String name, double duration){
        Process process = new Process(getMaxProcessId()+1, name, duration);
        processes.add(process);

        SystemLog.writeInFile("CRIANDO PROCESSO: "+process.toString());

        return process.getProcessId();
    }

}