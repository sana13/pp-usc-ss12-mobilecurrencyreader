package org.usc.android.hello;
import android.app.Activity;



import android.app.Activity;
import android.content.Context;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.widget.TextView;
import android.net.wifi.WifiManager;


public class SocketTest extends Activity {
	
	
	WifiManager wifi;	
	
	
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       // setContentView(R.layout.main);
       // TextView myView = (TextView)findViewById(R.id.textview);
       // myView.setText("Currency Reader");
        
//        Thread sThread = new Thread(new UDPServer());
//        Thread cThread = new Thread(new UDPClient());
//        Thread sThread = new Thread(new TCPServer());
        wifi = (WifiManager) getSystemService(Context.WIFI_SERVICE);	
        
        Thread cThread = new Thread(new TCPClient());
       
        /*sThread.start();
        try {
               Thread.sleep(1000);
          } catch (InterruptedException e) { }*/
       
         cThread.start();
        
    }
}
