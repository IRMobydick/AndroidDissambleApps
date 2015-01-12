package com.google.android.gms.auth.api;

import android.app.PendingIntent;
import com.google.android.gms.common.api.Status;

public class GoogleAuthApiException extends Exception
{
  private Status CM;
  private PendingIntent mPendingIntent;

  public GoogleAuthApiException(String paramString, Status paramStatus)
  {
    super(paramString);
    this.CM = paramStatus;
  }

  public GoogleAuthApiException(String paramString, Status paramStatus, PendingIntent paramPendingIntent)
  {
    super(paramString);
    this.CM = paramStatus;
    this.mPendingIntent = paramPendingIntent;
  }

  public PendingIntent getPendingIntent()
  {
    return this.mPendingIntent;
  }

  public Status getStatus()
  {
    return this.CM;
  }

  public boolean isUserRecoverable()
  {
    return this.mPendingIntent != null;
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.google.android.gms.auth.api.GoogleAuthApiException
 * JD-Core Version:    0.6.2
 */