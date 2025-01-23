package hotel;

public class Chambre {
    private int numero;
    private String type;
    private boolean reserve;

    public Chambre(int numero, String type) {
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
