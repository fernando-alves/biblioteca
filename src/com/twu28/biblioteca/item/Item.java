package com.twu28.biblioteca.item;

/**
 * Created with IntelliJ IDEA.
 * User: Fernando
 * Date: 9/13/12
 * Time: 6:03 PM
 * To change this template use File | Settings | File Templates.
 */

/**
 *
 * Represents a reservable library item
 *
 */
public class Item implements Reservable {

    private boolean isReserved;

    /**
     * Default constructor
     *
     */
    public Item(){
        this.isReserved = false;
    }

    /**
     * {@inheritdoc}
     */
    public boolean isReserved() {
        return isReserved;
    }

    /**
     * {@inheritdoc}
     */
    public void reserve() {
        this.isReserved = true;
    }
}
