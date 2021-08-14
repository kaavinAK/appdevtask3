package com.example.afinal;


import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.List;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.ViewHolder> {

    private List<dog> localDataSet;

    /**
     * Provide a reference to the type of views that you are using
     * (custom ViewHolder).
     */
    public static class ViewHolder extends RecyclerView.ViewHolder {
        private final TextView name;
        private final TextView breed;
        private final TextView temperament;
        private final Context ctx;
          int id;
        private final ImageView imageview;

        public ViewHolder(View view) {
            super(view);
            // Define click listener for the ViewHolder's View
            ctx=view.getContext();
            name = (TextView) view.findViewById(R.id.name);
            breed = (TextView) view.findViewById(R.id.breed);
            temperament = (TextView) view.findViewById(R.id.temperament);
            imageview=(ImageView) view.findViewById(R.id.image);
            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(view.getContext(),fullpage.class);
                    intent.putExtra("id",id);
                    view.getContext().startActivity(intent);

                }
            });
        }


        public TextView getname()
        {
            return name;
        }
        public TextView getbreed()
        {
            return breed;
        }
        public TextView gettemperament()
        {
            return temperament;
        }
        public ImageView getImageview()
        {
            return imageview;
        }
        public Context getCtx()
        {
            return ctx;
        }
        public void setid(int ids){id=ids;}
    }

    /**
     * Initialize the dataset of the Adapter.
     *
     * @param dataSet String[] containing the data to populate views to be used
     * by RecyclerView.
     */
    public CustomAdapter(List<dog> dataSet) {
        localDataSet = dataSet;
    }

    // Create new views (invoked by the layout manager)
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        // Create a new view, which defines the UI of the list item

        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.customadapter, viewGroup, false);

        return new ViewHolder(view);
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(ViewHolder viewHolder, final int position) {

        // Get element from your dataset at this position and replace the
        // contents of the view with that element
      //  viewHolder.getTextView().setText(localDataSet[position]);
         viewHolder.setid(localDataSet.get(position).id);
        viewHolder.getname().setText("NAME: "+localDataSet.get(position).name);
        viewHolder.getbreed().setText("BREED: "+localDataSet.get(position).breed_group);
        viewHolder.gettemperament().setText("temperaments :"+localDataSet.get(position).temperament);
        String url= localDataSet.get(position).image.url;
      
        Picasso.with(viewHolder.getCtx()).load(url).into(viewHolder.getImageview());

    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return localDataSet.size();
    }
}

