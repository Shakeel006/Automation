package org.sel;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SelectHotelPage extends BaseClass{
	public SelectHotelPage() {
		PageFactory.initElements(driver, this);
	}
	@FindBy(id="radiobutton_0")
	private WebElement radioSelect;
	
	@FindBy(id="continue")
	private WebElement btnContinue;
	
	
	public WebElement getRadioSelect() {
		return radioSelect;
	}
	public WebElement getBtnContinue() {
		return btnContinue;
	}
	public void selectHotel() {
		
click(getRadioSelect());
click(getBtnContinue());


	}

}
