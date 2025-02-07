package com.uniquedeveloper.registration;

import java.io.IOException;
import java.util.Date;
import javax.servlet.ServletException;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

public class autpjob implements Job {
static int nam;

	public void execute(JobExecutionContext context) throws JobExecutionException {
		nam = 1;
		System.out.println("Job --->>> Time is " + new Date());
		try {
			todo todo = new todo();
			todo.doGet(null, null);
		} catch (ServletException | IOException e) {
			e.printStackTrace();
		}                
	}
	
}



