public class ButtonTimer 
{
	int keyTimeDown;
	
	ButtonTimer()
	{
		keyTimeDown = 0;
	}
	
	public void count()
	{
		keyTimeDown++;
	}
	
	public void reset()
	{
		keyTimeDown = 0;
	}
}
