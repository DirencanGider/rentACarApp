package kodlama.io.rentACarApp.business.concretes;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import kodlama.io.rentACarApp.business.abstracts.ModelService;
import kodlama.io.rentACarApp.business.requests.CreateModelRequest;
import kodlama.io.rentACarApp.business.requests.UpdateModelRequest;
import kodlama.io.rentACarApp.business.responses.GetAllModelsResponse;
import kodlama.io.rentACarApp.business.responses.GetByIdResponse;
import kodlama.io.rentACarApp.core.utilities.mappers.ModelMapperService;
import kodlama.io.rentACarApp.dataAccess.abstracts.ModelRepository;
import kodlama.io.rentACarApp.entities.concretes.Model;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ModelManager implements ModelService {
	
	private ModelRepository modelRepository;
	
	private ModelMapperService modelMapperService;
	
	@Override
	public List<GetAllModelsResponse> getAll() {
		
		List<Model> models = modelRepository.findAll();
		
		List<GetAllModelsResponse> response = models.stream()
                .map(model -> this.modelMapperService.forResponse()
                		.map(model, GetAllModelsResponse.class)).collect(Collectors.toList());
		
	return response;
	}

	@Override
	public void add(CreateModelRequest createModelRequest) {
		
		Model model = this.modelMapperService.forRequest().map(createModelRequest, Model.class);
		
		this.modelRepository.save(model);
		
	}

	@Override
	public GetByIdResponse getById(int id) {
		
		Model model = modelRepository.findById(id).orElseThrow();
		
		GetByIdResponse response = this.modelMapperService.forResponse().map(model, GetByIdResponse.class);
		
		return response;
	}

	@Override
	public void update(UpdateModelRequest updateModelRequest) {
		
		Model model = this.modelMapperService.forRequest().map(updateModelRequest, Model.class);
		this.modelRepository.save(model);
	}

	@Override
	public void delete(int id) {
		this.modelRepository.deleteById(id);
		
	}
}
