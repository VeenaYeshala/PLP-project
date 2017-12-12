package com.cg.dao;

import java.util.List;

import com.cg.dto.BookingsDto;
import com.cg.dto.HotelDto;
import com.cg.dto.LoginDto;
import com.cg.dto.RoomDto;
import com.cg.exception.HotelException;

public interface IHBMSDao {

	boolean validateLogin(String userid, String password) throws HotelException;



	int addNewHotel(HotelDto hotelDto) throws HotelException;



	List<HotelDto> getAllHotels() throws HotelException;



	void deleteHotel(int hotelId) throws HotelException;



	HotelDto retrieveHotelData(int hotelId);



	void updateHotel(HotelDto hotel);



	List<RoomDto> getAllRooms(int hotelId);



	void deleteRooms(int roomId);



	void addNewRoom(RoomDto roomDto);



	RoomDto retrieveRoomDataById(int roomId);



	RoomDto updateRooms(int roomId);



	void updateRoomDetails(RoomDto roomDto);



	



	List<LoginDto> getUserDetails(List<BookingsDto> bookingsDto);



	List<BookingsDto> displayBookingsForSpecificHotel(int hotelId) throws HotelException;



	List<BookingsDto> showDetailsForSpecificDate(String specificDate) throws HotelException;

}
