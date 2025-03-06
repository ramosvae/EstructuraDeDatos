/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectoestructurasdatos;

import java.io.IOException;
import javax.swing.JOptionPane;
import org.jsoup.nodes.Document;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/**
 *
 * @author enano
 */
public class WebScraping {
    public String aTxt = "";
    String url = "https://books.toscrape.com/catalogue/a-light-in-the-attic_1000/index.html";
    String url2 = "https://books.toscrape.com/index.html";

    public void Scrap() {
        try {
            Document document = Jsoup.connect(url).get();
            Document documento = Jsoup.connect(url2).get();
            Elements pees = document.select("p");

            for (Element p : pees) {

                String laP = p.select("p").text();
                if (laP.contains("It's hard to imagine a world withou")) {
                    String superP = laP;
                    System.out.println(superP);
                }
                System.out.print("*************\n");
            }
            
            Elements books = documento.select(".product_pod");
            for (Element bk : books) {
                String titulo = bk.select("h3 > a").text();
                String precio = bk.select(".price_color").text().substring(2);
                aTxt += "\nTitulo: " + titulo + "\nPrecio: " + precio + "\n************";
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(aTxt);
    }
}
