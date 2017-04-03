import java.util.Comparator;

public class Comparitor_athlete implements Comparator {

	@Override
	 public int compare(Object obj0, Object obj1)
	 {
		 Athlete a1 = (Athlete)obj0;
		 Athlete a2 = (Athlete)obj1;
		 if(a1.get_current() < a2.get_current())
		 {
			 return -1;
		 }
		 else if(a1.get_current() == a2.get_current())
		 {
			 return 0;
		 }
		 else
		 {
			 return 1;
		 }
	 }
}
	
