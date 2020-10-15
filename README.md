[![Build Status](https://travis-ci.com/AlphaWong/hello-java.svg?branch=master)](https://travis-ci.com/AlphaWong/hello-java)
[![codecov](https://codecov.io/gh/AlphaWong/hello-java/branch/master/graph/badge.svg)](https://codecov.io/gh/AlphaWong/hello-java)
# assumption
`moreThanAMonthApart` A month is from some day to the same day in the following month, regardless of the number of days. So, Jan 3rd to Feb 3rd is exactly one month. Jan 3rd to Feb 4th is more than a month.

# restriction
Cannot use standard date/time classes.

# pre-condition
```console
java -version 
openjdk version "1.8.0_265"
OpenJDK Runtime Environment (AdoptOpenJDK)(build 1.8.0_265-b01)
OpenJDK 64-Bit Server VM (AdoptOpenJDK)(build 25.265-b01, mixed mode)
```

# run test
```console
./gradlew clean test 
``` 
## expected result
```console
 ./gradlew clean test
AppTest > testMoreThanAMonthApartWithCross31And30Day PASSED
AppTest > testMoreThanAMonthApartWithSuccessInLeapYear29Feb PASSED
AppTest > testIsLaterOrEqualThanInSameMonthOneDayBeforeDate PASSED
AppTest > testMoreThanAMonthApartBuildInWithCrossYear PASSED
AppTest > testMoreThanAMonthApartBetweenJan30AndFeb PASSED
AppTest > testMoreThanAMonthApartBuildInWithDifferenceBCYear PASSED
AppTest > testGetAMonthLaterFEB PASSED
AppTest > testMoreThanAMonthApartBetweenJulAndAug PASSED
AppTest > testIsValidDayOfMonth35May PASSED
AppTest > testMoreThanAMonthApartBuildInWithInvalidDayOfMonth PASSED
AppTest > testIsValidDayOfMonthSuccess PASSED
AppTest > testMoreThanAMonthApartBuildInBetweenFebAndMar PASSED
AppTest > testMoreThanAMonthApartBuildInWithDifferenceYear PASSED
AppTest > testMoreThanAMonthApartBetweenFebAndMar PASSED
AppTest > testMoreThanAMonthApartBetweenJan31AndFeb PASSED
AppTest > testMoreThanAMonthApartWithDifferenceYear PASSED
AppTest > testIsLaterOrEqualThanInSameMonthOneDayAfterDate PASSED
AppTest > testIsValidDayOfMonth29FebInNonLeapYear PASSED
AppTest > testMoreThanAMonthApartBuildInWithInvalidMonth PASSED
AppTest > testMoreThanAMonthApartWithInvalidMonth PASSED
AppTest > testMoreThanAMonthApartBetweenOctAndNov PASSED
AppTest > testMoreThanAMonthApartWithInvalidDayOfMonth PASSED
AppTest > testGetAMonthLaterFromJAN2FEBInLeapYear PASSED
AppTest > testMoreThanAMonthApartBuildInWithInvalidNegativeDayOfMonth PASSED
AppTest > testMoreThanAMonthApartBetweenMayAndJul PASSED
AppTest > testMoreThanAMonthApartWithAIsLatestButLessThanAMonthGap PASSED
AppTest > testMoreThanAMonthApartWithInvalidNegativeDayOfMonth PASSED
AppTest > testIsLaterOrEqualThanOneMonthBeforeDate PASSED
AppTest > testMoreThanAMonthApartBetweenJan29AndFeb PASSED
AppTest > testGetAMonthLater PASSED
AppTest > testMoreThanAMonthApartWithInvalidDay29FebInNonLeapYear PASSED
AppTest > testGetAMonthLaterCrossYear PASSED
AppTest > testGetAMonthLaterFromMAYToJUN PASSED
AppTest > testGetAMonthLaterFromJAN2FEBInNonLeapYear PASSED
AppTest > testMoreThanAMonthApartWithSameDate PASSED
AppTest > testValidDateFailWith13Month PASSED
AppTest > testMoreThanAMonthApartBuildInWithCross31And30Day PASSED
AppTest > testIsValidDayOfMonth29FebInLeapYear PASSED
AppTest > testMoreThanAMonthApartWithAIsLatest PASSED
AppTest > testIsLaterOrEqualThanCrossYear PASSED
AppTest > testMoreThanAMonthApartWithDifferenceBCYear PASSED
AppTest > testMoreThanAMonthApartBuildInWithAIsLatest PASSED
AppTest > testMoreThanAMonthApartBuildInWithSameDate PASSED
AppTest > testMoreThanAMonthApartBuildInCrossFEB28 PASSED
AppTest > testMoreThanAMonthApartCrossFEB28 PASSED
AppTest > testIsLaterOrEqualThanInEqualDate PASSED
AppTest > testMoreThanAMonthApartBetweenAugAndSep PASSED
AppTest > testMoreThanAMonthApartWithCrossYear PASSED
AppTest > testMoreThanAMonthApartBetweenDecAndJanCrossYear PASSED
AppTest > testMoreThanAMonthApartBuildInWithAIsLatestButLessThanAMonthGap PASSED
> Task :jacocoTestReport
BUILD SUCCESSFUL in 6s
5 actionable tasks: 5 executed
```

# improvement ?
ping me via `wck.alpha@gmail.com`

# reference
1. https://www.geeksforgeeks.org/calendar-compareto-method-in-java-with-examples/
1. https://stackoverflow.com/questions/9356543/logging-while-testing-through-gradle
