Feature: Project Payment Task and Schedule

  Scenario: Major functionalities test in project
    When the user go to plan section
    And the user navigate to task page
    And the user create task
    Then validate task has been created
    When the user create new task group
    Then validate task group has been created
    When the user create new task from newly created task group
    Then validate task has been created
    When the user edit the task
    When the user create check list
    Then validate check list has created
    When the user add items to the task
    Then validate items are added to task
    When the user close the task
    And the user click schedule button from created task
    Then validate schedule has been created
    When the user go to time tracking section
    And the user add new time entry
    Then validate time entry added or not
    When the user go to project overview page
    And the user go to payment page
    And the user crete new payment request
    Then validate payment request created as per given data
    When the user share payment request via email
    Then validate payemnt shared or not
    When the user mark payment stats as paid
    Then validate payment summary section
