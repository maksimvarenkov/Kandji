# Few words

What is smoke test? It’s a very basic test that allows us to check that our application works as expected after deployed
to desired environment.

There are several different approaches to creating them, first and most obvious - make sure that our application:
1) Deployed successfully. There's no 500 errors, no placeholders like "Ongoing maintenance", base url can be opened
and content displayed
2) Login/logout. As Kandji is not some kind of landing page it's crucial that user should have access to application.
3) Verify basic content on each available page.
4) Verify basic functionality on each page if there's some for Empty state(like switching tabs)

For smoke test in general I'd prefer to see something like that, but expanded with user that has some predefined data
that I can check.

What are the pros of this approach?
a) We don't need to update data. It means that we can have several users on different environments(PROD included) and 
use them for our check right away, without creating entities each time, waiting for ETL/jobs completion, etc.
b) Tests are fast. The less logic we have - the faster operations we must perform to have results
c) Tests are more reliable because data is already there
d) We don't need to worry about cleaning up artifacts we made during the testing

Cons
a) We don’t check functionality for CRUDs for our most significant entities
b) Some important functionality can be missed easily, especially if it’s hidden behind complicated workflow, involving 
backend logic triggers

There’s another approach that can be used for tasks like that, but I don’t think we can make it for Kandji,
as product has a lot of logic, complexity, and probably will require a lot of operations with hardware devices or
enhanced security.

For smaller application, like some landing page, smoke test can cover entire happy path due to simplicity:
user opens main page, filling some form, getting a link or code, sending a message with price inquiry, etc.

For Kandji I think that best approach will be to have very basic smoke test like I described before, like sanity
check, and a lot of cases that will be running for every critical functionality. During our interview we spoke
that there are 600+ cases, if they will be executed in parallel they should have us covered.

### Functionality I skipped
I skipped search in sidebar because looks like it's some kind of global search across the all pages. It's not a critical
functional, also we have checks on every page for that functionality so there's workaround.

Also skipped chat, because I don't think it can be properly checked on my side. Yes, I can send a message, but I need to 
make sure that it's added somewhere in queue and received, otherwise it will not have a lot of sense in spamming
test messages. 

## Technical part
To provide my response faster I decided to go with Selenium+TestNG without any wrapper(selenide, selenoid, etc.) to
be sure that it will not require additional effort from the team to invest time digging in documentation for them.
For driver management it will be bonigarcia.

As a language - Java. I know that company using Playwright, I have some experience with it, but it would consume
additional time as I less familiar with it. Also, I would like to mention that I would like to use it for automation
in company and enhance my experience with this framework.

I decided not to add BDD layer with cucumber now because it will make it harder to check output with additional entity.

## Technical part notices

### OTP
OTP is one big issue. I was thinking about using Tokens for access, but as they can be used only once it is not the
best idea to rely on them. So I wrote simple helper to generate OTP and use it further for tests execution.
Anyway, it makes harder to run tests in parallel or as bunch, like all tests in package.
It can be bypassed by several things:
- I can log once, store session information and apply it to any new instance of browser
- I can adjust setup procedures to run multiply tests in one file
- I can add several tries for logging in
- I can collect all failed tests and run them again
- I can rerun failed tests
- On application side check can be disabled on certain environment\for certain account, allowing to perform all checks 
and have one separate test for checking that OTP works in general.
All those solutions require additional effort, but doable, but right now OTP is the cause of flakiness

### Hashed classes
As classes in application are hashed it's hard and complicated to write reliable selector for element. Not all of them 
have some attributes that not changed, like data-test-id, so often I had to write weird xpath selector pointing to div 
inside div that has label with some text(and it will broke after minor typo fix, text change or using other locale).
It's not a good thing, always better to use some id for finding desired element, but there's no easy workaround that can
be implemented on my end.

## How to run
1. Clone repo
2. Fill properties file with appropriate credentials
3. Using IDE(like IDEA - you can run desired class in test folder with right click > Run 'ClassnameTest')
4. Using Terminal - mvn clean test from root directory

#### Warning - some tests will fail if run all at once. Reasons and solutions described in OTP section 

## For CI integration
Tests can be run using IDE or from terminal using

mvn clean test

Right now testng file set up to run tests in one thread. There's a sample testng_parallel file, but also pom.xml have 
to be updated.
So for integration we only need to schedule a job or create some trigger as part of our process.

CI integration is good, but in my practice I found useful for tests being as visible, as they can because
it helps people to really use them. So my suggestion is to make integration with Slack, for example, by adding plugin to 
Jenkins.

## Areas to improve
1. Solve OTP issue with one of the possible way described in OTP section
2. Adding reports generation like Allure Reporting instead of surefire
3. Improve logging. I prefer to do this part with usage of libraries form part 2. It's doable to write own implementation 
of Logger, but it's better to use library from the start to avoid duplicating functionality.


