package framework.observer;

import framework.observer.Observer;

public interface Observable {
    void registerObserver(Observer observer);

    void removeObserver(Observer observer);

    void notifyObservers();
}
