package kodlama.io.rentACarApp.business.requests;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UpdateBrandRequest {
	
	private int id;
	private String name;

}
