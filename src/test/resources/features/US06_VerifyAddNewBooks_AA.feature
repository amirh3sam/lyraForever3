Feature: Books module
  As a librarian, I should be able to add new book into library

  @us06 @ui @db
  Scenario Outline: Verify added book is matching with DB
    Given the "librarian" on the home page
    And the user navigates to "Books" page_AA
    When the librarian click to add book_AA
    And the librarian enter book name "<Book Name>"_AA
    When the librarian enter ISBN "<ISBN>"_AA
    And the librarian enter year "<Year>"_AA
    When the librarian enter author "<Author>"_AA
    And the librarian choose the book category "<Book Category>"_AA
    And the librarian click to save changes_AA
    Then verify "The book has been created" message is displayed_AA
    And verify "<Book Name>" information must match with DB_AA
    Examples:
      | Book Name             | ISBN     | Year | Author      | Book Category |
      | Lyra Forever          | 20230423 | 2023 | Joe Sky     | Horror        |
      | The Scrum Field Guide | 11112021 | 2006 | Mitch Lacey | Short Story   |