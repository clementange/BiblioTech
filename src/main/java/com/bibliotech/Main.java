/*
package main.java.com.bibliotech.model;

import java.util.Scanner;



public class Main {
    static Book[] catalogue = new Book[10];
    static int nombreLivre = 0;

    public static void main(String[] args) {

        ajouterLivre(catalogue, new Book("PRINCE", "BOO", "1254", true));
        ajouterLivre(catalogue, new Book("main sale", "jean paul satre", "1255", true));

        Scanner scanner = new Scanner(System.in);
        int choix = 0;


        while (choix != 4) {
            System.out.println("\n--- MENU GESTION CATALOGUE ---");
            System.out.println("1: Ajouter un livre");
            System.out.println("2: Rechercher un livre par titre");
            System.out.println("3: Afficher tout le catalogue");
            System.out.println("4: Quitter");
            System.out.print("Quel action souhaitez-vous effectuer : ");

            if (scanner.hasNextInt()) {
                choix = scanner.nextInt();
                scanner.nextLine();
            } else {
                System.out.println("Veuillez entrer un nombre valide !");
                scanner.nextLine();
                continue;
            }

            switch (choix) {
                case 1:
                    System.out.print("Entrez le titre : ");
                    String titre = scanner.nextLine();
                    System.out.print("Entrez l'auteur : ");
                    String auteur = scanner.nextLine();
                    System.out.print("Entrez l'ISBN : ");
                    String isbn = scanner.nextLine();

                    ajouterLivre(catalogue, new Book(titre, auteur, isbn, true));
                    break;

                case 2:
                    System.out.print("Entrez le titre du livre à rechercher : ");
                    String titreRecherche = scanner.nextLine();
                    rechercherParTitre(catalogue, titreRecherche);
                    break;

                case 3:
                    afficherCatalogue(catalogue);
                    break;

                case 4:
                    System.out.println("Fin du programme. Au revoir !");
                    break;

                default:
                    System.out.println("Option invalide. Veuillez choisir entre 1 et 4.");
            }
        }
        scanner.close();
    }

    public static void ajouterLivre(Book[] catalogue, Book livre) {
        if (nombreLivre < catalogue.length) {
            catalogue[nombreLivre] = livre;
            nombreLivre++;
            System.out.println("Livre ajouté avec succès !");
        } else {
            System.out.println("Catalogue plein !");
        }
    }

    public static Book rechercherParTitre(Book[] catalogue, String titre) {
        for (int i = 0; i < nombreLivre; i++) {
            if (catalogue[i].getTitle().equalsIgnoreCase(titre)) {
                System.out.println("Ce titre correspond bien à un livre !");
                System.out.println(catalogue[i]);
                return catalogue[i];
            }
        }
        System.out.println("Le titre de ce livre n'existe pas dans le catalogue !");
        return null;
    }

    public static void afficherCatalogue(Book[] catalogue) {
        if (nombreLivre == 0) {
            System.out.println("Le catalogue est vide.");
            return;
        }
        System.out.println(" Liste des livres");
        for (int i = 0; i < nombreLivre; i++) {
            System.out.println((i + 1) + ". " + catalogue[i]);
        }
    }
}*/

package main.java.com.bibliotech;


import main.java.com.bibliotech.model.Book;

import java.util.Scanner;

public class Main {
    static Book[] catalogue = new Book[10];
    static int nombreLivre = 0;

    public static void main(String[] args) {
        ajouterLivre(catalogue, new Book("Le Petit Prince", "Saint-Exupéry", "978-2-07-061275-8"));
        ajouterLivre(catalogue, new Book("1984", "George Orwell", "978-2-07-036822-6"));
        Scanner scanner = new Scanner(System.in);
        int choix = 0;

        while (choix != 4) {
            System.out.println("\n--- MENU GESTION CATALOGUE ---");
            System.out.println("1: Ajouter un livre");
            System.out.println("2: Rechercher un livre par titre");
            System.out.println("3: Afficher tout le catalogue");
            System.out.println("4: Quitter");
            System.out.print("Votre choix : ");

            if (scanner.hasNextInt()) {
                choix = scanner.nextInt();
                scanner.nextLine();
            } else {
                System.out.println("Veuillez entrer un nombre valide !");
                scanner.nextLine();
                continue;
            }

            switch (choix) {
                case 1:
                    System.out.print("Titre : ");
                    String titre = scanner.nextLine();
                    System.out.print("Auteur : ");
                    String auteur = scanner.nextLine();
                    System.out.print("ISBN : ");
                    String isbn = scanner.nextLine();

                    // Vérification doublon ISBN (amélioration)
                    if (rechercherParIsbn(catalogue, isbn) != null) {
                        System.out.println("Erreur : un livre avec cet ISBN existe déjà !");
                    } else {
                        ajouterLivre(catalogue, new Book(titre, auteur, isbn));
                    }
                    break;

                case 2:
                    System.out.print("Titre à rechercher : ");
                    String titreRecherche = scanner.nextLine();
                    rechercherParTitre(catalogue, titreRecherche);
                    break;

                case 3:
                    afficherCatalogue(catalogue);
                    break;

                case 4:
                    System.out.println("Au revoir !");
                    break;

                default:
                    System.out.println("Option invalide (1-4)");
            }
        }
        scanner.close();
    }

    public static void ajouterLivre(Book[] catalogue, Book livre) {
        if (nombreLivre < catalogue.length) {
            catalogue[nombreLivre] = livre;
            nombreLivre++;
            System.out.println("Livre ajouté !");
        } else {
            System.out.println("Catalogue plein !");
        }
    }

    public static Book rechercherParTitre(Book[] catalogue, String titre) {
        for (int i = 0; i < nombreLivre; i++) {
            if (catalogue[i].getTitle().equalsIgnoreCase(titre)) {
                System.out.println("Livre trouvé : " + catalogue[i]);
                return catalogue[i];
            }
        }
        System.out.println("Aucun livre avec ce titre.");
        return null;
    }

    public static Book rechercherParIsbn(Book[] catalogue, String isbn) {
        for (int i = 0; i < nombreLivre; i++) {
            if (catalogue[i].getIsbn().equalsIgnoreCase(isbn)) {
                return catalogue[i];
            }
        }
        return null;
    }

    public static void afficherCatalogue(Book[] catalogue) {
        if (nombreLivre == 0) {
            System.out.println("Le catalogue est vide.");
            return;
        }
        System.out.println("\n--- Liste des livres ---");
        for (int i = 0; i < nombreLivre; i++) {
            System.out.println((i + 1) + ". " + catalogue[i]);
        }
    }
}
