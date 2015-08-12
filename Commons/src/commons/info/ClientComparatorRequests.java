package commons.info;


import java.util.Comparator;

public class ClientComparatorRequests implements Comparator<Client> {
    @Override
    public int compare(Client client1, Client client2) {
        return client2.requestCount - client1.requestCount;
    }
}