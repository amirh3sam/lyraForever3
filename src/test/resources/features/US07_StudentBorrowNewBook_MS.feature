
@B28G27-150
Feature: Books module
  As a students, I should be able to borrow book

  @B28G27-151 @ui @db
  Scenario: Student borrow new book
    Given the "student" on the home page
    And the user navigates to "Books" page
    And the user searches book name called "Head First Java"
    When the user clicks Borrow Book
    Then verify that book is shown in "Borrowing Books” page
    And verify logged "Test Student 5" has same book in database
