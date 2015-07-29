abstract class Duck {

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

interface FlyBehavior {	//the interface that all flying behavior classes implement
	public void fly();
}

class FlyNoWay implements FlyBehavior {	//Flying behavior implementation for ducks that do NOT fly (like rubber ducks and decoy ducks)
	public void fly() {
		System.out.println("I can't fly!");
	}
}

class FlyRocketPowered implements FlyBehavior {
	public void fly() {
		System.out.println("I'm flying with a rocket");
	}
}

class FlyWithWings implements FlyBehavior {	//Flying behavior implementatino for ducks that DO fly
	public void fly() {
		System.out.println("I'm flying!");
	}
}


class MallardDuck extends Duck {	//MallardDuck inherits the quackBehavior and flyBehavior instance variables from class Duck

	public MallardDuck() {		//A MallardDuck uses the Quack class to handle its quack so when performQuack() is called the responsibility for the quack
		quackBehavior = new Quack();  // is delegated to the Quack object and we get a real quack.
		flyBehavior = new FlyWithWings();	//And it uses FlyWithWings as its FlyBehavior type.
	}

	public void display() {
		System.out.println("I'm a real Mallard duck");
	}
}

class ModelDuck extends Duck {
	public ModelDuck() {
		flyBehavior = new FlyNoWay(); //our model duck begins life grounded...without a way to fly
		quackBehavior = new Quack();
	}

	public void display() {
		System.out.println("I'm a model duck");
	}
}

class MuteQuack implements QuackBehavior {
	public void quack() {
		System.out.println("<< Silence >>");
	}
}

class Quack implements QuackBehavior {
	public void quack() {
		System.out.println("Quack!");
	}
}

interface QuackBehavior {
	public void quack();
}

class Squeak implements QuackBehavior {
	public void quack() {
		System.out.println("Squeak");
	}
}

public class Duck_All_In_One {
	public static void main(String[] args) {
		Duck mallard = new MallardDuck();
		mallard.performQuack();	//This calls the Mallard Duck's inherited performQuack() method, which then delegates to the object's QuackBehavior (i.e. calls quack() on the duck's inherited quackBehavior reference).
		mallard.performFly();	//Then we do the same thing with MallardDuck's inherited performFly() method.

		Duck model = new ModelDuck();
		model.performFly();	//The first call to performFly() delegates to the flyBehavior object set in the ModelDuck's constructor, which is a FlyNoWay instance.
		model.setFlyBehavior(new FlyRocketPowered()); //This invokes the model's inherited behavior setter method -- the model suddenly has rocket-powered flying capability!
														//to change the duck's behavior at runtime, just call the duck's setter method for that behavior (Duck.java class)
		model.performFly(); //The model duck DYNAMICALLY changed its flying behavior. You can't do THAT if the implementation lives inside the Duck class.
	}
}