package com.aditya.openweathermvvm.data.countries;

import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;

import androidx.preference.ListPreference;

import com.aditya.openweathermvvm.R;

public class CountryPreference extends ListPreference {

    public CountryPreference(Context context) {
        super(context);
        init();
    }

    public CountryPreference(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    protected void init() {
        // use the list of human-readable language names for the displayed list
        setEntries(R.array.countries_list_human);
        // use the list of machine-readable language names for the saved values
        setEntryValues(R.array.countries_list_machine);
        // use an empty language code (no custom language) as the default
        setDefaultValue("");
        // set the summary to be auto-updated to the selected value
        setSummary("%s");
    }

    @Override
    public void setValue(String value) {
        // if the API level is 19 or above
        if (Build.VERSION.SDK_INT >= 19) {
            // we can just call the default implementation
            super.setValue(value);
        }
        // if the API level is below 19
        else {
            // get the old value first
            String oldValue = getValue();
            // call the default implementation
            super.setValue(value);
            // if the new and old value differ
            if (!value.equals(oldValue)) {
                // notify the super class of the change
                notifyChanged();
            }
        }
    }

}