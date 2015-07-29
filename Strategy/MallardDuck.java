public class MallardDuck extends Duck {	//MallardDuck inherits the quackBehavior and flyBehavior instance variables from class Duck

	public MallardDuck() {		//A MallardDuck uses the Quack class to handle its quack so when performQuack() is called the responsibility for the quack
		quackBehavior = new Quack();  // is delegated to the Quack object and we get a real quack.
		flyBehavior = new FlyWithWings();	//And it uses FlyWithWings as its FlyBehavior type.
	}

	public void display() {
		System.out.println("I'm a real Mallard duck");
	}
}