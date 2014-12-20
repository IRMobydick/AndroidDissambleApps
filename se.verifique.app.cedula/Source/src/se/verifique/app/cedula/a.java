package se.verifique.app.cedula;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.SharedPreferences.Editor;

class a
  implements DialogInterface.OnClickListener
{
  a(DemoVerifiquese paramDemoVerifiquese, SharedPreferences.Editor paramEditor, Activity paramActivity)
  {
  }

  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    this.b.putString("Version", this.c.getString(2131165236));
    this.b.commit();
    paramDialogInterface.cancel();
  }
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     se.verifique.app.cedula.a
 * JD-Core Version:    0.6.0
 */