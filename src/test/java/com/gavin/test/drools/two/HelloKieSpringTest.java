package com.gavin.test.drools.two;

import java.util.Arrays;
import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.kie.api.runtime.KieSession;
import org.kie.api.runtime.StatelessKieSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({ "classpath:com/redhat/gss/kie/kmodule-spring.xml" })
public class HelloKieSpringTest {

	@Autowired
	private ApplicationContext ctx;

	@Test
	public void hello() {
		methodTwo();
	}

	private void methodTwo() {
		StatelessKieSession statelessKieSession = (StatelessKieSession) ctx.getBean("kieSession");
		Applicant applicant = new Applicant("Mr John Smith", 26);
		Application application = new Application(new Date());

		System.out.println("1" + applicant + " | " + application);
		statelessKieSession.execute(Arrays.asList(new Object[] { applicant, application }));
		System.out.println("2" + applicant + " | " + application);
	}

	private void methodOne() {
		KieSession kieSession = (KieSession) ctx.getBean("kieSession");
		Applicant applicant = new Applicant("Mr John Smith", 26);
		System.out.println("1" + applicant);
		kieSession.insert(applicant);
		kieSession.fireAllRules();
		System.out.println("2" + applicant);
		kieSession.dispose();
	}
}
