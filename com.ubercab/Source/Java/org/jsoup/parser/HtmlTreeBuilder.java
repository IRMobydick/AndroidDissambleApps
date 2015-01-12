package org.jsoup.parser;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import org.jsoup.helper.DescendableLinkedList;
import org.jsoup.helper.StringUtil;
import org.jsoup.helper.Validate;
import org.jsoup.nodes.Attributes;
import org.jsoup.nodes.Comment;
import org.jsoup.nodes.DataNode;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.nodes.FormElement;
import org.jsoup.nodes.Node;
import org.jsoup.nodes.TextNode;
import org.jsoup.select.Elements;

class HtmlTreeBuilder extends TreeBuilder
{
  private static final String[] TagSearchButton;
  private static final String[] TagSearchEndTags;
  private static final String[] TagSearchList;
  private static final String[] TagSearchSelectScope;
  private static final String[] TagSearchSpecial;
  private static final String[] TagSearchTableScope;
  private static final String[] TagsScriptStyle;
  public static final String[] TagsSearchInScope;
  private boolean baseUriSetFromDoc = false;
  private Element contextElement;
  private FormElement formElement;
  private DescendableLinkedList<Element> formattingElements = new DescendableLinkedList();
  private boolean fosterInserts = false;
  private boolean fragmentParsing = false;
  private boolean framesetOk = true;
  private Element headElement;
  private HtmlTreeBuilderState originalState;
  private List<Token.Character> pendingTableCharacters = new ArrayList();
  private HtmlTreeBuilderState state;

  static
  {
    if (!HtmlTreeBuilder.class.desiredAssertionStatus());
    for (boolean bool = true; ; bool = false)
    {
      $assertionsDisabled = bool;
      TagsScriptStyle = new String[] { "script", "style" };
      TagsSearchInScope = new String[] { "applet", "caption", "html", "table", "td", "th", "marquee", "object" };
      TagSearchList = new String[] { "ol", "ul" };
      TagSearchButton = new String[] { "button" };
      TagSearchTableScope = new String[] { "html", "table" };
      TagSearchSelectScope = new String[] { "optgroup", "option" };
      TagSearchEndTags = new String[] { "dd", "dt", "li", "option", "optgroup", "p", "rp", "rt" };
      TagSearchSpecial = new String[] { "address", "applet", "area", "article", "aside", "base", "basefont", "bgsound", "blockquote", "body", "br", "button", "caption", "center", "col", "colgroup", "command", "dd", "details", "dir", "div", "dl", "dt", "embed", "fieldset", "figcaption", "figure", "footer", "form", "frame", "frameset", "h1", "h2", "h3", "h4", "h5", "h6", "head", "header", "hgroup", "hr", "html", "iframe", "img", "input", "isindex", "li", "link", "listing", "marquee", "menu", "meta", "nav", "noembed", "noframes", "noscript", "object", "ol", "p", "param", "plaintext", "pre", "script", "section", "select", "style", "summary", "table", "tbody", "td", "textarea", "tfoot", "th", "thead", "title", "tr", "ul", "wbr", "xmp" };
      return;
    }
  }

  private void clearStackToContext(String[] paramArrayOfString)
  {
    Iterator localIterator = this.stack.descendingIterator();
    while (true)
    {
      if (localIterator.hasNext())
      {
        Element localElement = (Element)localIterator.next();
        if ((!StringUtil.in(localElement.nodeName(), paramArrayOfString)) && (!localElement.nodeName().equals("html")));
      }
      else
      {
        return;
      }
      localIterator.remove();
    }
  }

  private boolean inSpecificScope(String paramString, String[] paramArrayOfString1, String[] paramArrayOfString2)
  {
    return inSpecificScope(new String[] { paramString }, paramArrayOfString1, paramArrayOfString2);
  }

  private boolean inSpecificScope(String[] paramArrayOfString1, String[] paramArrayOfString2, String[] paramArrayOfString3)
  {
    Iterator localIterator = this.stack.descendingIterator();
    while (localIterator.hasNext())
    {
      String str = ((Element)localIterator.next()).nodeName();
      boolean bool2;
      if (StringUtil.in(str, paramArrayOfString1))
        bool2 = true;
      boolean bool1;
      do
      {
        return bool2;
        bool1 = StringUtil.in(str, paramArrayOfString2);
        bool2 = false;
      }
      while (bool1);
      if ((paramArrayOfString3 != null) && (StringUtil.in(str, paramArrayOfString3)))
        return false;
    }
    Validate.fail("Should not be reachable");
    return false;
  }

  private void insertNode(Node paramNode)
  {
    if (this.stack.size() == 0)
      this.doc.appendChild(paramNode);
    while (true)
    {
      if (((paramNode instanceof Element)) && (((Element)paramNode).tag().isFormListed()) && (this.formElement != null))
        this.formElement.addElement((Element)paramNode);
      return;
      if (isFosterInserts())
        insertInFosterParent(paramNode);
      else
        currentElement().appendChild(paramNode);
    }
  }

  private boolean isElementInQueue(DescendableLinkedList<Element> paramDescendableLinkedList, Element paramElement)
  {
    Iterator localIterator = paramDescendableLinkedList.descendingIterator();
    while (localIterator.hasNext())
      if ((Element)localIterator.next() == paramElement)
        return true;
    return false;
  }

  private boolean isSameFormattingElement(Element paramElement1, Element paramElement2)
  {
    return (paramElement1.nodeName().equals(paramElement2.nodeName())) && (paramElement1.attributes().equals(paramElement2.attributes()));
  }

  private void replaceInQueue(LinkedList<Element> paramLinkedList, Element paramElement1, Element paramElement2)
  {
    int i = paramLinkedList.lastIndexOf(paramElement1);
    if (i != -1);
    for (boolean bool = true; ; bool = false)
    {
      Validate.isTrue(bool);
      paramLinkedList.remove(i);
      paramLinkedList.add(i, paramElement2);
      return;
    }
  }

  Element aboveOnStack(Element paramElement)
  {
    assert (onStack(paramElement));
    Iterator localIterator = this.stack.descendingIterator();
    while (localIterator.hasNext())
      if ((Element)localIterator.next() == paramElement)
        return (Element)localIterator.next();
    return null;
  }

  void clearFormattingElementsToLastMarker()
  {
    Element localElement;
    do
    {
      if (this.formattingElements.isEmpty())
        break;
      localElement = (Element)this.formattingElements.peekLast();
      this.formattingElements.removeLast();
    }
    while (localElement != null);
  }

  void clearStackToTableBodyContext()
  {
    clearStackToContext(new String[] { "tbody", "tfoot", "thead" });
  }

  void clearStackToTableContext()
  {
    clearStackToContext(new String[] { "table" });
  }

  void clearStackToTableRowContext()
  {
    clearStackToContext(new String[] { "tr" });
  }

  void error(HtmlTreeBuilderState paramHtmlTreeBuilderState)
  {
    if (this.errors.canAddError())
    {
      ParseErrorList localParseErrorList = this.errors;
      int i = this.reader.pos();
      Object[] arrayOfObject = new Object[2];
      arrayOfObject[0] = this.currentToken.tokenType();
      arrayOfObject[1] = paramHtmlTreeBuilderState;
      localParseErrorList.add(new ParseError(i, "Unexpected token [%s] when in state [%s]", arrayOfObject));
    }
  }

  void framesetOk(boolean paramBoolean)
  {
    this.framesetOk = paramBoolean;
  }

  boolean framesetOk()
  {
    return this.framesetOk;
  }

  void generateImpliedEndTags()
  {
    generateImpliedEndTags(null);
  }

  void generateImpliedEndTags(String paramString)
  {
    while ((paramString != null) && (!currentElement().nodeName().equals(paramString)) && (StringUtil.in(currentElement().nodeName(), TagSearchEndTags)))
      pop();
  }

  Element getActiveFormattingElement(String paramString)
  {
    Iterator localIterator = this.formattingElements.descendingIterator();
    Element localElement;
    do
      if (localIterator.hasNext())
      {
        localElement = (Element)localIterator.next();
        if (localElement != null);
      }
      else
      {
        return null;
      }
    while (!localElement.nodeName().equals(paramString));
    return localElement;
  }

  String getBaseUri()
  {
    return this.baseUri;
  }

  Document getDocument()
  {
    return this.doc;
  }

  FormElement getFormElement()
  {
    return this.formElement;
  }

  Element getFromStack(String paramString)
  {
    Iterator localIterator = this.stack.descendingIterator();
    while (localIterator.hasNext())
    {
      Element localElement = (Element)localIterator.next();
      if (localElement.nodeName().equals(paramString))
        return localElement;
    }
    return null;
  }

  Element getHeadElement()
  {
    return this.headElement;
  }

  List<Token.Character> getPendingTableCharacters()
  {
    return this.pendingTableCharacters;
  }

  DescendableLinkedList<Element> getStack()
  {
    return this.stack;
  }

  boolean inButtonScope(String paramString)
  {
    return inScope(paramString, TagSearchButton);
  }

  boolean inListItemScope(String paramString)
  {
    return inScope(paramString, TagSearchList);
  }

  boolean inScope(String paramString)
  {
    return inScope(paramString, null);
  }

  boolean inScope(String paramString, String[] paramArrayOfString)
  {
    return inSpecificScope(paramString, TagsSearchInScope, paramArrayOfString);
  }

  boolean inScope(String[] paramArrayOfString)
  {
    return inSpecificScope(paramArrayOfString, TagsSearchInScope, null);
  }

  boolean inSelectScope(String paramString)
  {
    Iterator localIterator = this.stack.descendingIterator();
    while (localIterator.hasNext())
    {
      String str = ((Element)localIterator.next()).nodeName();
      if (str.equals(paramString))
        return true;
      if (!StringUtil.in(str, TagSearchSelectScope))
        return false;
    }
    Validate.fail("Should not be reachable");
    return false;
  }

  boolean inTableScope(String paramString)
  {
    return inSpecificScope(paramString, TagSearchTableScope, null);
  }

  Element insert(String paramString)
  {
    Element localElement = new Element(Tag.valueOf(paramString), this.baseUri);
    insert(localElement);
    return localElement;
  }

  Element insert(Token.StartTag paramStartTag)
  {
    if (paramStartTag.isSelfClosing())
    {
      Element localElement2 = insertEmpty(paramStartTag);
      this.stack.add(localElement2);
      this.tokeniser.transition(TokeniserState.Data);
      this.tokeniser.emit(new Token.EndTag(localElement2.tagName()));
      return localElement2;
    }
    Element localElement1 = new Element(Tag.valueOf(paramStartTag.name()), this.baseUri, paramStartTag.attributes);
    insert(localElement1);
    return localElement1;
  }

  void insert(Element paramElement)
  {
    insertNode(paramElement);
    this.stack.add(paramElement);
  }

  void insert(Token.Character paramCharacter)
  {
    if (StringUtil.in(currentElement().tagName(), TagsScriptStyle));
    for (Object localObject = new DataNode(paramCharacter.getData(), this.baseUri); ; localObject = new TextNode(paramCharacter.getData(), this.baseUri))
    {
      currentElement().appendChild((Node)localObject);
      return;
    }
  }

  void insert(Token.Comment paramComment)
  {
    insertNode(new Comment(paramComment.getData(), this.baseUri));
  }

  Element insertEmpty(Token.StartTag paramStartTag)
  {
    Tag localTag = Tag.valueOf(paramStartTag.name());
    Element localElement = new Element(localTag, this.baseUri, paramStartTag.attributes);
    insertNode(localElement);
    if (paramStartTag.isSelfClosing())
    {
      if (!localTag.isKnownTag())
        break label60;
      if (localTag.isSelfClosing())
        this.tokeniser.acknowledgeSelfClosingFlag();
    }
    return localElement;
    label60: localTag.setSelfClosing();
    this.tokeniser.acknowledgeSelfClosingFlag();
    return localElement;
  }

  FormElement insertForm(Token.StartTag paramStartTag, boolean paramBoolean)
  {
    FormElement localFormElement = new FormElement(Tag.valueOf(paramStartTag.name()), this.baseUri, paramStartTag.attributes);
    setFormElement(localFormElement);
    insertNode(localFormElement);
    if (paramBoolean)
      this.stack.add(localFormElement);
    return localFormElement;
  }

  void insertInFosterParent(Node paramNode)
  {
    Element localElement1 = getFromStack("table");
    Element localElement2;
    int i;
    if (localElement1 != null)
      if (localElement1.parent() != null)
      {
        localElement2 = localElement1.parent();
        i = 1;
      }
    while (i != 0)
    {
      Validate.notNull(localElement1);
      localElement1.before(paramNode);
      return;
      localElement2 = aboveOnStack(localElement1);
      i = 0;
      continue;
      localElement2 = (Element)this.stack.get(0);
      i = 0;
    }
    localElement2.appendChild(paramNode);
  }

  void insertMarkerToFormattingElements()
  {
    this.formattingElements.add(null);
  }

  void insertOnStackAfter(Element paramElement1, Element paramElement2)
  {
    int i = this.stack.lastIndexOf(paramElement1);
    if (i != -1);
    for (boolean bool = true; ; bool = false)
    {
      Validate.isTrue(bool);
      this.stack.add(i + 1, paramElement2);
      return;
    }
  }

  boolean isFosterInserts()
  {
    return this.fosterInserts;
  }

  boolean isFragmentParsing()
  {
    return this.fragmentParsing;
  }

  boolean isInActiveFormattingElements(Element paramElement)
  {
    return isElementInQueue(this.formattingElements, paramElement);
  }

  boolean isSpecial(Element paramElement)
  {
    return StringUtil.in(paramElement.nodeName(), TagSearchSpecial);
  }

  void markInsertionMode()
  {
    this.originalState = this.state;
  }

  void maybeSetBaseUri(Element paramElement)
  {
    if (this.baseUriSetFromDoc);
    String str;
    do
    {
      return;
      str = paramElement.absUrl("href");
    }
    while (str.length() == 0);
    this.baseUri = str;
    this.baseUriSetFromDoc = true;
    this.doc.setBaseUri(str);
  }

  void newPendingTableCharacters()
  {
    this.pendingTableCharacters = new ArrayList();
  }

  boolean onStack(Element paramElement)
  {
    return isElementInQueue(this.stack, paramElement);
  }

  HtmlTreeBuilderState originalState()
  {
    return this.originalState;
  }

  Document parse(String paramString1, String paramString2, ParseErrorList paramParseErrorList)
  {
    this.state = HtmlTreeBuilderState.Initial;
    return super.parse(paramString1, paramString2, paramParseErrorList);
  }

  List<Node> parseFragment(String paramString1, Element paramElement, String paramString2, ParseErrorList paramParseErrorList)
  {
    this.state = HtmlTreeBuilderState.Initial;
    initialiseParse(paramString1, paramString2, paramParseErrorList);
    this.contextElement = paramElement;
    this.fragmentParsing = true;
    Element localElement1 = null;
    String str;
    if (paramElement != null)
    {
      if (paramElement.ownerDocument() != null)
        this.doc.quirksMode(paramElement.ownerDocument().quirksMode());
      str = paramElement.tagName();
      if (!StringUtil.in(str, new String[] { "title", "textarea" }))
        break label203;
      this.tokeniser.transition(TokeniserState.Rcdata);
    }
    while (true)
    {
      localElement1 = new Element(Tag.valueOf("html"), paramString2);
      this.doc.appendChild(localElement1);
      this.stack.push(localElement1);
      resetInsertionMode();
      Elements localElements = paramElement.parents();
      localElements.add(0, paramElement);
      Iterator localIterator = localElements.iterator();
      while (localIterator.hasNext())
      {
        Element localElement2 = (Element)localIterator.next();
        if ((localElement2 instanceof FormElement))
          this.formElement = ((FormElement)localElement2);
      }
      runParser();
      if (paramElement == null)
        break;
      return localElement1.childNodes();
      label203: if (StringUtil.in(str, new String[] { "iframe", "noembed", "noframes", "style", "xmp" }))
        this.tokeniser.transition(TokeniserState.Rawtext);
      else if (str.equals("script"))
        this.tokeniser.transition(TokeniserState.ScriptData);
      else if (str.equals("noscript"))
        this.tokeniser.transition(TokeniserState.Data);
      else if (str.equals("plaintext"))
        this.tokeniser.transition(TokeniserState.Data);
      else
        this.tokeniser.transition(TokeniserState.Data);
    }
    return this.doc.childNodes();
  }

  Element pop()
  {
    if ((((Element)this.stack.peekLast()).nodeName().equals("td")) && (!this.state.name().equals("InCell")))
      Validate.isFalse(true, "pop td not in cell");
    if (((Element)this.stack.peekLast()).nodeName().equals("html"))
      Validate.isFalse(true, "popping html!");
    return (Element)this.stack.pollLast();
  }

  void popStackToBefore(String paramString)
  {
    Iterator localIterator = this.stack.descendingIterator();
    while (true)
    {
      if ((!localIterator.hasNext()) || (((Element)localIterator.next()).nodeName().equals(paramString)))
        return;
      localIterator.remove();
    }
  }

  void popStackToClose(String paramString)
  {
    Iterator localIterator = this.stack.descendingIterator();
    while (true)
    {
      if (localIterator.hasNext())
      {
        if (((Element)localIterator.next()).nodeName().equals(paramString))
          localIterator.remove();
      }
      else
        return;
      localIterator.remove();
    }
  }

  void popStackToClose(String[] paramArrayOfString)
  {
    Iterator localIterator = this.stack.descendingIterator();
    while (true)
    {
      if (localIterator.hasNext())
      {
        if (StringUtil.in(((Element)localIterator.next()).nodeName(), paramArrayOfString))
          localIterator.remove();
      }
      else
        return;
      localIterator.remove();
    }
  }

  protected boolean process(Token paramToken)
  {
    this.currentToken = paramToken;
    return this.state.process(paramToken, this);
  }

  boolean process(Token paramToken, HtmlTreeBuilderState paramHtmlTreeBuilderState)
  {
    this.currentToken = paramToken;
    return paramHtmlTreeBuilderState.process(paramToken, this);
  }

  void push(Element paramElement)
  {
    this.stack.add(paramElement);
  }

  void pushActiveFormattingElements(Element paramElement)
  {
    int i = 0;
    Iterator localIterator = this.formattingElements.descendingIterator();
    Element localElement;
    if (localIterator.hasNext())
    {
      localElement = (Element)localIterator.next();
      if (localElement != null)
        break label45;
    }
    while (true)
    {
      this.formattingElements.add(paramElement);
      return;
      label45: if (isSameFormattingElement(paramElement, localElement))
        i++;
      if (i != 3)
        break;
      localIterator.remove();
    }
  }

  void reconstructFormattingElements()
  {
    int i = this.formattingElements.size();
    if ((i == 0) || (this.formattingElements.getLast() == null) || (onStack((Element)this.formattingElements.getLast())))
      return;
    Element localElement1 = (Element)this.formattingElements.getLast();
    int j = i - 1;
    int k;
    if (j == 0)
      k = 1;
    while (true)
    {
      if (k == 0)
      {
        DescendableLinkedList localDescendableLinkedList2 = this.formattingElements;
        j++;
        localElement1 = (Element)localDescendableLinkedList2.get(j);
      }
      Validate.notNull(localElement1);
      Element localElement2 = insert(localElement1.nodeName());
      localElement2.attributes().addAll(localElement1.attributes());
      this.formattingElements.add(j, localElement2);
      this.formattingElements.remove(j + 1);
      int m = i - 1;
      k = 0;
      if (j == m)
      {
        return;
        DescendableLinkedList localDescendableLinkedList1 = this.formattingElements;
        j--;
        localElement1 = (Element)localDescendableLinkedList1.get(j);
        k = 0;
        if (localElement1 != null)
        {
          if (!onStack(localElement1))
            break;
          k = 0;
        }
      }
    }
  }

  void removeFromActiveFormattingElements(Element paramElement)
  {
    Iterator localIterator = this.formattingElements.descendingIterator();
    while (localIterator.hasNext())
      if ((Element)localIterator.next() == paramElement)
        localIterator.remove();
  }

  boolean removeFromStack(Element paramElement)
  {
    Iterator localIterator = this.stack.descendingIterator();
    while (localIterator.hasNext())
      if ((Element)localIterator.next() == paramElement)
      {
        localIterator.remove();
        return true;
      }
    return false;
  }

  void replaceActiveFormattingElement(Element paramElement1, Element paramElement2)
  {
    replaceInQueue(this.formattingElements, paramElement1, paramElement2);
  }

  void replaceOnStack(Element paramElement1, Element paramElement2)
  {
    replaceInQueue(this.stack, paramElement1, paramElement2);
  }

  void resetInsertionMode()
  {
    int i = 0;
    Iterator localIterator = this.stack.descendingIterator();
    do
    {
      String str;
      if (localIterator.hasNext())
      {
        Element localElement = (Element)localIterator.next();
        if (!localIterator.hasNext())
        {
          i = 1;
          localElement = this.contextElement;
        }
        str = localElement.nodeName();
        if ("select".equals(str))
          transition(HtmlTreeBuilderState.InSelect);
      }
      else
      {
        return;
      }
      if (("td".equals(str)) || (("td".equals(str)) && (i == 0)))
      {
        transition(HtmlTreeBuilderState.InCell);
        return;
      }
      if ("tr".equals(str))
      {
        transition(HtmlTreeBuilderState.InRow);
        return;
      }
      if (("tbody".equals(str)) || ("thead".equals(str)) || ("tfoot".equals(str)))
      {
        transition(HtmlTreeBuilderState.InTableBody);
        return;
      }
      if ("caption".equals(str))
      {
        transition(HtmlTreeBuilderState.InCaption);
        return;
      }
      if ("colgroup".equals(str))
      {
        transition(HtmlTreeBuilderState.InColumnGroup);
        return;
      }
      if ("table".equals(str))
      {
        transition(HtmlTreeBuilderState.InTable);
        return;
      }
      if ("head".equals(str))
      {
        transition(HtmlTreeBuilderState.InBody);
        return;
      }
      if ("body".equals(str))
      {
        transition(HtmlTreeBuilderState.InBody);
        return;
      }
      if ("frameset".equals(str))
      {
        transition(HtmlTreeBuilderState.InFrameset);
        return;
      }
      if ("html".equals(str))
      {
        transition(HtmlTreeBuilderState.BeforeHead);
        return;
      }
    }
    while (i == 0);
    transition(HtmlTreeBuilderState.InBody);
  }

  void setFormElement(FormElement paramFormElement)
  {
    this.formElement = paramFormElement;
  }

  void setFosterInserts(boolean paramBoolean)
  {
    this.fosterInserts = paramBoolean;
  }

  void setHeadElement(Element paramElement)
  {
    this.headElement = paramElement;
  }

  void setPendingTableCharacters(List<Token.Character> paramList)
  {
    this.pendingTableCharacters = paramList;
  }

  HtmlTreeBuilderState state()
  {
    return this.state;
  }

  public String toString()
  {
    return "TreeBuilder{currentToken=" + this.currentToken + ", state=" + this.state + ", currentElement=" + currentElement() + '}';
  }

  void transition(HtmlTreeBuilderState paramHtmlTreeBuilderState)
  {
    this.state = paramHtmlTreeBuilderState;
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     org.jsoup.parser.HtmlTreeBuilder
 * JD-Core Version:    0.6.2
 */