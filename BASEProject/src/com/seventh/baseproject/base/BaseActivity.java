package com.seventh.baseproject.base;

import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.util.DisplayMetrics;
/**
 * 
 * @author gr
 * @date 2015年10月7日
 * @version 1.0
 * 
 */
public abstract class BaseActivity extends FragmentActivity {
	/**
	 * 上下文
	 */
	public static Context context;
	/**
	 * 资源
	 */
	public static Resources res;
	/**
	 * 屏幕
	 */
	public static DisplayMetrics dm;
	/**
	 * 屏幕宽度
	 */
	public static int scW;
	/**
	 * 屏幕高度
	 */
	public static int scH;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		context = getApplicationContext();
		res = getResources();
		// 获取分辨率宽度，高度
		dm = new DisplayMetrics();
		getWindowManager().getDefaultDisplay().getMetrics(dm);
		scW = dm.widthPixels;
		scH = dm.heightPixels;
		
		initView();
		initData();
		setListener();
	}

	@Override
	protected void onResume() {
		super.onResume();
	}

	@Override
	protected void onPause() {
		super.onPause();
	}
	
	/**
	 * 初始化UI
	 */
	protected abstract void initView();

	/**
	 * 初始化数据
	 */
	protected abstract void initData();

	/**
	 * 设置监听
	 */
	protected abstract void setListener();
	
}
