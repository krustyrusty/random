public class ModelDuck extends Duck {
	public ModelDuck() {
		flyBehavior = new FlyNoWay(); //our model duck begins life grounded...without a way to fly
		quackBehavior = new Quack();
	}

	public void display() {
		System.out.println("I'm a model duck");
	}
}