package com.example.whjt;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.RelativeLayout;

public class MainActivity extends Activity {
	private View.OnClickListener clickListener = new OnClickListener() {
		@Override
		public void onClick(View v) {
			switch (v.getId()) {
			case R.id.module_lswffx:
				toLswffx();
				break;
			default:
				break;
			}
		}
	};

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		RelativeLayout relativeLayout = (RelativeLayout)findViewById(R.id.module_lswffx);
		relativeLayout.setOnClickListener(clickListener);
	}
	
	//跳转到违法代码查询
	public void toLswffx() {
		Intent intent = new Intent();
		intent.setClass(this, CodeQuery.class);
		this.startActivity(intent);
	}
	
}
