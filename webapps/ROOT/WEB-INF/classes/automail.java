import org.quartz.CronExpression;
import org.quartz.CronScheduleBuilder;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.quartz.impl.StdSchedulerFactory;

public class automail {
	public static void main(String[] args) {
		try {
			
			JobDetail job = JobBuilder.newJob(autpjob.class)
					.withIdentity("job", "group").build();
			Trigger trigger = TriggerBuilder.newTrigger()
					.withIdentity("cronTrigger", "group")
					.withSchedule(CronScheduleBuilder.cronSchedule("0 52 11 * * ?"))
					.build();
			Scheduler scheduler = new StdSchedulerFactory().getScheduler();
			scheduler.start();
			scheduler.scheduleJob(job, trigger);	
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
