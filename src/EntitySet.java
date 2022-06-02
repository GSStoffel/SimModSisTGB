package src;

import java.util.Map;

public class EntitySet {

    private String name;
    private int id;
    private String mode;
    private int size;
    private int maxPossibleSize;

    public EntitySet(String name, String mode, int maxPossibleSize) {
        this.name = name;
        this.mode = mode;
        this.maxPossibleSize = maxPossibleSize;
    }

    public String getMode() {
        return mode;
    }

    public void setMode(String mode) {
        this.mode = mode;
    }

    // TODO: implementar
    private Entity remove(){
        return null;
    }

    // TODO: implementar
    private Entity removeById(int id){
        return null;
    }

    public boolean isEmpty() {
        return size > 0;
    }

    // TODO: implementar
    public Entity findEntity(int id) {
        return null;
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
