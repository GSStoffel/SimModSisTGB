package src.restaurante;

import src.*;
import src.Process;
import src.restaurante.process.Chegada;

public class Restaurante extends DesEngine {

    @Override
    public void simulate() {
        for (Process p : processes) {
            if (p.isActive() && p.getStartTime() >= time) {
                p.executeOnStart();
            }

            if (p.isActive() && p.getEndTime() <= time) {
                p.executeOnEnd();
            }
        }
    }


    @Override
    public int createProcess(String name, double duration, EntitySet entitySet, Resource resource) {
        int processId = super.createProcess(name, duration);
        Process process = getProcess(processId);
        Chegada chegada = new Chegada(process.getId(), process.getName(), process.getDuration(), entitySet, resource);
        processes.add(chegada);
        return chegada.getId();
    }

}
