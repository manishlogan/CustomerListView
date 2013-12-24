package com.logan.adapter;

import java.util.List;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.logan.entity.Words;
import com.logan.wordaday.R;

public class WordsAdapter extends BaseAdapter{
	
	private Activity activity;
    private List<Words> data;
    private static LayoutInflater inflater=null;
   
    public WordsAdapter(Activity activity, List<Words> data) {
		this.activity = activity;
		this.data = data;
        inflater = (LayoutInflater)activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
	}
    
	@Override
	public int getCount() {
		return data.size();
	}
	  
	@Override
	public Object getItem(int position) {
		return position;
	}
	  
	@Override
	public long getItemId(int position) {
		return position;
	}
	  
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		View view=convertView;
        if(convertView==null)
            view = inflater.inflate(R.layout.row_layout, null);
 
        TextView word = (TextView)view.findViewById(R.id.word);
        TextView meaning = (TextView)view.findViewById(R.id.meaning); 
 
        Words currentWord = data.get(position); 

        word.setText(currentWord.getWord());
        meaning.setText(currentWord.getMeaning());
        
        return view;
	}
}
