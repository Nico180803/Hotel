package hotel;

public class Chambre {
    private int numero;
    private Type type;
    private boolean reserve;

    public Chambre(int numero, Type type) {
        this.numero = numero;
        this.type = type;
    }

    public void reserve(){
        this.reserve = true;
    }

    public void notReserve(){
        this.reserve = false;
    }

    public boolean isReserve() {
        return reserve;
    }

    public int getNumero() {
        return numero;
    }
}
