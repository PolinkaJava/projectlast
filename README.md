## Description

This is a project that allows you to process transfer files containing information about amounts, senders and receivers of money transfers. The project reads files from the specified directory, parses them into a list of Transaction objects, and writes a report on the results of processing to the file report.txt.

## Technologies

The project is written in Java using JDK 11. The classes from java.nio.file package are used to work with files, SimpleDateFormat class from java.text package is used to work with dates and time, List interface from java.util package is used to work with lists.
After starting the project, a menu with two options will appear in the console: 1 - Process translation files, 0 - Exit. To process translation files you should enter 1 and press Enter. Then enter the path to the directory where the translation files are located and press Enter. The project will read all files from the directory, try to parse them into the list of Transaction objects, and output the result of processing to the console. The project will also write a report on the processing results to the file report.txt, which will be created in the same directory where the project executable is located. To exit the project, enter 0 and press Enter.



## Format of transfer files

Transfer files must have the following format: each line of the file contains three elements separated by spaces: the sender's account number, the recipient's account number and the transfer amount in rubles.
If a transfer file has an incorrect format, for example, it contains less or more than three elements in a line, or a transfer amount that is not an integer, the project will throw a FileParseException exception and stop processing this file.

