package src.restaurante;

import src.*;
import src.Process;
import src.restaurante.process.Chegada;

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

    public int createProcess(Chegada chegada) {
        chegada.setProcessId(getMaxProcessId()+1);
        processes.add(chegada);
        return chegada.getProcessId();
    }
}
