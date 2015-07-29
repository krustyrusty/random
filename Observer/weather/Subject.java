public interface Subject {
	public void registerObserver(Observer o);
	public void removeObserver(Observer o);
	public void notifyObservers();	//called to notify all observers when the Subject's state has changed
}