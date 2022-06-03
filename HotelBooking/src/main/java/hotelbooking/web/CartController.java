package hotelbooking.web;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;
import hotelbooking.Room;
import hotelbooking.Cart;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/booking")
public class CartController {
	private RestTemplate rest = new RestTemplate();
	@ModelAttribute
	public void addIngredientsToModel(Model model) {
		List<Room> rooms = 	Arrays.asList(rest.getForObject("http://localhost:8080/rooms",Room[].class));
		}

		@GetMapping
		public String showBookingForm(Model model) {
			model.addAttribute("room", new Room());
			return "cart";
		}

		private List<Room> filterByType(List<Room> rooms, String type) {
			List<Room> roomList = new ArrayList<Room>();
			for (Room room: rooms) {
				roomList.add(room);
			}
			return roomList;
				
		}
		@PostMapping
		  public String processCart(@RequestParam("room") String roomIds) {
		    List<Room> rooms = new ArrayList<Room>();
		    for (String roomId : roomIds.split(",")) {
		      Room room = rest.getForObject("http://localhost:8080/rooms/{id}",Room.class, roomId);
		      rooms.add(room);
		    }
		    Cart cart = new Cart();
			cart.setRooms(rooms);
			int ttprice=0;
			for (Room room: rooms) 
				ttprice = ttprice + room.getPrice();
		    rest.postForObject("http://localhost:8080/cart", cart, Cart.class);
		    return "redirect:/Booking/current";
		  }

}
