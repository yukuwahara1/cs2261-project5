# cs2261-project5
Encrypting and decrypting a file

The project 5 was assigned to encrypt a file and read the encrypted 
file. Assuming there is a file called "plaintext" containing a super secret
message,

  Yu Kuwahara is actually a bunny person!

then the program promps the user to enter a key that is a byte between -128 
and 127. Next, the program asks the file name, in this case it is "plaintext".
Now, the program encrypts the content of the file by reading the contents as
an array of bytes instead of reading them letter by letter as string. 
Exception handlings such as IO error were done at the end. The encrypted file 
should be able to find in the same folder as the program. The encrypted content
is,

  ]y$Oy{eleve$mw$egxyepp}$e$fyrr}$tivwsr%

Again as you can see, those white spaces were proerly take care of.

The second project was to decrypt the encrypted file in the first 
program. This program basically reverses what was done on the first program.
First, it reads the content of the file as an array of bytes. Then the program
subtracts the key to each of the elements in the array and convert the outcome
into bytes. Now I got,

  Yu Kuwahara is actually a bunny person!

The hardest part was coming up with a way to encrypt a file other than 
read the whole content as string and break them down into pieces like how I did
in C++. Doing online researches and one of the requirements for the project, 
read the content in byte, helped me to come up with read the whole content as an 
array of bytes. To encrypt, simply add the key and convert the outcome as byte 
so there is no problem with white spaces.

Another problem was to figure out where to put the text file inside of 
Eclipse. I ended up putting the file everywhere.

I tried to work on the extra credits that tells if the file is unencrypted,
if so it should be end with .txt or if it is decrypted, if so find out what key was 
used by matching the content of the encrypted file with the content of the decrypted 
file modified with key from -128 to 127 by using BufferedReader and FileReader to check if each of 
the lines in both of the files are the same.



