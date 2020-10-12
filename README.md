![build](https://travis-ci.com/AlphaWong/hello-java.svg?branch=master&status=passed)
# assumption
`moreThanAMonthApart` means the duration between two data.
It does not mean they are stay at the same month.

# restriction
Cannot use standard date/time classes.

# pre-condition
```
java --version
openjdk 15 2020-09-15
OpenJDK Runtime Environment AdoptOpenJDK (build 15+36)
OpenJDK 64-Bit Server VM AdoptOpenJDK (build 15+36, mixed mode, sharing)

gradle -version
Gradle 6.6.1
```

# run test
```sh
gradle :cleanTest :test 
``` 
## expected result
```sh
 gradle :cleanTest :test

> Task :test

AppTest > testMoreThanAMonthApartBetweenFebAndMar PASSED

AppTest > testMoreThanAMonthApartWithDifferenceYear PASSED

AppTest > testMoreThanAMonthApartWithSameYear PASSED

Deprecated Gradle features were used in this build, making it incompatible with Gradle 7.0.
Use '--warning-mode all' to show the individual deprecation warnings.
See https://docs.gradle.org/6.6.1/userguide/command_line_interface.html#sec:command_line_warnings

BUILD SUCCESSFUL in 1s
4 actionable tasks: 4 executed
```

# improvement ?
ping me via `wck.alpha@gmail.com`

# reference
1. https://www.geeksforgeeks.org/calendar-compareto-method-in-java-with-examples/
1. https://stackoverflow.com/questions/9356543/logging-while-testing-through-gradle