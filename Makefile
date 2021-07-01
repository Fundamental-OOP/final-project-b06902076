JFLAGS = -g -d out -cp out -sourcepath src
JC = javac
.SUFFIXES: .java .class
.java.class:
		$(JC) $(JFLAGS) $*.java

Main.class: src/Main.java
		$(JC) $(JFLAGS) src/Main.java

run: Main.class
		java -cp out Main

clean:
		$(RM) *.class
