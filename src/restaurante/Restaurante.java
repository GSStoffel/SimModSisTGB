package src.restaurante;

import src.*;
import src.Process;
import src.restaurante.process.Chegada;
import src.restaurante.process.PagamentoPedido;

public class Restaurante extends DesEngine {

    @Override
    public void simulate() {
        while (time < maxTimeSimulate) {
            SystemLog.writeInFile("EXECUÇÃO NO TEMPO: " + time);
            double minTime = maxTimeSimulate;
            for (Process p : processes) {
                if (p.getEndTime() == time){
                    p.executeOnEnd();
                }

                if (p.getStartTime() == time){
                    p.executeOnStart();
                }

                if (minTime > p.getStartTime()){
                    minTime = p.getStartTime();
                }
                if (minTime > p.getEndTime()){
                    minTime = p.getEndTime();
                }
                SystemLog.writeInFile("TAMANHO DA FILA: " + entitysets.toString());
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

    public int createProcess(PagamentoPedido chegada) {
        chegada.setProcessId(getMaxProcessId()+1);
        processes.add(chegada);
        SystemLog.writeInFile("CRIANDO PROCESSO DE CHEGADA: "+chegada.toString());
        return chegada.getProcessId();
    }
}
