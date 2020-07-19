package com.homework;

public class TestHeadphone{


	static class Headphone {

		static final int LOW = 1;
		static final int MEDIUM = 2;
		static final int HIGH = 3;

		private int volume = MEDIUM;
		private boolean pluggedIn = false;
		private String manufacturer;
		private String headphoneColor;
		private String headphoneModel;
		private String color;
		
		/**
		 * Default no-args constructor
		 */
		public Headphone() {
			;
		}

		/**
		 * Convenience constructor for creating headphone object will all values
		 * @param volume
		 * @param pluggedIn
		 * @param manufacturer
		 * @param headphoneColor
		 * @param headphoneModel
		 * @param color
		 */
		public Headphone(int volume, boolean pluggedIn, String manufacturer, String headphoneColor,
				String headphoneModel, String color) {
			super();
			this.volume = volume;
			this.pluggedIn = pluggedIn;
			this.manufacturer = manufacturer;
			this.headphoneColor = headphoneColor;
			this.headphoneModel = headphoneModel;
			this.color = color;
		}

		public int getVolume() {
			return volume;
		}

		public void setVolume(int volume) {
			this.volume = volume;
		}

		public boolean isPluggedIn() {
			return pluggedIn;
		}

		public void setPluggedIn(boolean pluggedIn) {
			this.pluggedIn = pluggedIn;
		}

		public String getManufacturer() {
			return manufacturer;
		}

		public void setManufacturer(String manufacturer) {
			this.manufacturer = manufacturer;
		}

		public String getHeadphoneColor() {
			return headphoneColor;
		}

		public void setHeadphoneColor(String headphoneColor) {
			this.headphoneColor = headphoneColor;
		}

		public String getHeadphoneModel() {
			return headphoneModel;
		}

		public void setHeadphoneModel(String headphoneModel) {
			this.headphoneModel = headphoneModel;
		}

		public String getColor() {
			return color;
		}

		public void setColor(String color) {
			this.color = color;
		}

		@Override
		public String toString() {
			return "Headphone [volume=" + volume + ", pluggedIn=" + pluggedIn + ", manufacturer=" + manufacturer
					+ ", headphoneColor=" + headphoneColor + ", headphoneModel=" + headphoneModel + ", color=" + color
					+ "]";
		}
		
	}	// end of Headphone internal class


	public static void main(String[] args) {

		Headphone headphone1 = new Headphone();
		headphone1.setColor("Pink");
		headphone1.setPluggedIn(false);
		headphone1.setManufacturer("LG");
		headphone1.setVolume(Headphone.HIGH);

		/**Print 1st Headphone Details*/

		System.out.println("First pair of headphones: ");

		System.out.println(headphone1.toString());



  		Headphone headphone2 = new Headphone();
		 headphone2.setColor("Grey");
		 headphone2.setPluggedIn(false);
		 headphone2.setManufacturer("Samsung");
		 headphone2.setVolume(Headphone.LOW);

		/**Print 2nd Headphone Details*/

		System.out.println("Second pair of headphones: ");
		System.out.println(headphone2.toString());



		Headphone headphone3 = new Headphone();
		 headphone3.setColor("Green");
		 headphone3.setPluggedIn(false);
		 headphone3.setManufacturer("Sony");
		 headphone3.setVolume(Headphone.MEDIUM);

		/**Print 3rd Headphone Details*/

		System.out.println("Third pair of headphones: ");

		System.out.println(headphone3.toString());

	}



}