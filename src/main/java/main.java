import java.util.Scanner;

// Méthode principale
public class main {
    public static void main(
            String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choix;

        do {
            GestionEmployes.printMenu();
            choix = scanner.nextInt();
            scanner.nextLine(); // Consomme la nouvelle ligne

            switch (choix) {
                case 1:
                    System.out.print("Entrez l'ID: ");
                    int id = scanner.nextInt();
                    scanner.nextLine(); // Consomme la nouvelle ligne
                    System.out.print("Entrez le nom: ");
                    String nom = scanner.nextLine();
                    System.out.print("Entrez le poste: ");
                    String poste = scanner.nextLine();
                    System.out.print("Entrez le salaire: ");
                    double salaire = scanner.nextDouble();
                    GestionEmployes.ajouterEmploye(new Employe(id, nom, poste, salaire));
                    break;
                case 2:
                    System.out.print("Entrez l'ID de l'employé à modifier: ");
                    int idModif = scanner.nextInt();
                    scanner.nextLine(); // Consomme la nouvelle ligne
                    System.out.print("Entrez le nouveau nom: ");
                    String nouveauNom = scanner.nextLine();
                    System.out.print("Entrez le nouveau poste: ");
                    String nouveauPoste = scanner.nextLine();
                    System.out.print("Entrez le nouveau salaire: ");
                    double nouveauSalaire = scanner.nextDouble();
                    GestionEmployes.modifierEmploye(idModif, nouveauNom, nouveauPoste, nouveauSalaire);
                    break;
                case 3:
                    System.out.print("Entrez l'ID de l'employé à supprimer: ");
                    int idSuppr = scanner.nextInt();
                    GestionEmployes.supprimerEmploye(idSuppr);
                    break;
                case 4:
                    GestionEmployes.afficherEmployes();
                    break;
                case 5:
                    System.out.print("Entrez le critère de recherche (nom ou poste): ");
                    String critere = scanner.nextLine();
                    GestionEmployes.rechercherEmploye(critere);
                    break;
                case 6:
                    System.out.println("Masse salariale totale: " + GestionEmployes.calculerMasseSalariale());
                    break;
                case 7:
                    System.out.print("Trier par salaire (true pour croissant, false pour décroissant): ");
                    boolean ordre = scanner.nextBoolean();
                    GestionEmployes.trierEmployesParSalaire(ordre);
                    break;
                case 8:
                    System.out.println("Au revoir!");
                    break;
                default:
                    System.out.println("Choix invalide. Veuillez réessayer.");
            }
        } while (choix != 8);

        scanner.close();
    }
}


