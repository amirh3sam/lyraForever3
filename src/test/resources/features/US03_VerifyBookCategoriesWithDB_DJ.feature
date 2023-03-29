@B28G27-145
Feature: As a data consumer, I want UI and DB book categories are match.
@B28G27-144 @ui @db
  Scenario: verify book categories with DB
    Given the "librarian" on the home page_DJ
    When the user navigates to "Books" page_DJ
    And the user clicks book categories_DJ
    Then verify book categories must match book_categories table from db_DJ