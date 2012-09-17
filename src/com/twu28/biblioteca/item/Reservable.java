package com.twu28.biblioteca.item;

/**
 * Created with IntelliJ IDEA.
 * User: Fernando
 * Date: 9/13/12
 * Time: 6:02 PM
 * To change this template use File | Settings | File Templates.
 */

/**
 * Represents a reservable object.
 *
 */
public interface Reservable {

    /**
     * Checks if an item is reserved
     *
     * @return true, if it's reserved
     *         false, otherwise
     */
    public boolean isReserved();

    /**
     *
     * Reserves the item
     *
     */
    public void reserve();
}
