 Lab 4 Report – Implementing GRASP Principles in Java

----Information Expert----
`Book.java` manages its own availability through `borrow()` and `returnBook()`. `Member.java` manages its own borrowed book list through `borrowBook()` and `returnBook()`. Each object performs work using information it already owns.

----Creator----
`Library.java` creates and stores `Book.java` objects in `addBook()` and `Member` objects in `registerMember()`. It is a suitable creator because it contains and manages those collections.

----Controller----
`LibrarianController.java` receives application requests such as borrowing, returning, adding, removing, and looking up records. It delegates the actual work to `Library.java`, `Member.java`, and `Book.java` rather than implementing all the logic itself.

----Low Coupling----
Responsibilities are divided among separate classes. The controller communicates through public methods, and `Library` does not directly change the private fields inside `Book.java` or `Member.java`. Collection getters return unmodifiable views so users cannot edit the private lists.

----High Cohesion----
Each class has a focused purpose:
- `Book.java`: book details and availability.
- `Member.java`: member info and list of books
- `Library.java`: collection of catalog and members
- `LibrarianController.java`: handling and coordinating requests.
- `LibraryApp.java`: the main program to test classes

----Notes----
- A book cannot be removed while it is borrowed.
- A member cannot be removed while they have borrowed books.
- Duplicate member IDs are rejected.