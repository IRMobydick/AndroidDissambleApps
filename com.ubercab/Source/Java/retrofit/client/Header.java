package retrofit.client;

public final class Header
{
  private final String name;
  private final String value;

  public Header(String paramString1, String paramString2)
  {
    this.name = paramString1;
    this.value = paramString2;
  }

  public boolean equals(Object paramObject)
  {
    if (this == paramObject);
    Header localHeader;
    do
    {
      return true;
      if ((paramObject == null) || (getClass() != paramObject.getClass()))
        return false;
      localHeader = (Header)paramObject;
      if (this.name != null)
      {
        if (this.name.equals(localHeader.name));
      }
      else
        while (localHeader.name != null)
          return false;
      if (this.value == null)
        break;
    }
    while (this.value.equals(localHeader.value));
    while (true)
    {
      return false;
      if (localHeader.value == null)
        break;
    }
  }

  public String getName()
  {
    return this.name;
  }

  public String getValue()
  {
    return this.value;
  }

  public int hashCode()
  {
    if (this.name != null);
    for (int i = this.name.hashCode(); ; i = 0)
    {
      int j = i * 31;
      String str = this.value;
      int k = 0;
      if (str != null)
        k = this.value.hashCode();
      return j + k;
    }
  }

  public String toString()
  {
    StringBuilder localStringBuilder1 = new StringBuilder();
    String str1;
    StringBuilder localStringBuilder2;
    if (this.name != null)
    {
      str1 = this.name;
      localStringBuilder2 = localStringBuilder1.append(str1).append(": ");
      if (this.value == null)
        break label60;
    }
    label60: for (String str2 = this.value; ; str2 = "")
    {
      return str2;
      str1 = "";
      break;
    }
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     retrofit.client.Header
 * JD-Core Version:    0.6.2
 */