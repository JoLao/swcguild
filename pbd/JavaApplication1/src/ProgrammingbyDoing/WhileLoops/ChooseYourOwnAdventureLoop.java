/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ProgrammingbyDoing.WhileLoops;
    import java.util.Scanner;
/**
 *
 * @author apprentice
 */
public class ChooseYourOwnAdventureLoop {

	public static void main( String[] args )
	{
		Scanner keyboard = new Scanner(System.in);
		
		int nextroom = 1;
		String choice = "";

		while ( nextroom != 0 )
		{
			if ( nextroom == 1 )
			{
				System.out.println( "You are in a small room. There is a \"closet\" and a doorway to the \"hall\"." );
				System.out.print( "> " );
				choice = keyboard.nextLine();
				if ( choice.equals("closet") )
					nextroom = 2;
				else if ( choice.equals("hall") )
					nextroom = 3;
				else
					System.out.println( choice + " wasn't one of the options. Try again." );
			}
			if ( nextroom == 2 )
			{
				System.out.println( "You're in a barren closet. There's nothing to do here except go \"back\"." );
				System.out.print( "> " );
				choice = keyboard.nextLine();
				if ( choice.equals("back") )
					nextroom = 1;
				else
					System.out.println( choice + " wasn't one of the options. Try again." );
			}
			if ( nextroom == 3 )
			{
				System.out.println( "You find yourself in a concrete hallway. Oddly, there is only a single" );
				System.out.println( "\"door\" visible. Otherwise, the hall just extends about fifteen feet" );
				System.out.println( "in either direction, and ends in a smooth, blank, concrete wall." );
				System.out.println( "Do you want to enter the \"door\" or approach the \"wall\" looking for clues?" );
				choice = keyboard.nextLine();
				System.out.print( "> " );
				if ( choice.equals("door") )
					nextroom = 1;
				else if ( choice.equals("wall") )
					nextroom = 4;
				else
					System.out.println( choice + " wasn't one of the options. Try again." );
			}
			if ( nextroom == 4 )
			{
				System.out.println( "Upon closer inspection, the seemingly blank wall shimmers ever so slightly" );
				System.out.println( "in the dim light. You put forward a tentative hand, and it pushes through," );
				System.out.println( "a feeling of static sliding up your arm." );
				System.out.println();
				System.out.println( "You pass through the portal into the unknown...." );
                                System.out.println( "Do you want to enter the portal (Y/N)?" );
				choice = keyboard.nextLine();
				System.out.print( "> " );
                                if ( choice.equals("Y") )
					nextroom = 5;
				else 
					nextroom = 1;				
			}
                        if ( nextroom == 5)
			{
				System.out.println( "You are in a creaky room. A cool wind is blowing to your face." );
				System.out.println( "You saw a faint light. It grow bigger as you move closer," );
				System.out.println( "a warm fuzzy feeling came over you." );
				System.out.println();
				System.out.println( "Do you go to the light (y/n)?" );
				choice = keyboard.nextLine();
				System.out.print( "> " );
                                if ( choice.equals("Y") )
					nextroom = 6;
				else 
					nextroom = 2;	
			}
                        if ( nextroom == 6)
			{
				System.out.println( "Suddenly, there's light. You saw silhoettes of people coated in white light." );
				System.out.println( "Welcome, you're in heaven" );
				nextroom = 0;
				
				
		}

		System.out.println( "\nThe game is over. The next episode can be downloaded for only 800 Microsoft points!" );
	}
	
}
    
}
