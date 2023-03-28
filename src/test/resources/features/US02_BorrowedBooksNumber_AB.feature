
Feature: As a librarian, I want to know borrowed books number
  @db @ui @wip3
  Scenario: verify the total amount of borrowed books_AB
    Given the "librarian" on the home page_AB
    When the librarian gets borrowed books number_AB
    Then borrowed books number information must match with DB_AB