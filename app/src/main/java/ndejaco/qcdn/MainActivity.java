package ndejaco.qcdn;

import android.content.Context;
import android.content.Intent;
import android.net.wifi.WifiManager;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;



public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button qcdnButton = (Button) findViewById(R.id.button2);
        Button networkButton = (Button) findViewById(R.id.button);

        final WifiManager wifiManager = (WifiManager) getSystemService(Context.WIFI_SERVICE);

        qcdnButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!wifiManager.isWifiEnabled()) {
                    wifiManager.setWifiEnabled(true);
                    Toast.makeText(MainActivity.this, "Wifi is enabled for QCDN", Toast.LENGTH_SHORT).show();
                }

                Intent myIntent = new Intent(MainActivity.this, SingleVideoActivity.class);
                myIntent.putExtra("Network Type", "qcdn");
                startActivity(myIntent);
            }
        });


        networkButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (wifiManager.isWifiEnabled()) {
                    wifiManager.setWifiEnabled(false);
                    Toast.makeText(MainActivity.this, "Wifi is disabled to use cellular network", Toast.LENGTH_SHORT).show();
                }
                Intent myIntent = new Intent(MainActivity.this, SingleVideoActivity.class);
                myIntent.putExtra("Network Type", "cell network");
                startActivity(myIntent);
            }
        });

    }

    private void startSingleVideo() {

        Intent intent = new Intent(this, SingleVideoActivity.class);
        startActivity(intent);
    }


}
