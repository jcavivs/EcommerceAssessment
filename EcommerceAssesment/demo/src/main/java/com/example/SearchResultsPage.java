package com.example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchResultsPage extends HomePage{

    @FindBy(xpath = "/html/body/div[1]/div/div[2]/div/div/div[2]/div[2]/div[2]/div[6]")
    WebElement itemProduct;
    
    @FindBy(xpath = "/html/body/div[1]/div/div[2]/div/div/div[2]/div[2]/div[2]/div[1]/a/div/div/div[2]/div[1]/div[1]/div")
    WebElement itemName;

    @FindBy(xpath = "/html/body/div[1]/div/div[2]/div/div/div[3]/main/section/section/div/div/div[4]/div/span")
    WebElement itemPrice;

    // /html/body/div[1]/div/div[2]/div/div/div[3]/main/section/section/div/div/div[4]/div/span

    
    public SearchResultsPage(WebDriver driver) {
        super(driver);
        //TODO Auto-generated constructor stub
    }

    public String mySearchresult(){
        return searchResult.getText();
    }

    public String mySearchitem(){
        return searchbox.getAttribute("value");
    }
    
    public String itemNameresult(){
        return itemName.getText();
    }

     public String prodPrice(){
        return itemPrice.getText();
    }

    public void clickItem(){
        itemProduct.click();
    }



    
 
    

}