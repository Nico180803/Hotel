package application;
import hotel.Hotel;
import hotel.Chambre;
import hotel.Client;
import hotel.Type;
import hotel.Reservation;
import java.time.LocalDate;
import java.util.Scanner;

public class Application {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean continuer = true;
        String nom;

        System.out.println("Veuillez entrer le nom de l'hotel :");
        String nomHotel = sc.nextLine();

        System.out.println("Veuillez entrer l'adresse de l'hotel :");
        String adresseHotel = sc.nextLine();

        System.out.println("Veuillez entrer le pays où se trouve l'hotel :");
        String paysHotel = sc.nextLine();

        Hotel hotel = new Hotel(nomHotel, adresseHotel, paysHotel);


        do {
            System.out.println("Bienvenu à " + hotel.getHotelName() + ", que voulez vous faire ?\n\t1 - Ajouter une chambre\n\t2 - Ajouter un client\n\t3 - Ajouter un type de chambre\n\t4- Ajouter une réservation\n\t5 - Voir les réservations\n\t6 - Voir les chambres disponibles\n\t7 - Voir les clients\n\t8 - Arreter le programme");
            String reponse = sc.nextLine();

            switch (reponse) {
                case "1":
                    System.out.println("Entrez un numéro :");
                    int numeroChambre = sc.nextInt();
                    hotel.afficherTypes();
                    System.out.println("Quel type voulez vous ?");
                    Chambre chambre = new Chambre(numeroChambre, hotel.getTypes(sc.nextInt()));
                    hotel.ajouterChambre(chambre);
                    break;
                case "2":
                    System.out.println("Entrez un nom");
                    nom = sc.nextLine();
                    System.out.println("Entrez un mail");
                    String mail = sc.nextLine();
                    Client client = new Client(nom, mail);
                    hotel.ajouterClient(client);
                    break;
                case "3":
                    System.out.println("Entrer un prix");
                    int prix = sc.nextInt();
                    sc.nextLine();
                    System.out.println("Entrez un nom :");
                    nom = sc.nextLine();
                    Type type = new Type(nom, prix);
                    hotel.ajouterType(type);
                    break;
                case "4":
                    hotel.afficherClients();
                    System.out.println("Quel client reserve ?");
                    int numero = sc.nextInt();
                    sc.nextLine();
                    hotel.afficherChambresDisponibles();
                    System.out.println("Quelle chambre ?");
                    int numChambre = sc.nextInt();
                    sc.nextLine();
                    System.out.println("Entrez une date de début (AAAA-MM-DD) :");
                    LocalDate dateDebut = LocalDate.parse(sc.nextLine());
                    System.out.println("Entrez une date de fin (AAAA-MM-DD) :");
                    LocalDate dateFin = LocalDate.parse(sc.nextLine());
                    hotel.reserverChambre(numero, numChambre, dateDebut, dateFin);
                    break;
                case "5":
                    hotel.afficherReservations();
                    break;
                case "6":
                    hotel.afficherChambresDisponibles();
                    break;
                case "7":
                    hotel.afficherClients();
                    break;
                case "8":
                    continuer = false;
                    System.out.println("Au revoir !");
                    break;
                default:
                    break;
            }
        }while (continuer);
    }
}