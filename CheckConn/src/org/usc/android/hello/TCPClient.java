package org.usc.android.hello;


import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.Socket;

import android.util.Log;






public class TCPClient implements Runnable {

	     @Override 
	     public void run() { 
	          try { 
	               Log.d("UDP", "C: Connecting..."); 
	               DatagramSocket socket = new DatagramSocket(); 
	               byte[] buf = ("Hello from Client").getBytes(); 
	               InetAddress serverAddr = InetAddress.getByName("207.151.224.26");//204.140.144.22");207.151.230.13 
	               DatagramPacket packet = new DatagramPacket(buf, buf.length, serverAddr, 8080); 
	               Log.d("UDP", "C: Sending: '" + new String(buf) + "'"); 
	               socket.send(packet); 
	               Log.d("UDP", "C: Sent."); 
	               Log.d("UDP", "C: Done."); 
	          } catch (Exception e) { 
	               Log.e("UDP", "C: Error", e); 
	          } 
	     }  
	}





	/*
    public void run() {
         try {
        	 
        	 InetAddress serverAddr = InetAddress.getByName("localhost");//TCPServer.SERVERIP
        	 
        	 Log.d("TCP", "C: Connecting...");
        	 Socket socket = new Socket(serverAddr, TCPServer.SERVERPORT);
        	 String message = "Hello from Client";
		     try {
		    	 Log.d("TCP", "C: Sending: '" + message + "'");
		    	 PrintWriter out = new PrintWriter( new BufferedWriter( new OutputStreamWriter(socket.getOutputStream())),true);
		    	 
		    	 out.println(message);
		    	 Log.d("TCP", "C: Sent.");
	             Log.d("TCP", "C: Done.");
		    	 
             } catch(Exception e) {
                 Log.e("TCP", "S: Error", e);
		      } finally {
		        socket.close();
		      }
         } catch (Exception e) {
              Log.e("TCP", "C: Error", e);
         }
    }*/
