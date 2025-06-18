Feature: Change Orders

  Scenario: Basic functionality test for change orders
    When user navigate change order
    And user click new change order button
    And user select external co and giving a name
    And user click create and open change order
    Then Validate new CO created
    When user go to new co and select design section
    And user remove original item with keep accessory
    Then Validate item removed and keep accessory
    When user remove original item keep labor
    Then Validate keep labor
    When user add item to change order
    Then Validate add item to CO
    When user copy item to all location
    Then Validate copy item
    When user replace the item
    Then Validate replace item
    When user create proposal
    Then Validate proposal created
    When user accept the change order
    Then Validate accepted CO
    #When user click new change order button
    When user select internal co and giving a name
    #And user click create and open change order
    Then Validate new internal CO created
    And user add item
    Then Validate item added to CO
    When user approve the internal CO
    And user back to CO dashboard


