package com.techlab.inicio.Model;
import com.techlab.inicio.Interfaces.Calculable;

import java.util.ArrayList;

public class ProductoElectronico extends Producto {

    //Atributos
    private int garantiaMeses;

    public ProductoElectronico(int codigo, String nombre, double precio, int cantidad, Categoria categoria, int garantiaMeses) {
        super(codigo, nombre, precio, cantidad, categoria);
        this.garantiaMeses = garantiaMeses;
    }

    //Métodos

    public int getGarantiaMeses() {
        return garantiaMeses;
    }

    public void setGarantiaMeses(int garantiaMeses) {
        this.garantiaMeses = garantiaMeses;
    }

    @Override
    public String getTipoProducto() {
        return "Electrónico";
    }

    @Override
    public String getDetalleEspecifico() {
        return "Garantía: " + garantiaMeses + " meses";
    }

    /*
     * Implementación concreta del método de la interfaz.
     *
     * Acá se ve claramente que esta clase cumple el contrato Calculable.
     */
    //@Override
    public double calcularPrecioFinal(ArrayList<ProductoElectronico> pedido, int codigoBuscado) {
        int codigoDePedido;
        for (ProductoElectronico productoPedido: pedido) {
            codigoDePedido = productoPedido.getCodigo();
            if (codigoDePedido == codigoBuscado) {
                if (garantiaMeses > 12) {
                    return getPrecio() * 1.10;
                }
                return getPrecio();
            }
        }
        return (-1);
    }

}
