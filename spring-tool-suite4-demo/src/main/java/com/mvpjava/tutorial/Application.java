package com.mvpjava.tutorial;

import java.util.Scanner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Application {
	private IApplicationInitiator initiator;

	final Logger logger = LoggerFactory.getLogger(this.getClass());

	public Application(IApplicationInitiator initiator) {
		this.initiator = initiator;
	}

	public void initApp() {
		initiator.init();
		pauseApplicationUntilKeyEntered();
	}

	private void pauseApplicationUntilKeyEntered() {
		try (Scanner scanner = new Scanner(System.in)){
			
			System.out.println("Look at the STS4 Live Boot Hint Decoratoes in your Code!");
			System.out.print ("Hit any key to resume program execution:");
			String anything = scanner.next(); 
			logger.trace("You entered: {}", anything);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
