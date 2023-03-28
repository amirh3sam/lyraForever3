package com.library.steps;

import com.library.pages.BookPage;
import com.library.pages.LoginPage;
import com.library.utility.BrowserUtil;
import io.cucumber.java.en.*;

public class US03StepDefs_DJ {

    LoginPage loginPage = new LoginPage();
    BookPage bookPage = new BookPage();
    @Given("the {string} on the home page_DJ")
    public void the_on_the_home_page(String librarian) {
        loginPage.login(librarian);

    }

    @When("the user navigates to {string} page_DJ")
    public void the_user_navigates_to_page(String booksModule) {
        bookPage.navigateModule(booksModule);

    }

    @When("the user clicks book categories_DJ")
    public void the_user_clicks_book_categories() {
        bookPage.mainCategoryElement.click();

    }

    @Then("verify book categories must match book_categories table from db_DJ")
    public void verify_book_categories_must_match_book_categories_table_from_db() {


    }

}
