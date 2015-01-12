package com.inauth.mme.beans;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class CustomLogInfoBean
{
  private static String payloadname = "CustomEvent";
  private String name = payloadname;
  private String occured_at = "";
  private List<CustomLogInfoBeanHelper> vars = new ArrayList();

  public String getName()
  {
    return this.name;
  }

  public String getOccured_at()
  {
    return this.occured_at;
  }

  public void setName(String paramString)
  {
    this.name = paramString;
  }

  public void setOccured_at(String paramString)
  {
    this.occured_at = paramString;
  }

  public void setVars(Map<String, String> paramMap)
  {
    Iterator localIterator = new ArrayList(paramMap.keySet()).iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      CustomLogInfoBeanHelper localCustomLogInfoBeanHelper = new CustomLogInfoBeanHelper(str, (String)paramMap.get(str));
      this.vars.add(localCustomLogInfoBeanHelper);
    }
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.inauth.mme.beans.CustomLogInfoBean
 * JD-Core Version:    0.6.2
 */