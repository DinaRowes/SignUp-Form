# SignUp-Form
## Hot to run :
- The project contains 2 classes Testng for (happy & negtaive scenarios)  & 1 class Data reader & class runner 
-  you can run test suit in contains test runner class
 ```
- Tech Stack: Selenium JAVA,Maven ,TestNG,

## The Reports :tada:
- The project use the **Allure** report for generating the reports after running
- The reports files located in project root file under /allure-results folder
- but you need to install Allure in your local machine to be able to read these reports

- If you are on **windows** you can execute the bellow commands to install Allure:  :shipit:
```
 Set-ExecutionPolicy RemoteSigned -scope CurrentUser
 iwr -useb get.scoop.sh | iex
 scoop install allure
```

- After install the Allure on your machine and run tests, you can use this command to open the report:
 ```
 allure serve allure-results
