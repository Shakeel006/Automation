package org.sel;
import java.io.IOException;

import org.openqa.selenium.*;
public class Test {
	public static void main(String[] args) throws IOException, InterruptedException {
		BaseClass b = new BaseClass();
		b.getDriver();
		
		b.fluentwait(600, 300);
		
		b.getUrl("http://adactinhotelapp.com/");
		
		b.maximize();
		
		WebElement txtUserName = b.byid("username");
		String userName = b.getDataFromCell("Sheet3", 18, 0);
		b.sendKeys(txtUserName, userName);
		
		WebElement txtPassWord = b.byid("password");
		String userPass = b.getDataFromCell("Sheet3", 19, 0);
		b.sendKeys(txtPassWord, userPass);

		WebElement btnLogIn = b.byid("login");
		b.click(btnLogIn);
	
		b.childWindow();
		
		WebElement ddnLocation = b.byid("location");
		b.click(ddnLocation);
		String location = b.getDataFromCell("Sheet3", 1, 1);
		b.selectByValue(ddnLocation, location);
		b.click(ddnLocation);
				
		WebElement ddnHotels = b.byid("hotels");
		b.click(ddnHotels);
		String hotel = b.getDataFromCell("Sheet3", 1, 0);
		b.selectByValue(ddnHotels, hotel);
		b.click(ddnHotels);
	
		WebElement ddnRoomType = b.byid("room_type");
		b.click(ddnRoomType);
		String roomType = b.getDataFromCell("Sheet3", 1, 2);
		b.selectByValue(ddnRoomType, roomType);
		b.click(ddnRoomType);
	
		WebElement ddnRoomCount = b.byid("room_nos");
		b.click(ddnRoomCount);
		String roomNo = b.getDataFromCell("Sheet3", 1, 3);
		b.selectByValue(ddnRoomCount, roomNo);
		b.click(ddnRoomCount);
		
		WebElement checkInDate = b.byid("datepick_in");
		checkInDate.clear();
		String dateIn = b.getDataFromCell("Sheet3", 1, 4);
		b.sendKeys(checkInDate, dateIn);
		
		WebElement checkOutDate = b.byid("datepick_out");
		checkOutDate.clear();
		String dateOut = b.getDataFromCell("Sheet3", 1, 5);
		b.sendKeys(checkOutDate, dateOut);
		
		WebElement adultNos = b.byid("adult_room");
		adultNos.click();
		String adult = b.getDataFromCell("Sheet3", 1, 6);
		b.selectByValue(adultNos, adult);
		
		
		WebElement childNos = b.byid("child_room");
		String child = b.getDataFromCell("Sheet3", 1, 7);
		b.selectByValue(childNos, child);
		
		WebElement btnSearch = b.byid("Submit");
		b.click(btnSearch);
		
		b.childWindow();
		
		WebElement radioBtn = b.byid("radiobutton_0");
		b.click(radioBtn);
		
		WebElement btnContinue = b.byid("continue");
		b.click(btnContinue);
		
		b.childWindow();
		
		WebElement firstName = b.byid("first_name");
		String name = b.getDataFromCell("Sheet3", 1, 13);
		b.sendKeys(firstName, name);
		
		WebElement lastName = b.byid("last_name");
		String lName = b.getDataFromCell("Sheet3", 1, 14);
		b.sendKeys(lastName, lName);
		
		WebElement billingAdd = b.byid("address");
		String add = b.getDataFromCell("Sheet3", 1, 15);
		b.sendKeys(billingAdd, add);
		
		WebElement creditCardNo = b.byid("cc_num");
		String card = b.getDataFromCell("Sheet3", 1, 16);
		b.sendKeys(creditCardNo, card);

		WebElement cardType = b.byid("cc_type");
		b.click(cardType);
		String type = b.getDataFromCell("Sheet3", 1, 17);
		b.selectByValue(cardType, type);
		b.click(cardType);
		
		WebElement  selectMonth = b.byid("cc_exp_month");
		b.click(selectMonth);
		String month = b.getDataFromCell("Sheet3", 1, 18);
		b.selectByValue(selectMonth, month);
		b.click(selectMonth);
		
		WebElement selectYear = b.byid("cc_exp_year");
		b.click(selectYear);
		String year = b.getDataFromCell("Sheet3", 1, 19);
		b.selectByValue(selectYear, year);
		b.click(selectYear);
		
		WebElement cvv = b.byid("cc_cvv");
		String cvvNo = b.getDataFromCell("Sheet3", 1, 20);
		b.sendKeys(cvv, cvvNo);
		
		WebElement btnBookNow = b.byid("book_now");
		b.click(btnBookNow);
		
		
		Thread.sleep(5000	);
		
		
		WebElement byid = b.byid("order_no");
		
		Thread.sleep(5000);
		
		String attribute = b.getAttribute(byid);
		System.out.println(attribute);
		b.insertDataInCell("Sheet3", 1, 21, attribute);
		//	b.gettext("Sheet3", 1, 21, attribute);
	b.quit();
	}
}