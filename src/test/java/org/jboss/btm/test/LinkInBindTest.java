package org.jboss.btm.test;

import static org.assertj.core.api.Assertions.assertThat;

import org.jboss.btm.abstractmethod.GreetingsProcessorAbstractMethod;
import org.jboss.btm.common.GreetingsProcessor;
import org.jboss.byteman.contrib.bmunit.BMRule;
import org.jboss.byteman.contrib.bmunit.BMRules;
import org.jboss.byteman.contrib.bmunit.BMUnitConfig;
import org.jboss.byteman.contrib.bmunit.BMUnitRunner;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(BMUnitRunner.class)
@BMUnitConfig(verbose = true, debug = true)
public class LinkInBindTest {

	@Test
	@BMRules(rules = {
	@BMRule(name = "fist call",
		targetClass = "GreetingsProcessorAbstractMethod",
		targetMethod = "process",
		targetLocation = "AT ENTRY",
		condition = "NOT flagged(\"myflag\")",
		action = "flag(\"myflag\"), link(\"test\", \"greetings\", \"goodbye\"), trace(\">>>>>>>>>> called #1\\n\")"),
	@BMRule(name = "second call",
		targetClass = "GreetingsProcessorAbstractMethod",
		targetMethod = "process",
		targetLocation = "AT ENTRY",
		condition = "flagged(\"myflag\")",
		binding = "isf:boolean = flagged(\"myflag\"), linkedGreetings:String = linked(\"test\", \"greetings\")",
		action = "$1 = linkedGreetings, trace(\">>>>>>>>>> called #2\\n\")"),
	})
	public void linkedAtBinding() {
		GreetingsProcessor processor = new GreetingsProcessorAbstractMethod();
		processor.process("hello");
		String ret = processor.process("how are you?");
		assertThat(ret).isEqualTo("goodbye");
	}
}
