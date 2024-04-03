The software system described follows several key principles of object-oriented design, enhancing its flexibility, maintainability, and scalability.

Single Responsibility Principle (SRP) ensures that each class has a clear and focused purpose, enhancing readability and maintainability. For instance, the separation of concerns between classes like Book, Magazine, and CD allows for easier modifications and updates to specific item types without affecting others.

Open-Closed Principle (OCP) allows for the system's extensibility by enabling the addition of new item types or user roles without altering existing code. This flexibility is crucial for accommodating future changes and expansions in the library system.

Liskov Substitution Principle (LSP) ensures that subclasses can seamlessly substitute their base class, providing interoperability and consistency. This principle enhances code reusability and simplifies the implementation of new features or variations.

Interface Segregation Principle (ISP) promotes the creation of specific interfaces tailored to the needs of clients, preventing unnecessary dependencies and ensuring cohesion. By implementing only the methods required by each class, such as Librarian and Patron, ISP minimizes interface bloat and enhances code clarity.

Dependency Inversion Principle (DIP) encourages the use of abstractions, such as interfaces, to decouple high-level modules from concrete implementations. This design approach facilitates easier maintenance, testing, and future enhancements by reducing dependencies and promoting modularity.

The Command-Line Interface (CLI) provides a straightforward method for librarians to interact with the system, demonstrating how users can efficiently utilize the library catalog. By offering a user-friendly interface, the system enhances usability and accessibility, catering to the needs of both novice and experienced users.

Overall, the adherence to these principles fosters a robust, adaptable, and user-friendly software system that can efficiently manage library resources while accommodating future changes and expansions.
