package org.jsoup.nodes;

public class XmlDeclaration extends Node
{
  private static final String DECL_KEY = "declaration";
  private final boolean isProcessingInstruction;

  public XmlDeclaration(String paramString1, String paramString2, boolean paramBoolean)
  {
    super(paramString2);
    this.attributes.put("declaration", paramString1);
    this.isProcessingInstruction = paramBoolean;
  }

  public String getWholeDeclaration()
  {
    return this.attributes.get("declaration");
  }

  public String nodeName()
  {
    return "#declaration";
  }

  void outerHtmlHead(StringBuilder paramStringBuilder, int paramInt, Document.OutputSettings paramOutputSettings)
  {
    StringBuilder localStringBuilder = paramStringBuilder.append("<");
    if (this.isProcessingInstruction);
    for (String str = "!"; ; str = "?")
    {
      localStringBuilder.append(str).append(getWholeDeclaration()).append(">");
      return;
    }
  }

  void outerHtmlTail(StringBuilder paramStringBuilder, int paramInt, Document.OutputSettings paramOutputSettings)
  {
  }

  public String toString()
  {
    return outerHtml();
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     org.jsoup.nodes.XmlDeclaration
 * JD-Core Version:    0.6.2
 */