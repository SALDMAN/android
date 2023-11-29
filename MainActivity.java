package com.example.anew;

import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.PopupMenu;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private int selectedBgColor = Color.BLACK;
    private int selectedTextColor = Color.WHITE;
    private int selectedImageResource = 0;
    private Button btnBackgroundColor;
    private Button btnForegroundColor;
    private Button btnChooseImage;
    private EditText editTextGreeting;
    private Button btnNext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnBackgroundColor = findViewById(R.id.btnBackgroundColor);
        btnForegroundColor = findViewById(R.id.btnForegroundColor);
        btnChooseImage = findViewById(R.id.btnChooseImage);
        editTextGreeting = findViewById(R.id.editTextGreeting);
        btnNext = findViewById(R.id.btnNext);

        btnBackgroundColor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showPopupMenu(btnBackgroundColor, R.menu.menu2);
            }
        });

        btnForegroundColor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showPopupMenu(btnForegroundColor, R.menu.menu3);
            }
        });

        btnChooseImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showPopupMenu(btnChooseImage, R.menu.main_menu);
            }
        });

        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String greetingText = editTextGreeting.getText().toString();

                // Start SecondActivity with chosen options
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                intent.putExtra("bgColor", selectedBgColor);
                intent.putExtra("textColor", selectedTextColor);
                intent.putExtra("imageResource", selectedImageResource);
                intent.putExtra("greetingText", greetingText);
                startActivity(intent);
            }
        });
    }

    private void showPopupMenu(final Button button, final int menuRes) {
        PopupMenu popupMenu = new PopupMenu(MainActivity.this, button);
        popupMenu.getMenuInflater().inflate(menuRes, popupMenu.getMenu());

        popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(android.view.MenuItem menuItem) {
                handleMenuItemClick(menuItem.getItemId());
                return true;
            }
        });

        popupMenu.show();
    }

    private void handleMenuItemClick(int itemId) {
        View v = getWindow().getDecorView(); // bg view
        if (itemId == R.id.colorGreen) {
            selectedBgColor = Color.parseColor("#00FF00"); // Green background
            selectedTextColor = Color.parseColor("#000000"); // Black text
        } else if (itemId == R.id.colorYellow) {
            selectedBgColor = Color.parseColor("#FFFF00"); // Yellow background
            selectedTextColor = Color.parseColor("#000000"); // Black text
        } else if (itemId == R.id.colorBlue) {
            selectedBgColor = Color.parseColor("#0000FF"); // Blue background
            selectedTextColor = Color.parseColor("#FFFFFF"); // White text
        } else if (itemId == R.id.menu_item1) {
            selectedImageResource = R.drawable.hanuc;
            selectedTextColor = Color.parseColor("#000000"); // Black text
        } else if (itemId == R.id.menu_item2) {
            selectedImageResource = R.drawable.safgi;
            selectedTextColor = Color.parseColor("#FFFFFF"); // White text
        } else if (itemId == R.id.menu_item3) {
            selectedImageResource = R.drawable.sef;
            selectedTextColor = Color.parseColor("#00FF00"); // Green text
        }
    }
    }



