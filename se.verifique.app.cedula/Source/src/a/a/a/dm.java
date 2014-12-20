package a.a.a;

public final class dm
  implements Comparable
{
  public static final dm a = new dm(0);
  public static final dm b = new dm(1);
  public static final dm c = new dm(2);
  public static final dm d = new dm(3);
  private short e;

  private dm(int paramInt)
  {
    this.e = (short)paramInt;
  }

  public int compareTo(Object paramObject)
  {
    return this.e - ((dm)paramObject).e;
  }

  public boolean equals(Object paramObject)
  {
    int i = 0;
    if (!(paramObject instanceof dm));
    while (true)
    {
      return i;
      if (this.e != ((dm)paramObject).e)
        continue;
      i = 1;
    }
  }

  public int hashCode()
  {
    return super.hashCode();
  }

  public String toString()
  {
    String str;
    switch (this.e)
    {
    default:
      str = "?";
    case 0:
    case 1:
    case 2:
    case 3:
    }
    while (true)
    {
      return str;
      str = "SUMMARY";
      continue;
      str = "INFO";
      continue;
      str = "WARNING";
      continue;
      str = "ERROR";
    }
  }
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     a.a.a.dm
 * JD-Core Version:    0.6.0
 */