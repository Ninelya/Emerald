package server.repository;


import commons.info.Tariff;
import server.service.MysqlConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class TariffsDAO {
    private static final String TABLE = "tariffs";
    private static final String ID = "id";
    private static final String MIN_SUM = "min_sum";
    private static final String MAX_SUM = "max_sum";
    private static final String RATE = "rate";
    private static final String TERM = "term_month";
    private static final String CONDITIONS = "condit";
    private static final String NAME = "name";
    private static final String IS_ACTIVE = "is_active";

    private static final String GET_CREDIT_PROGRAMS =
            "SELECT *" +
                    " FROM " + TABLE;

    private static final String GET_TARIFF_BY_NAME =
            "SELECT *" +
                    " FROM " + TABLE +
                    " WHERE " + NAME +
                    " = ?";

    private static final String DEL_TARIFF_BY_ID =
            "UPDATE " + TABLE +
                    " SET " +
                    IS_ACTIVE + " = " + false +
                    " WHERE " + ID +
                    " = ?";

    private static final String EDIT_TARIFF_BY_ID =
            "UPDATE " + TABLE +
                    " SET " +
                    NAME + " = ?, " +
                    MIN_SUM + " = ?, " +
                    MAX_SUM + " = ?, " +
                    RATE + " = ?, " +
                    TERM + " = ?, " +
                    CONDITIONS + " = ? " +
                    " WHERE " + ID +
                    " = ?";

    private static final String SAVE_TARIFF =
            "INSERT INTO " + TABLE +
                    " SET " +
                    NAME + " = ?, " +
                    MIN_SUM + " = ?, " +
                    MAX_SUM + " = ?, " +
                    RATE + " = ?, " +
                    TERM + " = ?, " +
                    CONDITIONS + " = ?";

    public static int delTariff(int id) {
        int result = 0;

        try (Connection connection = MysqlConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(
                     DEL_TARIFF_BY_ID)) {

            statement.setInt(1, id);
            result = statement.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    public static int editTariff(Tariff tariff) {
        int result = 0;

        try (Connection connection = MysqlConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(
                     EDIT_TARIFF_BY_ID)) {

            statement.setString(1, tariff.name);
            statement.setFloat(2, tariff.minSum);
            statement.setFloat(3, tariff.maxSum);
            statement.setInt(4, tariff.rate);
            statement.setInt(5, tariff.termMonth);
            statement.setString(6, tariff.conditions);
            statement.setInt(7, tariff.id);
            result = statement.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    public static List<Tariff> getTariffs() {
        List<Tariff> result = new ArrayList<>();

        try (Connection connection = MysqlConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(
                     GET_CREDIT_PROGRAMS);
             ResultSet resultSet = statement.executeQuery()) {

            while (resultSet.next()) {
                result.add(new Tariff(
                        resultSet.getInt(ID),
                        resultSet.getString(NAME),
                        resultSet.getFloat(MIN_SUM),
                        resultSet.getFloat(MAX_SUM),
                        resultSet.getInt(RATE),
                        resultSet.getInt(TERM),
                        resultSet.getString(CONDITIONS),
                        resultSet.getBoolean(IS_ACTIVE)
                ));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    public static int saveNewTariff(Tariff tariff) {
        int result = 0;

        try (Connection connection = MysqlConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(
                     SAVE_TARIFF)) {

            statement.setString(1, tariff.name);
            statement.setFloat(2, tariff.minSum);
            statement.setFloat(3, tariff.maxSum);
            statement.setInt(4, tariff.rate);
            statement.setInt(5, tariff.termMonth);
            statement.setString(6, tariff.conditions);

            result = statement.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    public static Tariff getTariffByName(String name) {
        Tariff result = null;

        try (Connection connection = MysqlConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(
                     GET_TARIFF_BY_NAME)) {
            statement.setString(1, name);
            try (ResultSet resultSet = statement.executeQuery()) {

                if (resultSet.next()) {
                    result = new Tariff(
                            resultSet.getInt(ID),
                            resultSet.getString(NAME),
                            resultSet.getFloat(MIN_SUM),
                            resultSet.getFloat(MAX_SUM),
                            resultSet.getInt(RATE),
                            resultSet.getInt(TERM),
                            resultSet.getString(CONDITIONS),
                            resultSet.getBoolean(IS_ACTIVE)
                    );
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
}