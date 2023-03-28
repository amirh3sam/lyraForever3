
Feature: As a data consumer, I want UI and DB book categories are match.
@ui @viki @db
  Scenario: verify book categories with DB
    Given the "librarian" on the home page_VK
    When the user navigates to "Books" page_VK
    And the user clicks book categories_VK
    Then verify book categories must match book_categories table from db_VK