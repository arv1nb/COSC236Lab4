package lab4.library;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Member {

	// GRASP Principle: Information Expert and Low Coupling
	// Can borrow and return books.

	private String name;
	private String memberId;
	// private borrowedbBooks TODO: implement collection of borrowed books
	private List<Book> borrowedBooks;
	// TODO: implement functionality of Member class

	public Member(String name, String memberId) {
		this.memberId = memberId;
		this.name = name;
		this.borrowedBooks = new ArrayList<>();
	}

	public boolean borrowBook(Book book) {
		if (book == null || !book.borrow())
			return false;
		borrowedBooks.add(book);
		return true;
	}

	public boolean returnBook(Book book) {
		if (book == null || !borrowedBooks.contains(book))
			return false;
		if (!book.returnBook())
			return false;
		borrowedBooks.remove(book);
		return true;
	}

	@Override
	public String toString() {
		return name + " (ID: " + memberId + ")";
	}

	// Getters
	public String getMemberId() {
		return memberId;
	}

	public String getName() {
		return name;
	}

	public List<Book> getBorrowedBooks() {
		return Collections.unmodifiableList(borrowedBooks);
	}

}
