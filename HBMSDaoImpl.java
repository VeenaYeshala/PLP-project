package com.cg.dao;


import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.cg.dto.BookingsDto;
import com.cg.dto.HotelDto;
import com.cg.dto.LoginDto;
import com.cg.dto.RoomDto;
import com.cg.exception.HotelException;

@Repository("hbmsDao")
public class HBMSDaoImpl implements IHBMSDao  {
	HotelDto hotelDto;
	RoomDto roomDto;
	@PersistenceContext
	private EntityManager entityManager;
	@Override
	public boolean validateLogin(String userid, String password) throws HotelException{
		try{
			LoginDto loginDto;
			System.out.println("1");
			loginDto=entityManager.find(LoginDto.class,userid);
			System.out.println("2");
			if(loginDto.getPassword().equals(password))
			{
				System.out.println("3");
				return true;
			}
			
			else
			{
				System.out.println("4");
				return false;
			}
		}catch(Exception e){
			throw new HotelException("Wrong Login Details......");
		}
			
	
	}
	@Override
	public int addNewHotel(HotelDto hotelDto) {
		
		entityManager.persist(hotelDto);
		entityManager.flush();
		return hotelDto.getHotelId();
	}
	@Override
	public List<HotelDto> getAllHotels() {
		List<HotelDto> hotelList;
		String getHotelQuery="from HotelDto";
		TypedQuery<HotelDto> query=entityManager.createQuery(getHotelQuery,HotelDto.class);
		hotelList=query.getResultList();
		entityManager.flush();
		
		return hotelList;
	}
	@Override
	public void deleteHotel(int hotelId) throws HotelException {
		
		try{
		hotelDto=entityManager.find(HotelDto.class, hotelId);
		entityManager.remove(hotelDto);
		entityManager.flush();}
		catch(Exception e)
		{	System.out.println("In dao ");
			throw new HotelException("Hotel cannot be deleted because child records exist.");
		}
		
	}
	@Override
	public HotelDto retrieveHotelData(int hotelId) {
		hotelDto=entityManager.find(HotelDto.class, hotelId);
		entityManager.flush();
		return hotelDto;
	}
	@Override
	public void updateHotel(HotelDto hotel) {
		HotelDto hotelDto = entityManager.find(HotelDto.class,hotel.getHotelId()); //Consider em as JPA EntityManager
		System.out.println(hotelDto);
		entityManager.merge(hotel);

		entityManager.flush();
		
		/*hotelDto=entityManager.find(HotelDto.class, hotel.getHotelId());
		hotelDto.merge(hotel);
		entityManager.flush();*/
		
	}
	
	/* r where r.hotelId=:hotelId*/
	
	@Override
	public List<RoomDto> getAllRooms(int hotelId) {
	
		List<RoomDto> hotelRoomsList;
	
		String getHotelQuery="SELECT rooms FROM RoomDto rooms where rooms.hotelId=:hotelId";
		
		TypedQuery<RoomDto> query=entityManager.createQuery(getHotelQuery,RoomDto.class);
		System.out.println("in dao after q");
		query.setParameter("hotelId", hotelId);
		hotelRoomsList=query.getResultList();		
	
		return hotelRoomsList;
				
		
		
	}
	@Override
	public void deleteRooms(int roomId) {
		roomDto=entityManager.find(RoomDto.class,roomId);
		entityManager.remove(roomDto);
		entityManager.flush();
				
	}
	@Override
	public void addNewRoom(RoomDto roomDto) {
		entityManager.persist(roomDto);
		entityManager.flush();
		
		
	}
	@Override
	public RoomDto retrieveRoomDataById(int roomId) {
		roomDto=entityManager.find(RoomDto.class,roomId);
		entityManager.flush();
		return roomDto;
	}
	@Override
	public RoomDto updateRooms(int roomId) {
		RoomDto roomDto;
		roomDto= entityManager.find(RoomDto.class,roomId); 
		System.out.println(roomDto);
		
		entityManager.flush();
		return roomDto;
	}
	@Override
	public void updateRoomDetails(RoomDto roomDto) {
		RoomDto roomToUpdate = entityManager.find(RoomDto.class,roomDto.getRoomId());
		
		entityManager.merge(roomDto);
		entityManager.flush();
		
	}
	
	@Override
	public List<LoginDto> getUserDetails(List<BookingsDto> bookingsDto) {
		
		List<LoginDto> loginDto;
		
		
		
		
		return null;
	}
	@Override
	public List<BookingsDto> displayBookingsForSpecificHotel(int hotelId) throws HotelException {
		List<BookingsDto> listOfBookings;
		
		try{
			HotelDto hotel;
			
			hotel=entityManager.find(HotelDto.class,hotelId);
			
			if(hotel.getHotelId()==hotelId)
			{
				
			}
			
			
		}catch(Exception e){
			throw new HotelException("Invalid Hotel Id");
		}
		
		try{
			String specifiedDateBookingsQuery="SELECT bookings FROM BookingsDto bookings WHERE bookings.hotelId ="+hotelId;
			TypedQuery<BookingsDto> bookings=entityManager.createQuery(specifiedDateBookingsQuery,BookingsDto.class);
			listOfBookings=bookings.getResultList();
		}catch (Exception e) {
			throw new HotelException("Error in parsing date. Please provide date in correct format");
		}
		return listOfBookings;
	}
	@Override
	public List<BookingsDto> showDetailsForSpecificDate(String specificDate) throws HotelException {
		SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat format2 = new SimpleDateFormat("dd-MMM-yyyy");

		Date date1 = null;
		try {
			date1 = format1.parse(specificDate);
			String dateTransformed1 = format2.format(date1);
			System.out.println("in dao date is "+dateTransformed1);
			List<BookingsDto> listOfBookings;
			String specifiedDateBookingsQuery="SELECT bookings FROM BookingsDto bookings WHERE bookings.bookingFrom <="+""+"'"+dateTransformed1+"'"+""+"and bookings.bookingTo >="+""+"'"+dateTransformed1+"'"+"";
			TypedQuery<BookingsDto> bookings=entityManager.createQuery(specifiedDateBookingsQuery,BookingsDto.class);
			listOfBookings=bookings.getResultList();
			return listOfBookings;
		} catch (Exception e) {
			throw new HotelException("Error in parsing date. Please provide date in correct format");
		}

	}
	
}