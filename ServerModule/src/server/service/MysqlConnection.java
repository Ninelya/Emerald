package server.service;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;
import commons.service.ConnectionProps;

import java.sql.Connection;
import java.sql.SQLException;

public class MysqlConnection {

    public static Connection getConnection() throws SQLException {
        MysqlDataSource dataSource = new MysqlDataSource();
        dataSource.setURL(ConnectionProps.getDatabase());
        dataSource.setUser(ConnectionProps.getUser());
        dataSource.setPassword(ConnectionProps.getPassword());
        dataSource.setCharacterEncoding(ConnectionProps.getCharset());

        return dataSource.getConnection();
    }
}