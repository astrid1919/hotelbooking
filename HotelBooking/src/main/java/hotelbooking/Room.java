package hotelbooking;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;


@Data
@NoArgsConstructor(force=true)

public class Room {
	private String id;
	private int number;
	private String type;
	private int price;
}
