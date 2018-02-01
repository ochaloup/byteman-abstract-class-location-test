package org.jboss.btm.abstractmethod;

import org.jboss.btm.common.GreetingsProcessor;

public class GreetingsProcessorAbstractMethod extends AbstractGreetingsProcessorAbstractMethod implements GreetingsProcessor {

	@Override
	public String process(String param) {
		return param;
	}

}
