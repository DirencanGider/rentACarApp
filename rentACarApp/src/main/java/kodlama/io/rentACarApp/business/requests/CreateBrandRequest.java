package kodlama.io.rentACarApp.business.requests;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CreateBrandRequest {
	
	@NotNull //Required olmasını istiyoruz
	@NotBlank //Boşluk olmasını istemiyoruz
	@Size(min = 3, max = 20)
	//Validation anotasyonlarının devreye girebilmesi için Controller'da metod içerisine @Valid anotasyonunu eklemeyi unutmuyoruz.
	private String name;

}
