package semiproyecto;

public class Cola {

    private Nodo frent, ult;

    public boolean esVacia() {
        return frent == null;
    }

    public void encola(Cliente c) {
        Nodo n = new Nodo(c);
        if (this.esVacia()) {
            frent = ult = n;
        } else {
            ult.setSig(n);
            ult = n;
        }
    }
    public boolean buscar(int valor) {
        Nodo n = frent;
        while (n != null) {
            if (n.getCliente().getId() == valor) {
                return true;
            }
            n = n.getSig();
        }
        return false;
    }

    public void atiende() {
        if (!esVacia()) {
            frent = frent.getSig();
        }
    }

    public Nodo getFrente(){
        if (!esVacia()){
            return  frent;
        }
        return null;
    }

    @Override
    public String toString() {
        String r = "\n";
        if (this.esVacia()) {
            r += "Vacia\n";
        } else {
            Nodo aux = frent;
            while (aux != null) {
                r += aux + "\n";
                aux = aux.getSig();
            }
            r += "";
        }
        return r;
    }
}
