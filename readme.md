# Email Service Project

This project is an email service built using **Spring Boot** for the backend and **Angular** for the frontend. It allows users to send emails through RediffPro's SMTP service.

## Table of Contents

- [Features](#features)
- [Technologies Used](#technologies-used)
- [Getting Started](#getting-started)
- [Backend Setup](#backend-setup)
- [Frontend Setup](#frontend-setup)
- [API Endpoints](#api-endpoints)
- [Usage](#usage)
- [Troubleshooting](#troubleshooting)
- [License](#license)

## Features

- Send emails via RediffPro SMTP service.
- User-friendly interface to input email details (recipient, subject, and message).
- Error handling and user feedback via notifications.

## Technologies Used

- **Backend**: Spring Boot, Jakarta Mail
- **Frontend**: Angular, Angular Material
- **Database**: None (Currently, it doesn't use a database)
- **HTTP Client**: Axios for making HTTP requests from Angular.

## Getting Started

### Prerequisites

- Java Development Kit (JDK) 11 or higher
- Node.js and npm (for the Angular frontend)
- Angular CLI
- RediffPro email account (for SMTP configuration)

### Backend Setup

1. Clone the repository:
2. Update the EmailService class with your RediffPro email credentials
3. The application by default will start on http://localhost:8080

```java
   String from = "your-email@rediff.com"; // Your RediffPro email
   String host = "smtp.rediffmailpro.com"; // RediffPro SMTP server
```

### Frontend Setup

1. Navigate to the frontend directory

```bash
cd email-service-frontend
npm install
ng serve
```

2. Update the API URL in the EmailService class to match your backend URL

```java
private apiUrl = 'http://localhost:8080/send-mail'; // Adjust if necessary
```

3. The application will run on http://localhost:4200.
