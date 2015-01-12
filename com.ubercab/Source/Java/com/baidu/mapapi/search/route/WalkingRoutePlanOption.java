package com.baidu.mapapi.search.route;

public class WalkingRoutePlanOption
{
  PlanNode a = null;
  PlanNode b = null;

  public WalkingRoutePlanOption from(PlanNode paramPlanNode)
  {
    this.a = paramPlanNode;
    return this;
  }

  public WalkingRoutePlanOption to(PlanNode paramPlanNode)
  {
    this.b = paramPlanNode;
    return this;
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.baidu.mapapi.search.route.WalkingRoutePlanOption
 * JD-Core Version:    0.6.2
 */