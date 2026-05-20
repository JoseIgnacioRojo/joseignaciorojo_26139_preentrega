package com.techlab.inicio.Model;

import java.util.ArrayList;

public class ProductoAlimenticio  extends Producto{
   //Atributos
    private int diasParaVencimiento;

    public ProductoAlimenticio(int codigo, String nombre, double precio, int cantidad, Categoria categoria, int diasParaVencimiento) {
        super(codigo, nombre, precio, cantidad, categoria);
        this.diasParaVencimiento = diasParaVencimiento;
    }

    //Métodos
    public int getDiasParaVencimiento() {
        return diasParaVencimiento;
    }

    public void setDiasParaVencimiento(int diasParaVencimiento) {
        this.diasParaVencimiento = diasParaVencimiento;
    }


    @Override
    public String getTipoProducto() {
        return "Alimenticio";
    }

    @Override
    public String getDetalleEspecifico() {
        return "Días para vencimiento: " + diasParaVencimiento;
    }

    //@Override
    public double calcularPrecioFinal(ArrayList<ProductoAlimenticio> pedido, int codigoBuscado) {
        int codigoDePedido;
        for (ProductoAlimenticio productoPedido: pedido) {
            codigoDePedido = productoPedido.getCodigo();
            if (codigoDePedido == codigoBuscado) {
                if (diasParaVencimiento <= 3) {
                    return getPrecio() * 0.80;
                }

                if (diasParaVencimiento <= 7) {
                    return getPrecio() * 0.90;
                }

                return getPrecio();
            }
        }
        return (-1);
    }

}
