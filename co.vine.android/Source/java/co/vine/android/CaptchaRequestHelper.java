package co.vine.android;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

public abstract class CaptchaRequestHelper
{
  public static final int REQUEST_CODE_CAPTCHA = 11;
  protected static final String STATE_PENDING_CAPTCHA_REQUEST = "state_pending_captcha_request";
  protected PendingCaptchaRequest mPendingCaptchaRequest;

  protected abstract void handleFailedCaptchaRequest(PendingCaptchaRequest paramPendingCaptchaRequest);

  public void handlePendingCaptchaRequest()
  {
    if (this.mPendingCaptchaRequest != null)
    {
      if (this.mPendingCaptchaRequest.state != 3)
        break label32;
      handleFailedCaptchaRequest(this.mPendingCaptchaRequest);
    }
    while (true)
    {
      this.mPendingCaptchaRequest = null;
      return;
      label32: if (this.mPendingCaptchaRequest.state != 2)
        continue;
      handleRetryCaptchaRequest(this.mPendingCaptchaRequest);
    }
  }

  protected abstract void handleRetryCaptchaRequest(PendingCaptchaRequest paramPendingCaptchaRequest);

  public boolean onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    int i;
    switch (paramInt1)
    {
    default:
      i = 0;
      return i;
    case 11:
    }
    String str;
    if ((this.mPendingCaptchaRequest != null) && (paramIntent != null))
    {
      str = paramIntent.getStringExtra("rid");
      if ((paramInt2 != -1) || (!str.equals(this.mPendingCaptchaRequest.reqId)))
        break label80;
    }
    for (this.mPendingCaptchaRequest.state = 2; ; this.mPendingCaptchaRequest.state = 3)
      label80: 
      do
      {
        i = 1;
        break;
      }
      while ((paramInt2 != 2) || (!str.equals(this.mPendingCaptchaRequest.reqId)));
  }

  public void onCaptchaRequired(Activity paramActivity, String paramString1, int paramInt, Bundle paramBundle, String paramString2)
  {
    setPendingCaptchaRequest(new PendingCaptchaRequest(paramString1, paramInt, paramBundle));
    if (paramActivity != null)
      paramActivity.startActivityForResult(CaptchaActivity.getIntent(paramActivity, paramString2, paramString1), 11);
  }

  public void onSaveInstanceState(Bundle paramBundle)
  {
    paramBundle.putParcelable("state_pending_captcha_request", this.mPendingCaptchaRequest);
  }

  public void restorePendingCaptchaRequest(Bundle paramBundle)
  {
    this.mPendingCaptchaRequest = ((PendingCaptchaRequest)paramBundle.getParcelable("state_pending_captcha_request"));
  }

  public void setPendingCaptchaRequest(PendingCaptchaRequest paramPendingCaptchaRequest)
  {
    this.mPendingCaptchaRequest = paramPendingCaptchaRequest;
  }
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     co.vine.android.CaptchaRequestHelper
 * JD-Core Version:    0.6.0
 */