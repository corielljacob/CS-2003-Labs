/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.26.0-b05b57321 modeling language!*/



// line 15 "Project.ump"
public class Order
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Order Attributes
  private int orderNum;
  private String dateCreated;
  private String itemName;

  //Order Associations
  private Account account;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Order(int aOrderNum, String aDateCreated, String aItemName, Account aAccount)
  {
    orderNum = aOrderNum;
    dateCreated = aDateCreated;
    itemName = aItemName;
    boolean didAddAccount = setAccount(aAccount);
    if (!didAddAccount)
    {
      throw new RuntimeException("Unable to create order due to account");
    }
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setOrderNum(int aOrderNum)
  {
    boolean wasSet = false;
    orderNum = aOrderNum;
    wasSet = true;
    return wasSet;
  }

  public boolean setDateCreated(String aDateCreated)
  {
    boolean wasSet = false;
    dateCreated = aDateCreated;
    wasSet = true;
    return wasSet;
  }

  public boolean setItemName(String aItemName)
  {
    boolean wasSet = false;
    itemName = aItemName;
    wasSet = true;
    return wasSet;
  }

  public int getOrderNum()
  {
    return orderNum;
  }

  public String getDateCreated()
  {
    return dateCreated;
  }

  public String getItemName()
  {
    return itemName;
  }

  public Account getAccount()
  {
    return account;
  }

  public boolean setAccount(Account aAccount)
  {
    boolean wasSet = false;
    if (aAccount == null)
    {
      return wasSet;
    }

    Account existingAccount = account;
    account = aAccount;
    if (existingAccount != null && !existingAccount.equals(aAccount))
    {
      existingAccount.removeOrder(this);
    }
    account.addOrder(this);
    wasSet = true;
    return wasSet;
  }

  public void delete()
  {
    Account placeholderAccount = account;
    this.account = null;
    placeholderAccount.removeOrder(this);
  }


  public String toString()
  {
    return super.toString() + "["+
            "orderNum" + ":" + getOrderNum()+ "," +
            "dateCreated" + ":" + getDateCreated()+ "," +
            "itemName" + ":" + getItemName()+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "account = "+(getAccount()!=null?Integer.toHexString(System.identityHashCode(getAccount())):"null");
  }
}