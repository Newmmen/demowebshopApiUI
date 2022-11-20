# Demonstration test automation project for Demowebshop.com 


## Content

> ➠ [Covered functionality](#tshirt-covered-functionality)
>
> ➠ [Technology stack](#abacus-technology-stack)
>
> ➠ [Running tests from the terminal](#Running-tests-from-the-terminal)
>
> ➠ [Test results report in Allure Report](#scroll-main-page-of-allure-report)

## :tshirt: Covered functionality

> Autotests developed <code>API</code>.

### Web + API

- [x] Checking new user register (Get new token and user registration with API) 
- [x] Edit registered user data (Get new token and user registration with API) 
- [x] Check add product to cart (Get new token, user registration, add product to cart with API) 
- [x] Check login existing user
- [x] Check making order full process (Get new token, user registration, add product to cart with API) 
- [x] Check displaying order information in my account (Get new token, user registration, add product to cart with API) 
- [x] Check login with undefined user data
- [x] Check login with empty user data



## :abacus: Technology stack

<p align="center">
<img width="6%" title="IntelliJ IDEA" src="images/logo/Intelij_IDEA.svg">
<img width="6%" title="Java" src="images/logo/Java.svg">
<img width="6%" title="Selenide" src="images/logo/Selenide.svg">
<img width="6%" title="Rest Assured" src="images/logo/RestAssured.png">
<img width="6%" title="Allure Report" src="images/logo/Allure_Report.svg">
<img width="6%" title="Gradle" src="images/logo/Gradle.svg">
<img width="6%" title="JUnit5" src="images/logo/JUnit5.svg">
<img width="6%" title="GitHub" src="images/logo/GitHub.svg">
<img width="6%" title="Jenkins" src="images/logo/Jenkins.svg">
<img width="6%" title="Selenoid" src="images/logo/Selenoid.svg">
<img width="6%" title="Allure TestOps" src="images/logo/Allure_TO.svg">
<img width="6%" title="Telegram API" src="images/logo/Telegram.svg.svg">
</p>

In this project, autotests are written in <code>Java</code> with <code>Selenide</code> and <code>Rest Assured</code> for API tests.

> <code>Owner</code> library provide test data.
>
> <code>Allure Report</code> generates a test run report.
> 
> <code>Gradle</code> is used for automated project build.
>
> <code>JUnit 5</code> is used as a unit testing library.
>
> <code>Jenkins</code> runs the tests.
>
> <code>Selenoid</code> runs <code>Docker</code> container for remote launch tests.
>
> <code>Allure TestOps</code> form test-case's suits and dashboard and link selected test-cases and launches to <code>Jira</code> task.
>  
> After tests launch notification send to <code>Telegram</code> bot>.

## Running tests from the terminal

### :desktop_computer: Running Tests Locally

```
gradle clean test
```

### :desktop_computer: Remote test running

```
clean test
```
### :desktop_computer: Add file <code>data.properties</code> with data below
```
user.email=eve.holt@reqres.in
user.undefined.email=sample@mail.ru
user.undefined.password=1234
user.first.name=Janet
user.job=QA
user.lastname=Weaver
user.password=pistol
token=QpwL5tke4Pnpja7X4

```
### :scroll: Main page of <code>Allure-report</code>

<p align="center">
<img title="Allure Overview Dashboard" src="images/screens/AllureMain.PNG">
</p>

### :scroll: Suites page of <code>Allure-report</code>

<p align="center">
<img title="Allure Overview Dashboard" src="images/screens/AllureSuites.PNG">
</p>
