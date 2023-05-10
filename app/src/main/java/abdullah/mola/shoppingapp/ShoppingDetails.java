package abdullah.mola.shoppingapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class ShoppingDetails extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shopping_details);
        String name = getIntent().getStringExtra("Name");
        String description = getIntent().getStringExtra("Description");
        int image = getIntent().getIntExtra("Image",0);
        TextView nameTextView = findViewById(R.id.textview1);
        TextView descriptionTextView = findViewById(R.id.textview2);
        ImageView imageTextView = findViewById(R.id.imageView);
        nameTextView.setText(name);
        descriptionTextView.setText(description);
        imageTextView.setImageResource(image);
    }
}