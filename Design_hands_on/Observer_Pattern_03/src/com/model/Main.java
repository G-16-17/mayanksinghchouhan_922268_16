package com.model;

public class Main

{

	public static void main(String[] args)

	{

		MessageSubscriberOne subscriber1 = new MessageSubscriberOne();
		MessageSubscriberTwo subscriber2 = new MessageSubscriberTwo();
		MessageSubscriberThree subscriber3 = new MessageSubscriberThree();
		MessagePublisher publisher = new MessagePublisher();
		publisher.attach(subscriber1);
		publisher.attach(subscriber2);
		publisher.notifyUpdate(new Message("First Message"));
		publisher.detach(subscriber1);
		publisher.attach(subscriber3);
		publisher.notifyUpdate(new Message("Second Message"));

	}

}