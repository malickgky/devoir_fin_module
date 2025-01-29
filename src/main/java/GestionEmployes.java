import java.util.Scanner;

// Classe principale GestionEmployes
public class GestionEmployes {
    private static final Employe[] employes = new Employe[50];
    private static int compteur = 0;

    // Méthode pour afficher le menu principal
    public static void printMenu() {
        System.out.println("Menu de Gestion des Employés");
        System.out.println("1. Ajouter un employé");
        System.out.println("2. Modifier un employé");
        System.out.println("3. Supprimer un employé");
        System.out.println("4. Afficher tous les employés");
        System.out.println("5. Rechercher un employé");
        System.out.println("6. Calculer la masse salariale");
        System.out.println("7. Trier les employés par salaire");
        System.out.println("8. Quitter");
        System.out.print("Choisissez une option: ");
    }

    // Méthode pour ajouter un employé
    public static void ajouterEmploye(Employe employe) {
        if (compteur < employes.length) {
            employes[compteur++] = employe;
            System.out.println("Employé ajouté avec succès.");
        } else {
            System.out.println("Le tableau est plein, impossible d'ajouter un nouvel employé.");
        }
    }

    // Méthode pour modifier un employé
    public static void modifierEmploye(int id, String nouveauNom, String nouveauPoste, double nouveauSalaire) {
        for (int i = 0; i < compteur; i++) {
            if (employes[i].getId() == id) {
                employes[i].setNom(nouveauNom);
                employes[i].setPoste(nouveauPoste);
                employes[i].setSalaire(nouveauSalaire);
                System.out.println("Employé modifié avec succès.");
                return;
            }
        }
        System.out.println("Employé non trouvé.");
    }

    // Méthode pour supprimer un employé
    public static void supprimerEmploye(int id) {
        for (int i = 0; i < compteur; i++) {
            if (employes[i].getId() == id) {
                // Décaler les éléments pour supprimer l'employé
                employes[i] = employes[--compteur]; // Remplace l'employé supprimé par le dernier
                employes[compteur] = null; // Nullifie la dernière position
                System.out.println("Employé supprimé avec succès.");
                return;
            }
        }
        System.out.println("Employé non trouvé.");
    }

    // Méthode pour afficher tous les employés
    public static void afficherEmployes() {
        if (compteur == 0) {
            System.out.println("Aucun employé à afficher.");
            return;
        }
        for (int i = 0; i < compteur; i++) {
            System.out.println(employes[i]);
        }
    }

    // Méthode pour rechercher un employé par nom ou poste
    public static void rechercherEmploye(String critere) {
        boolean trouve = false;
        for (int i = 0; i < compteur; i++) {
            if (employes[i].getNom().toLowerCase().contains(critere.toLowerCase()) ||
                    employes[i].getPoste().toLowerCase().contains(critere.toLowerCase())) {
                System.out.println(employes[i]);
                trouve = true;
            }
        }
        if (!trouve) {
            System.out.println("Aucun employé trouvé avec ce critère.");
        }
    }
    // Méthode pour calculer la masse salariale
    public static double calculerMasseSalariale() {
        double masseSalariale = 0;
        for (int i = 0; i < compteur; i++) {
            masseSalariale += employes[i].getSalaire();
        }
        return masseSalariale;
    }

    // Méthode pour trier les employés par salaire
    public static void trierEmployesParSalaire(boolean ordreCroissant) {
        for (int i = 0; i < compteur - 1; i++) {
            for (int j = 0; j < compteur - i - 1; j++) {
                // Inverser l'ordre pour un tri décroissant
                if (ordreCroissant ? Employe.compareParSalaire(employes[j], employes[j + 1]) > 0 :
                        Employe.compareParSalaire(employes[j], employes[j + 1]) < 0) {
                    // Échange
                    Employe temp = employes[j];
                    employes[j] = employes[j + 1];
                    employes[j + 1] = temp;
                }
            }
        }
        afficherEmployes();
    }
}
