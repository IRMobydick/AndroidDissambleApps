package com.ubercab.client.core.push;

import android.text.TextUtils;
import com.ubercab.client.core.app.RiderPreferences;
import com.ubercab.client.core.model.Ping;
import com.ubercab.client.core.network.RiderClient;
import com.ubercab.library.network.dispatch.DispatchCallback;
import com.ubercab.library.network.dispatch.DispatchRequest;
import retrofit.RetrofitError;
import retrofit.client.Response;

public class RiderPushManager
{
  private static final String TAG = "RiderPushManager";
  private RiderPreferences mPreferences;
  private PushProvider mPushProvider;
  private RiderClient mRiderClient;

  public RiderPushManager(RiderClient paramRiderClient, PushProvider paramPushProvider, RiderPreferences paramRiderPreferences)
  {
    this.mRiderClient = paramRiderClient;
    this.mPushProvider = paramPushProvider;
    this.mPreferences = paramRiderPreferences;
  }

  public void register()
  {
    try
    {
      if ((this.mPreferences.isRegisteredWithNotifier()) && (!TextUtils.isEmpty(this.mPushProvider.getRegistrationId())))
        return;
      this.mPushProvider.register(new PushProvider.RegisterCallback()
      {
        public void onRegistered(String paramAnonymousString1, String paramAnonymousString2)
        {
          // Byte code:
          //   0: aload_0
          //   1: getfield 17	com/ubercab/client/core/push/RiderPushManager$1:this$0	Lcom/ubercab/client/core/push/RiderPushManager;
          //   4: invokestatic 25	com/ubercab/client/core/push/RiderPushManager:access$200	(Lcom/ubercab/client/core/push/RiderPushManager;)Lcom/ubercab/client/core/network/RiderClient;
          //   7: aload_1
          //   8: aload_2
          //   9: new 27	com/ubercab/client/core/push/RiderPushManager$1$1
          //   12: dup
          //   13: aload_0
          //   14: invokespecial 30	com/ubercab/client/core/push/RiderPushManager$1$1:<init>	(Lcom/ubercab/client/core/push/RiderPushManager$1;)V
          //   17: invokeinterface 36 4 0
          //   22: return
        }
      });
      return;
    }
    catch (Exception localException)
    {
    }
  }

  public void unregister(final String paramString)
  {
    try
    {
      if ((!this.mPreferences.isRegisteredWithNotifier()) && (TextUtils.isEmpty(this.mPushProvider.getRegistrationId())))
        return;
      this.mPushProvider.unregister(new PushProvider.UnregisterCallback()
      {
        public void onUnregistered(String paramAnonymousString1, String paramAnonymousString2)
        {
          // Byte code:
          //   0: aload_0
          //   1: getfield 19	com/ubercab/client/core/push/RiderPushManager$2:this$0	Lcom/ubercab/client/core/push/RiderPushManager;
          //   4: invokestatic 30	com/ubercab/client/core/push/RiderPushManager:access$200	(Lcom/ubercab/client/core/push/RiderPushManager;)Lcom/ubercab/client/core/network/RiderClient;
          //   7: aload_0
          //   8: getfield 21	com/ubercab/client/core/push/RiderPushManager$2:val$sessionToken	Ljava/lang/String;
          //   11: aload_1
          //   12: aload_2
          //   13: new 32	com/ubercab/client/core/push/RiderPushManager$2$1
          //   16: dup
          //   17: aload_0
          //   18: invokespecial 35	com/ubercab/client/core/push/RiderPushManager$2$1:<init>	(Lcom/ubercab/client/core/push/RiderPushManager$2;)V
          //   21: invokeinterface 41 5 0
          //   26: return
        }
      });
      return;
    }
    catch (Exception localException)
    {
    }
  }

  private static abstract class Callback
    implements DispatchCallback<Ping>
  {
    public abstract void onComplete(boolean paramBoolean);

    public void onDispatchError(DispatchRequest paramDispatchRequest, Ping paramPing, Response paramResponse)
    {
      onComplete(false);
    }

    public void onDispatchNetworkError(DispatchRequest paramDispatchRequest, RetrofitError paramRetrofitError)
    {
      onComplete(false);
    }

    public void onDispatchSuccess(DispatchRequest paramDispatchRequest, Ping paramPing, Response paramResponse)
    {
      onComplete(true);
    }
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.client.core.push.RiderPushManager
 * JD-Core Version:    0.6.2
 */