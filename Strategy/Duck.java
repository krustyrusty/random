public abstract class Duck {

	FlyBehavior flyBehavior;	//Declare 2 reference vars for the behavior interface types
	QuackBehavior quackBehavior; //All duck subclasses inherit these; Each Duck has a reference to something that implements the QuackBehavior interface

	public Duck() {

	}

	public abstract void display();

	public void performFly() {	//these perform methods replace fly() and quack()
		flyBehavior.fly();		//Delegate to the behavior class
	}

	public void performQuack() {	//Delegate to the behavior class; instance variables hold a reference to a specific behavior at runtime
		quackBehavior.quack();	//Rather than handling the quack behavior itself, the Duck pbject DELEGATES that behavior to the object referenced by quackBehavior.
	}

	public void swim() {
		System.out.println("All ducks float, even decoys!");
	}

	public void setFlyBehavior(FlyBehavior fb) {	//allows you to set the duck's behavior type through a setter method on the duck's subclass, rather than by instantiating it in the duck's constructor
		flyBehavior = fb;							
	}

	public void setQuackBehavior(QuackBehavior qb) {	//we can call these methods anytime we want to change the behavior of the duck "on the fly"
		quackBehavior = qb;
	}
}