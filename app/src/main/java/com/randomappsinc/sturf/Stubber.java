package com.randomappsinc.sturf;

import com.randomappsinc.sturf.Models.Item;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by alexanderchiou on 3/27/16.
 */
public class Stubber {
    public static List<Item> getItems() {
        List<Item> items = new ArrayList<>();

        Item book = new Item();
        book.setTitle("Econ 101 Textbook");
        book.setCategory("School Supplies");
        book.setSubcategory("Textbook");
        book.setLocation("UCLA Ackerman");
        book.setImageUrl("http://pngimg.com/upload/book_PNG2116.png");
        items.add(book);

        Item pizza = new Item();
        pizza.setTitle("Free Pizza");
        pizza.setCategory("Food/Drink");
        pizza.setSubcategory("Junk Food");
        pizza.setLocation("Berkeley Sproul");
        pizza.setImageUrl("http://troppa-nl.com/wp-content/uploads/2015/08/pizza-stock.jpg");
        items.add(pizza);

        return items;
    }
}
