package com.library.steps;

import com.library.utility.DB_Util;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class US05StepDefs_PB {
    String mostCommonGenre;
    @When("I execute query to find most popular book genre_PB")
    public void i_execute_query_to_find_most_popular_book_genre_pb() {
        DB_Util.runQuery("select bc.name,count(*) from book_borrow bb\n" +
                "                                 inner  join books b on bb.book_id = b.id\n" +
                "                                 inner join book_categories bc on b.book_category_id=bc.id\n" +
                "group by name\n" +
                "order by 2 desc");

        mostCommonGenre = DB_Util.getFirstRowFirstColumn();
    }
    @Then("verify {string} is the most popular book genre._PB")
    public void verify_is_the_most_popular_book_genre__pb(String string) {
        Assert.assertEquals(string,mostCommonGenre);
    }



}
