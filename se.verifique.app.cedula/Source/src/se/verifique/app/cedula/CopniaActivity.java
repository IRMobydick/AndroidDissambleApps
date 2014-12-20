package se.verifique.app.cedula;

import android.app.ListActivity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.widget.ArrayAdapter;
import com.google.b.a.a.p;
import java.util.ArrayList;
import java.util.List;
import se.verifique.app.cedula.a.h;
import se.verifique.app.cedula.util.Parametros;

public class CopniaActivity extends ListActivity
{
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    h localh = (h)getIntent().getExtras().get("se.verifique.app.cedula.PERSONA");
    if ((localh != null) && (localh.j() != null) && (localh.j() != ""))
    {
      ArrayList localArrayList = new ArrayList();
      String str = localh.j();
      localArrayList.add("DATOS COPNIA");
      localArrayList.add("El Sr(a) " + localh.d() + " " + localh.e());
      localArrayList.add(Parametros.b().getString(2131165312) + localh.f());
      localArrayList.add(Parametros.b().getString(2131165315));
      localArrayList.add(str);
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
 * Qualified Name:     se.verifique.app.cedula.CopniaActivity
 * JD-Core Version:    0.6.0
 */