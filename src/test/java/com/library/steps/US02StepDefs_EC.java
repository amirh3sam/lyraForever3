package com.library.steps;

import com.library.pages.BorrowedBooksPage;
import com.library.pages.LoginPage;
import com.library.utility.DB_Util;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class US02StepDefs_EC {

 LoginPage loginpage=new LoginPage();
 BorrowedBooksPage borrowedBooksPage=new BorrowedBooksPage();
 String  actualBorrowedBooks;

    @Given("the {string} on the home page")
    public void the_on_the_home_page(String userType) {
        loginpage.login(userType);

    }
    @When("the librarian gets borrowed books number")
    public void the_librarian_gets_borrowed_books_number() {
        String query="select count(*) from book_borrow\n" +
                "where is_returned=0";

        DB_Util.runQuery(query);

        actualBorrowedBooks=DB_Util.getFirstRowFirstColumn();
        System.out.println("actualBorrowedBooks = " + actualBorrowedBooks);

    }
    @Then("borrowed books number information must match with DB")
    public void borrowed_books_number_information_must_match_with_db() {

        String query="select count(*) from book_borrow\n" +
                "where is_returned=0";

        DB_Util.runQuery(query);

        String expectedBorrowedBooks= DB_Util.getFirstRowFirstColumn();

        System.out.println("expectedBorrowedBooks = " + expectedBorrowedBooks);

        Assert.assertEquals(expectedBorrowedBooks,actualBorrowedBooks);






    }





}
