package se.verifique.app.cedula;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.ActivityNotFoundException;
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
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import mobi.pdf417.Pdf417MobiScanData;
import mobi.pdf417.Pdf417MobiSettings;
import mobi.pdf417.activity.Pdf417ScanActivity;
import net.photopay.barcode.BarcodeDetailedData;
import se.verifique.app.cedula.a.h;
import se.verifique.app.cedula.b.a;
import se.verifique.app.cedula.util.Parametros;

public class Pdf417MobiDemo extends Activity
{
  private String a = "";
  private String b = "";
  private BarcodeDetailedData c = null;
  private boolean d = false;
  private se.verifique.app.cedula.a.c e = null;
  private boolean f = false;
  private g g;
  private boolean h = false;

  private void a()
  {
    findViewById(2131230755).setVisibility(0);
    findViewById(2131230754).setVisibility(0);
    findViewById(2131230757).setVisibility(0);
    findViewById(2131230758).setVisibility(0);
    findViewById(2131230756).setVisibility(0);
    findViewById(2131230751).setVisibility(8);
  }

  private void b()
  {
    SharedPreferences localSharedPreferences = getSharedPreferences("Preferences", 0);
    SharedPreferences.Editor localEditor = localSharedPreferences.edit();
    String str = localSharedPreferences.getString("Version", "");
    if (!getString(2131165236).equals(str))
    {
      AlertDialog.Builder localBuilder = new AlertDialog.Builder(this);
      localBuilder.setTitle("Disclaimer").setMessage(getString(2131165283)).setCancelable(false).setPositiveButton("Aceptar", new q(this, localEditor, this)).setNegativeButton("Salir", new r(this, this));
      localBuilder.create().show();
    }
    while (true)
    {
      return;
      int i = 1 + localSharedPreferences.getInt("cantidadAperturas", 0);
      localEditor.putInt("cantidadAperturas", i);
      localEditor.commit();
      if (i % 5 != 4)
        continue;
      this.h = true;
      this.g = new g(this);
      this.g.a("ca-app-pub-1748861609761932/7293727204");
      com.google.android.gms.ads.b localb = new com.google.android.gms.ads.d().a();
      this.g.a(localb);
      s locals = new s(this);
      this.g.a(locals);
    }
  }

  private void b(String paramString)
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
    catch (a locala)
    {
      while (true)
      {
        locala.printStackTrace();
        a("No se logró obtener el Documento del AGN solicitado.");
      }
    }
  }

  private void c()
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
    catch (a locala)
    {
      while (true)
      {
        String str = new se.verifique.app.cedula.a.d(this.c.getAllData()).a();
        if (str == null)
        {
          a(locala.a());
          continue;
        }
        b(str);
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

  public void btnEscanearCedula_click(View paramView)
  {
    this.f = true;
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
    int i = paramView.getId();
    Intent localIntent = new Intent("android.intent.action.VIEW");
    switch (i)
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

  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    int i = 0;
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
        break label120;
      if ("PDF417".equals(this.a))
        c();
    }
    label120: Intent localIntent2;
    StringBuilder localStringBuilder;
    while (true)
    {
      return;
      String str = "";
      int j = 0;
      if (j >= this.c.getAllData().length)
        Log.e("Pdf417MobilDemo", str);
      try
      {
        new URL(this.b);
        k = 1;
        if (k != 0)
        {
          Intent localIntent1 = new Intent("android.intent.action.VIEW");
          localIntent1.setData(Uri.parse(this.b));
          startActivity(localIntent1);
          continue;
          str = str + "P=" + j + ":N=" + this.c.getAllData()[j] + ":A=" + (char)this.c.getAllData()[j] + '\n';
          j++;
        }
      }
      catch (MalformedURLException localMalformedURLException)
      {
        while (true)
          int k = 0;
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
          break label453;
      }
    }
    localStringBuilder.append("\n\n\n raw data:\n\n");
    localStringBuilder.append(this.c.toString());
    localStringBuilder.append("\n\n\n raw data merged:\n\n");
    byte[] arrayOfByte = this.c.getAllData();
    localStringBuilder.append("{");
    while (true)
    {
      if (i >= arrayOfByte.length)
      {
        localStringBuilder.append("}");
        label453: localIntent2.putExtra("android.intent.extra.TEXT", localStringBuilder.toString());
        startActivity(Intent.createChooser(localIntent2, getString(2131165231)));
        break;
      }
      localStringBuilder.append(0xFF & arrayOfByte[i]);
      if (i != -1 + arrayOfByte.length)
        localStringBuilder.append(", ");
      i++;
    }
  }

  @SuppressLint({"NewApi"})
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    b();
    se.verifique.app.cedula.util.c.a();
    getWindow().setFlags(1024, 1024);
    getWindow().requestFeature(1);
    setContentView(2130903051);
    if (!this.h)
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
    for (int i = 0; ; i = 1)
      return i;
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
 * Qualified Name:     se.verifique.app.cedula.Pdf417MobiDemo
 * JD-Core Version:    0.6.0
 */