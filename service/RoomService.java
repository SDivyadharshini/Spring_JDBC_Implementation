package com.example.jdbc.project_spring_jdbc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.jdbc.project_spring_jdbc.Bean.HotelRoom;
import com.example.jdbc.project_spring_jdbc.Exception.RoomAlreadyExistsException;
import com.example.jdbc.project_spring_jdbc.Exception.RoomNotFoundException;
import com.example.jdbc.project_spring_jdbc.Dao.RoomDAO;
import static com.example.jdbc.project_spring_jdbc.constants.ERROR_Message.*;
import static com.example.jdbc.project_spring_jdbc.constants.Response_DELETE_Msg.*;

import java.util.List;

@Component
public class RoomService {
	
	@Autowired
	private RoomDAO roomDAO;
	
	public HotelRoom createNewRoom(HotelRoom room) {
		HotelRoom newRoom = null;
		HotelRoom existingroom= null;
		System.out.println("In service class ------- " + room);
		try {
		      existingroom=roomDAO.getByNo(room.getRoomNo());
		}catch(RoomNotFoundException rnfe) {
			System.out.println("In service class - catch block  ------- ");
			newRoom = roomDAO.saveroom(room);
		}
		
		if(null != existingroom) {
			System.out.println("In service class ------- existingroom ---- " + existingroom);
			 throw new RoomAlreadyExistsException( room.getRoomNo() + " " + ROOM_ALREADY_EXISTS);
		}

		return newRoom;
	}
	
	public HotelRoom FetchOneRoom (String roomno)
	{
	 HotelRoom OneRoom =roomDAO.getByNo(roomno);
	
//    if(OneRoom==null)
//    {
//         throw new RoomNotFoundException(roomno + ROOM_NOT_FOUND);
//    
//	}
    return OneRoom;
	}

	public HotelRoom UpdateRoom (HotelRoom room)
	{
		HotelRoom ModifyRoom = null;
		HotelRoom existingroom = roomDAO.getByNo(room.getRoomNo());
		String roomno = room.getRoomNo();
		if(existingroom != null)
		{
			 ModifyRoom = roomDAO.updateroom(room);
		}
//		else 
//		
//			throw new RoomNotFoundException(roomno + " " + ROOM_NOT_FOUND);
		
		return ModifyRoom;
	}
	
	public String DeleteRoom (String room)
	{
		HotelRoom existingroom = roomDAO.getByNo(room);
		if(existingroom != null)
		{
			 roomDAO.deleteRoom(room);
		}
//		else
//		{
//			throw new RoomNotFoundException(room + " " + ROOM_NOT_FOUND);
//			
//		}
		return room + " " + DELETED_ROOM;
	}

	public List<HotelRoom> allRooms() {
		// TODO Auto-generated method stub
		return roomDAO.allRooms();
	}
}
