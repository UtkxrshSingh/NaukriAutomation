# Naukri Automation Testing Framework

This project is a Selenium-based test automation framework developed to automate key user workflows on Naukri.com. The framework follows the Page Object Model (POM) design pattern to improve maintainability, reusability, and scalability of test scripts.

## Features

- Automated login validation
- Profile and job search workflow testing
- Search result verification
- Data-driven test execution
- Page Object Model (POM) implementation
- TestNG test execution and reporting
- Maven project structure
- Automated test reports generation

- ## Test Scenarios Covered

### TC-B1 — Open Home Page

**Objective:** Verify the Naukri home page opens.

**Steps:**

1. Open https://www.naukri.com

**Expected Result:**

* Home page title contains "Naukri"
* Main search box is visible

---

### TC-B2 — Login with Valid Credentials

**Objective:** Verify user can log in with correct credentials.

**Steps:**

1. Click Login
2. Enter valid email/phone and password
3. Click Sign In

**Expected Result:**

* User profile icon is visible
* "My Naukri" section is accessible

---

### TC-B3 — Login with Invalid Credentials

**Objective:** Verify proper error handling for invalid login attempts.

**Steps:**

1. Enter invalid email/password
2. Click Sign In

**Expected Result:**

* Error message displayed
* Login is unsuccessful

---

### TC-B4 — Basic Job Search (Keyword Only)

**Objective:** Verify job search functionality using keyword input.

**Steps:**

1. Enter "Java Developer"
2. Click Search

**Expected Result:**

* Search results page opens
* Job cards are displayed
* Page title contains search keyword

---

### TC-B5 — Basic Job Search (Keyword + Location)

**Objective:** Verify search results using keyword and location.

**Steps:**

1. Enter keyword: "Java"
2. Enter location: "Bengaluru"
3. Click Search

**Expected Result:**

* Relevant jobs are displayed
* Location information is shown in results

---

### TC-B6 — Open Job Details

**Objective:** Verify job details page opens correctly.

**Steps:**

1. Perform a job search
2. Open the first job listing

**Expected Result:**

* Job title displayed
* Company information displayed

---

### TC-B7 — Save a Job

**Objective:** Verify logged-in users can bookmark jobs.

**Steps:**

1. Search for jobs
2. Click Save/Favourite icon

**Expected Result:**

* Save icon changes state
* Job appears under Saved Jobs

---

### TC-B8 — Logout

**Objective:** Verify user logout functionality.

**Steps:**

1. Open profile menu
2. Click Logout

**Expected Result:**

* User redirected to public homepage
* Login/Signup options visible

---

### TC-B9 — Upload Resume

**Objective:** Verify resume upload functionality.

**Steps:**

1. Navigate to Profile
2. Select Upload Resume
3. Upload a valid resume file

**Expected Result:**

* Resume uploaded successfully
* Resume name displayed

---

### TC-B10 — Forgot Password Flow

**Objective:** Verify password recovery workflow.

**Steps:**

1. Click Forgot Password
2. Enter registered email
3. Submit request

**Expected Result:**

* Confirmation message displayed
* OTP/Reset email notification shown

---

## Test Coverage Summary

| Module            | Test Cases                  |
| ----------------- | --------------------------- |
| Home Page         | TC-B1                       |
| Authentication    | TC-B2, TC-B3, TC-B8, TC-B10 |
| Job Search        | TC-B4, TC-B5                |
| Job Details       | TC-B6                       |
| Saved Jobs        | TC-B7                       |
| Resume Management | TC-B9                       |

## QA Concepts Demonstrated

* Functional Testing
* Smoke Testing
* Regression Testing
* End-to-End Testing
* Positive Testing
* Negative Testing
* Selenium Automation
* Test Case Design
* Test Execution
* Defect Verification
* Test Reporting

## Tech Stack

- Java
- Selenium WebDriver
- TestNG
- Maven
- Page Object Model (POM)
- Eclipse / IntelliJ IDEA

## Testing Scope

### Functional Testing
- User Login
- Navigation Validation
- Job Search Functionality
- Search Result Validation
- Session Handling

### Automation Testing
- Browser Automation
- Element Identification
- Assertion Validation
- Automated Test Execution
- Report Generation

## Key QA Concepts Demonstrated

- Automation Testing
- Functional Testing
- Regression Testing
- TestNG Framework
- Selenium WebDriver
- Page Object Model
- Test Reporting
- Test Case Design
- Quality Assurance Best Practices

## Learning Outcomes

- Developed reusable automation scripts using Selenium WebDriver.
- Implemented Page Object Model for maintainable test automation.
- Automated critical user journeys on a real-world job portal.
- Generated execution reports for test result analysis.
- Applied software testing principles and automation framework design.

## Resume Project Description

Naukri.com Test Automation Framework

- Developed an automated testing framework using Java, Selenium WebDriver, TestNG, and Maven.
- Implemented Page Object Model (POM) architecture for reusable and maintainable test scripts.
- Automated login, navigation, and job search workflows.
- Executed regression test suites and generated detailed execution reports.
- Improved testing efficiency by reducing manual validation efforts.

Technologies: Java, Selenium WebDriver, TestNG, Maven, POM, Git
