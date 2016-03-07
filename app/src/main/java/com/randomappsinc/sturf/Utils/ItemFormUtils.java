package com.randomappsinc.sturf.Utils;

import com.randomappsinc.sturf.R;

/**
 * Created by alexanderchiou on 3/6/16.
 */
public class ItemFormUtils {
    public static int getSubcategoryChoices(int currentCategory) {
        switch (currentCategory) {
            case 0:
            case 1:
                return R.array.lost_and_found_options;
            case 2:
                return R.array.school_supplies_options;
            case 3:
                return R.array.household_items_options;
            default:
                return R.array.lost_and_found_options;
        }
    }
}
