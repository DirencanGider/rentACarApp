package kodlama.io.rentACarApp.business.responses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class GetAllModelsResponse {  //Model responseları için DTO class'ımız
	
	private int id;
	private String name;
	private String brandName; //Normalde ilişkiye göre oluşan tablo brand_id fakat biz name getirmek istiyoruz. Join kullanacağız.

}
