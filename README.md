\*\*SoftMouse.NET QA Automation Framework\*\*







\*\*Overview\*\*



This repository contains my QA Engineer interview assessments for ISEEHEAR Inc. It includes:







\\- 10 manual test cases for SoftMouse.NET Colony module



\\- Automation framework for 5 key test cases using Selenium and TestNG



\\- Communication samples 



\\- Bonus tasks on database integrity, performance planning, and security controls







The project demonstrates test design, automation, communication, and critical thinking skills aligned with real-world QA workflows.







---







\*\*Project Structure\*\*







\*\*softmouse-automation/\*\*



\*\*│\*\*



\*\*├── src/\*\*



\*\*│   ├── main/\*\*



\*\*│   │   └── java/\*\*



\*\*│   │       └── softmouse/\*\*



\*\*│   │           ├── base/\*\*



\*\*│   │           │   └── BasePage.java\*\*



\*\*│   │           ├── pages/\*\*



\*\*│   │           │   ├── AnimalPage.java\*\*



\*\*│   │           │   ├── CagePage.java\*\*



\*\*│   │           │   ├── LoginPage.java\*\*



\*\*│   │           │   ├── StrainPage.java\*\*



\*\*│   │           │   └── WebDriver.java\*\*



\*\*│   │           └── utils/\*\*



\*\*│   │               ├── CSVReader.java\*\*



\*\*│   │               ├── CSVUtils.java\*\*



\*\*│   │               ├── CSVWriter.java\*\*



\*\*│   │               ├── ConfigReader.java\*\*



\*\*│   │               ├── ExtentManager.java\*\*



\*\*│   │               ├── ExtentReportUtils.java\*\*



\*\*│   │               ├── JSONUtil.java\*\*



\*\*│   │               ├── LoggerUtil.java\*\*



\*\*│   │               ├── ReporterUtil.java\*\*



\*\*│   │               ├── ScreenshotUtils.java\*\*



\*\*│   │               └── TestUtil.java\*\*



\*\*│   │\*\*



\*\*│   └── test/\*\*



\*\*│       ├── java/\*\*



\*\*│       │   └── softmouse/\*\*



\*\*│       │       ├── listeners/\*\*



\*\*│       │       │   └── TestListener.java\*\*



\*\*│       │       └── tests/\*\*



\*\*│       │           ├── AddStrainTest.java\*\*



\*\*│       │           ├── BaseTest.java\*\*



\*\*│       │           ├── EditAnimalTest.java\*\*



\*\*│       │           ├── ExportAnimalsTest.java\*\*



\*\*│       │           ├── LoginTest.java\*\*



\*\*│       │           ├── MoveAnimalTest.java\*\*



\*\*│       │           ├── PrintAnimalList.java\*\*



\*\*│       │           └── VerifyCageTest.java\*\*



\*\*│       └── resources/\*\*



\*\*│           └── \\\[Test data, configuration files]\*\*



\*\*│\*\*



\*\*├── test-output/\*\*



\*\*│   └── \\\[Test execution reports, e.g., extent-report.html]\*\*



\*\*│\*\*



\*\*├── .gitignore\*\*



\*\*├── pom.xml\*\*



\*\*└── README.md\*\*















---







\*\*Tools \\\& Technologies\*\*







Java 21







Selenium WebDriver







TestNG







Maven







WebDriverManager







ExtentReports







Git \\\& GitHub







---




\*\*Setup Instructions\*\*




\*\*Prerequisites\*\*



Java JDK 21+







Maven 3.8+







Git







IntelliJ IDEA







\*\*Clone the Repo\*\*







git clone https://github.com/roshinijalaludeen/iseehear-qa-assessments.git



cd iseehear-qa-assessments







\*\*Configure Environment\*\*







Create or update your configuration file with:



baseUrl=https://softmouse.net



username=roshiniseehear



password=Softmouse@07







\*\*Running Tests\*\*



Option 1: From IntelliJ



Right-click a test class → Run







Option 2: From Terminal



bash



Copy



Edit



mvn clean test







\*\*Reports and Logs\*\*

test-output/extent-report.html – Interactive Extent Report with pass/fail status







screenshots/ – Failure screenshots (auto-captured with timestamp)






\*\*Dependency Manifest\*\*

This project uses Maven for dependency management. All dependencies are listed in pom.xml. Key dependencies include:

| Dependency                | Version | Purpose                                               |
| ------------------------- | ------- | ----------------------------------------------------- |
| **Selenium Java**         | 4.21.0  | Browser automation using WebDriver APIs               |
| **TestNG**                | 7.9.0   | Testing framework for writing/executing test cases    |
| **WebDriverManager**      | 5.8.0   | Auto-manages browser drivers (no manual setup needed) |
| **Apache POI**            | 5.2.5   | Reading/writing Excel files for test data             |
| **ExtentReports**         | 5.1.1   | Generates rich HTML reports                           |
| **JSON-simple**           | 1.1.1   | Lightweight library to handle JSON configs            |
| **Maven Surefire Plugin** | 3.1.2   | Executes TestNG tests via `testng.xml`                |
| **Maven Compiler Plugin** | JDK 21  | Compiles Java code with preview feature enabled       |






\*\*Contents\*\*



assessments/ – Includes:







Manual test cases (Assessment 1)







Communication drafts (Assessment 2)







Bonus answers: DB checks, perf test, security controls (Assessments 3–5)







Bug report (Failed manual test case)

















