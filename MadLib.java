//� A+ Computer Science  -  www.apluscompsci.com
//Name -
//Date -
//Class -
//Lab  -

import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class MadLib
{
	private ArrayList<String> verbs = new ArrayList<String>();
	private ArrayList<String> nouns = new ArrayList<String>();
	private ArrayList<String> adjectives = new ArrayList<String>();
	private String story = "";

	public MadLib()
	{
		verbs.add("run");

		nouns.add("Jonathan Leohr");

		adjectives.add("purple");

		story = "Jonathan Leohr run down a purple road";
	}

	public MadLib(String fileName)
	{
		//load stuff
		loadNouns();
		loadVerbs();
		loadAdjectives();

		try
		{
			//Read the different parts of the story and concatenate the resulting
			//story using the symbols to tell you the parts of speech
			Scanner chopper = new Scanner(new File(fileName));

			//a string to store the next postion in the scanner to prevent the scanner jumping foward one the point in the scanner is used
			String curent = "";

			//While there is more of the story, read in the word/symbol
			while(chopper.hasNext())
			{
				//set the string to the scanner's next postion
				curent = chopper.next();
				//If what was read in is one of the symbols, find a random
				//word to replace it.
				if (curent.equals("#"))
				{	
					story += getRandomNoun() + " "; 
				}
				else if (curent.equals("@"))
				{
					story += getRandomVerb() + " ";
				}
				else if (curent.equals("&"))
				{
					story += getRandomAdjective() + " ";
				}
				else
				{
					story += curent + " ";
				}
			}	
			
			
	
			//close scanner
			chopper.close();
		}
		catch(Exception e)
		{
			System.out.println("Houston we have a problem!");
		}

	}

	public void loadNouns()
	{
		try
		{
			//use a scanner to place each line into a postion in the nouns array list
			Scanner reader = new Scanner(new File ("nouns.dat"));

			while(reader.hasNext())
				nouns.add(reader.nextLine());

			reader.close();

		}
		catch(Exception e)
		{
			System.out.println("nouns.dat does not exist");
		}

	}

	public void loadVerbs()
	{
		try
		{
			//use a scanner to place each line into a postion in the verbs array list
			Scanner reader = new Scanner(new File ("verbs.dat"));

			while(reader.hasNext())
				verbs.add(reader.nextLine());

			reader.close();	
		}
		catch(Exception e)
		{
			System.out.println("verbs.dat does not exist");
		}
	}

	public void loadAdjectives()
	{
		try
		{
			//use a scanner to place each line into a postion in the adjectives array list
			Scanner reader = new Scanner(new File ("adjectives.dat"));

			while(reader.hasNext())
				adjectives.add(reader.nextLine());

			reader.close();	
		}
		catch(Exception e)
		{
			System.out.println("adjectives.dat does not exist");
		}
	}

	public String getRandomVerb()
	{
		//use math.random to get a random verb from the verbs array list
		return ""+ verbs.get((int)(Math.random()*verbs.size()));
	}

	public String getRandomNoun()
	{
		//use random object to get a random noun from the nouns array list
		Random rand = new Random();
		return ""+ nouns.get(rand.nextInt(nouns.size()));
	}

	public String getRandomAdjective()
	{
		//use random object to get a random adjective from the adjectives array list
		Random rand = new Random();
		return ""+ adjectives.get(rand.nextInt(adjectives.size()));
	}

	public String toString()
	{
		//print out the story thats made
		return "" + story;
	}
}