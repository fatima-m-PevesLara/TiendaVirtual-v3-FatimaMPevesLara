package tienda.models.impl;

import tienda.models.Pedido;
import tienda.models.impl.DescuentoFactory;
import tienda.models.interfaces.IDescuento;
import tienda.models.interfaces.IEstadoPedido;

public class PedidoCreado implements IEstadoPedido {

    private String id;
    private boolean pagoConcretado;

    public PedidoCreado()   {
    }

    @Override
    public void procesar(Pedido pedido) {

        DescuentoFactory factoryDiscount = new DescuentoFactory();
        //IDescuento descuento = factoryDiscount.crearDescuento(DescuentoFactory.DESCUENTO_ANIVERSARIO);
        IDescuento descuento = factoryDiscount.crearDescuento(DescuentoFactory.DESCUENTO_CUPON);
        pedido.setMontoTotal( pedido.calcularMontoPedido(descuento) );
        //System.out.println("Precio Total " + order.getMontoTotal()  );
                
        System.out.println("Pedido creado con monto: " + pedido.getMontoTotal() );

        if (pagoConcretado){
            pedido.setEstadoPedido( new PedidoValidado() );
        }
        else {
            pedido.setEstadoPedido(new PedidoAnulado());
        }
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
    
}
