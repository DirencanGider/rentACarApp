package kodlama.io.rentACarApp.webApi.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlama.io.rentACarApp.business.abstracts.ModelService;
import kodlama.io.rentACarApp.business.requests.CreateModelRequest;
import kodlama.io.rentACarApp.business.responses.GetAllModelsResponse;
import kodlama.io.rentACarApp.business.responses.GetByIdResponse;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/models-controller")
@AllArgsConstructor
public class ModelsController {
	
	@Autowired
	private ModelService modelService;
	
	@GetMapping()
	List<GetAllModelsResponse> getAll() {
	
		return modelService.getAll();
	}
	
	@GetMapping("/{id}")
	GetByIdResponse getById(@PathVariable(value = "id") int id) {
	return modelService.getById(id);
	}
	
	@PostMapping()
	void add(CreateModelRequest createModelRequest) {
		modelService.add(createModelRequest);
	}
	

}
