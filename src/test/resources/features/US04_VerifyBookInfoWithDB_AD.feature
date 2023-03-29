@B28G27-155
Feature: As a data consumer, I want UI and DB book information are match.

  @ui @db @B28G27-154
  Scenario: US4AC1-Verify book information with DB
    Given the "librarian" on the home page
    And the user navigates to "Books" page_AD
    When the user searches for "LyraBook" book_AD
    And  the user clicks edit book button_AD
    Then book information must match the Database_AD

    #negative Testing
  @ui @db
  Scenario: Verify book information with DB
    Given the "librarian" on the home page
    And the user navigates to "Books" page
    When the user searches for "LyraBook2" book_AD
    Then should not be able to see the book information_AD