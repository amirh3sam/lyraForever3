package com.library.steps;

import com.library.pages.BookPage;
import com.library.pages.BorrowedBooksPage;
import com.library.pages.DashBoardPage;
import com.library.pages.LoginPage;
import com.library.utility.BrowserUtil;
import com.library.utility.DB_Util;
import com.library.utility.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebElement;

import java.util.List;

public class US07StepDefs_MS {

    BookPage bookPage = new BookPage();
    BorrowedBooksPage borrowedBooksPage = new BorrowedBooksPage();

    String expectedBorrowedBook;

    @And("the user navigates to {string} page")
    public void the_user_navigates_to_page(String moduleName) {
    new DashBoardPage().navigateModule(moduleName);
    }

    @And("the user searches book name called {string}")
    public void the_user_searches_book_name_called(String bookName) {
        bookPage.search.sendKeys(bookName);
        BrowserUtil.waitFor(3);
    }
    @When("the user clicks Borrow Book")
    public void the_user_clicks_borrow_book() {
        bookPage.borrowedBy.click();
        BrowserUtil.waitFor(3);
        BrowserUtil.waitForClickablility(bookPage.borrowButton, 3).click();

    }

    @Then("verify that book is shown in \"Borrowing Books” page")
    public void verify_that_book_is_shown_in_borrowing_books_page() {
    bookPage.navigateModule("Borrowing Books");

    BrowserUtil.waitFor(2);

    expectedBorrowedBook = borrowedBooksPage.locateBorrowedBook("Head First Java");

    BrowserUtil.waitFor(2);

    }

    @And("verify logged student has same book in database")
    public void verify_logged_student_has_same_book_in_database() {

        String query = "select full_name,b.name,bb.borrowed_date from users u\n" +
                "inner join book_borrow bb on u.id = bb.user_id\n" +
                "inner join books b on bb.book_id = b.id\n" +
                "where full_name='Test Student 5'\n" +
                "order by 3 desc";

        DB_Util.runQuery(query);

        String actualBookStatus = DB_Util.getCellValue(1,2);

        Assert.assertEquals(expectedBorrowedBook, actualBookStatus);




    }

}
