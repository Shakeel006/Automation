package org.sel;

import static org.junit.Assert.assertEquals;

import java.io.IOException;

import org.apache.poi.ss.usermodel.ReadingOrder;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class PomAdactin extends BaseClass{
	
@BeforeClass
public static void triggerUrl()
{
	getDriver();
	getUrl("http://adactinhotelapp.com/");
	maximize();
	
}
	

	
@Test
public void booking() throws IOException, InterruptedException {
	
	// Login Page
LoginPage loginPage=new LoginPage();


loginPage.login(getDataFromCell("Sheet3", 18, 0), getDataFromCell("Sheet3", 19, 0));
WebElement txtloginSuccess =byid("username_show");
 String actloginsuccessmsg = getAttribute(txtloginSuccess);
 assertEquals("Verify after Login","Hello Shakeels!",actloginsuccessmsg);

   // Search Hotel
SearchHotelPage searchHotel=new SearchHotelPage();
searchHotel.searchHotels(getDataFromCell("Sheet3", 1, 1),getDataFromCell ("Sheet3", 1, 0), getDataFromCell("Sheet3", 1, 2),getDataFromCell("Sheet3", 1, 3),getDataFromCell("Sheet3", 1, 4),
		getDataFromCell("Sheet3", 1, 5),getDataFromCell("Sheet3", 1, 6),getDataFromCell("Sheet3", 1, 7));

//select Hotel
 
SelectHotelPage selecthotel=new  SelectHotelPage();
selecthotel.selectHotel();

//bookhotel
BookHotelPage bookHotel=new BookHotelPage();
bookHotel.bookHotel(getDataFromCell("Sheet3", 1, 13), getDataFromCell("Sheet3", 1, 14), getDataFromCell("Sheet3", 1, 15),getDataFromCell("Sheet3", 1, 16), getDataFromCell("Sheet3", 1, 17), 
		getDataFromCell("Sheet3", 1, 18), getDataFromCell("Sheet3", 1, 19),getDataFromCell("Sheet3", 1, 20));

//Book Hotel Page Confirm
BookingCofirmPage confirmBook=new BookingCofirmPage();
WebElement Getattribute = confirmBook.getTxtOrderNum();

Thread.sleep(5000);
String gettext = gettext(Getattribute);
Thread.sleep(5000);
WebElement orderNum = confirmBook.getTxtOrderNum();
String orderId = getAttribute(orderNum);
System.out.println(orderId);
insertDataInCell("Sheet3", 1, 21, orderId);
confirmBook.confirmBook(orderId);

//Cancel booking
CancelBookingPage cancelBookingPage=new CancelBookingPage();
Thread.sleep(5000);
cancelBookingPage.cancelBooking(orderId);
cancelBookingPage.getBtnGo();
cancelBookingPage.wait(2000);
cancelBookingPage.alertaccept();
cancelBookingPage.getBtnCancel();




}
}
	
	

