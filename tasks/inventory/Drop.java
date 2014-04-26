package mining.tasks.inventory;

import java.util.concurrent.Callable;

import mining.Information;
import mining.tasks.Task;

import org.powerbot.script.Condition;
import org.powerbot.script.Random;
import org.powerbot.script.Tile;
import org.powerbot.script.rt4.ClientContext;
import org.powerbot.script.rt4.GameObject;
import org.powerbot.script.rt4.Item;

/**
 * For dropping appropriate ores from inventory *
 */
public class Drop extends Task {

	public Drop(ClientContext ctx) {
		super(ctx);
	}

	/**
	 * returns true if inventory is full
	 */
	public boolean activate() {
		return ctx.inventory.select().count() == 28;
	}

	/**
	 * loops though specific ore in inventory and drops it
	 */
	public void execute() {
		for (Item i : ctx.inventory.select().id(Information.oreIds)) {
			i.interact("Drop");
			Condition.sleep(Random.getDelay()); // sleeps for
												// "a suggested human reaction delay"
		}

	}

}
