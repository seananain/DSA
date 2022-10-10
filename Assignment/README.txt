README

Student ID: 20324861
Name: Sean Anain
Date Created: 10/10/2022

IMPORTANT: Do not modify any files except for "inputString.txt"

TO RUN KEYMEUP:
    Compile neccessary files:
        javac DSAGraph.java
        javac DSALinkedList.java
        javac DSAQueue.java
        javac DSAStack.java 
        javac keyMeUp.java
    Run program using either:
        Interactive Mode: java keyMeUp -i 
            1. Load keyboard file first. Choose any from below
            2. Enter a string for finding path
            3. Generate paths
            4. Display paths. Will be printed to terminal, option to save to "results.txt" 
        *Silent Mode: java keyMeUp -s keyboardFile  stringFile  pathFile
            - Nothing will be shown in terminal
            - Open "results.txt" to see results (or whatever file you used)


*It is recomended that stringFile used is "inputString.txt" and the pathFile used is "results.txt"



FILES:
    Main:
        keyMeUp.java
        20324861-Assignment-Report-SeanAnain.docx
        README.txt
    Supporting classes:
        DSAGraph.java
        DSALinkedList.java
        DSAQueue.java
        DSAStack.java
    Keyboard Files:
        iview.al
        stan.al
        stanNoWrap.al
        switch.al
        netflix.al
        numPad.al
    Files neccessary for program:
        output.al (keyboards saved here)
        results.txt (paths saved here)
        inputString.txt (Provide an input string)
    Files needed for testing:
        TESTexport.al
        TESTinputString.txt
        TESTkb.al
        TESTresults.txt
        TESTresults1.txt
        TESTresults2.txt
    Unit Tests:
        UnitTestDSAGraph.java
        UnitTestDSALinkedList.java
        UnitTestDSAQueue.java
        UnitTestDSAStack.java
        UnitTestKeyMeUp.java