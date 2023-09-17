package com.example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductDetailsPage extends SearchResultsPage {

    @FindBy(className = "KmiQIK")
    WebElement productItemName ;

    @FindBy(className = "pqTWkA")
    WebElement productPrice;

    @FindBy(className =  "irIKAp")
    WebElement productDesc;

    @FindBy(className = "btn-tinted")
    WebElement addtocartButton ;

    public ProductDetailsPage(WebDriver driver) {
        super(driver);
        //TODO Auto-generated constructor stub
    }

    public String itemName(){
        return productItemName.getText();
    }

    public String itemPrice(){
        return productPrice.getText();
    }

    public String itemDesc(){
        return productDesc.getText();
    }

    public void addtoCart(){
        addtocartButton.click();
    }

    

    // pqTWkA


    
}
