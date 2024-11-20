package kodlama.io.rentACarApp.core.utilities.exceptions;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ProblemDetails { //Spesifik hatalar ile ilgili ayrı subclasslar açılabilir. Örn: ValidationProblemDetails
	
	//Uzun hata mesajları yerine son kullanıcıya gösterilecek hata mesajları.
	private String message;

}
