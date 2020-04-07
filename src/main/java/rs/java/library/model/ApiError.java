package rs.java.library.model;

import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ApiError {

    private HttpStatus status;
    private String localDateTime;
    private String message;

    public ApiError() {
    }

    public ApiError(HttpStatus status, String message) {
        this.status = status;
        this.message = message;
        localDateTime = getLocalDateTime();
    }

    private String getLocalDateTime(){
        LocalDateTime localDateTime = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        return formatter.format(localDateTime);
    }

}
