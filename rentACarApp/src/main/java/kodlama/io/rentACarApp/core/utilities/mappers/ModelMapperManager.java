package kodlama.io.rentACarApp.core.utilities.mappers;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ModelMapperManager implements ModelMapperService {
	
	private ModelMapper modelMapper;
	
	//İki metot içerisindeki içerikler aynı. İkisini birbirinden ayıran nokta ise MatchingStrategies.

	@Override
	public ModelMapper forResponse() {
		
		this.modelMapper.getConfiguration()
		.setAmbiguityIgnored(true)
		.setMatchingStrategy(MatchingStrategies.LOOSE); //Gevşek mapleme. Sadece DTO içerisindeki fieldları mapler
		
		return this.modelMapper;
	}

	@Override
	public ModelMapper forRequest() {
		
		this.modelMapper.getConfiguration()
		.setAmbiguityIgnored(true)
		.setMatchingStrategy(MatchingStrategies.STANDARD); //Entity içerisindeki herşeyi DTO'ya mapler
		
		return this.modelMapper;
	}

}
