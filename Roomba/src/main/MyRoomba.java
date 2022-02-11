package main;
import java.lang.Math;
import world.Move;
import world.Roomba;

public class MyRoomba extends Roomba{
	
	/*You can put variables here if it will be helpful*/
	/*Examples: Roomba is currently turning, Roomba is trying to get to some new direction, etc. */

	public MyRoomba(int x, int y, int radius) {
		super(x, y, radius);
	}

	@Override
	public Move makeMove() {
		double number = Math.random();
		/*TODO: Make this method better. Here's an example Roomba that always turns a random direction*/
		
		//if we bump into something, turn
		if(this.frontBumper)
		{
			return Move.TURNCOUNTERCLOCKWISE;
		}
		
		
		if(this.infraredSensor < 12)
		{	
			if(number > 0.66)
			{
				return Move.TURNCLOCKWISE;
			}
			else
			{
				return Move.TURNCOUNTERCLOCKWISE;
			}
		}
			
		
		if(this.wallSensor) {
			if(number > 0.66)
			{
				return Move.TURNCOUNTERCLOCKWISE;
			}
			else
			{
				return Move.TURNCLOCKWISE;
			}
		}
		
		//otherwise just move forward
		return Move.FORWARD;
	}
	
}
