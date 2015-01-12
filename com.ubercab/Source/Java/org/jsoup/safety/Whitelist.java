package org.jsoup.safety;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import org.jsoup.helper.Validate;
import org.jsoup.nodes.Attribute;
import org.jsoup.nodes.Attributes;
import org.jsoup.nodes.Element;

public class Whitelist
{
  private Map<TagName, Set<AttributeKey>> attributes = new HashMap();
  private Map<TagName, Map<AttributeKey, AttributeValue>> enforcedAttributes = new HashMap();
  private boolean preserveRelativeLinks = false;
  private Map<TagName, Map<AttributeKey, Set<Protocol>>> protocols = new HashMap();
  private Set<TagName> tagNames = new HashSet();

  public static Whitelist basic()
  {
    return new Whitelist().addTags(new String[] { "a", "b", "blockquote", "br", "cite", "code", "dd", "dl", "dt", "em", "i", "li", "ol", "p", "pre", "q", "small", "strike", "strong", "sub", "sup", "u", "ul" }).addAttributes("a", new String[] { "href" }).addAttributes("blockquote", new String[] { "cite" }).addAttributes("q", new String[] { "cite" }).addProtocols("a", "href", new String[] { "ftp", "http", "https", "mailto" }).addProtocols("blockquote", "cite", new String[] { "http", "https" }).addProtocols("cite", "cite", new String[] { "http", "https" }).addEnforcedAttribute("a", "rel", "nofollow");
  }

  public static Whitelist basicWithImages()
  {
    return basic().addTags(new String[] { "img" }).addAttributes("img", new String[] { "align", "alt", "height", "src", "title", "width" }).addProtocols("img", "src", new String[] { "http", "https" });
  }

  public static Whitelist none()
  {
    return new Whitelist();
  }

  public static Whitelist relaxed()
  {
    return new Whitelist().addTags(new String[] { "a", "b", "blockquote", "br", "caption", "cite", "code", "col", "colgroup", "dd", "div", "dl", "dt", "em", "h1", "h2", "h3", "h4", "h5", "h6", "i", "img", "li", "ol", "p", "pre", "q", "small", "strike", "strong", "sub", "sup", "table", "tbody", "td", "tfoot", "th", "thead", "tr", "u", "ul" }).addAttributes("a", new String[] { "href", "title" }).addAttributes("blockquote", new String[] { "cite" }).addAttributes("col", new String[] { "span", "width" }).addAttributes("colgroup", new String[] { "span", "width" }).addAttributes("img", new String[] { "align", "alt", "height", "src", "title", "width" }).addAttributes("ol", new String[] { "start", "type" }).addAttributes("q", new String[] { "cite" }).addAttributes("table", new String[] { "summary", "width" }).addAttributes("td", new String[] { "abbr", "axis", "colspan", "rowspan", "width" }).addAttributes("th", new String[] { "abbr", "axis", "colspan", "rowspan", "scope", "width" }).addAttributes("ul", new String[] { "type" }).addProtocols("a", "href", new String[] { "ftp", "http", "https", "mailto" }).addProtocols("blockquote", "cite", new String[] { "http", "https" }).addProtocols("cite", "cite", new String[] { "http", "https" }).addProtocols("img", "src", new String[] { "http", "https" }).addProtocols("q", "cite", new String[] { "http", "https" });
  }

  public static Whitelist simpleText()
  {
    return new Whitelist().addTags(new String[] { "b", "em", "i", "strong", "u" });
  }

  private boolean testValidProtocol(Element paramElement, Attribute paramAttribute, Set<Protocol> paramSet)
  {
    String str1 = paramElement.absUrl(paramAttribute.getKey());
    if (str1.length() == 0)
      str1 = paramAttribute.getValue();
    if (!this.preserveRelativeLinks)
      paramAttribute.setValue(str1);
    Iterator localIterator = paramSet.iterator();
    while (localIterator.hasNext())
    {
      Protocol localProtocol = (Protocol)localIterator.next();
      String str2 = localProtocol.toString() + ":";
      if (str1.toLowerCase().startsWith(str2))
        return true;
    }
    return false;
  }

  public Whitelist addAttributes(String paramString, String[] paramArrayOfString)
  {
    Validate.notEmpty(paramString);
    Validate.notNull(paramArrayOfString);
    if (paramArrayOfString.length > 0);
    TagName localTagName;
    HashSet localHashSet;
    for (boolean bool = true; ; bool = false)
    {
      Validate.isTrue(bool, "No attributes supplied.");
      localTagName = TagName.valueOf(paramString);
      if (!this.tagNames.contains(localTagName))
        this.tagNames.add(localTagName);
      localHashSet = new HashSet();
      int i = paramArrayOfString.length;
      for (int j = 0; j < i; j++)
      {
        String str = paramArrayOfString[j];
        Validate.notEmpty(str);
        localHashSet.add(AttributeKey.valueOf(str));
      }
    }
    if (this.attributes.containsKey(localTagName))
    {
      ((Set)this.attributes.get(localTagName)).addAll(localHashSet);
      return this;
    }
    this.attributes.put(localTagName, localHashSet);
    return this;
  }

  public Whitelist addEnforcedAttribute(String paramString1, String paramString2, String paramString3)
  {
    Validate.notEmpty(paramString1);
    Validate.notEmpty(paramString2);
    Validate.notEmpty(paramString3);
    TagName localTagName = TagName.valueOf(paramString1);
    if (!this.tagNames.contains(localTagName))
      this.tagNames.add(localTagName);
    AttributeKey localAttributeKey = AttributeKey.valueOf(paramString2);
    AttributeValue localAttributeValue = AttributeValue.valueOf(paramString3);
    if (this.enforcedAttributes.containsKey(localTagName))
    {
      ((Map)this.enforcedAttributes.get(localTagName)).put(localAttributeKey, localAttributeValue);
      return this;
    }
    HashMap localHashMap = new HashMap();
    localHashMap.put(localAttributeKey, localAttributeValue);
    this.enforcedAttributes.put(localTagName, localHashMap);
    return this;
  }

  public Whitelist addProtocols(String paramString1, String paramString2, String[] paramArrayOfString)
  {
    Validate.notEmpty(paramString1);
    Validate.notEmpty(paramString2);
    Validate.notNull(paramArrayOfString);
    TagName localTagName = TagName.valueOf(paramString1);
    AttributeKey localAttributeKey = AttributeKey.valueOf(paramString2);
    Object localObject1;
    Object localObject2;
    if (this.protocols.containsKey(localTagName))
    {
      localObject1 = (Map)this.protocols.get(localTagName);
      if (!((Map)localObject1).containsKey(localAttributeKey))
        break label150;
      localObject2 = (Set)((Map)localObject1).get(localAttributeKey);
    }
    while (true)
    {
      int i = paramArrayOfString.length;
      for (int j = 0; j < i; j++)
      {
        String str = paramArrayOfString[j];
        Validate.notEmpty(str);
        ((Set)localObject2).add(Protocol.valueOf(str));
      }
      localObject1 = new HashMap();
      this.protocols.put(localTagName, localObject1);
      break;
      label150: localObject2 = new HashSet();
      ((Map)localObject1).put(localAttributeKey, localObject2);
    }
    return this;
  }

  public Whitelist addTags(String[] paramArrayOfString)
  {
    Validate.notNull(paramArrayOfString);
    int i = paramArrayOfString.length;
    for (int j = 0; j < i; j++)
    {
      String str = paramArrayOfString[j];
      Validate.notEmpty(str);
      this.tagNames.add(TagName.valueOf(str));
    }
    return this;
  }

  Attributes getEnforcedAttributes(String paramString)
  {
    Attributes localAttributes = new Attributes();
    TagName localTagName = TagName.valueOf(paramString);
    if (this.enforcedAttributes.containsKey(localTagName))
    {
      Iterator localIterator = ((Map)this.enforcedAttributes.get(localTagName)).entrySet().iterator();
      while (localIterator.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)localIterator.next();
        localAttributes.put(((AttributeKey)localEntry.getKey()).toString(), ((AttributeValue)localEntry.getValue()).toString());
      }
    }
    return localAttributes;
  }

  protected boolean isSafeAttribute(String paramString, Element paramElement, Attribute paramAttribute)
  {
    boolean bool1 = true;
    TagName localTagName = TagName.valueOf(paramString);
    AttributeKey localAttributeKey = AttributeKey.valueOf(paramAttribute.getKey());
    if ((this.attributes.containsKey(localTagName)) && (((Set)this.attributes.get(localTagName)).contains(localAttributeKey)))
      if (this.protocols.containsKey(localTagName))
      {
        localMap = (Map)this.protocols.get(localTagName);
        if ((localMap.containsKey(localAttributeKey)) && (!testValidProtocol(paramElement, paramAttribute, (Set)localMap.get(localAttributeKey))))
          break label130;
        bool2 = bool1;
        bool1 = bool2;
      }
    label130: 
    while ((!paramString.equals(":all")) && (isSafeAttribute(":all", paramElement, paramAttribute)))
      while (true)
      {
        Map localMap;
        return bool1;
        boolean bool2 = false;
      }
    return false;
  }

  protected boolean isSafeTag(String paramString)
  {
    return this.tagNames.contains(TagName.valueOf(paramString));
  }

  public Whitelist preserveRelativeLinks(boolean paramBoolean)
  {
    this.preserveRelativeLinks = paramBoolean;
    return this;
  }

  static class AttributeKey extends Whitelist.TypedValue
  {
    AttributeKey(String paramString)
    {
      super();
    }

    static AttributeKey valueOf(String paramString)
    {
      return new AttributeKey(paramString);
    }
  }

  static class AttributeValue extends Whitelist.TypedValue
  {
    AttributeValue(String paramString)
    {
      super();
    }

    static AttributeValue valueOf(String paramString)
    {
      return new AttributeValue(paramString);
    }
  }

  static class Protocol extends Whitelist.TypedValue
  {
    Protocol(String paramString)
    {
      super();
    }

    static Protocol valueOf(String paramString)
    {
      return new Protocol(paramString);
    }
  }

  static class TagName extends Whitelist.TypedValue
  {
    TagName(String paramString)
    {
      super();
    }

    static TagName valueOf(String paramString)
    {
      return new TagName(paramString);
    }
  }

  static abstract class TypedValue
  {
    private String value;

    TypedValue(String paramString)
    {
      Validate.notNull(paramString);
      this.value = paramString;
    }

    public boolean equals(Object paramObject)
    {
      if (this == paramObject);
      TypedValue localTypedValue;
      do
      {
        do
        {
          return true;
          if (paramObject == null)
            return false;
          if (getClass() != paramObject.getClass())
            return false;
          localTypedValue = (TypedValue)paramObject;
          if (this.value != null)
            break;
        }
        while (localTypedValue.value == null);
        return false;
      }
      while (this.value.equals(localTypedValue.value));
      return false;
    }

    public int hashCode()
    {
      if (this.value == null);
      for (int i = 0; ; i = this.value.hashCode())
        return i + 31;
    }

    public String toString()
    {
      return this.value;
    }
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     org.jsoup.safety.Whitelist
 * JD-Core Version:    0.6.2
 */