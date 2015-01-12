package org.jsoup.select;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.ListIterator;
import org.jsoup.helper.Validate;
import org.jsoup.nodes.Element;
import org.jsoup.nodes.FormElement;

public class Elements
  implements List<Element>, Cloneable
{
  private List<Element> contents;

  public Elements()
  {
    this.contents = new ArrayList();
  }

  public Elements(int paramInt)
  {
    this.contents = new ArrayList(paramInt);
  }

  public Elements(Collection<Element> paramCollection)
  {
    this.contents = new ArrayList(paramCollection);
  }

  public Elements(List<Element> paramList)
  {
    this.contents = paramList;
  }

  public Elements(Element[] paramArrayOfElement)
  {
    this(Arrays.asList(paramArrayOfElement));
  }

  public void add(int paramInt, Element paramElement)
  {
    this.contents.add(paramInt, paramElement);
  }

  public boolean add(Element paramElement)
  {
    return this.contents.add(paramElement);
  }

  public boolean addAll(int paramInt, Collection<? extends Element> paramCollection)
  {
    return this.contents.addAll(paramInt, paramCollection);
  }

  public boolean addAll(Collection<? extends Element> paramCollection)
  {
    return this.contents.addAll(paramCollection);
  }

  public Elements addClass(String paramString)
  {
    Iterator localIterator = this.contents.iterator();
    while (localIterator.hasNext())
      ((Element)localIterator.next()).addClass(paramString);
    return this;
  }

  public Elements after(String paramString)
  {
    Iterator localIterator = this.contents.iterator();
    while (localIterator.hasNext())
      ((Element)localIterator.next()).after(paramString);
    return this;
  }

  public Elements append(String paramString)
  {
    Iterator localIterator = this.contents.iterator();
    while (localIterator.hasNext())
      ((Element)localIterator.next()).append(paramString);
    return this;
  }

  public String attr(String paramString)
  {
    Iterator localIterator = this.contents.iterator();
    while (localIterator.hasNext())
    {
      Element localElement = (Element)localIterator.next();
      if (localElement.hasAttr(paramString))
        return localElement.attr(paramString);
    }
    return "";
  }

  public Elements attr(String paramString1, String paramString2)
  {
    Iterator localIterator = this.contents.iterator();
    while (localIterator.hasNext())
      ((Element)localIterator.next()).attr(paramString1, paramString2);
    return this;
  }

  public Elements before(String paramString)
  {
    Iterator localIterator = this.contents.iterator();
    while (localIterator.hasNext())
      ((Element)localIterator.next()).before(paramString);
    return this;
  }

  public void clear()
  {
    this.contents.clear();
  }

  public Elements clone()
  {
    Elements localElements;
    try
    {
      localElements = (Elements)super.clone();
      ArrayList localArrayList = new ArrayList();
      localElements.contents = localArrayList;
      Iterator localIterator = this.contents.iterator();
      while (localIterator.hasNext())
        localArrayList.add(((Element)localIterator.next()).clone());
    }
    catch (CloneNotSupportedException localCloneNotSupportedException)
    {
      throw new RuntimeException(localCloneNotSupportedException);
    }
    return localElements;
  }

  public boolean contains(Object paramObject)
  {
    return this.contents.contains(paramObject);
  }

  public boolean containsAll(Collection<?> paramCollection)
  {
    return this.contents.containsAll(paramCollection);
  }

  public Elements empty()
  {
    Iterator localIterator = this.contents.iterator();
    while (localIterator.hasNext())
      ((Element)localIterator.next()).empty();
    return this;
  }

  public Elements eq(int paramInt)
  {
    if (this.contents.size() > paramInt)
    {
      Element[] arrayOfElement = new Element[1];
      arrayOfElement[0] = get(paramInt);
      return new Elements(arrayOfElement);
    }
    return new Elements();
  }

  public boolean equals(Object paramObject)
  {
    return this.contents.equals(paramObject);
  }

  public Element first()
  {
    if (this.contents.isEmpty())
      return null;
    return (Element)this.contents.get(0);
  }

  public List<FormElement> forms()
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.contents.iterator();
    while (localIterator.hasNext())
    {
      Element localElement = (Element)localIterator.next();
      if ((localElement instanceof FormElement))
        localArrayList.add((FormElement)localElement);
    }
    return localArrayList;
  }

  public Element get(int paramInt)
  {
    return (Element)this.contents.get(paramInt);
  }

  public boolean hasAttr(String paramString)
  {
    Iterator localIterator = this.contents.iterator();
    while (localIterator.hasNext())
      if (((Element)localIterator.next()).hasAttr(paramString))
        return true;
    return false;
  }

  public boolean hasClass(String paramString)
  {
    Iterator localIterator = this.contents.iterator();
    while (localIterator.hasNext())
      if (((Element)localIterator.next()).hasClass(paramString))
        return true;
    return false;
  }

  public boolean hasText()
  {
    Iterator localIterator = this.contents.iterator();
    while (localIterator.hasNext())
      if (((Element)localIterator.next()).hasText())
        return true;
    return false;
  }

  public int hashCode()
  {
    return this.contents.hashCode();
  }

  public String html()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    Iterator localIterator = this.contents.iterator();
    while (localIterator.hasNext())
    {
      Element localElement = (Element)localIterator.next();
      if (localStringBuilder.length() != 0)
        localStringBuilder.append("\n");
      localStringBuilder.append(localElement.html());
    }
    return localStringBuilder.toString();
  }

  public Elements html(String paramString)
  {
    Iterator localIterator = this.contents.iterator();
    while (localIterator.hasNext())
      ((Element)localIterator.next()).html(paramString);
    return this;
  }

  public int indexOf(Object paramObject)
  {
    return this.contents.indexOf(paramObject);
  }

  public boolean is(String paramString)
  {
    return !select(paramString).isEmpty();
  }

  public boolean isEmpty()
  {
    return this.contents.isEmpty();
  }

  public Iterator<Element> iterator()
  {
    return this.contents.iterator();
  }

  public Element last()
  {
    if (this.contents.isEmpty())
      return null;
    return (Element)this.contents.get(-1 + this.contents.size());
  }

  public int lastIndexOf(Object paramObject)
  {
    return this.contents.lastIndexOf(paramObject);
  }

  public ListIterator<Element> listIterator()
  {
    return this.contents.listIterator();
  }

  public ListIterator<Element> listIterator(int paramInt)
  {
    return this.contents.listIterator(paramInt);
  }

  public Elements not(String paramString)
  {
    return Selector.filterOut(this, Selector.select(paramString, this));
  }

  public String outerHtml()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    Iterator localIterator = this.contents.iterator();
    while (localIterator.hasNext())
    {
      Element localElement = (Element)localIterator.next();
      if (localStringBuilder.length() != 0)
        localStringBuilder.append("\n");
      localStringBuilder.append(localElement.outerHtml());
    }
    return localStringBuilder.toString();
  }

  public Elements parents()
  {
    LinkedHashSet localLinkedHashSet = new LinkedHashSet();
    Iterator localIterator = this.contents.iterator();
    while (localIterator.hasNext())
      localLinkedHashSet.addAll(((Element)localIterator.next()).parents());
    return new Elements(localLinkedHashSet);
  }

  public Elements prepend(String paramString)
  {
    Iterator localIterator = this.contents.iterator();
    while (localIterator.hasNext())
      ((Element)localIterator.next()).prepend(paramString);
    return this;
  }

  public Element remove(int paramInt)
  {
    return (Element)this.contents.remove(paramInt);
  }

  public Elements remove()
  {
    Iterator localIterator = this.contents.iterator();
    while (localIterator.hasNext())
      ((Element)localIterator.next()).remove();
    return this;
  }

  public boolean remove(Object paramObject)
  {
    return this.contents.remove(paramObject);
  }

  public boolean removeAll(Collection<?> paramCollection)
  {
    return this.contents.removeAll(paramCollection);
  }

  public Elements removeAttr(String paramString)
  {
    Iterator localIterator = this.contents.iterator();
    while (localIterator.hasNext())
      ((Element)localIterator.next()).removeAttr(paramString);
    return this;
  }

  public Elements removeClass(String paramString)
  {
    Iterator localIterator = this.contents.iterator();
    while (localIterator.hasNext())
      ((Element)localIterator.next()).removeClass(paramString);
    return this;
  }

  public boolean retainAll(Collection<?> paramCollection)
  {
    return this.contents.retainAll(paramCollection);
  }

  public Elements select(String paramString)
  {
    return Selector.select(paramString, this);
  }

  public Element set(int paramInt, Element paramElement)
  {
    return (Element)this.contents.set(paramInt, paramElement);
  }

  public int size()
  {
    return this.contents.size();
  }

  public List<Element> subList(int paramInt1, int paramInt2)
  {
    return this.contents.subList(paramInt1, paramInt2);
  }

  public Elements tagName(String paramString)
  {
    Iterator localIterator = this.contents.iterator();
    while (localIterator.hasNext())
      ((Element)localIterator.next()).tagName(paramString);
    return this;
  }

  public String text()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    Iterator localIterator = this.contents.iterator();
    while (localIterator.hasNext())
    {
      Element localElement = (Element)localIterator.next();
      if (localStringBuilder.length() != 0)
        localStringBuilder.append(" ");
      localStringBuilder.append(localElement.text());
    }
    return localStringBuilder.toString();
  }

  public Object[] toArray()
  {
    return this.contents.toArray();
  }

  public <T> T[] toArray(T[] paramArrayOfT)
  {
    return this.contents.toArray(paramArrayOfT);
  }

  public String toString()
  {
    return outerHtml();
  }

  public Elements toggleClass(String paramString)
  {
    Iterator localIterator = this.contents.iterator();
    while (localIterator.hasNext())
      ((Element)localIterator.next()).toggleClass(paramString);
    return this;
  }

  public Elements traverse(NodeVisitor paramNodeVisitor)
  {
    Validate.notNull(paramNodeVisitor);
    NodeTraversor localNodeTraversor = new NodeTraversor(paramNodeVisitor);
    Iterator localIterator = this.contents.iterator();
    while (localIterator.hasNext())
      localNodeTraversor.traverse((Element)localIterator.next());
    return this;
  }

  public Elements unwrap()
  {
    Iterator localIterator = this.contents.iterator();
    while (localIterator.hasNext())
      ((Element)localIterator.next()).unwrap();
    return this;
  }

  public String val()
  {
    if (size() > 0)
      return first().val();
    return "";
  }

  public Elements val(String paramString)
  {
    Iterator localIterator = this.contents.iterator();
    while (localIterator.hasNext())
      ((Element)localIterator.next()).val(paramString);
    return this;
  }

  public Elements wrap(String paramString)
  {
    Validate.notEmpty(paramString);
    Iterator localIterator = this.contents.iterator();
    while (localIterator.hasNext())
      ((Element)localIterator.next()).wrap(paramString);
    return this;
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     org.jsoup.select.Elements
 * JD-Core Version:    0.6.2
 */