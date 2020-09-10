# Andrew Faust
# Codementor Code Snips

You are free to clone/copy the code in this repo for use in your schoolwork.  **ALL* works here-in are the property of [Andrew C. Faust](https://www.linkedin.com/in/andrew-faust-1026a367/).  The purpose of the repo is to illustrate basic Java 8+ functionality and also
to answer specific questions posted on [CourseHero](https://www.coursehero.com)

[BinaryTreeIntegers](./src/com/homework/BinaryTreeIntegerOnly.java) <br />
This is a **partial** BinarySearchTree implementation that will add and then an in-numeric-order display of the contents of the tree.
**Important** This is **integer** only, doesn't use generics, and and a partial implementation of add to toString only.

[BubbleSort](./src/com/homework/BubbleSort.java) <br />
This is a simple BubbleSort example.  It does **not** split the array up into partitions.  Simple bubble  

[Challange](./src/com/coursehero/challange/Challange.java) <br />
This is a figure-out how manys ways to make change for <i>x</i? dollars

[DesignerCompariable](./src/com/homework/DesignerCompariable.java) <br />
This illustrates implementing a java ***Comparable*** interface

[MorseCodeGuesser](./src/com/coursehero/challange/MorseCodeGuesser.java) <br />
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

[Dice Class](./src/com/homework/games/Dice.java) <br />
This class will take any number of dice, with any number of sides, and execute a roll operation which returns a List of Integers.  ***IntStreams*** 
are used a good bit for looping 

[QueueFifoExample](./src/com/homework/QueueFifoSample.java) <br />
This program uses simple java Queue/LinkedList java objects to illustrate how to use a </b>FIFO</b> queue in java

[StreamingExamples](./src/com/acf/samples/StreamingExamples.java) <br />
This is a good quick way to see how to do various common operations on collection objects using streams.  This includes <br />
Math Function | Description
--- | --- |
min | Get the minimun value of a numeric object property |
max | Get the max value of a numeric object property |
sum | Get the sum of all the numeric values of a given object property |
avg | Get the average of all the numeric values of a given object property |
group by | Similar to an ~~~sql SQL Select distinct something, count~~~ this will group a list of items based on a value |
distinct | Get a get of the number of distinct values of something |
count | Can be used to just get a count of the number of elements in the stream

[StudentsFromCsvFile](./src/com/homework/StudentsFromCsvFile.java) <br />
Uses object extending and polymoric behaviour, along with java 8 file i/o features

## Socket Server / Client

[Socket Server](./src/com/acf/samples/SocketServerExample.java) <br />
[Socket Client](./src/com/acf/samples/SocketClientExample.java) <br />
These two are meant to work together.  The socket server run locally at 127.0.0.1 on port 8000.  The ~main~ method will start the server.  The
Socket client will connect to the socket server.  This is a simple game where the server generates a math problem, sends it to the client, and
the client sends back and answer.  This continues until the client returns the word ~stop~

[Thread Pools and Shipping](./src/com/homework/ThreadsAndShipping.java) <br />
This makes use of the `ExecutorService` and fixed thread pools.  Thre threads themselves are simple.

[Thread Pools and Runables](./src/com/homework/ThreadsAndRunnable.java) <br />
This makes use of the `ExecutorService`, fixed thread pools, cached (ie dynamic size) thread pools, and also use both Threads and Runnables


## Swing Examples

[HedgeYourBet](./src/com/homework/swing/HedgeYourBet.java) <br />
This is a simple app that asks a series of questions, captures the end-user's answer, and records scores.  ***Note*** Several individual Collection obects were used 
to keep track of stuff andm, in reality, an object, that implements a comparator, should have been used for the questions and it's associated answers.

[Simple JOptionPane Usage](./src/com/homework/swing/JOptionPaneSamples.java) <br />
Sample uses of a ***JOptionPane***

[School Management App](./src/com/homework/swing/SchoolManagerApp.java) <br />
This app features a **SWING** UI and makes heavy use of object higherarchies and class extensions.

