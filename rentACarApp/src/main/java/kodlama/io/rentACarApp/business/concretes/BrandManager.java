package kodlama.io.rentACarApp.business.concretes;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import kodlama.io.rentACarApp.business.abstracts.BrandService;
import kodlama.io.rentACarApp.business.requests.CreateBrandRequest;
import kodlama.io.rentACarApp.business.requests.UpdateBrandRequest;
import kodlama.io.rentACarApp.business.responses.GetAllBrandsResponse;
import kodlama.io.rentACarApp.business.responses.GetByIdResponse;
import kodlama.io.rentACarApp.business.rules.BrandBusinessRules;
import kodlama.io.rentACarApp.core.utilities.mappers.ModelMapperService;
import kodlama.io.rentACarApp.dataAccess.abstracts.BrandRepository;
import kodlama.io.rentACarApp.entities.concretes.Brand;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class BrandManager implements BrandService {
	
	private BrandRepository brandRepository;
	
	private ModelMapperService modelMapperService; 
	
	private BrandBusinessRules brandBusinessRules;

	//İşlemleri DTOlar ile gerçekleştiriyoruz. Son kullanıcıya asla Entity'ler üzerinde işlem yaptırmıyoruz
	//Bu durumda, DTOlar'ı oluştururken response-request pattern kullanıyoruz
	
	@Override
	public List<GetAllBrandsResponse> getAll() {
		
		//Brand Entitiy'i liste şeklinde çektik. Şimdi dto'ya mapleyeceğiz.
		List<Brand> brands = brandRepository.findAll(); 
		
		//Entity -> DTO mapleme
		List<GetAllBrandsResponse> response = brands.stream()
				.map(brand -> this.modelMapperService.forResponse()
						.map(brand, GetAllBrandsResponse.class)).collect(Collectors.toList());
		
		return response;
	}

	@Override
	public GetByIdResponse getById(int id) {
		
		//Optional<Brand> türü yerine, Brand türünde bir referans değişkeni tanımladık
		Brand brand = brandRepository.findById(id).orElseThrow(); //Bir üst satıra binaen hata vermemesi için orElseThrow() kullanıyoruz
		
		GetByIdResponse response = this.modelMapperService.forResponse()
				.map(brand, GetByIdResponse.class); //Parantez içi anlamı-> (verinin alınacağı yer, aktarılacağı yer)
		
		return response;
	}

	@Override
	public void add(CreateBrandRequest createBrandRequest) {
		
		//İş kuralı
		this.brandBusinessRules.checkIfBrandNameExists(createBrandRequest.getName());
		
		//dto içindekini entity'e mapleme işlemi
		Brand brand = this.modelMapperService.forRequest().map(createBrandRequest, Brand.class);
		
		this.brandRepository.save(brand);
		
	}

	@Override
	public void update(UpdateBrandRequest updateBrandRequest) {
		Brand brand = this.modelMapperService.forRequest().map(updateBrandRequest, Brand.class);
		this.brandRepository.save(brand);
	}

	@Override
	public void delete(int id) {
		this.brandRepository.deleteById(id);
		
	}

}
