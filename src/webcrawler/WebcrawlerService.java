package webcrawler;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class WebcrawlerService {

	private String cssQuery = "article.page-content.g-9";
	private Book book;

	public List<Book> getBooksFromUrl(String url) throws Exception {

		Elements elements = WebcrawlerHelper.getHtmlContent(url, cssQuery);
		
		List<Book> bookList = new ArrayList<Book>();
		book = new Book();
		
		for(Element element: elements) {
			if(book.getTitle() == null) {
				if(element.tagName().toLowerCase() == "h2")
					book.setTitle(element.text());
			}
			else if(book.getLanguage() == null) {
				if(element.tagName().toLowerCase().equals("div") && element.className().toLowerCase().equals("book-lang"))
					book.setLanguage(element.text());
			}
			else if(element.tagName().toLowerCase().equals("a") && element.child(0).className().toLowerCase().equals("book-cover-image")) {
				
			}
			else if(element.tagName().toLowerCase().equals("p")) {
				String description = Optional.ofNullable(book.getDescription()).orElse("") + element.text();
				book.setDescription(description);
				
				if(element.nextElementSibling() == null || element.nextElementSibling().tagName().toLowerCase().equals("h2")) {
					bookList.add(book);
					book = new Book();
				}
			}
		}

		return bookList;
	}
}
