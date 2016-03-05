package com.randomappsinc.sturf.Activities;

import android.os.Bundle;
import android.widget.Button;

import com.randomappsinc.sturf.R;

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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.item_form);
        ButterKnife.bind(this);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        String mode = getIntent().getStringExtra(FORM_MODE_KEY);
        if (mode.equals(ADD)) {
            itemAction.setText(R.string.post_item);
        }
        else if (mode.equals(UPDATE)){
            itemAction.setText(R.string.update_item);
        }
    }
}
