import java.rmi.*;

public interface CalculatriceInterface extends Remote {
    // Déclaration des méthodes que le client peut appeler
    int addition(int a, int b) throws RemoteException;
    int soustraction(int a, int b) throws RemoteException;
    int multiplication(int a, int b) throws RemoteException;
    int division(int a, int b) throws RemoteException;
}

