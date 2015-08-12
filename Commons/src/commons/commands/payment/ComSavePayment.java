package commons.commands.payment;

import commons.commands.support.Command;
import commons.commands.support.CommandType;
import commons.info.Payment;

import java.io.Serializable;

public class ComSavePayment implements Command, Serializable {
    private static final CommandType type = CommandType.SAVE_PAYMENT;

    public final Payment newPayment;

    public ComSavePayment(Payment newPayment) {
        this.newPayment = newPayment;
    }

    @Override
    public CommandType getType() {
        return type;
    }
}
