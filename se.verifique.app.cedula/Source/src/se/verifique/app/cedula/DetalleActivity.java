package se.verifique.app.cedula;

import android.app.ListActivity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import com.google.b.a.a.p;
import java.util.ArrayList;
import java.util.List;
import se.verifique.app.cedula.a.c;
import se.verifique.app.cedula.a.h;
import se.verifique.app.cedula.util.Parametros;

public class DetalleActivity extends ListActivity
{
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setTitle("Detalles de la Persona");
    h localh = (h)getIntent().getExtras().get("se.verifique.app.cedula.PERSONA");
    ArrayList localArrayList = new ArrayList();
    if (localh.c() != null)
    {
      c localc = localh.c();
      localArrayList.add("DATOS PERSONALES");
      localArrayList.add(Parametros.b().getString(2131165316) + localc.a());
      localArrayList.add("Primer Nombre: " + localc.c());
      localArrayList.add("Segundo Nombre: " + localc.d());
      localArrayList.add("Primer Apellido: " + localc.e());
      localArrayList.add("Segundo Apellido: " + localc.f());
      localArrayList.add("Fecha Nacimiento: " + localc.g());
      localArrayList.add("Tipo Sangre (de la cédula): " + localc.h());
    }
    while (true)
    {
      setListAdapter(new ArrayAdapter(this, 17367043, localArrayList));
      Parametros.a(this);
      return;
      localArrayList.add("DATOS PERSONALES");
      localArrayList.add(Parametros.b().getString(2131165316) + localh.f());
      localArrayList.add("Nombres: " + localh.d());
      localArrayList.add("Apellidos: " + localh.e());
    }
  }

  public boolean onCreateOptionsMenu(Menu paramMenu)
  {
    getMenuInflater().inflate(2131492864, paramMenu);
    return true;
  }

  public void onListItemClick(ListView paramListView, View paramView, int paramInt, long paramLong)
  {
  }

  public boolean onOptionsItemSelected(MenuItem paramMenuItem)
  {
    if (paramMenuItem.getItemId() == 2131230777);
    for (boolean bool = true; ; bool = super.onOptionsItemSelected(paramMenuItem))
      return bool;
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
 * Qualified Name:     se.verifique.app.cedula.DetalleActivity
 * JD-Core Version:    0.6.0
 */