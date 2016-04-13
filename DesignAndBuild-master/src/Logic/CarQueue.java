package Logic;

import java.util.LinkedList;
import java.util.Queue;

/**
 *
 * @author      327278, 331048, 335364 & 343991
 * @version     13-04-2016
 * This class creates an carQueue
 */

public class CarQueue {
    /**
     * Constructor for the class Logic.CarQueue that is initialized with objects of the class Logic.Car
     */
    private Queue<Car> queue = new LinkedList<>();

    /**
     * Add a Logic.Car to the Logic.CarQueue.
     * @param car Define the name of the car.
     * @return Add car to queue.
     */
    public boolean addCar(Car car) {
        return queue.add(car);
    }

    /**
     * Remove a Logic.Car from the Logic.CarQueue.
     * @return Remove the first object in the list.
     */
    public Car removeCar() {
        return queue.poll();
    }

    /**
     *
     * @return the queue peek
     */

    public Car peek(){
        return this.queue.peek();
    }

    /**
     * This methods returns the size of the queue
     * @return The size of the queue
     */

    public int getQueueSize(){
        return queue.size();
    }

    /**
     * This methods is a getter, it gets the queue.
     * @return returns the queue
     */

    public Queue<Car> getQueue() {
        return queue;
    }
}