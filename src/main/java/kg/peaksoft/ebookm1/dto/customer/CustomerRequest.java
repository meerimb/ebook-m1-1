package kg.peaksoft.ebookm1.dto.customer;


import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class CustomerRequest {
    private String firstName;
    private String lastName;
    private String email;
    private String password;
}
