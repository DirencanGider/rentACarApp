package kodlama.io.rentACarApp.business.abstracts;

import java.util.List;

import kodlama.io.rentACarApp.business.requests.CreateModelRequest;
import kodlama.io.rentACarApp.business.requests.UpdateModelRequest;
import kodlama.io.rentACarApp.business.responses.GetAllModelsResponse;
import kodlama.io.rentACarApp.business.responses.GetByIdResponse;

public interface ModelService {
	
	List<GetAllModelsResponse> getAll();
	
	GetByIdResponse getById(int id);
	
	void add(CreateModelRequest createModelRequest);
	
	void update(UpdateModelRequest updateModelRequest);
	
	void delete(int id);

}
