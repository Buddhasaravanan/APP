Feature: Service Call

  Scenario: Basic functionality test for Service Call
    When user navigate to service call page
    And user create new service call
    And User enter the client details and click create button
    Then validate new service call created
    #When user scroll the page
    And user schedule the service call
    Then validate new schedule created
    When user navigate to worksummary
    And user add labor
    Then validate labor added
    And user add truk roll fee with tax
    Then validate truck roll fee added
    When user add drive time fee with tax
    Then validate drive time fee added
    When user add service call time entry
    Then validate service call time entry added
    When user add repair product
    Then validate item added
    When user add replace product
    Then validate item replaced
    When user add additional product
    Then validate item added
    When user create payment request for service call
    And user set the terms and create
    Then validate payment request created
    When user share the payment request
    Then validate payment request shared
    #When user navigate to present mode
    #And user make the payment via card
    And user back to serviceall dashboard
