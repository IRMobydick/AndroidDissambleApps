package com.baidu.mapapi.search.route;

import java.util.List;

public class DrivingRoutePlanOption
{
  PlanNode a = null;
  PlanNode b = null;
  DrivingPolicy c = DrivingPolicy.ECAR_TIME_FIRST;
  List<PlanNode> d = null;

  public DrivingRoutePlanOption from(PlanNode paramPlanNode)
  {
    this.a = paramPlanNode;
    return this;
  }

  public DrivingRoutePlanOption passBy(List<PlanNode> paramList)
  {
    this.d = paramList;
    return this;
  }

  public DrivingRoutePlanOption policy(DrivingPolicy paramDrivingPolicy)
  {
    this.c = paramDrivingPolicy;
    return this;
  }

  public DrivingRoutePlanOption to(PlanNode paramPlanNode)
  {
    this.b = paramPlanNode;
    return this;
  }

  public static enum DrivingPolicy
  {
    private int a;

    static
    {
      ECAR_DIS_FIRST = new DrivingPolicy("ECAR_DIS_FIRST", 2, 1);
      ECAR_FEE_FIRST = new DrivingPolicy("ECAR_FEE_FIRST", 3, 2);
      DrivingPolicy[] arrayOfDrivingPolicy = new DrivingPolicy[4];
      arrayOfDrivingPolicy[0] = ECAR_AVOID_JAM;
      arrayOfDrivingPolicy[1] = ECAR_TIME_FIRST;
      arrayOfDrivingPolicy[2] = ECAR_DIS_FIRST;
      arrayOfDrivingPolicy[3] = ECAR_FEE_FIRST;
    }

    private DrivingPolicy(int paramInt)
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
 * Qualified Name:     com.baidu.mapapi.search.route.DrivingRoutePlanOption
 * JD-Core Version:    0.6.2
 */