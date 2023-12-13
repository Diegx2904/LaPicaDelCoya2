package com.example.portada.Modelo;
public class Pedido {

    private int total;
    private boolean bbq;
    private boolean ketchup;
    private boolean mostaza;
    private boolean mayonesa;
    private boolean domicilio;

    public Pedido() {
    }

    public Pedido(int total, boolean bbq, boolean ketchup, boolean mostaza, boolean mayonesa, boolean domicilio) {
        this.total = total;
        this.bbq = bbq;
        this.ketchup = ketchup;
        this.mostaza = mostaza;
        this.mayonesa = mayonesa;
        this.domicilio = domicilio;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public boolean isBbq() {
        return bbq;
    }

    public void setBbq(boolean bbq) {
        this.bbq = bbq;
    }

    public boolean isKetchup() {
        return ketchup;
    }

    public void setKetchup(boolean ketchup) {
        this.ketchup = ketchup;
    }

    public boolean isMostaza() {
        return mostaza;
    }

    public void setMostaza(boolean mostaza) {
        this.mostaza = mostaza;
    }

    public boolean isMayonesa() {
        return mayonesa;
    }

    public void setMayonesa(boolean mayonesa) {
        this.mayonesa = mayonesa;
    }

    public boolean isDomicilio() {
        return domicilio;
    }

    public void setDomicilio(boolean domicilio) {
        this.domicilio = domicilio;
    }

    @Override
    public String toString() {
        return "total: " + total +
                ", bbq: " + bbq +
                ", ketchup: " + ketchup +
                ", mostaza: " + mostaza +
                ", mayonesa: " + mayonesa +
                ", domicilio: " + domicilio +
                '}';
    }
}

