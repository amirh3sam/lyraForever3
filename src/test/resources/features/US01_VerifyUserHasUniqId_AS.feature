@B28G27-157
Feature: As a data consumer, I want the user information are stored in mySql DB correctly in users table.
  Background:
    Given Establish the database connection

@B28G27-156 @db
  Scenario: verify users has unique IDs
    When Execute query to get all IDs from users
    Then verify all users has unique ID

@B28G27-158  @db
  Scenario: verify users table columns
    When Execute query to get all columns_AS
    Then verify the below columns are listed in result_AS

      | id            |
      | full_name     |
      | email         |
      | password      |
      | user_group_id |
      | image         |
      | extra_data    |
      | status        |
      | is_admin      |
      | start_date    |
      | end_date      |
      | address       |
