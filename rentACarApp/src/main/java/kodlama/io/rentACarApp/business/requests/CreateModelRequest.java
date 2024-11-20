package kodlama.io.rentACarApp.business.requests;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class CreateModelRequest {
	
	@NotNull
	@NotBlank
	@Size(min= 3, max= 20)
	private String name;
	
	private int brandId; //Model oluştururken Brand Id gerekli. Çünkü ilişki mevcut.
	
}
