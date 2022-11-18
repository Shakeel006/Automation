package org.sel;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CancelBookingPage extends BaseClass {
	public CancelBookingPage() {
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//*[@id=\"order_id_text\"]")
	private WebElement txtOrderId;
	@FindBy(xpath="//*[@id=\"check_all\"]")
	private WebElement Cancelbtn;
	
	@FindBy(id="search_hotel_id")
	private WebElement btnGo;
	@FindBy(name="cancelall")
	private WebElement btnCancel;
	public WebElement getBtnCancel() {
		return btnCancel;
	}
	public WebElement getCancelbtn() {
		return Cancelbtn;
	}
	public WebElement getTxtOrderId() {
		return txtOrderId;
	}
	public WebElement getBtnGo() {
		return btnGo;
	}
	public void cancelBooking(String txtorderid) throws IOException {

		String fromCell = getDataFromCell("Sheet3", 1, 21);
		sendKeys(getTxtOrderId(), fromCell);
		click(btnGo);
		click(btnCancel);

	}

}
