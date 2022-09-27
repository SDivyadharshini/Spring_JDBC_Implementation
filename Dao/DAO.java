package com.example.jdbc.project_spring_jdbc.Dao;

import java.util.List;
import com.example.jdbc.project_spring_jdbc.Bean.HotelRoom;
public interface DAO<T> {
	
	List<HotelRoom> allRooms();
	HotelRoom getByNo(String roomNo);
    HotelRoom saveroom(HotelRoom room);
    HotelRoom updateroom(HotelRoom room);
    String deleteRoom(String roomNo);
    
}
