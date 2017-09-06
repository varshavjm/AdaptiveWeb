package com.assignment1;

import java.util.ArrayList;

public class Actions {
private static Actions actionInstance=null;
static ArrayList<String> action;
private Actions() {
	action= new ArrayList<String>();
}
public static Actions getActionInstance() {
	
	if(actionInstance==null) {
		actionInstance = new Actions();
	}
	return actionInstance;
}

public static void destroyInstance() {
	actionInstance=null;
	action=null;
}
public  static void addAction(String act) {
	action.add(act);
}

public static ArrayList getActions() {
	return action;
}

}
