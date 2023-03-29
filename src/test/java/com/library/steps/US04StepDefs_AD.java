package com.library.steps;

import com.library.pages.BookPage;
import com.library.utility.BrowserUtil;
import com.library.utility.DB_Util;
import io.cucumber.java.en.*;
import org.junit.Assert;

import java.util.List;

public class US04StepDefs_AD {

    String bookName;
    BookPage bookPage = new BookPage();
    @Given("the user navigates to {string} page_AD")
    public void the_user_navigates_to_page_ad(String book) {

        bookPage.navigateModule(book);
    }
    @When("the user searches for {string} book_AD")
    public void the_user_searches_for_book_ad(String bookName) {

        bookPage.search.sendKeys(bookName);
        this.bookName=bookName;
    }
    @When("the user clicks edit book button_AD")
    public void the_user_clicks_edit_book_button_ad() {
        bookPage.editBook(bookName).click();

    }
    @Then("book information must match the Database_AD")
    public void book_information_must_match_the_database_ad() {

       String Query ="SELECT * FROM books where name = 'LyraBook'";
        DB_Util.runQuery(Query);
        BrowserUtil.waitFor(1);
        Assert.assertEquals(DB_Util.getCellValue(1, 2), bookPage.bookName.getAttribute("value"));


    }
    @Then("should not be able to see the book information_AD")
    public void shouldNotBeAbleToSeeTheBookInformation_AD() {

        String Query ="SELECT * FROM books where name = 'LyraBook'";
        DB_Util.runQuery(Query);
        BrowserUtil.waitFor(1);

        Assert.assertFalse(bookName.equals(DB_Util.getCellValue(1, 2)));



    }
}
