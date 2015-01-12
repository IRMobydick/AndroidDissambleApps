package com.adjust.sdk;

public enum ActivityKind
{
  static
  {
    SESSION = new ActivityKind("SESSION", 1);
    EVENT = new ActivityKind("EVENT", 2);
    REVENUE = new ActivityKind("REVENUE", 3);
    REATTRIBUTION = new ActivityKind("REATTRIBUTION", 4);
    ActivityKind[] arrayOfActivityKind = new ActivityKind[5];
    arrayOfActivityKind[0] = UNKNOWN;
    arrayOfActivityKind[1] = SESSION;
    arrayOfActivityKind[2] = EVENT;
    arrayOfActivityKind[3] = REVENUE;
    arrayOfActivityKind[4] = REATTRIBUTION;
  }

  public static ActivityKind fromString(String paramString)
  {
    if ("session".equals(paramString))
      return SESSION;
    if ("event".equals(paramString))
      return EVENT;
    if ("revenue".equals(paramString))
      return REVENUE;
    if ("reattribution".equals(paramString))
      return REATTRIBUTION;
    return UNKNOWN;
  }

  public String toString()
  {
    switch (1.$SwitchMap$com$adjust$sdk$ActivityKind[ordinal()])
    {
    default:
      return "unknown";
    case 1:
      return "session";
    case 2:
      return "event";
    case 3:
      return "revenue";
    case 4:
    }
    return "reattribution";
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.adjust.sdk.ActivityKind
 * JD-Core Version:    0.6.2
 */