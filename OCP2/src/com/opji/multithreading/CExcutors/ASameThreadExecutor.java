package com.opji.multithreading.CExcutors;

import java.util.concurrent.Executor;


public class ASameThreadExecutor implements Executor {
	/**
	 * El siguiente ejemplo no comienza ningún hilo, en su lugar ejecuta 
	 * Runnable usando el Thread que  invocó al execute()
	 */
	@Override
	public void execute(Runnable command) {
		command.run(); // caller waits

	}
}
