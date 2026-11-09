package lab4.library;

public class LibrarianController {

	// GRASP Principle: Controller
	// Handles user requests like borrowing and returning books.
	// Delegates tasks to the appropriate objects.

	// TODO: implement functionality of Member class
	private Library library;

	public LibrarianController(Library library) {
		this.library = library;
	}

	// Return or borrow book if book is available and member is found
	public void borrowBook(String memberName, String bookTitle) {
		Member member = library.findMemberByName(memberName);
		Book book = library.findBookByTitle(bookTitle);

		if (member == null) {
			System.out.println("Member not found: Cannot complete request");
		} else if (book == null) {
			System.out.println("Book not found: Cannot complete request");
		} else if (!member.borrowBook(book)) {
			System.out.println(bookTitle + " is not available: Cannot complete request");
		} else {
			System.out.println(memberName + " borrowed " + bookTitle + ".");
		}
	}

	public void returnBook(String memberName, String bookTitle) {
		Member member = library.findMemberByName(memberName);
		Book book = library.findBookByTitle(bookTitle);

		if (member == null || book == null) {
			System.out.println("Member or book not found. Cannot complete request");
		} else if (!member.returnBook(book)) {
			System.out.println("This member has not borrowed that book. Cannot complete request");
		} else {
			System.out.println(memberName + " returned " + bookTitle + ".");
		}
	}

	public void addBook(String title, String author) {
		library.addBook(title, author);
		System.out.println("Added book: " + title + ".");
	}

	public void removeBook(String title) {
		if (library.removeBook(title))
			System.out.println("Removed book: " + title + ".");
		else
			System.out.println("Cannot find book: " + title + ".");
	}

	public void registerMember(String id, String name) {
		if (library.registerMember(id, name) != null)
			System.out.println("Registered member: " + name + ".");
		else
			System.out.println("Member already exists: Cannot register member");
	}

	public void removeMember(String id) {
		if (library.removeMember(id))
			System.out.println("Removed memberID: " + id + ".");
		else
			System.out.println("Cannot remove memberID: " + id + ".");
	}

	public void lookupBook(String title) {
		Book book = library.findBookByTitle(title);
		System.out.println(book == null ? "Cannot find book." : book);
	}

	public void lookupMember(String name) {
		Member member = library.findMemberByName(name);
		System.out.println(member == null ? "Cannot find member." : member);
	}

	public void displayCatalog() {
		System.out.println("\nBook catalog:");
		for (Book book : library.getCatalog())
			System.out.println(" - " + book);
	}
}
