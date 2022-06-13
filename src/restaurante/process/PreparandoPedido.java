package src.restaurante.process;

import src.Entity;
import src.EntitySet;
import src.Process;
import src.Resource;
import src.restaurante.entity.Pedido;

public class PreparandoPedido extends Process {

    private Pedido pedido;
    private Resource cozinheiros;
    private EntitySet filaCozinha;
    private EntitySet filaPedidosEspera;

    public PreparandoPedido(String name, double duration, Resource cozinheiros, EntitySet filaCozinha, EntitySet filaPedidosEspera) {
        super(name, duration);
        this.cozinheiros = cozinheiros;
        this.filaCozinha = filaCozinha;
        this.filaPedidosEspera = filaPedidosEspera;
    }

    @Override
    public void executeOnStart() {
        super.executeOnStart();
        if (!filaCozinha.getEntities().isEmpty()){
            boolean isAllocate = cozinheiros.allocate(1);
            if (isAllocate){
                pedido = (Pedido) filaCozinha.remove();
            }
        }
    }

    @Override
    public void executeOnEnd() {
        super.executeOnEnd();
        if (!filaCozinha.isFull() && pedido != null) {
            cozinheiros.release(1);
            filaPedidosEspera.getEntities().add(pedido);
        }
    }
}
