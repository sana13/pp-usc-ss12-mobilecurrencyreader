package client.pkg;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.Socket;

import android.util.Log;

public class TCPClient implements Runnable {
	
	byte[] buf;
	byte[] recdata;
	public static String str;
 	
	TCPClient(byte[] data1){
		
		buf = new byte[data1.length];
		for(int i=0;i < data1.length ; i++)
		{
			buf[i] = data1[i];
		}
		
	}

	     @Override 
	     public void run() { 
	          try { 
	               Log.d("UDP", "C: Connecting..."); 
	               DatagramSocket socket = new DatagramSocket(); 
	              // byte[] buf = ("Hello from Client").getBytes(); 
	               InetAddress serverAddr = InetAddress.getByName("207.151.224.26");//204.140.144.22");207.151.230.13 
	          
	               
	               DatagramPacket packet = new DatagramPacket(buf, buf.length, serverAddr, 8080); 
	               Log.d("UDP", "C: Sending: '" + new String(buf) + "'"); 
	               socket.send(packet); 
	               Log.d("UDP", "C: Sent."); 
	               Log.d("UDP", "C: Done."); 
	              // socket.receive(packet);
	               Log.d("UDP", "Waiting to recieve from server.");
	               socket.receive(packet); 
	               //Log.d("UDP - recieved", new String(packet.getData()));
	                str = new String(packet.getData());
	               Log.d("UDP", "C: Received: '" + str + "'");
	               
	               
	          } 
	          catch(IOException ioe){
	        	  Log.e("UDP", "IOException", ioe);
	          }
	          catch (Exception e) { 
	               Log.e("UDP", "C: Error", e); 
	          }
	     }  
	}






