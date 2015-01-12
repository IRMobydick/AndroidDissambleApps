package org.jsoup.parser;

import java.util.HashMap;
import java.util.Map;
import org.jsoup.helper.Validate;

public class Tag
{
  private static final String[] blockTags;
  private static final String[] emptyTags;
  private static final String[] formListedTags;
  private static final String[] formSubmitTags;
  private static final String[] formatAsInlineTags;
  private static final String[] inlineTags;
  private static final String[] preserveWhitespaceTags;
  private static final Map<String, Tag> tags = new HashMap();
  private boolean canContainBlock = true;
  private boolean canContainInline = true;
  private boolean empty = false;
  private boolean formList = false;
  private boolean formSubmit = false;
  private boolean formatAsBlock = true;
  private boolean isBlock = true;
  private boolean preserveWhitespace = false;
  private boolean selfClosing = false;
  private String tagName;

  static
  {
    blockTags = new String[] { "html", "head", "body", "frameset", "script", "noscript", "style", "meta", "link", "title", "frame", "noframes", "section", "nav", "aside", "hgroup", "header", "footer", "p", "h1", "h2", "h3", "h4", "h5", "h6", "ul", "ol", "pre", "div", "blockquote", "hr", "address", "figure", "figcaption", "form", "fieldset", "ins", "del", "s", "dl", "dt", "dd", "li", "table", "caption", "thead", "tfoot", "tbody", "colgroup", "col", "tr", "th", "td", "video", "audio", "canvas", "details", "menu", "plaintext" };
    inlineTags = new String[] { "object", "base", "font", "tt", "i", "b", "u", "big", "small", "em", "strong", "dfn", "code", "samp", "kbd", "var", "cite", "abbr", "time", "acronym", "mark", "ruby", "rt", "rp", "a", "img", "br", "wbr", "map", "q", "sub", "sup", "bdo", "iframe", "embed", "span", "input", "select", "textarea", "label", "button", "optgroup", "option", "legend", "datalist", "keygen", "output", "progress", "meter", "area", "param", "source", "track", "summary", "command", "device" };
    emptyTags = new String[] { "meta", "link", "base", "frame", "img", "br", "wbr", "embed", "hr", "input", "keygen", "col", "command", "device" };
    formatAsInlineTags = new String[] { "title", "a", "p", "h1", "h2", "h3", "h4", "h5", "h6", "pre", "address", "li", "th", "td", "script", "style", "ins", "del", "s" };
    preserveWhitespaceTags = new String[] { "pre", "plaintext", "title", "textarea" };
    formListedTags = new String[] { "button", "fieldset", "input", "keygen", "object", "output", "select", "textarea" };
    formSubmitTags = new String[] { "input", "keygen", "object", "select", "textarea" };
    String[] arrayOfString1 = blockTags;
    int i = arrayOfString1.length;
    for (int j = 0; j < i; j++)
      register(new Tag(arrayOfString1[j]));
    String[] arrayOfString2 = inlineTags;
    int k = arrayOfString2.length;
    for (int m = 0; m < k; m++)
    {
      Tag localTag1 = new Tag(arrayOfString2[m]);
      localTag1.isBlock = false;
      localTag1.canContainBlock = false;
      localTag1.formatAsBlock = false;
      register(localTag1);
    }
    for (String str5 : emptyTags)
    {
      Tag localTag6 = (Tag)tags.get(str5);
      Validate.notNull(localTag6);
      localTag6.canContainBlock = false;
      localTag6.canContainInline = false;
      localTag6.empty = true;
    }
    for (String str4 : formatAsInlineTags)
    {
      Tag localTag5 = (Tag)tags.get(str4);
      Validate.notNull(localTag5);
      localTag5.formatAsBlock = false;
    }
    for (String str3 : preserveWhitespaceTags)
    {
      Tag localTag4 = (Tag)tags.get(str3);
      Validate.notNull(localTag4);
      localTag4.preserveWhitespace = true;
    }
    for (String str2 : formListedTags)
    {
      Tag localTag3 = (Tag)tags.get(str2);
      Validate.notNull(localTag3);
      localTag3.formList = true;
    }
    for (String str1 : formSubmitTags)
    {
      Tag localTag2 = (Tag)tags.get(str1);
      Validate.notNull(localTag2);
      localTag2.formSubmit = true;
    }
  }

  private Tag(String paramString)
  {
    this.tagName = paramString.toLowerCase();
  }

  public static boolean isKnownTag(String paramString)
  {
    return tags.containsKey(paramString);
  }

  private static void register(Tag paramTag)
  {
    tags.put(paramTag.tagName, paramTag);
  }

  public static Tag valueOf(String paramString)
  {
    Validate.notNull(paramString);
    Tag localTag = (Tag)tags.get(paramString);
    if (localTag == null)
    {
      String str = paramString.trim().toLowerCase();
      Validate.notEmpty(str);
      localTag = (Tag)tags.get(str);
      if (localTag == null)
      {
        localTag = new Tag(str);
        localTag.isBlock = false;
        localTag.canContainBlock = true;
      }
    }
    return localTag;
  }

  public boolean canContainBlock()
  {
    return this.canContainBlock;
  }

  public boolean equals(Object paramObject)
  {
    if (this == paramObject);
    Tag localTag;
    do
    {
      return true;
      if (!(paramObject instanceof Tag))
        return false;
      localTag = (Tag)paramObject;
      if (this.canContainBlock != localTag.canContainBlock)
        return false;
      if (this.canContainInline != localTag.canContainInline)
        return false;
      if (this.empty != localTag.empty)
        return false;
      if (this.formatAsBlock != localTag.formatAsBlock)
        return false;
      if (this.isBlock != localTag.isBlock)
        return false;
      if (this.preserveWhitespace != localTag.preserveWhitespace)
        return false;
      if (this.selfClosing != localTag.selfClosing)
        return false;
      if (this.formList != localTag.formList)
        return false;
      if (this.formSubmit != localTag.formSubmit)
        return false;
    }
    while (this.tagName.equals(localTag.tagName));
    return false;
  }

  public boolean formatAsBlock()
  {
    return this.formatAsBlock;
  }

  public String getName()
  {
    return this.tagName;
  }

  public int hashCode()
  {
    int i = 1;
    int j = 31 * this.tagName.hashCode();
    int k;
    int n;
    label40: int i2;
    label60: int i4;
    label80: int i6;
    label100: int i8;
    label120: int i10;
    label140: int i12;
    label160: int i13;
    if (this.isBlock)
    {
      k = i;
      int m = 31 * (j + k);
      if (!this.formatAsBlock)
        break label187;
      n = i;
      int i1 = 31 * (m + n);
      if (!this.canContainBlock)
        break label193;
      i2 = i;
      int i3 = 31 * (i1 + i2);
      if (!this.canContainInline)
        break label199;
      i4 = i;
      int i5 = 31 * (i3 + i4);
      if (!this.empty)
        break label205;
      i6 = i;
      int i7 = 31 * (i5 + i6);
      if (!this.selfClosing)
        break label211;
      i8 = i;
      int i9 = 31 * (i7 + i8);
      if (!this.preserveWhitespace)
        break label217;
      i10 = i;
      int i11 = 31 * (i9 + i10);
      if (!this.formList)
        break label223;
      i12 = i;
      i13 = 31 * (i11 + i12);
      if (!this.formSubmit)
        break label229;
    }
    while (true)
    {
      return i13 + i;
      k = 0;
      break;
      label187: n = 0;
      break label40;
      label193: i2 = 0;
      break label60;
      label199: i4 = 0;
      break label80;
      label205: i6 = 0;
      break label100;
      label211: i8 = 0;
      break label120;
      label217: i10 = 0;
      break label140;
      label223: i12 = 0;
      break label160;
      label229: i = 0;
    }
  }

  public boolean isBlock()
  {
    return this.isBlock;
  }

  public boolean isData()
  {
    return (!this.canContainInline) && (!isEmpty());
  }

  public boolean isEmpty()
  {
    return this.empty;
  }

  public boolean isFormListed()
  {
    return this.formList;
  }

  public boolean isFormSubmittable()
  {
    return this.formSubmit;
  }

  public boolean isInline()
  {
    return !this.isBlock;
  }

  public boolean isKnownTag()
  {
    return tags.containsKey(this.tagName);
  }

  public boolean isSelfClosing()
  {
    return (this.empty) || (this.selfClosing);
  }

  public boolean preserveWhitespace()
  {
    return this.preserveWhitespace;
  }

  Tag setSelfClosing()
  {
    this.selfClosing = true;
    return this;
  }

  public String toString()
  {
    return this.tagName;
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     org.jsoup.parser.Tag
 * JD-Core Version:    0.6.2
 */