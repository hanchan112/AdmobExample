package com.framgia.lupx.admob.example;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

public class MainActivity extends AppCompatActivity {

    private AdView banner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        requestAds();
    }

    private void requestAds(){
        banner = (AdView)findViewById(R.id.banner);
        AdRequest adRequest = new AdRequest.Builder().build();
        banner.setAdListener(new AdListener() {
            @Override
            public void onAdClosed() {
                //Khi ad bị close bởi người dùng
            }

            @Override
            public void onAdFailedToLoad(int i) {
                //Khi load quảng cáo lỗi, bạn có thể load quảng cáo của mạng khác để thay thế tại đây
                switch (i){
                    case AdRequest.ERROR_CODE_INTERNAL_ERROR:

                        break;
                    case AdRequest.ERROR_CODE_INVALID_REQUEST:

                        break;
                    case AdRequest.ERROR_CODE_NETWORK_ERROR:

                        break;
                    case AdRequest.ERROR_CODE_NO_FILL:
                            //Khi không còn quảng cáo nào phù hợp
                        break;
                }
            }

            @Override
            public void onAdLeftApplication() {
                super.onAdLeftApplication();
            }

            @Override
            public void onAdOpened() {
                // Khi quảng cáo được mở
            }

            @Override
            public void onAdLoaded() {
                //Khi quảng cáo đã load xong
            }
        });
        banner.loadAd(adRequest);
    }
}
