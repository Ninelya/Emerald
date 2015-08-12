package commons.view;

import java.util.Locale;
import java.util.PropertyResourceBundle;
import java.util.ResourceBundle;

public class Text {

    private static final String BUNDLE_NAME = "text";
    private static final Locale LOCALE_UKR = new Locale("uk");
    private static final Locale LOCALE_RUS = new Locale("ru");
    private static final Locale LOCALE_ENG = new Locale("en", "GB");

    public static ResourceBundle bundle = getBundle(LOCALE_UKR);


    public static void setBundle(int localeIndex) {
        ResourceBundle.clearCache();
        switch (localeIndex) {
            case FrontEnd.COMBO_ITEM_1:
                bundle = getBundle(LOCALE_UKR);
                break;
            case FrontEnd.COMBO_ITEM_2:
                bundle = getBundle(LOCALE_RUS);
                break;
            case FrontEnd.COMBO_ITEM_3:
                bundle = getBundle(LOCALE_ENG);
                break;
            default:
                break;
        }
    }

    private static ResourceBundle getBundle(Locale locale) {
        Locale.setDefault(locale);

        return PropertyResourceBundle.getBundle(BUNDLE_NAME);
    }

    public static String setMonth(int term_month) {
        switch (term_month % 10) {
            case 1:
                return bundle.getString(MONTH_ONE);
            case 2:
            case 3:
            case 4:
                return bundle.getString(MONTH_SEV);
            default:
                return bundle.getString(MONTH_LOT);
        }
    }

    public static String setYear(int term_years) {
        switch (term_years % 10) {
            case 1:
                return bundle.getString(YEAR_ONE);
            case 2:
            case 3:
            case 4:
                return bundle.getString(YEAR_SEV);
            default:
                return bundle.getString(YEAR_LOT);
        }
    }

    //Frame Title
    public static final String EMERALD_SERVER = "emerald.server";
    public static final String EMERALD = "emerald.name";

    //Buttons
    public static final String BUTTON_MAIN = "button.41.main";
    public static final String BUTTON_ENTER = "button.41.enter";

    public static final String BUTTON_LOGOFF = "button.42.logoff";
    public static final String BUTTON_WRITE_MANAGER = "button.42.write_manager";
    public static final String BUTTON_PROFILE = "button.42.profile";

    public static final String BUTTON_MAIL = "button.43.mail";
    public static final String BUTTON_MY_CLIENTS = "button.43.my_clients";
    public static final String BUTTON_NEW_CLIENT = "button.43.new_client";
    public static final String BUTTON_REQUESTS = "button.43.requests";

    public static final String BUTTON_NEW_TARIFF = "button.44.new_tariff";

    public static final String BUTTON_USERS = "button.45.users";
    public static final String BUTTON_NEW_MODER = "button.45.new_moder";
    public static final String BUTTON_SYSTEM = "button.45.system";

    public static final String BUTTON_MORE = "button.tariff.more";
    public static final String BUTTON_GET = "button.tariff.get";
    public static final String BUTTON_EDIT = "button.tariff.edit";
    public static final String BUTTON_DELETE = "button.tariff.delete";
    public static final String BUTTON_SAVE = "button.tariff.save";

    public static final String BUTTON_CREDITS = "button.client.credits";
    public static final String BUTTON_SEARCH = "button.client.search";

    public static final String BUTTON_SEND = "button.request.send";
    public static final String BUTTON_PROGRAM = "button.request.program";
    public static final String BUTTON_APPROVE = "button.request.approve";
    public static final String BUTTON_DENY = "button.request.deny";

    public static final String BUTTON_REQUEST = "button.history.request";
    public static final String BUTTON_PAYMENT = "button.history.payment";

    public static final String BUTTON_DOWN = "button.mail.down";
    public static final String BUTTON_UP = "button.mail.up";
    public static final String BUTTON_MORE_LETTERS = "button.mail.more";

    public static final String BUTTON_SETTINGS_DEFAULT = "button.settings.restore";

    public static final String BUTTON_PAY = "button.payments.pay";
    public static final String BUTTON_CREDIT = "button.payments.credit";

    //Dialogs
    public static final String CONFIRM_REQUEST = "dialog.confirm.request";
    public static final String CONFIRM_CHANGE = "dialog.confirm.change";
    public static final String CONFIRM_DELETION = "dialog.confirm.deletion";
    public static final String CONFIRM_SETTINGS = "dialog.confirm.settings";

    public static final String ARE_YOU_SURE_REQUEST = "dialog.are_you_sure.request";
    public static final String ARE_YOU_SURE_CLIENT_ACCESS = "dialog.are_you_sure.client_access";
    public static final String ARE_YOU_SURE_TARIFF = "dialog.are_you_sure.tariff";
    public static final String ARE_YOU_SURE_MODER = "dialog.are_you_sure.moder";
    public static final String ARE_YOU_SURE_CLIENT = "dialog.are_you_sure.client";
    public static final String ARE_YOU_SURE_SETTINGS = "dialog.are_you_sure.settings";

    public static final String ENTER_LOGIN_AND_PASS = "dialog.enter.login_and_pass";
    public static final String ENTER_WISHED_SUM = "dialog.enter.wished_sum";
    public static final String ENTER_CLIENT_NAME = "dialog.enter.client_name";
    public static final String ENTER_ALL_FIELDS = "dialog.enter.all_fields";
    public static final String ENTER_DENY_REASON = "dialog.enter.deny_reason";
    public static final String ENTER_NEW_MODER = "dialog.enter.new_moder";

    public static final String FAILED_PASSWORD = "dialog.failed.password";
    public static final String FAILED_CONNECTION = "dialog.failed.connection";

    public static final String TARIFF_DELETED_SUCCESSFULLY = "dialog.tariff.deleted_successfully";
    public static final String TARIFF_IS_NOT_DELETED = "dialog.tariff.is_not_deleted";
    public static final String TARIFF_SAVED_SUCCESSFULLY = "dialog.tariff.saved_successfully";
    public static final String TARIFF_IS_NOT_SAVED = "dialog.tariff.is_not_saved";

    public static final String REQUEST_IS_ACCEPTED = "dialog.request.is_accepted";
    public static final String REQUEST_IS_NOT_ACCEPTED = "dialog.request.is_not_accepted";
    public static final String REQUEST_ALREADY_EXISTS = "dialog.request.already_exists";
    public static final String REQUEST_APPROVED = "dialog.request.approved";
    public static final String REQUEST_IS_NOT_APPROVED = "dialog.request.is_not_approved";
    public static final String REQUEST_DENIED = "dialog.request.denied";
    public static final String REQUEST_IS_NOT_DENIED = "dialog.request.is_not_denied";

    public static final String MAIL_IS_ACCEPTED = "dialog.mail.is_accepted";
    public static final String MAIL_IS_NOT_ACCEPTED = "dialog.mail.is_not_accepted";
    public static final String MAIL_ANSWER_IS_ACCEPTED = "dialog.mail.answer_is_accepted";

    public static final String EDIT_BAN_ADMIN = "dialog.edit_ban.admin";
    public static final String EDIT_BAN_CREATE_CLIENT = "dialog.edit_ban.create_client";
    public static final String EDIT_BAN_DELETE_CLIENT = "dialog.edit_ban.delete_client";

    public static final String USER_EDITED_SUCCESSFULLY = "dialog.user.edited_successfully";
    public static final String USER_IS_NOT_EDITED = "dialog.user.is_not_edited";

    public static final String MODER_SAVED_SUCCESSFULLY = "dialog.moder.saved_successfully";
    public static final String MODER_IS_NOT_SAVED = "dialog.moder.is_not_saved";
    public static final String MODER_DELETED_SUCCESSFULLY = "dialog.moder.deleted_successfully";
    public static final String MODER_IS_NOT_DELETED = "dialog.moder.is_not_deleted";

    public static final String CLIENT_SAVED_SUCCESSFULLY = "dialog.client.saved_successfully";
    public static final String CLIENT_IS_NOT_SAVED = "dialog.client.is_not_saved";
    public static final String CLIENT_EDITED_SUCCESSFULLY = "dialog.client.edited_successfully";
    public static final String CLIENT_IS_NOT_EDITED = "dialog.client.is_not_edited";

    public static final String PAYMENT_SAVED_SUCCESSFULLY = "dialog.payment.saved_successfully";
    public static final String PAYMENT_IS_NOT_SAVED = "dialog.payment.is_not_saved";

    //Titles
    public static final String CLIENT_NEW = "title.client.new";
    public static final String CLIENT_EDIT = "title.client.edit";
    public static final String CLIENT_LIST = "title.client.list";

    public static final String REQUESTS_UNDONE = "title.request.undone";
    public static final String REQUEST_LIST = "title.request.list";
    public static final String REQUEST_EXPAND = "title.request.expand";

    public static final String CREDIT_ORDER = "title.credit.order";
    public static final String CREDIT_APPROVE = "title.credit.approve";
    public static final String CREDIT_HISTORY = "title.credit.history";
    public static final String CREDIT_INFO = "title.credit.info";

    public static final String MAIL_TO_MANAGER = "title.mail.to_manager";
    public static final String MAIL_TO_CLIENT = "title.mail.to_client";
    public static final String MAIL_LIST = "title.mail.list";

    public static final String TARIFF_LIST = "title.tariff.list";
    public static final String TARIFF_PROGRAM = "title.tariff.program";
    public static final String TARIFF_EDIT = "title.tariff.edit";
    public static final String TARIFF_NEW = "title.tariff.new";

    public static final String USER_LIST = "title.user.list";
    public static final String USER_NEW = "title.user.new";
    public static final String USER_EDIT = "title.user.edit";

    public static final String SETTINGS_EDIT = "title.settings.edit";
    public static final String PAYMENTS = "title.payments";

    //Combo Boxes
    public static final String LANG_TITLE = "combo.lang.title";
    public static final String LANG_UKR = "combo.lang.ukr";
    public static final String LANG_RUS = "combo.lang.rus";
    public static final String LANG_ENG = "combo.lang.eng";

    public static final String HISTORY_CLIENT = "combo.history.client";
    public static final String HISTORY_MANAGER = "combo.history.manager";
    public static final String HISTORY_CREDITS = "combo.history.credits";
    public static final String HISTORY_REQUESTS = "combo.history.requests";

    public static final String SORT_TEXT = "combo.sort.text";
    public static final String SORT_NAMES = "combo.sort.names";
    public static final String SORT_REQUESTS = "combo.sort.requests";

    public static final String ACCESS_CLIENT = "combo.access.client";
    public static final String ACCESS_MANAGER = "combo.access.manager";
    public static final String ACCESS_MARKETER = "combo.access.marketer";
    public static final String ACCESS_ADMIN = "combo.access.admin";
    public static final String ACCESS_TYPE = "combo.access.type";
    public static final String ACCESS_ALL = "combo.access.all";

    //Common
    public static final String FROM = "common.from";
    public static final String TO = "common.to";
    public static final String HRN = "common.hrn";
    public static final String HRN_MONTHLY = "common.hrn_monthly";
    public static final String PERCENT_SIGN = "common.percent_sign";
    public static final String QUOTE_LEFT = "common.quote.left";
    public static final String QUOTE_RIGHT = "common.quote.right";
    public static final String DASH = "common.dash";

    public static final String MONTH_NEUTRAL = "common.month.neutral";
    private static final String MONTH_ONE = "common.month.one";
    private static final String MONTH_SEV = "common.month.sev";
    private static final String MONTH_LOT = "common.month.lot";

    private static final String YEAR_ONE = "common.year.one";
    private static final String YEAR_SEV = "common.year.sev";
    private static final String YEAR_LOT = "common.year.lot";

    //Menu Log Off + Menu Client
    public static final String LOGIN = "menu.login";
    public static final String PASSWORD = "menu.password";
    public static final String TOTAL_DEBT = "menu.total_debt";

    //Tariff Panel
    public static final String PERCENT_RATE = "0.percent_rate";
    public static final String CREDIT_TERM = "0.credit_term";
    public static final String CREDIT_SUM = "0.credit_sum";
    public static final String CREDIT_INACTIVE = "0.credit_inactive";

    //Tariff Edit
    public static final String TARIFF_NAME = "21.tariff_name";
    public static final String MIN_CREDIT_SUM = "21.min_credit_sum";
    public static final String MAX_CREDIT_SUM = "21.max_credit_sum";
    public static final String EXTRA_CONDITIONS = "21.extra_conditions";
    public static final String FULL_DESCRIPTION = "21.full_description";

    //Clients Panel
    public static final String CLIENT_EMAIL = "11.client_email";
    public static final String CLIENT_TEL = "11.client_tel";
    public static final String CLIENT_FULL_NAME = "11.client_full_name";
    public static final String SEARCH_BY_FIRST_NAME = "11.search_by_first_name";
    public static final String REQUESTS_COUNT = "11.requests_count";
    public static final String CLIENT_TEXT = "11.head_client";

    //Clients Expand
    public static final String CLIENT_ADDRESS = "1.client_address";
    public static final String CLIENT_GUARANTEE = "1.client_guarantee";
    public static final String CLIENT_INCOME = "1.client_income";
    public static final String CLIENT_MANAGER = "1.client_manager";
    public static final String CLIENT_INN = "1.client_inn";
    public static final String CLIENT_BIRTH_YEAR = "1.client_birth_year";
    public static final String CLIENT_WITH_EMERALD = "1.client_with_emerald";
    public static final String CLIENT_FIRST_YEAR = "1.client_first_year";
    public static final String CLIENT_SENIORITY = "1.client_seniority";
    public static final String CLIENT_IS_STUDENT = "1.client_is_student";

    //Request new
    public static final String CUSTOMER = "6.customer";
    public static final String CREDIT_PROGRAM = "6.credit_program";
    public static final String WANTED_SUM = "6.wanted_sum";
    public static final String AVAILABLE_DISCOUNT = "6.available_discount";
    public static final String RESULTING_PERCENT = "6.resulting_percent";

    //Request for client
    public static final String STATUS = "4.status";
    public static final String DENY_REASON = "4.deny_reason";
    public static final String REQUEST = "4.head_request";
    public static final String DATE_OF_GIVING = "4.date_of_giving";

    //Request approve
    public static final String CONDITIONS = "14.conditions";
    public static final String INCOME = "14.income";
    public static final String GUARANTEE = "14.guarantee";
    public static final String SENIORITY = "14.seniority";
    public static final String OR = "14.or";
    public static final String SEMICOLON = "14.semicolon";
    public static final String DOT = "14.dot";

    //Credit panel
    public static final String CREDIT = "3.head_credit";
    public static final String PERCENT = "3.percent";
    public static final String LEFT_DEBT = "3.left_debt";

    //Credit expand
    public static final String PENALTY = "8.penalty";
    public static final String CREDIT_GIVING_DATE = "8.credit_giving_date";
    public static final String PAYING_FINISH_DATE = "8.paying_finish_date";
    public static final String MONTHS_LATE = "8.months_late";
    public static final String WITHOUT_PENALTY = "8.without_penalty";
    public static final String PAYMENTS_SUM = "8.payment_sum";

    //Mail for client
    public static final String YOUR_MESSAGE = "2.your_message";
    public static final String MANAGER_ANSWER = "2.manager_answer";
    public static final String NEW_CLAIM = "2.new_claim";

    //Mail For Manager
    public static final String NEW_ANSWER = "13.new_answer";
    public static final String CLIENT_CLAIM = "13.client_claim";
    public static final String YOUR_ANSWER = "13.your_answer";

    //Mail New Panel
    public static final String LAST_CLAIM = "16.last_claim";
    public static final String ANSWER = "16.answer";

    //Payments
    public static final String NEW_PAYMENT = "17.new_payment";
    public static final String CURRENT_PENALTY = "17.current_penalty";
    public static final String SUM_TO_PAY = "17.sum_to_pay";
    public static final String PAYMENT_DATE = "17.payment_date";
    public static final String PAYMENT_SUM = "17.payment_sum";
    public static final String PAYMENT_PENALTY = "17.payment_penalty";

    //Moder Panel
    public static final String CLIENT_PASSWORD = "31.client_pass";
    public static final String CLIENT_ACCESS = "31.client_access";
    public static final String USER_TEXT = "31.head_user";
    public static final String NEW_MANAGER = "31.new_manager";

    //SettingsEdit
    public static final String HEAD_CONNECT = "34.head_connect";
    public static final String PORT_NUMBER = "34.port_number";
    public static final String THREAD_COUNT = "34.thread_count";
    public static final String HOST_ADDRESS = "34.host_address";
    public static final String HEAD_DATABASE = "34.head_database";
    public static final String DB_ADDRESS = "34.db_address";
    public static final String DB_LOGIN = "34.db_login";
    public static final String DB_PASSWORD = "34.db_password";
    public static final String TOOLTIP_BTN_RESTORE = "34.tooltip.btn_restore";

    //Never used
    static public final String BUTTON_UNANSWERED_LETTERS = "zz.button.unanswered_letters";
    static public final String BUTTON_ALL_LETTERS = "zz.button.all_letters";
    static public final String BUTTON_CLEAR = "zz.button.clear";
    static public final String BUTTON_SORT_BY_REQUESTS = "zz.button.sort_by_requests";
    static public final String BUTTON_SORT_BY_NAMES = "zz.button.sort_by_names";
    static public final String BUTTON_REFRESH = "zz.button.refresh";
    static public final String BUTTON_BACK = "zz.button.back";
    static public final String DETAILED_DESCRIPTION = "zz.detailed_description";
    static public final String TOPIC = "zz.topic";
    public static final String CLIENT_DELETED_SUCCESSFULLY = "zz.dialog.client.deleted_successfully";
    public static final String CLIENT_IS_NOT_DELETED = "zz.dialog.client.is_not_deleted";
}