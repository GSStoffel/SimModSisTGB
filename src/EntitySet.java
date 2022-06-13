package src;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EntitySet {

    private String name;
    private int id;
    private int mode;
    private int maxPossibleSize;
    private List<Entity> entities;

    public EntitySet(int id, String name, int mode, int maxPossibleSize) {
        this.id = id;
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
        return entities.isEmpty();
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

    // TODO: implementar

    public double maxTimeInSet() {
        int timeAv = 0;
        for (int i = 0; i < entities.size(); i++) {
            timeAv += entities.get(i).getCreationTime() / 2;
        }
        return timeAv / entities.size();
    }

    Map<Integer, Integer> log = new HashMap<>();

    public void startLog(int timeGap) throws IOException {
        // CSV
        File fout = new File("log.csv");
        FileOutputStream fos = new FileOutputStream(fout);
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(fos));
        Map<Integer, Integer> start_log = new HashMap<>();
        for (int i = 0; i < entities.size(); i++) {
            start_log.put((int) entities.get(i).getCreationTime(), getSize());
            log.put((int) entities.get(i).getCreationTime(), getSize());
            bw.write("START: " + start_log.toString());
            bw.newLine();
        }

        bw.close();
    }

    public void stopLog() throws IOException {
        File fout = new File("stop_log.csv");
        FileOutputStream fos = new FileOutputStream(fout);

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(fos));
        Map<Integer, Integer> stop_log = new HashMap<>();
        for (int i = 0; i < entities.size(); i++) {
            stop_log.put((int) entities.get(i).getCreationTime(), getSize());
            log.put((int) entities.get(i).getCreationTime(), getSize());
            bw.write("STOP: " + stop_log.toString());
            bw.newLine();
        }
        bw.close();
    }

    public Map<Integer, Integer> getLog() {
        return log;
    }

    public int getId() {
        return id;
    }

    public List<Entity> getEntities() {
        return entities;
    }
}