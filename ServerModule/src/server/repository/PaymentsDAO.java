package server.repository;

import commons.info.Credit;
import commons.info.Payment;
import server.service.MysqlConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class PaymentsDAO {
    private static final String TABLE = "payments";
    private static final String ID = "id";
    private static final String CREDIT_ID = "credit_id";
    private static final String PENALTY = "penalty";
    private static final String SUM = "sum";
    private static final String DATE = "date";

    private static final String GET_PAYMENTS_BY_CREDIT_ID =
            "SELECT *" +
                    " FROM " + TABLE +
                    " WHERE " + CREDIT_ID +
                    " = ?";

    private static final String SAVE_NEW_PAYMENT =
            "INSERT INTO " + TABLE +
                    " SET " +
                    CREDIT_ID + " = ?, " +
                    SUM + " = ?, " +
                    PENALTY + " = ?, " +
                    DATE + " = NOW() ";


    public static List<Payment> getPaymentsByCredit(Credit credit) {
        ArrayList<Payment> result = new ArrayList<>();

        try (Connection connection = MysqlConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(
                     GET_PAYMENTS_BY_CREDIT_ID)) {

            statement.setInt(1, credit.id);
            try (ResultSet resultSet = statement.executeQuery()) {

                while (resultSet.next())
                    result.add(new Payment(
                            resultSet.getInt(ID),
                            resultSet.getDate(DATE),
                            resultSet.getFloat(SUM),
                            resultSet.getFloat(PENALTY),
                            credit));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    public static int savePayment(Payment newPayment) {
        int result = 0;

        try (Connection connection = MysqlConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(
                     SAVE_NEW_PAYMENT)) {

            statement.setInt(1, newPayment.credit.id);
            statement.setFloat(2, newPayment.sum);
            statement.setFloat(3, newPayment.penalty);

            result = statement.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    public static Payment getLastPaymentByCreditId(int id) {
        Payment result = null;

        try (Connection connection = MysqlConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(
                     GET_PAYMENTS_BY_CREDIT_ID)) {

            statement.setInt(1, id);
            try (ResultSet resultSet = statement.executeQuery()) {

                //Date time = new Date(1);
                while (resultSet.next())
                    //if (resultSet.getDate(DATE).after(time))
                    result = new Payment(
                            resultSet.getInt(ID),
                            resultSet.getDate(DATE),
                            resultSet.getFloat(SUM),
                            resultSet.getFloat(PENALTY),
                            null);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
}
