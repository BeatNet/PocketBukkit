package net.pocketbukkit.addon;

import org.blockserver.Server;
import org.blockserver.scheduler.Task;
import org.mozilla.javascript.ImporterTopLevel;
import org.mozilla.javascript.ScriptableObject;
import org.mozilla.javascript.annotations.JSStaticFunction;

@SuppressWarnings("serial")
public class AddonAPIs{
	public static class TopNamespace extends ImporterTopLevel{
		@Override
		public String getClassName(){
			return "TopNamespace";
		}
	}
	public static class ServerAPI extends ScriptableObject{
		@Override
		public String getClassName(){
			return "Server";
		}
		@JSStaticFunction
		public static Server get(){
			return Server.getInstance();
		}
		@JSStaticFunction
		public static void post(Runnable run, int ticks){
			Task task = new RunnableTask(run, ticks);
			get().getScheduler().addTask(task);
		}
		private static class RunnableTask extends Task{
			private Runnable run;
			RunnableTask(Runnable r, int delay){
				super(delay);
				run = r;
			}
			RunnableTask(Runnable r, int delay, int repeatTimes){
				super(delay, repeatTimes);
				run = r;
			}
			RunnableTask(Runnable r, int delay, boolean forever){
				super(delay, forever);
				run = r;
			}
			@Override
			public void onRun(Server server, long currentTick){
				run.run();
			}
			@Override
			public void onFinish(long currentTick){}
		}
	}
}
