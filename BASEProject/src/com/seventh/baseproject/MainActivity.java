package com.seventh.baseproject;

import com.seventh.baseproject.base.BaseActivity;
import com.seventh.baseproject.util.NetworkUtil;
import com.seventh.baseproject.util.TimeUtil;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import hirondelle.date4j.DateTime;

public class MainActivity extends BaseActivity {
	private TextView tv_test;
	private Button btn_refresh;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
	}

	@Override
	protected void initView() {
		setContentView(R.layout.activity_main);
		tv_test = (TextView) findViewById(R.id.tv_test);
		btn_refresh = (Button) findViewById(R.id.btn_refresh);
	}

	@Override
	protected void initData() {
		//boolean b = NetworkUtil.is3G(context);
		//setText();
		DateTime dt = TimeUtil.getNowDateTime();
		tv_test.setText(dt+";\n"+TimeUtil.getNowDateTime().format(TimeUtil.DATEFORMAT_1_1)+";\n"+TimeUtil.getNowDateTime().format(TimeUtil.DATEFROMAT_1_2)+";\n"+TimeUtil.getNowDateTime().format(TimeUtil.DATEFROMAT_1_3)+";\n");
	}

	@Override
	protected void setListener() {
		btn_refresh.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				setText();
			}
		});
	}
	
	private void setText(){
		if(NetworkUtil.isNetworkAvailable(context)){
			tv_test.setText(NetworkUtil.getNetworkClass(context)+"");
		}else{
			tv_test.setText("不可用");
		}
		
	}
}
