package kodlama.io.rentACarApp.core.utilities.exceptions;

public class BusinessException extends RuntimeException { //Defaultta Exception'ı extend ediyordu. RuntimeException ile değiştirdik
	
	public BusinessException(String message) {
		super(message); //Extend edilen RuntimeException içerisindeki metoda mesajı iletecek. Mesaj oradaki metot ile işlenecek
	}

}
