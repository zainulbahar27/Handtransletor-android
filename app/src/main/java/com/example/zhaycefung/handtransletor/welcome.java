package com.example.zhaycefung.handtransletor;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by Zhaycefung on 1/2/2017.
 */

public class welcome extends AppCompatActivity {
    private final int SPLASH_DISPLAY_LENGHT = 4000;
    @Override
    public void onCreate(Bundle icicle) {
        super.onCreate(icicle);

  /* layout Loadingscreen */
        setContentView(R.layout.activiry_welcome);
  /* handler untuk menjalankan Loading selama 4 detik lalu
   * Kembali ke MainActivity
   */
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent mainIntent = null;
                mainIntent = new Intent(welcome.this,
                        DeviceListActivity.class);
                welcome.this.startActivity(mainIntent);
                welcome.this.finish();
            }
        }, SPLASH_DISPLAY_LENGHT);
    }
}
