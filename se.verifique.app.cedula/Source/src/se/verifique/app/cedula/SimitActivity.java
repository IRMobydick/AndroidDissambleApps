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
import se.verifique.app.cedula.a.e;
import se.verifique.app.cedula.a.h;
import se.verifique.app.cedula.util.Parametros;

public class SimitActivity extends ListActivity
{
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    h localh = (h)getIntent().getExtras().get("se.verifique.app.cedula.PERSONA");
    ArrayList localArrayList;
    Iterator localIterator;
    int i;
    if (localh.h() != null)
    {
      List localList = localh.h();
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
      e locale = (e)localIterator.next();
      StringBuilder localStringBuilder = new StringBuilder("INFRACCIÓN #");
      i++;
      localArrayList.add(i + "\n" + "Lugar: " + locale.c() + "\n" + "Fecha infración: " + locale.a() + "\n" + "Valor infracción: " + locale.b() + "\n");
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
 * Qualified Name:     se.verifique.app.cedula.SimitActivity
 * JD-Core Version:    0.6.0
 */