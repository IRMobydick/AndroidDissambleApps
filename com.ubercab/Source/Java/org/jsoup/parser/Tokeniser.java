package org.jsoup.parser;

import org.jsoup.helper.Validate;
import org.jsoup.nodes.Entities;

class Tokeniser
{
  static final char replacementChar = '�';
  private StringBuilder charBuffer = new StringBuilder();
  Token.Comment commentPending;
  StringBuilder dataBuffer;
  Token.Doctype doctypePending;
  private Token emitPending;
  private ParseErrorList errors;
  private boolean isEmitPending = false;
  private Token.StartTag lastStartTag;
  private CharacterReader reader;
  private boolean selfClosingFlagAcknowledged = true;
  private TokeniserState state = TokeniserState.Data;
  Token.Tag tagPending;

  Tokeniser(CharacterReader paramCharacterReader, ParseErrorList paramParseErrorList)
  {
    this.reader = paramCharacterReader;
    this.errors = paramParseErrorList;
  }

  private void characterReferenceError(String paramString)
  {
    if (this.errors.canAddError())
      this.errors.add(new ParseError(this.reader.pos(), "Invalid character reference: %s", new Object[] { paramString }));
  }

  private void error(String paramString)
  {
    if (this.errors.canAddError())
      this.errors.add(new ParseError(this.reader.pos(), paramString));
  }

  void acknowledgeSelfClosingFlag()
  {
    this.selfClosingFlagAcknowledged = true;
  }

  void advanceTransition(TokeniserState paramTokeniserState)
  {
    this.reader.advance();
    this.state = paramTokeniserState;
  }

  String appropriateEndTagName()
  {
    return this.lastStartTag.tagName;
  }

  char[] consumeCharacterReference(Character paramCharacter, boolean paramBoolean)
  {
    if (this.reader.isEmpty());
    while (true)
    {
      return null;
      if ((paramCharacter != null) && (paramCharacter.charValue() == this.reader.current()))
        continue;
      if (this.reader.matchesAny(new char[] { 9, 10, 13, 12, 32, 60, 38 }))
        continue;
      this.reader.mark();
      String str2;
      int j;
      int k;
      if (this.reader.matchConsume("#"))
      {
        boolean bool2 = this.reader.matchConsumeIgnoreCase("X");
        if (bool2);
        for (str2 = this.reader.consumeHexSequence(); str2.length() == 0; str2 = this.reader.consumeDigitSequence())
        {
          characterReferenceError("numeric reference with no numerals");
          this.reader.rewindToMark();
          return null;
        }
        if (!this.reader.matchConsume(";"))
          characterReferenceError("missing semicolon");
        j = -1;
        if (bool2)
          k = 16;
      }
      try
      {
        while (true)
        {
          int m = Integer.valueOf(str2, k).intValue();
          j = m;
          label205: if ((j != -1) && ((j < 55296) || (j > 57343)) && (j <= 1114111))
            break;
          characterReferenceError("character outside of valid range");
          return new char[] { 65533 };
          k = 10;
        }
        return Character.toChars(j);
        String str1 = this.reader.consumeLetterThenDigitSequence();
        boolean bool1 = this.reader.matches(';');
        if ((Entities.isBaseNamedEntity(str1)) || ((Entities.isNamedEntity(str1)) && (bool1)));
        for (int i = 1; ; i = 0)
        {
          if (i != 0)
            break label343;
          this.reader.rewindToMark();
          if (!bool1)
            break;
          characterReferenceError(String.format("invalid named referenece '%s'", new Object[] { str1 }));
          return null;
        }
        label343: if (paramBoolean)
          if ((!this.reader.matchesLetter()) && (!this.reader.matchesDigit()))
          {
            if (!this.reader.matchesAny(new char[] { 61, 45, 95 }));
          }
          else
          {
            this.reader.rewindToMark();
            return null;
          }
        if (!this.reader.matchConsume(";"))
          characterReferenceError("missing semicolon");
        char[] arrayOfChar = new char[1];
        arrayOfChar[0] = Entities.getCharacterByName(str1).charValue();
        return arrayOfChar;
      }
      catch (NumberFormatException localNumberFormatException)
      {
        break label205;
      }
    }
  }

  void createCommentPending()
  {
    this.commentPending = new Token.Comment();
  }

  void createDoctypePending()
  {
    this.doctypePending = new Token.Doctype();
  }

  Token.Tag createTagPending(boolean paramBoolean)
  {
    if (paramBoolean);
    for (Object localObject = new Token.StartTag(); ; localObject = new Token.EndTag())
    {
      this.tagPending = ((Token.Tag)localObject);
      return this.tagPending;
    }
  }

  void createTempBuffer()
  {
    this.dataBuffer = new StringBuilder();
  }

  boolean currentNodeInHtmlNS()
  {
    return true;
  }

  void emit(char paramChar)
  {
    this.charBuffer.append(paramChar);
  }

  void emit(String paramString)
  {
    this.charBuffer.append(paramString);
  }

  void emit(Token paramToken)
  {
    Validate.isFalse(this.isEmitPending, "There is an unread token pending!");
    this.emitPending = paramToken;
    this.isEmitPending = true;
    if (paramToken.type == Token.TokenType.StartTag)
    {
      localStartTag = (Token.StartTag)paramToken;
      this.lastStartTag = localStartTag;
      if (localStartTag.selfClosing)
        this.selfClosingFlagAcknowledged = false;
    }
    while ((paramToken.type != Token.TokenType.EndTag) || (((Token.EndTag)paramToken).attributes == null))
    {
      Token.StartTag localStartTag;
      return;
    }
    error("Attributes incorrectly present on end tag");
  }

  void emit(char[] paramArrayOfChar)
  {
    this.charBuffer.append(paramArrayOfChar);
  }

  void emitCommentPending()
  {
    emit(this.commentPending);
  }

  void emitDoctypePending()
  {
    emit(this.doctypePending);
  }

  void emitTagPending()
  {
    this.tagPending.finaliseTag();
    emit(this.tagPending);
  }

  void eofError(TokeniserState paramTokeniserState)
  {
    if (this.errors.canAddError())
      this.errors.add(new ParseError(this.reader.pos(), "Unexpectedly reached end of file (EOF) in input state [%s]", new Object[] { paramTokeniserState }));
  }

  void error(TokeniserState paramTokeniserState)
  {
    if (this.errors.canAddError())
    {
      ParseErrorList localParseErrorList = this.errors;
      int i = this.reader.pos();
      Object[] arrayOfObject = new Object[2];
      arrayOfObject[0] = Character.valueOf(this.reader.current());
      arrayOfObject[1] = paramTokeniserState;
      localParseErrorList.add(new ParseError(i, "Unexpected character '%s' in input state [%s]", arrayOfObject));
    }
  }

  TokeniserState getState()
  {
    return this.state;
  }

  boolean isAppropriateEndTagToken()
  {
    if (this.lastStartTag == null)
      return false;
    return this.tagPending.tagName.equals(this.lastStartTag.tagName);
  }

  Token read()
  {
    if (!this.selfClosingFlagAcknowledged)
    {
      error("Self closing flag not acknowledged");
      this.selfClosingFlagAcknowledged = true;
    }
    while (!this.isEmitPending)
      this.state.read(this, this.reader);
    if (this.charBuffer.length() > 0)
    {
      String str = this.charBuffer.toString();
      this.charBuffer.delete(0, this.charBuffer.length());
      return new Token.Character(str);
    }
    this.isEmitPending = false;
    return this.emitPending;
  }

  void transition(TokeniserState paramTokeniserState)
  {
    this.state = paramTokeniserState;
  }

  String unescapeEntities(boolean paramBoolean)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    while (!this.reader.isEmpty())
    {
      localStringBuilder.append(this.reader.consumeTo('&'));
      if (this.reader.matches('&'))
      {
        this.reader.consume();
        char[] arrayOfChar = consumeCharacterReference(null, paramBoolean);
        if ((arrayOfChar == null) || (arrayOfChar.length == 0))
          localStringBuilder.append('&');
        else
          localStringBuilder.append(arrayOfChar);
      }
    }
    return localStringBuilder.toString();
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     org.jsoup.parser.Tokeniser
 * JD-Core Version:    0.6.2
 */