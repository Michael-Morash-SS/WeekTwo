package com.ss.assignments.utopia.menus;

import com.ss.assignments.utopia.menus.actions.FlowMenuAction;

public class FlowMenuOption {
	private String text;
	private FlowMenuAction action;
	
	public FlowMenuOption(String text, FlowMenuAction action) {
		this.text = text;
		this.action = action;
	}
	
	public String getText() {
		return text;
	}
	
	public void setText(String text) {
		this.text = text;
	}
	
	public FlowMenuAction getAction() {
		return action;
	}
	
	public void setAction(FlowMenuAction action) {
		this.action = action;
	}
	
	public void executeAction() {
		action.executeAction();
	}
}
