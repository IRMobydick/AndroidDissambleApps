package com.google.android.gms.plus.model.moments;

import com.google.android.gms.common.data.Freezable;
import com.google.android.gms.internal.nu;
import com.google.android.gms.internal.nw;
import java.util.HashSet;
import java.util.Set;

public abstract interface Moment extends Freezable<Moment>
{
  public abstract String getId();

  public abstract ItemScope getResult();

  public abstract String getStartDate();

  public abstract ItemScope getTarget();

  public abstract String getType();

  public abstract boolean hasId();

  public abstract boolean hasResult();

  public abstract boolean hasStartDate();

  public abstract boolean hasTarget();

  public abstract boolean hasType();

  public static class Builder
  {
    private String BL;
    private String amP;
    private nu amX;
    private nu amY;
    private final Set<Integer> amc = new HashSet();
    private String uO;

    public Moment build()
    {
      return new nw(this.amc, this.BL, this.amX, this.amP, this.amY, this.uO);
    }

    public Builder setId(String paramString)
    {
      this.BL = paramString;
      this.amc.add(Integer.valueOf(2));
      return this;
    }

    public Builder setResult(ItemScope paramItemScope)
    {
      this.amX = ((nu)paramItemScope);
      this.amc.add(Integer.valueOf(4));
      return this;
    }

    public Builder setStartDate(String paramString)
    {
      this.amP = paramString;
      this.amc.add(Integer.valueOf(5));
      return this;
    }

    public Builder setTarget(ItemScope paramItemScope)
    {
      this.amY = ((nu)paramItemScope);
      this.amc.add(Integer.valueOf(6));
      return this;
    }

    public Builder setType(String paramString)
    {
      this.uO = paramString;
      this.amc.add(Integer.valueOf(7));
      return this;
    }
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.google.android.gms.plus.model.moments.Moment
 * JD-Core Version:    0.6.2
 */