public class MiniDuckSimulator {
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