package kodlama.io.rentACarApp.business.abstracts;

import java.util.List;

import kodlama.io.rentACarApp.business.requests.CreateBrandRequest;
import kodlama.io.rentACarApp.business.requests.UpdateBrandRequest;
import kodlama.io.rentACarApp.business.responses.GetAllBrandsResponse;
import kodlama.io.rentACarApp.business.responses.GetByIdResponse;

public interface BrandService {
	
	List<GetAllBrandsResponse> getAll();
	
	GetByIdResponse getById(int id);
	
	void add (CreateBrandRequest createBrandRequest);
	
	void update(UpdateBrandRequest updateBrandRequest);
	
	void delete(int id);

}
