package a.a.a;

class ab
  implements Comparable
{
  private String a;
  private String b;
  private bd c;

  ab(String paramString1, String paramString2, bd parambd)
  {
    this.b = paramString2;
    this.a = paramString1;
    this.c = parambd;
  }

  public String a()
  {
    return this.a;
  }

  public int compareTo(Object paramObject)
  {
    return this.a.compareTo(((ab)paramObject).a);
  }

  public boolean equals(Object paramObject)
  {
    return this.a.equals(((ab)paramObject).a);
  }

  public int hashCode()
  {
    return this.a.hashCode();
  }
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     a.a.a.ab
 * JD-Core Version:    0.6.0
 */