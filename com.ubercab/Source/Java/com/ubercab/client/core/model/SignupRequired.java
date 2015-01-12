package com.ubercab.client.core.model;

import com.ubercab.common.base.Objects;
import java.util.Map;

public final class SignupRequired
{
  public Map<String, String> fields;

  public boolean equals(Object paramObject)
  {
    if (this == paramObject)
      return true;
    if ((paramObject == null) || (getClass() != paramObject.getClass()))
      return false;
    SignupRequired localSignupRequired = (SignupRequired)paramObject;
    return Objects.equal(this.fields, localSignupRequired.fields);
  }

  Map<String, String> getFields()
  {
    return this.fields;
  }

  public int hashCode()
  {
    int i = 31 * super.hashCode();
    if (this.fields != null);
    for (int j = this.fields.hashCode(); ; j = 0)
      return j + i;
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.client.core.model.SignupRequired
 * JD-Core Version:    0.6.2
 */