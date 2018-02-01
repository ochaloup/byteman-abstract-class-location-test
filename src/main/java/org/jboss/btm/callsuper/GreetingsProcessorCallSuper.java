package org.jboss.btm.callsuper;

public class GreetingsProcessorCallSuper extends AbstractGreetingsProcessorCallSuper {

	@Override
	public String process(String param) {
		return super.process(param);
	}

}
