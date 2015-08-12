package commons.info;

import commons.service.ConnectionProps;

import java.io.Serializable;

public class Props implements Serializable {
    public int port;
    public int clientsCount;
    public String host;

    public String dbUrl;
    public String user;
    public String password;

    public Props() {
        port = ConnectionProps.getPort();
        clientsCount = ConnectionProps.getClients();
        host = ConnectionProps.getHost();

        dbUrl = ConnectionProps.getDatabase();
        user = ConnectionProps.getUser();
        password = ConnectionProps.getPassword();
    }

    public Props(int port, int clientsCount, String host,
                 String dbUrl, String user, String password) {
        this.port = port;
        this.clientsCount = clientsCount;
        this.host = host;

        this.dbUrl = dbUrl;
        this.user = user;
        this.password = password;
    }
}