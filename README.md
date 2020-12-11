# Goal
Project for exercising TDD (Test Driven Development) software development process.

## Requirements
1. java 8
1. eclipse
1. maven is optional since mvnw (maven wrapper) can be used

## Importing project into eclipse
Import using File -> Import item from menu. When a dialog is opened then select Maven -> Existing Maven Projects option and follow steps in the wizard.

## Importing eclipse preferences
Import using File -> Import item from menu. When a dialog is opened then select General -> Preferences option and pick `./tdd-workshop-1-arrays/eclipse/preferences.epf` file using the wizard. 

## Build
Execute following command on linux:

    ./mvnw clean install
or on windows:

    mvn clean install

## Instructions

### ArraySum

1. fork repository to your own github account
1. checkout `feature/1-array-sum` branch
1. project is already set up using maven and junit 5, so start tests by executing `./mvnw clean test`
1. update dummy classes: `MatrixSum` and `MatrixSumTest` to fulfill requirements from [ArraySum #1 issue](https://github.com/vdarko/tdd-workshop-1-arrays/issues/1) using Test Driven Development
1. in case that you're stuck or want to check reference tests you can simple merge following branches:
    1. result/step-1-ArraySumHappyPathTest
    1. result/step-2-ArraySumEdgeCasesTest
    1. result/step-3-ArraySumMoreEdgeCasesTest

### MatrixSum
 
1. commit all changes and rebase your changes on `feature/2-matrix-sum`
1. update dummy classes: `MatrixSum` and `MatrixSumTest` to fulfill requirements from [MatrixSum #2 issue](https://github.com/vdarko/tdd-workshop-1-arrays/issues/2) using Test Driven Development
1. you will still have `ArraySum` in your working copy and use it for implementing `MatrixSum`
1. in case that you're stuck or want to check reference tests you can simple merge following branches:
    1. result/step-4-MatrixSumHappyPathTest
    1. result/step-5-MatrixSumEdgeCasesTest

### MatrixSum Performance

1. stay on your current branch
1. check requirements from [MatrixSum Performance #3 issue](https://github.com/vdarko/tdd-workshop-1-arrays/issues/3)
1. define acceptance criteria for measuring `MatrixSum` performance and create a test for existing `MatrixSum` calculation
1. keep the existing method named `sum` in `MatrixSum` and add the new one named `parallelSum` with the same signature so that you can compare the performance later
1. use any mechanism upon your choice for implementing multi-threaded calculation: Thread, Future, CompletableFuture or Stream :)
1. in case that you're stuck or want to check reference tests you can simple merge following branches:
    1. result/step-6-MatrixSumPerformanceTest

## Important notes
1. push your changes to the fork repository at the end -no matter if it compiles or not :)
