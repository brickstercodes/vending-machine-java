# Vending Machine Project

This project is a Java-based Vending Machine application that utilizes Swing for the graphical user interface (GUI). It demonstrates various object-oriented programming concepts such as inheritance, polymorphism, abstraction, and interfaces.

## Project Structure

```
vending-machine
├── src
│   ├── main
│   │   ├── java
│   │   │   ├── com
│   │   │   │   └── vendingmachine
│   │   │   │       ├── exceptions
│   │   │   │       │   └── InsufficientFundsException.java
│   │   │   │       ├── interfaces
│   │   │   │       │   ├── Payment.java
│   │   │   │       │   └── VendingOperations.java
│   │   │   │       ├── models
│   │   │   │       │   ├── AbstractProduct.java
│   │   │   │       │   ├── Beverage.java
│   │   │   │       │   ├── Snack.java
│   │   │   │       │   └── Transaction.java
│   │   │   │       ├── gui
│   │   │   │       │   ├── MainFrame.java
│   │   │   │       │   ├── ProductPanel.java
│   │   │   │       │   └── TransactionPanel.java
│   │   │   │       └── utils
│   │   │   │           └── CollectionManager.java
│   │   │   └── Main.java
│   │   └── resources
├── test
│   └── java
│       └── com
│           └── vendingmachine
│               └── tests
├── pom.xml
└── README.md
```

## Features

- **Custom Exception Handling**: The application includes a custom exception `InsufficientFundsException` to handle scenarios where the user does not have enough funds to complete a transaction.
- **Payment Processing**: Interfaces for payment processing and vending operations are defined to ensure a modular design.
- **Product Management**: The application supports different types of products (Beverages and Snacks) using an abstract class and inheritance.
- **Graphical User Interface**: The GUI is built using Swing, providing an interactive experience for users to select products and make payments.
- **Collection Management**: The application utilizes Java Collections Framework to manage product lists and transactions efficiently.

## Setup Instructions

1. Clone the repository:
   ```
   git clone <repository-url>
   ```
2. Navigate to the project directory:
   ```
   cd vending-machine
   ```
3. Build the project using Maven:
   ```
   mvn clean install
   ```
4. Run the application:
   ```
   mvn exec:java -Dexec.mainClass="Main"
   ```

## Usage

- Launch the application to view the vending machine interface.
- Select products and proceed to payment.
- Handle exceptions gracefully with informative messages.

## Testing

Unit tests for the vending machine functionalities are located in the `test/java/com/vendingmachine/tests` directory. Use Maven to run the tests:

```
mvn test
```

## License

This project is licensed under the MIT License.

## Command:

mvn clean package && java -jar target/vending-machine-1.0-SNAPSHOT.jar
