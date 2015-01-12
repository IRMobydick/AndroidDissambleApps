package com.ubercab.client.feature.mobilemessage;

import android.content.Context;
import com.ubercab.client.core.model.MobileMessage;

public abstract interface NativeUriHandler
{
  public abstract HandlerResult handle(Context paramContext, MobileMessage paramMobileMessage, String paramString);
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.client.feature.mobilemessage.NativeUriHandler
 * JD-Core Version:    0.6.2
 */