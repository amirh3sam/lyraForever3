@B28G27-153
Feature: As a data consumer, I want UI and DB book categories are match.
@ui @db @B28G27-152
  Scenario: verify book categories with DB
    Given the "librarian" on the home page_VK
    When the user navigates to "Books" page_VK
    And the user clicks book categories_VK
    Then verify book categories must match book_categories table from db_VK