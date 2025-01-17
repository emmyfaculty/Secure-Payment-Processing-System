# Secure Payment Processing System

## Table of Contents

- [Overview](#overview)
- [Features](#features)
- [Technologies Used](#technologies-used)
- [Setup and Installation](#setup-and-installation)
- [Usage](#usage)
- [Authentication](#authentication)
- [Contributing](#contributing)

[//]: # (- [License]&#40;#license&#41;)

## Overview

The payment processing system is designed to handle multiple payment methods (credit cards, bank transfers, digital wallets) while maintaining high security, availability, and scalability standards. The system employs a microservices architecture to ensure modularity, scalability, and ease of maintenance
## Features

- **User Login**: Enables users to authenticate and receive a JWT token for subsequent requests.
- **JWT Authentication**: Secure access to the application using JSON Web Tokens.
- **Process Payment**: Allows users to process payment by using Card, Transfer or Digital wallet to a mock API.
- **Error Handling**: Robust error handling that provides meaningful responses based on the API's feedback.

## Technologies Used

- **Java**: The primary programming language used for building the service.
- **Spring Boot**: Framework for developing the service with ease of configuration and deployment.
- **Spring Security**: Provides authentication and authorization for the application.
- **JWT**: JSON Web Tokens for secure user authentication.

## Setup and Installation

To set up the Secure Payment Processing System on your local machine, follow these steps:

1. **Clone the repository**:
    ```bash
    git clone https://github.com/emmyfaculty/Secure-Payment-Processing-System.git
    cd airtime-service-app
    ```

2. **Build the project**:
    Ensure you have Maven installed, then run:
    ```bash
    mvn clean install
    ```

3. **Run the application**:
    Start the Spring Boot application:
    ```bash
    mvn spring-boot:run
    ```

4. **Configure application properties**:
    Update your `application.properties` file with the necessary configuration for your external API, JWT settings, and database connection.

## Usage

After setting up the application, you can interact with the Airtime Service through its API endpoints.

### Authentication Endpoints

- **POST /api/user**
    - **Request Body**: JSON representation of user registration details (e.g., username, password, email).
    - **Response**: Returns a confirmation message upon successful registration.

- **POST /api/user/login**
    - **Request Body**: JSON representation of login credentials (e.g., username, password).
    - **Response**: Returns a JWT token for authenticated requests.
  
- **POST /api/user/fundWallet**
    - **Request Body**: JSON representation of funding wallet (e.g., walletNumber, amount).
    - **Response**: Returns a JWT token for authenticated requests.

### Airtime Purchase Endpoint

- **POST /api/airtime/purchase**
    - **Request Body**: JSON representation of `AirtimeRequestDto`
    - **Headers**: Include `Authorization: Bearer <JWT_TOKEN>`
    - **Response**: Returns an `AirtimeResponse` containing the result of the purchase request.

### Example Request for Login

```json

{
    "username": "emmanuel",
    "password": "ahola"
}
```

### Example Request for Processing Transfers

```json
{
  "type": "CREDIT_CARD",
  "amount": 100.50,
  "currencyCode": "USD",
  "paymentInstrument": {
    "cardNumber": "1234567812345678",
    "expiryMonth": "12",
    "expiryYear": "25",
    "cvv": "123",
    "accountNumber": "123456789012",
    "routingNumber": "111000025"
  }
}
```

### Example Response

```json
{
  "id": 3,
  "transactionId": "P-C2024-10-27524c01d1-f5ba-4fbe-b789-997f62beca49",
  "type": "CREDIT_CARD",
  "amount": 100.50,
  "currencyCode": "USD",
  "status": "FAILED",
  "createdAt": "2024-10-27T12:43:15.752609Z"
}
```

## Authentication

The application uses JWT for securing endpoints. Upon successful login, a JWT token is generated and returned to the user. This token should be included in the `Authorization` header for all subsequent requests to protected endpoints.

### Example of Authorization Header

```http
Authorization: Bearer <your_jwt_token>
```
## Contributing

Contributions are welcome! If you have suggestions for improvements or bug fixes, please create a pull request or open an issue.

1. Fork the repository
2. Create your feature branch (`git checkout -b feature/MyFeature`)
3. Commit your changes (`git commit -m 'Add some feature'`)
4. Push to the branch (`git push origin feature/MyFeature`)
5. Open a pull request

[//]: # (## License)

[//]: # ()
[//]: # (This project is licensed under the MIT License - see the [LICENSE]&#40;LICENSE&#41; file for details.)#   S e c u r e - P a y m e n t - P r o c e s s i n g - S y s t e m 
 
 
