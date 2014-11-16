package com.daniellu666.ucdcarpool;




import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;



import com.daniellu666.ucdcarpool.base.BaseBottomMenuActivity;
import com.daniellu666.ucdcarpool.bottombutton.BottomButton;

import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class CarpoolListActivity extends BaseBottomMenuActivity implements OnItemClickListener{

	ListView listView;
	String[] address= {"1","2","3","4","5","6","7"};
	String[] details={"aaa","bbb","ccc","ddd","eee","fff","ggg"};
    int[] images={R.drawable.machine101,R.drawable.datamining201,R.drawable.collective301,
			R.drawable.android401,R.drawable.performance501,R.drawable.ios601,R.drawable.datastructure701};
    
//	@Override
//	protected void onCreate(Bundle savedInstanceState) {
//		super.onCreate(savedInstanceState);
//		setContentView(R.layout.activity_carpool_list);
//		
////		Resources res=getResources(); 
////		myTitles=res.getStringArray(R.array.titles);
////		myModuleNames=res.getStringArray(R.array.modulenames);
//		
//		
//		listView=(ListView)findViewById(R.id.listview);
//		ModulesAdapter adapter=new ModulesAdapter(this, address, images, details);
//		listView.setAdapter(adapter);
//		listView.setOnItemClickListener(this);
//		
//	}



	@Override
	protected void onCreatOverride(Bundle savedInstanceState) {
//		super.onCreate(savedInstanceState);
//		setContentView(R.layout.activity_carpool_list);
		
//		Resources res=getResources(); 
//		myTitles=res.getStringArray(R.array.titles);
//		myModuleNames=res.getStringArray(R.array.modulenames);
		
		
		listView=(ListView)findViewById(R.id.listview);
		ModulesAdapter adapter=new ModulesAdapter(this, address, images, details);
		listView.setAdapter(adapter);
		listView.setOnItemClickListener(this);
		
	}

	

	@Override
	public List<BottomButton> getButtonList() {
		    
		    Map<String,String> buttonMaps =  new HashMap<String,String>();
			buttonMaps.put("Menu1", String.valueOf(R.drawable.home));
	    	buttonMaps.put("Menu2", String.valueOf(R.drawable.home));
	    	buttonMaps.put("Menu3", String.valueOf(R.drawable.home));
	    	buttonMaps.put("Menu4", String.valueOf(R.drawable.home));

	    	List<BottomButton> buttons = new ArrayList<BottomButton>();
	        Iterator<String> itKey = buttonMaps.keySet().iterator();
	        while(itKey.hasNext())
	        {
	        	String key = itKey.next();
	        	String valueRes = buttonMaps.get(key);
	        	BottomButton oneBottomButton = new BottomButton();
	        	oneBottomButton.setText(key);
	        	oneBottomButton.setBackgroundResource(Integer.parseInt(valueRes));
	        	buttons.add(oneBottomButton);
	        }
	        return buttons;
		}
	
	
	@Override
	public int getContentViewLayoutResId() {
		// TODO Auto-generated method stub
		return R.layout.activity_carpool_list;
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.carpool_list, menu);
		return true;
	}	
	
	
	@Override
	public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
		Intent intent= new Intent();
		Bundle myBund=new Bundle();
		myBund.putInt("row", arg2);
		intent.putExtras(myBund);
		intent.setClass(CarpoolListActivity.this, CarpoolItemActivity.class);
		startActivity(intent);		
		
	}
}






class ModulesAdapter extends ArrayAdapter<String> {
	Context context;
	
	int[] images; 
	String[] titleArray;
	String[] moduleNamesArray;
	
	public ModulesAdapter(Context c,String[] titles,int[] imgs,String[] names) {
		super(c,R.layout.single_row,R.id.rowtitle,titles);
		this.context=c;
		this.images=imgs;
		this.titleArray=titles;
		this.moduleNamesArray=names;
		
	}
	
	public View getView (int position,View convertView, ViewGroup parent){
		LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		
		View row=inflater.inflate(R.layout.single_row, parent,false);
		ImageView myImage=(ImageView)row.findViewById(R.id.imageView1);
		TextView myTitle=(TextView)  row.findViewById(R.id.rowtitle);
		TextView myModuleNames= (TextView)  row.findViewById(R.id.rowdescription);
		
		myImage.setImageResource(images[position]);
		myTitle.setText(titleArray[position]);
		myModuleNames.setText(moduleNamesArray[position]);
		
		return row;
	}
}