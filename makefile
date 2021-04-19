default: 
	javacc Jagger.jj
	javac Jagger.java
check: 
	java Jagger tests.txt