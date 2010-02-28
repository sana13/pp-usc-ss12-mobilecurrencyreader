package currency.reader;


import java.io.IOException;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;
import android.media.*;

public class MobileCurrencyReader extends Activity {
    /** Called when the activity is first created. */
    
	MediaPlayer mp = null;
    public void onCreate(Bundle savedInstanceState) {
    	super.onCreate(savedInstanceState);   
    	
    	//denominationPlayed(100);
    	
    	
    	

    }
    
    /**
     * A method that calls the corresponding denomination audio file
     * @param deno - denomination
     */
    public void denominationPlayed(int deno){
    	
    	switch(deno){
			case 1:
				mp = MediaPlayer.create(MobileCurrencyReader.this, R.raw.dollar1);  
				break;
			case 5:
				mp = MediaPlayer.create(MobileCurrencyReader.this, R.raw.dollar5);  
				break;
			case 10:
				mp = MediaPlayer.create(MobileCurrencyReader.this, R.raw.dollar10);  
				break;
			case 20:
				mp = MediaPlayer.create(MobileCurrencyReader.this, R.raw.dollar20);  
				break;
			case 50:
				mp = MediaPlayer.create(MobileCurrencyReader.this, R.raw.dollar50);  
				break;
			case 100:
				mp = MediaPlayer.create(MobileCurrencyReader.this, R.raw.dollar100);  
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
