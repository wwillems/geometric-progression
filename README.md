Sequencer

https://en.wikipedia.org/wiki/Geometric_progression

Problem definition

Given a list of integers, identify sequences where successive numbers exactly ​N​ indexes apart have a value equal to ​N​ multiplied by the previous number in the sequence.

Rules:
● N​ must be greater than 1
● Sequences with less than 3 entries should be ignored
● Sequences returned must always be the longest possible for a given value of ​N
    ○ In other words, there is max one resulting sequence for any value of ​N 
● Sequences of ​all​ zeros do not count

Example:

Consider the following list of integers:
2, 10, 4, 3, 8, 6, 9, 9, 18, 27

The following sequences are found:
● 2, 4, 8 (for ​N=2​)
● 3, 9, 27 (for ​N=3​)

Build project and run tests
mvn clean install

Run main
mvn exec:java -Dexec.mainClass="org.trajectumservices.sequencer.Main"