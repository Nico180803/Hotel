package hotel;

import java.time.LocalDate;
import java.util.ArrayList;

public class Hotel {
    private String hotelName;
    private String hotelAddress;
    private String hotelCountry;
    ArrayList<Chambre> chambres = new ArrayList<Chambre>();
    ArrayList<Reservation> reservations = new ArrayList<Reservation>();

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

    public void reserverChambre(Client client, Chambre chambre, LocalDate dateDebut, LocalDate dateFin) {

        boolean accept = true;

        for (Reservation reservation : reservations){
            if (reservation.getDateDebut().isAfter(dateDebut)||reservation.getDateDebut().equals(dateDebut) || reservation.getDateFin().isBefore(dateFin)||reservation.getDateFin().equals(dateFin)) {
                System.out.println("Erreur une réservation existe déja !");
                accept = false;
                break;
            }
        }
        if (accept) {
            Reservation reservation = new Reservation(client, chambre, dateDebut, dateFin);
            reservations.add(reservation);
            chambre.reserve();
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
}

