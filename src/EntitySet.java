package src;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class EntitySet {

    private String name;
    private int id;

    private Mode modeEnun;
    private int mode;

    private int size;
    private int maxPossibleSize;

    private List<Entity> entities;

    public EntitySet(String name, int mode, int maxPossibleSize) {
        this.name = name;
        this.mode = mode;
        this.maxPossibleSize = maxPossibleSize;
        this.entities = new ArrayList<>(maxPossibleSize);
    }

    public int getMode() {
        return mode;
    }

    public void setMode(int mode) {
        this.mode = mode;
    }

    private int getPriorityIndex(){
        int curIndex = 0;
        for (int i = 1; i < size; i++) {
            if (entities.get(i).getPriority() >= entities.get(curIndex).getPriority()){
                curIndex = i;
            }
        }
        return curIndex;
    }

    public int getRandomNumber(int min, int max) {
        return (int) ((Math.random() * (max - min)) + min);
    }

    // TODO: implementar
    private Entity remove(){
        if (size > 0){
            switch (mode) {
                case Mode.FIFO -> {
                    return entities.remove(entities.size()-1);
                }
                case Mode.LIFO -> {
                    return entities.remove(0);
                }
                case Mode.PRIORITYBASED -> {
                    return entities.remove(getPriorityIndex());
                }
                case Mode.NONE -> {
                    return entities.remove(getRandomNumber(0, size));
                }
            }
            this.size--;
        }
        return null;
    }

    // TODO: implementar
    private Entity removeById(int id){
        this.size--;
        return entities.remove(id);
    }

    public boolean isEmpty() {
        return size > 0;
    }

    // TODO: implementar
    public Entity findEntity(int id) {
        return entities.get(id);
    }

    public boolean isFull() {
        return size == maxPossibleSize;
    }

    // TODO: impelementar. PS.: Perguntar pro professor
    public double averageSize() {
        return 0;
    }

    public int getSize() {
        return size;
    }

    public int getMaxPossibleSize() {
        return maxPossibleSize;
    }

    // TODO: implementar
    public double averageTimeInSet() {
        return 0;
    }

    // TODO: implementar
    public double maxTimeInSet() {
        return 0;
    }

    public void startLog(int timeGap) {

    }

    public void stopLog() {

    }

    public Map<Integer, Integer> getLog() {
        return null;
    }
}
