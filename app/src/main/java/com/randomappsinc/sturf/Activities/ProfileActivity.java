package com.randomappsinc.sturf.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.joanzapata.iconify.IconDrawable;
import com.joanzapata.iconify.fonts.IoniconsIcons;
import com.randomappsinc.sturf.Adapters.ItemsAdapter;
import com.randomappsinc.sturf.R;
import com.randomappsinc.sturf.Stubber;
import com.squareup.picasso.Picasso;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.OnItemClick;

/**
 * Created by alexanderchiou on 3/2/16.
 */
public class ProfileActivity extends StandardActivity {
    @Bind(R.id.profile_image) ImageView profilePic;
    @Bind(R.id.user_name) TextView userName;
    @Bind(R.id.school) TextView school;
    @Bind(R.id.post_item) FloatingActionButton postItem;
    @Bind(R.id.my_sturf) ListView mySturf;
    @Bind(R.id.no_sturf) View noSturf;

    private ItemsAdapter itemsAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.profile);
        ButterKnife.bind(this);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Picasso.with(this)
                .load("http://i.imgur.com/nYIEqa2.png")
                .into(profilePic);

        userName.setText("Alex Chiou");
        school.setText("UCLA");

        postItem.setImageDrawable(new IconDrawable(this, IoniconsIcons.ion_android_add).colorRes(R.color.white));

        itemsAdapter = new ItemsAdapter(this);
        mySturf.setAdapter(itemsAdapter);
        itemsAdapter.appendItems(Stubber.getItems());

        setNoContent();
    }

    private void setNoContent() {
        if (itemsAdapter.getCount() == 0) {
            noSturf.setVisibility(View.VISIBLE);
        } else {
            noSturf.setVisibility(View.GONE);
        }
    }

    @OnClick(R.id.post_item)
    public void postItem() {
        Intent postItemIntent = new Intent(this, ItemFormActivity.class);
        postItemIntent.putExtra(ItemFormActivity.FORM_MODE_KEY, ItemFormActivity.ADD);
        startActivity(postItemIntent);
    }

    @OnItemClick(R.id.my_sturf)
    public void updateItem(int position) {
        Intent updateItemIntent = new Intent(this, ItemFormActivity.class);
        updateItemIntent.putExtra(ItemFormActivity.FORM_MODE_KEY, ItemFormActivity.UPDATE);
        updateItemIntent.putExtra(ItemFormActivity.ITEM_KEY, itemsAdapter.getItem(position));
        startActivity(updateItemIntent);
    }
}
