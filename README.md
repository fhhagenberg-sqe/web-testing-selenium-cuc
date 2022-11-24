# Testing Web-Applications with Selenium and Cucumber _(5 Points)_

In this assignment you learn how to use behavior driven tests for web applications using [Selenium WebDriver][Selenium WebDriver] and [Cucumber][Cucumber]. 


## (1) Write a test scenario 

In this exercise you learn how to sepcify a feature and example scenarios using the [Gherkin Syntax][Gherkin].

### Prerequisites

- [x] Selenium WebDriver (dependencies managed by Maven)
- [x] Cucumber framework (dependencies managed by Maven)

### Instructions

1. Check the initial setup by running `mvn test`. Make sure the tests pass green.
1. Remove the example tests part of the project
1. Create a feature file [`src/test/resources/at/fhhagenberg/sqe/BibSearch.feature`](src/test/resources/at/fhhagenberg/sqe/BibSearch.feature) describing following scenario:
   1. Goto https://search-fho.obvsg.at/primo-explore/search?vid=FHO&search_scope=default_scope
   1. Search for "software testing"
   1. Assert the number of entries returned by the search
1. Run `mvn test` to verify the feature file has been processed sucessfully.


## (2) Create test step definitions 

The goal of this step is to create test step definitions, which [map the scenario description to Java methods][Cucumber Gherkin]. 

### Prerequisites

- [x] Completion of the previous step (1)
- [x] See Cucumber Docs: https://cucumber.io/docs/cucumber/step-definitions/?lang=java

### Instructions

1. Create a test definition file [`src/test/java/at/fhhagenberg/sqe/StepDefinitions.java`](src/test/java/at/fhhagenberg/sqe/StepDefinitions.java)
1. Add a public method for every `given`, `when`, and `then` step specified in the feature file
1. Annotate the methods with `@Given`, `@When`, and `@Then` annotations including [regular expressions matching the specified steps][Step Definitions] 
1. Replace test data values with parameters to make the test step definitions more generic
1. Leave the method implementation empty. Run `mvn test` to verify the textual descriptions in the feature file match the implemented test steps.


## (3) Glue code using page objects 

In this step you reuse the page objects developed in the previous exercise to exercise the web application under test.

### Prerequisites

- [x] Completion of the previous step of the exercise (2)
- [x] A current version of either Firefox or Chrome web browser plus Selenium WebDriver
- [x] Page objects developed in the previous exercise `Testing Web-Applications with Selenium`

### Instructions

1. Copy the page objects `SearchPage.java` and `ResultsPage.java` develped in the previous exercise to [`src/test/java/at/fhhagenberg/sqe/pageobjects`](`src/test/java/at/fhhagenberg/sqe/pageobjects`)
1. Add the methods `@Before public void setUp()` and `@After public void tearDown()` to create and to close the `WebDriver` instance 
1. Implement the (sofar empty) methods representing the `given`, `when`, and `then` steps in the test step definition file `StepDefinitions.java` using the methods from the page objects
1. Run the Cucumber test, which uses Selenium WebDriver to actually exercise the web application – make sure the test passes green

### Submission

When you're done...

- [x] push your changes to your upstream repository on GitHub.
- [x] on GitHub, [create a release][GitHub creating releases] with version `v3.0`.
- [x] upload the [link to your release][GitHub linking to releases] on the e-learning platform until the specified date and time before the next lecture.


[GitHub creating releases]: https://help.github.com/articles/creating-releases/
[GitHub linking to releases]: https://help.github.com/articles/linking-to-releases/
[Selenium WebDriver]: https://www.selenium.dev/documentation/en/webdriver/
[Cucumber]: https://cucumber.io/tools/cucumber-open/
[Gherkin]: https://cucumber.io/docs/gherkin/
[Cucumber Gherkin]: https://cucumber.io/docs/gherkin/step-organization/?lang=java
[Step Definitions]: https://cucumber.io/docs/cucumber/step-definitions/?lang=java