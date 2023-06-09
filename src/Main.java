import java.io.*;
import java.util.*;

public class Main {
    static Scanner scanner = new Scanner(System.in);
    static String[] products = {"Хлеб", "Яблоки", "Молоко"};
    static int[] prices = {100, 200, 300};

    static File saveFile = new File ("basket.txt");

    public static void main(String[] args) throws FileNotFoundException {

          Basket basket = null;
          if (saveFile.exists()) {
              basket = Basket.loadFromTxtFile(saveFile);
          } else {
              basket = new Basket(products, prices);
          }

        while (true) {
            showPrice();
            System.out.println("Выберете товар и количество через пробел или введите 'end'");
            String input = scanner.nextLine();
            if ("end".equals(input)) {
                break;
            }

            String[] parts = input.split(" ");
            int productNumber = Integer.parseInt(parts[0]) - 1;
            int productCount = Integer.parseInt(parts[1]);
            basket.addToCart(productNumber, productCount);
            basket.saveTxt(saveFile);
        }

        basket.printCart();
    }
    public static void showPrice() {
        for (int i = 0; i < products.length; i++) {
            System.out.println(products[i] + " " + prices[i] + " руб./шт.");
        }
    }
}