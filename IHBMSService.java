package com.cg.service;


import java.util.List;

import com.cg.dto.BookingsDto;
import com.cg.dto.HotelDto;
import com.cg.dto.LoginDto;
import com.cg.dto.RoomDto;
import com.cg.exception.HotelException;

public interface IHBMSService {

	boolean validateLogin(String userid, String password) throws HotelException;

	public int addNewHotel(HotelDto hotelDto) throws HotelException;

	List<HotelDto> getAllHotels() throws HotelException;

	void deleteHotelByHotelId(int hotelId) throws HotelException;

	HotelDto retrieveHotelData(int hotelId);

	void updateHotel(HotelDto hotel);

	List<RoomDto> getAllRoomsInHotel(int hotelId);

	void deleteRoomByRoomId(int roomId);

	void addNewRoom(RoomDto roomDto);

	RoomDto retrieveRoomDataByRoomId(int roomId);

	RoomDto updateRoom(int roomId);

	void upadateRoomDetails(RoomDto roomDto);

	

	List<LoginDto> getUserDetails(List<BookingsDto> bookingsDto);

	List<BookingsDto> displayBookingsForSpecificHotel(int hotelId) throws HotelException;

	List<BookingsDto> showDetailsForSpecificDate(String specificDate) throws HotelException ;

}
