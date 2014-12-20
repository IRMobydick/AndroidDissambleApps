package co.vine.android;

import android.os.AsyncTask;

class CaptchaActivity$1$1 extends AsyncTask<Void, Void, Void>
{
  protected Void doInBackground(Void[] paramArrayOfVoid)
  {
    AppImpl.getInstance().clearUploadCaptchas(this.this$1.this$0.getApplicationContext());
    return null;
  }
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     co.vine.android.CaptchaActivity.1.1
 * JD-Core Version:    0.6.0
 */