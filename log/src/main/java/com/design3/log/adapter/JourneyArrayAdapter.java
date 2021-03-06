package com.design3.log.adapter;

import java.util.ArrayList;
import java.util.Date;

import com.design3.log.R;
import com.design3.log.model.Journey;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class JourneyArrayAdapter extends ArrayAdapter<Journey> {

	private final Context context;
	private final ArrayList<Journey> values;
	
	public JourneyArrayAdapter(Context context, ArrayList<Journey>values) {
		super(context, R.layout.row_layout, values);
		this.context = context;
		this.values = values;
	}
	
	// By overriding this method, we can create a custom row view
	// This will be customised for Journey objects
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		LayoutInflater inflater = (LayoutInflater) context.
				getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		View rowView = inflater.inflate(R.layout.row_layout, parent, false);

		TextView textView1 = (TextView) rowView.findViewById(R.id.list_text1);
		textView1.setText(values.get(position).toString());
		TextView textView2 = (TextView) rowView.findViewById(R.id.list_text2);
		textView2.setText(String.valueOf(values.get(position).getRunTimeMinutes())
            + " minutes");

        ImageView imageView = (ImageView) rowView.findViewById(R.id.list_image);
        if(values.get(position).getUseType() == Journey.UseType.PERSONAL)
             imageView.setImageResource(R.drawable.image_personal);
        else imageView.setImageResource((R.drawable.image_business));

		return rowView;
	}

}
