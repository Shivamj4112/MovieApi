package com.api.movieapi.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.api.movieapi.Api.ApiClient;
import com.api.movieapi.MainActivity;
import com.api.movieapi.ModelClass.Result;
import com.api.movieapi.R;
import com.bumptech.glide.Glide;

import java.util.List;

public class DataAdapter extends RecyclerView.Adapter<DataAdapter.viewholder> {

    MainActivity mainActivity;
    List<Result> results;

    public DataAdapter(MainActivity mainActivity, List<Result> results) {
        this.mainActivity = mainActivity;
        this.results = results;
    }

    @NonNull
    @Override
    public DataAdapter.viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(mainActivity).inflate(R.layout.layout,parent,false);
        return new viewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DataAdapter.viewholder holder, int position) {

        holder.date.setText(results.get(position).getFirstAirDate());
        holder.name.setText(results.get(position).getName());
        holder.popularity.setText(results.get(position).getPopularity().toString());
        holder.language.setText(results.get(position).getOriginalLanguage());
        holder.overview.setText(results.get(position).getOverview());


        Glide.with(mainActivity).load(ApiClient.IMAGE_URL +results.get(position).getPosterPath()).into(holder.poster);

    }

    @Override
    public int getItemCount() {
        return results.size();
    }

    public class viewholder extends RecyclerView.ViewHolder {

        TextView date,name,popularity,language,overview;
        ImageView background,poster;

        public viewholder(@NonNull View itemView) {
            super(itemView);

            date = itemView.findViewById(R.id.txt_first_date);
            name = itemView.findViewById(R.id.txt_movie_name);
            popularity = itemView.findViewById(R.id.txt_popularity);
            language = itemView.findViewById(R.id.txt_origin_language);
            overview = itemView.findViewById(R.id.txt_overview);
            background = itemView.findViewById(R.id.img_background);
            poster = itemView.findViewById(R.id.img_poster);
        }
    }
}
