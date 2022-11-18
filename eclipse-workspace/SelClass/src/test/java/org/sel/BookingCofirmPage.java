package org.sel;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BookingCofirmPage extends BaseClass {
	public BookingCofirmPage() {
		PageFactory.initElements(driver, this);
	}
	@FindBy(id="order_no")
	private WebElement txtOrderNum;
	@FindBy(xpath="//a[text()='Booked Itinerary']")
	private WebElement btnItenarary;

	public WebElement getTxtOrderNum() {
		return txtOrderNum;
	}
	public WebElement getBtnItenarary() {
		return btnItenarary;
	}
	
public void confirmBook(String orderid) {
	 getAttribute(getTxtOrderNum());
	click(btnItenarary);


}
}
