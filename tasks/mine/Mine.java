package mining.tasks.mine;

import java.util.concurrent.Callable;

import mining.Information;
import mining.tasks.Task;

import org.powerbot.script.Condition;
import org.powerbot.script.Random;
import org.powerbot.script.Tile;
import org.powerbot.script.rt4.ClientContext;
import org.powerbot.script.rt4.GameObject;

public class Mine extends Task {

	public Mine(ClientContext ctx) {
		super(ctx);
	}

	/**
	 * Returns true if inventory is not full
	 */
	public boolean activate() {
		return ctx.inventory.select().count() < 28;
	}

	/**
	 * Mines a rock
	 */
	public void execute() {
		// get the nearest rock
		GameObject rock = ctx.objects.select().id(Information.rock_ids)
				.nearest().poll();

		// if we are not mining and not moving
		if (ctx.players.local().animation() == -1
				&& !ctx.players.local().inMotion()) {
			Condition.sleep(Random.getDelay()); // sleeps for
												// "a suggested human reaction delay"
												// to stop instantaneous and
												// unhumanlike reactions
			
			if (ctx.players.local().animation() == -1
					&& !ctx.players.local().inMotion()) { //double check we aren't doing anything still because there is a pause sometimes
				if(rock.interact("Mine")){
					Condition.wait(new Callable<Boolean>() {
		                 @Override
		                 public Boolean call() throws Exception {
		                     return ctx.players.local().animation()!=-1; //sleep until we ARE mining, stops spam clicks
		                 }
		             }, 600, 5);
				}
			}
			}
		}

	}


