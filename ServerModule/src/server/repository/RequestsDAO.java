package server.repository;


import commons.info.Request;
import commons.info.status.RequestStatus;
import server.service.MysqlConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class RequestsDAO {
    static final String TABLE = "requests";
    static final String ID = "id";
    static final String CLIENT_ID = "client_id";
    private static final String TARIFF_ID = "tariff_id";
    static final String SUM = "sum";
    private static final String STATUS = "status";
    private static final String STATUS_PENDING = "pending";
    private static final String STATUS_APPROVED = "'approved'";
    private static final String STATUS_DENIED = "'denied'";
    private static final String DATE_OF_CREATION = "create_date";
    private static final String REASON_OF_DENY = "deny_reason";

    private static final String SAVE_NEW_REQUEST =
            "INSERT INTO " + TABLE +
                    " SET " +
                    CLIENT_ID + " = ?, " +
                    TARIFF_ID + " = ?, " +
                    SUM + " = ?, " +
                    DATE_OF_CREATION + " = NOW()";

    private static final String SET_APPROVE_STATUS =
            "UPDATE " + TABLE +
                    " SET " +
                    STATUS + " = " + STATUS_APPROVED +
                    " WHERE " + ID + " = ?";

    private static final String SET_DENIED_STATUS =
            "UPDATE " + TABLE +
                    " SET " +
                    STATUS + " = " + STATUS_DENIED + ", " +
                    REASON_OF_DENY + " = ?" +
                    " WHERE " + ID + " = ?";

    private static final String GET_REQUEST_BY_IDS =
            "SELECT *" +
                    " FROM " + TABLE +
                    " LEFT JOIN " + ClientsDAO.TABLE + " ON " +
                    ClientsDAO.TABLE + "." + ClientsDAO.ID + " = " +
                    TABLE + "." + CLIENT_ID +
                    " WHERE " + CLIENT_ID + " = ?" +
                    " AND " + TARIFF_ID + " = ?";

    private static final String GET_REQUESTS_BY_CLIENT =
            "SELECT *" +
                    " FROM " + TABLE +
                    " LEFT JOIN " + ClientsDAO.TABLE + " ON " +
                    ClientsDAO.TABLE + "." + ClientsDAO.ID + " = " +
                    TABLE + "." + CLIENT_ID +
                    " WHERE " + CLIENT_ID + " = ?";


    public static List<Request> getRequestsByClientId(int id) {
        List<Request> result = new ArrayList<>();
        try (Connection connection = MysqlConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(
                     GET_REQUESTS_BY_CLIENT)) {

            statement.setInt(1, id);
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    result.add(new Request(
                            resultSet.getInt(ID),
                            resultSet.getInt(CLIENT_ID),
                            resultSet.getInt(TARIFF_ID),
                            resultSet.getFloat(SUM),
                            resultSet.getInt(ClientsDAO.INCOMING),
                            resultSet.getBoolean(ClientsDAO.GUARANTEE),
                            RequestStatus.valueOf(resultSet.getString(STATUS)),
                            resultSet.getDate(DATE_OF_CREATION),
                            resultSet.getString(REASON_OF_DENY)));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    public static int setDenyStatusById(int requestId, String denyReason) {
        int result = 0;
        try (Connection connection = MysqlConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(
                     SET_DENIED_STATUS)) {

            statement.setString(1, denyReason);
            statement.setInt(2, requestId);
            result = statement.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    public static int setApproveStatusById(int requestId) {
        int result = 0;
        try (Connection connection = MysqlConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(
                     SET_APPROVE_STATUS)) {

            statement.setInt(1, requestId);
            result = statement.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    public static Request getRequestByIds(int clientId, int creditId) {
        Request result = null;
        try (Connection connection = MysqlConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(
                     GET_REQUEST_BY_IDS)) {

            statement.setInt(1, clientId);
            statement.setInt(2, creditId);
            try (ResultSet resultSet = statement.executeQuery()) {

                if (resultSet.next()) {
                    result = new Request(
                            resultSet.getInt(ID),
                            resultSet.getInt(CLIENT_ID),
                            resultSet.getInt(TARIFF_ID),
                            resultSet.getFloat(SUM),
                            resultSet.getInt(ClientsDAO.INCOMING),
                            resultSet.getBoolean(ClientsDAO.GUARANTEE),
                            RequestStatus.valueOf(resultSet.getString(STATUS)),
                            resultSet.getDate(DATE_OF_CREATION),
                            resultSet.getString(REASON_OF_DENY));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    public static int saveRequest(Request newRequest) {
        int result = 0;
        try (Connection connection = MysqlConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(
                     SAVE_NEW_REQUEST)) {

            statement.setInt(1, newRequest.clientId);
            statement.setInt(2, newRequest.tariffId);
            statement.setFloat(3, newRequest.sum);

            if (getRequestByIds(newRequest.clientId, newRequest.tariffId) == null)
                result = statement.executeUpdate();
            else
                result = -1;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
}