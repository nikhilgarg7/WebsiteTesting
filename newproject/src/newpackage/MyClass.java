package newpackage;


import javax.xml.parsers.ParserConfigurationException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.TestNGException;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;


//comment the above line and uncomment below line to use Chrome
//import org.openqa.selenium.chrome.ChromeDriver;


public class MyClass {
	
	WebDriver driver;	
	@BeforeTest( )
	@Parameters("browser")
	
	public void OpenBrowser(String browser) throws Exception,TestNGException,SAXParseException,ParserConfigurationException,SAXException{
	 
		//Check if parameter passed from TestNG is 'firefox'
		if(browser.equalsIgnoreCase("firefox")){
			System.setProperty("webdriver.gecko.driver", "C:\\Users\\nikhi\\Downloads\\Selenium\\driver\\geckodriver.exe");
			driver = new FirefoxDriver();
			System.out.println("-----Firefox-----");
		}
		
		//Check if parameter passed as 'chrome'
		else if(browser.equalsIgnoreCase("chrome")){
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\nikhi\\Downloads\\Selenium\\driver\\chromedriver.exe");
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			System.out.println("-----Chrome-----");
		}
		
		//Check if parameter passed as 'Edge'
		else if(browser.equalsIgnoreCase("IE")){	
			System.setProperty("webdriver.ie.driver", "C:\\Users\\nikhi\\Downloads\\Selenium\\driver\\IEDriverServer.exe");
			DesiredCapabilities caps = DesiredCapabilities.internetExplorer();
			caps.setCapability("ignoreZoomSetting", true);
			driver = new InternetExplorerDriver(caps);
			driver.manage().window().maximize();
			System.out.println("-----Edge-----");
		}
		
		//Check if parameter passed as 'IE'
		else if(browser.equalsIgnoreCase("Edge")){
			System.setProperty("webdriver.edge.driver", "C:\\Users\\nikhi\\Downloads\\Selenium\\driver\\MicrosoftWebDriver.exe");
			DesiredCapabilities caps = DesiredCapabilities.edge();
			caps.setCapability("ignoreZoomSetting", true);
			driver = new EdgeDriver(caps);
			driver.manage().window().maximize();
			System.out.println("-----IE-----");
		}

		else{
			//If no browser passed throw exception
			throw new Exception("Browser is not correct");
		}
		
		//driver.manage().window().maximize();
		System.out.println(driver.getTitle());
		System.out.println("-----------------------------------------------");
		 
	}
	
	@Test(priority=1,enabled=true)
	public void Test000() throws InterruptedException{
		
		driver.get("https://www.bemagenta.com/");
		//Thread.sleep(4000);
		
		Long loadtime = (Long)((JavascriptExecutor)driver).executeScript(
			    "return performance.timing.loadEventEnd - performance.timing.navigationStart;");
		System.out.println(loadtime);
	}	
	
		//driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
	@Test(priority=1,enabled=false)
	public void Test001() throws InterruptedException{
		
		driver.get("http://demo.guru99.com/test/newtours/");
		
		Long loadtime = (Long)((JavascriptExecutor)driver).executeScript(
			    "return performance.timing.loadEventEnd - performance.timing.navigationStart;");
		System.out.println(loadtime);
		
		driver.manage().window().maximize();
		System.out.println(driver.getTitle());
		System.out.println("-----------------------------------------------");
		
		driver.findElement(By.name("userName")).sendKeys("abcd@gmail.com");
		driver.findElement(By.name("password")).sendKeys("abcdefghlkjl");

		WebElement LogIn = driver.findElement(By.xpath("//*[@name='submit']"));
	  		JavascriptExecutor login = (JavascriptExecutor)driver;
	  	login.executeScript("arguments[0].click();", LogIn);
	} 
	
	/* This is Registration Test */
	@Test(priority=1,enabled=false)
	public void Test002() throws InterruptedException{
		driver.get("http://demo.guru99.com/test/newtours/");
		
		Long loadtime = (Long)((JavascriptExecutor)driver).executeScript(
			    "return performance.timing.loadEventEnd - performance.timing.navigationStart;");
		System.out.println(loadtime);
		
		driver.manage().window().maximize();
		System.out.println(driver.getTitle());
		System.out.println("-----------------------------------------------");
		
		//First Name
		driver.findElement(By.name("firstName")).sendKeys("abcdefghlkjl");
		//Last Name
		driver.findElement(By.name("lastName")).sendKeys("abcdefghlkjl");
		//Phone
		driver.findElement(By.name("phone")).sendKeys("abcdefghlkjl");
		//Email
		driver.findElement(By.id("userName")).sendKeys("abcdefghlkjl");
		//Address
		driver.findElement(By.name("address1")).sendKeys("abcdefghlkjl");
		//City
		driver.findElement(By.name("city")).sendKeys("abcdefghlkjl");
		//State
		driver.findElement(By.name("country")).sendKeys("abcdefghlkjl");
		//Postal Code
		driver.findElement(By.name("password")).sendKeys("abcdefghlkjl");
		//Country
		driver.findElement(By.name("password")).sendKeys("abcdefghlkjl");
		//User Name
		
		//Password
		
		//Confirm Password
		
		
		
		
		
		
		
		
		
	}
      @AfterTest 
      public void AfterTest() throws InterruptedException{
        //close Chrome
        driver.close();
      }
    }

