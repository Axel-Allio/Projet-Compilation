default: 
	javacc Jagger.jj
	javac Jagger.java
all: Jagger
	java Jagger
Jagger: Jagger.java
	javac Jagger.java
Jagger.java: Jagger.jj
	javacc Jagger.jj