package hotelbooking.web;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import lombok.extern.slf4j.Slf4j;
import hotelbooking.Booking;

@Slf4j
@Controller
@RequestMapping("/payment")
public class BookingController {
	@GetMapping("/current")
	public String orderForm(Model model) {
		model.addAttribute("booking", new Booking());
		return "booking";
	}
	
	@PostMapping
	public String processBooking(@Valid Booking booking, Errors errors) {
	    if (errors.hasErrors()) {
		return "booking";
	    }
	    return "redirect:/";
	}

}
