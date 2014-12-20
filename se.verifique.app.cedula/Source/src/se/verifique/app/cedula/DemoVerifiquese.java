package se.verifique.app.cedula;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.ActivityNotFoundException;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.Toast;
import com.google.android.gms.ads.g;
import com.google.b.a.a.au;
import com.google.b.a.a.p;
import java.io.PrintStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import mobi.pdf417.Pdf417MobiScanData;
import mobi.pdf417.Pdf417MobiSettings;
import mobi.pdf417.activity.Pdf417ScanActivity;
import net.photopay.barcode.BarcodeDetailedData;
import se.verifique.app.cedula.a.h;
import se.verifique.app.cedula.util.Parametros;

public class DemoVerifiquese extends Activity
  implements DialogInterface.OnClickListener
{
  private String a = "";
  private String b = "";
  private BarcodeDetailedData c = null;
  private boolean d = false;
  private se.verifique.app.cedula.a.c e = null;
  private boolean f = false;
  private boolean g = false;
  private g h;
  private boolean i = false;

  private String a(List paramList)
  {
    String str = "";
    Iterator localIterator = paramList.iterator();
    while (true)
    {
      if (!localIterator.hasNext())
        return str;
      str = str + (String)localIterator.next() + ",";
    }
  }

  private List a(Parametros paramParametros)
  {
    return se.verifique.app.cedula.util.a.b(paramParametros);
  }

  private void a()
  {
  }

  private void b()
  {
    SharedPreferences localSharedPreferences = getSharedPreferences("Preferences", 0);
    SharedPreferences.Editor localEditor = localSharedPreferences.edit();
    String str = localSharedPreferences.getString("Version", "");
    if (!getString(2131165236).equals(str))
    {
      AlertDialog.Builder localBuilder = new AlertDialog.Builder(this);
      localBuilder.setTitle("Disclaimer").setMessage(getString(2131165283)).setCancelable(false).setPositiveButton("Aceptar", new a(this, localEditor, this)).setNegativeButton("Salir", new b(this, this));
      localBuilder.create().show();
    }
    while (true)
    {
      return;
      int j = 1 + localSharedPreferences.getInt("cantidadAperturas", 0);
      localEditor.putInt("cantidadAperturas", j);
      localEditor.commit();
      if (j % 5 != 4)
        continue;
      this.i = true;
      this.h = new g(this);
      this.h.a("ca-app-pub-1748861609761932/7293727204");
      com.google.android.gms.ads.b localb = new com.google.android.gms.ads.d().a();
      this.h.a(localb);
      c localc = new c(this);
      this.h.a(localc);
    }
  }

  private void c()
  {
    try
    {
      this.e = new se.verifique.app.cedula.a.c(this.c.getAllData());
      this.e.b();
      if (c(this.e.a()))
        b(this.e.c() + " " + this.e.d() + " " + "\n" + this.e.e() + " " + this.e.f() + "\n\nCédula  ACEPTADA");
      else
        b("\n\nCédula  NEGADA");
    }
    catch (se.verifique.app.cedula.b.a locala)
    {
      a(locala.a());
    }
  }

  private boolean c(String paramString)
  {
    Parametros localParametros = (Parametros)getApplicationContext();
    if (localParametros.a == null)
      localParametros.a = a(localParametros);
    if (localParametros.a == null)
      throw new se.verifique.app.cedula.b.a("No se logró descargar Cédulas Aceptadas!. Revise su conexión a internet y que tenga espacio disponible en el Dispositivo!");
    System.out.println("Cedula solciitada en lista=" + paramString + "dentro de:" + a(localParametros.a));
    return localParametros.a.contains(paramString);
  }

  private void d()
  {
    try
    {
      this.e = new se.verifique.app.cedula.a.c(this.c.getAllData());
      this.e.b();
      Intent localIntent = new Intent(this, PrincipalActivity.class);
      h localh = new h();
      localh.a(this.e);
      localIntent.putExtra("se.verifique.app.cedula.PERSONA", localh);
      localIntent.putExtra("se.verifique.app.cedula.TIPO_LECTURA", 2);
      localIntent.putExtra("se.verifique.app.cedula.extra.mostrarmensaje", "NADA");
      startActivity(localIntent);
      return;
    }
    catch (se.verifique.app.cedula.b.a locala)
    {
      while (true)
      {
        String str = new se.verifique.app.cedula.a.d(this.c.getAllData()).a();
        if (str == null)
        {
          a(locala.a());
          continue;
        }
        d(str);
      }
    }
  }

  private void d(String paramString)
  {
    Toast.makeText(getBaseContext(), "Abriendo documento... ", 1).show();
    se.verifique.app.cedula.util.b localb = se.verifique.app.cedula.util.c.b();
    try
    {
      String str = localb.b(paramString);
      try
      {
        Intent localIntent = new Intent("android.intent.action.VIEW");
        localIntent.setDataAndType(Uri.parse("file://" + str), "application/pdf");
        startActivity(localIntent);
        return;
      }
      catch (ActivityNotFoundException localActivityNotFoundException)
      {
        while (true)
          Log.e("No se encuentra un visor PDF.  Instalarlo e intentar nuevamente", localActivityNotFoundException.getMessage());
      }
    }
    catch (se.verifique.app.cedula.b.a locala)
    {
      while (true)
      {
        locala.printStackTrace();
        a("No se logró obtener el Documento del AGN solicitado.");
      }
    }
  }

  public void a(String paramString)
  {
    AlertDialog.Builder localBuilder = new AlertDialog.Builder(this);
    localBuilder.setMessage(paramString);
    localBuilder.setCancelable(true).setTitle("Alerta");
    localBuilder.setCancelable(true);
    localBuilder.create().show();
  }

  public void b(String paramString)
  {
    AlertDialog.Builder localBuilder = new AlertDialog.Builder(this);
    localBuilder.setMessage(paramString);
    localBuilder.setCancelable(true).setTitle("Verificación");
    localBuilder.setPositiveButton("Otra?", this);
    localBuilder.setNegativeButton("Cerrar", null);
    localBuilder.create().show();
  }

  public void btnEscanearCedula_Validar_click(View paramView)
  {
    this.f = true;
    this.g = true;
    btnScan_click_oscar(paramView);
  }

  public void btnEscanearCedula_click(View paramView)
  {
    this.f = true;
    this.g = false;
    btnScan_click_oscar(paramView);
  }

  public void btnEscribirCedula_click(View paramView)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("tipo_lectura", "ESCRIBIR");
    p.a(this).a(localHashMap);
    this.f = true;
    startActivity(new Intent(this, EscribirCedulaActivity.class));
  }

  public void btnInfo_click(View paramView)
  {
    int j = paramView.getId();
    Intent localIntent = new Intent("android.intent.action.VIEW");
    switch (j)
    {
    default:
    case 2131230756:
    case 2131230757:
    case 2131230758:
    }
    while (true)
    {
      startActivity(localIntent);
      return;
      localIntent.setData(Uri.parse("https://twitter.com/verifiquese"));
      continue;
      localIntent.setData(Uri.parse("https://www.facebook.com/verifiquese"));
      continue;
      localIntent.setData(Uri.parse("http://verifique.se"));
    }
  }

  public void btnScan_click(View paramView)
  {
    this.f = false;
    btnScan_click_oscar(paramView);
  }

  public void btnScan_click_oscar(View paramView)
  {
    Log.i("Pdf417MobiDemo", "scan will be performed");
    Intent localIntent = new Intent(this, Pdf417ScanActivity.class);
    localIntent.putExtra("EXTRAS_BEEP_RESOURCE", 2130968576);
    localIntent.putExtra("EXTRAS_BEEP_RESOURCE", 2130968576);
    Pdf417MobiSettings localPdf417MobiSettings = new Pdf417MobiSettings();
    localPdf417MobiSettings.setPdf417Enabled(true);
    localPdf417MobiSettings.setNullQuietZoneAllowed(true);
    localPdf417MobiSettings.setQrCodeEnabled(true);
    localPdf417MobiSettings.setDontShowDialog(this.f);
    localPdf417MobiSettings.setRemoveOverlayEnabled(true);
    localIntent.putExtra("EXTRAS_SETTINGS", localPdf417MobiSettings);
    p localp = p.a(this);
    localp.a("&cd", "SCAN PDF417");
    localp.a(au.a("UX", "OPEN", "SCANPDF417", null).a());
    startActivityForResult(localIntent, 1337);
  }

  public void descargarCedulas_click(View paramView)
  {
    Parametros localParametros = (Parametros)getApplicationContext();
    if (se.verifique.app.cedula.util.a.a(localParametros))
    {
      localParametros.a = a(localParametros);
      a("Cédulas Aceptadas DESCARGADAS!");
    }
    while (true)
    {
      return;
      a("No se logró descargar Cédulas Aceptadas!. Revise su conexión a internet y que tenga espacio disponible en el Dispositivo!");
    }
  }

  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    int j = 0;
    HashMap localHashMap = new HashMap();
    localHashMap.put("tipo_lectura", "SCAN");
    p.a(this).a(localHashMap);
    if ((paramInt1 == 1337) && (paramInt2 == 1))
    {
      Pdf417MobiScanData localPdf417MobiScanData = (Pdf417MobiScanData)paramIntent.getParcelableExtra("EXTRAS_RESULT");
      this.a = localPdf417MobiScanData.getBarcodeType();
      this.b = localPdf417MobiScanData.getBarcodeData();
      this.c = localPdf417MobiScanData.getBarcodeRawData();
      this.d = localPdf417MobiScanData.isResultUncertain();
      if (!this.f)
        break label134;
      if ("PDF417".equals(this.a))
      {
        if (this.g)
          break label127;
        d();
      }
    }
    label127: Intent localIntent2;
    label134: StringBuilder localStringBuilder;
    while (true)
    {
      return;
      c();
      continue;
      String str = "";
      int k = 0;
      if (k >= this.c.getAllData().length)
        Log.e("Pdf417MobilDemo", str);
      try
      {
        new URL(this.b);
        m = 1;
        if (m != 0)
        {
          Intent localIntent1 = new Intent("android.intent.action.VIEW");
          localIntent1.setData(Uri.parse(this.b));
          startActivity(localIntent1);
          continue;
          str = str + "P=" + k + ":N=" + this.c.getAllData()[k] + ":A=" + (char)this.c.getAllData()[k] + '\n';
          k++;
        }
      }
      catch (MalformedURLException localMalformedURLException)
      {
        while (true)
          int m = 0;
        localIntent2 = new Intent("android.intent.action.SEND");
        localIntent2.setType("text/plain");
        localStringBuilder = new StringBuilder();
        if (this.d)
          localStringBuilder.append("This scan data is uncertain!\n\n");
        localStringBuilder.append(this.a);
        localStringBuilder.append(": ");
        localStringBuilder.append(this.b);
        localStringBuilder.append(": ");
        localStringBuilder.append(str);
        if (this.c == null)
          break label468;
      }
    }
    localStringBuilder.append("\n\n\n raw data:\n\n");
    localStringBuilder.append(this.c.toString());
    localStringBuilder.append("\n\n\n raw data merged:\n\n");
    byte[] arrayOfByte = this.c.getAllData();
    localStringBuilder.append("{");
    while (true)
    {
      if (j >= arrayOfByte.length)
      {
        localStringBuilder.append("}");
        label468: localIntent2.putExtra("android.intent.extra.TEXT", localStringBuilder.toString());
        startActivity(Intent.createChooser(localIntent2, getString(2131165231)));
        break;
      }
      localStringBuilder.append(0xFF & arrayOfByte[j]);
      if (j != -1 + arrayOfByte.length)
        localStringBuilder.append(", ");
      j++;
    }
  }

  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    btnEscanearCedula_Validar_click(null);
  }

  @SuppressLint({"NewApi"})
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    b();
    se.verifique.app.cedula.util.c.a();
    getWindow().setFlags(1024, 1024);
    getWindow().requestFeature(1);
    setContentView(2130903043);
    if (!this.i)
      a();
    Parametros.a(this);
  }

  public boolean onCreateOptionsMenu(Menu paramMenu)
  {
    getMenuInflater().inflate(2130903059, paramMenu);
    return true;
  }

  public boolean onOptionsItemSelected(MenuItem paramMenuItem)
  {
    switch (paramMenuItem.getItemId())
    {
    default:
    case 2131230776:
    }
    for (int j = 0; ; j = 1)
      return j;
  }

  public void onStart()
  {
    super.onStart();
    p.a(this).a(this);
  }

  public void onStop()
  {
    super.onStop();
    p.a(this).b(this);
  }
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     se.verifique.app.cedula.DemoVerifiquese
 * JD-Core Version:    0.6.0
 */