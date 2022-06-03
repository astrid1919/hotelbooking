package hotelbooking;

import java.sql.Date;
import java.util.List;
import lombok.Data;
import hotelbooking.Room;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
public class Cart {
	private Long id;
	private Date createdAt;
	@Size(min=1, message="You must choose at least 1 room")
	private List<Room> rooms;
	
}
