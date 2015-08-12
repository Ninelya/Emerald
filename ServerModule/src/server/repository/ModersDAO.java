package server.repository;


import server.service.MysqlConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ModersDAO {

    static final String TABLE = "moders";
    static final String ID = "id";
    static final String USER_ID = "user_id";

    private static final String DEL_MODER_BY_CLIENT_ID =
            "DELETE " +
                    "FROM " + TABLE +
                    " WHERE " + USER_ID +
                    " = ?";

    private static final String SAVE_NEW_MODER =
            "INSERT INTO " + TABLE +
                    " SET " +
                    USER_ID + " = ?";

    private static final String GET_MANAGER_ID_BY_EMAIL =
            "SELECT " + ID +
                    " FROM " + TABLE +
                    " WHERE " +
                    USER_ID + " = " +
                    "(" + UsersDAO.GET_USER_ID_BY_LOGIN + ")";

    private static final String GET_MANAGER_ID_BY_ID =
            "SELECT " + ID +
                    " FROM " + TABLE +
                    " WHERE " + USER_ID +
                    " = ?";

    public static int delModerByClient(int clientId) {
        int result = 0;

        try (Connection connection = MysqlConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(
                     DEL_MODER_BY_CLIENT_ID)) {

            statement.setInt(1, clientId);
            result = statement.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    public static int saveNewModer(int userId) {
        int result = 0;

        try (Connection connection = MysqlConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(
                     SAVE_NEW_MODER)) {

            statement.setInt(1, userId);
            result = statement.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    public static int getManagerIdByEmail(String newManagerEmail) {
        int result = 0;

        try (Connection connection = MysqlConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(
                     GET_MANAGER_ID_BY_EMAIL)) {
            statement.setString(1, newManagerEmail);

            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next())
                    result = resultSet.getInt(ID);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    public static int getManagerIdById(int userId) {
        int result = 0;

        try (Connection connection = MysqlConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(
                     GET_MANAGER_ID_BY_ID)) {
            statement.setInt(1, userId);

            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next())
                    result = resultSet.getInt(ID);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
}
