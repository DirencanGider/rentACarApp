package kodlama.io.rentACarApp.core.utilities.exceptions;

import java.util.Map;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ValidationProblemDetails extends ProblemDetails {
	
	//Hasmap kullanalım. Hangi alanda (İlk String) ne hatası var (İkinci String) şeklinde.
	private Map<String, String> validationErrors;

}
