# TA_Qualification_Assignment
Assignment for spriteCloud Job vacancy

This is a project built by me, following the next specs:
1. Environment and specs: https://demoqa.com/ (UI) / https://petstore.swagger.io/ (API)
2. Used scripting language: Java
3. Used testing tool: VScode
4. CI platform: Jenkins/Saucelabs

## How to run the tests locally
In `Configurtion.properties` file you can especify if you want to run the tests locally or remotely(Saucelabs) by changing the `Environment` variable `remote` to 
`local` and vice versa. In addition you can switch between browser by especifying the browser you are going to use in the `Browser` variable in the same file.  

The drivers are already located in a folder inside the project so there's no need to change the driver path.
To run the tests use the following command:
```
mvn test
```

## How to run the test in a CI/CD pipeline
To run the test in Saucelabs the `Environment` variable located in `Configuration.properties` has to be set to remote. To run test cases in Saucelabs a `USERNAME` and an `ACCESS KEY` are needed, mines are already set but feel free to set your own to see how the test are running.

Another CI platform used is Jenkins, for that Maven and Cucumber plugins are needed. Just create a new maven project and especify the path of the `pom.xml` file.

## Link to the results in Calliope.pro
https://app.calliope.pro/reports/110803/public/e414bf22-20c6-4404-8112-dc0e1ee26266

## What you used to select the scenarios, what was your approach?
I selected the scenarios that for me can show off my skills for the time given to complete the assignment. I chose the scenarios related to the book store and student registration form because those where the most complete which covers many diferent functions for testing. I covered the usual behavior of any end user.

## Why are they the most important
They are the most important to test because as a tester the priority is that the main function works, any other bugs are less important, so it is needed to make choices and select the scenarios that will accomplish the most of the client's needs.

## What could be the next steps to your project
Once happy path is tested, next step is to test wrong paths and to not stop testing until something breaks lol.
