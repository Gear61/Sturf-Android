package com.randomappsinc.sturf.Activities;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;

import com.joanzapata.iconify.fonts.FontAwesomeIcons;
import com.randomappsinc.sturf.R;
import com.randomappsinc.sturf.Utils.UIUtils;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by alexanderchiou on 3/2/16.
 */
public class ItemFormActivity extends StandardActivity {
    public static final String FORM_MODE_KEY = "formMode";
    public static final String ADD = "add";
    public static final String UPDATE = "update";

    @Bind(R.id.item_action) Button itemAction;

    private String mode;

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
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.item_form_menu, menu);
        if (mode.equals(UPDATE)) {
            UIUtils.loadMenuIcon(menu, R.id.delete_posting, FontAwesomeIcons.fa_plus);
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
