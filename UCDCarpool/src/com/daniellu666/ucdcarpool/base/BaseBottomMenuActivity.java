package com.daniellu666.ucdcarpool.base;



import java.util.List;

import com.daniellu666.ucdcarpool.R;
import com.daniellu666.ucdcarpool.R.layout;
import com.daniellu666.ucdcarpool.R.menu;
import com.daniellu666.ucdcarpool.bottombutton.BottomButton;
import com.daniellu666.ucdcarpool.bottombutton.BottomMenuLayout;
import com.daniellu666.ucdcarpool.util.GlobalUtils;

import android.os.Bundle;
import android.app.Activity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.Window;
import android.widget.LinearLayout.LayoutParams;

/**
 * Note    :  底部菜单，继承后实现onCreateBottomButton方法， 组装自己的按钮。
 *            按以下步骤来实现：
 *            1. 在子类中继承实现getButtonList方法，在方法中封装BottomButton对象返回，每一个BottomButton代表一个菜单项，具体属性见BottomButton定义。
 *            2. 在子类中继承实现getContentViewLayoutResId方法，返回layout xml的ID。
 *            3. 在子类中继承实现onCreatOverride方法，原先在onCreat方法中完成的事情挪到这里，super.onCreate(savedInstanceState);和setContentView就不需要调用了。
 * 			  
 */
public abstract class BaseBottomMenuActivity extends Activity 
{
	private LayoutInflater mInflater;   //实例化layout使用的类    
	protected BottomMenuLayout bottomMenuLayout;   //底部菜单UI部分
	protected View contentView;                    //页面中间UI部分
	
	final protected void onCreate(Bundle savedInstanceState) 
	{
		//设置标题不显示
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);
		super.onCreate(savedInstanceState);
		
		//实例化工具类
		if(GlobalUtils.getInstance() == null)
			new GlobalUtils(getWindowManager());
		
		//创建出完整的页面Layout，并设置为当前Activity的页面。
		bottomMenuLayout = new BottomMenuLayout(this);
		LayoutParams layoutParams = new LayoutParams(LayoutParams.FILL_PARENT,LayoutParams.WRAP_CONTENT);
		bottomMenuLayout.setOrientation(BottomMenuLayout.VERTICAL);
		bottomMenuLayout.setLayoutParams(layoutParams);
        setContentView(bottomMenuLayout);
        
        //将业务自定义的layout实例化出来，设置给完整页面Layout的内容部分。其中，获取业务自定义layoutID的时候回调了子类的方法。
        this.mInflater = LayoutInflater.from(this);
        contentView = mInflater.inflate(getContentViewLayoutResId(), null);
        bottomMenuLayout.addView(contentView);
        
        
        //回调子类,正常处理onCreate方法。
        onCreatOverride(savedInstanceState);
        
        
        //回调子类，获得所有的底部菜单按钮的集合，并进行处理，将按钮绑定到菜单里。
		bottomMenuLayout.setButtonList(getButtonList());
		bottomMenuLayout.processInitButton();
	}
	
	
	/**
	 * 为避免子类错误调用，覆盖该方法，并定义为空方法。
	 */
	public void setContentView(int layoutResID) { }

	/**
	 * 子类实现后，在原来的onCreate方法中内容移到这里来操作。
	 * @param savedInstanceState
	 */
	protected abstract void onCreatOverride(Bundle savedInstanceState);
	
	/**
	 * 返回layout xml的ID
	 * 原本在Activity的onCreate方法中调用的setContentView(R.layout.xxxxLayoutId); 现在从该方法返回。
	 * @return
	 */
	public abstract int getContentViewLayoutResId();
	

	/**
	 * 创建底部菜单，需要子类实现，在此方法中，
	 * 创建多个BottomButton对象并放置到List中返回即可。
	 * 如果需要哪一个按钮当前被选中，则设置BottomButton的isCurrent属性为ture.
	 * @param bottomButtons
	 * @param bottomMenuLayout
	 * @return
	 */
	public abstract List<BottomButton> getButtonList();
}
