package server.repository;


import commons.info.Client;
import commons.info.Manager;
import commons.info.User;
import commons.info.status.AccessType;
import server.service.MysqlConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class UsersDAO {
    static final String TABLE = "users";
    static final String ID = "id";
    static final String EMAIL = "email";
    static final String NAME = "name";
    private static final String PASSWORD = "password";
    private static final String TYPE_OF_ACCESS = "access";
    private static final String ACCESS_CLIENT = "client";

    static final String GET_PASSWORD_BY_LOGIN =
            "SELECT " + PASSWORD +
                    " FROM " + TABLE +
                    " WHERE " + EMAIL +
                    " = ?";

    static final String GET_ACCESS_TYPE_BY_LOGIN =
            "SELECT " + TYPE_OF_ACCESS +
                    " FROM " + TABLE +
                    " WHERE " + EMAIL +
                    " = ?";

    static final String GET_USER_BY_LOGIN =
            "SELECT *" +
                    " FROM " + TABLE +
                    " WHERE " + EMAIL +
                    " = ?";

    static final String GET_MANAGER_BY_LOGIN =
            "SELECT *" +
                    " FROM " + TABLE +
                    " LEFT JOIN " + ModersDAO.TABLE + " ON " +
                    ModersDAO.TABLE + "." + ModersDAO.USER_ID + " = " +
                    TABLE + "." + ID +
                    " WHERE " + EMAIL +
                    " = ?";

    static final String GET_MANAGER_BY_ID =
            "SELECT *" +
                    " FROM " + TABLE +
                    " LEFT JOIN " + ModersDAO.TABLE + " ON " +
                    ModersDAO.TABLE + "." + ModersDAO.USER_ID + " = " +
                    TABLE + "." + ID +
                    " WHERE " + ModersDAO.TABLE + "." + ModersDAO.ID +
                    " = ?";

    static final String GET_USERS =
            "SELECT *" +
                    " FROM " + TABLE;

    static final String GET_USER_ID_BY_LOGIN =
            "SELECT " + ID +
                    " FROM " + TABLE +
                    " WHERE " + EMAIL +
                    " = ?";

    static final String EDIT_USER_BY_ID =
            "UPDATE " + TABLE +
                    " SET " +
                    NAME + " = ?, " +
                    EMAIL + " = ?, " +
                    PASSWORD + " = ? " +
                    " WHERE " + ID +
                    " = ?";

    static final String EDIT_CLIENT_BY_ID =
            "UPDATE " + TABLE +
                    " SET " +
                    NAME + " = ?, " +
                    EMAIL + " = ? " +
                    " WHERE " + ID +
                    " = ?";

    static final String SAVE_NEW_USER =
            "INSERT INTO " + TABLE +
                    " SET " +
                    NAME + " = ?, " +
                    EMAIL + " = ?, " +
                    PASSWORD + " = ?, " +
                    TYPE_OF_ACCESS + " = ?";

    static final String DEL_USER_BY_ID =
            "DELETE " +
                    "FROM " + TABLE +
                    " WHERE " + ID +
                    " = ?";


    public static int saveNewClientsUser(User user) {
        int result = 0;

        try (Connection connection = MysqlConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(
                     SAVE_NEW_USER)) {

            statement.setString(1, user.name);
            statement.setString(2, user.email);
            statement.setString(3, user.password);
            statement.setString(4, ACCESS_CLIENT);

            result = statement.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    public static boolean getPasswordChecked(User loginPass) {

        String result = "";

        try (Connection connection = MysqlConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(
                     GET_PASSWORD_BY_LOGIN)) {

            statement.setString(1, loginPass.email);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    result = resultSet.getString(PASSWORD);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result.equals(loginPass.password);
    }

    public static String getUserAccessType(String login) {
        String result = "";
        try (Connection connection = MysqlConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(
                     GET_ACCESS_TYPE_BY_LOGIN)) {

            statement.setString(1, login);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    result = resultSet.getString(TYPE_OF_ACCESS);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    public static int getUserIdByLogin(String email) {
        int result = 0;

        try (Connection connection = MysqlConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(
                     GET_USER_ID_BY_LOGIN)) {

            statement.setString(1, email);
            try (ResultSet resultSet = statement.executeQuery()) {

                if (resultSet.next()) {
                    result = resultSet.getInt(ID);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    public static User getUserByLogin(String email) {
        User result = null;

        try (Connection connection = MysqlConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(
                     GET_USER_BY_LOGIN)) {

            statement.setString(1, email);
            try (ResultSet resultSet = statement.executeQuery()) {

                if (resultSet.next()) {
                    result = new User(
                            resultSet.getInt(ID),
                            resultSet.getString(NAME),
                            resultSet.getString(EMAIL),
                            resultSet.getString(PASSWORD),
                            AccessType.valueOf(resultSet.getString(TYPE_OF_ACCESS)));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    public static Manager getManagerByLogin(String login) {
        Manager result = null;

        try (Connection connection = MysqlConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(
                     GET_MANAGER_BY_LOGIN)) {

            statement.setString(1, login);
            try (ResultSet resultSet = statement.executeQuery()) {

                if (resultSet.next()) {
                    result = new Manager(
                            resultSet.getInt(ModersDAO.TABLE + "." + ID),
                            resultSet.getString(EMAIL),
                            resultSet.getString(NAME));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    public static Manager getManagerById(int managerId) {
        Manager result = null;

        try (Connection connection = MysqlConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(
                     GET_MANAGER_BY_ID)) {

            statement.setInt(1, managerId);
            try (ResultSet resultSet = statement.executeQuery()) {

                if (resultSet.next()) {
                    result = new Manager(
                            managerId,
                            resultSet.getString(EMAIL),
                            resultSet.getString(NAME));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    public static List<User> loadUsersForAdmin() {
        List<User> result = new ArrayList<>();
        try (Connection connection = MysqlConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(
                     GET_USERS)) {

            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    result.add(new User(
                            resultSet.getInt(ID),
                            resultSet.getString(NAME),
                            resultSet.getString(EMAIL),
                            resultSet.getString(PASSWORD),
                            AccessType.valueOf(resultSet.getString(TYPE_OF_ACCESS))));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    public static int editUser(User user) {
        int result = 0;

        try (Connection connection = MysqlConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(
                     EDIT_USER_BY_ID)) {

            statement.setString(1, user.name);
            statement.setString(2, user.email);
            statement.setString(3, user.password);
            statement.setInt(4, user.id);
            result = statement.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    public static int saveNewUser(User user) {
        int result = 0;

        try (Connection connection = MysqlConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(
                     SAVE_NEW_USER)) {

            statement.setString(1, user.name);
            statement.setString(2, user.email);
            statement.setString(3, user.password);
            statement.setString(4, String.valueOf(user.access));

            result = statement.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    public static int delUserById(int moderId) {
        int result = 0;

        try (Connection connection = MysqlConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(
                     DEL_USER_BY_ID)) {

            statement.setInt(1, moderId);
            result = statement.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }


    public static int editClientsUser(Client client) {
        int result = 0;

        try (Connection connection = MysqlConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(
                     EDIT_CLIENT_BY_ID)) {

            statement.setString(1, client.name);
            statement.setString(2, client.email);
            statement.setInt(3, client.userId);
            result = statement.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

}