package com.example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CartPage extends ProductDetailsPage{

    public CartPage(WebDriver driver) {
        super(driver);
        //TODO Auto-generated constructor stub
    }
    
    @FindBy(xpath = "/html/body/div[1]/div/div[2]/div[1]/header/div[2]/div/div[2]/div/div/div/a")
    WebElement addtocardlogo;

    @FindBy(className = "JB57cn")
    WebElement prodTitle;

    @FindBy(css =  "div.ofQLuG span")
    WebElement prodPrice;

    public void addtocartPage(){
        addtocardlogo.click();
    }

    public String productName(){
        return prodTitle.getAttribute("title");
    }

    public String productPrice(){
        return prodPrice.getText();
    }
    
}
