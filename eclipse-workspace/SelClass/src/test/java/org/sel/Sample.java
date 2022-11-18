package org.sel;


import static org.junit.Assert.assertEquals;

import java.io.IOException;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebElement;

import junit.framework.Assert;

public class Sample extends BaseClass {
	@BeforeClass
	public static void beforeclass() {
		getDriver();
		getUrl("https://adactinhotelapp.com/");
		maximize();
	
	}
	
	@Test
	public void login() throws IOException, InterruptedException {
		WebElement txtUserName = byid("username");
		String userName =getDataFromCell("Sheet3", 18, 0);
		sendKeys(txtUserName, userName);
		
	
	 WebElement txtPassWord =byid("password");
	 String userPass = getDataFromCell("Sheet3", 19, 0);
	  sendKeys(txtPassWord, userPass);
	  
	  WebElement btnLogIn = byid("login");
      click(btnLogIn);
      
      WebElement txtloginSuccess =byid("username_show");
 	 String actloginsuccessmsg = getAttribute(txtloginSuccess);
 	 assertEquals("Verify after Login","Hello Shakeels!",actloginsuccessmsg);
	  
 	childWindow();
	
	WebElement ddnLocation = byid("location");
	click(ddnLocation);
	String location = getDataFromCell("Sheet3", 1, 1);
	selectByValue(ddnLocation, location);
    click(ddnLocation);
			
	WebElement ddnHotels = byid("hotels");
	click(ddnHotels);
	String hotel = getDataFromCell("Sheet3", 1, 0);
	selectByValue(ddnHotels, hotel);
	click(ddnHotels);

	WebElement ddnRoomType = byid("room_type");
	click(ddnRoomType);
	String roomType = getDataFromCell("Sheet3", 1, 2);
	selectByValue(ddnRoomType, roomType);
	click(ddnRoomType);

	WebElement ddnRoomCount = byid("room_nos");
	click(ddnRoomCount);
	String roomNo = getDataFromCell("Sheet3", 1, 3);
	selectByValue(ddnRoomCount, roomNo);
	click(ddnRoomCount);
	
	WebElement checkInDate = byid("datepick_in");
	checkInDate.clear();
	String dateIn = getDataFromCell("Sheet3", 1, 4);
	sendKeys(checkInDate, dateIn);
	
	WebElement checkOutDate = byid("datepick_out");
	checkOutDate.clear();
	String dateOut = getDataFromCell("Sheet3", 1, 5);
	sendKeys(checkOutDate, dateOut);
	
	WebElement adultNos = byid("adult_room");
	adultNos.click();
	String adult = getDataFromCell("Sheet3", 1, 6);
	selectByValue(adultNos, adult);
	
	
	WebElement childNos = byid("child_room");
	String child = getDataFromCell("Sheet3", 1, 7);
	selectByValue(childNos, child);
	
	WebElement btnSearch = byid("Submit");
	click(btnSearch);
	
WebElement byselecthotel = byclassname("login_title");
String actsearchmsg = gettext(byselecthotel);
 assertEquals("Verify after search","Select Hotel",actsearchmsg);
 
 childWindow();
	
	WebElement radioBtn = byid("radiobutton_0");
	click(radioBtn);
	
	WebElement btnContinue = byid("continue");
	click(btnContinue);
	
	childWindow();
	
	WebElement firstName = byid("first_name");
	String name = getDataFromCell("Sheet3", 1, 13);
	sendKeys(firstName, name);
	
	WebElement lastName = byid("last_name");
	String lName = getDataFromCell("Sheet3", 1, 14);
	sendKeys(lastName, lName);
	
	WebElement billingAdd =byid("address");
	String add = getDataFromCell("Sheet3", 1, 15);
	sendKeys(billingAdd, add);
	
	WebElement creditCardNo = byid("cc_num");
	String card = getDataFromCell("Sheet3", 1, 16);
	sendKeys(creditCardNo, card);

	WebElement cardType = byid("cc_type");
	click(cardType);
	String type = getDataFromCell("Sheet3", 1, 17);
	selectByValue(cardType, type);
	click(cardType);
	
	WebElement  selectMonth = byid("cc_exp_month");
	click(selectMonth);
	String month = getDataFromCell("Sheet3", 1, 18);
	selectByValue(selectMonth, month);
	click(selectMonth);
	
	WebElement selectYear = byid("cc_exp_year");
	click(selectYear);
	String year = getDataFromCell("Sheet3", 1, 19);
	selectByValue(selectYear, year);
	click(selectYear);
	
	WebElement cvv = byid("cc_cvv");
	String cvvNo = getDataFromCell("Sheet3", 1, 20);
	sendKeys(cvv, cvvNo);
	
	WebElement bybookhotel = byxpath("//td[text()='Book A Hotel ']");
	String actbookingmsg = gettext(bybookhotel);
	 assertEquals("Verify book hotel","Book A Hotel",actbookingmsg);
	
	
	WebElement btnBookNow = byid("book_now");
	click(btnBookNow);
	Thread.sleep(5000	);
	WebElement bookcnf = byxpath("//td[text()='Booking Confirmation ']");
	String actbookcnf = gettext(bookcnf);
	 assertEquals("Verify book confirm","Booking Confirmation",actbookcnf);
	 
	 Thread.sleep(5000	);
		
		
		WebElement byid = byid("order_no");
		
		Thread.sleep(5000);
		
		String attribute = getAttribute(byid);
		System.out.println(attribute);
		insertDataInCell("Sheet3", 1, 21, attribute);
	  
	  
	}
	@AfterClass
	public static void afterClass() {
		// TODO Auto-generated method stub
	}
}
