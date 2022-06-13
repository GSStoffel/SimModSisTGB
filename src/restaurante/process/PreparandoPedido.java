package src.restaurante.process;

import src.EntitySet;
import src.Process;
import src.Resource;
import src.restaurante.entity.GrupoClientes;
import src.restaurante.entity.Pedido;

public class PreparandoPedido extends Process {

    private Pedido pedido;
    private Resource cozinheiros;
    private EntitySet filaCozinha;
    private EntitySet filaPedidos;

    public PreparandoPedido(int processId, String name, double duration, Pedido pedido, Resource cozinheiros, EntitySet filaCozinha, EntitySet filaPedidos) {
        super(processId, name, duration);
        this.pedido = pedido;
        this.cozinheiros = cozinheiros;
        this.filaCozinha = filaCozinha;
        this.filaPedidos = filaPedidos;
    }

    @Override
    public void executeOnStart() {

    }

    @Override
    public void executeOnEnd() {

    }
}
