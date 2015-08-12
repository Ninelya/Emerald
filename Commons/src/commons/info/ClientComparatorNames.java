package commons.info;

import java.util.Comparator;

public class ClientComparatorNames implements Comparator<Client> {
    @Override
    public int compare(Client client1, Client client2) {
        return client1.name.compareTo(client2.name);
    }
}