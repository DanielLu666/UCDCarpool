package com.daniellu666.ucdcarpool.util;

import android.view.Display;
import android.view.WindowManager;

public class GlobalUtils 
{
	private static GlobalUtils instance;
	
	private int screenHeight;
	private int screenWidth;
	
	public GlobalUtils(WindowManager windowManager)
	{
		instance = this;
		Display display = windowManager.getDefaultDisplay();
		this.screenHeight = display.getHeight(); //��Ļ�߶�
		this.screenWidth = display.getWidth();  //��Ļ���
	}
	public static GlobalUtils getInstance()
	{
		return instance;
	}
	
	
	/**
	 * �����Ļ�ĸ߶ȡ�
	 * @return
	 */
	public int getScreenHeight() {
		return screenHeight;
	}
	
	/**
	 * �����Ļ�Ŀ�ȡ�
	 * @return
	 */
	public int getScreenWidth() {
		return screenWidth;
	}
	
}
