package commons.commands.payment;

import commons.commands.support.Respond;
import commons.commands.support.RespondType;
import commons.info.Payment;

import java.io.Serializable;

public class RespSavePayment implements Respond, Serializable {
    private static final RespondType type = RespondType.RET_SAVE_PAYMENT;

    public final Payment payment;
    public final boolean isConfirmed;

    public RespSavePayment(boolean isConfirmed, Payment payment) {
        this.payment = payment;
        this.isConfirmed = isConfirmed;
    }

    @Override
    public RespondType getType() {
        return type;
    }
}