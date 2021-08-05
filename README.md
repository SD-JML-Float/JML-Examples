# Java Floating-Point Verification via OpenJML

This is the codebase used by Group 11 for the Spring/Summer 2021 Senior Design capstone project.

## OpenJML Test Cases

The OpenJML test cases provide a testing suite for the Float and Double wrapper classes, primitive floating-point arithmetic, and the Java Math API methods associated with floating-points.

### Test Case Composition

- Each test case method tests a specific Java method or constant associated with floating-points

- Finite vs. infinite inputs (and non-reals) are separated in different methods since infinite and non-real inputs can result in significantly different behavior.

## Z3 Test Cases

The Z3 test cases verify that Z3 4.8 can properly model and comprehend floating-point theory and behaviors. The design for each Z3 test case is different from normal test cases because they are designed to "fail".

Each test case asserts that certain properties that should hold are not valid, thus verifying whether Z3 can properly interpret floating-points.

## Running OpenJML Test Cases

The [runtests.sh](runtests.sh) script will run all the OpenJML test cases in the repo, analyzing each method individually and output their behavior.

If you wish to run a specific test case, you must manually feed the file into the OpenJML tool through a command line. Instructions on this process can be found [here](https://www.openjml.org/).

## Developers

Alexander Mompoint

JonElliot Antognoni

Robert Moore

Gary Hoppenworth
