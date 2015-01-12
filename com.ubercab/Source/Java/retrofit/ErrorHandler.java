package retrofit;

public abstract interface ErrorHandler
{
  public static final ErrorHandler DEFAULT = new ErrorHandler()
  {
    public Throwable handleError(RetrofitError paramAnonymousRetrofitError)
    {
      return paramAnonymousRetrofitError;
    }
  };

  public abstract Throwable handleError(RetrofitError paramRetrofitError);
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     retrofit.ErrorHandler
 * JD-Core Version:    0.6.2
 */