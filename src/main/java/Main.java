import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        String url = "https://rozetka.com.ua/headphones/c80027/#search_text=наушники";
        List<Brand> brand = new ArrayList<Brand>();
        Document doc = Jsoup.connect(url).get();


        Elements producer = doc.getElementsByAttributeValue("param", "producer");
        Elements list = producer.first().getElementsByTag("li");

        list.forEach(element ->{
            String name = element.getElementsByAttributeValue("class", "filter-parametrs-i-l-i-default-title" ).text();
            String q = element.getElementsByAttributeValue("class", "filter-parametrs-i-l-i-default-count").text();
            if (name.length() != 0) {
                brand.add(new Brand(name, q));
            }
        });

        brand.forEach(b ->{
            String name = b.getName();
            System.out.println(name);
        });
    }
}
