package src.restaurante;

import src.*;
import src.Process;
import src.restaurante.process.Chegada;

import java.util.List;

public class Restaurante extends DesEngine {

    @Override
    public void simulate() {
        double nextTime = 0;
        while (time < maxTimeSimulate) {
            for (Process p : processes) {
                if (p.isActive() && p.getStartTime() >= time) {
                    p.executeOnStart();
                }

                if (p.isActive() && p.getEndTime() <= time) {
                    p.executeOnEnd();
                }

                if (nextTime < p.getStartTime()) {
                    nextTime = p.getStartTime();
                }
            }
        }
    }

    @Override
    public int createProcess(String name, double duration, List<EntitySet> entitySetList, Resource resource) {
        int processId = super.createProcess(name, duration);
        Process process = getProcess(processId);
        Chegada chegada = new Chegada(process.getId(), process.getName(), process.getDuration(), entitySetList, resource);
        processes.add(chegada);
        return chegada.getId();
    }

}
