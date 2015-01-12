package com.google.android.gms.internal;

import android.content.Intent;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.o;
import com.google.android.gms.panorama.PanoramaApi.PanoramaResult;

class ne
  implements PanoramaApi.PanoramaResult
{
  private final Status CM;
  private final Intent akC;

  public ne(Status paramStatus, Intent paramIntent)
  {
    this.CM = ((Status)o.i(paramStatus));
    this.akC = paramIntent;
  }

  public Status getStatus()
  {
    return this.CM;
  }

  public Intent getViewerIntent()
  {
    return this.akC;
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ne
 * JD-Core Version:    0.6.2
 */