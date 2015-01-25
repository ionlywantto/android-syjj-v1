package com.example.whjt;

import android.app.Activity;
import android.os.Bundle;
import android.os.StrictMode;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.alibaba.fastjson.JSONObject;
import com.example.whjt.tools.RequestTool;

public class CodeQuery extends Activity {
	private View.OnClickListener clickListener = new OnClickListener() {
		@Override
		public void onClick(View v) {
			switch (v.getId()) {
			case R.id.btn_code_query:
				queryByCode();
				break;
			default:
				break;
			}
		}
	};

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
	    StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder().detectDiskReads().detectDiskWrites().detectNetwork().penaltyLog().build());
	    StrictMode.setVmPolicy(new StrictMode.VmPolicy.Builder().detectLeakedSqlLiteObjects().detectLeakedClosableObjects().penaltyLog().penaltyDeath().build());
		
		setContentView(R.layout.activity_code_query);
		Button btn = (Button)findViewById(R.id.btn_code_query);
		btn.setOnClickListener(clickListener);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.code_query, menu);
		
//        StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder().detectDiskReads().detectDiskWrites().detectNetwork().penaltyLog().build());
//        StrictMode.setVmPolicy(new StrictMode.VmPolicy.Builder().detectLeakedSqlLiteObjects().detectLeakedClosableObjects().penaltyLog().penaltyDeath().build());
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
	
	public void queryByCode() {
		EditText text = (EditText)findViewById(R.id.text_code_query);
		String inpuCode =  text.getText().toString();
		if (inpuCode == null || inpuCode.equals("")) {
			Toast.makeText(this, R.string.code_query_warn, Toast.LENGTH_SHORT).show();
			return;
		}

		TextView code = (TextView) findViewById(R.id.fault_code_value);
		TextView score = (TextView) findViewById(R.id.fault_score_value);
		TextView amount = (TextView) findViewById(R.id.fault_amount_value);
		TextView name = (TextView) findViewById(R.id.fault_name_value);
		TextView basis = (TextView) findViewById(R.id.fault_basis_value);
		score.setText("");
		amount.setText("");
		name.setText("");
		basis.setText("");
		
		String json = "";
		try {
			json = RequestTool.request("http://www.syjg.gov.cn:8088/WMS1.0/query/code/" + inpuCode);
//			json = RequestTool.request("http://61.184.92.118:8088/WMS1.0/query/code/" + code);
//			json = RequestTool.request("http://192.168.1.108:8080/WMS1.0/query/code/" + code);
		} catch (Exception e) {
			e.printStackTrace();
			Toast.makeText(this, R.string.request_failed, Toast.LENGTH_SHORT).show();
			return;
		}
		if (json != null && !json.equals("")) {
			try {
				Fault fault = JSONObject.parseObject(json, Fault.class);
				code.setText(fault.getFaultId()+"");
				score.setText(fault.getScore()+"");
				amount.setText(fault.getAmount()+"");
				name.setText(fault.getName());
				basis.setText(fault.getBasis());
			} catch (Exception e) {
				e.printStackTrace();
				Toast.makeText(this, R.string.parsed_failed, Toast.LENGTH_SHORT).show();
				return;
			}
		} else {
			Toast.makeText(this, R.string.error_date_notfound, Toast.LENGTH_SHORT).show();
		}
	}
	
}
