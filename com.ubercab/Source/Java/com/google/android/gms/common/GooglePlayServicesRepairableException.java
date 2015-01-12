package com.google.android.gms.common;

import android.content.Intent;

public class GooglePlayServicesRepairableException extends UserRecoverableException
{
  private final int Dr;

  GooglePlayServicesRepairableException(int paramInt, String paramString, Intent paramIntent)
  {
    super(paramString, paramIntent);
    this.Dr = paramInt;
  }

  public int getConnectionStatusCode()
  {
    return this.Dr;
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.google.android.gms.common.GooglePlayServicesRepairableException
 * JD-Core Version:    0.6.2
 */