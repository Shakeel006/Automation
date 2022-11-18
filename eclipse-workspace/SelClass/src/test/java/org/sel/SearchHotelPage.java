package org.sel;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchHotelPage extends BaseClass {
	public SearchHotelPage() {
		PageFactory.initElements(driver, this);
	}
	@FindBy(id="location")
	private WebElement dDnlocation;
	@FindBy(id="username_show")
	private WebElement txtWelcomeMsg;
	@FindBy(id="hotels")
	private WebElement dDnHotels;
	@FindBy(id="room_type")
	private WebElement dDnRoomType;
	@FindBy(id="room_nos")
	private WebElement dDnRoomNo;
	@FindBy(id="datepick_in")
	private WebElement txtCheckInDate;
	@FindBy(id="datepick_out")
	private WebElement dDnCheckOutDate;
	@FindBy(id="adult_room")
	private WebElement dDnAdultsPerRoom;
	@FindBy(id="child_room")
	private WebElement dDnChildrensPerRoom;
	@FindBy(id="Submit")
	private WebElement btnSearch;
	public WebElement getdDnlocation() {
		return dDnlocation;
	}
	public WebElement getTxtWelcomeMsg() {
		return txtWelcomeMsg;
	}
	public WebElement getdDnHotels() {
		return dDnHotels;
	}
	public WebElement getdDnRoomType() {
		return dDnRoomType;
	}
	public WebElement getdDnRoomNo() {
		return dDnRoomNo;
	}
	public WebElement getTxtCheckInDate() {
		return txtCheckInDate;
	}
	public WebElement getdDnCheckOutDate() {
		return dDnCheckOutDate;
	}
	public WebElement getdDnAdultsPerRoom() {
		return dDnAdultsPerRoom;
	}
	public WebElement getdDnChildrensPerRoom() {
		return dDnChildrensPerRoom;
	}
	public WebElement getBtnSearch() {
		return btnSearch;
	}
//	@FindBy(className="login_title")
//	private WebElement getTxt;
//	
//	public WebElement getGetTxt() {
//		return getTxt;
//	}
	public void searchHotels(String location,String hotels,String roomType,
			String noOfRooms,String checkInDate,String checkOutDate,String adultsPerRoom,String childrenPerRoom)
	{

selectByValue(getdDnlocation(), location);
selectByValue(getdDnHotels(), hotels);
selectByValue(getdDnRoomType(), roomType);
selectByValue(getdDnRoomNo(), noOfRooms);
sendKeys(getTxtCheckInDate(), checkInDate);
sendKeys(getdDnCheckOutDate(), checkOutDate);
selectByValue(getdDnAdultsPerRoom(), adultsPerRoom);
selectByValue(getdDnChildrensPerRoom(), childrenPerRoom);
//gettext(getGetTxt());
gettext(getTxtWelcomeMsg());
click(getBtnSearch());

	}

}
