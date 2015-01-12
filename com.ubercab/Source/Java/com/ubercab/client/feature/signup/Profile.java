package com.ubercab.client.feature.signup;

import android.text.TextUtils;
import com.ubercab.common.collect.Iterables;
import java.util.LinkedHashSet;
import java.util.Set;

public class Profile
{
  private Set<String> mEmails = new LinkedHashSet();
  private Set<Name> mNames = new LinkedHashSet();
  private Set<Phone> mPhones = new LinkedHashSet();

  public void addEmail(String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
      this.mEmails.add(paramString);
  }

  public void addName(String paramString1, String paramString2)
  {
    this.mNames.add(new Name(paramString1, paramString2));
  }

  public void addPhone(String paramString1, String paramString2)
  {
    this.mPhones.add(new Phone(paramString1, paramString2));
  }

  public Set<String> getEmails()
  {
    return this.mEmails;
  }

  public Set<Name> getNames()
  {
    return this.mNames;
  }

  public Set<Phone> getPhones()
  {
    return this.mPhones;
  }

  public String getTopEmail()
  {
    return (String)Iterables.getFirst(this.mEmails, null);
  }

  public Name getTopName()
  {
    return (Name)Iterables.getFirst(this.mNames, null);
  }

  public Phone getTopPhone()
  {
    return (Phone)Iterables.getFirst(this.mPhones, null);
  }

  public static class Name
  {
    private String mFirstName;
    private String mLastName;

    public Name(String paramString1, String paramString2)
    {
      this.mFirstName = paramString1;
      this.mLastName = paramString2;
    }

    public boolean equals(Object paramObject)
    {
      if (this == paramObject);
      Name localName;
      do
      {
        return true;
        if ((paramObject == null) || (getClass() != paramObject.getClass()))
          return false;
        localName = (Name)paramObject;
        if (this.mFirstName != null)
        {
          if (this.mFirstName.equals(localName.mFirstName));
        }
        else
          while (localName.mFirstName != null)
            return false;
        if (this.mLastName == null)
          break;
      }
      while (this.mLastName.equals(localName.mLastName));
      while (true)
      {
        return false;
        if (localName.mLastName == null)
          break;
      }
    }

    public String getFirstName()
    {
      return this.mFirstName;
    }

    public String getLastName()
    {
      return this.mLastName;
    }

    public int hashCode()
    {
      if (this.mFirstName != null);
      for (int i = this.mFirstName.hashCode(); ; i = 0)
      {
        int j = i * 31;
        String str = this.mLastName;
        int k = 0;
        if (str != null)
          k = this.mLastName.hashCode();
        return j + k;
      }
    }
  }

  public static class Phone
  {
    public String mCountryIso2;
    public String mNumber;

    public Phone(String paramString1, String paramString2)
    {
      this.mNumber = paramString1;
      this.mCountryIso2 = paramString2;
    }

    public boolean equals(Object paramObject)
    {
      if (this == paramObject);
      Phone localPhone;
      do
      {
        return true;
        if ((paramObject == null) || (getClass() != paramObject.getClass()))
          return false;
        localPhone = (Phone)paramObject;
        if (this.mCountryIso2 != null)
        {
          if (this.mCountryIso2.equals(localPhone.mCountryIso2));
        }
        else
          while (localPhone.mCountryIso2 != null)
            return false;
        if (this.mNumber == null)
          break;
      }
      while (this.mNumber.equals(localPhone.mNumber));
      while (true)
      {
        return false;
        if (localPhone.mNumber == null)
          break;
      }
    }

    public String getCountryIso2()
    {
      return this.mCountryIso2;
    }

    public String getNumber()
    {
      return this.mNumber;
    }

    public int hashCode()
    {
      if (this.mNumber != null);
      for (int i = this.mNumber.hashCode(); ; i = 0)
      {
        int j = i * 31;
        String str = this.mCountryIso2;
        int k = 0;
        if (str != null)
          k = this.mCountryIso2.hashCode();
        return j + k;
      }
    }
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.client.feature.signup.Profile
 * JD-Core Version:    0.6.2
 */