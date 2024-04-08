package com.example.font;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private TextView fontPropertiesText, fontSizeText, quoteText;
    private SeekBar seekBar;
    private Button nextButton;
    private String[] quotes = {"Dzień dobry", "Good morning", "Buenos dias"};
    private int currentQuoteIndex = 2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        LinearLayout layout = new LinearLayout(this);
        layout.setOrientation(LinearLayout.VERTICAL);
        layout.setBackgroundColor(0xFF558B2F);
        layout.setPadding(20, 20, 20, 20);

        fontPropertiesText = new TextView(this);
        fontPropertiesText.setText("Właściwości czcionki");
        fontPropertiesText.setTextSize(24);
        fontPropertiesText.setTextColor(0xFFFFFFFF);
        fontPropertiesText.setPadding(0, 0, 0, 20);

        fontSizeText = new TextView(this);
        fontSizeText.setText("Rozmiar: 20");
        fontSizeText.setTextSize(18);
        fontSizeText.setTextColor(0xFFFFFFFF);
        layout.addView(fontPropertiesText);
        layout.addView(fontSizeText);

        seekBar = new SeekBar(this);
        seekBar.setMax(40);
        seekBar.setProgress(20);
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                fontSizeText.setText("Rozmiar: " + progress);
                quoteText.setTextSize(progress);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {}

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {}
        });
        layout.addView(seekBar);

        quoteText = new TextView(this);
        quoteText.setText(quotes[currentQuoteIndex]);
        quoteText.setTextSize(20);
        quoteText.setTextColor(0xFFFFFFFF);
        layout.addView(quoteText);

        nextButton = new Button(this);
        nextButton.setText(">>");
        nextButton.setTextSize(18);
        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                currentQuoteIndex = (currentQuoteIndex + 1) % 3;
                quoteText.setText(quotes[currentQuoteIndex]);
            }
        });
        layout.addView(nextButton);

        setContentView(layout);
    }
}