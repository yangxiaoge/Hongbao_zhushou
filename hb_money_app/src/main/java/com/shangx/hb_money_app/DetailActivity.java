package com.shangx.hb_money_app;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.TextView;

import com.baidu.mobads.InterstitialAd;
import com.baidu.mobads.InterstitialAdListener;

public class DetailActivity extends Activity{

	InterstitialAd interAd;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.detail);
		ad();
		TextView tx_view = (TextView) this.findViewById(R.id.imageview_above_menu_teacher);
		tx_view.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				finish();
			}
		});

		chabo();
	}

	public void chabo(){

		if(interAd.isAdReady()){
			interAd.showAd(DetailActivity.this);
		}else{
			interAd.loadAd();
		}
	}

	private void ad(){
		String adPlaceId = "2373336"; // 重要：不填写代码位id不能出广告
		interAd=new InterstitialAd(this, adPlaceId);
		interAd.setListener(new InterstitialAdListener(){

			@Override
			public void onAdClick(InterstitialAd arg0) {
				Log.i("InterstitialAd","onAdClick");
			}

			@Override
			public void onAdDismissed() {
				Log.i("InterstitialAd","onAdDismissed");
				interAd.loadAd();
			}

			@Override
			public void onAdFailed(String arg0) {
				Log.i("InterstitialAd","onAdFailed");
			}

			@Override
			public void onAdPresent() {
				Log.i("InterstitialAd","onAdPresent");
			}

			@Override
			public void onAdReady() {
				Log.i("InterstitialAd","onAdReady");
			}

		});
		interAd.loadAd();
	}
}
