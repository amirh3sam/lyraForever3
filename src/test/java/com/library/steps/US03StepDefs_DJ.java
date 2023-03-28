package com.library.steps;

import com.library.pages.BookPage;
import com.library.pages.LoginPage;
import com.library.utility.BrowserUtil;
import com.library.utility.DB_Util;
import io.cucumber.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class US03StepDefs_DJ {

    LoginPage loginPage = new LoginPage();
    BookPage bookPage = new BookPage();
    List<String> actualList;
    @Given("the {string} on the home page")
    public void the_on_the_home_page(String librarian) {
        loginPage.login(librarian);

    }

    @When("the user navigates to {string} page")
    public void the_user_navigates_to_page(String booksModule) {
        bookPage.navigateModule(booksModule);

    }

    @When("the user clicks book categories")
    public void the_user_clicks_book_categories() {
        bookPage.mainCategoryElement.click();

    }

    @Then("verify book categories must match book_categories table from db")
    public void verify_book_categories_must_match_book_categories_table_from_db() {

        Select select = new Select(bookPage.mainCategoryElement);
        actualList = BrowserUtil.getElementsText(select.getOptions());
        actualList.remove(0);

        String query = "select name from book_categories";
        DB_Util.runQuery(query);
        List<String> expectedList = DB_Util.getColumnDataAsList("name");
        //expectedList.remove(0);
        Assert.assertEquals(expectedList,actualList);


    }

}
