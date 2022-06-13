package src.restaurante;

import src.*;
import src.Process;
import src.restaurante.process.Chegada;
import src.restaurante.process.Comendo;
import src.restaurante.process.PagamentoPedido;
import src.restaurante.process.PreparandoPedido;

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
                SystemLog.writeInFile("RESOURCES: " + resources.toString());
                SystemLog.writeInFile("ENTITIES: " + entities.toString());
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

    public int createProcess(PagamentoPedido pagamentoPedido) {
        pagamentoPedido.setProcessId(getMaxProcessId()+1);
        processes.add(pagamentoPedido);
        SystemLog.writeInFile("CRIANDO PROCESSO DE PAGAMENTO E PEDIDO: "+pagamentoPedido.toString());
        return pagamentoPedido.getProcessId();
    }

    public int createProcess(PreparandoPedido preparandoPedido) {
        preparandoPedido.setProcessId(getMaxProcessId()+1);
        processes.add(preparandoPedido);
        SystemLog.writeInFile("CRIANDO PROCESSO DE PREPARAÇÃO DO PEDIDO: "+preparandoPedido.toString());
        return preparandoPedido.getProcessId();
    }

    public int createProcess(Comendo comendo) {
        comendo.setProcessId(getMaxProcessId()+1);
        processes.add(comendo);
        SystemLog.writeInFile("CRIANDO PROCESSO DE COMENDO: "+comendo.toString());
        return comendo.getProcessId();
    }
}
