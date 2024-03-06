package com.example.testing2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import android.view.View.OnClickListener;
import android.view.View.OnClickListener;
import android.view.View.OnClickListener;
import android.view.View.OnClickListener;

import android.view.View;


public class MainActivity extends AppCompatActivity {

    private EditText enter;
    private Button fifteen;
    private Button twenty;
    private Button twenfive;
    private EditText guests;
    private TextView tamount;
    private TextView totamount;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        enter = findViewById(R.id.enter);
        fifteen = findViewById(R.id.fifteen);
        twenty = findViewById(R.id.twenty);
        twenfive = findViewById(R.id.twenfive);
        guests = findViewById(R.id.guests);
        tamount = findViewById(R.id.tamount);
        totamount = findViewById(R.id.totamount);

        // Set the click listeners for all three tip percentage buttons
        fifteen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculateTip(15);
            }
        });

        twenty.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculateTip(20);
            }
        });

        twenfive.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculateTip(25);
            }
        });
    }

    private void calculateTip(int tipPercentage) {
        // Get the bill amount entered by the user
        double billAmount = Double.parseDouble(enter.getText().toString());

        // Get the number of guests entered by the user
        int numGuests = Integer.parseInt(guests.getText().toString());

        // Calculate the total amount per guest
        double totalAmountPerGuest = billAmount / numGuests;

        // Calculate the tip amount based on the total amount per guest and tip percentage
        double tipAmount = totalAmountPerGuest * (tipPercentage / 100.0);

        // Calculate the total amount (bill amount + tip amount) per guest
        double totalAmount = totalAmountPerGuest + tipAmount;

        // Format the tip amount, total amount per guest, and total amount as strings with two decimal places
        String formattedTipAmount = String.format("%.2f", tipAmount);
        String formattedTotalAmountPerGuest = String.format("%.2f", totalAmountPerGuest);
        String formattedTotalAmount = String.format("%.2f", totalAmount);

        // Update the UI to display the formatted tip amount, total amount per guest, and total amount
        tamount.setText(formattedTipAmount);
        totamount.setText(formattedTotalAmount);
    }



}