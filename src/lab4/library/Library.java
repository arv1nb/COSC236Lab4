package lab4.library;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Library {

	// GRASP Principles: Creator, Controller
	// Manage the catalog of books and members.
	// Track which books are borrowed and available

	// Attributes:
	private List<Book> catalog;
	private List<Member> members;

	// TODO: implement functionality of Member class

	public Library() {
		catalog = new ArrayList<>();
		members = new ArrayList<>();
	}

	// Creator (Library creates and stores books)
	public Book addBook(String title, String author) {
		Book book = new Book(title, author);
		catalog.add(book);
		return book;
	}

	public boolean removeBook(String title) {
		Book book = findBookByTitle(title);
		if (book == null || !book.isAvailable())
			return false;
		return catalog.remove(book);
	}

	public Book findBookByTitle(String title) {
		for (Book book : catalog) {
			if (book.getTitle().equalsIgnoreCase(title))
				return book;
		}
		return null;
	}

	// Creator (Library creates and stores members)
	public Member registerMember(String memberId, String name) {
		if (findMemberById(memberId) != null)
			return null;
		Member member = new Member(memberId, name);
		members.add(member);
		return member;
	}

	public boolean removeMember(String memberId) {
		Member member = findMemberById(memberId);
		if (member == null || !member.getBorrowedBooks().isEmpty())
			return false;
		return members.remove(member);
	}

	public Member findMemberByName(String name) {
		for (Member member : members) {
			if (member.getName().equalsIgnoreCase(name))
				return member;
		}
		return null;
	}

	public Member findMemberById(String memberId) {
		for (Member member : members) {
			if (member.getMemberId().equalsIgnoreCase(memberId))
				return member;
		}
		return null;
	}

	// Getters
	public List<Book> getCatalog() {
		return Collections.unmodifiableList(catalog);
	}

	public List<Member> getMembers() {
		return Collections.unmodifiableList(members);
	}

}
