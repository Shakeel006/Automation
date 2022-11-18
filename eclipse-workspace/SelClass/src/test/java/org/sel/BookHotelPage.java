package org.sel;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BookHotelPage extends BaseClass {
	public BookHotelPage() {
		PageFactory.initElements(driver, this);
	}
	public WebElement getTxtFirstName() {
		return txtFirstName;
	}
	public WebElement getTxtLastName() {
		return txtLastName;
	}
	public WebElement getTxtAddress() {
		return txtAddress;
	}
	public WebElement getTxtCcNum() {
		return txtCcNum;
	}
	public WebElement getdDnCcType() {
		return dDnCcType;
	}
	public WebElement getdDnCcExpMonth() {
		return dDnCcExpMonth;
	}
	public WebElement getdDnCcExpYear() {
		return dDnCcExpYear;
	}
	public WebElement getTxtCcCvv() {
		return txtCcCvv;
	}
	public WebElement getBtnBookNow() {
		return btnBookNow;
	}
	@FindBy(id="first_name")
	private WebElement txtFirstName;
	@FindBy(id="last_name")
	private WebElement txtLastName;
	@FindBy(id="address")
	private WebElement txtAddress;
	@FindBy(id="cc_num")
	private WebElement txtCcNum;
	@FindBy(id="cc_type")
	private WebElement dDnCcType;
	@FindBy(id="cc_exp_month")
	private WebElement dDnCcExpMonth;
	@FindBy(id="cc_exp_year")
	private WebElement dDnCcExpYear;
	@FindBy(id="cc_cvv")
	private WebElement txtCcCvv;
	@FindBy(id="book_now")
	private WebElement btnBookNow;
	
public void bookHotel(String FirstName,String LastName,String Address,String CcardNum,String dDnCcardType,
		String CcardExpMonth,String CcardExpYear,String CvvNum) {
	sendKeys(txtFirstName, FirstName);
	sendKeys(txtLastName, LastName);
	sendKeys(txtAddress, Address);
	sendKeys(txtCcNum, CcardNum);
	selectByValue(dDnCcType, dDnCcardType);
	selectByValue(dDnCcExpMonth, CcardExpMonth);
	selectByValue(dDnCcExpYear, CcardExpYear);
	sendKeys(txtCcCvv, CvvNum);
	click(btnBookNow);

}
}
