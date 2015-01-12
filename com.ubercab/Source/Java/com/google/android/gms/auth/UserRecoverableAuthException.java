package com.google.android.gms.auth;

import android.content.Intent;

public class UserRecoverableAuthException extends GoogleAuthException
{
  private final Intent mIntent;

  public UserRecoverableAuthException(String paramString, Intent paramIntent)
  {
    super(paramString);
    this.mIntent = paramIntent;
  }

  public Intent getIntent()
  {
    if (this.mIntent == null)
      return null;
    return new Intent(this.mIntent);
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.google.android.gms.auth.UserRecoverableAuthException
 * JD-Core Version:    0.6.2
 */