package se.verifique.app.cedula;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.Window;
import android.widget.TextView;
import se.verifique.app.cedula.util.Parametros;

public class CifinActivity extends Activity
{
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    getWindow().setFlags(1024, 1024);
    getWindow().requestFeature(1);
    setContentView(2130903041);
    ((TextView)findViewById(2131230743)).setText("Score:  752");
    ((TextView)findViewById(2131230744)).setText("Probabilidad NO Pago:  4,37 %");
    ((TextView)findViewById(2131230745)).setText("Probabilidad MORA:  9,78 %");
    ((TextView)findViewById(2131230746)).setText("Cantidad CrÃ©ditos:  4");
    ((TextView)findViewById(2131230747)).setText("Saldo CrÃ©ditos:  98.000");
    ((TextView)findViewById(2131230748)).setText("Cuota CrÃ©ditos:  1.200");
    Parametros.a(this);
  }

  public boolean onCreateOptionsMenu(Menu paramMenu)
  {
    getMenuInflater().inflate(2130903059, paramMenu);
    return true;
  }
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     se.verifique.app.cedula.CifinActivity
 * JD-Core Version:    0.6.0
 */