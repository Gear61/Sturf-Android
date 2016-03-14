package com.randomappsinc.sturf;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.tokenautocomplete.TokenCompleteTextView;

/**
 * Created by alexanderchiou on 3/13/16.
 */
public class TagsCompletionView extends TokenCompleteTextView<String> {
    public TagsCompletionView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected View getViewForObject(String tag) {
        LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
        TextView tagCell = (TextView) inflater.inflate(R.layout.tag_token,
                (ViewGroup) TagsCompletionView.this.getParent(), false);
        tagCell.setText(tag);
        return tagCell;
    }

    @Override
    protected String defaultObject(String completionText) {
        return completionText;
    }
}
