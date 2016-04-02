package com.randomappsinc.sturf.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.randomappsinc.sturf.Models.Item;
import com.randomappsinc.sturf.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by alexanderchiou on 4/1/16.
 */
public class ItemsAdapter extends BaseAdapter {
    private Context context;
    private List<Item> items;

    public ItemsAdapter(Context context) {
        this.context = context;
        this.items = new ArrayList<>();
    }

    public void prependItems(List<Item> items) {
        notifyDataSetChanged();
    }

    public void appendItems(List<Item> items) {
        this.items.addAll(items);
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return items.size();
    }

    @Override
    public Item getItem(int position) {
        return items.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    public class StoryViewHolder {
        @Bind(R.id.item_title) TextView title;
        @Bind(R.id.item_image) ImageView picture;

        public StoryViewHolder(View view) {
            ButterKnife.bind(this, view);
        }

        public void loadItem(int position) {
            Item item = getItem(position);
            title.setText(item.getTitle());
            Picasso.with(context)
                    .load(item.getImageUrl())
                    .into(picture);
        }
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {
        StoryViewHolder holder;
        if (view == null) {
            LayoutInflater vi = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = vi.inflate(R.layout.item_cell, parent, false);
            holder = new StoryViewHolder(view);
            view.setTag(holder);
        }
        else {
            holder = (StoryViewHolder) view.getTag();
        }

        holder.loadItem(position);

        return view;
    }
}
