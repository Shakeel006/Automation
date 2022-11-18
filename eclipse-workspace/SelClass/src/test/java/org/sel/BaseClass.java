package org.sel;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
//1
	public static WebDriver driver;
//2	  
    public static void getDriver() {
    	WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
	}
//3
    public static void getcurrenturl() {
    	driver.getCurrentUrl();
    }
//4	    
	public static void maximize() {
		driver.manage().window().maximize();
	} 
//5
	public static void getUrl(String url) {
		driver.get(url);
	}
//6
	public String getTitle() {
		String title = driver.getTitle();
		return title;	
	}
//7
	public WebElement byid(String id) {
		WebElement findElement = driver.findElement(By.id(id));
		return findElement;	
	}
//8
	public WebElement byxpath(String xpath) {
		WebElement findElement = driver.findElement(By.xpath(xpath));
		return findElement;	
	}
//9
	public WebElement byname(String name) {
		WebElement findElement = driver.findElement(By.name(name));
	    return findElement;	
	}
	    public WebElement byclassname(String name) {
			WebElement findElement = driver.findElement(By.className(name));
		    return findElement;	
	}
//10
	public void sendKeys(WebElement element,String value) {
		element.sendKeys(value);
	}
//11
	public void click(WebElement element) {
		element.click();
		}
//12
	public String getAttribute(WebElement element) {
		String attribute = element.getAttribute("value");
		System.out.println(attribute);
		return attribute;
	}
//13
	public String gettext(WebElement element) {
		String text = element.getText();
		System.out.println(text);
		return text;
	}
//14
	public void movetoelement(WebElement element,String xpath) {
		Actions x = new Actions(driver);
		x.moveToElement(element).perform();
		driver.findElement(By.xpath(xpath)).click();
	}
//15
	public void draganddrop(WebElement source,WebElement destination) {
		Actions x=new Actions(driver);
		x.dragAndDrop(source, destination).perform();
	}
//16
	public void screenshot(String path) throws Exception {
		TakesScreenshot ts = (TakesScreenshot)driver;
		File screenshotAs = ts.getScreenshotAs(OutputType.FILE);
		File file = new File(path);
		FileUtils.copyFile(screenshotAs, file);
	}
//17
	public void keyboardactions(Keys shift,WebElement element,String input) {
		Actions actions =new Actions(driver);
		actions.keyDown(shift).sendKeys(element,input).keyUp(shift).perform();
	}
//18
	public void doubleclick(WebElement element) {
		Actions actions = new Actions(driver);
		actions.doubleClick(element).perform();
	}
//19
	public void alertaccept() {
		Alert alert = driver.switchTo().alert();
		alert.accept();
	}
//20
	public void alertdismiss() {
		Alert alert = driver.switchTo().alert();
		alert.dismiss();
	}
//21
	public Alert alert(String input) {
		Alert alert = driver.switchTo().alert();
		return alert;
	}
//22
	public void jssetattribute(WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].setAttribute('value',’yogesh')", element);
	}
//23
	public void jsgetattribute(WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor)driver;
		Object executeScript = js.executeScript("arguments[0].getAttribute('value')", element);
		String string = executeScript.toString();
		System.out.println(string);
	}
//24
	public void jsclick(WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].click()",element);
	}
//25
	public void frameid(String id) {
		driver.switchTo().frame(id);
	}
//26
	public void frameelement(WebElement element) {
		driver.switchTo().frame(element);
	}
//27
	public void frameindex(int index) {
		driver.switchTo().frame(index);
	}
//28
	public void parentframe() {
		driver.switchTo().parentFrame();
	}
//29
	public List<WebElement> noofframes(String id) {
		List<WebElement>list = (List<WebElement>) driver.findElement(By.tagName(id));
		int size = list.size();
		System.out.println(size);
		return list;
	}
//30
	public void childWindow() {
		String parent = driver.getWindowHandle();
		Set<String> allWindow = driver.getWindowHandles();
		for (String eachWindow : allWindow) {
		if(!eachWindow.equals(parent)) {
		driver.switchTo().window(eachWindow);
	}}}
//31
	public void backToParentWindow() {
		String parent = driver.getWindowHandle();
		Set<String>both = driver.getWindowHandles();
		for (String x : both) {
		if(parent.equals(x)) {
		driver.switchTo().window(x);
	}}}
//32
	public void windowhandling(int index) {
		Set<String>windowHandles = driver.getWindowHandles();
		List<String>li = new ArrayList<String>();
		li.addAll(windowHandles);
		String x = li.get(index);
		driver.switchTo().window(x);
	}
//33
	public void navigateTo(String url) {
		driver.navigate().to(url);
	}
//34
	public void navigateBack() {
		driver.navigate().back();
	}
//35
	public void navigateForward() {
		driver.navigate().forward();
	}
//36
	public void navigateRefresh() {
		driver.navigate().refresh();
	}
//37	
	public void selectByIndex(WebElement element,int index) {
		Select s = new Select(element);
		s.selectByIndex(index);
	}
//38
	public void selectByValue(WebElement element,String value) {
		Select s = new Select(element);
		s.selectByValue(value);
	}
//39
	public void selectByVisibleText(WebElement element,String text) {
		Select s = new Select(element);
		s.selectByVisibleText(text);
	}
//40
	public void deselectAll(WebElement element) {
		Select s = new Select(element);
		s.deselectAll();
	}
//41
    public void deselectByIndex(WebElement element,int index) {
		Select s = new Select(element);
		s.deselectByIndex(index);
	}
//42
    public void deselectByValue(WebElement element,String value) {
		Select s = new Select(element);
	    s.deselectByValue(value);
	}
//43
    public void deselectByVisibleText(WebElement element,String text) {
		Select s = new Select(element);
		s.deselectByVisibleText(text);
	}
//44	   
    public boolean isMultiple (WebElement element) {
		Select s = new Select(element);
		boolean b = s.isMultiple();	
		return b;	
	}
//45
    public void getfirstselectedoption(WebElement element) {
		Select s = new Select(element);
		WebElement firstSelectedOption = s.getFirstSelectedOption();
		System.out.println(firstSelectedOption);
	}
//46
    public void getoptions(WebElement element) {
		Select s = new Select(element);
		List<WebElement>options = s.getOptions();
		for(int i=0;i<options.size();i++) {
		options.get(i);
	}}
//47
    public void jsscrolldown(WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeAsyncScript("arguments[0].Scrollintoview(true)" ,element);
	}
//48
    public void jsscrollup(WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeAsyncScript("arguments[0].Scrollintoview(false)",element);
	}
//49
    public void nooftables() {
		List<WebElement>findElements = driver.findElements(By.tagName("table"));
		int size = findElements.size();
		System.out.println(size);
	}
//50
    public void gettextxt(int index) {
		List<WebElement>findElements = driver.findElements(By.tagName("table"));
		WebElement a = findElements.get(index);
		List<WebElement>findElements2 = a.findElements(By.tagName("tr"));
		for (WebElement x : findElements2) {
		String text = x.getText();
		System.out.println(text);
	}}
//51
    public void gettextweb(int index) {
		List<WebElement>e = driver.findElements(By.tagName("table"));
	    WebElement ee = e.get(index);
		String text = ee.getText();
		System.out.println(text);
	}
//52
    public void quit() {
		driver.quit();
	}
//53
    public void close() {
    	driver.close();
	}
//54
    public  String excelread(String path,String sheet,int i,int j) throws Exception{
		String value = null;
		return value;
    }
//55
    public void getselectedoption(WebElement element) {
	    Select s = new Select(element);
		List<WebElement>options = s.getAllSelectedOptions();
		for (WebElement x : options) {
		String text = x.getText();
		System.out.println(text);	
	}}
//56
    public void implicitywait() {
		driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
	}
//57
    public void fluentwait(int sec,int interval) {
		FluentWait w=new FluentWait(driver).withTimeout(Duration.ofSeconds(sec)).pollingEvery(Duration.ofSeconds(interval)).ignoring(NoSuchElementException.class);
	}
//58			
	public String getDataFromCell(String sheetName ,int rowNum ,int cellNum )throws IOException  {
		String res= " " ;
		File file =new File("C:\\Users\\LENOVO\\eclipse-workspace\\SelClass\\Base\\Data.xlsx");
		FileInputStream fileInputStream = new  FileInputStream(file);
		Workbook workbook= new XSSFWorkbook(fileInputStream);
		Sheet sheet=workbook.getSheet(sheetName);
		Row row=sheet.getRow(rowNum);
		Cell cell=row.getCell(cellNum);
		CellType type=cell.getCellType();
		switch (type) {
			case STRING:
				res=cell.getStringCellValue();
			break;
			  case NUMERIC:
				if (DateUtil.isCellDateFormatted(cell)) {
					Date dateCellValue=cell.getDateCellValue();
					SimpleDateFormat dateFormat =new SimpleDateFormat("dd/MM/yyyy");
					res=dateFormat.format(dateCellValue);
				}
				else {
					double numericCellValue=cell.getNumericCellValue();
					long check =Math.round(numericCellValue);
					    if (numericCellValue==check) {
						res=String.valueOf(check);
						}}
			default:
				break;
			}
			return res;
	}
//59
	public void updateDataInCell(String sheetName ,int rowNum ,int cellNum, String oldData, String newData )throws IOException  {
		File file =new File("C:\\Users\\LENOVO\\eclipse-workspace\\SelClass\\Base\\Data.xlsx");
		FileInputStream fileInputStream = new  FileInputStream(file);
		Workbook workbook= new XSSFWorkbook(fileInputStream);
		Sheet sheet=workbook.getSheet(sheetName);
		Row row=sheet.getRow(rowNum);
		Cell cell=row.getCell(cellNum);
		CellType type=cell.getCellType();
	    String value=cell.getStringCellValue();
	    	if (value.equals(oldData)) {
		    	cell.setCellValue(newData);
		    }
	    FileOutputStream out= new FileOutputStream(file);
	    workbook.write(out);
	}
//60			
	public void insertDataInCell(String sheetName ,int rowNum ,int cellNum, String data )throws IOException  {
		File file =new File("C:\\Users\\LENOVO\\eclipse-workspace\\SelClass\\Base\\Data.xlsx");
		FileInputStream fileInputStream = new  FileInputStream(file);
		Workbook workbook= new XSSFWorkbook(fileInputStream);
		Sheet sheet=workbook.getSheet(sheetName);
		Row row=sheet.getRow(rowNum);
		Cell cell=row.createCell(cellNum);
		cell.setCellValue(data);
		FileOutputStream out= new FileOutputStream(file);
	    workbook.write(out);
		}
	


	
	
	}