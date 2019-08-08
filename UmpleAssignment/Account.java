/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.26.0-b05b57321 modeling language!*/


import java.util.*;

// line 7 "Project.ump"
public class Account
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Account Attributes
  private int accountNum;
  private int totalNumOrders;

  //Account Associations
  private List<Order> orders;
  private Customer customer;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Account(int aAccountNum, int aTotalNumOrders, Customer aCustomer)
  {
    accountNum = aAccountNum;
    totalNumOrders = aTotalNumOrders;
    orders = new ArrayList<Order>();
    if (aCustomer == null || aCustomer.getAccount() != null)
    {
      throw new RuntimeException("Unable to create Account due to aCustomer");
    }
    customer = aCustomer;
  }

  public Account(int aAccountNum, int aTotalNumOrders, String aNameForCustomer, String aAddressForCustomer)
  {
    accountNum = aAccountNum;
    totalNumOrders = aTotalNumOrders;
    orders = new ArrayList<Order>();
    customer = new Customer(aNameForCustomer, aAddressForCustomer, this);
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setAccountNum(int aAccountNum)
  {
    boolean wasSet = false;
    accountNum = aAccountNum;
    wasSet = true;
    return wasSet;
  }

  public boolean setTotalNumOrders(int aTotalNumOrders)
  {
    boolean wasSet = false;
    totalNumOrders = aTotalNumOrders;
    wasSet = true;
    return wasSet;
  }

  public int getAccountNum()
  {
    return accountNum;
  }

  public int getTotalNumOrders()
  {
    return totalNumOrders;
  }

  public Order getOrder(int index)
  {
    Order aOrder = orders.get(index);
    return aOrder;
  }

  public List<Order> getOrders()
  {
    List<Order> newOrders = Collections.unmodifiableList(orders);
    return newOrders;
  }

  public int numberOfOrders()
  {
    int number = orders.size();
    return number;
  }

  public boolean hasOrders()
  {
    boolean has = orders.size() > 0;
    return has;
  }

  public int indexOfOrder(Order aOrder)
  {
    int index = orders.indexOf(aOrder);
    return index;
  }

  public Customer getCustomer()
  {
    return customer;
  }

  public static int minimumNumberOfOrders()
  {
    return 0;
  }

  public Order addOrder(int aOrderNum, String aDateCreated, String aItemName)
  {
    return new Order(aOrderNum, aDateCreated, aItemName, this);
  }

  public boolean addOrder(Order aOrder)
  {
    boolean wasAdded = false;
    if (orders.contains(aOrder)) { return false; }
    Account existingAccount = aOrder.getAccount();
    boolean isNewAccount = existingAccount != null && !this.equals(existingAccount);
    if (isNewAccount)
    {
      aOrder.setAccount(this);
    }
    else
    {
      orders.add(aOrder);
    }
    wasAdded = true;
    return wasAdded;
  }

  public boolean removeOrder(Order aOrder)
  {
    boolean wasRemoved = false;
    //Unable to remove aOrder, as it must always have a account
    if (!this.equals(aOrder.getAccount()))
    {
      orders.remove(aOrder);
      wasRemoved = true;
    }
    return wasRemoved;
  }

  public boolean addOrderAt(Order aOrder, int index)
  {  
    boolean wasAdded = false;
    if(addOrder(aOrder))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfOrders()) { index = numberOfOrders() - 1; }
      orders.remove(aOrder);
      orders.add(index, aOrder);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveOrderAt(Order aOrder, int index)
  {
    boolean wasAdded = false;
    if(orders.contains(aOrder))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfOrders()) { index = numberOfOrders() - 1; }
      orders.remove(aOrder);
      orders.add(index, aOrder);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addOrderAt(aOrder, index);
    }
    return wasAdded;
  }

  public void delete()
  {
    for(int i=orders.size(); i > 0; i--)
    {
      Order aOrder = orders.get(i - 1);
      aOrder.delete();
    }
    Customer existingCustomer = customer;
    customer = null;
    if (existingCustomer != null)
    {
      existingCustomer.delete();
    }
  }


  public String toString()
  {
    return super.toString() + "["+
            "accountNum" + ":" + getAccountNum()+ "," +
            "totalNumOrders" + ":" + getTotalNumOrders()+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "customer = "+(getCustomer()!=null?Integer.toHexString(System.identityHashCode(getCustomer())):"null");
  }
}