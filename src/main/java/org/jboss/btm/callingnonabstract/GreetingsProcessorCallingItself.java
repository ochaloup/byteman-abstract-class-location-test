package org.jboss.btm.callingnonabstract;

public class GreetingsProcessorCallingItself extends AbstractGreetingsProcessorCallingItself {

	@Override
	public String process(String param) {
		return callProcess(param);
	}

}
