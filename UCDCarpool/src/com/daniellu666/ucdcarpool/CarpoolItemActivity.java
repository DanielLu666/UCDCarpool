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
import android.view.Menu;

public class CarpoolItemActivity extends BaseBottomMenuActivity {

	@Override
	protected void onCreatOverride(Bundle savedInstanceState)  {
		
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
		return R.layout.activity_carpool_item;
	}
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.carpool_item, menu);
		return true;
	}

}
