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
 * Illustrates a simple socket server running on locally
 * at 127.0.0.1 port 8000
 * @author Student's name
 *
 */
public class SocketServerExample {

	private Random rand = new Random();
	List<String> operators = new ArrayList<>();
	private ServerSocket serverSocket;
	private Socket clientSocket;
	private PrintWriter out;
	private BufferedReader in;

	public void start(int port) {
		try {
			Collections.addAll(operators, "+", "-", "*", "/");
			serverSocket = new ServerSocket(port);
			System.out.println("Server started on port: " + port);
			clientSocket = serverSocket.accept();
			out = new PrintWriter(clientSocket.getOutputStream(), true);
			in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
			listen();
			stop();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void listen() {
		try {
			
			out.println("Welcome to the Edruka Trivia Game");
			out.println("You can stop the game at any time by just entering the word stop\n ");

			// Now will continue to loop unitl they enter the word stop
			String questionTemplate = "Question from server: What is %d %s %d ?";
			int nbrOne;
			int nbrTwo;
			int nbrAnswer = 0;
			int answerReceived = 0;
			String oper;
			String response = "";
			String answerResponse = "";

			// Shuffle the operators
			Collections.shuffle(operators);
			
			while (true) {
				
				oper = operators.get(rand.nextInt(3)); // a number from 0 to 3
				nbrOne = rand.nextInt(10) + 1;
				nbrTwo = rand.nextInt(10) + 1;
				switch (oper) {
				case "+":
					nbrAnswer = nbrOne + nbrTwo;
					break;
				case "-":
					nbrAnswer = nbrOne - nbrTwo;
					break;
				case "*":
					nbrAnswer = nbrOne * nbrTwo;
					break;
				case "/":
					nbrAnswer = nbrOne / nbrTwo;
					break;
				}

				out.println(String.format(questionTemplate, nbrOne, oper, nbrTwo));
				out.println("\t");
		
				response = in.readLine();

				if (response == null) {
					break;
				}
				
				System.out.println("Server DEBUG: " + "The client sent over the value: " + response);
				if (response.equalsIgnoreCase("stop")) {
					break;
				}
				
				try {
					answerReceived = Integer.parseInt(response);
					answerResponse = "Oops!  " + answerReceived + " is not the correct answer.  The correct answer is: " + nbrAnswer + "\n\n";
					if (answerReceived == nbrAnswer) {
						answerResponse = "YES!  " + answerReceived + " is the correct answer\n\n";
					}
					
				} catch (NumberFormatException e) {
					answerResponse = "Oops!  " + answerReceived + " is not the correct answer.  The correct answer is: " + nbrAnswer + "\n\n";					
				}
				
				out.println(answerResponse);
				
			} // end of while statement

		} catch (IOException e) {
			e.printStackTrace();
		}	    	
	}

	public void stop() {
		try {
			in.close();
			out.close();
			clientSocket.close();
			serverSocket.close();
			System.out.println("Server has shut down.");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}


	public static void main(String[] args) {
		try {
			SocketServerExample sse = new SocketServerExample();
			sse.start(8000);
		} catch (Exception e) {
			System.out.println("Sorry.  The server would not start properly.  The error is: " + e.getClass().getName() + " - " + e.getMessage());
			System.exit(1);
		}




	}

}
