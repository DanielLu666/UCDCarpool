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
 * Note    :  �ײ��˵����̳к�ʵ��onCreateBottomButton������ ��װ�Լ��İ�ť��
 *            �����²�����ʵ�֣�
 *            1. �������м̳�ʵ��getButtonList�������ڷ����з�װBottomButton���󷵻أ�ÿһ��BottomButton����һ���˵���������Լ�BottomButton���塣
 *            2. �������м̳�ʵ��getContentViewLayoutResId����������layout xml��ID��
 *            3. �������м̳�ʵ��onCreatOverride������ԭ����onCreat��������ɵ�����Ų�����super.onCreate(savedInstanceState);��setContentView�Ͳ���Ҫ�����ˡ�
 * 			  
 */
public abstract class BaseBottomMenuActivity extends Activity 
{
	private LayoutInflater mInflater;   //ʵ����layoutʹ�õ���    
	protected BottomMenuLayout bottomMenuLayout;   //�ײ��˵�UI����
	protected View contentView;                    //ҳ���м�UI����
	
	final protected void onCreate(Bundle savedInstanceState) 
	{
		//���ñ��ⲻ��ʾ
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);
		super.onCreate(savedInstanceState);
		
		//ʵ����������
		if(GlobalUtils.getInstance() == null)
			new GlobalUtils(getWindowManager());
		
		//������������ҳ��Layout��������Ϊ��ǰActivity��ҳ�档
		bottomMenuLayout = new BottomMenuLayout(this);
		LayoutParams layoutParams = new LayoutParams(LayoutParams.FILL_PARENT,LayoutParams.WRAP_CONTENT);
		bottomMenuLayout.setOrientation(BottomMenuLayout.VERTICAL);
		bottomMenuLayout.setLayoutParams(layoutParams);
        setContentView(bottomMenuLayout);
        
        //��ҵ���Զ����layoutʵ�������������ø�����ҳ��Layout�����ݲ��֡����У���ȡҵ���Զ���layoutID��ʱ��ص�������ķ�����
        this.mInflater = LayoutInflater.from(this);
        contentView = mInflater.inflate(getContentViewLayoutResId(), null);
        bottomMenuLayout.addView(contentView);
        
        
        //�ص�����,��������onCreate������
        onCreatOverride(savedInstanceState);
        
        
        //�ص����࣬������еĵײ��˵���ť�ļ��ϣ������д�������ť�󶨵��˵��
		bottomMenuLayout.setButtonList(getButtonList());
		bottomMenuLayout.processInitButton();
	}
	
	
	/**
	 * Ϊ�������������ã����Ǹ÷�����������Ϊ�շ�����
	 */
	public void setContentView(int layoutResID) { }

	/**
	 * ����ʵ�ֺ���ԭ����onCreate�����������Ƶ�������������
	 * @param savedInstanceState
	 */
	protected abstract void onCreatOverride(Bundle savedInstanceState);
	
	/**
	 * ����layout xml��ID
	 * ԭ����Activity��onCreate�����е��õ�setContentView(R.layout.xxxxLayoutId); ���ڴӸ÷������ء�
	 * @return
	 */
	public abstract int getContentViewLayoutResId();
	

	/**
	 * �����ײ��˵�����Ҫ����ʵ�֣��ڴ˷����У�
	 * �������BottomButton���󲢷��õ�List�з��ؼ��ɡ�
	 * �����Ҫ��һ����ť��ǰ��ѡ�У�������BottomButton��isCurrent����Ϊture.
	 * @param bottomButtons
	 * @param bottomMenuLayout
	 * @return
	 */
	public abstract List<BottomButton> getButtonList();
}
