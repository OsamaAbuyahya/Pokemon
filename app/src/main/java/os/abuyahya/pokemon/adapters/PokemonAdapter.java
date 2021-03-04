package os.abuyahya.pokemon.adapters;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

import os.abuyahya.pokemon.R;
import os.abuyahya.pokemon.model.Pokemon;

public class PokemonAdapter extends RecyclerView.Adapter<PokemonAdapter.PokemonViewHolder> {

    private ArrayList<Pokemon> list = new ArrayList<>();
    private Context context;


    public PokemonAdapter() {
    }

    public PokemonAdapter(Context context) {

        this.context = context;
    }

    public class PokemonViewHolder extends RecyclerView.ViewHolder {

        private ImageView pokemonImg;
        private TextView pokemonName;
        public PokemonViewHolder(@NonNull View itemView) {
            super(itemView);

            pokemonImg = itemView.findViewById(R.id.pokemon_imageView);
            pokemonName = itemView.findViewById(R.id.pokemon_name_textView);
        }
    }

    @NonNull
    @Override
    public PokemonViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.pokemon_item, parent, false);

        return new PokemonViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PokemonViewHolder holder, int position) {

        holder.pokemonName.setText(list.get(position).getName());

        Glide.with(context).load(list.get(position).getUrl())
                .into(holder.pokemonImg);
    }

    public void setList(ArrayList<Pokemon> list) {

        this.list = list;
        notifyDataSetChanged();
    }

    public Pokemon getPokemonAt(int position){

        return list.get(position);
    }

    @Override
    public int getItemCount() {

        return list.size();
    }

}
