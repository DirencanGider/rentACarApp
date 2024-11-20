package kodlama.io.rentACarApp.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlama.io.rentACarApp.entities.concretes.Brand;

public interface BrandRepository extends JpaRepository<Brand, Integer> {
	
	//JpaRepositoryde defaultta olmayan, isme göre arama yapmamızı sağlayacak metot
	Brand findByName(String name);
	
	//İlgili isimde marka olup olmadığını true ya da false olarak dönecek metot
	boolean existsByName(String name);

}
