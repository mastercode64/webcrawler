package webcrawler;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

public class WebcrawlerHelper {

	public static Elements getHtmlContent(String url, String cssQuery) throws Exception {
		Document doc = Jsoup.connect(url).get();
		Elements bookList = doc.select(cssQuery).first().children();
		return bookList;
	}

}
