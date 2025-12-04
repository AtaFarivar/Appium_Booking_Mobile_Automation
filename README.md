
# 📱 Mobile Automation Framework – Appium + Java + TestNG + Cucumber
An end-to-end mobile automation project built for the Booking.com Android application.

## 🚀 Overview
This project automates the full hotel search flow on the Booking.com mobile app using Java, Appium, Cucumber BDD, and TestNG.

## 🧪 Automated Test Flow
- Open the app  
- Close sign-in popup  
- Navigate to **Stays**  
- Enter destination  
- Select suggestion  
- Select **check-in (tomorrow)** & **check-out (+7 nights)**  
- Configure guests & rooms  
- Set children ages using custom NumberPicker scroll action  
- Validate **"Traveling with pets?"** toggle  
- Apply & search  

## 🏗 Project Structure
src/test/java/pages  
src/test/java/stepDefenitions  
src/test/java/utils  
src/test/java/runners  
src/test/resources/features  

## ▶️ How to Run Locally
```bash
mvn clean test
```
or run **TestRunner.java** from IDE.

## 🔄 CI/CD – Jenkins Integration
This project supports Jenkins execution through a freestyle job.

Example CI run command:
```bash
mvn -f Test1/pom.xml clean test
```
Supports:
- Manual build trigger  
- Build on commit (Git polling or webhook)

## 📊 Reporting – Extent Reports
Report output:
```
Test1/Reports/ExtentReport.html
```
Also accessible in Jenkins via **Publish HTML Reports**.

## 👤 Author
**Ata Farivar**  
🔗 https://linkedin.com/in/atafarivar
