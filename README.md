[![Build Status](https://travis-ci.com/AlphaWong/hello-java.svg?branch=master)](https://travis-ci.com/AlphaWong/hello-java)
[![codecov](https://codecov.io/gh/AlphaWong/hello-java/branch/master/graph/badge.svg)](https://codecov.io/gh/AlphaWong/hello-java)
# assumption
`moreThanAMonthApart` means the duration between two date.
It does not mean they are stay at the same month.

# restriction
Cannot use standard date/time classes.

# pre-condition
```
java -version 
openjdk version "1.8.0_265"
OpenJDK Runtime Environment (AdoptOpenJDK)(build 1.8.0_265-b01)
OpenJDK 64-Bit Server VM (AdoptOpenJDK)(build 25.265-b01, mixed mode)
```

# run test
```sh
./gradlew clean test 
``` 
## expected result
```sh
 ./gradlew clean test                                   

> Task :compileJava
Note: /Users/alphawong/IdeaProjects/coding/src/main/java/DateString.java uses unchecked or unsafe operations.
Note: Recompile with -Xlint:unchecked for details.

> Task :test

AppTest > testMoreThanAMonthApartBetweenFebAndMar PASSED

AppTest > testMoreThanAMonthApartWithDifferenceYear PASSED

AppTest > testMoreThanAMonthApartWithInvalidMonth PASSED

AppTest > testMoreThanAMonthApartWithInvalidDayOfMonth PASSED

AppTest > testMoreThanAMonthApartWithAIsLatestButLessThanAMonthGap PASSED

AppTest > testMoreThanAMonthApartWithInvalidNegativeDayOfMonth PASSED

AppTest > testMoreThanAMonthApartWithSameDate PASSED

AppTest > testMoreThanAMonthApartWithAIsLatest PASSED

AppTest > testMoreThanAMonthApartWithDifferenceBCYear PASSED

BUILD SUCCESSFUL in 1s
4 actionable tasks: 4 executed
```

# improvement ?
ping me via `wck.alpha@gmail.com`

# reference
1. https://www.geeksforgeeks.org/calendar-compareto-method-in-java-with-examples/
1. https://stackoverflow.com/questions/9356543/logging-while-testing-through-gradle