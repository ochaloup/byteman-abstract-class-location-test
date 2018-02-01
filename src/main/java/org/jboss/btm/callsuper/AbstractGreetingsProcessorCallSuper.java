package org.jboss.btm.callsuper;

import org.jboss.btm.common.GreetingsProcessor;

public abstract class AbstractGreetingsProcessorCallSuper implements GreetingsProcessor {

	public String process(String param) {
		return param;
	}

}
