package hotel;

import java.time.LocalDate;
import java.util.ArrayList;

public class Hotel {
    private String hotelName;
    private String hotelAddress;
    private String hotelCountry;
    private ArrayList<Chambre> chambres = new ArrayList<Chambre>();
    private ArrayList<Reservation> reservations = new ArrayList<Reservation>();
    private ArrayList<Type> types = new ArrayList<Type>();
    private ArrayList<Client> clients = new ArrayList<Client>();

    public Hotel(String hotelName, String hotelAddress, String hotelCountry) {
        this.hotelName = hotelName;
        this.hotelAddress = hotelAddress;
        this.hotelCountry = hotelCountry;
    }

    public void ajouterChambre(Chambre chambre) {
        this.chambres.add(chambre);
    }

    public void afficherChambresDisponibles() {
        System.out.println("Liste des chambres : ");
        for (Chambre chambre : chambres) {
            if (!chambre.isReserve()) {
                System.out.println("Chambre : "+chambre.getNumero());
            }
        }
    }

    public void afficherChambres() {
        System.out.println("Liste des chambres : ");
        int i = 1;
        for (Chambre chambre : chambres) {
            System.out.println("\n"+i+" "+chambre.getNumero());
            i++;
        }
    }

    public void reserverChambre(int client, int chambre, LocalDate dateDebut, LocalDate dateFin) {

        boolean accept = true;

        for (Reservation reservation : reservations){
            if (reservation.getDateDebut().isAfter(dateDebut)||reservation.getDateDebut().equals(dateDebut) || reservation.getDateFin().isBefore(dateFin)||reservation.getDateFin().equals(dateFin)) {
                System.out.println("Erreur une réservation existe déja !");
                accept = false;
                break;
            }
        }
        if (accept) {
            Reservation reservation = new Reservation(clients.get(client-1), chambres.get(chambre-1), dateDebut, dateFin);
            reservations.add(reservation);
            chambres.get(chambre-1).reserve();
        }
    }

    public void afficherReservations() {
        System.out.println("Liste des Réservations :");
        for (Reservation reservation : reservations) {
            System.out.println("Reservation : "+reservation.getClient().getName()+" "+reservation.getChambre().getNumero());
        }
    }

    public void changerAffectation(Client client,Chambre chambre1,Chambre chambre2) {
        chambre1.notReserve();
        chambre2.reserve();

        for (Reservation reservation : reservations) {
            if (reservation.getClient().equals(client) && reservation.getChambre().equals(chambre1)) {
                reservation.setChambre(chambre2);
            }
        }

    }

    public void supressionReservation(Client client,Chambre chambre){
        for (int i = 0; i < reservations.size(); i++) {

            if (reservations.get(i).getClient().equals(client) && reservations.get(i).getChambre().equals(chambre)) {
                reservations.remove(reservations.get(i));
            }
        }
    }

    public void afficherTypes() {
        int i = 1;
        System.out.println("Liste des types :");
        for (Type type : types) {
            System.out.println("\n"+i+" "+type.getNom());
            i ++;
        }
    }

    public void ajouterType(Type type) {
        types.add(type);
    }

    public void afficherClients() {
        int i = 1;
        System.out.println("Liste des clients :");
        for (Client client : clients) {
            System.out.println("\n"+i+" "+client.getName());
            i ++;
        }
    }

    public void ajouterClient(Client client) {
        clients.add(client);
    }

    public Type getTypes(int nbr) {
        return types.get(nbr-1);
    }

    public String getHotelName() {
        return hotelName;
    }

    public void setHotelName(String hotelName) {
        this.hotelName = hotelName;
    }

    public String getHotelAddress() {
        return hotelAddress;
    }

    public void setHotelAddress(String hotelAddress) {
        this.hotelAddress = hotelAddress;
    }

    public String getHotelCountry() {
        return hotelCountry;
    }

    public void setHotelCountry(String hotelCountry) {
        this.hotelCountry = hotelCountry;
    }
}

