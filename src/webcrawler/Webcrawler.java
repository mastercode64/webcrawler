package webcrawler;

import java.util.List;

public class Webcrawler {
	
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		String url = "https://kotlinlang.org/docs/books.html";
		
		WebcrawlerService service = new WebcrawlerService();
		
		
		List<Book> books = service.getBooksFromUrl(url);
		
		System.out.println("\nListing all books\n");
		books.forEach(b -> {
			System.out.println(b.toString());
		});
	}

}
