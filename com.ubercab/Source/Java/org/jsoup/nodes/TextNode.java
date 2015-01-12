package org.jsoup.nodes;

import java.util.List;
import org.jsoup.helper.StringUtil;
import org.jsoup.helper.Validate;
import org.jsoup.parser.Tag;

public class TextNode extends Node
{
  private static final String TEXT_KEY = "text";
  String text;

  public TextNode(String paramString1, String paramString2)
  {
    this.baseUri = paramString2;
    this.text = paramString1;
  }

  public static TextNode createFromEncoded(String paramString1, String paramString2)
  {
    return new TextNode(Entities.unescape(paramString1), paramString2);
  }

  private void ensureAttributes()
  {
    if (this.attributes == null)
    {
      this.attributes = new Attributes();
      this.attributes.put("text", this.text);
    }
  }

  static boolean lastCharIsWhitespace(StringBuilder paramStringBuilder)
  {
    return (paramStringBuilder.length() != 0) && (paramStringBuilder.charAt(-1 + paramStringBuilder.length()) == ' ');
  }

  static String normaliseWhitespace(String paramString)
  {
    return StringUtil.normaliseWhitespace(paramString);
  }

  static String stripLeadingWhitespace(String paramString)
  {
    return paramString.replaceFirst("^\\s+", "");
  }

  public String absUrl(String paramString)
  {
    ensureAttributes();
    return super.absUrl(paramString);
  }

  public String attr(String paramString)
  {
    ensureAttributes();
    return super.attr(paramString);
  }

  public Node attr(String paramString1, String paramString2)
  {
    ensureAttributes();
    return super.attr(paramString1, paramString2);
  }

  public Attributes attributes()
  {
    ensureAttributes();
    return super.attributes();
  }

  public String getWholeText()
  {
    if (this.attributes == null)
      return this.text;
    return this.attributes.get("text");
  }

  public boolean hasAttr(String paramString)
  {
    ensureAttributes();
    return super.hasAttr(paramString);
  }

  public boolean isBlank()
  {
    return StringUtil.isBlank(getWholeText());
  }

  public String nodeName()
  {
    return "#text";
  }

  void outerHtmlHead(StringBuilder paramStringBuilder, int paramInt, Document.OutputSettings paramOutputSettings)
  {
    String str = Entities.escape(getWholeText(), paramOutputSettings);
    if ((paramOutputSettings.prettyPrint()) && ((parent() instanceof Element)) && (!Element.preserveWhitespace((Element)parent())))
      str = normaliseWhitespace(str);
    if ((paramOutputSettings.prettyPrint()) && (((siblingIndex() == 0) && ((this.parentNode instanceof Element)) && (((Element)this.parentNode).tag().formatAsBlock()) && (!isBlank())) || ((paramOutputSettings.outline()) && (siblingNodes().size() > 0) && (!isBlank()))))
      indent(paramStringBuilder, paramInt, paramOutputSettings);
    paramStringBuilder.append(str);
  }

  void outerHtmlTail(StringBuilder paramStringBuilder, int paramInt, Document.OutputSettings paramOutputSettings)
  {
  }

  public Node removeAttr(String paramString)
  {
    ensureAttributes();
    return super.removeAttr(paramString);
  }

  public TextNode splitText(int paramInt)
  {
    boolean bool1;
    if (paramInt >= 0)
    {
      bool1 = true;
      Validate.isTrue(bool1, "Split offset must be not be negative");
      if (paramInt >= this.text.length())
        break label111;
    }
    label111: for (boolean bool2 = true; ; bool2 = false)
    {
      Validate.isTrue(bool2, "Split offset must not be greater than current text length");
      String str1 = getWholeText().substring(0, paramInt);
      String str2 = getWholeText().substring(paramInt);
      text(str1);
      TextNode localTextNode = new TextNode(str2, baseUri());
      if (parent() != null)
        parent().addChildren(1 + siblingIndex(), new Node[] { localTextNode });
      return localTextNode;
      bool1 = false;
      break;
    }
  }

  public String text()
  {
    return normaliseWhitespace(getWholeText());
  }

  public TextNode text(String paramString)
  {
    this.text = paramString;
    if (this.attributes != null)
      this.attributes.put("text", paramString);
    return this;
  }

  public String toString()
  {
    return outerHtml();
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     org.jsoup.nodes.TextNode
 * JD-Core Version:    0.6.2
 */