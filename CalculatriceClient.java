import java.rmi.*;

public class CalculatriceClient {

    public static void main(String args[]) throws Exception {
        // Recherche de l'objet RMI sur le serveur
        CalculatriceInterface calculatrice = (CalculatriceInterface) Naming.lookup("rmi://localhost/CalculatriceServer");

        System.out.println("Client RMI démarré.");

        boolean continuer = true;

        // Boucle pour permettre au client de faire plusieurs calculs
        while (continuer) {
            // Demande à l'utilisateur de saisir l'opération et les opérandes
            int choix = Integer.parseInt(System.console().readLine("Entrez le code de l'opération (1: Addition, 2: Soustraction, 3: Multiplication, 4: Division): "));
            int a = Integer.parseInt(System.console().readLine("Entrez le premier nombre : "));
            int b = Integer.parseInt(System.console().readLine("Entrez le deuxième nombre : "));

            int resultat = 0;

            // Appel de la méthode appropriée sur l'objet RMI en fonction du choix de l'utilisateur
            switch (choix) {
                case 1:
                    resultat = calculatrice.addition(a, b);
                    break;
                case 2:
                    resultat = calculatrice.soustraction(a, b);
                    break;
                case 3:
                    resultat = calculatrice.multiplication(a, b);
                    break;
                case 4:
                    resultat = calculatrice.division(a, b);
                    break;
                default:
                    System.out.println("Code d'opération invalide.");
                    break;
            }

            // Affichage du résultat
            System.out.println("Résultat : " + resultat);

            // Demande à l'utilisateur s'il veut continuer
            String continuerStr = System.console().readLine("Voulez-vous continuer ? (oui/non): ");
            continuer = continuerStr.equalsIgnoreCase("oui");
        }
    }
}
