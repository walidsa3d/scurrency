/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package scurrency.converter;

import java.io.IOException;
import java.net.URLEncoder;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/**
 *
 * @author walid
 */
public class CurrConv {
    private String c1;
    private String c2;
    private double c;
    private String s;
    public String Convert(double c, String c1, String c2) throws IOException{
       String base= "http://www.google.com/search?q=";
       String query=+c+"+"+c1+"+"+"in"+"+"+c2;
       String enquery=URLEncoder.encode(query, "UTF-8");
       String url=base+enquery;
//        System.out.println(url);
Document doc = Jsoup.connect(url)
        .userAgent("Mozilla/6.0 (Windows NT 6.2; WOW64; rv:16.0.1) Gecko/20121011 Firefox/16.0.1")
      .referrer("http://www.google.com")
      .get();
Elements res=doc.select("html body#gsr.tbo div#main div div#cnt div.mw div#rcnt div#center_col div#res.med div#search div#ires ol#rso li.currency div.vk_ans span");
//for(Element i:res){
////    System.out.println(""+i.html());
//     s[0]=i.html();
////     System.out.println(s);
//    }
s=res.get(0).html();
    return s;

    }
    }

