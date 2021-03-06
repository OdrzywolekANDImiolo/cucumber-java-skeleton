package progob;

public class Client extends Person {
    private static int id = 1;
    private int clientId;

    public Client(String firstName, String lastName) {
        super(firstName, lastName);
        clientId = id;
        id++;
    }

    public int getClientId() {
        return clientId;
    }

    public static int getStaticId() {
        return id;
    }
}
