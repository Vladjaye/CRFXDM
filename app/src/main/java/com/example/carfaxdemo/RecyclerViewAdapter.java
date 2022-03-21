package com.example.carfaxdemo;

import static android.util.Log.INFO;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.carfaxdemo.jsondata.Model;
import com.squareup.picasso.Picasso;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {
    Model data;
    private List<Model.Listing> listingsList;
    private int carid = 0;
    public RecyclerViewAdapter() {
        listingsList = new ArrayList<>();
    }

    @Override
    public RecyclerViewAdapter.ViewHolder onCreateViewHolder(ViewGroup parent,
                                                             int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_item, parent, false);

        RecyclerViewAdapter.ViewHolder viewHolder = new RecyclerViewAdapter.ViewHolder(view);
        return viewHolder;
    }
    @Override
    public void onBindViewHolder(RecyclerViewAdapter.ViewHolder holder, int position) {
        Model.Listing car = listingsList.get(position);
        carid = position;
        String basicinfo = "" + car.getYear() + " " + car.getMake() + " " + car.getModel() + " " + car.getTrim();

        NumberFormat formatter = NumberFormat.getCurrencyInstance();
        String priceString = formatter.format(car.getCurrentPrice());

        String priceMileage = "" + priceString + " | " + car.getMileage() + " mi";
        String locationtxt = "" + car.getDealer().getCity() + ", " + car.getDealer().getState();
        holder.carBasics.setText(basicinfo);
        holder.priceMileage.setText(priceMileage);
        holder.locationText.setText(locationtxt);

        final View.OnClickListener callListener = v -> {
            makeCall(holder.button, car.getDealer().getPhone());
            notifyDataSetChanged();

        };
        holder.button.setOnClickListener(callListener);

        //Log.println(INFO, "DATAINRECYCLER", "IMAGE URL IS: " +car.getImages().getLarge().get(0));
        Picasso.get().load(car.getImages().getLarge().get(0)).resize(600,380).centerCrop().into(holder.imageView);

    }

    @Override
    public int getItemCount() {
        return listingsList.size();
    }

   public void setData(List<Model.Listing> data) {
        this.listingsList.addAll(data);
        notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView carBasics;
        public TextView priceMileage;
        public TextView locationText;
        public CardView cardView;
        public ImageView imageView;
        public Button button;

        public ViewHolder(View view) {
            super(view);

            carBasics = view.findViewById(R.id.carbasicsTextView);
            priceMileage = view.findViewById(R.id.priceMileageTextView);
            locationText = view.findViewById(R.id.locationTextview);
            cardView = view.findViewById(R.id.cardView);
            imageView = view.findViewById(R.id.carImageView);
            button = view.findViewById(R.id.button);

            cardView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    view.getContext().startActivity(new Intent(view.getContext(), DetailsActivity.class).putExtra("carid", view.getId()));

                }
            });
        }
    }
    public void makeCall(View view, String number) {
        Intent callIntent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + number));
        view.getContext().startActivity(callIntent);
    }
}
