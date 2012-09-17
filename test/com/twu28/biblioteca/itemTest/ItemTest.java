package com.twu28.biblioteca.itemTest;

import com.twu28.biblioteca.item.Item;
import junit.framework.TestCase;

/**
 * Created with IntelliJ IDEA.
 * User: Fernando
 * Date: 9/13/12
 * Time: 6:06 PM
 * To change this template use File | Settings | File Templates.
 */
public class ItemTest extends TestCase{

    public ItemTest(){
        super();
    }

    //tests the initial status of an item's reservation
    //it should be available to be reserved
    public void testReservedInitialValue(){

        Item item = new Item();
        assertFalse(item.isReserved());

    }

    //tests the reserve behavior of a book
    //it should not be able to be reserved after a successfully reservation
    public void testReserve(){

        Item item = new Item();
        item.reserve();
        assertTrue(item.isReserved());


    }
}
