package webcrawler;

public class Book {

	private Long bookId;
	private String title;
	private String description;
	private String isbn;
	private String language;
	
	public String toString() {
		String text = 
				this.title + "\n" +
				this.language + "\n" +
				this.description + "\n" +
				this.isbn + "\n";
		return text;
	}

	public Long getBookId() {
		return bookId;
	}

	public void setBookId(Long bookId) {
		this.bookId = bookId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

}