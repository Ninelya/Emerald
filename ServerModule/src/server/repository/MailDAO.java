package server.repository;


import commons.info.Mail;
import server.service.MysqlConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class MailDAO {
    private static final String TABLE = "mail";
    private static final String ID = "id";
    private static final String CLIENT_ID = "client_id";
    private static final String SENT_TIME = "sent_time";
    private static final String STATUS = "status";
    private static final String STATUS_PENDING = "'pending'";
    private static final String STATUS_QUESTION = "'question'";
    private static final String STATUS_ANSWER = "'answer'";
    private static final String TEXT = "text";

    private static final String SAVE_MAIL_FROM_CLIENT =
            "INSERT INTO " + TABLE +
                    " SET " +
                    CLIENT_ID + " = ?, " +
                    TEXT + " = ?, " +
                    SENT_TIME + " = NOW(), " +
                    STATUS + " = " + STATUS_PENDING;

    private static final String SAVE_MAIL_FROM_MANAGER =
            "INSERT INTO " + TABLE +
                    " SET " +
                    CLIENT_ID + " = ?, " +
                    TEXT + " = ?, " +
                    SENT_TIME + " = NOW(), " +
                    STATUS + " = " + STATUS_ANSWER;

    private static final String GET_MAIL_BY_CLIENT_ID =
            "SELECT *" +
                    " FROM " + TABLE +
                    " WHERE " + CLIENT_ID +
                    " = ?";

    private static final String SET_MAIL_STATUS_TO_QUESTION =
            "UPDATE " + TABLE +
                    " SET " +
                    STATUS + " = " + STATUS_QUESTION +
                    " WHERE " + ID +
                    " = ?";


    public static int saveMailFromClient(Mail newMail) {
        int result = 0;

        try (Connection connection = MysqlConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(
                     SAVE_MAIL_FROM_CLIENT)) {

            statement.setInt(1, newMail.clientId);
            statement.setString(2, newMail.text);

            result = statement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return result;
    }

    public static ArrayList<Mail> getMailByClientId(int id) {
        ArrayList<Mail> result = new ArrayList<>();

        try (Connection connection = MysqlConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(
                     GET_MAIL_BY_CLIENT_ID)) {

            statement.setInt(1, id);
            try (ResultSet resultSet = statement.executeQuery()) {

                while (resultSet.next())
                    result.add(new Mail(
                            resultSet.getInt(ID),
                            resultSet.getInt(CLIENT_ID),
                            resultSet.getDate(SENT_TIME),
                            resultSet.getString(STATUS),
                            resultSet.getString(TEXT)));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    public static Mail getLastMailByClientId(int clientId) {
        Mail result = null;

        try (Connection connection = MysqlConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(
                     GET_MAIL_BY_CLIENT_ID)) {

            statement.setInt(1, clientId);
            try (ResultSet resultSet = statement.executeQuery()) {

                //Date time = new Date(1);
                while (resultSet.next())
                    //if (resultSet.getDate(SENT_TIME).after(time))
                    result = new Mail(
                            resultSet.getInt(ID),
                            resultSet.getInt(CLIENT_ID),
                            resultSet.getDate(SENT_TIME),
                            resultSet.getString(STATUS),
                            resultSet.getString(TEXT)
                    );
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    public static int saveMailFromManager(Mail newMail) {
        int result = 0;

        try (Connection connection = MysqlConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(
                     SAVE_MAIL_FROM_MANAGER)) {

            statement.setInt(1, newMail.clientId);
            statement.setString(2, newMail.text);

            result = statement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return result;
    }

    public static int setMailStatusToQuestion(int letter_id) {
        int result = 0;

        try (Connection connection = MysqlConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(
                     SET_MAIL_STATUS_TO_QUESTION)) {

            statement.setInt(1, letter_id);

            result = statement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
}