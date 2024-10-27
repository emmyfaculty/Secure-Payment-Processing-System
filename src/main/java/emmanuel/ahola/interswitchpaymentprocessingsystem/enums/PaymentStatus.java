package david.abejirin.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum PaymentStatus {
    PENDING,
    AUTHORIZED,
    COMPLETED,
    FAILED,
    REFUNDED;
    @JsonCreator
    public static PaymentStatus jsonDecode(final String status){
        return valueOf(status);
    }

    @JsonValue
    public String jsonEncode(){
        return name();
    }
}
