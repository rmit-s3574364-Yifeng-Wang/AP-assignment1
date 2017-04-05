import java.util.Random;
											//ze pan s3582660
public class Athlete extends Participants  //class athlete: to generate the grades for games
 {
	 private int scores;//total score of athletes
	 private int current_score;//current game score 
	 private String type;//
	 
	 public Athlete(String ID_, String name_, int age_, String state_, String type_)
	 {
		 super(ID_, name_, age_, state_);
		 type = type_;
		 scores = 0;
		 current_score = 0;
	 }
	 
	 public int compete(String game)//generate the grade of game by random
	 {
		 Random r = new Random();
		 int value = 0;
		 if(game.equals("running"))
		 {
			 value = r.nextInt(10) + 10;
		 }
		 else if(game.equals("swimming"))
		 {
			 value = r.nextInt(100) + 100;
		 }
		 else if(game.equals("cycling"))
		 {
			 value = r.nextInt(300) + 500;
		 }
		 current_score = value;
		 return value;
	 }
	 
	 public int get_current()//get score of current game  
	 {
		 return current_score;
	 }
	 
	 public void set_scores(int score)//set the total score 
	 {
		 scores += score;
	 }
	 
	 public String get_type()
	 {
		 return type;
	 }
	 
	 public void print()//output all the information of  athletes
	 {
		 System.out.print(get_ID() + "\t" + get_name() + "\t" + get_age() + "\t" + get_state() + "\t" + type + "\t" + scores + "\t");
	 }
 }