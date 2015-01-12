package org.jsoup.helper;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.nio.charset.IllegalCharsetNameException;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Document.OutputSettings;
import org.jsoup.nodes.Element;
import org.jsoup.parser.Parser;
import org.jsoup.select.Elements;

public class DataUtil
{
  private static final int bufferSize = 131072;
  private static final Pattern charsetPattern = Pattern.compile("(?i)\\bcharset=\\s*(?:\"|')?([^\\s,;\"']*)");
  static final String defaultCharset = "UTF-8";

  static String getCharsetFromContentType(String paramString)
  {
    String str;
    if (paramString == null)
      str = null;
    while (true)
    {
      return str;
      Matcher localMatcher = charsetPattern.matcher(paramString);
      if (localMatcher.find())
      {
        str = localMatcher.group(1).trim().replace("charset=", "");
        if (str.isEmpty())
          return null;
      }
      try
      {
        if (!Charset.isSupported(str))
        {
          str = str.toUpperCase(Locale.ENGLISH);
          boolean bool = Charset.isSupported(str);
          if (!bool)
            return null;
        }
      }
      catch (IllegalCharsetNameException localIllegalCharsetNameException)
      {
      }
    }
    return null;
  }

  // ERROR //
  public static Document load(java.io.File paramFile, String paramString1, String paramString2)
    throws IOException
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: new 85	java/io/FileInputStream
    //   5: dup
    //   6: aload_0
    //   7: invokespecial 88	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   10: astore 4
    //   12: aload 4
    //   14: invokestatic 92	org/jsoup/helper/DataUtil:readToByteBuffer	(Ljava/io/InputStream;)Ljava/nio/ByteBuffer;
    //   17: aload_1
    //   18: aload_2
    //   19: invokestatic 98	org/jsoup/parser/Parser:htmlParser	()Lorg/jsoup/parser/Parser;
    //   22: invokestatic 102	org/jsoup/helper/DataUtil:parseByteData	(Ljava/nio/ByteBuffer;Ljava/lang/String;Ljava/lang/String;Lorg/jsoup/parser/Parser;)Lorg/jsoup/nodes/Document;
    //   25: astore 6
    //   27: aload 4
    //   29: ifnull +8 -> 37
    //   32: aload 4
    //   34: invokevirtual 105	java/io/FileInputStream:close	()V
    //   37: aload 6
    //   39: areturn
    //   40: astore 5
    //   42: aload_3
    //   43: ifnull +7 -> 50
    //   46: aload_3
    //   47: invokevirtual 105	java/io/FileInputStream:close	()V
    //   50: aload 5
    //   52: athrow
    //   53: astore 5
    //   55: aload 4
    //   57: astore_3
    //   58: goto -16 -> 42
    //
    // Exception table:
    //   from	to	target	type
    //   2	12	40	finally
    //   12	27	53	finally
  }

  public static Document load(InputStream paramInputStream, String paramString1, String paramString2)
    throws IOException
  {
    return parseByteData(readToByteBuffer(paramInputStream), paramString1, paramString2, Parser.htmlParser());
  }

  public static Document load(InputStream paramInputStream, String paramString1, String paramString2, Parser paramParser)
    throws IOException
  {
    return parseByteData(readToByteBuffer(paramInputStream), paramString1, paramString2, paramParser);
  }

  static Document parseByteData(ByteBuffer paramByteBuffer, String paramString1, String paramString2, Parser paramParser)
  {
    String str1;
    Document localDocument;
    Element localElement;
    Object localObject;
    if (paramString1 == null)
    {
      str1 = Charset.forName("UTF-8").decode(paramByteBuffer).toString();
      localDocument = paramParser.parseInput(str1, paramString2);
      localElement = localDocument.select("meta[http-equiv=content-type], meta[charset]").first();
      if (localElement != null)
      {
        if (!localElement.hasAttr("http-equiv"))
          break label231;
        localObject = getCharsetFromContentType(localElement.attr("content"));
        if ((localObject != null) || (!localElement.hasAttr("charset")));
      }
    }
    while (true)
    {
      try
      {
        if (Charset.isSupported(localElement.attr("charset")))
        {
          String str3 = localElement.attr("charset");
          localObject = str3;
        }
        if ((localObject != null) && (((String)localObject).length() != 0) && (!((String)localObject).equals("UTF-8")))
        {
          String str2 = ((String)localObject).trim().replaceAll("[\"']", "");
          paramString1 = str2;
          paramByteBuffer.rewind();
          str1 = Charset.forName(str2).decode(paramByteBuffer).toString();
          localDocument = null;
        }
        if (localDocument == null)
        {
          if ((str1.length() > 0) && (str1.charAt(0) == 65279))
            str1 = str1.substring(1);
          localDocument = paramParser.parseInput(str1, paramString2);
          localDocument.outputSettings().charset(paramString1);
        }
        return localDocument;
      }
      catch (IllegalCharsetNameException localIllegalCharsetNameException)
      {
        localObject = null;
        continue;
      }
      label231: localObject = localElement.attr("charset");
      continue;
      Validate.notEmpty(paramString1, "Must set charset arg to character set of file to parse. Set to null to attempt to detect from HTML");
      str1 = Charset.forName(paramString1).decode(paramByteBuffer).toString();
      localDocument = null;
    }
  }

  static ByteBuffer readToByteBuffer(InputStream paramInputStream)
    throws IOException
  {
    return readToByteBuffer(paramInputStream, 0);
  }

  static ByteBuffer readToByteBuffer(InputStream paramInputStream, int paramInt)
    throws IOException
  {
    boolean bool;
    int i;
    label18: byte[] arrayOfByte;
    ByteArrayOutputStream localByteArrayOutputStream;
    int j;
    if (paramInt >= 0)
    {
      bool = true;
      Validate.isTrue(bool, "maxSize must be 0 (unlimited) or larger");
      if (paramInt <= 0)
        break label66;
      i = 1;
      arrayOfByte = new byte[131072];
      localByteArrayOutputStream = new ByteArrayOutputStream(131072);
      j = paramInt;
    }
    while (true)
    {
      int k = paramInputStream.read(arrayOfByte);
      if (k == -1);
      while (true)
      {
        return ByteBuffer.wrap(localByteArrayOutputStream.toByteArray());
        bool = false;
        break;
        label66: i = 0;
        break label18;
        if (i == 0)
          break label102;
        if (k <= j)
          break label95;
        localByteArrayOutputStream.write(arrayOfByte, 0, j);
      }
      label95: j -= k;
      label102: localByteArrayOutputStream.write(arrayOfByte, 0, k);
    }
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     org.jsoup.helper.DataUtil
 * JD-Core Version:    0.6.2
 */