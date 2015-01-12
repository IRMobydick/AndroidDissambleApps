package org.jsoup.parser;

import java.util.Iterator;
import java.util.List;
import org.jsoup.helper.DescendableLinkedList;
import org.jsoup.helper.Validate;
import org.jsoup.nodes.Comment;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.DocumentType;
import org.jsoup.nodes.Element;
import org.jsoup.nodes.Node;
import org.jsoup.nodes.TextNode;
import org.jsoup.nodes.XmlDeclaration;

public class XmlTreeBuilder extends TreeBuilder
{
  private void insertNode(Node paramNode)
  {
    currentElement().appendChild(paramNode);
  }

  private void popStackToClose(Token.EndTag paramEndTag)
  {
    String str = paramEndTag.name();
    Iterator localIterator1 = this.stack.descendingIterator();
    Element localElement;
    do
    {
      boolean bool = localIterator1.hasNext();
      localObject = null;
      if (!bool)
        break;
      localElement = (Element)localIterator1.next();
    }
    while (!localElement.nodeName().equals(str));
    Object localObject = localElement;
    if (localObject == null);
    while (true)
    {
      return;
      Iterator localIterator2 = this.stack.descendingIterator();
      while (localIterator2.hasNext())
      {
        if ((Element)localIterator2.next() == localObject)
        {
          localIterator2.remove();
          return;
        }
        localIterator2.remove();
      }
    }
  }

  protected void initialiseParse(String paramString1, String paramString2, ParseErrorList paramParseErrorList)
  {
    super.initialiseParse(paramString1, paramString2, paramParseErrorList);
    this.stack.add(this.doc);
  }

  Element insert(Token.StartTag paramStartTag)
  {
    Tag localTag = Tag.valueOf(paramStartTag.name());
    Element localElement = new Element(localTag, this.baseUri, paramStartTag.attributes);
    insertNode(localElement);
    if (paramStartTag.isSelfClosing())
    {
      this.tokeniser.acknowledgeSelfClosingFlag();
      if (!localTag.isKnownTag())
        localTag.setSelfClosing();
      return localElement;
    }
    this.stack.add(localElement);
    return localElement;
  }

  void insert(Token.Character paramCharacter)
  {
    insertNode(new TextNode(paramCharacter.getData(), this.baseUri));
  }

  void insert(Token.Comment paramComment)
  {
    Comment localComment = new Comment(paramComment.getData(), this.baseUri);
    Object localObject = localComment;
    if (paramComment.bogus)
    {
      String str = localComment.getData();
      if ((str.length() > 1) && ((str.startsWith("!")) || (str.startsWith("?"))))
        localObject = new XmlDeclaration(str.substring(1), localComment.baseUri(), str.startsWith("!"));
    }
    insertNode((Node)localObject);
  }

  void insert(Token.Doctype paramDoctype)
  {
    insertNode(new DocumentType(paramDoctype.getName(), paramDoctype.getPublicIdentifier(), paramDoctype.getSystemIdentifier(), this.baseUri));
  }

  List<Node> parseFragment(String paramString1, String paramString2, ParseErrorList paramParseErrorList)
  {
    initialiseParse(paramString1, paramString2, paramParseErrorList);
    runParser();
    return this.doc.childNodes();
  }

  protected boolean process(Token paramToken)
  {
    switch (1.$SwitchMap$org$jsoup$parser$Token$TokenType[paramToken.type.ordinal()])
    {
    default:
      Validate.fail("Unexpected token type: " + paramToken.type);
    case 6:
    case 1:
    case 2:
    case 3:
    case 4:
    case 5:
    }
    while (true)
    {
      return true;
      insert(paramToken.asStartTag());
      continue;
      popStackToClose(paramToken.asEndTag());
      continue;
      insert(paramToken.asComment());
      continue;
      insert(paramToken.asCharacter());
      continue;
      insert(paramToken.asDoctype());
    }
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     org.jsoup.parser.XmlTreeBuilder
 * JD-Core Version:    0.6.2
 */