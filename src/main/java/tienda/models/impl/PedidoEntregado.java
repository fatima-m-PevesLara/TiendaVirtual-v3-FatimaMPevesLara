package tienda.models.impl;

import tienda.models.Pedido;
import tienda.models.interfaces.IEstadoPedido;

public class PedidoEntregado implements IEstadoPedido{

    private String id;
    private boolean pedidoEntregado;

    public PedidoEntregado()   {
    }

    @Override
    public void procesar(Pedido pedido) {

        if (pedidoEntregado){
            pedido.setEstadoPedido( new PedidoFinalizado());
        }
        else {
            pedido.setEstadoPedido(new PedidoNoEntregado());
        }
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
