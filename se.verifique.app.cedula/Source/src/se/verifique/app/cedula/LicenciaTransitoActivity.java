package se.verifique.app.cedula;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.widget.ArrayAdapter;
import com.google.b.a.a.p;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import se.verifique.app.cedula.a.f;
import se.verifique.app.cedula.a.h;
import se.verifique.app.cedula.util.Parametros;

public class LicenciaTransitoActivity extends ListActivity
{
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    h localh = (h)getIntent().getExtras().get("se.verifique.app.cedula.PERSONA");
    ArrayList localArrayList;
    Iterator localIterator;
    int i;
    if (localh.k() != null)
    {
      List localList = localh.k();
      localArrayList = new ArrayList();
      localIterator = localList.iterator();
      i = 0;
    }
    while (true)
    {
      if (!localIterator.hasNext())
      {
        setListAdapter(new ArrayAdapter(this, 17367043, localArrayList));
        Parametros.a(this);
        return;
      }
      f localf = (f)localIterator.next();
      StringBuilder localStringBuilder = new StringBuilder("LICENCIA #");
      i++;
      localArrayList.add(i + "\n" + "Número: " + localf.a() + "\n" + "Estado: " + localf.b() + "\n" + "Categoría antigua: " + localf.c() + "\n" + "Categorías: " + localf.d() + "\n" + "Fecha expedición: " + localf.e() + "\n");
    }
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
 * Qualified Name:     se.verifique.app.cedula.LicenciaTransitoActivity
 * JD-Core Version:    0.6.0
 */