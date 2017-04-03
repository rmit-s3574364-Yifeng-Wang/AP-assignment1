import java.util.Random;

public class Athlete extends Participant {

	public Athlete(String ID, String name, int age, String state,String athleteType) {
		super(ID, name, age, state);
		// TODO Auto-generated constructor stub
	}
    private int current_score;
    private String game_type; 
	private int scores=0;
	public int compete(String game)
	{
		Random r = new Random();
		int time = 0;
		if(game.equals("running"))
		 {
			 time = r.nextInt(10) + 10;
		 }
		 else if(game.equals("swimming"))
		 {
			 time = r.nextInt(100) + 100;
		 }
		 else if(game.equals("cycling"))
		 {
			 time = r.nextInt(300) + 500;
		 }
		 current_score = time;
		 return time;
	 }
	 public int get_current()
	 {
		 return current_score;
	 }
	 
	 public void set_scores(int score)
	 {
		 scores += score;
	 }
	 
	 public void print()
	 {
		 System.out.print(get_ID() + "\t" + get_name() + "\t" + get_age() + "\t" + get_state() + "\t" + game_type + "\t" + scores + "\t");
	 }
 }

