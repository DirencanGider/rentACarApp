package kodlama.io.rentACarApp.core.utilities.mappers;

import org.modelmapper.ModelMapper;

public interface ModelMapperService {
	
	ModelMapper forResponse();
	ModelMapper forRequest();

}
