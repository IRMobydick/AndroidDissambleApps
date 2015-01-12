package com.squareup.picasso;

public abstract interface Callback
{
  public abstract void onError();

  public abstract void onSuccess();

  public static class EmptyCallback
    implements Callback
  {
    public void onError()
    {
    }

    public void onSuccess()
    {
    }
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.squareup.picasso.Callback
 * JD-Core Version:    0.6.2
 */