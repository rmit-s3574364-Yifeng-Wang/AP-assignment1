import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Driver {

	public static int SelectGame(List<Game> games)
	{
		int index = -1;
		Scanner ss = new Scanner(System.in);
		while(index == -1)
		{
			System.out.print("Please input the game ID: ");
			String ID = ss.nextLine();
			for(int i = 0; i < games.size(); i++)
			{
				if(ID.equals(games.get(i).get_ID()))
				{
					index = i;
					break;
				}
			}
		}
		return index;
	}
	
	public static String predict(List<Athlete> athletes)
	{
		boolean flag = false;
		Scanner ss = new Scanner(System.in);
		String ID = "";
		while(!flag)
		{
			System.out.print("Please input the ID of winner: ");
			ID = ss.nextLine();
			for(Athlete item : athletes)
			{
				if(item.get_ID().equals(ID))
				{
					flag = true;
					break;
				}
			}
		}
		return ID;
	}
	
	public static int menu()
	{
		System.out.println("Ozlympic Game");
		System.out.println("===================================");
		System.out.println("1. Select a game to run");
		System.out.println("2. Predict the winner of the game");
		System.out.println("3. Start the game");
		System.out.println("4. Display the final results of all games");
		System.out.println("5. Display the points of all athletes");
		System.out.println("6. Exit");
		Scanner ss = new Scanner(System.in);
		System.out.println();
		System.out.print("Enter an option: ");
		int choice = ss.nextInt();
		return choice;
	}
	
	public static void InitAthletes(List<Athlete> athletes)
	{
		File f = new File("Athletes.csv");
		BufferedReader br = null;
		String str;
		try
		{
			br = new BufferedReader(new FileReader(f));
			while((str = br.readLine()) != null)
			{
				String[] arry = str.split(",");
				athletes.add(new Athlete(arry[0], arry[1], Integer.valueOf(arry[2]), arry[3], arry[4]));
			}
		}
		catch(IOException ie)
		{
			
		}
		try
		{
			br.close();
		}
		catch(IOException ie)
		{
			
		}
	}
	
	public static void InitReferees(List<Referee> referees)
	{
		File f = new File("Referees.csv");
		BufferedReader br = null;
		String str;
		try
		{
			br = new BufferedReader(new FileReader(f));
			while((str = br.readLine()) != null)
			{
				String[] arry = str.split(",");
				referees.add(new Referee(arry[0], arry[1], Integer.valueOf(arry[2]), arry[3]));
			}
		}
		catch(IOException ie)
		{
			
		}
		
		try
		{
			br.close();
		}
		catch(IOException ie)
		{
			
		}
	}
	
	public static void InitGames(List<Game> games, List<Athlete> athletes, List<Referee> referees)
	{
		File f = new File("Games.csv");
		BufferedReader br = null;
		String str;
		try
		{
			br = new BufferedReader(new FileReader(f));
			while((str = br.readLine()) != null)
			{
				String[] arry = str.split(",");
				List<String> IDs = new ArrayList<String>();
				for(int i = 3; i < arry.length; i++)
				{
					IDs.add(arry[i]);
				}
				games.add(new Game(IDs, athletes, arry[2], referees, arry[0], arry[1]));
			}
		}
		catch(IOException ie)
		{
			
		}
		try
		{
			br.close();
		}
		catch(IOException ie)
		{
			
		}
	}
	
	
	   public static void start_game()
	{	
		int choice;
		int index = -1;
	String ID = "";
	List<Game> games = new ArrayList<Game>();
	List<Athlete> athletes = new ArrayList<Athlete>();
	List<Referee> referees = new ArrayList<Referee>();
	InitAthletes(athletes);
	InitReferees(referees);
	InitGames(games, athletes, referees);
	while(true)
	{
		choice = menu();
		if(choice == 1)
		{
			for(Game item : games)
			{
				item.print();
			}
			index = Driver.SelectGame(games);
			System.out.println("Select Game Successfully.");
		}
		else if(choice == 2)
		{
			ID = predict(games.get(index).get_athletes());
			System.out.println("You have predicted one winner.");
		}
		else if(choice == 3)
		{
			if(index == -1)
			{
				System.out.println("You have to select the game to start first!");
			}
			else
			{
				games.get(index).start();
			}
			if(ID.equals(games.get(index).get_athletes().get(0).get_ID()))
			{
				System.out.println("Congratulate you have predicted the right winner");
			}
			else
			{
				System.out.println("I am sorry that you do not predict the right winner");
			}
		}
		else if(choice == 4)
		{
			for(Game item : games)
			{
				item.print();
			}
		}
		else if(choice == 5)
		{
			for(Athlete item : athletes)
			{
				item.print();
				System.out.println();
			}
		}
		else if(choice == 6)
		{
			break;
		}
  
		}
	 }
}
