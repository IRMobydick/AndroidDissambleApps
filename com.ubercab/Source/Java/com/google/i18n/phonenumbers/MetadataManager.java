package com.google.i18n.phonenumbers;

import java.io.IOException;
import java.io.InputStream;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

class MetadataManager
{
  private static final String ALTERNATE_FORMATS_FILE_PREFIX = "/com/google/i18n/phonenumbers/data/PhoneNumberAlternateFormatsProto";
  private static final Logger LOGGER = Logger.getLogger(MetadataManager.class.getName());
  private static final String SHORT_NUMBER_METADATA_FILE_PREFIX = "/com/google/i18n/phonenumbers/data/ShortNumberMetadataProto";
  private static final Map<Integer, Phonemetadata.PhoneMetadata> callingCodeToAlternateFormatsMap = Collections.synchronizedMap(new HashMap());
  private static final Set<Integer> countryCodeSet = AlternateFormatsCountryCodeSet.getCountryCodeSet();
  private static final Set<String> regionCodeSet = ShortNumbersRegionCodeSet.getRegionCodeSet();
  private static final Map<String, Phonemetadata.PhoneMetadata> regionCodeToShortNumberMetadataMap = Collections.synchronizedMap(new HashMap());

  private static void close(InputStream paramInputStream)
  {
    if (paramInputStream != null);
    try
    {
      paramInputStream.close();
      return;
    }
    catch (IOException localIOException)
    {
      LOGGER.log(Level.WARNING, localIOException.toString());
    }
  }

  static Phonemetadata.PhoneMetadata getAlternateFormatsForCountry(int paramInt)
  {
    if (!countryCodeSet.contains(Integer.valueOf(paramInt)))
      return null;
    synchronized (callingCodeToAlternateFormatsMap)
    {
      if (!callingCodeToAlternateFormatsMap.containsKey(Integer.valueOf(paramInt)))
        loadAlternateFormatsMetadataFromFile(paramInt);
      return (Phonemetadata.PhoneMetadata)callingCodeToAlternateFormatsMap.get(Integer.valueOf(paramInt));
    }
  }

  static Phonemetadata.PhoneMetadata getShortNumberMetadataForRegion(String paramString)
  {
    if (!regionCodeSet.contains(paramString))
      return null;
    synchronized (regionCodeToShortNumberMetadataMap)
    {
      if (!regionCodeToShortNumberMetadataMap.containsKey(paramString))
        loadShortNumberMetadataFromFile(paramString);
      return (Phonemetadata.PhoneMetadata)regionCodeToShortNumberMetadataMap.get(paramString);
    }
  }

  static Set<String> getShortNumberMetadataSupportedRegions()
  {
    return regionCodeSet;
  }

  // ERROR //
  private static void loadAlternateFormatsMetadataFromFile(int paramInt)
  {
    // Byte code:
    //   0: ldc 129
    //   2: invokestatic 134	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   5: invokestatic 134	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   8: astore_1
    //   9: ldc 136
    //   11: new 138	java/lang/StringBuilder
    //   14: dup
    //   15: bipush 11
    //   17: aload_1
    //   18: invokevirtual 142	java/lang/String:length	()I
    //   21: iadd
    //   22: invokespecial 144	java/lang/StringBuilder:<init>	(I)V
    //   25: aload_1
    //   26: invokevirtual 148	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   29: iload_0
    //   30: invokevirtual 151	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   33: invokevirtual 152	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   36: invokevirtual 156	java/lang/Class:getResourceAsStream	(Ljava/lang/String;)Ljava/io/InputStream;
    //   39: astore_2
    //   40: aconst_null
    //   41: astore_3
    //   42: new 158	java/io/ObjectInputStream
    //   45: dup
    //   46: aload_2
    //   47: invokespecial 160	java/io/ObjectInputStream:<init>	(Ljava/io/InputStream;)V
    //   50: astore 4
    //   52: new 162	com/google/i18n/phonenumbers/Phonemetadata$PhoneMetadataCollection
    //   55: dup
    //   56: invokespecial 163	com/google/i18n/phonenumbers/Phonemetadata$PhoneMetadataCollection:<init>	()V
    //   59: astore 5
    //   61: aload 5
    //   63: aload 4
    //   65: invokevirtual 167	com/google/i18n/phonenumbers/Phonemetadata$PhoneMetadataCollection:readExternal	(Ljava/io/ObjectInput;)V
    //   68: aload 5
    //   70: invokevirtual 171	com/google/i18n/phonenumbers/Phonemetadata$PhoneMetadataCollection:getMetadataList	()Ljava/util/List;
    //   73: invokeinterface 177 1 0
    //   78: astore 8
    //   80: aload 8
    //   82: invokeinterface 183 1 0
    //   87: ifeq +61 -> 148
    //   90: aload 8
    //   92: invokeinterface 187 1 0
    //   97: checkcast 120	com/google/i18n/phonenumbers/Phonemetadata$PhoneMetadata
    //   100: astore 9
    //   102: getstatic 52	com/google/i18n/phonenumbers/MetadataManager:callingCodeToAlternateFormatsMap	Ljava/util/Map;
    //   105: aload 9
    //   107: invokevirtual 190	com/google/i18n/phonenumbers/Phonemetadata$PhoneMetadata:getCountryCode	()I
    //   110: invokestatic 99	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   113: aload 9
    //   115: invokeinterface 194 3 0
    //   120: pop
    //   121: goto -41 -> 80
    //   124: astore 7
    //   126: aload 4
    //   128: astore_3
    //   129: getstatic 39	com/google/i18n/phonenumbers/MetadataManager:LOGGER	Ljava/util/logging/Logger;
    //   132: getstatic 84	java/util/logging/Level:WARNING	Ljava/util/logging/Level;
    //   135: aload 7
    //   137: invokevirtual 87	java/io/IOException:toString	()Ljava/lang/String;
    //   140: invokevirtual 91	java/util/logging/Logger:log	(Ljava/util/logging/Level;Ljava/lang/String;)V
    //   143: aload_3
    //   144: invokestatic 196	com/google/i18n/phonenumbers/MetadataManager:close	(Ljava/io/InputStream;)V
    //   147: return
    //   148: aload 4
    //   150: invokestatic 196	com/google/i18n/phonenumbers/MetadataManager:close	(Ljava/io/InputStream;)V
    //   153: return
    //   154: astore 6
    //   156: aload_3
    //   157: invokestatic 196	com/google/i18n/phonenumbers/MetadataManager:close	(Ljava/io/InputStream;)V
    //   160: aload 6
    //   162: athrow
    //   163: astore 6
    //   165: aload 4
    //   167: astore_3
    //   168: goto -12 -> 156
    //   171: astore 7
    //   173: aconst_null
    //   174: astore_3
    //   175: goto -46 -> 129
    //
    // Exception table:
    //   from	to	target	type
    //   52	80	124	java/io/IOException
    //   80	121	124	java/io/IOException
    //   42	52	154	finally
    //   129	143	154	finally
    //   52	80	163	finally
    //   80	121	163	finally
    //   42	52	171	java/io/IOException
  }

  // ERROR //
  private static void loadShortNumberMetadataFromFile(String paramString)
  {
    // Byte code:
    //   0: ldc 198
    //   2: invokestatic 134	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   5: astore_1
    //   6: aload_0
    //   7: invokestatic 134	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   10: astore_2
    //   11: aload_2
    //   12: invokevirtual 142	java/lang/String:length	()I
    //   15: ifeq +122 -> 137
    //   18: aload_1
    //   19: aload_2
    //   20: invokevirtual 202	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   23: astore_3
    //   24: ldc 136
    //   26: aload_3
    //   27: invokevirtual 156	java/lang/Class:getResourceAsStream	(Ljava/lang/String;)Ljava/io/InputStream;
    //   30: astore 4
    //   32: aconst_null
    //   33: astore 5
    //   35: new 158	java/io/ObjectInputStream
    //   38: dup
    //   39: aload 4
    //   41: invokespecial 160	java/io/ObjectInputStream:<init>	(Ljava/io/InputStream;)V
    //   44: astore 6
    //   46: new 162	com/google/i18n/phonenumbers/Phonemetadata$PhoneMetadataCollection
    //   49: dup
    //   50: invokespecial 163	com/google/i18n/phonenumbers/Phonemetadata$PhoneMetadataCollection:<init>	()V
    //   53: astore 7
    //   55: aload 7
    //   57: aload 6
    //   59: invokevirtual 167	com/google/i18n/phonenumbers/Phonemetadata$PhoneMetadataCollection:readExternal	(Ljava/io/ObjectInput;)V
    //   62: aload 7
    //   64: invokevirtual 171	com/google/i18n/phonenumbers/Phonemetadata$PhoneMetadataCollection:getMetadataList	()Ljava/util/List;
    //   67: invokeinterface 177 1 0
    //   72: astore 10
    //   74: aload 10
    //   76: invokeinterface 183 1 0
    //   81: ifeq +68 -> 149
    //   84: aload 10
    //   86: invokeinterface 187 1 0
    //   91: checkcast 120	com/google/i18n/phonenumbers/Phonemetadata$PhoneMetadata
    //   94: astore 11
    //   96: getstatic 54	com/google/i18n/phonenumbers/MetadataManager:regionCodeToShortNumberMetadataMap	Ljava/util/Map;
    //   99: aload_0
    //   100: aload 11
    //   102: invokeinterface 194 3 0
    //   107: pop
    //   108: goto -34 -> 74
    //   111: astore 9
    //   113: aload 6
    //   115: astore 5
    //   117: getstatic 39	com/google/i18n/phonenumbers/MetadataManager:LOGGER	Ljava/util/logging/Logger;
    //   120: getstatic 84	java/util/logging/Level:WARNING	Ljava/util/logging/Level;
    //   123: aload 9
    //   125: invokevirtual 87	java/io/IOException:toString	()Ljava/lang/String;
    //   128: invokevirtual 91	java/util/logging/Logger:log	(Ljava/util/logging/Level;Ljava/lang/String;)V
    //   131: aload 5
    //   133: invokestatic 196	com/google/i18n/phonenumbers/MetadataManager:close	(Ljava/io/InputStream;)V
    //   136: return
    //   137: new 131	java/lang/String
    //   140: dup
    //   141: aload_1
    //   142: invokespecial 204	java/lang/String:<init>	(Ljava/lang/String;)V
    //   145: astore_3
    //   146: goto -122 -> 24
    //   149: aload 6
    //   151: invokestatic 196	com/google/i18n/phonenumbers/MetadataManager:close	(Ljava/io/InputStream;)V
    //   154: return
    //   155: astore 8
    //   157: aload 5
    //   159: invokestatic 196	com/google/i18n/phonenumbers/MetadataManager:close	(Ljava/io/InputStream;)V
    //   162: aload 8
    //   164: athrow
    //   165: astore 8
    //   167: aload 6
    //   169: astore 5
    //   171: goto -14 -> 157
    //   174: astore 9
    //   176: aconst_null
    //   177: astore 5
    //   179: goto -62 -> 117
    //
    // Exception table:
    //   from	to	target	type
    //   46	74	111	java/io/IOException
    //   74	108	111	java/io/IOException
    //   35	46	155	finally
    //   117	131	155	finally
    //   46	74	165	finally
    //   74	108	165	finally
    //   35	46	174	java/io/IOException
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.google.i18n.phonenumbers.MetadataManager
 * JD-Core Version:    0.6.2
 */