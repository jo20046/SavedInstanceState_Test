package de.jo20046.savedinstancestate_test;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    EditText editText;
    Button button;
    TextView textView;
    final String KEY_TEXT_VALUE = "text_value";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = findViewById(R.id.edittext);
        button = findViewById(R.id.button);
        textView = findViewById(R.id.textview);

        if (savedInstanceState != null)
            textView.setText(savedInstanceState.getString(KEY_TEXT_VALUE));

        button.setOnClickListener(v -> textView.setText(editText.getText()));
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString(KEY_TEXT_VALUE, editText.getText().toString());
    }
}