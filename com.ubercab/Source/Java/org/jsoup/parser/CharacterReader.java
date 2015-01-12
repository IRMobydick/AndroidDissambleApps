package org.jsoup.parser;

import java.util.Locale;
import org.jsoup.helper.Validate;

class CharacterReader
{
  static final char EOF = 'èøø';
  private final char[] input;
  private final int length;
  private int mark = 0;
  private int pos = 0;

  CharacterReader(String paramString)
  {
    Validate.notNull(paramString);
    this.input = paramString.toCharArray();
    this.length = this.input.length;
  }

  void advance()
  {
    this.pos = (1 + this.pos);
  }

  char consume()
  {
    if (isEmpty());
    int j;
    for (int i = 65535; ; j = this.input[this.pos])
    {
      this.pos = (1 + this.pos);
      return i;
    }
  }

  String consumeAsString()
  {
    char[] arrayOfChar = this.input;
    int i = this.pos;
    this.pos = (i + 1);
    return new String(arrayOfChar, i, 1);
  }

  String consumeDigitSequence()
  {
    int i = this.pos;
    while (this.pos < this.length)
    {
      int j = this.input[this.pos];
      if ((j < 48) || (j > 57))
        break;
      this.pos = (1 + this.pos);
    }
    return new String(this.input, i, this.pos - i);
  }

  String consumeHexSequence()
  {
    int i = this.pos;
    while (this.pos < this.length)
    {
      int j = this.input[this.pos];
      if (((j < 48) || (j > 57)) && ((j < 65) || (j > 70)) && ((j < 97) || (j > 102)))
        break;
      this.pos = (1 + this.pos);
    }
    return new String(this.input, i, this.pos - i);
  }

  String consumeLetterSequence()
  {
    int i = this.pos;
    while (this.pos < this.length)
    {
      int j = this.input[this.pos];
      if (((j < 65) || (j > 90)) && ((j < 97) || (j > 122)))
        break;
      this.pos = (1 + this.pos);
    }
    return new String(this.input, i, this.pos - i);
  }

  String consumeLetterThenDigitSequence()
  {
    int i = this.pos;
    while (this.pos < this.length)
    {
      int k = this.input[this.pos];
      if (((k < 65) || (k > 90)) && ((k < 97) || (k > 122)))
        break;
      this.pos = (1 + this.pos);
    }
    while (!isEmpty())
    {
      int j = this.input[this.pos];
      if ((j < 48) || (j > 57))
        break;
      this.pos = (1 + this.pos);
    }
    return new String(this.input, i, this.pos - i);
  }

  String consumeTo(char paramChar)
  {
    int i = nextIndexOf(paramChar);
    if (i != -1)
    {
      String str = new String(this.input, this.pos, i);
      this.pos = (i + this.pos);
      return str;
    }
    return consumeToEnd();
  }

  String consumeTo(String paramString)
  {
    int i = nextIndexOf(paramString);
    if (i != -1)
    {
      String str = new String(this.input, this.pos, i);
      this.pos = (i + this.pos);
      return str;
    }
    return consumeToEnd();
  }

  String consumeToAny(char[] paramArrayOfChar)
  {
    int i = this.pos;
    while (true)
    {
      if (this.pos < this.length);
      for (int j = 0; j < paramArrayOfChar.length; j++)
        if (this.input[this.pos] == paramArrayOfChar[j])
        {
          if (this.pos <= i)
            break label85;
          return new String(this.input, i, this.pos - i);
        }
      this.pos = (1 + this.pos);
    }
    label85: return "";
  }

  String consumeToEnd()
  {
    String str = new String(this.input, this.pos, this.length - this.pos);
    this.pos = this.length;
    return str;
  }

  boolean containsIgnoreCase(String paramString)
  {
    String str1 = paramString.toLowerCase(Locale.ENGLISH);
    String str2 = paramString.toUpperCase(Locale.ENGLISH);
    return (nextIndexOf(str1) > -1) || (nextIndexOf(str2) > -1);
  }

  char current()
  {
    if (isEmpty())
      return 65535;
    return this.input[this.pos];
  }

  boolean isEmpty()
  {
    return this.pos >= this.length;
  }

  void mark()
  {
    this.mark = this.pos;
  }

  boolean matchConsume(String paramString)
  {
    if (matches(paramString))
    {
      this.pos += paramString.length();
      return true;
    }
    return false;
  }

  boolean matchConsumeIgnoreCase(String paramString)
  {
    if (matchesIgnoreCase(paramString))
    {
      this.pos += paramString.length();
      return true;
    }
    return false;
  }

  boolean matches(char paramChar)
  {
    return (!isEmpty()) && (this.input[this.pos] == paramChar);
  }

  boolean matches(String paramString)
  {
    int i = paramString.length();
    if (i > this.length - this.pos)
      return false;
    for (int j = 0; ; j++)
    {
      if (j >= i)
        break label52;
      if (paramString.charAt(j) != this.input[(j + this.pos)])
        break;
    }
    label52: return true;
  }

  boolean matchesAny(char[] paramArrayOfChar)
  {
    if (isEmpty());
    while (true)
    {
      return false;
      int i = this.input[this.pos];
      int j = paramArrayOfChar.length;
      for (int k = 0; k < j; k++)
        if (paramArrayOfChar[k] == i)
          return true;
    }
  }

  boolean matchesDigit()
  {
    if (isEmpty());
    int i;
    do
    {
      return false;
      i = this.input[this.pos];
    }
    while ((i < 48) || (i > 57));
    return true;
  }

  boolean matchesIgnoreCase(String paramString)
  {
    int i = paramString.length();
    if (i > this.length - this.pos)
      return false;
    for (int j = 0; ; j++)
    {
      if (j >= i)
        break label58;
      if (Character.toUpperCase(paramString.charAt(j)) != Character.toUpperCase(this.input[(j + this.pos)]))
        break;
    }
    label58: return true;
  }

  boolean matchesLetter()
  {
    if (isEmpty());
    int i;
    do
    {
      return false;
      i = this.input[this.pos];
    }
    while (((i < 65) || (i > 90)) && ((i < 97) || (i > 122)));
    return true;
  }

  int nextIndexOf(char paramChar)
  {
    for (int i = this.pos; i < this.length; i++)
      if (paramChar == this.input[i])
        return i - this.pos;
    return -1;
  }

  int nextIndexOf(CharSequence paramCharSequence)
  {
    int i = paramCharSequence.charAt(0);
    for (int j = this.pos; j < this.length; j++)
    {
      if (i != this.input[j])
        do
          j++;
        while ((j < this.length) && (i != this.input[j]));
      int k = j + 1;
      int m = -1 + (k + paramCharSequence.length());
      if ((j < this.length) && (m <= this.length))
      {
        for (int n = 1; (k < m) && (paramCharSequence.charAt(n) == this.input[k]); n++)
          k++;
        if (k == m)
          return j - this.pos;
      }
    }
    return -1;
  }

  int pos()
  {
    return this.pos;
  }

  void rewindToMark()
  {
    this.pos = this.mark;
  }

  public String toString()
  {
    return new String(this.input, this.pos, this.length - this.pos);
  }

  void unconsume()
  {
    this.pos = (-1 + this.pos);
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     org.jsoup.parser.CharacterReader
 * JD-Core Version:    0.6.2
 */