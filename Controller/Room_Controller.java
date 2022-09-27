package com.example.jdbc.project_spring_jdbc.Controller;

import java.util.List;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;

import com.example.jdbc.project_spring_jdbc.Bean.HotelRoom;
import com.example.jdbc.project_spring_jdbc.Dao.RoomDAO;
import com.example.jdbc.project_spring_jdbc.service.RoomService;
import static com.example.jdbc.project_spring_jdbc.constants.URI_Request.*;

@RestController
public class Room_Controller {
	
	private RoomDAO connectDAO ;
	
	@Autowired
	private RoomService roomService;
	
//	public Room_Controller(RoomDAO connectDAO)
//	{
//		this.connectDAO=connectDAO;
//	}
//	@GetMapping(ALL_ROOMS)
//	public List<HotelRoom> list()
//	{
//		return connectDAO.allRooms();
//	}
	@GetMapping(ALL_ROOMS)
	public List<HotelRoom> list()
    {
		return roomService.allRooms();
	}
	
	@GetMapping(PARTICULAR_ROOM)
    public HotelRoom getByNo(@PathVariable String roomNo)
    {
		
     return roomService.FetchOneRoom(roomNo);
    }
    
	
	@PostMapping(CREATE_ROOM)
    public HotelRoom addRoom(@RequestBody HotelRoom room)
    {
		
		//System.out.println("In post------- " + room);
		HotelRoom newRoom = roomService.createNewRoom(room);
		
		//System.out.println("In post... created new room... " + newRoom);
      return newRoom;
		
        
    }
	
	@PutMapping(UPDATE_ROOM)
    public HotelRoom updateRoom(@RequestBody HotelRoom room)
    {
		System.out.println("Enter PUT Mapping");
        return roomService.UpdateRoom(room);
    }
	
	@DeleteMapping(DELETE_ROOM)
    public String deleteRoom(@PathVariable String roomNo){
        return roomService.DeleteRoom(roomNo);
    }

}
