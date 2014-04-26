package mining;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicInteger;

import mining.tasks.mine.Mine;
import mining.tasks.inventory.Drop;

import mining.gui.Gui;
import mining.tasks.Task;

import org.powerbot.script.*;
import org.powerbot.script.Script.Controller;

/**
 * 
 * Basic mining script powermining functionality only
 * 
 */
@Script.Manifest(description = "A basic mining script.", name = "Basic Miner")
public class BasicMiner extends
		PollingScript<org.powerbot.script.rt4.ClientContext> implements
		PaintListener, MessageListener {

	// array list to contain tasks
	private List<Task> tasks = new ArrayList<Task>();

	private int mineCount = 0;

	/**
	 * Ran once on script start
	 */
	public void start() {
		// call Gui
		new Gui();
		tasks.add(new Mine(ctx));
		tasks.add(new Drop(ctx));
	}

	/**
	 * Polls indefinitely
	 */
	public void poll() {
		
		
		if (ctx.widgets.widget(211).component(0).visible()) { //no pickaxe!			
			ctx.controller().stop();
		}
		
			
			// check they have selected what they want to mine
			if (Information.ore_id != 0) {
				// loop through all tasks, calling execute() as appropriate
				for (Task t : tasks) {
					if (t.activate()) {
						t.execute();
					}
				}
			}
		}
	

	public String formatTime(final long time) {
		final int sec = (int) (time / 1000), h = sec / 3600, m = sec / 60 % 60, s = sec % 60;
		return (h < 10 ? "0" + h : h) + ":" + (m < 10 ? "0" + m : m) + ":"
				+ (s < 10 ? "0" + s : s);
	}

	@Override
	public void repaint(Graphics g) {
		g.setColor(new Color(0, 0, 0));
		g.fillRect(4, 5, 129, 56);
		g.drawRect(4, 5, 129, 56);
		g.setColor(new Color(255, 255, 255));
		g.drawString("Basic Miner", 43, 18);
		g.drawString("Run Time: " + formatTime(getTotalRuntime()), 10, 37);
		g.drawString("Mined: " + mineCount, 10, 52);

	}

	@Override
	public void messaged(MessageEvent e) {
		if (e.getMessage().toLowerCase().contains("you manage to")) {
			mineCount++;
		}

	}


}
