/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crawler;

import java.io.IOException;

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

        SpiderLeg spiderLeg = new SpiderLeg();
        spiderLeg.getValue("https://www.ntv.com.tr/dunya/son-dakika-dogu-kudus-filistinin-baskenti-ilan-edildi,7uaXHsN6DE6OmzhnKAznrA", "Filistin");

    }
}
