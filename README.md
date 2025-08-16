Simple Binary Search Tree Generator
A Spring Boot web application that allows users to create binary search trees from a series of numbers, visualize the resulting tree structure, and view previously created trees.

Features
===================================================================================================================================================================
Interactive Tree Creation: Enter numbers to build a binary search tree
Real-time Visualization: SVG-based tree rendering with nodes and connections
Database Storage: Persistent storage of all created trees using H2 database
Tree History: View and browse all previously created trees
JSON API: RESTful endpoints for tree operations
Responsive Design: Clean, modern UI that works on different screen sizes

Technology Stack
===================================================================================================================================================================
Backend: Spring Boot 3.3.2
Database: H2 (In-memory)
Frontend: HTML5, CSS3, JavaScript, Thymeleaf
Build Tool: Maven
Java Version: 17

Prerequisites
===================================================================================================================================================================
Java 17 or higher
Maven 3.6 or higher
Modern web browser

Getting Started
===================================================================================================================================================================
1. Clone the Repository
bashgit clone <your-repository-url>
cd Trees
2. Build and Run
bashmvn clean install
mvn spring-boot:run
3. Access the Application
Open your browser and navigate to:
http://localhost:8080
API Endpoints
MethodEndpointDescriptionGET/Redirects to main input pageGET/enter-numbersShows the tree input formPOST/process-numbersCreates tree from input numbersGET/previous-treesDisplays all stored treesGET/h2-consoleH2 database console (dev only)

How to Use
===================================================================================================================================================================
Creating a New Tree

Navigate to the home page
Enter numbers separated by commas or spaces (e.g., "5, 3, 7, 1, 9")
Click "Generate Tree"
View the visual representation and JSON structure

Viewing Previous Trees
===================================================================================================================================================================
Click "Show Previous Trees" on the main page
Browse through all previously created trees
Each entry shows:

Original input numbers
Creation timestamp
Tree structure in JSON format


Configuration
===================================================================================================================================================================
The application uses H2 in-memory database by default. Configuration can be modified in application.properties:
properties# Server Configuration
server.port=8080

Database Configuration (Add your own values or use these test ones)
===================================================================================================================================================================
spring.datasource.url=jdbc:h2:mem:testdb
spring.datasource.username=sa
spring.datasource.password=

Testing
===================================================================================================================================================================
Run the unit tests:
mvn test
The project includes tests for:

Tree construction logic
Controller endpoints
Service layer functionality

Binary Search Tree Logic
===================================================================================================================================================================
The application implements a standard binary search tree with the following properties:

Left subtree: Contains nodes with values less than the parent.
Right subtree: Contains nodes with values greater than the parent.
No duplicates: Duplicate values are ignored during insertion.
Sequential insertion: Numbers are inserted in the order provided.
