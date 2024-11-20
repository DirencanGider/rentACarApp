package kodlama.io.rentACarApp.webApi.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;
import kodlama.io.rentACarApp.business.abstracts.BrandService;
import kodlama.io.rentACarApp.business.requests.CreateBrandRequest;
import kodlama.io.rentACarApp.business.requests.UpdateBrandRequest;
import kodlama.io.rentACarApp.business.responses.GetAllBrandsResponse;
import kodlama.io.rentACarApp.business.responses.GetByIdResponse;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/brands-controller")
@AllArgsConstructor
public class BrandsController {
	
	@Autowired
	private BrandService brandService;
	
	
	@GetMapping()
	List<GetAllBrandsResponse> getAll(){
		return brandService.getAll();
		
	}
	
	@GetMapping("/{id}")
	GetByIdResponse getById(@PathVariable int id) {
		return brandService.getById(id);
	}
	
	@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED)
	void add (@RequestBody @Valid CreateBrandRequest createBrandRequest) {
		brandService.add(createBrandRequest);
	}
	
	@PutMapping
	void update(@RequestBody UpdateBrandRequest updateBrandRequest) {
		brandService.update(updateBrandRequest);
	}
	
	@DeleteMapping("/{id}")
	void delete(@PathVariable int id) {
		brandService.delete(id);
	}

}
