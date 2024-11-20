package kodlama.io.rentACarApp.business.responses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class GetAllBrandsResponse { //Brand responseları için DTO class'ımız
	
	private int id;
	private String name;

}
