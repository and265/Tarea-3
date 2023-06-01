package org.example.Tarea1;

import Tarea1.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.*;

class ExpendedorTest {

    private Expendedor expendedor;
    @BeforeEach
    void setUp() {

        expendedor = new Expendedor(3,500,500);
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    @DisplayName("Test Una CocaCola")
    public void testComprarUnaBebida() throws PagoInsuficienteException, PagoIncorrectoException, NoHayProductoException {
        System.out.println("comprarUnaCocaCola");
        Moneda pago = new Moneda1000(101);
        expendedor.comprarProducto(pago,1);
        assertNotNull(expendedor.getCompra());

    }
    @Test
    @DisplayName("Test Tres CocaCola")
    public void testComprarTresBebidas() throws PagoInsuficienteException, PagoIncorrectoException, NoHayProductoException {

        Moneda pago = new Moneda1000(101);
        expendedor.comprarProducto(pago,1);
        assertNotNull(expendedor.getCompra());
        pago = new Moneda1000(102);
        expendedor.comprarProducto(pago,1);
        assertNotNull(expendedor.getCompra());
        pago = new Moneda1000(103);
        expendedor.comprarProducto(pago,1);
        assertNotNull(expendedor.getCompra());

    }

    @Test
    @DisplayName("Test NoHayProductoException")
    public void testComprarCuatroCocaCola(){
        Moneda pago = new Moneda1000(101);
        Exception exception = assertThrows(NoHayProductoException.class,()->{
            expendedor.comprarProducto(pago,1);
            expendedor.comprarProducto(pago,1);
            expendedor.comprarProducto(pago,1);
            expendedor.comprarProducto(pago,1);

        });
    }

    @Test
    @DisplayName("Test PagoInsuficienteException")
    public void testComprarBebidaSinSuficienteMoneda(){
        Moneda pago = new Moneda100(101);
        Exception exception = assertThrows(PagoInsuficienteException.class,
                ()->{
                    expendedor.comprarProducto(pago,1);

                });
    }

}