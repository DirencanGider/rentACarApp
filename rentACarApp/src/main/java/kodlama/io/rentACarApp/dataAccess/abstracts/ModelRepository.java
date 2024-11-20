package kodlama.io.rentACarApp.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlama.io.rentACarApp.entities.concretes.Model;

public interface ModelRepository extends JpaRepository<Model ,Integer> {
	
	Model findByName(String name);
	
	boolean existsByName(String name);
	
	
}
