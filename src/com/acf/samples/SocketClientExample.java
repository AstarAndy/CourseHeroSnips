package com.acf.samples;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/**
 * Illustrates a simple socket client.  The client
 * can communicate with the server via a passed in IP address and port number
 * or they will default to 127.0.0.0 and 8000
 * @author Student's Name
 *
 */
public class SocketClientExample {

	private Socket clientSocket;
	private PrintWriter out;
	private BufferedReader in;
	public Scanner sc = new Scanner(System.in);

	public void startConnection(String ip, int port) {
		try {
			clientSocket = new Socket(ip, port);
			out = new PrintWriter(clientSocket.getOutputStream(), true);
			in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
			String response = "";
			String answer = "stop";
			boolean gameOn = true;
			while (gameOn) {
				while ( (response = in.readLine()) != null) {
					if (response.equals("\t")) {
						break;
					}
					System.out.println(response);
				}
				answer = sc.nextLine();
				out.println(answer); 
				gameOn = (!answer.equalsIgnoreCase("stop"));
			}
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		try {
			SocketClientExample sce = new SocketClientExample();
			sce.startConnection("127.0.0.1",  8000);
			
		} catch (Exception e) {
			System.out.println("Sorry.  Unable to establish a connection with the serve.  The error is: " + e.getClass().getName() + " - " + e.getMessage());
			System.exit(1);
		}




	}

}
