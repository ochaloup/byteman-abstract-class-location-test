package org.jboss.btm.test;

import static org.assertj.core.api.Assertions.assertThat;

import org.jboss.btm.abstractmethod.GreetingsProcessorAbstractMethod;
import org.jboss.btm.callingnonabstract.GreetingsProcessorCallingItself;
import org.jboss.btm.callsuper.GreetingsProcessorCallSuper;
import org.jboss.byteman.contrib.bmunit.BMRule;
import org.jboss.byteman.contrib.bmunit.BMUnitRunner;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(BMUnitRunner.class)
// @BMUnitConfig(verbose = true, debug = true)
public class AbstractTest {
	// test to see the byteman injection works here :)
	// @BMScript("rule.btm")

	/**
	 * Running code from:
	 *   org.jboss.btm.abstractmethod
	 */
	@Test
	@BMRule(name = "change hello abstract",
		targetClass = "AbstractGreetingsProcessorAbstractMethod",
		targetMethod = "process",
		targetLocation = "AT ENTRY",
		action = "$1 = \"goodbye\"")
	public void abstractmethod() {
		String ret = new GreetingsProcessorAbstractMethod().process("hello");
		assertThat(ret).isEqualTo("goodbye");
	}

	/**
	 * Running code from:
	 *   org.jboss.btm.abstractmethod
	 */
	@Test
	@BMRule(name = "change hello abstract2",
	targetClass = "^AbstractGreetingsProcessorAbstractMethod",
	targetMethod = "process",
	targetLocation = "AT ENTRY",
	action = "$1 = \"goodbye\"")
	public void abstractmethodInheritanceRule() {
		String ret = new GreetingsProcessorAbstractMethod().process("hello");
		assertThat(ret).isEqualTo("goodbye");
	}

	/**
	 * Running code from:
	 *   org.jboss.btm.callsuper
	 */
	@Test
	@BMRule(name = "change hello callsuper",
	targetClass = "AbstractGreetingsProcessorCallSuper",
	targetMethod = "process",
	targetLocation = "AT ENTRY",
	action = "$1 = \"goodbye\"")
	public void callsuper() {
		String ret = new GreetingsProcessorCallSuper().process("hello");
		assertThat(ret).isEqualTo("goodbye");
	}

	/**
	 * Running code from:
	 *   org.jboss.btm.callsuper
	 */
	@Test
	@BMRule(name = "change hello callsuper2",
	targetClass = "^AbstractGreetingsProcessorCallSuper",
	targetMethod = "process",
	targetLocation = "AT ENTRY",
	action = "$1 = \"goodbye\"")
	public void callsuperInheritInheritanceRule() {
		String ret = new GreetingsProcessorCallSuper().process("hello");
		assertThat(ret).isEqualTo("goodbye");
	}

	/**
	 * Running code from:
	 *   org.jboss.btm.callingnonabstract
	 */
	@Test
	@BMRule(name = "change hello callingitself",
	targetClass = "AbstractGreetingsProcessorCallingItself",
	targetMethod = "callProcess",
	targetLocation = "AT ENTRY",
	action = "$1 = \"goodbye\"")
	public void callingNonAbstract() {
		String ret = new GreetingsProcessorCallingItself().process("hello");
		assertThat(ret).isEqualTo("goodbye");
	}
}
