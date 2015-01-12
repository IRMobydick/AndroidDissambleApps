package com.mobileapptracker;

import java.util.HashMap;
import org.json.JSONObject;

public class MATEventItem
{
  public String attribute_sub1 = null;
  public String attribute_sub2 = null;
  public String attribute_sub3 = null;
  public String attribute_sub4 = null;
  public String attribute_sub5 = null;
  public String itemname = null;
  public int quantity = 0;
  public double revenue = 0.0D;
  public double unitPrice = 0.0D;

  public MATEventItem(String paramString, int paramInt, double paramDouble1, double paramDouble2)
  {
    this.itemname = paramString;
    this.quantity = paramInt;
    this.unitPrice = paramDouble1;
    this.revenue = paramDouble2;
  }

  public MATEventItem(String paramString1, int paramInt, double paramDouble1, double paramDouble2, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6)
  {
    this.itemname = paramString1;
    this.quantity = paramInt;
    this.unitPrice = paramDouble1;
    this.revenue = paramDouble2;
    this.attribute_sub1 = paramString2;
    this.attribute_sub2 = paramString3;
    this.attribute_sub3 = paramString4;
    this.attribute_sub4 = paramString5;
    this.attribute_sub5 = paramString6;
  }

  public MATEventItem(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6)
  {
    this.itemname = paramString1;
    this.attribute_sub1 = paramString2;
    this.attribute_sub2 = paramString3;
    this.attribute_sub3 = paramString4;
    this.attribute_sub4 = paramString5;
    this.attribute_sub5 = paramString6;
  }

  public String getAttrStringByName(String paramString)
  {
    if (paramString.equals("itemname"))
      return this.itemname;
    if (paramString.equals("quantity"))
      return Integer.toString(this.quantity);
    if (paramString.equals("unitPrice"))
      return Double.toString(this.unitPrice);
    if (paramString.equals("revenue"))
      return Double.toString(this.revenue);
    if (paramString.equals("attribute_sub1"))
      return this.attribute_sub1;
    if (paramString.equals("attribute_sub2"))
      return this.attribute_sub2;
    if (paramString.equals("attribute_sub3"))
      return this.attribute_sub3;
    if (paramString.equals("attribute_sub4"))
      return this.attribute_sub4;
    if (paramString.equals("attribute_sub5"))
      return this.attribute_sub5;
    return null;
  }

  public JSONObject toJSON()
  {
    HashMap localHashMap = new HashMap();
    if (this.itemname != null)
      localHashMap.put("item", this.itemname);
    localHashMap.put("quantity", Integer.toString(this.quantity));
    localHashMap.put("unit_price", Double.toString(this.unitPrice));
    localHashMap.put("revenue", Double.toString(this.revenue));
    if (this.attribute_sub1 != null)
      localHashMap.put("attribute_sub1", this.attribute_sub1);
    if (this.attribute_sub2 != null)
      localHashMap.put("attribute_sub2", this.attribute_sub2);
    if (this.attribute_sub3 != null)
      localHashMap.put("attribute_sub3", this.attribute_sub3);
    if (this.attribute_sub4 != null)
      localHashMap.put("attribute_sub4", this.attribute_sub4);
    if (this.attribute_sub5 != null)
      localHashMap.put("attribute_sub5", this.attribute_sub5);
    return new JSONObject(localHashMap);
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.mobileapptracker.MATEventItem
 * JD-Core Version:    0.6.2
 */