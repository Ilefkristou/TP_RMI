import java.rmi.*;
import java.rmi.server.*;

public class CalculatriceServer extends UnicastRemoteObject implements CalculatriceInterface {

    public CalculatriceServer() throws RemoteException {
        super();
    }

    public int addition(int a, int b) throws RemoteException {
        return a + b;
    }

    public int soustraction(int a, int b) throws RemoteException {
        return a - b;
    }

    public int multiplication(int a, int b) throws RemoteException {
        return a * b;
    }

    public int division(int a, int b) throws RemoteException {
        if (b != 0)
            return a / b;
        else
            throw new RemoteException("Division par zéro.");
    }

    public static void main(String args[]) throws Exception {
        CalculatriceServer server = new CalculatriceServer();
        Naming.rebind("rmi://localhost/CalculatriceServer", server);
        System.out.println("Serveur RMI démarré.");
    }
}
