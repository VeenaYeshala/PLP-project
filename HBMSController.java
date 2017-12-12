package com.cg.controller;



import java.util.ArrayList;




import java.util.List;

import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.cg.dto.BookingsDto;
import com.cg.dto.HotelDto;
import com.cg.dto.LoginDto;
import com.cg.dto.RoomDto;
import com.cg.exception.HotelException;
import com.cg.service.IHBMSService;
@Controller
public class HBMSController {
	private static final Logger logr = Logger.getLogger(HBMSController.class);
	ModelAndView mv;
	@Autowired
	IHBMSService hbmsService;
	@RequestMapping("/")
	public ModelAndView loginPage()
	{

		mv =new ModelAndView("HBMS_Admin_LoginPage");

		mv.addObject("login", new LoginDto());

		return mv;

	}
	@RequestMapping("/logout")
	public ModelAndView logOut()
	{

		mv =new ModelAndView("HBMS_Admin_LoginPage");

		mv.addObject("login", new LoginDto());

		return mv;

	}
	@SuppressWarnings("finally")
	@RequestMapping("/validateLogin")
	public ModelAndView validateLogin(@ModelAttribute("login") @Valid LoginDto dto,BindingResult result){

		if(result.hasErrors())
		{
			mv = new ModelAndView("HBMS_Admin_LoginPage");

		}
		boolean validateLogin;
		try {
			validateLogin = hbmsService.validateLogin(dto.getUserid(),dto.getPassword());
			if(validateLogin){
				logr.info("Login Success");
				mv = new ModelAndView("HBMS_Admin_HomePage");

			}
			else
			{
				logr.error("Login Error");
				mv = new ModelAndView("HBMS_Admin_LoginPage");
				System.out.println("login failed");
				mv.addObject("exception","Enter valid login details");
				return mv;
			}
		} catch (HotelException e) {
			mv=new ModelAndView("HBMS_Admin_LoginPage");
			mv.addObject("exception",e.getMessage());

		}
		finally{
			return mv;
		}


	}

	@RequestMapping("/hotelManagement")
	public ModelAndView hotelManagementOperations()
	{
		List<HotelDto> hotelList;
		try {
			hotelList = hbmsService.getAllHotels();
			mv = new ModelAndView("HBMS_Admin_HotelManagement");
			mv.addObject("hotelList",hotelList);
			return mv;

		} catch (HotelException e) {
			mv=new ModelAndView("error");
			mv.addObject("exception",e.getMessage());
			return mv;
		}

	}
	@RequestMapping("/home")
	public ModelAndView home()
	{

		mv = new ModelAndView("HBMS_Admin_HomePage");
		return mv;

	}

	@RequestMapping(value="/addHotel",method=RequestMethod.POST)
	public ModelAndView addHotel()
	{
		mv = new ModelAndView("HBMS_Admin_AddHotel");
		ArrayList<String>	cityList=new ArrayList<String>();
		cityList.add("Anantapur");
		cityList.add("Hyderabad");
		cityList.add("Bangalore");
		cityList.add("Chennai");
		cityList.add("Kolkata");
		cityList.add("Noida");
		cityList.add("Pune");
		cityList.add("Goa");
		cityList.add("Vizag");
		cityList.add("New Delhi");
		cityList.add("Maisore");
		cityList.add("Nellore");
		cityList.add("Medchal");
		mv.addObject("cityList",cityList);

		ArrayList<String>	rating=new ArrayList<String>();
		rating.add("Good");
		rating.add("Average");
		rating.add("Poor");
		mv.addObject("rating", rating);
		mv.addObject("add", new HotelDto());
		return mv;

	}
	@RequestMapping("/addHotelData")
	public ModelAndView addHotelData(@ModelAttribute("add") @Valid HotelDto hotelDto,BindingResult result)
	{	

		if(result.hasErrors()){
			mv=new ModelAndView("HBMS_Admin_AddHotel");
			ArrayList<String>	cityList=new ArrayList<String>();
			cityList.add("Anantapur");
			cityList.add("Hyderabad");
			cityList.add("Bangalore");
			cityList.add("Chennai");
			cityList.add("Kolkata");
			cityList.add("Noida");
			cityList.add("Pune");
			cityList.add("Goa");
			cityList.add("Vizag");
			cityList.add("New Delhi");
			cityList.add("Maisore");
			cityList.add("Nellore");
			cityList.add("Medchal");
			mv.addObject("cityList",cityList);

			ArrayList<String>	rating=new ArrayList<String>();
			rating.add("Good");
			rating.add("Average");
			rating.add("Poor");
			mv.addObject("rating", rating);

			return mv;
		}
		else{

			try {
				hbmsService.addNewHotel(hotelDto);
				List<HotelDto> hotelList=hbmsService.getAllHotels();
				mv = new ModelAndView("HBMS_Admin_HotelManagement");
				mv.addObject("hotelList",hotelList);
				return mv;

			} catch (HotelException e) {

				mv=new ModelAndView("error");
				mv.addObject("exception",e.getMessage());
				return mv;
			}


		}


	}
	@RequestMapping("/deleteHotel")
	public ModelAndView deleteHotelByHotelId(@RequestParam("hId")int hotelId){

		System.out.println("in controll");
		try{
			System.out.println("in tru11");
			hbmsService.deleteHotelByHotelId(hotelId);
			System.out.println("In controler try");
			List<HotelDto> hotelList=hbmsService.getAllHotels();
			mv = new ModelAndView("HBMS_Admin_HotelManagement");
			mv.addObject("hotelList",hotelList);
			return mv;
		}catch(HotelException e){

			mv=new ModelAndView("error");
			mv.addObject("exception",e.getMessage());
			return mv;
		}


	}
	@RequestMapping("/updateHotel")
	public ModelAndView updateHotelByHotelId(@RequestParam("hId")int hotelId){
		HotelDto hotelData=hbmsService.retrieveHotelData(hotelId);
		mv = new ModelAndView("HBMS_Admin_UpdateHotel");
		ArrayList<String>	cityList=new ArrayList<String>();
		cityList.add("Anantapur");
		cityList.add("Hyderabad");
		cityList.add("Bangalore");
		cityList.add("Chennai");
		cityList.add("Kolkata");
		cityList.add("Noida");
		cityList.add("Pune");
		cityList.add("Goa");
		cityList.add("Vizag");
		cityList.add("New Delhi");
		cityList.add("Maisore");
		cityList.add("Nellore");
		cityList.add("Medchal");
		mv.addObject("cityList",cityList);

		ArrayList<String>	rating=new ArrayList<String>();
		rating.add("Good");
		rating.add("Average");
		rating.add("Poor");
		mv.addObject("rating", rating);
		mv.addObject("hotelData",hotelData);
		mv.addObject("update", new HotelDto());
		return mv;
	}
	@RequestMapping(value="/update",method=RequestMethod.POST)
	public ModelAndView updateHotel(@ModelAttribute("update") @Valid HotelDto hotel,BindingResult result){
		/*HotelDto hotelData=hbmsService.retrieveHotelData(hotel.getHotelId());*/
		if(result.hasErrors()){

			mv=new ModelAndView("HBMS_Admin_UpdateHotel");
			ArrayList<String>	cityList=new ArrayList<String>();
			cityList.add("Anantapur");
			cityList.add("Hyderabad");
			cityList.add("Bangalore");
			cityList.add("Chennai");
			cityList.add("Kolkata");
			cityList.add("Noida");
			cityList.add("Pune");
			cityList.add("Goa");
			cityList.add("Vizag");
			cityList.add("New Delhi");
			cityList.add("Maisore");
			cityList.add("Nellore");
			cityList.add("Medchal");
			mv.addObject("cityList",cityList);

			ArrayList<String>	rating=new ArrayList<String>();
			rating.add("Good");
			rating.add("Average");
			rating.add("Poor");
			mv.addObject("rating", rating);
			/*mv.addObject("hotelData",hotelData);*/
			return mv;
		}else{



			try {
				System.out.println(hotel.toString());
				hbmsService.updateHotel(hotel);

				List<HotelDto> hotelList;

				hotelList = hbmsService.getAllHotels();
				mv = new ModelAndView("HBMS_Admin_HotelManagement");
				mv.addObject("hotelList",hotelList);
				return mv;
			} catch (HotelException e) {
				mv=new ModelAndView("error");
				mv.addObject("exception",e.getMessage());
				return mv;
			}
		}
	}


	//Room management
	@RequestMapping("/roomManagement")
	public ModelAndView roomManagementOperations()
	{
		List<HotelDto> hotelList;
		try {
			hotelList = hbmsService.getAllHotels();
			mv = new ModelAndView("HBMS_Admin_RoomManagement");
			mv.addObject("hotelList",hotelList);
			return mv;

		} catch (HotelException e) {
			mv=new ModelAndView("error");
			mv.addObject("exception",e.getMessage());
			return mv;
		}

	}

	@RequestMapping("/hotelRooms")
	public ModelAndView getHotelRoomsByHotelId(@RequestParam("hId") int hotelId){

		List<RoomDto> hotelRooms;
		hotelRooms = hbmsService.getAllRoomsInHotel(hotelId);

		mv = new ModelAndView("HBMS_Admin_HotelRooms");
		mv.addObject("hotelRooms",hotelRooms);
		mv.addObject("hotelId", hotelId);
		return mv;





	}



	//Add room

	@RequestMapping("/deleteRooms")
	public ModelAndView deleteRoomByHotelId(@RequestParam("hId") int hotelId,@RequestParam("rId") int roomId){


		hbmsService.deleteRoomByRoomId(roomId);

		List<RoomDto> hotelRooms = hbmsService.getAllRoomsInHotel(hotelId);
		mv = new ModelAndView("HBMS_Admin_HotelRooms");


		mv.addObject("hotelRooms",hotelRooms);
		mv.addObject("hotelId", hotelId);
		return mv;


	}

	@RequestMapping("/addRoom")
	public ModelAndView addRoomInHotel(@RequestParam("hId") int hotelId)
	{
		System.out.println("In add rokom  "+hotelId);
		mv = new ModelAndView("HBMS_Admin_AddRoom");
		mv.addObject("addRoom", new RoomDto());
		mv.addObject("hotelId",hotelId);
		return mv;

	}
	@RequestMapping("/addRoomData")
	public ModelAndView addRoomData(@ModelAttribute("addRoom") @Valid  RoomDto roomDto,BindingResult result) 
	{
		if(result.hasErrors()){

			mv = new ModelAndView("HBMS_Admin_AddRoom");

			mv.addObject("hotelId",roomDto.getHotelId());
			return mv;
		}
		System.out.println("before"+roomDto);
		hbmsService.addNewRoom(roomDto);

		List<RoomDto> hotelRooms = hbmsService.getAllRoomsInHotel(roomDto.getHotelId());
		mv = new ModelAndView("HBMS_Admin_HotelRooms");
		mv.addObject("hotelRooms",hotelRooms);
		mv.addObject("hotelId",roomDto.getHotelId());
		return mv;


	} 


	@RequestMapping("/viewDetails")
	public ModelAndView viewDetails() 
	{
		mv = new ModelAndView("HBMS_Admin_ViewDetails");
		return mv;

	}
	@RequestMapping("/searchHotel")
	public ModelAndView searchHotel() 
	{
		mv = new ModelAndView("searchHotel");
		return mv;

	}
	@RequestMapping("/searchHotelById")
	public ModelAndView searchHotelByHotelId(@RequestParam("hotelId")int hotelId){
		HotelDto hotelData=hbmsService.retrieveHotelData(hotelId);
		mv = new ModelAndView("specificHotelDetails");

		mv.addObject("hotelData",hotelData);
		/*mv.addObject("update", new HotelDto());*/
		return mv;

	}
	@RequestMapping("/searchRoom")
	public ModelAndView searchRoom() 
	{
		mv = new ModelAndView("searchRoom");
		return mv;

	}

	@RequestMapping("/searchRoomById")
	public ModelAndView searchRoomByRoomId(@RequestParam("roomId")int roomId){
		RoomDto roomData=hbmsService.retrieveRoomDataByRoomId(roomId);
		mv = new ModelAndView("specificRoomDetails");

		mv.addObject("roomData",roomData);
		/*mv.addObject("update", new HotelDto());*/
		return mv;

	}


	@RequestMapping("/updateRooms")
	public ModelAndView updateRoomInHotel(@RequestParam("hId") int hotelId,@RequestParam("rId") int roomId){

		RoomDto roomDto=hbmsService.updateRoom(roomId);

		ModelAndView mv=new ModelAndView("HBMS_Admin_UpdateRoom");
		mv.addObject("roomDto",roomDto);
		mv.addObject("updateRoom", new RoomDto());
		return mv;

	}

	@RequestMapping("/updateOneRoom")
	public ModelAndView updateRoom(@ModelAttribute("updateRoom") @Valid  RoomDto roomDto,BindingResult result){

		if(result.hasErrors()){
			ModelAndView mv=new ModelAndView("HBMS_Admin_UpdateRoom");
			return mv;

		}
		List<RoomDto> hotelRooms;
		hbmsService.upadateRoomDetails(roomDto);
		hotelRooms = hbmsService.getAllRoomsInHotel(roomDto.getHotelId());

		mv = new ModelAndView("HBMS_Admin_HotelRooms");
		mv.addObject("hotelRooms",hotelRooms);
		mv.addObject("hotelId",roomDto.getHotelId());

		return mv;

	}

	@RequestMapping("/viewListOfHotels")
	public ModelAndView viewAllHotels(){
		List<HotelDto> hotelList;
		try {
			hotelList = hbmsService.getAllHotels();
			mv = new ModelAndView("HBMS_Admin_ViewAllHotels");
			mv.addObject("hotelList",hotelList);
			return mv;

		} catch (HotelException e) {
			mv=new ModelAndView("HBMS_Admin_Error");
			mv.addObject("exception",e.getMessage());
			return mv;
		}
	}
	@RequestMapping("/viewBookingsOfSpecificHotel")
	public ModelAndView viewBookingsOfSpecificHotel(){
		ModelAndView mv=new ModelAndView("HBMS_Admin_ViewBookingsOfSpecificHotel");
		mv.addObject("bookingsDto", new BookingsDto());

		return mv;

	}
	@RequestMapping("/displayBookingsForSpecificHotel")
	public ModelAndView displayBookingsForSpecificHotel(@ModelAttribute("bookingsDto") @Valid BookingsDto book,BindingResult result){
		if(result.hasErrors())
		{
			mv = new ModelAndView("HBMS_Admin_ViewBookingsOfSpecificHotel");
			return mv;

		}

		else{

			List<BookingsDto> bookingsDto;
			try {

				bookingsDto = hbmsService.displayBookingsForSpecificHotel(book.getHotelId());

				ModelAndView mv=new ModelAndView("HBMS_Admin_DisplayBookingsForSpecificHotel");
				if(bookingsDto.isEmpty())
				{
					mv.addObject("exception","No Bookings Available");
				}
				mv.addObject("bookingsDto",bookingsDto);
				return mv;
			} catch (HotelException e) {
				ModelAndView	mv=new ModelAndView("HBMS_Admin_Error");
				mv.addObject("exception",e.getMessage());

				return mv;

			}
		}

	}
	@RequestMapping("/bookingDetailsForSpecificDate")
	public ModelAndView bookingDetailsForSpecificDate(){

		ModelAndView mv=new ModelAndView("HBMS_Admin_BookingDetailsForSpecificDate");
		mv.addObject("bookingDto", new BookingsDto());

		return mv;

	}

	@RequestMapping("/showDetailsForSpecificDate")
	public ModelAndView showDetailsForSpecificDate(@RequestParam("date") String specificDate) {

		List<BookingsDto> bookingsDto;
		try {
			bookingsDto = hbmsService.showDetailsForSpecificDate(specificDate);
			ModelAndView mv=new ModelAndView("HBMS_Admin_DisplayBookingsForSpecificDate");
			if(bookingsDto.isEmpty())
			{
				mv.addObject("exception","No Bookings Available");
				return mv;
			}
			mv.addObject("bookingsDto",bookingsDto);
			return mv;
		} catch (HotelException e) {
			mv=new ModelAndView("HBMS_Admin_Error");
			mv.addObject("exception",e.getMessage());
			return mv;

		}




	}

}

