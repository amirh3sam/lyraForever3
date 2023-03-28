@B28G27-147
Feature: As a librarian, I want to know borrowed books number
  @B28G27-146 @db @ui
  Scenario: US2AC1-Verify the total amount of borrowed books
    Given the "librarian" on the home page
    When the librarian gets borrowed books number
    Then borrowed books number information must match with DB