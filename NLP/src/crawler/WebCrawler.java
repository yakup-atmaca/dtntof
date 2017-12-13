/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crawler;

import java.io.IOException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

/**
 *
 * @author Yakup
 */
public class WebCrawler {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
//        Spider spider = new Spider();
//        spider.search("https://www.ntv.com.tr/dunya/son-dakika-dogu-kudus-filistinin-baskenti-ilan-edildi,7uaXHsN6DE6OmzhnKAznrA", "Filistin");

//        SpiderLeg spiderLeg = new SpiderLeg();
//        spiderLeg.getValue("https://www.ntv.com.tr/dunya/son-dakika-dogu-kudus-filistinin-baskenti-ilan-edildi,7uaXHsN6DE6OmzhnKAznrA", "Filistin");
//         SpiderLeg spiderLeg = new SpiderLeg();
//         String newsTime = new String();
//        newsTime = spiderLeg.getTime("https://www.ntv.com.tr/dunya/son-dakika-dogu-kudus-filistinin-baskenti-ilan-edildi,7uaXHsN6DE6OmzhnKAznrA", "content");
//
//        System.out.println(newsTime);
        Document document;
//Get Document object after parsing the html from given url.
        document = Jsoup.connect(
                "https://www.ntv.com.tr/dunya/son-dakika-dogu-kudus-filistinin-baskenti-ilan-edildi,7uaXHsN6DE6OmzhnKAznrA")
                .get();
//Get description from document object.
        String description
                = document.select("meta[property=article:modified_time]").get(0)
                        .attr("content");
//Print description.
        System.out.println("Meta Description: " + description);
//Get keywords from document object.
        String keywords
                = document.select("meta[name=keywords]").first()
                        .attr("content");
//Print keywords.
        System.out.println("Meta Keyword : " + keywords);
    }
}
