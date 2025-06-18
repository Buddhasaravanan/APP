Feature: Service Contract

  Scenario: Basic functionality test for Service Contract
    When user navigate service contract section
    And user create new service opportunity
    And user added service contract
    Then Validate opportunity created
    And Validate service plan added to quote
    When User create new service plan
    And User set service plan name
    And User Set price and term
    And User set length of service plan
    And User set billing frequescies of service plan
    And User add plan feature
    Then Validate plan feature added to service plan
    When User added terms and conditions
    Then Validate T&C added to service call
    When User click create buton
    Then Validate service plan created and added
    When User create new monitoring agreements
    And User set monitoring agreements name
    And User Set price and term
    And User set length of monitoring agreements
    And User set billing frequescies of monitoring agreements
    And User add plan feature
    Then Validate plan feature added to monitoring agreements
    When User added terms and conditions
    Then Validate T&C added to service call
    When User click create buton
    Then Validate monitoring agreements created and added
    When User created multimedia proposal
    And User share the proposal
    And User go to present proposal
    And user select length and billing frequescy
    And User decline the second plan
    And user accept the proposal
    And User won the opportunity
    Then Validate won the opportunity with selected service plan +
    When User added description to service plan
    Then validate desicription added
    When user moved to payment section
    And User Genarate payment schedule
    Then Validate payment schedule screated
    When User request payemnt
    Then Validate payment request cerated
    When User share the payment request
    Then Validate payment request shared
    When User go to present mode
    And user download the PDF
    Then Validate Payment section loaded
    When user back to service plan payment section
    Then Validate payment status changed as requested
    When User enable payment automation
    Then Validate payment automation enabled
