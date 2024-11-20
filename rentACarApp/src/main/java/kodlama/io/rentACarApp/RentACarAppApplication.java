package kodlama.io.rentACarApp;

import java.util.HashMap;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import kodlama.io.rentACarApp.core.utilities.exceptions.BusinessException;
import kodlama.io.rentACarApp.core.utilities.exceptions.ProblemDetails;
import kodlama.io.rentACarApp.core.utilities.exceptions.ValidationProblemDetails;

@SpringBootApplication
public class RentACarAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(RentACarAppApplication.class, args);
	}
	
	//Hata yakalamayı aktif hale getirme
		@ExceptionHandler
		@ResponseStatus(code=HttpStatus.BAD_REQUEST) //Eğer hata yakalanırsa son kullanıcıya bu status döndürülecek
		public ProblemDetails handleBusinessException(BusinessException businessException) {  /*Hangi hatayı alırsa bu metod çalışacak? Cevap
		 																						parantez içinde. BusinessException alırsa 
		 																						çalışacak.*/
			
			ProblemDetails problemDetails = new ProblemDetails();
			problemDetails.setMessage(businessException.getMessage());  /*Message'ı, o an oluşan hatanın mesajı olarak setliyoruz. */
			
			return problemDetails;  //Artık buraya(ProblemDetails içerisine) istediğimiz kadar bilgi(field/alan) koyup onu döndürebiliriz.
		}
		
		
		@ExceptionHandler 
		@ResponseStatus(code=HttpStatus.BAD_REQUEST)
		public ProblemDetails handleValidationException(MethodArgumentNotValidException methodArgumentNotValidException) {  
			/*Swagger üzerinden tek bir harf için bir Brand eklenmesi denendi fakat yine uzun hata fırlattı. Çünkü alınan exception
			 * BusinessException türünde değil de MethodArgumentNotValidException türündeydi.
			 * Bu yüzden bir üst blokta yazmış olduğumuz handleBusinessException'ı aynen kopyalayıp hemen altına, yani buraya yapıştırdık ve
			 * içeriğini MethodArgumentNotValidException' göre değiştirdik. */
			
			ValidationProblemDetails validationProblemDetails = new ValidationProblemDetails();
			validationProblemDetails.setMessage("VALIDATION.EXCEPTION");  /*Hata mesajını bu şekilde verebiliriz. Fakat detaylı olarak hatada yer alan hata
																ayrıntısını buraya setleyebiliriz.
																Bu bizim için yeterli olmadığı için ProblemDetails yerine ValidationProblemDetails
																class'ı oluşturarak onun referansını kullanacağız. 
																frontenciye de doğru hata bilgisini vermek için detaylandıralım. 
																*/
			
			
			
			
			
			validationProblemDetails.setValidationErrors(new HashMap<String, String>());  /*HashMap'i oluşturduk. Şimdi aşağıda 
																							put ile içini dolduracağız.  */
			/*
			 * Şimdi Swagger üzerinde uzun uzadıya çıkan hatayı aşağı doğru incelediğimizde hatalar array olarak gelmekte. 
			 * Bu durumda tek tek dolaşacağız. Bunu foreach ile yapabiliriz.
			 * 
			 * */
			
			for (FieldError fieldError : methodArgumentNotValidException.getBindingResult().getFieldErrors()) {
				validationProblemDetails.getValidationErrors().put(fieldError.getField(), fieldError.getDefaultMessage());  //  HashMap'e setledik.
			}
			
			
			return validationProblemDetails;
		}
	
	@Bean
	public ModelMapper getModelMapper() {
		return new ModelMapper();
	}

}
