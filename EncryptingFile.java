//============================================================================
//Name        : Project 5
//Course      : CS 2261: Objected-Oriented Programming
//Date        : 11/28/2018
//Author      : Yu Kuwahara
//============================================================================

// this program encrypts a content of a file by using a key in byte
// it reads the content as an array of byte and add the key in byte
// to each of the elements in the array
// then  name the file as xxx.encrypted
// the next program decrypts the encrypted file

// to take the user input for the key and the file name
import java.util.Scanner;

// to work with files
import java.io.File;

// to take in the content of the file like C++
import java.io.FileInputStream;

// to output the changed content of the file like C++
import java.io.FileOutputStream;

// throws a method when input or output operation is failed or interpreted 
import java.io.IOException;

// throws a method when the file is not found
import java.io.FileNotFoundException;

public class EncryptingFile 
{
	
	// this project simply encrypts by adding the key as a byte to 
	// each of the elements in the array as a byte, everything can 
	// be done inside of a main function
	
	public static void main(String args[])
	{
		
		// welcomes the user as always
		System.out.println("Welcome to the file encrypting program!");
		System.out.println("==============================================================================");
		
		// create a scanner object
		Scanner input = new Scanner(System.in);
		
		// prompt the user for the key 
		System.out.println("What would you like to use for the special key to encrypt?");
		System.out.println("* WARNING: the key can only be in bytes between -128 and 127");
		System.out.println("==============================================================================");
		
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
		System.out.println("What is a name of a file you like to encrypt?");
		
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
				fileByte[i] = (byte)(fileByte[i] + key);
				
			}
			
			// create a new file, encrypted file + ".encrypt"
			fout = new FileOutputStream(newFile+".encrypted");
			
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
				if (fin!=null)
				{
					fin.close();
				}
				
				// if the writing file has some content, also close it
				if (fout!=null)
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
		
		// I do not believe I need to throw runtime exception this time

	} // the end of main
	
} // the end of class
