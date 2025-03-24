package semiproyecto;

public class Nodo {

    private Cliente cliente;
    private Nodo sig;

    public Nodo(Cliente cliente) {
        this.cliente = cliente;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Nodo getSig() {
        return sig;
    }

    public void setSig(Nodo sig) {
        this.sig = sig;
    }


    @Override
    public String toString() {
        return cliente+"";
    }
}

