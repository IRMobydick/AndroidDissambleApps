package org.jsoup.parser;

import org.jsoup.helper.Validate;
import org.jsoup.nodes.Attribute;
import org.jsoup.nodes.Attributes;

abstract class Token
{
  TokenType type;

  Character asCharacter()
  {
    return (Character)this;
  }

  Comment asComment()
  {
    return (Comment)this;
  }

  Doctype asDoctype()
  {
    return (Doctype)this;
  }

  EndTag asEndTag()
  {
    return (EndTag)this;
  }

  StartTag asStartTag()
  {
    return (StartTag)this;
  }

  boolean isCharacter()
  {
    return this.type == TokenType.Character;
  }

  boolean isComment()
  {
    return this.type == TokenType.Comment;
  }

  boolean isDoctype()
  {
    return this.type == TokenType.Doctype;
  }

  boolean isEOF()
  {
    return this.type == TokenType.EOF;
  }

  boolean isEndTag()
  {
    return this.type == TokenType.EndTag;
  }

  boolean isStartTag()
  {
    return this.type == TokenType.StartTag;
  }

  String tokenType()
  {
    return getClass().getSimpleName();
  }

  static class Character extends Token
  {
    private final String data;

    Character(String paramString)
    {
      super();
      this.type = Token.TokenType.Character;
      this.data = paramString;
    }

    String getData()
    {
      return this.data;
    }

    public String toString()
    {
      return getData();
    }
  }

  static class Comment extends Token
  {
    boolean bogus = false;
    final StringBuilder data = new StringBuilder();

    Comment()
    {
      super();
      this.type = Token.TokenType.Comment;
    }

    String getData()
    {
      return this.data.toString();
    }

    public String toString()
    {
      return "<!--" + getData() + "-->";
    }
  }

  static class Doctype extends Token
  {
    boolean forceQuirks = false;
    final StringBuilder name = new StringBuilder();
    final StringBuilder publicIdentifier = new StringBuilder();
    final StringBuilder systemIdentifier = new StringBuilder();

    Doctype()
    {
      super();
      this.type = Token.TokenType.Doctype;
    }

    String getName()
    {
      return this.name.toString();
    }

    String getPublicIdentifier()
    {
      return this.publicIdentifier.toString();
    }

    public String getSystemIdentifier()
    {
      return this.systemIdentifier.toString();
    }

    public boolean isForceQuirks()
    {
      return this.forceQuirks;
    }
  }

  static class EOF extends Token
  {
    EOF()
    {
      super();
      this.type = Token.TokenType.EOF;
    }
  }

  static class EndTag extends Token.Tag
  {
    EndTag()
    {
      this.type = Token.TokenType.EndTag;
    }

    EndTag(String paramString)
    {
      this();
      this.tagName = paramString;
    }

    public String toString()
    {
      return "</" + name() + ">";
    }
  }

  static class StartTag extends Token.Tag
  {
    StartTag()
    {
      this.attributes = new Attributes();
      this.type = Token.TokenType.StartTag;
    }

    StartTag(String paramString)
    {
      this();
      this.tagName = paramString;
    }

    StartTag(String paramString, Attributes paramAttributes)
    {
      this();
      this.tagName = paramString;
      this.attributes = paramAttributes;
    }

    public String toString()
    {
      if ((this.attributes != null) && (this.attributes.size() > 0))
        return "<" + name() + " " + this.attributes.toString() + ">";
      return "<" + name() + ">";
    }
  }

  static abstract class Tag extends Token
  {
    Attributes attributes;
    private String pendingAttributeName;
    private StringBuilder pendingAttributeValue;
    boolean selfClosing = false;
    protected String tagName;

    Tag()
    {
      super();
    }

    private final void ensureAttributeValue()
    {
      if (this.pendingAttributeValue == null)
        this.pendingAttributeValue = new StringBuilder();
    }

    void appendAttributeName(char paramChar)
    {
      appendAttributeName(String.valueOf(paramChar));
    }

    void appendAttributeName(String paramString)
    {
      if (this.pendingAttributeName == null);
      while (true)
      {
        this.pendingAttributeName = paramString;
        return;
        paramString = this.pendingAttributeName.concat(paramString);
      }
    }

    void appendAttributeValue(char paramChar)
    {
      ensureAttributeValue();
      this.pendingAttributeValue.append(paramChar);
    }

    void appendAttributeValue(String paramString)
    {
      ensureAttributeValue();
      this.pendingAttributeValue.append(paramString);
    }

    void appendAttributeValue(char[] paramArrayOfChar)
    {
      ensureAttributeValue();
      this.pendingAttributeValue.append(paramArrayOfChar);
    }

    void appendTagName(char paramChar)
    {
      appendTagName(String.valueOf(paramChar));
    }

    void appendTagName(String paramString)
    {
      if (this.tagName == null);
      while (true)
      {
        this.tagName = paramString;
        return;
        paramString = this.tagName.concat(paramString);
      }
    }

    void finaliseTag()
    {
      if (this.pendingAttributeName != null)
        newAttribute();
    }

    Attributes getAttributes()
    {
      return this.attributes;
    }

    boolean isSelfClosing()
    {
      return this.selfClosing;
    }

    String name()
    {
      if (this.tagName.length() == 0);
      for (boolean bool = true; ; bool = false)
      {
        Validate.isFalse(bool);
        return this.tagName;
      }
    }

    Tag name(String paramString)
    {
      this.tagName = paramString;
      return this;
    }

    void newAttribute()
    {
      if (this.attributes == null)
        this.attributes = new Attributes();
      if (this.pendingAttributeName != null)
        if (this.pendingAttributeValue != null)
          break label83;
      label83: for (Attribute localAttribute = new Attribute(this.pendingAttributeName, ""); ; localAttribute = new Attribute(this.pendingAttributeName, this.pendingAttributeValue.toString()))
      {
        this.attributes.put(localAttribute);
        this.pendingAttributeName = null;
        if (this.pendingAttributeValue != null)
          this.pendingAttributeValue.delete(0, this.pendingAttributeValue.length());
        return;
      }
    }
  }

  static enum TokenType
  {
    static
    {
      EndTag = new TokenType("EndTag", 2);
      Comment = new TokenType("Comment", 3);
      Character = new TokenType("Character", 4);
      EOF = new TokenType("EOF", 5);
      TokenType[] arrayOfTokenType = new TokenType[6];
      arrayOfTokenType[0] = Doctype;
      arrayOfTokenType[1] = StartTag;
      arrayOfTokenType[2] = EndTag;
      arrayOfTokenType[3] = Comment;
      arrayOfTokenType[4] = Character;
      arrayOfTokenType[5] = EOF;
    }
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     org.jsoup.parser.Token
 * JD-Core Version:    0.6.2
 */