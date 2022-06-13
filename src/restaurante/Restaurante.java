package src.restaurante;

import src.*;
import src.Process;
import src.restaurante.process.Chegada;

public class Restaurante extends DesEngine {

    @Override
    public void simulate() {
        double minTime = 0;
        while (time <= maxTimeSimulate) {
//            for (Process p : processes) {
//                if (p.isActive() && p.getStartTime() == time) {
//                    p.executeOnStart();
//                    if (nextTime < p.getStartTime()) {
//                        nextTime = p.getStartTime();
//                    }
//                }
//
//                if (p.isActive() && p.getStartTime() == time) {
//                    p.executeOnEnd();
//                    if (nextTime < p.getEndTime()) {
//                        nextTime = p.getEndTime();
//                    }
//                }
//            }
//            time = nextTime;

            for (Process p : processes) {
                if (p.getStartTime() == time){
                    p.executeOnStart();
                }

                if (p.getEndTime() == time){
                    p.executeOnEnd();
                }

                if (minTime > p.getStartTime()){
                    minTime = p.getStartTime();
                }
                if (minTime > p.getEndTime()){
                    minTime = p.getEndTime();
                }
            }
            time = minTime;
        }
    }

    public int createProcess(Chegada chegada) {
        chegada.setProcessId(getMaxProcessId()+1);
        processes.add(chegada);
        SystemLog.writeInFile("CRIANDO PROCESSO DE CHEGADA: "+chegada.toString());
        return chegada.getProcessId();
    }
}
