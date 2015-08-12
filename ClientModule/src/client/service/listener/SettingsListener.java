package client.service.listener;


import commons.info.Props;
import commons.service.ConnectionProps;

public class SettingsListener {


    public static void loadSettings(Props props) {
        ConnectionProps.setConnectionProps(
                props.host,
                String.valueOf(props.port),
                String.valueOf(props.clientsCount));

        ConnectionProps.setDBConnectionProps(
                props.user,
                props.password,
                props.dbUrl);
    }
}
