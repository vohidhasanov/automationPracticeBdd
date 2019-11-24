Feature:
  @techcenture
  Scenario: Creating new Student at TechCenture
    Given User navigates to "http://techcenture.us/qa-env/"
    When User click Creat button and fills form
    |Name   |Last Name        |Course                   |Student Age  |
    |Vohid  |Hasanov          |automation engineer      |39           |
#    |Sample1| Sample1         |Sample1                  |100          |
#    |Sample2       |Sample2                 |Sample2                         |101             |

And User clicks Save button

