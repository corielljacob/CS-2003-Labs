/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.26.0-b05b57321 modeling language!*/



// line 1 "Project.ump"
public class Customer
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Customer Attributes
  private String name;
  private String address;

  //Customer Associations
  private Account account;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Customer(String aName, String aAddress, Account aAccount)
  {
    name = aName;
    address = aAddress;
    if (aAccount == null || aAccount.getCustomer() != null)
    {
      throw new RuntimeException("Unable to create Customer due to aAccount");
    }
    account = aAccount;
  }

  public Customer(String aName, String aAddress, int aAccountNumForAccount, int aTotalNumOrdersForAccount)
  {
    name = aName;
    address = aAddress;
    account = new Account(aAccountNumForAccount, aTotalNumOrdersForAccount, this);
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setName(String aName)
  {
    boolean wasSet = false;
    name = aName;
    wasSet = true;
    return wasSet;
  }

  public boolean setAddress(String aAddress)
  {
    boolean wasSet = false;
    address = aAddress;
    wasSet = true;
    return wasSet;
  }

  public String getName()
  {
    return name;
  }

  public String getAddress()
  {
    return address;
  }

  public Account getAccount()
  {
    return account;
  }

  public void delete()
  {
    Account existingAccount = account;
    account = null;
    if (existingAccount != null)
    {
      existingAccount.delete();
    }
  }


  public String toString()
  {
    return super.toString() + "["+
            "name" + ":" + getName()+ "," +
            "address" + ":" + getAddress()+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "account = "+(getAccount()!=null?Integer.toHexString(System.identityHashCode(getAccount())):"null");
  }
}