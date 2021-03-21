package at.papp.stockfinder.service;

import at.papp.stockfinder.model.ProductUrl;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.StandardCharsets;


@Service
public class ProductUrlService implements Serializable {

    public String getContentOfProductUrl(ProductUrl pu) {
        URL url = null;
        try {
            url = new URL(pu.getProductUri());
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream(), StandardCharsets.UTF_8))) {
            for (String line; (line = reader.readLine()) != null;) {
                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

//    public boolean isProductAvailableAtUrl(ProductUrl pu) {
        // try {
//            Launcher launcher = new Launcher();
//            try (SessionFactory factory = launcher.launch();
//                 Session session = factory.create(new SessionSettings(1, 1))) {
//                while (true) {
//
//                    ProductUrl.getUrls().forEach(url -> checkForStock(session, url));
//                    TimeUnit.MINUTES.sleep(mins);
//                }
//
//            } catch (Exception e) {
//                Main.printMessage("Exception1: " + e.getMessage());
//            }
//
//        } catch (Exception e) {
//            Main.printMessage("Exception2: " + e.getMessage());
//        }
        //    }
//    }
//    private static void checkForStock(Session session, ProductUrl pu) {
//        session.navigate(pu.getUrl());
//        session.waitDocumentReady();
//        String content = (String) session.getProperty("//body", "innerText");
//        try {
//            Main.printMessage(pu.getProduct().getProductName() + " unavailable at "
//                    + new URI(pu.getUrl()).getHost() + "!");
//        } catch (URISyntaxException e) {
//            e.printStackTrace();
//        }
//        String priceStr = "";
//        if (content.toLowerCase().contains("add to cart")) {
//            try {
//                priceStr = (String) session.getProperty("//h4", "innerText");
//                Main.printMessage("priceStr: " + priceStr);
//                double price = Double.parseDouble(priceStr.replace(",", ".").replace(" €", ""));
//                Main.printMessage("******** ALERT! You can buy " + pu.getProduct().getProductName() + " for " + price + "EUR at {"
//                        + pu.getUrl() + "}! ********");
//            } catch (NumberFormatException e) {
//                Main.printMessage("priceStr: " + priceStr);
//                //System.out.println("Error parsing price: " + e.getMessage());
//                e.printStackTrace();
//            }
//        }
//    }

    private static void printMessage(String msg) {
//        System.out.println(LocalDateTime.now().toLocalDate() + " " + LocalDateTime.now().toLocalTime().getHour() + ":"
//                + LocalDateTime.now().getMinute() + " -> "
//                + msg);
    }

}
