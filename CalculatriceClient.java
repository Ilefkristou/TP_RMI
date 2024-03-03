import java.rmi.*;

public class CalculatriceClient {

    public static void main(String args[]) throws Exception {
        CalculatriceInterface calculatrice = (CalculatriceInterface) Naming.lookup("rmi://localhost/CalculatriceServer");

        System.out.println("Client RMI démarré.");

        boolean continuer = true;

        while (continuer) {
            int choix = Integer.parseInt(System.console().readLine("Entrez le code de l'opération (1: Addition, 2: Soustraction, 3: Multiplication, 4: Division): "));
            int a = Integer.parseInt(System.console().readLine("Entrez le premier nombre : "));
            int b = Integer.parseInt(System.console().readLine("Entrez le deuxième nombre : "));

            int resultat = 0;

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

            System.out.println("Résultat : " + resultat);

            String continuerStr = System.console().readLine("Voulez-vous continuer ? (oui/non): ");
            continuer = continuerStr.equalsIgnoreCase("oui");
        }
    }
}
