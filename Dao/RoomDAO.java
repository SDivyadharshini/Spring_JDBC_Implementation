package com.example.jdbc.project_spring_jdbc.Dao;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.example.jdbc.project_spring_jdbc.Bean.*;
import com.example.jdbc.project_spring_jdbc.Exception.RoomNotFoundException;
import static com.example.jdbc.project_spring_jdbc.constants.ERROR_Message.*;

@Component
public class RoomDAO implements DAO<HotelRoom> {
	private static final Logger log=LoggerFactory.getLogger(RoomDAO.class);
    private JdbcTemplate jdbcTemplate; 
    RowMapper<HotelRoom> rowMapper=(rs,rowNum)->{
        HotelRoom room =new HotelRoom();
        room.setRoomNo(rs.getString("roomNo"));
        room.setRoomType(rs.getString("roomType"));
        room.setBed(rs.getString("bed"));
        room.setPrice(rs.getInt("price"));
        room.setStatus(rs.getString("status"));
        return room;    
    };

    public RoomDAO(JdbcTemplate jdbcTemplate) {

        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<HotelRoom> allRooms() {
        String sql="SELECT * FROM room";
        return jdbcTemplate.query(sql,rowMapper);
    }
    
    
    @Override
	public HotelRoom getByNo(String roomNo) {
    	System.out.println("IN DAO... getByNo....");
    	HotelRoom room = null;
    	try {
    	 String sql="SELECT * from room where roomNo=?";
    	 room = jdbcTemplate.queryForObject(sql, rowMapper, new Object[] {roomNo});
			
			  }catch(DataAccessException ex) { 
				  throw new RoomNotFoundException(roomNo + " " + ROOM_NOT_FOUND); }
			 
    	 System.out.println("IN DAO... room.. " + room);
    	 return room;
	}
    
    
    /*@Override
    public Optional<HotelRoom> getByNo(String roomNo) {
        String sql="SELECT * from room where roomNo=?";
        HotelRoom room=null;
        try {
            room=jdbcTemplate.queryForObject(sql, rowMapper, new Object[] {roomNo});
        }
        catch(DataAccessException ex)
        {
            log.info("Room detail not found: " + roomNo);
            System.out.println(ex);
        }
        return Optional.ofNullable(room);
    }*/
    
    

	@Override
	public HotelRoom saveroom(HotelRoom room) {
		String sql = "Insert into room (roomNo, roomType, bed, price, status) values (?, ?, ?, ?, ?)";
    	jdbcTemplate.update(sql, room.getRoomNo(), room.getRoomType(), room.getBed(), room.getPrice(), room.getStatus());
		return room;
	}

	@Override
	public HotelRoom updateroom(HotelRoom room) {
		String sql="Update room set roomType=?, bed=?, price=?, status=? where roomNo=?";
    	int rowsUpdate = jdbcTemplate.update(sql, room.getRoomType(),room.getBed(), room.getPrice(), room.getStatus(), room.getRoomNo());
		if(rowsUpdate<1)
		{
			System.out.println("Updated UPDATE");
		}
    	return room;
	}

	@Override
	public String deleteRoom(String roomNo) {
		String sql="Delete from room where roomNo=?";
        jdbcTemplate.update(sql, roomNo);
                return roomNo + " Room Details got Deleted" ;
		
	}

	

  
   

}


