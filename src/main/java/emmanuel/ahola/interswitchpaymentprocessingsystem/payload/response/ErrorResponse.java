package david.abejirin.payload.response;

import lombok.Data;

import java.time.Instant;
import java.util.Map;

@Data
public class ErrorResponse {
    private final String code;
    private final String message;
    private final Instant timestamp;
    private final Map<String, String> details;

    public ErrorResponse(String code, String message) {
        this(code, message, null);
    }

    public ErrorResponse(String code, String message, Map<String, String> details) {
        this.code = code;
        this.message = message;
        this.timestamp = Instant.now();
        this.details = details;
    }
}
