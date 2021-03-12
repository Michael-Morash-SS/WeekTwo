package com.ss.assignments.utopia.menus;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

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
	void testOptions() {
		FlowMenu testMenu = new FlowMenu("", null);
		ArrayList<FlowMenuOption> flowMenuOptions = new ArrayList();
		
		//Assert that the options is set to the provided object to test getter and setter
		testMenu.setOptions(flowMenuOptions);
		assertEquals(flowMenuOptions, testMenu.getOptions());
		
		//Add an option to test menu, ensure change is reflected in flowMenuOptions
		FlowMenuOption testOption = new FlowMenuOption("", null);
		testMenu.addOption(testOption);
		assertEquals(flowMenuOptions.get(0), testOption);
		
		//Clear options, ensure that getOptions returns new list
		testMenu.clearOptions();
		assertNotEquals(flowMenuOptions, testMenu.getOptions());
	}
	
	@Test
	void testGetMenuString() {
		FlowMenu testMenu = new FlowMenu("Test Prompt", null);
		FlowMenuOption testOption = new FlowMenuOption("Test Option", null);
		testMenu.addOption(testOption);
		
		String expectedOutput = "Test Prompt\n1) Test Option\n2) Quit";
		
		assertEquals(testMenu.getMenuString(), expectedOutput);
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
		
		// Assert that the option is ran
		testMenu.runOption(1);
		assertEquals(successFlag.getValue(), true);
		
		// Assert that the quit option is ran
		testMenu.runOption(2);
		assertEquals(testMenu.isFinished(), true);
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
