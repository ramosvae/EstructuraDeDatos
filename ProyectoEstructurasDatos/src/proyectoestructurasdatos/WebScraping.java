/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectoestructurasdatos;

import java.io.IOException;
import org.jsoup.nodes.Document;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/**
 *
 * @author enano
 */
public class WebScraping {
    public String lastToTxt = "";
    public String toTxt = "";
    String url = "https://books.toscrape.com/catalogue/a-light-in-the-attic_1000/index.html";
    String url2 = "https://books.toscrape.com/index.html";
    String url3 = "https://www.xe.com/es/currencyconverter/convert/?Amount=1&From=USD&To=CRC";

    
    public void Scrap() {
        try {
            Document documentDescription = Jsoup.connect(url).get();
            Document documentBooks = Jsoup.connect(url2).get();
            Document documentDolar = Jsoup.connect(url3).get();
            
            Elements pees = documentDescription.select("p");
            for (Element p : pees) {
                String laP = p.select("p").text();
                if (laP.contains("It's hard")) {
                    lastToTxt = laP;
                    //System.out.println(superP);
                }
                //System.out.print("*************\n");
            }
            
            Elements books = documentBooks.select(".product_pod");
            for (Element b : books) {
                String titulo = b.select("h3 > a").text();
                String precio = b.select(".price_color").text().substring(2);
                toTxt += "\nTitulo: " + titulo + "\nPrecio: " + precio + "\n************";
            }
            
            String dolarValor = documentDolar.select(".sc-294d8168-1").text().substring(0, 6);
            toTxt += "\nPrecio actual del dolar: ₡" + dolarValor;
            
            
            
        } catch (IOException e) {
            e.printStackTrace();
        }
        toTxt += "\n\n"+lastToTxt;
        
        //System.out.println(toTxt);
    }
}
