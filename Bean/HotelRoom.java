package com.example.jdbc.project_spring_jdbc.Bean;

public class HotelRoom {
	
	private String roomNo;
	private String roomType;
	private String bed;
	private int price;
	private String status;
	
	public HotelRoom()
	{
		
	}

	public HotelRoom(String roomNo, String roomType, String bed, int price, String status) {
		super();
		this.roomNo = roomNo;
		this.roomType = roomType;
		this.bed = bed;
		this.price = price;
		this.status = status;
	}

	public String getRoomNo() {
		return roomNo;
	}

	public void setRoomNo(String roomNo) {
		this.roomNo = roomNo;
	}

	public String getRoomType() {
		return roomType;
	}

	public void setRoomType(String roomType) {
		this.roomType = roomType;
	}

	public String getBed() {
		return bed;
	}

	public void setBed(String bed) {
		this.bed = bed;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "HotelRoom [roomNo=" + roomNo + ", roomType=" + roomType + ", bed=" + bed + ", price=" + price
				+ ", status=" + status + "]";
	}
	
	
	

}
