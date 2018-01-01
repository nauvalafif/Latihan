package com.example.android.latihan;

import java.text.NumberFormat;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

/**
 * This app displays an order form to order coffee.
 */
public class MainActivity extends AppCompatActivity {
    int quantity = 0;
    int price;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * This method is called when the order button is clicked.
     */
    public void increment(View view) {
        quantity = quantity+1;
        display(quantity);
        displayPrice(calculatePrice(quantity));
    }
    public void decrement(View view) {
        if (quantity!=0) {
            quantity = quantity-1;
        }
        display(quantity);
        displayPrice(calculatePrice(quantity));
    }
    public void submitOrder(View view) {
        int numberOfCoffees = quantity;
        display(numberOfCoffees);
        price = calculatePrice(numberOfCoffees);
        String priceMessage = createOrderSummary(price);
        displayMessage(priceMessage);

    }

    public int calculatePrice(int quantity) {

        return quantity*10000;
    }

    public String createOrderSummary(int harga) {
        return "Nama : Daffa Daneswara" + '\n' + "Quantity : " + quantity + '\n' + "Total : " + NumberFormat.getCurrencyInstance().format(harga) + '\n' + "Thank You !";

    }
    /**
     * This method displays the given quantity value on the screen.
     */
    private void display(int number) {
        TextView quantityTextView = (TextView) findViewById(R.id.quantity_text_view);
        quantityTextView.setText("" + number);
    }

    /**
     * This method displays the given price on the screen.
     */
    private void displayPrice(int number) {
        TextView priceTextView = (TextView) findViewById(R.id.order_summary_text_view);
        priceTextView.setText(NumberFormat.getCurrencyInstance().format(number));
    }
    private void displayMessage(String message) {
        TextView orderSummaryTextView = (TextView) findViewById(R.id.order_summary_text_view);
        orderSummaryTextView.setText(message);
    }
}