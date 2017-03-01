Scenario: check increase balance

Given I see that balance is <defaultBalance>
When I add <number> of money
And I click top up balance
Then I see that balance is <balance>

Examples:
|   defaultBalance |   number  |   balance  |
|   0              |    500    |    500     |
|   0              |    1000   |    1500    |