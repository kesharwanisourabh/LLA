package com.example.android.lla;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.core.content.ContextCompat;

import java.security.PublicKey;
import java.util.ArrayList;


public class WordAdapter extends ArrayAdapter<word> {
    private int backgroundColor;

    public WordAdapter(Activity context, ArrayList<word> wordGroup,int background){
        super(context,0,wordGroup);
        backgroundColor=background;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Check if the existing view is being reused, otherwise inflate the view
        View listItemView = convertView;
        if(listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }

        // Get the {@link AndroidFlavor} object located at this position in the list
        word DefaultWord = getItem(position);

        // Find the TextView in the list_item.xml layout with the ID version_name
        TextView MiwokTextView = (TextView) listItemView.findViewById(R.id.miwok);
        // Get the version name from the current AndroidFlavor object and
        // set this text on the name TextView
        MiwokTextView.setText(DefaultWord.getMiwokTrans());

        // Find the TextView in the list_item.xml layout with the ID version_number
        TextView EnglishTextView = (TextView) listItemView.findViewById(R.id.english);
        // Get the version number from the current AndroidFlavor object and
        // set this text on the number TextView
        EnglishTextView.setText(DefaultWord.getDefaultTrans());

        ImageView imageView= (ImageView) listItemView.findViewById(R.id.Image);

        if(DefaultWord.hasImage()){
            imageView.setImageResource(DefaultWord.getmImageResId());
            imageView.setVisibility(View.VISIBLE);
        }
        else{
            imageView.setVisibility(View.GONE);
        }

        View textContainer = listItemView.findViewById(R.id.mainContainer);

        int color= ContextCompat.getColor(getContext(),backgroundColor);
        textContainer.setBackgroundColor(color);
        return listItemView;
    }
}
