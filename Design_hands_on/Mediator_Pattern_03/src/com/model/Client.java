package com.model;

public class Client {

	public static void main(String[] args) {
		ChatMediator chatMediator = new ChatMediator();
		BasicUser bu = new BasicUser("x", chatMediator);
		PremiumUser pu = new PremiumUser("y", chatMediator);
		PremiumUser pu2 = new PremiumUser("Abc", chatMediator);
		chatMediator.AddUser(pu);
		chatMediator.AddUser(pu2);
		String name = bu.getName();

		bu.SendMessage(name, "Hi All");
	}
}
