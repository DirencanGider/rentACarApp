package kodlama.io.rentACarApp.business.rules;

import org.springframework.stereotype.Service;

import kodlama.io.rentACarApp.core.utilities.exceptions.BusinessException;
import kodlama.io.rentACarApp.dataAccess.abstracts.BrandRepository;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class BrandBusinessRules {
	
	private BrandRepository brandRepository;
	
	public void checkIfBrandNameExists(String name) {
		
		if(this.brandRepository.existsByName(name)) {
			throw new BusinessException("Brand name already exist");
		}
		
	}

}
