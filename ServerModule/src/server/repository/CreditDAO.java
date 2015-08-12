package server.repository;


import commons.info.Credit;
import commons.info.Request;
import server.service.MysqlConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class CreditDAO {
    private static final String TABLE = "credits";
    private static final String ID = "id";
    private static final String REQUEST_ID = "request_id";
    private static final String PAYED_OFF = "payed_off";
    private static final String APPROVAL_DATE = "date_app";
    private static final String DATE_PAYED = "date_payed";
    private static final String PERCENT = "percent";

    private static final String SAVE_NEW_CREDIT =
            "INSERT INTO " + TABLE +
                    " SET " +
                    REQUEST_ID + " = ?," +
                    PERCENT + " = ?," +
                    APPROVAL_DATE + " = NOW()";

    private static final String GET_CREDIT_BY_REQUEST_ID =
            "SELECT *" +
                    " FROM " + TABLE +
                    " LEFT JOIN " + RequestsDAO.TABLE + " ON " +
                    RequestsDAO.TABLE + "." + RequestsDAO.ID + " = " +
                    TABLE + "." + REQUEST_ID +
                    " WHERE " + REQUEST_ID +
                    " = ?";

    public static Credit getCreditByRequestId(int requestId) {
        Credit result = null;

        try (Connection connection = MysqlConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(
                     GET_CREDIT_BY_REQUEST_ID)) {

            statement.setInt(1, requestId);

            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    boolean payedOff = resultSet.getBoolean(PAYED_OFF);

                    result = new Credit(
                            resultSet.getInt(ID),
                            resultSet.getInt(REQUEST_ID),
                            resultSet.getFloat(RequestsDAO.SUM),
                            payedOff,
                            new java.util.Date(resultSet.getTimestamp(APPROVAL_DATE).getTime()),
                            !payedOff ? null : new java.util.Date(resultSet.getTimestamp(DATE_PAYED).getTime()),
                            resultSet.getFloat(PERCENT)
                    );
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    public static int createCredit(Request request) {
        int result = 0;

        try (Connection connection = MysqlConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(
                     SAVE_NEW_CREDIT)) {

            statement.setInt(1, request.id);
            statement.setFloat(2, request.getPercent());
            statement.setFloat(3, request.sum + request.getPercent());

            result = statement.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
}