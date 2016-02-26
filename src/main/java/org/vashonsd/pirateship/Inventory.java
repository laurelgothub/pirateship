package org.vashonsd.pirateship;

import java.util.*;

public class Inventory
{
    private HashMap<Item, Integer> inventory;
    
    public Inventory()
    {
        inventory = new HashMap<Item, Integer>();    
    }
    
    public void addItem(Item other, int quan)
	{
		inventory.put(other, quan);
	}
	
	public void removeItem(Item other)
	{
		inventory.remove(other);
	}
	
	public void removeItem(Item other, int quan)
	{
		inventory.remove(other);
		inventory.put(other, quan);
	}
	
	public void dumpInventory()
	{
		inventory.clear();
	}
	
	public String toString()
	{
		String toReturn = "";
		
		for(Item n: inventory.keySet())
			toReturn += "Item: " + n.getName() + "   Quantity: " + inventory.get(n) + "\n";
			
		return toReturn;
	}
	
}