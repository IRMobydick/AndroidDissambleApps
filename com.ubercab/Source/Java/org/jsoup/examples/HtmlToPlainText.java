package org.jsoup.examples;

import java.io.IOException;
import java.io.PrintStream;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.helper.StringUtil;
import org.jsoup.helper.Validate;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.nodes.Node;
import org.jsoup.nodes.TextNode;
import org.jsoup.select.NodeTraversor;
import org.jsoup.select.NodeVisitor;

public class HtmlToPlainText
{
  public static void main(String[] paramArrayOfString)
    throws IOException
  {
    int i = 1;
    if (paramArrayOfString.length == i);
    while (true)
    {
      Validate.isTrue(i, "usage: supply url to fetch");
      Document localDocument = Jsoup.connect(paramArrayOfString[0]).get();
      String str = new HtmlToPlainText().getPlainText(localDocument);
      System.out.println(str);
      return;
      int j = 0;
    }
  }

  public String getPlainText(Element paramElement)
  {
    FormattingVisitor localFormattingVisitor = new FormattingVisitor(null);
    new NodeTraversor(localFormattingVisitor).traverse(paramElement);
    return localFormattingVisitor.toString();
  }

  private class FormattingVisitor
    implements NodeVisitor
  {
    private static final int maxWidth = 80;
    private StringBuilder accum = new StringBuilder();
    private int width = 0;

    private FormattingVisitor()
    {
    }

    private void append(String paramString)
    {
      if (paramString.startsWith("\n"))
        this.width = 0;
      if (paramString.equals(" "))
        if (this.accum.length() != 0)
        {
          if (!StringUtil.in(this.accum.substring(-1 + this.accum.length()), new String[] { " ", "\n" }));
        }
        else
          return;
      if (paramString.length() + this.width > 80)
      {
        String[] arrayOfString = paramString.split("\\s+");
        int i = 0;
        label94: String str;
        int j;
        if (i < arrayOfString.length)
        {
          str = arrayOfString[i];
          if (i != -1 + arrayOfString.length)
            break label191;
          j = 1;
          label119: if (j == 0)
            str = str + " ";
          if (str.length() + this.width <= 80)
            break label197;
          this.accum.append("\n").append(str);
        }
        for (this.width = str.length(); ; this.width += str.length())
        {
          i++;
          break label94;
          break;
          label191: j = 0;
          break label119;
          label197: this.accum.append(str);
        }
      }
      this.accum.append(paramString);
      this.width += paramString.length();
    }

    public void head(Node paramNode, int paramInt)
    {
      String str = paramNode.nodeName();
      if ((paramNode instanceof TextNode))
        append(((TextNode)paramNode).text());
      while (!str.equals("li"))
        return;
      append("\n * ");
    }

    public void tail(Node paramNode, int paramInt)
    {
      String str = paramNode.nodeName();
      if (str.equals("br"))
        append("\n");
      do
      {
        return;
        if (StringUtil.in(str, new String[] { "p", "h1", "h2", "h3", "h4", "h5" }))
        {
          append("\n\n");
          return;
        }
      }
      while (!str.equals("a"));
      Object[] arrayOfObject = new Object[1];
      arrayOfObject[0] = paramNode.absUrl("href");
      append(String.format(" <%s>", arrayOfObject));
    }

    public String toString()
    {
      return this.accum.toString();
    }
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     org.jsoup.examples.HtmlToPlainText
 * JD-Core Version:    0.6.2
 */