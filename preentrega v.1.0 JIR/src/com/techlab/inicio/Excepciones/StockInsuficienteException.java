package com.techlab.inicio.Excepciones;

public class StockInsuficienteException {
    public static Boolean main(int CantidadEnStock, int cantidadPedida) {
        if (CantidadEnStock <= cantidadPedida) {
            System.out.println("Stock insuficiente para satisfacer el pedido. Stock actual: " + CantidadEnStock + ". ");
            return true;
        }
        return false;
    }
}
