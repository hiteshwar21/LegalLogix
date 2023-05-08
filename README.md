# LegalLogix
The goal is to develop a comprehensive solution for lawyers, enabling them to efficiently create and manage digital records for their clients. This all-in-one platform will facilitate the storage of legal documents and provide intelligent extraction of valuable information from these documents. It aims to streamline the workflow and enhance the working process for advocates.

# Target Group:
- Independent lawyers
- Big law firms

# Business Model:
- Free for individuals.
- Licensed for Big Law Firms.

# Features for MVP:
1. Login & Registration with Server-side validations
 - Save clients details on Cloud securely with Spring Security.
 - Encryption on saving passwords with BCrypt password encoder.
2. Listing of clients per advocate
 - Client Dashboard to view, add, update, delete clients, logout etc. 
 - Added pagination for pages to view more clients.
3. Document/data per client in Listing/ShowPage form
 - Store scanned legal docs/contracts and process them to machine-readable PDFs.
4. Invoices/Client Fees
5. Download Excels
6. Time Effort/ Key Performance Indicator
7. Docker Implementation
8. Unit Test cases for everything
9. Uploaded Doc Validations
10. Complete deletion of a user from system (GDFR Compliance)

# Future features:
1. Calendars/Hearing notifications at email
2. Universal search
3. Extraction for docs
4. Automatically extract data out of docs.
 - Trained ML models that could identify certain metadata/clauses from these documents.

# User Journey for happy flow:

- User Login/Register on the first page that opens.
- After Login, our Homepage dashboard will be visible with Basic Client Information Listing. The user will have an option to create a new client from this page itself.
  The Basic Client Information listing will be based on URLs that can open a certain Client Dashboard.
- On the Client dashboard page, there will be client-specific data. Consisting of different documents repo based out of  :
    - FIRs(if any)
    - Evidence
    - Counter Reference
    - Similar Cases
    - Miscellaneous
- All these documents would have addition/updation(in the form of uploads in JPEG Format) allowed on them. (Delete will also be there but only Soft Delete aka Archive).
- Further, Clicking on Document would lead you to Document Show Page, where we have OCRed copy of the original document. We can view the original document as well by clicking a toggle.

# Dependencies
- spring-boot-starter-data-jdbc
- spring-boot-starter-security
- spring-boot-starter-web
- mybatis-spring-boot-starter
- spring-boot-devtools
- flyway-core
- lombok
- spring-boot-starter-test
- spring-security-test
- spring-boot-maven-plugin


# Login Page
![Login Page](https://user-images.githubusercontent.com/22851620/144982082-6b1c63dc-ba2c-4f0a-bbb8-7bed0348f724.png)

# Forgot Password
![Forgot password](https://user-images.githubusercontent.com/22851620/144982121-c7127feb-31e6-4824-b1ac-0c54c12ee59b.png)

# User Dashboard
![User Dashboard](https://user-images.githubusercontent.com/22851620/144981347-71c76fc6-ac46-4d34-affc-5fc2729cc5eb.png)

# Client DashBoard
![Client Dashboard](https://user-images.githubusercontent.com/22851620/144982328-e0d2902a-9840-41da-8ec9-4e11577f6ce5.png)

# Document Show Page
![Document ShowPage](https://user-images.githubusercontent.com/22851620/144982204-0a89f129-4360-4393-b738-bc505866c56b.png)

# Client DashBoard Copy
![Client Dashboard copy](https://user-images.githubusercontent.com/22851620/144982391-024663f8-8e76-4b28-bc59-c124e74d54e8.png)


