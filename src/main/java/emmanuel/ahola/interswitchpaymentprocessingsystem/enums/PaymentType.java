package david.abejirin.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum PaymentType {
    CREDIT_CARD,
    DEBIT_CARD,
    BANK_TRANSFER;


    @JsonCreator
    public static PaymentType jsonDecode(final String status){
        return valueOf(status);
    }

    @JsonValue
    public String jsonEncode(){
        return name();
    }



}
