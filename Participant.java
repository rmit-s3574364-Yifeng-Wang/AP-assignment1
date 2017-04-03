
public class Participant {

	private String ID;
	private String name;
	private int age;
	private String state;
	
   public Participant (String ID,String name,int age,String state)
   {
	   this.ID = ID;
	   this.name = name;
	   this.age = age;
	   this.state =state;
	}
	public String get_ID()
	{
		return ID;
	}
	public String get_name()
	{
		return name;
	}
	public int get_age()
	{
		return age;
	}
	public String get_state()
	{
		return state;
	}
   
   
   
}
