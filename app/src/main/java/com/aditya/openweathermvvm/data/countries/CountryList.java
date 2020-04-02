package com.aditya.openweathermvvm.data.countries;

import android.content.Context;

import com.aditya.openweathermvvm.R;

public class CountryList {

    /**
     * Returns a list of all supported full country names
     *
     * @param context the Context reference to get the Resources from
     * @return String array containing the full country names
     */
    public static String[] getHumanReadable(Context context) {
        return context.getResources().getStringArray(R.array.countries_list_human);
    }

    /**
     * Returns a list of all supported ISO-3166-1 ALPHA-3 codes
     *
     * @param context the Context reference to get the Resources from
     * @return String array containing the ISO-3166-1 ALPHA-3 codes
     */
    public static String[] getMachineReadable(Context context) {
        return context.getResources().getStringArray(R.array.countries_list_machine);
    }

}