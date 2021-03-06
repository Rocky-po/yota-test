Scenario: slider increase

Given I am on yota page
When I click increase button
Then I see that new speed is <newNumber> of <newSpeed>
And I see that new price is <newPrice>

Examples:
|   newNumber   |  newSpeed        | newPrice  |
|      320      |  Кбит/сек (макс.)|   300     |
|      416      |  Кбит/сек (макс.)|   350     |
|      512      |  Кбит/сек (макс.)|   400     |
|      640      |  Кбит/сек (макс.)|   450     |
|      768      |  Кбит/сек (макс.)|   500     |
|      896      |  Кбит/сек (макс.)|   550     |
|      1.0      |  Мбит/сек (макс.)|   600     |
|      1.3      |  Мбит/сек (макс.)|   650     |
|      1.7      |  Мбит/сек (макс.)|   700     |
|      2.1      |  Мбит/сек (макс.)|   750     |
|      3.1      |  Мбит/сек (макс.)|   800     |
|      4.1      |  Мбит/сек (макс.)|   850     |
|      5.0      |  Мбит/сек (макс.)|   900     |
|      5.7      |  Мбит/сек (макс.)|   950     |
|      6.4      |  Мбит/сек (макс.)|   1000    |
|      7.1      |  Мбит/сек (макс.)|   1050    |
|      7.8      |  Мбит/сек (макс.)|   1100    |
|      8.5      |  Мбит/сек (макс.)|   1150    |
|      9.2      |  Мбит/сек (макс.)|   1200    |
|      10.0     |  Мбит/сек (макс.)|   1250    |
|      12.0     |  Мбит/сек (макс.)|   1300    |
|      15.0     |  Мбит/сек (макс.)|   1350    |
|      Макс     |  Мбит/сек (макс.)|   1400    |

Scenario: slider decrease

Given I am on yota page
When I click decrease button
Then I see that new speed is <newNumber> of <newSpeed>
And I see that new price is <newPrice>

Examples:
|   newNumber   |  newSpeed        | newPrice  |
|     15.0      |  Мбит/сек (макс.)|   1350    |
|     12.0      |  Мбит/сек (макс.)|   1300    |
|     10.0      |  Мбит/сек (макс.)|   1250    |
|     9.2       |  Мбит/сек (макс.)|   1200    |
|     8.5       |  Мбит/сек (макс.)|   1150    |
|     7.8       |  Мбит/сек (макс.)|   1100    |
|     7.1       |  Мбит/сек (макс.)|   1050    |
|     6.4       |  Мбит/сек (макс.)|   1000    |
|     5.7       |  Мбит/сек (макс.)|   950     |
|     5.0       |  Мбит/сек (макс.)|   900     |
|     4.1       |  Мбит/сек (макс.)|   850     |
|     3.1       |  Мбит/сек (макс.)|   800     |
|     2.1       |  Мбит/сек (макс.)|   750     |
|     1.7       |  Мбит/сек (макс.)|   700     |
|     1.3       |  Мбит/сек (макс.)|   650     |
|     1.0       |  Мбит/сек (макс.)|   600     |
|     896       |  Кбит/сек (макс.)|   550     |
|     768       |  Кбит/сек (макс.)|   500     |
|     640       |  Кбит/сек (макс.)|   450     |
|     512       |  Кбит/сек (макс.)|   400     |
|     416       |  Кбит/сек (макс.)|   350     |
|     320       |  Кбит/сек (макс.)|   300     |
|     64        |  Кбит/сек (макс.)|   0       |