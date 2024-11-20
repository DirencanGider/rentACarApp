package kodlama.io.rentACarApp.entities.concretes;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table(name = "cars")
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Car {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "plate", unique = true)
	private String plate;
	
	@Column(name= "daily_price")
	private double dailyPrice;
	
	@Column(name= "model_year")
	private int modelYear;
	
	@Column(name= "state")
	private int state; //Aracın Durumu ---> 1-Available, 2-Rented, 3-Maintenance

	@ManyToOne
	@JoinColumn(name="model_id")
	private Model model;
}
