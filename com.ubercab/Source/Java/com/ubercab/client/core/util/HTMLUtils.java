package com.ubercab.client.core.util;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.nodes.Node;
import org.jsoup.select.Elements;

public final class HTMLUtils
{
  private static Node findBodyElement(Document paramDocument)
  {
    Elements localElements = paramDocument.select("body");
    if (localElements == null)
      return null;
    return localElements.get(0);
  }

  private static Node findImageElement(Document paramDocument, String paramString)
  {
    Elements localElements = paramDocument.select("img[src=" + paramString + "]");
    if ((localElements == null) || (localElements.isEmpty()))
      return null;
    return localElements.get(0);
  }

  private static Document getDocumentFromHtml(String paramString)
  {
    return Jsoup.parse(paramString);
  }

  public static String removeImage(String paramString1, String paramString2)
  {
    Document localDocument = getDocumentFromHtml(paramString1);
    Node localNode = findImageElement(localDocument, paramString2);
    if (localNode != null)
      localNode.remove();
    return localDocument.html();
  }

  public static String setTransparentBackground(String paramString)
  {
    Document localDocument = getDocumentFromHtml(paramString);
    Element localElement = (Element)findBodyElement(localDocument);
    if (!localElement.hasAttr("style"))
      return paramString;
    localDocument.head().append("<style> .no-background {background-image: none !important; background-color:transparent !important;} </style>");
    localElement.addClass("no-background");
    return localDocument.html();
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.client.core.util.HTMLUtils
 * JD-Core Version:    0.6.2
 */