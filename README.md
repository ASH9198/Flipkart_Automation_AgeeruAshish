# Flipkart Automation Framework

## Overview
This project is an automated testing framework for Flipkart's web application, built using the Page Object Model (POM) design pattern. It leverages Selenium WebDriver for browser automation, Java as the programming language, and TestNG as the test runner and reporting tool.

## Technologies Used
- **Java**: Main programming language for the framework.
- **Selenium WebDriver**: For automating browser actions and web UI testing.
- **TestNG**: For test execution, assertions, and reporting.
- **Maven**: For project build, dependency management, and running tests.

## Project Structure
```
├── pom.xml                  # Maven configuration and dependencies
├── testng.xml               # TestNG suite configuration
├── src/
│   ├── main/
│   │   └── java/
│   │       └── com/flipkart/qa/
│   │           ├── config/         # Configuration files (e.g., config.properties)
│   │           ├── listeners/      # TestNG listeners (e.g., for reporting)
│   │           ├── pages/          # Page Object Model classes for each page
│   │           ├── testdata/       # Test data files (e.g., testdata.properties)
│   │           └── utils/          # Utility classes (e.g., reporting, helpers)
│   └── resources/                  # Additional resources
│
│   └── test/
│       └── java/
│           └── com/flipkart/qa/
│               ├── base/           # Base classes (e.g., BasePage)
│               └── testcases/      # Test case classes (e.g., FlipkartEndToEndFlow)
│       └── resources/              # Test resources
├── target/                        # Compiled classes and test outputs
└── test-output/                   # TestNG and ExtentReports outputs
```

## How to Run the Project
1. **Prerequisites:**
   - Java JDK 8 or above
   - Maven
   - ChromeDriver (or other WebDriver executables as needed)

2. **Clone the repository:**
   ```
   git clone <repository-url>
   cd Flipkart_Automation_AgeeruAshish
   ```

3. **Configure properties:**
   - Update `src/main/java/com/flipkart/qa/config/config.properties` with the required configuration (e.g., browser, URL).
   - Update `src/main/java/com/flipkart/qa/testdata/testdata.properties` with test data as needed.

4. **Run tests using Maven:**
   ```
   mvn clean test
   ```
   This will execute the tests as defined in `testng.xml` and generate reports in the `test-output/` directory.

5. **View Reports:**
   - Open `test-output/emailable-report.html` or `test-output/ExtentReports/extentReport.html` in a browser to view the test results.

## Framework Highlights
- **Page Object Model (POM):** Each page of the application is represented by a separate class, encapsulating its elements and actions.
- **Reusable Utilities:** Common functions and reporting utilities are placed in the `utils` package.
- **Test Data Management:** Test data is externalized in properties files for easy maintenance.
- **Listeners and Reporting:** Custom listeners and reporting are implemented for enhanced test result tracking.

