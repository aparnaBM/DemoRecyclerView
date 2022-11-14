package com.example.demorecyclerview;

import android.content.Context;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.ViewHolder> {
    public static ArrayList<Product> productsList;
    private Context context;

    public CustomAdapter(Context context,ArrayList<Product> productsList) {
        this.context = context;
        this.productsList = productsList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        // Create a new view, which defines the UI of the list item
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.layout_rv, viewGroup, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, final int position) {
        Product product = productsList.get(position);
        viewHolder.idtxt.setText(String.valueOf(product.getId()));
        viewHolder.textView.setText(productsList.get(position).getName());

    }

    @Override
    public int getItemCount() {
        return productsList.size();
    }
    public static class ViewHolder extends RecyclerView.ViewHolder {
          TextView idtxt;
          EditText textView;
          TextView txtsave;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            idtxt = itemView.findViewById(R.id.idttxt);
            textView = itemView.findViewById(R.id.textView);
            txtsave = itemView.findViewById(R.id.txtsave);
            textView.addTextChangedListener(new TextWatcher() {
                @Override
                public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                }

                @Override
                public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                    productsList.get(getAdapterPosition()).setName(String.valueOf(charSequence));
                    txtsave.setText(charSequence);

                }

                @Override
                public void afterTextChanged(Editable editable) {
//                    productsList.get(getAdapterPosition()).setName(String.valueOf(editable));
//                    txtsave.setText(editable);

                }
            });
            

        }

    }

}
