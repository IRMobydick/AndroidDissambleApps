package com.squareup.okhttp.internal.http;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

public final class HttpDate
{
  private static final DateFormat[] BROWSER_COMPATIBLE_DATE_FORMATS = new DateFormat[BROWSER_COMPATIBLE_DATE_FORMAT_STRINGS.length];
  private static final String[] BROWSER_COMPATIBLE_DATE_FORMAT_STRINGS;
  private static final ThreadLocal<DateFormat> STANDARD_DATE_FORMAT = new ThreadLocal()
  {
    protected DateFormat initialValue()
    {
      SimpleDateFormat localSimpleDateFormat = new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss zzz", Locale.US);
      localSimpleDateFormat.setTimeZone(TimeZone.getTimeZone("GMT"));
      return localSimpleDateFormat;
    }
  };

  static
  {
    BROWSER_COMPATIBLE_DATE_FORMAT_STRINGS = new String[] { "EEEE, dd-MMM-yy HH:mm:ss zzz", "EEE MMM d HH:mm:ss yyyy", "EEE, dd-MMM-yyyy HH:mm:ss z", "EEE, dd-MMM-yyyy HH-mm-ss z", "EEE, dd MMM yy HH:mm:ss z", "EEE dd-MMM-yyyy HH:mm:ss z", "EEE dd MMM yyyy HH:mm:ss z", "EEE dd-MMM-yyyy HH-mm-ss z", "EEE dd-MMM-yy HH:mm:ss z", "EEE dd MMM yy HH:mm:ss z", "EEE,dd-MMM-yy HH:mm:ss z", "EEE,dd-MMM-yyyy HH:mm:ss z", "EEE, dd-MM-yyyy HH:mm:ss z", "EEE MMM d yyyy HH:mm:ss z" };
  }

  public static String format(Date paramDate)
  {
    return ((DateFormat)STANDARD_DATE_FORMAT.get()).format(paramDate);
  }

  // ERROR //
  public static Date parse(String paramString)
  {
    // Byte code:
    //   0: getstatic 20	com/squareup/okhttp/internal/http/HttpDate:STANDARD_DATE_FORMAT	Ljava/lang/ThreadLocal;
    //   3: invokevirtual 65	java/lang/ThreadLocal:get	()Ljava/lang/Object;
    //   6: checkcast 54	java/text/DateFormat
    //   9: aload_0
    //   10: invokevirtual 73	java/text/DateFormat:parse	(Ljava/lang/String;)Ljava/util/Date;
    //   13: astore 9
    //   15: aload 9
    //   17: areturn
    //   18: astore_1
    //   19: getstatic 52	com/squareup/okhttp/internal/http/HttpDate:BROWSER_COMPATIBLE_DATE_FORMAT_STRINGS	[Ljava/lang/String;
    //   22: astore_2
    //   23: aload_2
    //   24: monitorenter
    //   25: iconst_0
    //   26: istore_3
    //   27: getstatic 52	com/squareup/okhttp/internal/http/HttpDate:BROWSER_COMPATIBLE_DATE_FORMAT_STRINGS	[Ljava/lang/String;
    //   30: arraylength
    //   31: istore 5
    //   33: iload_3
    //   34: iload 5
    //   36: if_icmpge +67 -> 103
    //   39: getstatic 56	com/squareup/okhttp/internal/http/HttpDate:BROWSER_COMPATIBLE_DATE_FORMATS	[Ljava/text/DateFormat;
    //   42: iload_3
    //   43: aaload
    //   44: astore 6
    //   46: aload 6
    //   48: ifnonnull +27 -> 75
    //   51: new 75	java/text/SimpleDateFormat
    //   54: dup
    //   55: getstatic 52	com/squareup/okhttp/internal/http/HttpDate:BROWSER_COMPATIBLE_DATE_FORMAT_STRINGS	[Ljava/lang/String;
    //   58: iload_3
    //   59: aaload
    //   60: getstatic 81	java/util/Locale:US	Ljava/util/Locale;
    //   63: invokespecial 84	java/text/SimpleDateFormat:<init>	(Ljava/lang/String;Ljava/util/Locale;)V
    //   66: astore 6
    //   68: getstatic 56	com/squareup/okhttp/internal/http/HttpDate:BROWSER_COMPATIBLE_DATE_FORMATS	[Ljava/text/DateFormat;
    //   71: iload_3
    //   72: aload 6
    //   74: aastore
    //   75: aload 6
    //   77: aload_0
    //   78: invokevirtual 73	java/text/DateFormat:parse	(Ljava/lang/String;)Ljava/util/Date;
    //   81: astore 8
    //   83: aload_2
    //   84: monitorexit
    //   85: aload 8
    //   87: areturn
    //   88: astore 4
    //   90: aload_2
    //   91: monitorexit
    //   92: aload 4
    //   94: athrow
    //   95: astore 7
    //   97: iinc 3 1
    //   100: goto -67 -> 33
    //   103: aload_2
    //   104: monitorexit
    //   105: aconst_null
    //   106: areturn
    //
    // Exception table:
    //   from	to	target	type
    //   0	15	18	java/text/ParseException
    //   27	33	88	finally
    //   39	46	88	finally
    //   51	75	88	finally
    //   75	83	88	finally
    //   83	85	88	finally
    //   90	92	88	finally
    //   103	105	88	finally
    //   75	83	95	java/text/ParseException
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.squareup.okhttp.internal.http.HttpDate
 * JD-Core Version:    0.6.2
 */