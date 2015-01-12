package org.jsoup.nodes;

import java.util.Map.Entry;
import org.jsoup.helper.Validate;

public class Attribute
  implements Map.Entry<String, String>, Cloneable
{
  private String key;
  private String value;

  public Attribute(String paramString1, String paramString2)
  {
    Validate.notEmpty(paramString1);
    Validate.notNull(paramString2);
    this.key = paramString1.trim().toLowerCase();
    this.value = paramString2;
  }

  public static Attribute createFromEncoded(String paramString1, String paramString2)
  {
    return new Attribute(paramString1, Entities.unescape(paramString2, true));
  }

  public Attribute clone()
  {
    try
    {
      Attribute localAttribute = (Attribute)super.clone();
      return localAttribute;
    }
    catch (CloneNotSupportedException localCloneNotSupportedException)
    {
      throw new RuntimeException(localCloneNotSupportedException);
    }
  }

  public boolean equals(Object paramObject)
  {
    if (this == paramObject);
    Attribute localAttribute;
    do
    {
      return true;
      if (!(paramObject instanceof Attribute))
        return false;
      localAttribute = (Attribute)paramObject;
      if (this.key != null)
      {
        if (this.key.equals(localAttribute.key));
      }
      else
        while (localAttribute.key != null)
          return false;
      if (this.value == null)
        break;
    }
    while (this.value.equals(localAttribute.value));
    while (true)
    {
      return false;
      if (localAttribute.value == null)
        break;
    }
  }

  public String getKey()
  {
    return this.key;
  }

  public String getValue()
  {
    return this.value;
  }

  public int hashCode()
  {
    if (this.key != null);
    for (int i = this.key.hashCode(); ; i = 0)
    {
      int j = i * 31;
      String str = this.value;
      int k = 0;
      if (str != null)
        k = this.value.hashCode();
      return j + k;
    }
  }

  public String html()
  {
    return this.key + "=\"" + Entities.escape(this.value, new Document("").outputSettings()) + "\"";
  }

  protected void html(StringBuilder paramStringBuilder, Document.OutputSettings paramOutputSettings)
  {
    paramStringBuilder.append(this.key).append("=\"").append(Entities.escape(this.value, paramOutputSettings)).append("\"");
  }

  protected boolean isDataAttribute()
  {
    return (this.key.startsWith("data-")) && (this.key.length() > "data-".length());
  }

  public void setKey(String paramString)
  {
    Validate.notEmpty(paramString);
    this.key = paramString.trim().toLowerCase();
  }

  public String setValue(String paramString)
  {
    Validate.notNull(paramString);
    String str = this.value;
    this.value = paramString;
    return str;
  }

  public String toString()
  {
    return html();
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     org.jsoup.nodes.Attribute
 * JD-Core Version:    0.6.2
 */