import java.util.Collections;
import java.util.List;

public class Referee extends Participant {

	public Referee(String ID, String name, int age, String state) {
		super(ID, name, age, state);
		// TODO Auto-generated constructor stub
	}

	
		 
		 public void Summarize(List<Athlete> athletes)
		 {
			 Collections.sort(athletes, new Comparitor_athlete());
			 int count = 0;
			 for(Athlete item : athletes)
			 {
				 if(count == 0)
				 {
					 item.set_scores(5);
				 }
				 else if(count == 1)
				 {
					 item.set_scores(2);
				 }
				 else if(count == 2)
				 {
					 item.set_scores(1);
				 }
				 else
				 {
					 break;
				 }
				 count++;
			 }
		 }
		 
		 public void print()
		 {
			 System.out.println(get_ID() + "\t" + get_name() + "\t" + get_age() + "\t" + get_state());
		 }
	 }