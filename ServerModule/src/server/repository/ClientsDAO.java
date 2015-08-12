package server.repository;


import commons.info.Client;
import server.service.MysqlConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ClientsDAO {
    static final String TABLE = "clients";
    static final String ID = "id";
    static private final String MODER_ID = "moder_id";
    static private final String USER_ID = "user_id";
    static private final String INN = "inn";
    static private final String ADDRESS = "address";
    static private final String TELEPHONE = "tel";
    static final String INCOMING = "income";
    static final String GUARANTEE = "guarantee";
    static private final String BIRTHDAY = "birthday";
    static private final String PROFILE_CREATE_DATE = "create_date";
    static private final String SENIORITY = "seniority";
    static private final String IS_STUDENT = "is_student";

    private static final String GET_CLIENTS_BY_MANAGER_ID =
            "SELECT *" +
                    " FROM " + TABLE +
                    " LEFT JOIN " + UsersDAO.TABLE + " ON " +
                    UsersDAO.TABLE + "." + UsersDAO.ID + " = " +
                    TABLE + "." + USER_ID +
                    " WHERE " + MODER_ID +
                    " = ?";

    static final String GET_CLIENT_BY_LOGIN =
            "SELECT *" +
                    " FROM " + TABLE +
                    " LEFT JOIN " + UsersDAO.TABLE + " ON " +
                    UsersDAO.TABLE + "." + UsersDAO.ID + " = " +
                    TABLE + "." + USER_ID +
                    " WHERE " + UsersDAO.EMAIL +
                    " = ?";

    private static final String EDIT_CLIENT_BY_ID =
            "UPDATE " + TABLE +
                    " SET " +
                    ADDRESS + " = ?, " +
                    TELEPHONE + " = ?, " +
                    INCOMING + " = ?, " +
                    BIRTHDAY + " = ?, " +
                    GUARANTEE + " = ?," +
                    SENIORITY + " = ?," +
                    IS_STUDENT + " = ?" +
                    " WHERE " + ID +
                    " = ?";

    private static final String SET_NEW_MANAGER =
            "UPDATE " + TABLE +
                    " SET " +
                    MODER_ID + " = ?" +
                    " WHERE " + MODER_ID +
                    " = ?";

    private static final String SAVE_NEW_CLIENT =
            "INSERT INTO " + TABLE +
                    " SET " +
                    USER_ID + " = ?, " +
                    INN + " = ?, " +
                    MODER_ID + " = ?, " +
                    TELEPHONE + " = ?, " +
                    INCOMING + " = ?, " +
                    GUARANTEE + " = ?, " +
                    ADDRESS + " = ?, " +
                    BIRTHDAY + " = ?, " +
                    SENIORITY + " = ?," +
                    IS_STUDENT + " = ?," +
                    PROFILE_CREATE_DATE + " = NOW() ";


    public static int saveNewClient(Client client, int userId) {
        int result = 0;

        try (Connection connection = MysqlConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(
                     SAVE_NEW_CLIENT)) {

            statement.setInt(1, userId);
            statement.setString(2, client.inn);
            statement.setInt(3, client.managerId);
            statement.setInt(4, client.telephone);
            statement.setFloat(5, client.income);
            statement.setBoolean(6, client.hasGuarantee);
            statement.setString(7, client.address);
            statement.setInt(8, client.birthYear);
            statement.setInt(9, client.seniority);
            statement.setBoolean(10, client.isStudent);

            result = statement.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    public static int editClient(Client client) {
        int result = 0;

        try (Connection connection = MysqlConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(
                     EDIT_CLIENT_BY_ID)) {

            statement.setString(1, client.address);
            statement.setInt(2, client.telephone);
            statement.setFloat(3, client.income);
            statement.setInt(4, client.birthYear);
            statement.setBoolean(5, client.hasGuarantee);
            statement.setInt(6, client.seniority);
            statement.setBoolean(7, client.isStudent);
            statement.setInt(8, client.id);

            result = statement.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    public static Client getClientByLogin(String login) {
        Client result = null;

        try (Connection connection = MysqlConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(
                     GET_CLIENT_BY_LOGIN)) {

            statement.setString(1, login);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                result = new Client(
                        resultSet.getInt(TABLE + "." + ID),
                        resultSet.getInt(USER_ID),
                        resultSet.getString(INN),
                        resultSet.getString(UsersDAO.EMAIL),
                        resultSet.getInt(MODER_ID),
                        resultSet.getString(UsersDAO.NAME),
                        resultSet.getString(ADDRESS),
                        resultSet.getInt(TELEPHONE),
                        resultSet.getInt(INCOMING),
                        resultSet.getBoolean(GUARANTEE),
                        resultSet.getInt(BIRTHDAY),
                        resultSet.getDate(PROFILE_CREATE_DATE),
                        resultSet.getBoolean(IS_STUDENT),
                        resultSet.getInt(SENIORITY)
                );
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    public static List<Client> getClientsByManagerId(int id) {
        List<Client> result = new ArrayList<>();

        try (Connection connection = MysqlConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(
                     GET_CLIENTS_BY_MANAGER_ID)) {

            statement.setInt(1, id);
            try (ResultSet resultSet = statement.executeQuery()) {

                while (resultSet.next()) {
                    result.add(new Client(
                            resultSet.getInt(ID),
                            resultSet.getInt(USER_ID),
                            resultSet.getString(INN),
                            resultSet.getString(UsersDAO.EMAIL),
                            resultSet.getInt(MODER_ID),
                            resultSet.getString(UsersDAO.NAME),
                            resultSet.getString(ADDRESS),
                            resultSet.getInt(TELEPHONE),
                            resultSet.getInt(INCOMING),
                            resultSet.getBoolean(GUARANTEE),
                            resultSet.getInt(BIRTHDAY),
                            resultSet.getDate(PROFILE_CREATE_DATE),
                            resultSet.getBoolean(IS_STUDENT),
                            resultSet.getInt(SENIORITY)
                    ));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    public static void setNewManager(int userId, int newManagerId) {

        try (Connection connection = MysqlConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(
                     SET_NEW_MANAGER)) {

            statement.setInt(1, newManagerId);
            statement.setInt(2, userId);

            statement.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}