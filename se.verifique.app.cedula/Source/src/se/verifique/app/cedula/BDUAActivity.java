package se.verifique.app.cedula;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.widget.ArrayAdapter;
import com.google.b.a.a.p;
import java.util.ArrayList;
import java.util.List;
import se.verifique.app.cedula.a.b;
import se.verifique.app.cedula.a.h;
import se.verifique.app.cedula.util.Parametros;

public class BDUAActivity extends ListActivity
{
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    h localh = (h)getIntent().getExtras().get("se.verifique.app.cedula.PERSONA");
    if ((localh != null) && (localh.i().a() != null) && (localh.i().a() != ""))
    {
      ArrayList localArrayList = new ArrayList();
      b localb = localh.i();
      localArrayList.add("Nombres: " + localb.a());
      localArrayList.add("Apellidos: " + localb.b());
      localArrayList.add("Entidad: " + localb.d());
      localArrayList.add("Regimen: " + localb.e());
      localArrayList.add("Tipo afiliado: " + localb.i());
      localArrayList.add("Estado: " + localb.c());
      localArrayList.add("Fecha afiliación: " + localb.f());
      localArrayList.add("Departamento: " + localb.g());
      localArrayList.add("Ciudad: " + localb.h());
      setListAdapter(new ArrayAdapter(this, 17367043, localArrayList));
    }
    Parametros.a(this);
  }

  public boolean onCreateOptionsMenu(Menu paramMenu)
  {
    getMenuInflater().inflate(2130903059, paramMenu);
    return true;
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
 * Qualified Name:     se.verifique.app.cedula.BDUAActivity
 * JD-Core Version:    0.6.0
 */