package net.pocketbukkit.module;

import org.blockserver.Server;
import org.blockserver.ticker.Task;
//import org.blockserver.scheduler.Task;

public class ModuleTicker extends Task {
	private Module module;
	public ModuleTicker(Module module){
		//super(1, true);
		this.module = module;
	}

	@Override
	public void onRun(long ticks){
		//module.tick();
		if(!module.isEnabled()){
			//setRepeatTimes(0);
		}
	}

	//@Override
	public void onFinish(long ticks){
	}
}
