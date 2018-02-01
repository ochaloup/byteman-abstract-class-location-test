package org.jboss.btm.callingnonabstract;

import org.jboss.btm.common.GreetingsProcessor;

public abstract class AbstractGreetingsProcessorCallingItself implements GreetingsProcessor {

	public abstract String process(String param);

	protected String callProcess(String param) {
		return param;
	}
}
