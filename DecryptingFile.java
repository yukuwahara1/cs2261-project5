//============================================================================
//Name        : Project 5
//Course      : CS 2261: Objected-Oriented Programming
//Date        : 11/28/2018
//Author      : Yu Kuwahara
//============================================================================

// this program decrypts the file encrypted in the first program
// similarly read the content of the file in byte
// and then subtract the key and convert the outcome into byte
// finally create a new file with ".decpryted"

import java.util.Scanner;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.FileNotFoundException;

public class DecryptingFile 
{
	
	public static void main(String args[])
	{
		
		// welcomes the user as always
		System.out.println("Welcome to the file decrypting program!");
		System.out.println("Can we also decrypt the encrypted file?!");
		System.out.println("==============================================================================");
		
		// create a scanner object
		Scanner input = new Scanner(System.in);
		
		// prompt the user for the key 
		System.out.println("What is the key you used to encrypt the file?");
		
		// create an input called key 
		byte key = input.nextByte();
		
		// now the variable key has the key in byte 
		
		// if the user did not type in the range
		// that is if the user types bigger or smaller than 1 byte
		// display warning messages
		if (key > 128)
		{
			System.out.println("Your key has to be 1 byte, between -128 and 127");
		}
		
		if (key < -127)
		{
			System.out.println("Your key has to be 1 byte, between -128 and 127");
		}
		
		// create a file input object and set it to null as default
		FileInputStream fin = null;
		FileOutputStream fout = null;
		
		// now read the file
		// prompts the name of a file
		System.out.println("What is name of the file you encrypted?");
		
		// create an input called key 
		String fileName = input.next();
		
		// create a file object from the file from the user to manipulate it 
		File newFile = new File(fileName);
		
		// close a scanner since it is done taking input
		input.close();
		
		// throw an exception if IO error or file not found
		// other than that read the file byte by byte
		try
		{
			
			// take in the file
			fin = new FileInputStream(newFile);
			
			// read the file as an array of bytes
			byte fileByte[] = new byte[(int) newFile.length()];
			
			fin.read(fileByte);
			
			// encrypt by adding 5 to each of the elements in the array
			for (int i = 0; i < fileByte.length; i++)
			{
				// since key was entered as int, the type needs to be converted
				fileByte[i] = (byte)(fileByte[i] - key);
				
			}
			
			// create a new file, encrypted file + ".encrypt"
			fout = new FileOutputStream(newFile+".decrypted");
			
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

		
	} // the end of main 
	
} // the end of class
