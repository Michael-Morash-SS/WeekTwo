package com.ss.assignments.utopia.menus;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class PaginatedFlowMenuTest {
	@Test
	void testGetValidPageLength() {
		int optionCount = 0;
		PaginatedFlowMenu testMenu;
		
		// Test with no options
		testMenu = new PaginatedFlowMenu("", null);
		assertEquals(testMenu.getValidPageLength(), optionCount);
		
		// Test with less than full page
		optionCount = 9;
		testMenu = new PaginatedFlowMenu("", null);
		
		for (int i = 0; i < optionCount; i++) {
			testMenu.addOption(new FlowMenuOption("", null));
		}
		
		assertEquals(testMenu.getValidPageLength(), optionCount);
		
		// Test with single full page
		optionCount = 10;
		testMenu = new PaginatedFlowMenu("", null);
		
		for (int i = 0; i < optionCount; i++) {
			testMenu.addOption(new FlowMenuOption("", null));
		}
		
		assertEquals(testMenu.getValidPageLength(), 10);
		
		// Test with more than a full page
		optionCount = 11;
		testMenu = new PaginatedFlowMenu("", null);
		
		for (int i = 0; i < optionCount; i++) {
			testMenu.addOption(new FlowMenuOption("", null));
		}
		
		assertEquals(testMenu.getValidPageLength(), 10);
		testMenu.nextPage();
		assertEquals(testMenu.getValidPageLength(), 1);
	}
	
	@Test
	void testGetOptionCount() {
		int optionCount = 9;
		PaginatedFlowMenu testMenu = new PaginatedFlowMenu("", null);
		
		for (int i = 0; i < optionCount; i++) {
			testMenu.addOption(new FlowMenuOption("", null));
		}
		
		//Assert that three more options are added for Prev, Next, and Quit functions
		assertEquals(optionCount + 3, testMenu.getOptionCount());
	}
	
	@Test
	void testPagination() {
		//Test both prev page and next page functionality
		PaginatedFlowMenu flowMenu = new PaginatedFlowMenu("", null);
		int optionCount = 0;
		
		// Test with no options
		flowMenu.nextPage();
		assertEquals(0, flowMenu.getPageStart());
		
		flowMenu.prevPage();
		assertEquals(0, flowMenu.getPageStart());
		
		// Test with less than full page
		flowMenu = new PaginatedFlowMenu("", null);
		optionCount = 9;
		
		for (int i = 0; i < optionCount; i++) {
			flowMenu.addOption(new FlowMenuOption("", null));
		}
		
		flowMenu.nextPage();
		assertEquals(0, flowMenu.getPageStart());
		
		flowMenu.prevPage();
		assertEquals(0, flowMenu.getPageStart());
		
		// Test with full page
		flowMenu = new PaginatedFlowMenu("", null);
		optionCount = 10;
		
		for (int i = 0; i < optionCount; i++) {
			flowMenu.addOption(new FlowMenuOption("", null));
		}
		
		flowMenu.nextPage();
		assertEquals(0, flowMenu.getPageStart());
		
		flowMenu.prevPage();
		assertEquals(0, flowMenu.getPageStart());
		
		//Test with more than one full page
		flowMenu = new PaginatedFlowMenu("", null);
		optionCount = 11;
		
		for (int i = 0; i < optionCount; i++) {
			flowMenu.addOption(new FlowMenuOption("", null));
		}
		
		flowMenu.nextPage();
		assertEquals(10, flowMenu.getPageStart());
		
		flowMenu.prevPage();
		assertEquals(0, flowMenu.getPageStart());
	}
	
	/*
	@Test
	void testGetOptionString() {
		fail("Not yet implemented");
	}

	@Test
	void testRunOption() {
		fail("Not yet implemented");
	}

	@Test
	void testPrevPage() {
		fail("Not yet implemented");
	}

	@Test
	void testNextPage() {
		fail("Not yet implemented");
	}
	*/
}
