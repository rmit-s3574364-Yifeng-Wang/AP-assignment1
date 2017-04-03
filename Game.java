import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class Game
 {
	 private List<Athlete> athletes;
	 private List<String> grades;
	 private List<String> times;
	 private Referee referee;
	 private String ID;
	 private String game_type;
	 
	 public Game(List<String> ID, List<Athlete> athletes_, String referee, List<Referee> referees, String ID_, String type)
	 {
		 athletes = new ArrayList<Athlete>();
		 grades = new ArrayList<String>();
		 times = new ArrayList<String>();
		 for(String str : ID)
		 {
			 for(Athlete item : athletes_)
			 {
				 if(item.get_ID().equals(str))
				 {
					 athletes.add(item);
					 break;
				 }
			 }
		 }
		 for(Referee re : referees)
		 {
			 if(re.get_ID().equals(referee))
			 {
				 this.referee = re;
				 break;
			 }
		 }
		 this.ID = ID_;
		 game_type = type;
	 }
	 
	 public void start()
	 {
		 for(Athlete item : athletes)
		 {
			 item.compete(game_type);
		 }
		 referee.Summarize(athletes);
		 int count = 0;
		 for(Athlete item : athletes)
		 {
			 times.add(String.valueOf(item.get_current()));
			 if(count == 0)
			 {
				 grades.add("5");
			 }
			 else if(count == 1)
			 {
				 grades.add("2");
			 }
			 else if(count == 2)
			 {
				 grades.add("1");
			 }
			 count++;
		 }
	 }
	 
	 public void print()
	 {
		 System.out.println("*******************");
		 System.out.println("Game ID: " + ID);
		 System.out.println("Game Type: " + game_type);
		 System.out.println("****Referee****");
		 System.out.println("ID\tName\tage\tstate");
		 referee.print();
		 System.out.println("****Athletes****");
		 System.out.println("ID\tName\tage\tstate\ttype\ttotal_score\tgame_score\tgrades");
		 Iterator<String> it1 = grades.iterator();
		 Iterator<String> it2 = times.iterator();
		 for(Athlete item : athletes)
		 {
			 item.print();
			 if(it1.hasNext())
			 {
				 System.out.println(it1.next() + "\t\t" + it2.next());
			 }
			 else
			 {
				 System.out.println("0\t\t0");
			 }
		 }
	 }
	 
	 public String get_ID()
	 {
		 return ID;
	 }
	 
	 public List<Athlete> get_athletes()
	 {
		 return athletes;
	 }
 }