package se.verifique.app.cedula;

import android.annotation.TargetApi;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.v4.app.x;
import android.util.Log;
import android.view.View;
import android.view.ViewPropertyAnimator;
import android.webkit.MimeTypeMap;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.google.android.gms.ads.d;
import com.google.android.gms.ads.e;
import com.google.android.gms.ads.f;
import com.google.b.a.a.au;
import java.io.PrintStream;
import java.util.Map;
import se.verifique.app.cedula.a.g;
import se.verifique.app.cedula.util.Parametros;

public class PrincipalActivity extends android.support.v4.app.h
  implements p
{
  private static v r;
  private static String u;
  private boolean n = false;
  private se.verifique.app.cedula.a.h o = se.verifique.app.cedula.a.h.a();
  private String p;
  private PrincipalActivity q;
  private View s;
  private TextView t;
  private f v;

  private String a(String paramString, se.verifique.app.cedula.a.h paramh)
  {
    if (paramString.contains("(%cedula%)"))
      paramString = paramString.replace("(%cedula%)", paramh.f());
    while (true)
    {
      return paramString;
      if (!paramString.contains("(%nombrecompleto%)"))
        continue;
      paramString = paramString.replace("(%nombrecompleto%)", paramh.d() + " " + paramh.e());
    }
  }

  private void a(String paramString, boolean paramBoolean)
  {
    u = paramString;
    this.t.setText(u + "\n\n" + "Esto puede tardar unos instantes...");
    b(true);
    if (paramBoolean)
    {
      r = new v(this);
      v localv = r;
      Void[] arrayOfVoid = new Void[1];
      arrayOfVoid[0] = null;
      localv.execute(arrayOfVoid);
    }
  }

  @TargetApi(13)
  private void b(boolean paramBoolean)
  {
    int i = 0;
    if (Build.VERSION.SDK_INT >= 13)
    {
      int k = getResources().getInteger(17694720);
      this.s.setVisibility(0);
      ViewPropertyAnimator localViewPropertyAnimator = this.s.animate().setDuration(k);
      if (paramBoolean)
        i = 1;
      localViewPropertyAnimator.alpha(i).setListener(new t(this, paramBoolean));
      return;
    }
    View localView = this.s;
    if (paramBoolean);
    while (true)
    {
      localView.setVisibility(i);
      break;
      int j = 8;
    }
  }

  private void c(String paramString)
  {
    try
    {
      Intent localIntent = new Intent("android.intent.action.VIEW");
      localIntent.setDataAndType(Uri.parse("file://" + paramString), "application/pdf");
      startActivity(localIntent);
      return;
    }
    catch (ActivityNotFoundException localActivityNotFoundException)
    {
      while (true)
        Log.e("No se encuentra un visor para el Documento.  Instalarlo e intentar nuevamente", localActivityNotFoundException.getMessage());
    }
  }

  private void f()
  {
    SharedPreferences localSharedPreferences = getSharedPreferences("Preferences", 0);
    SharedPreferences.Editor localEditor = localSharedPreferences.edit();
    String str1 = localSharedPreferences.getString("VersionMenu", "");
    se.verifique.app.cedula.util.c.a();
    String str2 = se.verifique.app.cedula.util.c.b().b();
    if (str2.equals(str1))
      se.verifique.app.cedula.c.a.b((Parametros)getApplicationContext());
    while (true)
    {
      return;
      se.verifique.app.cedula.c.a.a((Parametros)getApplicationContext());
      localEditor.putString("VersionMenu", str2);
      localEditor.commit();
    }
  }

  public void b(String paramString)
  {
    AlertDialog.Builder localBuilder = new AlertDialog.Builder(this);
    localBuilder.setTitle("Noticia");
    if (("VFQ-TO".equals(paramString)) || ("ERROR".equals(paramString)))
      localBuilder.setMessage(getResources().getString(2131165273));
    while (true)
    {
      localBuilder.setCancelable(false);
      localBuilder.setPositiveButton("OK", new u(this));
      localBuilder.create().show();
      return;
      localBuilder.setMessage(paramString);
    }
  }

  public void b_(String paramString)
  {
    if (r == null)
    {
      this.p = paramString;
      if (!this.n)
        break label66;
      Bundle localBundle = new Bundle();
      localBundle.putString("item_id", paramString);
      n localn = new n();
      localn.b(localBundle);
      e().a().b(2131230766, localn).a();
    }
    while (true)
    {
      return;
      label66: g localg = (g)((Parametros)getApplicationContext()).a().get(paramString);
      if (localg.b().equals("1"))
      {
        if (paramString.equals("1"))
        {
          Intent localIntent2 = new Intent(this, DetalleActivity.class);
          localIntent2.putExtra("se.verifique.app.cedula.PERSONA", this.o);
          startActivity(localIntent2);
          continue;
        }
        if (paramString.equals("2"))
        {
          Intent localIntent3 = new Intent("android.intent.action.SEND");
          localIntent3.setType("text/plain");
          StringBuilder localStringBuilder = new StringBuilder();
          if (this.o.c() == null)
          {
            localStringBuilder.append(Parametros.b().getString(2131165316) + "=");
            localStringBuilder.append(this.o.f());
            localStringBuilder.append("\n");
            localStringBuilder.append("Nombres=");
            localStringBuilder.append(this.o.d());
            localStringBuilder.append("\n");
            localStringBuilder.append("Apellidos=");
            localStringBuilder.append(this.o.e());
            localStringBuilder.append("\n");
          }
          while (true)
          {
            localIntent3.putExtra("android.intent.extra.TEXT", localStringBuilder.toString());
            startActivity(Intent.createChooser(localIntent3, getString(2131165231)));
            break;
            localStringBuilder.append(Parametros.b().getString(2131165316) + "=");
            localStringBuilder.append(this.o.f());
            localStringBuilder.append("\n");
            localStringBuilder.append("Primer Nombre=");
            localStringBuilder.append(this.o.c().c());
            localStringBuilder.append("\n");
            localStringBuilder.append("Segundo Nombre=");
            localStringBuilder.append(this.o.c().d());
            localStringBuilder.append("\n");
            localStringBuilder.append("Primer Apellido=");
            localStringBuilder.append(this.o.c().e());
            localStringBuilder.append("\n");
            localStringBuilder.append("Segundo Apellido=");
            localStringBuilder.append(this.o.c().f());
            localStringBuilder.append("\n");
            localStringBuilder.append("Fecha Nacimiento=");
            localStringBuilder.append(this.o.c().g());
            localStringBuilder.append("\n");
            localStringBuilder.append("Tipo Sangre(de la cedula)=");
            localStringBuilder.append(this.o.c().h());
            localStringBuilder.append("\n");
          }
        }
        if (paramString.equals("3"))
        {
          if (r != null)
            continue;
          a(Parametros.b().getString(2131165278), true);
          continue;
        }
        if (paramString.equals("4"))
        {
          if (r != null)
            continue;
          a(Parametros.b().getString(2131165279), true);
          continue;
        }
        if (paramString.equals("5"))
        {
          if (r != null)
            continue;
          a(Parametros.b().getString(2131165280), true);
          continue;
        }
        if (paramString.equals("6"))
        {
          if (r != null)
            continue;
          a(Parametros.b().getString(2131165281), true);
          continue;
        }
        if (paramString.equals("7"))
        {
          if (r != null)
            continue;
          a(Parametros.b().getString(2131165282), true);
          continue;
        }
        if (paramString.equals("8"))
        {
          if (r != null)
            continue;
          a(Parametros.b().getString(2131165285), true);
          continue;
        }
        if (paramString.equals("9"))
        {
          Toast.makeText(getBaseContext(), "Abriendo documento...", 1).show();
          se.verifique.app.cedula.util.b localb = se.verifique.app.cedula.util.c.b();
          try
          {
            c(localb.c(this.o.f()));
          }
          catch (se.verifique.app.cedula.b.a locala)
          {
            locala.printStackTrace();
            b("No se logró obtener el Documento del AGN solicitado.");
          }
          continue;
        }
        if (paramString.equals("10"))
        {
          if (r != null)
            continue;
          a(Parametros.b().getString(2131165286), true);
          continue;
        }
        if (paramString.equals("11"))
        {
          if (r != null)
            continue;
          startActivity(new Intent(this, EscribirPlacaActivity.class));
          continue;
        }
        if (paramString.equals("12"))
        {
          if (r != null)
            continue;
          a(Parametros.b().getString(2131165288), true);
          continue;
        }
        if ((!paramString.equals("13")) || (r != null))
          continue;
        a(Parametros.b().getString(2131165289), true);
        continue;
      }
      if (!localg.b().equals("2"))
        continue;
      try
      {
        com.google.b.a.a.p localp = com.google.b.a.a.p.a(this);
        localp.a("&cd", "ENLACE EXTERNO");
        localp.a(au.a(localg.c(), "OPCIONES", "OPEN", null).a());
        Toast.makeText(this, "Abriendo el navegador para acceder a la página de la información solicitada!", 1).show();
        Intent localIntent1 = new Intent();
        localIntent1.setAction("android.intent.action.VIEW");
        localIntent1.setDataAndType(Uri.parse(a(localg.d(), this.o)), MimeTypeMap.getSingleton().getMimeTypeFromExtension(".HTML"));
        startActivity(localIntent1);
      }
      catch (ActivityNotFoundException localActivityNotFoundException)
      {
        Toast.makeText(this, "No se encontró una aplicación para abrir la página solicitada, por favor instale un navegador.", 1).show();
        localActivityNotFoundException.printStackTrace();
      }
    }
  }

  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.q = this;
    f();
    Bundle localBundle = getIntent().getExtras();
    this.n = false;
    this.o = ((se.verifique.app.cedula.a.h)localBundle.get("se.verifique.app.cedula.PERSONA"));
    String str = localBundle.getString("se.verifique.app.cedula.extra.mostrarmensaje");
    setTitle(this.o.f() + ": " + this.o.d() + " " + this.o.e());
    setContentView(2130903048);
    this.s = findViewById(2131230760);
    this.t = ((TextView)findViewById(2131230761));
    if (!"NADA".equals(str))
      b(str);
    Parametros.a(this);
    if (r != null)
    {
      a(u, false);
      this.v = new f(this);
      if (this.v != null)
      {
        this.v.setAdUnitId("ca-app-pub-1748861609761932/2440970404");
        this.v.setAdSize(e.g);
        LinearLayout localLinearLayout = (LinearLayout)findViewById(2131230768);
        if (localLinearLayout == null)
          break label268;
        localLinearLayout.addView(this.v);
        com.google.android.gms.ads.b localb = new d().a();
        this.v.a(localb);
      }
    }
    while (true)
    {
      return;
      System.out.println("TEST onCreate... No está ejecutando el Hilo...");
      break;
      label268: this.v = null;
    }
  }

  protected void onDestroy()
  {
    super.onDestroy();
    System.out.println("TEST onDESTROY Principal...");
    if (r != null)
    {
      r.a();
      r.cancel(true);
      r = null;
    }
  }

  public void onStart()
  {
    super.onStart();
    com.google.b.a.a.p.a(this).a(this);
  }

  public void onStop()
  {
    super.onStop();
    com.google.b.a.a.p.a(this).b(this);
  }
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     se.verifique.app.cedula.PrincipalActivity
 * JD-Core Version:    0.6.0
 */