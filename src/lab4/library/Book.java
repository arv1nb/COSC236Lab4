package lab4.library;

public class Book {

	// GRASP Principle: Information Expert
	// Manages its own state (available or borrowed).
	private String title;
	private boolean isAvailable;
	private String author;

	// DONE: implement Book functionality

	public Book(String title, String author) {
		this.title = title;
		this.author = author;
		this.isAvailable = true;
	}

	// Getters
	public String getTitle() {
		return title;
	}

	public String getAuthor() {
		return author;
	}

	public boolean isAvailable() {
		return isAvailable;
	}

	// Methods
	
	// See if book is available to borrow
	public boolean borrow() {
		if (!isAvailable)
			return false;
		isAvailable = false;
		return true;
	}

	// Set avaibility to true when book is returned
	public boolean returnBook() {
		if (isAvailable)
			return false;
		isAvailable = true;
		return true;
	}

	@Override
    public String toString() {
        return title + " by " + author + " (" + (isAvailable ? "Available" : "Borrowed") + ")";
    }

}
