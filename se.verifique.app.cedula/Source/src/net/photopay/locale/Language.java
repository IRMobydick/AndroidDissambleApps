package net.photopay.locale;

public enum Language
{
  private String mCountry;
  private String mLanguage;

  static
  {
    English = new Language("English", 2, "en", null);
    German = new Language("German", 3, "de", null);
    Dutch = new Language("Dutch", 4, "nl", null);
    Hungarian = new Language("Hungarian", 5, "hu", null);
    French = new Language("French", 6, "fr", null);
    Language[] arrayOfLanguage = new Language[7];
    arrayOfLanguage[0] = Croatian;
    arrayOfLanguage[1] = Slovenian;
    arrayOfLanguage[2] = English;
    arrayOfLanguage[3] = German;
    arrayOfLanguage[4] = Dutch;
    arrayOfLanguage[5] = Hungarian;
    arrayOfLanguage[6] = French;
    $VALUES = arrayOfLanguage;
  }

  private Language(String arg3, String arg4)
  {
    Object localObject1;
    this.mLanguage = localObject1;
    Object localObject2;
    this.mCountry = localObject2;
  }

  public final String getCountry()
  {
    return this.mCountry;
  }

  public final String getLanguage()
  {
    return this.mLanguage;
  }
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     net.photopay.locale.Language
 * JD-Core Version:    0.6.0
 */