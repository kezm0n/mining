package mining.tasks;

import org.powerbot.script.rt4.ClientAccessor;
import org.powerbot.script.rt4.ClientContext;

public abstract class Task extends ClientAccessor {

	public abstract boolean activate();

	public abstract void execute();

	public Task(ClientContext ctx) {
		super(ctx);
	}

}
