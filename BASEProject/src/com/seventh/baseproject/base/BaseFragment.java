package com.seventh.baseproject.base;

import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * @author gr
 * @date 2015年10月7日
 * @version 1.0
 */
public abstract class BaseFragment extends Fragment {
	protected Context context;
	public View rootView;
	
	/**
	 * 屏幕宽度
	 */
	public static int scW;
	/**
	 * 屏幕高度
	 */
	public static int scH;
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		context = getActivity();
		//获取当前屏幕宽高
		DisplayMetrics metric = new DisplayMetrics();
		getActivity().getWindowManager().getDefaultDisplay().getMetrics(metric);
		scW = metric.widthPixels;
		scH = metric.heightPixels;
		
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		rootView = initView(inflater);
		return rootView;
	}

	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
		initData(savedInstanceState);
		setListener();
	}
	
	/**
	 * 初始化UI
	 * 
	 * @param inflater
	 * @return
	 */
	protected abstract View initView(LayoutInflater inflater);

	/**
	 * 
	 * 初始化数据
	 * 
	 * @param savedInstanceState
	 */
	protected abstract void initData(Bundle savedInstanceState);

	/**
	 * 设置监听
	 */
	protected abstract void setListener();
	
}
