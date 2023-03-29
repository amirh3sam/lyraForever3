package com.library.steps;

import com.library.pages.BookPage;
import com.library.pages.LoginPage;
import com.library.utility.BrowserUtil;
import com.library.utility.DB_Util;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class US03StepDefs_VK {
    LoginPage loginPage = new LoginPage();
    BookPage bookPage = new BookPage();
    List<String> actualList;
    @Given("the {string} on the home page_VK")
    public void the_on_the_home_page_vk(String librarian) {
       loginPage.login(librarian);
    }
    @When("the user navigates to {string} page_VK")
    public void the_user_navigates_to_page_vk(String booksModule) {
      bookPage.navigateModule(booksModule);
    }
    @When("the user clicks book categories_VK")
    public void the_user_clicks_book_categories_vk() {
        bookPage.mainCategoryElement.click();
    }
    @Then("verify book categories must match book_categories table from db_VK")
    public void verify_book_categories_must_match_book_categories_table_from_db_vk() {
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
