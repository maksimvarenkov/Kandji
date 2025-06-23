# Framework structure

## org.kandji

### Assertions
This is the place where large assertions stored, that will check a lot of content 
on the same page. Stored separately to keep tests more human-readable.

### BaseTest
This is base test, where browser is configured, starting/closing driver instance etc.

### Helpers
ConfigReader - I store properties for my tests in properties file, so I need an ability to get desired data for it.
It's very basic and simple.

OTPGenerator - helper that can generate OTP password using provided User Secret Token. As we have only one way for 
authentication it has hardcoded HmacSHA1 

### Pages
This is storage for all pages and actions that I'm doing on those pages. It also a home for BasePage class, where
I implemented basic wrapping for functions for vanilla Selenium. 

### Sections
This is the place where portions of Web Page that exist on every page should be stored. Like sidebar, header, footer.

### UI 
This is home package for storing custom UI elements, basically implementation for WebElements for project UI kit. 
It will store behavior for custom elements, like dropdowns, inputs, switches and everything that will have non-standard 
logic(example - like dropdown with multiselect and search field).

### Utils
ScreenshotUtil - class that will create a screenshot and put it into target/screenshots folder with
name of failed test and timestamp.

TestListener - class that monitor test state and will actually trigger saving screenshot using screenshot utility.


### Resources

Environment.properties file has some constants that have to be filled with actual data before running a test

## Test

### KandjSmokeTest package
This is storage for all tests I wrote as part of smoke test

### Resources
There are two files - testng.xml and testng_parallel.xml. Right now in pom.xml file I use testng.xml, so if you'll execute
tests with mvn clean test it will run tests using this suite.