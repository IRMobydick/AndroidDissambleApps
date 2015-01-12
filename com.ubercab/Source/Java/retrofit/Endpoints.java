package retrofit;

public final class Endpoints
{
  private static final String DEFAULT_NAME = "default";

  public static Endpoint newFixedEndpoint(String paramString)
  {
    return new FixedEndpoint(paramString, "default");
  }

  public static Endpoint newFixedEndpoint(String paramString1, String paramString2)
  {
    return new FixedEndpoint(paramString1, paramString2);
  }

  private static class FixedEndpoint
    implements Endpoint
  {
    private final String apiUrl;
    private final String name;

    FixedEndpoint(String paramString1, String paramString2)
    {
      this.apiUrl = paramString1;
      this.name = paramString2;
    }

    public String getName()
    {
      return this.name;
    }

    public String getUrl()
    {
      return this.apiUrl;
    }
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     retrofit.Endpoints
 * JD-Core Version:    0.6.2
 */