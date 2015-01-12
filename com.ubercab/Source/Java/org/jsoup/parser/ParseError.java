package org.jsoup.parser;

public class ParseError
{
  private String errorMsg;
  private int pos;

  ParseError(int paramInt, String paramString)
  {
    this.pos = paramInt;
    this.errorMsg = paramString;
  }

  ParseError(int paramInt, String paramString, Object[] paramArrayOfObject)
  {
    this.errorMsg = String.format(paramString, paramArrayOfObject);
    this.pos = paramInt;
  }

  public String getErrorMessage()
  {
    return this.errorMsg;
  }

  public int getPosition()
  {
    return this.pos;
  }

  public String toString()
  {
    return this.pos + ": " + this.errorMsg;
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     org.jsoup.parser.ParseError
 * JD-Core Version:    0.6.2
 */