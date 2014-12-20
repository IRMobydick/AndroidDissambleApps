package se.verifique.app.cedula;

import android.content.Intent;
import android.os.AsyncTask;
import se.verifique.app.cedula.b.a;
import se.verifique.app.cedula.util.b;
import se.verifique.app.cedula.util.c;

public class h extends AsyncTask
{
  public h(EscribirCedulaActivity paramEscribirCedulaActivity)
  {
  }

  protected Boolean a(Void[] paramArrayOfVoid)
  {
    try
    {
      se.verifique.app.cedula.a.h localh = c.b().a(EscribirCedulaActivity.a(this.a));
      if (localh != null)
      {
        Intent localIntent = new Intent(EscribirCedulaActivity.b(this.a), PrincipalActivity.class);
        localIntent.putExtra("se.verifique.app.cedula.TIPO_LECTURA", 1);
        localIntent.putExtra("se.verifique.app.cedula.extra.mostrarmensaje", "NADA");
        localIntent.putExtra("se.verifique.app.cedula.PERSONA", localh);
        this.a.startActivity(localIntent);
        localBoolean = Boolean.valueOf(true);
        return localBoolean;
      }
    }
    catch (a locala)
    {
      while (true)
      {
        String str = locala.a();
        EscribirCedulaActivity.b(this.a).runOnUiThread(new i(this, str));
        Boolean localBoolean = Boolean.valueOf(false);
        continue;
        localBoolean = Boolean.valueOf(false);
      }
    }
  }

  protected void a(Boolean paramBoolean)
  {
    EscribirCedulaActivity.a(this.a, null);
    EscribirCedulaActivity.a(this.a, false);
    paramBoolean.booleanValue();
  }

  protected void onCancelled()
  {
    EscribirCedulaActivity.a(this.a, null);
    EscribirCedulaActivity.a(this.a, false);
  }
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     se.verifique.app.cedula.h
 * JD-Core Version:    0.6.0
 */