package org.jsoup.nodes;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;
import org.jsoup.helper.StringUtil;
import org.jsoup.helper.Validate;
import org.jsoup.parser.Parser;
import org.jsoup.parser.Tag;
import org.jsoup.select.Collector;
import org.jsoup.select.Elements;
import org.jsoup.select.Evaluator.AllElements;
import org.jsoup.select.Evaluator.Attribute;
import org.jsoup.select.Evaluator.AttributeStarting;
import org.jsoup.select.Evaluator.AttributeWithValue;
import org.jsoup.select.Evaluator.AttributeWithValueContaining;
import org.jsoup.select.Evaluator.AttributeWithValueEnding;
import org.jsoup.select.Evaluator.AttributeWithValueMatching;
import org.jsoup.select.Evaluator.AttributeWithValueNot;
import org.jsoup.select.Evaluator.AttributeWithValueStarting;
import org.jsoup.select.Evaluator.Class;
import org.jsoup.select.Evaluator.ContainsOwnText;
import org.jsoup.select.Evaluator.ContainsText;
import org.jsoup.select.Evaluator.Id;
import org.jsoup.select.Evaluator.IndexEquals;
import org.jsoup.select.Evaluator.IndexGreaterThan;
import org.jsoup.select.Evaluator.IndexLessThan;
import org.jsoup.select.Evaluator.Matches;
import org.jsoup.select.Evaluator.MatchesOwn;
import org.jsoup.select.Evaluator.Tag;
import org.jsoup.select.NodeTraversor;
import org.jsoup.select.NodeVisitor;
import org.jsoup.select.Selector;

public class Element extends Node
{
  private Set<String> classNames;
  private Tag tag;

  public Element(Tag paramTag, String paramString)
  {
    this(paramTag, paramString, new Attributes());
  }

  public Element(Tag paramTag, String paramString, Attributes paramAttributes)
  {
    super(paramString, paramAttributes);
    Validate.notNull(paramTag);
    this.tag = paramTag;
  }

  private static void accumulateParents(Element paramElement, Elements paramElements)
  {
    Element localElement = paramElement.parent();
    if ((localElement != null) && (!localElement.tagName().equals("#root")))
    {
      paramElements.add(localElement);
      accumulateParents(localElement, paramElements);
    }
  }

  private static void appendNormalisedText(StringBuilder paramStringBuilder, TextNode paramTextNode)
  {
    String str = paramTextNode.getWholeText();
    if (!preserveWhitespace(paramTextNode.parent()))
    {
      str = TextNode.normaliseWhitespace(str);
      if (TextNode.lastCharIsWhitespace(paramStringBuilder))
        str = TextNode.stripLeadingWhitespace(str);
    }
    paramStringBuilder.append(str);
  }

  private static void appendWhitespaceIfBr(Element paramElement, StringBuilder paramStringBuilder)
  {
    if ((paramElement.tag.getName().equals("br")) && (!TextNode.lastCharIsWhitespace(paramStringBuilder)))
      paramStringBuilder.append(" ");
  }

  private void html(StringBuilder paramStringBuilder)
  {
    Iterator localIterator = this.childNodes.iterator();
    while (localIterator.hasNext())
      ((Node)localIterator.next()).outerHtml(paramStringBuilder);
  }

  private static <E extends Element> Integer indexInList(Element paramElement, List<E> paramList)
  {
    Validate.notNull(paramElement);
    Validate.notNull(paramList);
    for (int i = 0; i < paramList.size(); i++)
      if (((Element)paramList.get(i)).equals(paramElement))
        return Integer.valueOf(i);
    return null;
  }

  private void ownText(StringBuilder paramStringBuilder)
  {
    Iterator localIterator = this.childNodes.iterator();
    while (localIterator.hasNext())
    {
      Node localNode = (Node)localIterator.next();
      if ((localNode instanceof TextNode))
        appendNormalisedText(paramStringBuilder, (TextNode)localNode);
      else if ((localNode instanceof Element))
        appendWhitespaceIfBr((Element)localNode, paramStringBuilder);
    }
  }

  static boolean preserveWhitespace(Node paramNode)
  {
    boolean bool1 = false;
    if (paramNode != null)
    {
      boolean bool2 = paramNode instanceof Element;
      bool1 = false;
      if (bool2)
      {
        Element localElement1 = (Element)paramNode;
        if (!localElement1.tag.preserveWhitespace())
        {
          Element localElement2 = localElement1.parent();
          bool1 = false;
          if (localElement2 != null)
          {
            boolean bool3 = localElement1.parent().tag.preserveWhitespace();
            bool1 = false;
            if (!bool3);
          }
        }
        else
        {
          bool1 = true;
        }
      }
    }
    return bool1;
  }

  public Element addClass(String paramString)
  {
    Validate.notNull(paramString);
    Set localSet = classNames();
    localSet.add(paramString);
    classNames(localSet);
    return this;
  }

  public Element after(String paramString)
  {
    return (Element)super.after(paramString);
  }

  public Element after(Node paramNode)
  {
    return (Element)super.after(paramNode);
  }

  public Element append(String paramString)
  {
    Validate.notNull(paramString);
    List localList = Parser.parseFragment(paramString, this, baseUri());
    addChildren((Node[])localList.toArray(new Node[localList.size()]));
    return this;
  }

  public Element appendChild(Node paramNode)
  {
    Validate.notNull(paramNode);
    addChildren(new Node[] { paramNode });
    return this;
  }

  public Element appendElement(String paramString)
  {
    Element localElement = new Element(Tag.valueOf(paramString), baseUri());
    appendChild(localElement);
    return localElement;
  }

  public Element appendText(String paramString)
  {
    appendChild(new TextNode(paramString, baseUri()));
    return this;
  }

  public Element attr(String paramString1, String paramString2)
  {
    super.attr(paramString1, paramString2);
    return this;
  }

  public Element before(String paramString)
  {
    return (Element)super.before(paramString);
  }

  public Element before(Node paramNode)
  {
    return (Element)super.before(paramNode);
  }

  public Element child(int paramInt)
  {
    return children().get(paramInt);
  }

  public Elements children()
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.childNodes.iterator();
    while (localIterator.hasNext())
    {
      Node localNode = (Node)localIterator.next();
      if ((localNode instanceof Element))
        localArrayList.add((Element)localNode);
    }
    return new Elements(localArrayList);
  }

  public String className()
  {
    return attr("class");
  }

  public Set<String> classNames()
  {
    if (this.classNames == null)
      this.classNames = new LinkedHashSet(Arrays.asList(className().split("\\s+")));
    return this.classNames;
  }

  public Element classNames(Set<String> paramSet)
  {
    Validate.notNull(paramSet);
    this.attributes.put("class", StringUtil.join(paramSet, " "));
    return this;
  }

  public Element clone()
  {
    Element localElement = (Element)super.clone();
    localElement.classNames = null;
    return localElement;
  }

  public String data()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    Iterator localIterator = this.childNodes.iterator();
    while (localIterator.hasNext())
    {
      Node localNode = (Node)localIterator.next();
      if ((localNode instanceof DataNode))
        localStringBuilder.append(((DataNode)localNode).getWholeData());
      else if ((localNode instanceof Element))
        localStringBuilder.append(((Element)localNode).data());
    }
    return localStringBuilder.toString();
  }

  public List<DataNode> dataNodes()
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.childNodes.iterator();
    while (localIterator.hasNext())
    {
      Node localNode = (Node)localIterator.next();
      if ((localNode instanceof DataNode))
        localArrayList.add((DataNode)localNode);
    }
    return Collections.unmodifiableList(localArrayList);
  }

  public Map<String, String> dataset()
  {
    return this.attributes.dataset();
  }

  public Integer elementSiblingIndex()
  {
    if (parent() == null)
      return Integer.valueOf(0);
    return indexInList(this, parent().children());
  }

  public Element empty()
  {
    this.childNodes.clear();
    return this;
  }

  public boolean equals(Object paramObject)
  {
    return this == paramObject;
  }

  public Element firstElementSibling()
  {
    Elements localElements = parent().children();
    if (localElements.size() > 1)
      return (Element)localElements.get(0);
    return null;
  }

  public Elements getAllElements()
  {
    return Collector.collect(new Evaluator.AllElements(), this);
  }

  public Element getElementById(String paramString)
  {
    Validate.notEmpty(paramString);
    Elements localElements = Collector.collect(new Evaluator.Id(paramString), this);
    if (localElements.size() > 0)
      return localElements.get(0);
    return null;
  }

  public Elements getElementsByAttribute(String paramString)
  {
    Validate.notEmpty(paramString);
    return Collector.collect(new Evaluator.Attribute(paramString.trim().toLowerCase()), this);
  }

  public Elements getElementsByAttributeStarting(String paramString)
  {
    Validate.notEmpty(paramString);
    return Collector.collect(new Evaluator.AttributeStarting(paramString.trim().toLowerCase()), this);
  }

  public Elements getElementsByAttributeValue(String paramString1, String paramString2)
  {
    return Collector.collect(new Evaluator.AttributeWithValue(paramString1, paramString2), this);
  }

  public Elements getElementsByAttributeValueContaining(String paramString1, String paramString2)
  {
    return Collector.collect(new Evaluator.AttributeWithValueContaining(paramString1, paramString2), this);
  }

  public Elements getElementsByAttributeValueEnding(String paramString1, String paramString2)
  {
    return Collector.collect(new Evaluator.AttributeWithValueEnding(paramString1, paramString2), this);
  }

  public Elements getElementsByAttributeValueMatching(String paramString1, String paramString2)
  {
    try
    {
      Pattern localPattern = Pattern.compile(paramString2);
      return getElementsByAttributeValueMatching(paramString1, localPattern);
    }
    catch (PatternSyntaxException localPatternSyntaxException)
    {
      throw new IllegalArgumentException("Pattern syntax error: " + paramString2, localPatternSyntaxException);
    }
  }

  public Elements getElementsByAttributeValueMatching(String paramString, Pattern paramPattern)
  {
    return Collector.collect(new Evaluator.AttributeWithValueMatching(paramString, paramPattern), this);
  }

  public Elements getElementsByAttributeValueNot(String paramString1, String paramString2)
  {
    return Collector.collect(new Evaluator.AttributeWithValueNot(paramString1, paramString2), this);
  }

  public Elements getElementsByAttributeValueStarting(String paramString1, String paramString2)
  {
    return Collector.collect(new Evaluator.AttributeWithValueStarting(paramString1, paramString2), this);
  }

  public Elements getElementsByClass(String paramString)
  {
    Validate.notEmpty(paramString);
    return Collector.collect(new Evaluator.Class(paramString), this);
  }

  public Elements getElementsByIndexEquals(int paramInt)
  {
    return Collector.collect(new Evaluator.IndexEquals(paramInt), this);
  }

  public Elements getElementsByIndexGreaterThan(int paramInt)
  {
    return Collector.collect(new Evaluator.IndexGreaterThan(paramInt), this);
  }

  public Elements getElementsByIndexLessThan(int paramInt)
  {
    return Collector.collect(new Evaluator.IndexLessThan(paramInt), this);
  }

  public Elements getElementsByTag(String paramString)
  {
    Validate.notEmpty(paramString);
    return Collector.collect(new Evaluator.Tag(paramString.toLowerCase().trim()), this);
  }

  public Elements getElementsContainingOwnText(String paramString)
  {
    return Collector.collect(new Evaluator.ContainsOwnText(paramString), this);
  }

  public Elements getElementsContainingText(String paramString)
  {
    return Collector.collect(new Evaluator.ContainsText(paramString), this);
  }

  public Elements getElementsMatchingOwnText(String paramString)
  {
    try
    {
      Pattern localPattern = Pattern.compile(paramString);
      return getElementsMatchingOwnText(localPattern);
    }
    catch (PatternSyntaxException localPatternSyntaxException)
    {
      throw new IllegalArgumentException("Pattern syntax error: " + paramString, localPatternSyntaxException);
    }
  }

  public Elements getElementsMatchingOwnText(Pattern paramPattern)
  {
    return Collector.collect(new Evaluator.MatchesOwn(paramPattern), this);
  }

  public Elements getElementsMatchingText(String paramString)
  {
    try
    {
      Pattern localPattern = Pattern.compile(paramString);
      return getElementsMatchingText(localPattern);
    }
    catch (PatternSyntaxException localPatternSyntaxException)
    {
      throw new IllegalArgumentException("Pattern syntax error: " + paramString, localPatternSyntaxException);
    }
  }

  public Elements getElementsMatchingText(Pattern paramPattern)
  {
    return Collector.collect(new Evaluator.Matches(paramPattern), this);
  }

  public boolean hasClass(String paramString)
  {
    Iterator localIterator = classNames().iterator();
    while (localIterator.hasNext())
      if (paramString.equalsIgnoreCase((String)localIterator.next()))
        return true;
    return false;
  }

  public boolean hasText()
  {
    Iterator localIterator = this.childNodes.iterator();
    while (localIterator.hasNext())
    {
      Node localNode = (Node)localIterator.next();
      if ((localNode instanceof TextNode))
      {
        if (!((TextNode)localNode).isBlank())
          return true;
      }
      else if (((localNode instanceof Element)) && (((Element)localNode).hasText()))
        return true;
    }
    return false;
  }

  public int hashCode()
  {
    int i = 31 * super.hashCode();
    if (this.tag != null);
    for (int j = this.tag.hashCode(); ; j = 0)
      return i + j;
  }

  public String html()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    html(localStringBuilder);
    return localStringBuilder.toString().trim();
  }

  public Element html(String paramString)
  {
    empty();
    append(paramString);
    return this;
  }

  public String id()
  {
    String str = attr("id");
    if (str == null)
      str = "";
    return str;
  }

  public Element insertChildren(int paramInt, Collection<? extends Node> paramCollection)
  {
    Validate.notNull(paramCollection, "Children collection to be inserted must not be null.");
    int i = childNodeSize();
    if (paramInt < 0)
      paramInt += i + 1;
    if ((paramInt >= 0) && (paramInt <= i));
    for (boolean bool = true; ; bool = false)
    {
      Validate.isTrue(bool, "Insert position out of bounds.");
      ArrayList localArrayList = new ArrayList(paramCollection);
      addChildren(paramInt, (Node[])localArrayList.toArray(new Node[localArrayList.size()]));
      return this;
    }
  }

  public boolean isBlock()
  {
    return this.tag.isBlock();
  }

  public Element lastElementSibling()
  {
    Elements localElements = parent().children();
    if (localElements.size() > 1)
      return (Element)localElements.get(-1 + localElements.size());
    return null;
  }

  public Element nextElementSibling()
  {
    if (this.parentNode == null);
    Elements localElements;
    Integer localInteger;
    do
    {
      return null;
      localElements = parent().children();
      localInteger = indexInList(this, localElements);
      Validate.notNull(localInteger);
    }
    while (localElements.size() <= 1 + localInteger.intValue());
    return (Element)localElements.get(1 + localInteger.intValue());
  }

  public String nodeName()
  {
    return this.tag.getName();
  }

  void outerHtmlHead(StringBuilder paramStringBuilder, int paramInt, Document.OutputSettings paramOutputSettings)
  {
    if ((paramStringBuilder.length() > 0) && (paramOutputSettings.prettyPrint()) && ((this.tag.formatAsBlock()) || ((parent() != null) && (parent().tag().formatAsBlock())) || (paramOutputSettings.outline())))
      indent(paramStringBuilder, paramInt, paramOutputSettings);
    paramStringBuilder.append("<").append(tagName());
    this.attributes.html(paramStringBuilder, paramOutputSettings);
    if ((this.childNodes.isEmpty()) && (this.tag.isSelfClosing()))
    {
      paramStringBuilder.append(" />");
      return;
    }
    paramStringBuilder.append(">");
  }

  void outerHtmlTail(StringBuilder paramStringBuilder, int paramInt, Document.OutputSettings paramOutputSettings)
  {
    if ((!this.childNodes.isEmpty()) || (!this.tag.isSelfClosing()))
    {
      if ((paramOutputSettings.prettyPrint()) && (!this.childNodes.isEmpty()) && ((this.tag.formatAsBlock()) || ((paramOutputSettings.outline()) && ((this.childNodes.size() > 1) || ((this.childNodes.size() == 1) && (!(this.childNodes.get(0) instanceof TextNode)))))))
        indent(paramStringBuilder, paramInt, paramOutputSettings);
      paramStringBuilder.append("</").append(tagName()).append(">");
    }
  }

  public String ownText()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    ownText(localStringBuilder);
    return localStringBuilder.toString().trim();
  }

  public final Element parent()
  {
    return (Element)this.parentNode;
  }

  public Elements parents()
  {
    Elements localElements = new Elements();
    accumulateParents(this, localElements);
    return localElements;
  }

  public Element prepend(String paramString)
  {
    Validate.notNull(paramString);
    List localList = Parser.parseFragment(paramString, this, baseUri());
    addChildren(0, (Node[])localList.toArray(new Node[localList.size()]));
    return this;
  }

  public Element prependChild(Node paramNode)
  {
    Validate.notNull(paramNode);
    addChildren(0, new Node[] { paramNode });
    return this;
  }

  public Element prependElement(String paramString)
  {
    Element localElement = new Element(Tag.valueOf(paramString), baseUri());
    prependChild(localElement);
    return localElement;
  }

  public Element prependText(String paramString)
  {
    prependChild(new TextNode(paramString, baseUri()));
    return this;
  }

  public Element previousElementSibling()
  {
    if (this.parentNode == null);
    Elements localElements;
    Integer localInteger;
    do
    {
      return null;
      localElements = parent().children();
      localInteger = indexInList(this, localElements);
      Validate.notNull(localInteger);
    }
    while (localInteger.intValue() <= 0);
    return (Element)localElements.get(-1 + localInteger.intValue());
  }

  public Element removeClass(String paramString)
  {
    Validate.notNull(paramString);
    Set localSet = classNames();
    localSet.remove(paramString);
    classNames(localSet);
    return this;
  }

  public Elements select(String paramString)
  {
    return Selector.select(paramString, this);
  }

  public Elements siblingElements()
  {
    Elements localElements1;
    if (this.parentNode == null)
      localElements1 = new Elements(0);
    while (true)
    {
      return localElements1;
      Elements localElements2 = parent().children();
      localElements1 = new Elements(-1 + localElements2.size());
      Iterator localIterator = localElements2.iterator();
      while (localIterator.hasNext())
      {
        Element localElement = (Element)localIterator.next();
        if (localElement != this)
          localElements1.add(localElement);
      }
    }
  }

  public Tag tag()
  {
    return this.tag;
  }

  public String tagName()
  {
    return this.tag.getName();
  }

  public Element tagName(String paramString)
  {
    Validate.notEmpty(paramString, "Tag name must not be empty.");
    this.tag = Tag.valueOf(paramString);
    return this;
  }

  public String text()
  {
    final StringBuilder localStringBuilder = new StringBuilder();
    new NodeTraversor(new NodeVisitor()
    {
      public void head(Node paramAnonymousNode, int paramAnonymousInt)
      {
        if ((paramAnonymousNode instanceof TextNode))
        {
          TextNode localTextNode = (TextNode)paramAnonymousNode;
          Element.appendNormalisedText(localStringBuilder, localTextNode);
        }
        Element localElement;
        do
        {
          do
            return;
          while (!(paramAnonymousNode instanceof Element));
          localElement = (Element)paramAnonymousNode;
        }
        while ((localStringBuilder.length() <= 0) || ((!localElement.isBlock()) && (!localElement.tag.getName().equals("br"))) || (TextNode.lastCharIsWhitespace(localStringBuilder)));
        localStringBuilder.append(" ");
      }

      public void tail(Node paramAnonymousNode, int paramAnonymousInt)
      {
      }
    }).traverse(this);
    return localStringBuilder.toString().trim();
  }

  public Element text(String paramString)
  {
    Validate.notNull(paramString);
    empty();
    appendChild(new TextNode(paramString, this.baseUri));
    return this;
  }

  public List<TextNode> textNodes()
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.childNodes.iterator();
    while (localIterator.hasNext())
    {
      Node localNode = (Node)localIterator.next();
      if ((localNode instanceof TextNode))
        localArrayList.add((TextNode)localNode);
    }
    return Collections.unmodifiableList(localArrayList);
  }

  public String toString()
  {
    return outerHtml();
  }

  public Element toggleClass(String paramString)
  {
    Validate.notNull(paramString);
    Set localSet = classNames();
    if (localSet.contains(paramString))
      localSet.remove(paramString);
    while (true)
    {
      classNames(localSet);
      return this;
      localSet.add(paramString);
    }
  }

  public String val()
  {
    if (tagName().equals("textarea"))
      return text();
    return attr("value");
  }

  public Element val(String paramString)
  {
    if (tagName().equals("textarea"))
    {
      text(paramString);
      return this;
    }
    attr("value", paramString);
    return this;
  }

  public Element wrap(String paramString)
  {
    return (Element)super.wrap(paramString);
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     org.jsoup.nodes.Element
 * JD-Core Version:    0.6.2
 */