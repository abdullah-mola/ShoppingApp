package abdullah.mola.shoppingapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ShoppingAdapter extends RecyclerView.Adapter<ShoppingAdapter.ViewHolder> {
    private final RecyclerViewInterface recyclerViewInterface;
    Context context;
    String [] name_list;
    String [] description_list;
    int [] image_list;
    public ShoppingAdapter(Context context, String[] name_list, String[] description_list, int[] image_list,RecyclerViewInterface recyclerViewInterface) {
        this.context = context;
        this.name_list = name_list;
        this.description_list = description_list;
        this.image_list = image_list;
        this.recyclerViewInterface =recyclerViewInterface;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{

    TextView rowName;
    TextView rowDescription;
    ImageView rowImage;
    public ViewHolder(@NonNull View itemView,RecyclerViewInterface recyclerViewInterface) {
        super(itemView);
        rowName= itemView.findViewById(R.id.textview1);
        rowDescription= itemView.findViewById(R.id.textview2);
        rowImage= itemView.findViewById(R.id.imageView);
        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (recyclerViewInterface!=null){
                    int pos = getAdapterPosition();
                    if (pos!= RecyclerView.NO_POSITION){
                        recyclerViewInterface.onItemClick(pos);
                    }

                }
            }
        });
    }
}

    @NonNull
    @Override
    public ShoppingAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater =LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.shopping_item, parent,false);
        ViewHolder viewHolder = new ViewHolder(view,recyclerViewInterface);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ShoppingAdapter.ViewHolder holder, int position) {

        holder.rowName.setText(name_list[position]);
        holder.rowDescription.setText(description_list[position]);
        holder.rowImage.setImageResource(image_list[position]);
    }

    @Override
    public int getItemCount() {
        return name_list.length;
    }
}
