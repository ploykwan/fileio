# fileio 
#### By Kwankaew Uttama
Task | Time
------|------
Copy the file one byte at a time|15.136635 sec
Copy the file using a byte array of size 1 KB|0.030880 sec
Copy the file using a byte array of size 4 KB|0.009481 sec
Copy the file using a byte array of size 64 KB|0.004491 sec
Copy the file using a BufferedReader and PrintWriter to copy lines of text|0.511842 sec
Copy a file by using BufferedReader and BufferedWriter with a array of char|0.032533 sec

##### Why Copy the file one byte at a time slowear?
Because it read just one byte in each time.

##### Why copy the file using a byte array of each size are different? (1KB longer than 4KB, and 4KB longer than 64KB)
Because it read different size of object in each time. So the more using a byte array of size ,the more faster.

##### Why copy a file by using BufferedReader and BufferedWriter will faster than copying lines of text?
Because BufferedWriter will buffer the characters in Java memory before.But PrintWriter will not. It would cause characters to be converted into bytes that would then be written immediately to the file, which be very inefficient.

