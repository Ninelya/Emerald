package commons.info;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Manager extends User implements Serializable {

    public List<Client> clients = new ArrayList<>();
    public List<Mail> mails = new ArrayList<>();

    public int userId;

    public Manager(int id, String email,
                   String name) {
        this.id = id;
        this.email = email;
        this.name = name;
    }

    public Client getClientById(int clientId) {
        for (Client client : clients)
            if (client.id == clientId)
                return client;
        return null;
    }
}