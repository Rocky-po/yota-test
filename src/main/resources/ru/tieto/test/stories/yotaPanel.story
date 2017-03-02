Scenario: check increase balance

Given I see that balance is <defaultBalance>
When I add <payNumber> of money
And I click top up balance
Then I see that balance is <balance>

Examples:
|   defaultBalance |   number  |   balance  |
|   0              |    500    |    500     |
|   0              |    1000   |    1500    |

Scenario: check that I can connect new conditions

Given I see default current <defaultNumber> of <defaultSpeed>
And I see default current <defaultPrice>
When I add <payNumber> of money
And I click top up balance
And I click increase button
And I click increase button
And I click connection button
Then I see current <number> of <speed>
And I see current <price>

Examples:
|defaultNumber| defaultSpeed    |defaultPrice|payNumber|number|     speed       |price  |
|   64        |Кбит/сек (макс.) |   0        |  5000   |  416 |Кбит/сек (макс.) |350    |

Scenario: check that I can't connect new conditions when I have same conditions

Given I see default current <defaultNumber> of <defaultSpeed>
And I see default current <defaultPrice>
When I add <payNumber> of money
And I click top up balance
And I click increase button
And I click increase button
And I click connection button
Then I see current <number> of <speed>
And I see current <price>
When I click increase button
And I click decrease button
Then I see that connection button is disables
When I click decrease button
And I click increase button
Then I see that connection button is disables

Examples:
|defaultNumber| defaultSpeed    |defaultPrice|payNumber|number|     speed       |price  |
|   64        |Кбит/сек (макс.) |   0        |  5000   |  416 |Кбит/сек (макс.) |350    |

Scenario: check that I can't connect new conditions when I hane not enough money

Given I see default current <defaultNumber> of <defaultSpeed>
And I see default current <defaultPrice>
When I add <payNumber> of money
And I click top up balance
And I click increase button
And I click increase button
And I click increase button
Then I see that connection button is disables

Examples:
|defaultNumber| defaultSpeed    |defaultPrice|payNumber|
|   64        |Кбит/сек (макс.) |   0        |  300    |

Scenario: check that I can connect all conditions
Given I see default current <defaultNumber> of <defaultSpeed>
And I see default current <defaultPrice>
When I add <payNumber> of money
And I click top up balance
And I click increase button
And I click connection button
Then I see current <number> of <speed>
And I see current <price>

Examples:
|defaultNumber| defaultSpeed    |defaultPrice|payNumber|number|     speed       |price  |
|   64        |Кбит/сек (макс.) |   0        |  5000   |  320 |Кбит/сек (макс.) |300    |
|   320       |Кбит/сек (макс.) |   300      |  5000   |  416 |Кбит/сек (макс.) |350    |
|   416       |Кбит/сек (макс.) |   350      |  5000   |  512 |Кбит/сек (макс.) |400    |
|   512       |Кбит/сек (макс.) |   400      |  5000   |  640 |Кбит/сек (макс.) |450    |
|   640       |Кбит/сек (макс.) |   450      |  5000   |  768 |Кбит/сек (макс.) |500    |
|   768       |Кбит/сек (макс.) |   500      |  5000   |  896 |Кбит/сек (макс.) |550    |
|   896       |Кбит/сек (макс.) |   550      |  5000   |  1.0 |Мбит/сек (макс.) |600    |
|   1.0       |Мбит/сек (макс.) |   600      |  5000   |  1.3 |Мбит/сек (макс.) |650    |
|   1.3       |Мбит/сек (макс.) |   650      |  5000   |  1.7 |Мбит/сек (макс.) |700    |
|   1.7       |Мбит/сек (макс.) |   700      |  5000   |  2.1 |Мбит/сек (макс.) |750    |
|   2.1       |Мбит/сек (макс.) |   750      |  5000   |  3.1 |Мбит/сек (макс.) |800    |
|   3.1       |Мбит/сек (макс.) |   800      |  5000   |  4.1 |Мбит/сек (макс.) |850    |
|   4.1       |Мбит/сек (макс.) |   850      |  5000   |  5.0 |Мбит/сек (макс.) |900    |
|   5.0       |Мбит/сек (макс.) |   900      |  5000   |  5.7 |Мбит/сек (макс.) |950    |
|   5.7       |Мбит/сек (макс.) |   950      |  5000   |  6.4 |Мбит/сек (макс.) |1000   |
|   6.4       |Мбит/сек (макс.) |   1000     |  5000   |  7.1 |Мбит/сек (макс.) |1050   |
|   7.1       |Мбит/сек (макс.) |   1050     |  5000   |  7.8 |Мбит/сек (макс.) |1100   |
|   7.8       |Мбит/сек (макс.) |   1100     |  5000   |  8.5 |Мбит/сек (макс.) |1150   |
|   8.5       |Мбит/сек (макс.) |   1150     |  5000   |  9.2 |Мбит/сек (макс.) |1200   |
|   9.2       |Мбит/сек (макс.) |   1200     |  5000   |  10.0|Мбит/сек (макс.) |1250   |
|   10.0      |Мбит/сек (макс.) |   1250     |  5000   |  12.0|Мбит/сек (макс.) |1300   |
|   12.0      |Мбит/сек (макс.) |   1300     |  5000   |  15.0|Мбит/сек (макс.) |1350   |
|   15.0      |Мбит/сек (макс.) |   1350     |  5000   |  Макс|Мбит/сек (макс.) |1400   |