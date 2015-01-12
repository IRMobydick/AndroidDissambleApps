package com.inauth.mme.beans;

public class CustomLogInfoBeanHelper
{
  private String name;
  private String value;

  CustomLogInfoBeanHelper(String paramString1, String paramString2)
  {
    setName(paramString1);
    setValue(paramString2);
  }

  public String getName()
  {
    return this.name;
  }

  public String getValue()
  {
    return this.value;
  }

  public void setName(String paramString)
  {
    this.name = paramString;
  }

  public void setValue(String paramString)
  {
    this.value = paramString;
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.inauth.mme.beans.CustomLogInfoBeanHelper
 * JD-Core Version:    0.6.2
 */