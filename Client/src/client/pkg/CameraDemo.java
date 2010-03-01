package client.pkg;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import client.pkg.TCPClient;

import android.app.Activity;
import android.hardware.Camera;
import android.hardware.Camera.PictureCallback;
import android.hardware.Camera.ShutterCallback;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.FrameLayout;

public class CameraDemo extends Activity {
	private static final String TAG = "CameraDemo";
	Camera camera;
	Preview preview;
	Button buttonClick;
	MediaPlayer mp = null;
	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		preview = new Preview(this);
		((FrameLayout) findViewById(R.id.preview)).addView(preview);

		buttonClick = (Button) findViewById(R.id.buttonClick);
		buttonClick.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				preview.camera.takePicture(shutterCallback, rawCallback,
						jpegCallback);
			}
		});

		Log.d(TAG, "onCreate'd");
	}

	
	ShutterCallback shutterCallback = new ShutterCallback() {
		public void onShutter() {
			Log.d(TAG, "onShutter'd");
		}
	};

	/** Handles data for raw picture */
	PictureCallback rawCallback = new PictureCallback() {
		public void onPictureTaken(byte[] data, Camera camera) {
			Log.d(TAG, "onPictureTaken - raw");
		}
	};

	/** Handles data for jpeg picture */
	PictureCallback jpegCallback = new PictureCallback() {
		public void onPictureTaken(byte[] data, Camera camera) {
			FileOutputStream outStream = null;
			try {
				// write to local sandbox file system
				// outStream =
				// CameraDemo.this.openFileOutput(String.format("%d.jpg",
				// System.currentTimeMillis()), 0);
				// Or write to sdcard
				
				Thread cThread = new Thread(new TCPClient(data));
				
				cThread.start();	
				if(TCPClient.str.equals("1"))
				denominationPlayed(1);
				
				else if(TCPClient.str.equals("2"))
					denominationPlayed(2);
					
				else if(TCPClient.str.equals("5"))
					denominationPlayed(5);
					
				else if(TCPClient.str.equals("10"))
					denominationPlayed(10);
					
				else if(TCPClient.str.equals("20"))
					denominationPlayed(20);
					
				else if(TCPClient.str.equals("50"))
					denominationPlayed(50);
					
				else
				denominationPlayed(100);
					
				
				/*
				outStream = new FileOutputStream(String.format(
						"/sdcard/%d.jpg", System.currentTimeMillis()));
				outStream.write(data);
				outStream.close();*/ //writes into jpg file
				
				Log.d(TAG, "onPictureTaken - wrote bytes: " + data.length);
			}  finally {
			}
			Log.d(TAG, "onPictureTaken - jpeg");
		}
	};

	

	 public void denominationPlayed(int deno){
	    
		 Log.d(TAG,"in the file playing code");
	    	switch(deno){
				case 1:
					mp = MediaPlayer.create(CameraDemo.this, R.raw.dollar1);  
					break;
				case 5:
					mp = MediaPlayer.create(CameraDemo.this, R.raw.dollar5);  
					break;
				case 10:
					mp = MediaPlayer.create(CameraDemo.this, R.raw.dollar10);  
					break;
				case 20:
					mp = MediaPlayer.create(CameraDemo.this, R.raw.dollar20);  
					break;
				case 50:
					mp = MediaPlayer.create(CameraDemo.this, R.raw.dollar50);  
					break;
				case 100:
					mp = MediaPlayer.create(CameraDemo.this, R.raw.dollar100);  
					break;
				default:
					break;
		
			}
			
			try {
				
				if(mp != null){
					mp.start();
		
					
				}
			} catch (IllegalArgumentException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalStateException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
		
		    } 
	    }
	    

}