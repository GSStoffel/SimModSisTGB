package src;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EntitySet {

    protected String name;
    protected int id;
    protected int mode;
    //private int size;
    protected int maxPossibleSize;
    protected List<Entity> entities;

    public EntitySet(int id, String name, int mode, int maxPossibleSize) {
        this.id = id;
        this.name = name;
        this.mode = mode;
        this.maxPossibleSize = maxPossibleSize;
        this.entities = new ArrayList<Entity>(maxPossibleSize);
    }

    public int getMode() {
        return mode;
    }

    public void setMode(int mode) {
        this.mode = mode;
    }

    private int getPriorityIndex() {
        int curIndex = 0;
        for (int i = 1; i < entities.size(); i++) {
            if (entities.get(i).getPriority() >= entities.get(curIndex).getPriority()) {
                curIndex = i;
            }
        }
        return curIndex;
    }

    public int getRandomNumber(int min, int max) {
        return (int) ((Math.random() * (max - min)) + min);
    }

    public Entity remove() {
        if (entities.size() > 0) {
            switch (mode) {
                case Mode.FIFO -> {
                    return entities.remove(entities.size() - 1);
                }
                case Mode.LIFO -> {
                    return entities.remove(0);
                }
                case Mode.PRIORITYBASED -> {
                    return entities.remove(getPriorityIndex());
                }
                case Mode.NONE -> {
                    return entities.remove(getRandomNumber(0, entities.size()));
                }
            }
        }
        return null;
    }

    private Entity removeById(int id) {
        return entities.remove(id);
    }

    public boolean isEmpty() {
        return entities.size() > 0;
    }

    public Entity findEntity(int id) {
        return entities.get(id);
    }

    public boolean isFull() {
        return entities.size() == maxPossibleSize;
    }

    // TODO: impelementar. PS.: Perguntar pro professor
    public double averageSize() {
        return entities.size() / 2;
    }

    public int getSize() {
        return entities.size();
    }

    public int getMaxPossibleSize() {
        return maxPossibleSize;
    }

    public double averageTimeInSet() {
        int timeAv = 0;
        for (int i = 0; i < entities.size(); i++) {
            timeAv += entities.get(i).getCreationTime();
        }
        return timeAv / entities.size();
    }

    public double maxTimeInSet() {
        int timeAv = 0;
        for (int i = 0; i < entities.size(); i++) {
            timeAv += entities.get(i).getCreationTime() / 2;
        }
        return timeAv / entities.size();
    }

    private List<LogPair> log = new ArrayList<>();

    public void startLog(int timeGap){
        for (int i = 0; i < entities.size(); i++) {
            LogPair logPair = new LogPair(entities.get(i).getCreationTime(), getSize());
            log.add(logPair);
            SystemLog.writeInFile("ENTITYSET START LOG: "+ logPair);
        }
    }

    public void stopLog(){
        for (int i = 0; i < entities.size(); i++) {
            LogPair logPair = new LogPair(entities.get(i).getCreationTime(), getSize());
            log.add(logPair);
            SystemLog.writeInFile("ENTITYSET STOP LOG: "+ logPair);
        }
    }

    public List<LogPair> getLog() {
        return log;
    }

    public int getId() {
        return id;
    }

    public List<Entity> getEntities() {
        return entities;
    }

    @Override
    public String toString() {
        return "EntitySet{" +
                "name='" + name + '\'' +
                ", id=" + id +
                ", mode=" + mode +
                ", size=" + entities.size() +
                ", maxPossibleSize=" + maxPossibleSize +
                '}';
    }
}