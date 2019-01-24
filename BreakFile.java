//============================================================================
//Name        : Project 5
//Course      : CS 2261: Objected-Oriented Programming
//Date        : 11/28/2018
//Author      : Yu Kuwahara
//============================================================================

// this program breaks the encrypted code
// I interpreted this program as if the original text file is tested
// it should say it is unencrypted so a new file will not be created
// if the decrypted file is tested
// it should say which key was used and a new file will be made with . broken

import java.util.Scanner;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.FileNotFoundException;

// needs these two to read the file content as string
// to compare the two files, encrypted one and decrypted one
import java.io.FileReader;
import java.io.BufferedReader;

public class BreakFile 
{

	public static void main(String args[])
	{
		
		// how can I tell if the file was re-written or not?
		// one way is to detect file modification
		// if it is modified, it is a decrypted file
		// if it is not, it is an unencrypted file 
		
		// welcomes the user as always
		System.out.println("Can we find out if it is unencrypted or not?!");
		System.out.println("==============================================================================");
		
		// create a scanner object
		Scanner input = new Scanner(System.in);
		
		// create a file input object and set it to null as default
		FileInputStream fin = null;
		FileOutputStream fout = null;
		
		// now read the file
		// prompts the name of a file
		System.out.println("What is name of the file you want to test with?");
		
		// create an input called key 
		String fileName = input.next();
		
		// if fileName has ".txt", it is unencrypted
		
		String textFile = ".txt";
		
		if (fileName.toLowerCase().indexOf(textFile.toLowerCase())!= -1) 
		{

		   System.out.println("This file is unencrypted.");
		   
		   // then terminate the program
		   System.exit(0);

		} 
		
		// if not, we need to find out what keyword was used
		else 
		{
			
			System.out.println("What is name of the ecrypted file?");
			
			// create an input called key 
			String encryptedFile = input.next();
			
			// use each of the keys with the decrypted file
			// and then compare it with the encrypted file
			File deFile = new File(fileName);
			
			File enFile = new File(encryptedFile);
			
			// close a scanner since it is done taking input
			input.close();
			
			// throw an exception if IO error or file not found
			// other than that read the file byte by byte
			try
			{
				
				// take in the decrypted file
				fin = new FileInputStream(deFile);
				
				// read the file as an array of bytes
				byte fileByte[] = new byte[(int) deFile.length()];
				
				fin.read(fileByte);
				
				// take in the encrypted file
				fin = new FileInputStream(enFile);
				
				// read the file as an array of bytes
				byte fileEnc[] = new byte[(int) enFile.length()];
				
				fin.read(fileEnc);
				
				// try as many time as the number of 1 byte, -128 to 127
				// use while loop to stop it once the content of the 
				
				
				
				/*
				 * I was going to import a package to compare the content
				 * of the two files but realized I cannot use it on Eclipse
				// boolean isTwoEqual = FileUtils.contentEquals(enFile, deFile);
				// while (isTwoEqual = true)
				 */
				
				// below is the rest IF I can import the package
				// OR I could have used FileReader and BufferReader to 
				// compare the content of the two files as string
				
				{
					for (int i = -128; i < 128; i++ )
					{
						for (int j = 0; j < fileByte.length; j++)
						{
							// check 
							// since key was entered as int, the type needs to be converted
							fileByte[i] = (byte)(fileByte[j] - i);
					
						}
					}
				}
						// create a new file, encrypted file + ".encrypt"
						fout = new FileOutputStream(deFile+".broken");
				
						// write the encrypted content on the new file
						fout.write(fileByte);
			}
			
			// display error messages
			catch(FileNotFoundException e)
			{
				System.out.println(e);
			}
			
			catch(IOException ex)
			{
				System.out.println(ex);
			}
			
			// exception handling always needs to end with finally block 
			finally
			{
				
				try
				{
					
					// if the reading file has some content, close it
					if(fin!=null)
					{
						fin.close();
					}
					
					// if the writing file has some content, also close it
					if(fout!=null)
					{
						fout.close();
					}
					
				}
				
				// if there is any problem reading or the file is empty
				catch (IOException e)
				{
					System.out.println(e);
				}
				
			} // the end of finally 

		} // the end of else function
		
	} // the end of main 
	
}
