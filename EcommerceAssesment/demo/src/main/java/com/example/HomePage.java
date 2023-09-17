package com.example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
        
    WebDriver driver;
    String searchresult ;
  
    // For Shopee Login

    @FindBy(className = "shopee-no-scroll")
    WebElement noscroll;

    @FindBy(xpath = "/html/body/div[1]/div/div[2]/div/div/div/div[2]/form/div/div[2]/div[5]/div[2]/button[2]")
    WebElement googleButton;

    @FindBy(css = "input[type='email']")
    WebElement email ;

    @FindBy(id = "identifierNext")
    WebElement nextButton;

    @FindBy(name = "Passwd")
    WebElement gPassword;

    @FindBy(id = "passwordNext")
    WebElement loginComplete;

    //start of search item

    @FindBy(className = "shopee-searchbar-input__input")
    WebElement searchbox;

    @FindBy(className  = "btn-solid-primary")
    WebElement searchButton ;

    @FindBy(className = "shopee-search-result-header__text-highlight")
    WebElement searchResult;
    
   
        
    public HomePage(WebDriver driver){
        this.driver = driver;
    PageFactory.initElements(driver, this);
    }

    // Start of Searching in Shopee

    public void noScroll(){
        noscroll.click();
    }

    public void enterItemsearch(String strItem){
        searchbox.sendKeys("Coffeee Maker");
    }

    public void searchItemButton(){
        searchButton.click();
    }

    // Start of Login via Google for shoppe

    public void loginviaGoogle(){
        googleButton.click();
    }

    public void enterEmail(String stremail){
        email.sendKeys("vivo4automationtesting@gmail.com");
    }

    public void googleNextbutton(){
        nextButton.click();
    }

    public void enterPassword(String strpass){
        gPassword.sendKeys("rmcxaqwt");
    }

    public void googleComplete(){
        loginComplete.click();
    }

}