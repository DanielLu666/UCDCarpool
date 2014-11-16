package com.daniellu666.ucdcarpool.bottombutton;

import android.view.View;

public class BottomButton 
{
	/**
	 * ButtonMenu text
	 */
	private String text;
	
	/**
	 * ButtonMenu image
	 */
	private int backgroundResource;
	
	/**
	 * OnclickListener
	 */
	private View.OnClickListener clickListener;
	
	/**
	 * if isCurret is true, highlight the button and ignore the click
	 */
	private boolean isCurrent = false;

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}


	public int getBackgroundResource() {
		return backgroundResource;
	}

	public void setBackgroundResource(int backgroundResource) {
		this.backgroundResource = backgroundResource;
	}

	public View.OnClickListener getClickListener() {
		return clickListener;
	}

	public void setClickListener(View.OnClickListener clickListener) {
		this.clickListener = clickListener;
	}

	public boolean isCurrent() {
		return isCurrent;
	}

	public void setCurrent(boolean isCurrent) {
		this.isCurrent = isCurrent;
	}
	
}
