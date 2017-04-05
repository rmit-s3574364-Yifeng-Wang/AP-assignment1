import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class driver 
{
	public driver()
	{
		
	}
	
	public void InitAthletes(List<Athlete> athletes)//读取文件，初始化运动员信息
	{
		File f = new File("Athletes.csv");
		BufferedReader br = null;
		String str;
		try
		{
			br = new BufferedReader(new FileReader(f));
			while((str = br.readLine()) != null)//逐行读取
			{
				String[] arry = str.split(",");//将读取的一行数据按照逗号分隔
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
	
	public void InitReferees(List<Referee> referees)//读取文件，初始化裁判员的相关信息
	{
		File f = new File("Referees.csv");
		BufferedReader br = null;
		String str;
		try
		{
			br = new BufferedReader(new FileReader(f));
			while((str = br.readLine()) != null)//逐行读取文件内容
			{
				String[] arry = str.split(",");//以逗号作为文件内容的分割
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
	
	public void InitGames(List<Game> games, List<Athlete> athletes, List<Referee> referees)//读取文件初始化比赛信息
	{
		File f = new File("Games.csv");
		BufferedReader br = null;
		String str;
		try
		{
			br = new BufferedReader(new FileReader(f));
			while((str = br.readLine()) != null)//逐行读取文件
			{
				String[] arry = str.split(",");//用逗号分隔字符串
				games.add(new Game(athletes, arry[2], referees, arry[0], arry[1]));
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
	
	public int SelectGame(List<Game> games)//选择比赛功能项
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
	
	public String predict(List<Athlete> athletes)//预测比赛结果功能项
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
	
	public int menu()//菜单函数
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
	
	public void Manage()//统筹系统运行的函数
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
			if(choice == 1)//选择比赛
			{
				for(Game item : games)
				{
					item.print();
				}
				index = SelectGame(games);
				System.out.println("Select Game Successfully.");
			}
			else if(choice == 2)//预测比赛结果
			{
				ID = predict(games.get(index).get_athletes());
				System.out.println("You have predict one winner.");
			}
			else if(choice == 3)//开始比赛
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
					System.out.println("Congratulate you have predict the right winner");
				}
				else
				{
					System.out.println("I am sorry about you do not predict the right winner");
				}
			}
			else if(choice == 4)//输出所有比赛结果
			{
				for(Game item : games)
				{
					item.print();
				}
			}
			else if(choice == 5)//输出所有运动员信息
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
