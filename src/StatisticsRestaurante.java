package src;

import src.restaurante.Restaurante;

public class StatisticsRestaurante {

    private Restaurante restaurante;

    public StatisticsRestaurante(Restaurante restaurante) {
        this.restaurante = restaurante;
    }

    public void getStatistics(){

        System.out.println("Total de pessoas que passaram pela simulação");
        System.out.println(restaurante.totalPeoplePassedSim);

        double tempoTotalSimulacao = restaurante.getTime();
        System.out.println("Tempo total da simulação");
        System.out.println(restaurante.getTime());

        int totalPessoasPassaram = 0;
        String tamanhoMedio = "";
        String tempoMedio = "";

        for (EntitySet fila:restaurante.entitysets) {
            tamanhoMedio+=fila.averageSize()+"\n";
            tempoMedio+=fila.averageTimeInSet()+"\n";
        }

        System.out.println("Tamanho médio de cada fila");
        System.out.println(tamanhoMedio);
        System.out.println("Tempo médio de cada fila");
        System.out.println(tempoMedio);
    }

}
