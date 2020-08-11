# Andrew Faust
# Codementor Code Snips

You are free to clone/copy the code in this repo for use in your schoolwork.  **ALL* works here-in are the property of [Andrew C. Faust](https://www.linkedin.com/in/andrew-faust-1026a367/).  The purpose of the repo is to illustrate basic Java 8+ functionality and also
to answer specific questions posted on [CourseHero](https://www.coursehero.com)

[BinaryTreeIntegers](./src/com/homework/BinaryTreeIntegerOnly.java) <br />
This is a **partial** BinarySearchTree implementation that will add and then an in-numeric-order display of the contents of the tree.
**Important** This is **integer** only, doesn't use generics, and and a partial implementation of add to toString only.

[BubbleSort](./src/com/homework/BubbleSort.java) <br />
This is a simple BubbleSort example.  It does **not** split the array up into partitions.  Simple bubble  

[Challange](./com/coursehero/challange/Challange.java) <br />
This is a figure-out how manys ways to make change for <i>x</i? dollars

[MorseCodeGuesser](./com/coursehero/challange/MorseCodeGusser) <br />
This program will take 1, 2, or 3 . or - characters and, if there is a ? (wildcard) character and figure-out how to find all correct answers.  Made use
of someString.match(regx), and use an x to represent a . in the signal.  Then just do ***map streaming*** and key.matches(regx) and find all matches
~~~java
private static List<String> lookupWords(int nbrSignals, String patternString) {
//		Map<Integer, String> collect = map.entrySet().stream()
//				.filter(x -> x.getKey() == 3)
//				.collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
		List<String> wordsFound = new ArrayList<>();
			signalMap
			.keySet()
			.stream()
			.filter(thisEntry -> {
				return (thisEntry.length() == nbrSignals && thisEntry.matches(patternString));
			})
			.forEach(thisKey -> wordsFound.add(thisKey));
		
		return wordsFound;
	}
~~~


[QueueFifiExample](./src/com/homework/QueueFifoSample.java) <br />
This program uses simple java Queue/LinkedList java objects to illustrate how to use a </b>FIFO</b> queue in java

[Schoom Management App](./src/com/homework/swing/SchoolManagementApp) <br />
This app features a **SWING** UI and makes heavy use of object higherarchies and class excendions.

