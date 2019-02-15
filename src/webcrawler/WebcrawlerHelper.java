package webcrawler;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class WebcrawlerHelper {

	public static Elements getHtmlContent(String url, String cssQuery) throws Exception {
		Document doc = Jsoup.connect(url).get();
		Elements bookList = doc.select(cssQuery).first().children();
		return bookList;
	}

	public static boolean wordIsIsbn(String word) {
		String pattern = "^(97(8|9))?\\d{9}(\\d|X)$";
		// Create a Pattern object
		Pattern r = Pattern.compile(pattern);

		// Now create matcher object.
		Matcher m = r.matcher(word);
		return m.find();
	}

	public static String findIsbnInElements(Elements elements) {
		for (Element e : elements) {
			String text = e.html();
			String[] wordArray = text.split(" ");
			for (String word : wordArray) {
				if (WebcrawlerHelper.wordIsIsbn(word)) {
					return word;
				}

			}
		}
		return "Unavailable";
	}

}
