Scenario: check increase balance

Given I see that balance is <defaultBalance>
And I see that balance is <defaultBalance>
When I add <payNumber> of money
And I click top up balance
Then I see that balance is <balance>

Examples:
|   defaultBalance |   number  |   balance  |
|   0              |    500    |    500     |
|   500            |    1000   |    1500    |


Scenario: check that I can connect new conditions

Given I see default current <defaultCurNumber> of <defaultCurSpeed>
And I see default current <defaultCurPrice>
When I add <payNumber> of money
And I click top up balance
And I click increase button
And I click increase button
And I click connection button
Then I see current <curNumber> of <curSpeed>
And I see current <curPrice>
And I click reset button

Examples:
|defaultCurNumber| defaultCurSpeed    |defaultCurPrice|payNumber|curNumber|     curSpeed       |curPrice  |
|       64       |  Кбит/сек (макс.)  |      0        |  5000   |  416    |   Кбит/сек (макс.) |   350    |


Scenario: check that I can't connect new conditions when I have same conditions

Given I see default current <defaultCurNumber> of <defaultCurSpeed>
And I see default current <defaultCurPrice>
When I add <payNumber> of money
And I click top up balance
And I click increase button
And I click increase button
And I click connection button
Then I see current <curNumber> of <curSpeed>
And I see current <curPrice>
When I click increase button
And I click decrease button
Then I see that connection button is disables
When I click decrease button
And I click increase button
Then I see that connection button is disables
And I click reset button

Examples:
|defaultCurNumber| defaultCurSpeed    |defaultCurPrice|payNumber|number|     curSpeed       |curPrice  |
|       64       |  Кбит/сек (макс.)  |      0        |  5000   |  416 |   Кбит/сек (макс.) |   350    |


Scenario: check that I can't connect new conditions when I have not enough money

Given I see default current <defaultCurNumber> of <defaultCurSpeed>
And I see default current <defaultCurPrice>
When I add <payNumber> of money
And I click top up balance
And I click increase button
And I click increase button
And I click increase button
Then I see that connection button is disables

Examples:
|defaultCurNumber| defaultCurSpeed    |defaultCurPrice|payNumber|
|      64        |   Кбит/сек (макс.) |      0        |  300    |