package com.library.pages;

import com.library.utility.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

public class BorrowedBooksPage extends BasePage{


    @FindBy(xpath = "//tbody//td[2]")
    public List<WebElement> allBorrowedBooksName;

    public String locateBorrowedBook(String bookName){


        List<WebElement> bookList = Driver.getDriver().findElements(By.xpath("//tbody/tr/td[2]"));

        for (WebElement currentBook : bookList) {
            String currentBookName = currentBook.getText();
            if (currentBookName.equals(bookName)) {
                return currentBookName;
            }
        }
        return "Book not found";
    }






}
