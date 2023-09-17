package com.example;

import java.util.Set;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;

public class ECommerceTest {

    WebDriver driver;
    HomePage shopeeHomePage;
    SearchResultsPage searchpage;
    ProductDetailsPage productdetailpage;
    CartPage cartpage;
    
    @BeforeTest
    public void setup(){
        WebDriverManager.chromedriver().setup();
        
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");
        driver = new ChromeDriver(options);
        driver.get("https://shopee.ph/buyer/login");
        
    }
    
    @Test
    public void Test1Homepage() throws InterruptedException{

        shopeeHomePage = new HomePage(driver);
       
        shopeeHomePage.loginviaGoogle();
        pause();

        Set<String> windowHandles = driver.getWindowHandles();
        if (windowHandles.size() > 1) {
            for (String windowHandle : windowHandles) {
                driver.switchTo().window(windowHandle);
            }
        }
        pause();
        shopeeHomePage.enterEmail("vivo4automationtesting@gmail.com");
        pause();
        shopeeHomePage.googleNextbutton();
        pause();
        shopeeHomePage.enterPassword("rmcxaqwt");
        pause();
        shopeeHomePage.googleComplete();
        pause(); 

        driver.switchTo().window((String) windowHandles.toArray()[1]);
        Thread.sleep(5000);

        shopeeHomePage.enterItemsearch("enter item");
        pause(); 
        shopeeHomePage.searchItemButton();
        pause(); 

    }

    @Test
    public void Test2SearchResultPage() throws InterruptedException{
        searchpage = new SearchResultsPage(driver);
        String myResult = searchpage.mySearchresult();
        String mySearch = searchpage.mySearchitem();
        pause(); 
        Assert.assertEquals(myResult, mySearch);
        pause(); 
      
        searchpage.clickItem();
        pause(); 
        
    }
    

    @Test
    public void Test3ProductDetailsPage() throws InterruptedException{
        productdetailpage = new ProductDetailsPage(driver);

        String name = productdetailpage.itemName();
        String price = productdetailpage.itemPrice();
        String desc = productdetailpage.itemDesc();
        
        System.out.println("Product name: " + name + "\nProduct Price: " + price + "\nProduct Description: " + desc);
        Assert.assertFalse(name.isBlank());
        Assert.assertFalse(price.isBlank());
        Assert.assertFalse(desc.isBlank());
        productdetailpage.addtoCart();
        pause();

    }

    @Test
    public void Test4CartPage() throws InterruptedException{
        cartpage = new CartPage(driver);
        pause();
        cartpage.addtocartPage();
        pause();
        String ctitle = cartpage.productName();
        pause();
        String cprice = cartpage.prodPrice();

        System.out.println("\nAdd to cart title: " + ctitle + "\n" + cprice );

        Assert.assertFalse(ctitle.isBlank());
        Assert.assertFalse(cprice.isBlank());
    }

    @AfterTest
    public void quitDriver(){
        driver.quit();
    }

    private void pause() throws InterruptedException{
        Thread.sleep(2000);
    }
    
}