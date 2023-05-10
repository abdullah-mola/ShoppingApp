package abdullah.mola.shoppingapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.content.Intent;
import android.os.Bundle;


public class MainActivity extends AppCompatActivity implements RecyclerViewInterface{
    RecyclerView recyclerView;
    RecyclerView.Adapter adapter;
    RecyclerView.LayoutManager layoutManager;
    String [] name_list = {"Apples","Bananas","strawberries"};
    String [] description_list = {"Red and delicious.", "Extra yummy!", "Great for Summer."};
    int [] image_list = {R.drawable.apple,R.drawable.bananas,R.drawable.strawberry};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView= findViewById(R.id.rvShopping);
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        adapter = new ShoppingAdapter(this, name_list,description_list,image_list,this);
        recyclerView.setAdapter(adapter);
    }
    @Override
    public void onItemClick(int position) {
        Intent intent = new Intent(MainActivity.this,ShoppingDetails.class);
        intent.putExtra("Name",name_list[position]);
        intent.putExtra("Description",description_list[position]);
        intent.putExtra("Image",image_list[position]);
        startActivity(intent);
    }
}