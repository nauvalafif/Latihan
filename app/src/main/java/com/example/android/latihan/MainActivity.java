package com.example.android.latihan;

import java.text.NumberFormat;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageButton;
import android.widget.ImageView;
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
        String krim = Boolean.toString(checkedorNot(R.id.krim_checkbox));
        String coklat = Boolean.toString(checkedorNot(R.id.coklat_checkbox));
        String priceMessage = createOrderSummary(price, krim, coklat);
        displayMessage(priceMessage);

        if ((checkedorNot(R.id.krim_checkbox)) && (checkedorNot(R.id.coklat_checkbox))) {
            displayPic(R.drawable.kopi_krim_coklat);
        } else if (checkedorNot(R.id.krim_checkbox)) {
            displayPic(R.drawable.kopi_krim);
        } else if (checkedorNot(R.id.coklat_checkbox)) {
            displayPic(R.drawable.kopi_coklat);
        } else {
            displayPic(R.drawable.kopi);
        }
    }

    public int calculatePrice(int quantity) {

        return quantity*10000;
    }

    public String createOrderSummary(int harga, String krim, String coklat) {
        return "Name : Daffa Daneswara" + '\n' + "Dikeki krim? " + krim + '\n' + "Dikeki coklat? " + coklat + '\n' + "Quantity : " + quantity + '\n' + "Total : " + NumberFormat.getCurrencyInstance().format(harga) + '\n' + "Thank You !";

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

    private boolean checkedorNot(int id) {
        CheckBox cekboks = (CheckBox) findViewById(id);
        return cekboks.isChecked();
    }

    private void displayPic(int idpic) {
        ImageView gambarkopi = (ImageView) findViewById(R.id.gambar_kopi);
        gambarkopi.setImageResource(idpic);
    }
}