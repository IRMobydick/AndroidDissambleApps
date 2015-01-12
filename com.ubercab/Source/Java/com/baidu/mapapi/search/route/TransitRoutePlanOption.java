package com.baidu.mapapi.search.route;

public class TransitRoutePlanOption
{
  PlanNode a = null;
  PlanNode b = null;
  String c = null;
  TransitPolicy d = TransitPolicy.EBUS_TIME_FIRST;

  public TransitRoutePlanOption city(String paramString)
  {
    this.c = paramString;
    return this;
  }

  public TransitRoutePlanOption from(PlanNode paramPlanNode)
  {
    this.a = paramPlanNode;
    return this;
  }

  public TransitRoutePlanOption policy(TransitPolicy paramTransitPolicy)
  {
    this.d = paramTransitPolicy;
    return this;
  }

  public TransitRoutePlanOption to(PlanNode paramPlanNode)
  {
    this.b = paramPlanNode;
    return this;
  }

  public static enum TransitPolicy
  {
    private int a = 0;

    static
    {
      EBUS_NO_SUBWAY = new TransitPolicy("EBUS_NO_SUBWAY", 3, 6);
      TransitPolicy[] arrayOfTransitPolicy = new TransitPolicy[4];
      arrayOfTransitPolicy[0] = EBUS_TIME_FIRST;
      arrayOfTransitPolicy[1] = EBUS_TRANSFER_FIRST;
      arrayOfTransitPolicy[2] = EBUS_WALK_FIRST;
      arrayOfTransitPolicy[3] = EBUS_NO_SUBWAY;
    }

    private TransitPolicy(int paramInt)
    {
      this.a = paramInt;
    }

    public int getInt()
    {
      return this.a;
    }
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.baidu.mapapi.search.route.TransitRoutePlanOption
 * JD-Core Version:    0.6.2
 */