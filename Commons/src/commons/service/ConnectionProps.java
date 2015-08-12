package commons.service;

import java.io.*;
import java.util.Properties;

public class ConnectionProps {

    private static final String FILE_CONNECTION = "Commons/src/connection.properties";
    private static final String HOST = "host";
    private static final String PORT = "port";
    private static final String CLIENTS = "clients";

    private static final String FILE_SQL = "Commons/src/mysql.properties";
    public static final String DATABASE = "database";
    public static final String USER = "user";
    public static final String PASSWORD = "password";
    public static final String CHARSET = "charset";
    private static final String DEFAULT_CHARSET = "UTF8";


    public static String getHost() {
        return getProperty(HOST);
    }

    public static int getPort() {
        return Integer.valueOf(getProperty(PORT));
    }

    public static int getClients() {
        return Integer.valueOf(getProperty(CLIENTS));
    }

    private static String getProperty(String name) {
        Properties props = new Properties();
        String result = "";

        try (InputStream input = new FileInputStream(FILE_CONNECTION)) {
            props.load(input);
            result = props.getProperty(name);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }

    public static void setConnectionProps(String newHost, String newPort, String newClientsCount) {
        Properties props = new Properties();

        try (InputStream input = new FileInputStream(FILE_CONNECTION);
             OutputStream output = new FileOutputStream(FILE_CONNECTION)) {

            props.load(input);

            props.put(HOST, newHost);
            props.put(PORT, newPort);
            props.put(CLIENTS, newClientsCount);

            props.store(output, null);
            output.flush();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String getDBProperty(String name) {
        Properties props = new Properties();
        String result = "";

        try (InputStream input = new FileInputStream(FILE_SQL)) {
            props.load(input);
            result = props.getProperty(name);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }

    public static Properties setDBConnectionProps(String newUser, String newPassword, String dbUrl) {

        Properties props = new Properties();

        try (InputStream input = new FileInputStream(FILE_SQL);
             OutputStream output = new FileOutputStream(FILE_SQL)) {

            props.load(input);

            props.put(DATABASE, dbUrl);
            props.put(USER, newUser);
            props.put(PASSWORD, newPassword);
            props.put(CHARSET, DEFAULT_CHARSET);

            props.store(output, null);
            output.flush();

        } catch (IOException e) {
            e.printStackTrace();
        }
        return props;
    }

    public static String getDatabase() {
        return getDBProperty(DATABASE);
    }

    public static String getUser() {
        return getDBProperty(USER);
    }

    public static String getPassword() {
        return getDBProperty(PASSWORD);
    }

    public static String getCharset() {
        return getDBProperty(CHARSET);
    }
}