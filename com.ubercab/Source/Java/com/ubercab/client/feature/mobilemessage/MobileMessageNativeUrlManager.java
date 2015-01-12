package com.ubercab.client.feature.mobilemessage;

import android.content.Context;
import android.net.Uri;
import com.squareup.otto.Bus;
import com.ubercab.client.core.app.RiderApplication;
import com.ubercab.client.feature.mobilemessage.handler.CancelHandler;
import com.ubercab.client.feature.mobilemessage.handler.ConfirmActionHandler;
import com.ubercab.client.feature.mobilemessage.handler.OpenBrowserHandler;
import com.ubercab.client.feature.mobilemessage.handler.OpenPaymentHandler;
import com.ubercab.client.feature.mobilemessage.handler.OpenProfileHandler;
import com.ubercab.client.feature.mobilemessage.handler.OpenUrlHandler;
import com.ubercab.client.feature.mobilemessage.handler.ShareClipboardHandler;
import com.ubercab.client.feature.mobilemessage.handler.ShareEmailHandler;
import com.ubercab.client.feature.mobilemessage.handler.ShareFacebookHandler;
import com.ubercab.client.feature.mobilemessage.handler.ShareGenericHandler;
import com.ubercab.client.feature.mobilemessage.handler.ShareMessageHandler;
import com.ubercab.client.feature.mobilemessage.handler.ShareTwitterHandler;
import com.ubercab.client.feature.mobilemessage.handler.UriNotSupportedHandler;
import com.ubercab.common.collect.ImmutableMap.Builder;
import java.util.Map;
import javax.inject.Inject;

public class MobileMessageNativeUrlManager
{
  private static final String HTTP_PROTOCOL = "http";
  public static final String NATIVE_PROTOCOL = "native://";
  private static final String SHARE_AUTHORITY = "share_";

  @Inject
  Bus mBus;
  private Map<String, NativeUriHandler> mMapHandlers;

  MobileMessageNativeUrlManager(Context paramContext)
  {
    RiderApplication.get(paramContext).inject(this);
    this.mMapHandlers = new ImmutableMap.Builder().put("cancel_button_tap", new CancelHandler()).put("confirm_action", new ConfirmActionHandler(this.mBus)).put("open_url_in_safari", new OpenBrowserHandler()).put("open_url_in_internal_browser", new OpenBrowserHandler()).put("share_email", new ShareEmailHandler()).put("share_facebook", new ShareFacebookHandler()).put("share_message", new ShareMessageHandler()).put("share_clipboard", new ShareClipboardHandler()).put("share_twitter", new ShareTwitterHandler()).put("show_add_payment_modal", new OpenPaymentHandler()).put("show_profile", new OpenProfileHandler()).build();
  }

  public NativeUriHandler getHandler(String paramString)
  {
    if (paramString == null)
      throw new NullPointerException();
    if (paramString.startsWith("native://"))
    {
      Uri localUri = Uri.parse(paramString);
      NativeUriHandler localNativeUriHandler = (NativeUriHandler)this.mMapHandlers.get(localUri.getAuthority());
      if (localNativeUriHandler != null)
        return localNativeUriHandler;
      if (localUri.getAuthority().startsWith("share_"))
        return new ShareGenericHandler();
      return new UriNotSupportedHandler();
    }
    if (paramString.startsWith("http"))
      return new OpenUrlHandler();
    return new UriNotSupportedHandler();
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.client.feature.mobilemessage.MobileMessageNativeUrlManager
 * JD-Core Version:    0.6.2
 */