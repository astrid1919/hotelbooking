package hotelbooking;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.Digits;
import javax.validation.constraints.Pattern;
import org.hibernate.validator.constraints.CreditCardNumber;
import javax.validation.constraints.NotBlank;
import lombok.Data;
import hotelbooking.Cart;
@Data

public class Booking {
	private Long id;
	private Date placedAt;
	@NotBlank(message="Name is required")
	  private String name;
	  @CreditCardNumber(message="Not a valid credit card number")
	  private String ccNumber;
	  @Pattern(regexp="^(0[1-9]|1[0-2])([\\/])([1-9][0-9])$",
	           message="Must be formatted MM/YY")
	  private String ccExpiration;
	  @Digits(integer=3, fraction=0, message="Invalid CVV")
	  private String ccCVV;
	  private Cart cart;
}
