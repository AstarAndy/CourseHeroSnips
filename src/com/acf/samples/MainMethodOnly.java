package com.acf.samples;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class MainMethodOnly {

	public static void main(String[] args) {
		
		String tweet = "#typ smoke; #det its raining ash; #loc windsor, co; #lat 40.499812; #lng -105.012075;";
		
		String type;
		String detail;
		String location;
		String latitude;
		String longitude;
		
		// Extract type
		int start = 5;
		int finish = tweet.indexOf(";");
		type = tweet.substring(start, finish);
		System.out.println("Type is: " + type);
		
		// Extract detail
		// First get rid of the type value as we don't need it any more
		tweet = tweet.substring(finish + 7);

		// Now extract the detail data
		finish = tweet.indexOf(";");
		detail = tweet.substring(0, finish);
		System.out.println("detail is: " + detail);
		
		// Now discard the detail portion of the tweet
		tweet = tweet.substring(finish + 7);

		// Now extract the location value
		finish = tweet.indexOf(";");
		location = tweet.substring(0, finish);
		System.out.println("location is: " + location);
		
		// Now discard the location portion of the tweet
		tweet = tweet.substring(finish + 7);

		// Now extract the latitude value
		finish = tweet.indexOf(";");
		latitude = tweet.substring(0, finish);
		System.out.println("latitude is: " + latitude);
		
		// Now discard the latitude portion of the tweet
		tweet = tweet.substring(finish + 7);

		// the only thing left is the longitude
		finish = tweet.indexOf(";");
		longitude = tweet.substring(0, finish);
		System.out.println("longitude is: " + longitude);
		
		
	} // end of main method

}
