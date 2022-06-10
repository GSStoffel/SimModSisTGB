package src;

import src.restaurante.Process;

import java.util.Random;

public class Scheduler {
    private double time;

    public double getTime() { return time; }

    public void startProcessNow(int processId){}

    public  void startProcessIn(int processId, int timeToStart){}

    public  void startProcessAt(int processId, int absoluteTime){}

    public void waitFor(int time){}

    public void simulate(){}

    public void simulateOneStep(){}

    public void simulateBy(int duration){}

    public void simulateUntil(int absoluteTime){}

    //  criacao e destruicao

    public void createEntity(Entity entity){}

    public Entity getEntity(int id){ return null; }

    public int createResource(String name, int quantity){ return 0; }

    public Resource getResource(int id){ return null; }

    public int createProcess(String name, int duration){ return 0; }

    public Process getProcess(int processId){ return null; }

    public int createEntitySet(String name, String mode, int maxPossibleSize){ return 0; }

    public EntitySet getEntitySet(int id){ return null; }


    // coleta de estatisticas

    public int getEntityTotalQuantity(){ return 0; }

    public int getEntityTotalQuantity(String name){ return 0; }

    public double averageTimeInModel(){ return 0; }

    public int maxEntitiesPresent(){ return 0; }

}
