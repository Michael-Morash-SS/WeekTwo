package com.ss.assignments.utopia.menus;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.ss.assignments.utopia.menus.actions.FlowMenuAction;

class FlowMenuTest {

	@Test
	void testGetPrompt() {
		String prompt = "Test prompt";
		FlowMenu testMenu = new FlowMenu(prompt, null);
		assertEquals(testMenu.getPrompt(), prompt);
	}

	@Test
	void testGetOptionCount() {
		int optionCount = 10;
		FlowMenu testMenu = new FlowMenu("", null);
		
		for (int i = 0; i < optionCount; i++) {
			testMenu.addOption(new FlowMenuOption("", null));
		}
		
		assertEquals(testMenu.getOptionCount(), optionCount + 1);
	}
	
	@Test
	void testGetOptionString() {
		FlowMenu testMenu = new FlowMenu("", null);
		String optionString = "test";
		String optionStringOutput = "1) " + optionString;
		String quitString = "2) Quit";
		
		testMenu.addOption(new FlowMenuOption(optionString, null));
		
		assertEquals(testMenu.getOptionString(1), optionStringOutput);
		assertEquals(testMenu.getOptionString(2), quitString);
	}

	@Test
	void testRunOption() {
		final SuccessFlagger successFlag = new SuccessFlagger();
		FlowMenuAction testAction = () -> { successFlag.setValue(true); };
		FlowMenu testMenu = new FlowMenu("", null);
		
		testMenu.addOption(new FlowMenuOption("", testAction));
		testMenu.runOption(1);
		
		assertEquals(successFlag.getValue(), true);
	}

	private class SuccessFlagger {
		boolean value = false;
		
		public boolean getValue() {
			return value;
		}
		
		public void setValue(boolean value) {
			this.value = value;
		}
	}
}
