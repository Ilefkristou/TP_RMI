import java.rmi.*;

public interface CalculatriceInterface extends Remote {
    int addition(int a, int b) throws RemoteException;
    int soustraction(int a, int b) throws RemoteException;
    int multiplication(int a, int b) throws RemoteException;
    int division(int a, int b) throws RemoteException;
}
