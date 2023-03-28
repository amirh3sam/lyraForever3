
Feature: As a data consumer, I want UI and DB book information are match.

  Scenario: Verify book information with DB
    Given the "librarian" on the home page
    And the user navigates to "Books" page_AD
    When the user searches for "LyraBook" book_AD
    And  the user clicks edit book button_AD
    Then book information must match the Database_AD