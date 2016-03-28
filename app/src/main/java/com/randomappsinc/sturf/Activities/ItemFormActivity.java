package com.randomappsinc.sturf.Activities;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.provider.Settings;
import android.support.annotation.NonNull;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;

import com.afollestad.materialdialogs.DialogAction;
import com.afollestad.materialdialogs.MaterialDialog;
import com.joanzapata.iconify.fonts.IoniconsIcons;
import com.randomappsinc.sturf.Constants;
import com.randomappsinc.sturf.Item;
import com.randomappsinc.sturf.R;
import com.randomappsinc.sturf.TagsCompletionView;
import com.randomappsinc.sturf.Utils.ItemFormUtils;
import com.randomappsinc.sturf.Utils.LocationUtils;
import com.randomappsinc.sturf.Utils.PermissionUtils;
import com.randomappsinc.sturf.Utils.UIUtils;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by alexanderchiou on 3/2/16.
 */
public class ItemFormActivity extends StandardActivity {
    public static final int LOCATION_ACCESS_CODE = 1;
    public static final String FORM_MODE_KEY = "formMode";
    public static final String ITEM_KEY = "item";
    public static final String ADD = "add";
    public static final String UPDATE = "update";

    @Bind(R.id.parent) View parent;
    @Bind(R.id.category) EditText category;
    @Bind(R.id.subcategory) EditText subcategory;
    @Bind(R.id.item_title) EditText title;
    @Bind(R.id.location) EditText location;
    @Bind(R.id.item_action) Button itemAction;
    @Bind(R.id.tags) TagsCompletionView tags;

    private String mode;
    private int currentCategoryIndex = -1;
    private int currentSubcategoryIndex = -1;
    private Item item;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.item_form);
        ButterKnife.bind(this);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        mode = getIntent().getStringExtra(FORM_MODE_KEY);
        if (mode.equals(ADD)) {
            itemAction.setText(R.string.post_item);
        }
        else if (mode.equals(UPDATE)){
            itemAction.setText(R.string.update_item);
            item = getIntent().getParcelableExtra(ITEM_KEY);
            loadItem();
        }

        tags.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, Constants.tags));
        tags.allowDuplicates(false);
    }

    private void loadItem() {
        category.setText(item.getCategory());
        subcategory.setText(item.getSubcategory());
        title.setText(item.getTitle());
        location.setText(item.getLocation());
    }

    @OnClick(R.id.category)
    public void chooseCategory() {
        new MaterialDialog.Builder(this)
                .title(R.string.category)
                .items(R.array.category_options)
                .itemsCallbackSingleChoice(currentCategoryIndex, new MaterialDialog.ListCallbackSingleChoice() {
                    @Override
                    public boolean onSelection(MaterialDialog dialog, View view, int which, CharSequence text) {
                        currentCategoryIndex = which;
                        category.setText(text);
                        currentSubcategoryIndex = -1;
                        subcategory.setText("");
                        return true;
                    }
                })
                .positiveText(R.string.choose)
                .negativeText(android.R.string.no)
                .show();
    }

    @OnClick(R.id.subcategory)
    public void chooseSubCategory() {
        if (!category.getText().toString().isEmpty()) {
            new MaterialDialog.Builder(this)
                    .title(R.string.sub_category)
                    .items(ItemFormUtils.getSubcategoryChoices(currentCategoryIndex))
                    .itemsCallbackSingleChoice(currentSubcategoryIndex, new MaterialDialog.ListCallbackSingleChoice() {
                        @Override
                        public boolean onSelection(MaterialDialog dialog, View view, int which, CharSequence text) {
                            currentSubcategoryIndex = which;
                            subcategory.setText(text);
                            return true;
                        }
                    })
                    .positiveText(R.string.choose)
                    .negativeText(android.R.string.no)
                    .show();
        }
    }

    @OnClick(R.id.location_icon)
    public void autoFillAddress() {
        if (!PermissionUtils.isPermissionGranted(Manifest.permission.ACCESS_FINE_LOCATION)) {
            PermissionUtils.requestPermission(this, Manifest.permission.ACCESS_FINE_LOCATION, LOCATION_ACCESS_CODE);
        } else if (!LocationUtils.areLocationServicesOn()) {
            askToEnableLocation();
        } else {
            String currentAddress = LocationUtils.getCurrentAddress();
            if (currentAddress.isEmpty()) {
                UIUtils.showSnackbar(parent, getString(R.string.location_fail));
            } else {
                location.setText(currentAddress);
                location.setSelection(currentAddress.length());
            }
        }
    }

    private void askToEnableLocation() {
        final Context context = this;
        new MaterialDialog.Builder(this)
                .title(R.string.enable_location_services)
                .content(R.string.location_services_explanation)
                .positiveText(android.R.string.yes)
                .negativeText(android.R.string.no)
                .onPositive(new MaterialDialog.SingleButtonCallback() {
                    @Override
                    public void onClick(@NonNull MaterialDialog dialog, @NonNull DialogAction which) {
                        context.startActivity(new Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS));
                    }
                })
                .show();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.item_form_menu, menu);
        if (mode.equals(UPDATE)) {
            UIUtils.loadMenuIcon(menu, R.id.delete_posting, IoniconsIcons.ion_android_delete);
        }
        else {
            menu.findItem(R.id.delete_posting).setVisible(false);
        }
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.delete_posting:
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
