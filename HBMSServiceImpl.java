package com.cg.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cg.dao.IHBMSDao;
import com.cg.dto.BookingsDto;
import com.cg.dto.HotelDto;
import com.cg.dto.LoginDto;
import com.cg.dto.RoomDto;
import com.cg.exception.HotelException;

@Service("hbmsService")
@Transactional(rollbackFor = HotelException.class)
public class HBMSServiceImpl implements IHBMSService{

	@Autowired
	IHBMSDao hbmsDao;
	@Override
	public boolean validateLogin(String userid, String password) throws HotelException {

		return hbmsDao.validateLogin(userid,password);
	}
	@Override
	public int addNewHotel(HotelDto hotelDto) throws HotelException {

		return hbmsDao.addNewHotel(hotelDto);
	}
	@Override
	public List<HotelDto> getAllHotels() throws HotelException {

		return hbmsDao.getAllHotels();
	}
	@Override
	public void deleteHotelByHotelId(int hotelId) throws HotelException {


		hbmsDao.deleteHotel(hotelId);

	}
	@Override
	public HotelDto retrieveHotelData(int hotelId) {

		return hbmsDao.retrieveHotelData(hotelId);
	}
	@Override
	public void updateHotel(HotelDto hotel) {
		 hbmsDao.updateHotel(hotel);

	}
	@Override
	public List<RoomDto> getAllRoomsInHotel(int hotelId) {
		List<RoomDto> hotelRoomsList=hbmsDao.getAllRooms(hotelId);
		return hotelRoomsList;
	}
	@Override
	public void deleteRoomByRoomId(int roomId) {
		
		hbmsDao.deleteRooms(roomId);
	}
	@Override
	public void addNewRoom(RoomDto roomDto) {
		hbmsDao.addNewRoom(roomDto);
		
	}
	@Override
	public RoomDto retrieveRoomDataByRoomId(int roomId) {
		
		return hbmsDao.retrieveRoomDataById(roomId);
	}
	@Override
	public RoomDto updateRoom(int roomId) {
		return hbmsDao.updateRooms(roomId);
	}
	@Override
	public void upadateRoomDetails(RoomDto roomDto) {
		hbmsDao.updateRoomDetails(roomDto);
		
	}
	
	@Override
	public List<LoginDto> getUserDetails(List<BookingsDto> bookingsDto) {
		
		return hbmsDao.getUserDetails(bookingsDto);
	}
	@Override
	public List<BookingsDto> displayBookingsForSpecificHotel(int hotelId) throws HotelException {
		
		return hbmsDao.displayBookingsForSpecificHotel(hotelId);
	}
	@Override
	public List<BookingsDto> showDetailsForSpecificDate(String specificDate) throws HotelException {
		return hbmsDao.showDetailsForSpecificDate(specificDate);
	}

}
