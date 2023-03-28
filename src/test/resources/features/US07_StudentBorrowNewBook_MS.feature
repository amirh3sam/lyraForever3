
Feature: Books module
  As a students, I should be able to borrow book

  Scenario: Student borrow new book
    Given the "student" on the home page
    And the user navigates to "Books" page_MS
    And the user searches for "Self Confidence" book_MS
    When the user clicks Borrow Book_MS
    Then verify that book is shown in "Borrowing Books" page_MS
    And  verify logged student has same book in database_MS