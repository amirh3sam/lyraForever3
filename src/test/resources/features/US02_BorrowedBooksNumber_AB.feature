@B28G27-149
Feature: As a librarian, I want to know borrowed books number




 #Positive Testing
  @B28G27-148 @db @ui
  Scenario: verify the total amount of borrowed books_AB
    Given the "librarian" on the home page_AB
    When the librarian gets borrowed books number_AB
    Then borrowed books number information must match with DB_AB

