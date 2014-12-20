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
import se.verifique.app.cedula.a.aa;
import se.verifique.app.cedula.a.ab;
import se.verifique.app.cedula.a.ac;
import se.verifique.app.cedula.a.ad;
import se.verifique.app.cedula.a.ae;
import se.verifique.app.cedula.a.af;
import se.verifique.app.cedula.a.ag;
import se.verifique.app.cedula.a.ah;
import se.verifique.app.cedula.a.h;
import se.verifique.app.cedula.a.k;
import se.verifique.app.cedula.a.l;
import se.verifique.app.cedula.a.m;
import se.verifique.app.cedula.a.q;
import se.verifique.app.cedula.a.r;
import se.verifique.app.cedula.a.s;
import se.verifique.app.cedula.a.w;
import se.verifique.app.cedula.a.x;
import se.verifique.app.cedula.a.y;
import se.verifique.app.cedula.a.z;
import se.verifique.app.cedula.util.Parametros;

public class RUAFActivity extends ListActivity
{
  protected void onCreate(Bundle paramBundle)
  {
    int i = 1;
    super.onCreate(paramBundle);
    h localh = (h)getIntent().getExtras().get("se.verifique.app.cedula.PERSONA");
    ArrayList localArrayList;
    k localk;
    int j;
    int k;
    int n;
    int i1;
    label371: int i3;
    int i4;
    label433: int i6;
    if ((localh != null) && (localh.b() != null) && (localh.b().a() != null) && (localh.b().a().a() != null) && (localh.b().a().a().size() > 0))
    {
      localArrayList = new ArrayList();
      localk = localh.b();
      localArrayList.add("     DATOS PERSONALES");
      localArrayList.add("Nombres: " + ((ab)((m)localk.a().a().get(0)).a().a().a().get(0)).b());
      localArrayList.add("Género: " + ((ab)((m)localk.a().a().get(0)).a().a().a().get(0)).c());
      localArrayList.add("Identificación: " + ((ab)((m)localk.a().a().get(0)).a().a().a().get(0)).a());
      localArrayList.add("");
      localArrayList.add("     SALUD");
      j = 0;
      k = i;
      if (j < ((m)localk.a().a().get(0)).b().a().a().size())
        break label559;
      localArrayList.add("");
      localArrayList.add("     PENSIONES");
      n = 0;
      i1 = i;
      if (n < ((m)localk.a().a().get(0)).c().a().a().size())
        break label986;
      localArrayList.add("");
      localArrayList.add("     RIESGOS PROFESIONALES");
      i3 = 0;
      i4 = i;
      if (i3 < ((m)localk.a().a().get(0)).d().a().a().size())
        break label1351;
      localArrayList.add("");
      localArrayList.add("     COMPENSACION FAMILIAR");
      i6 = 0;
    }
    while (true)
    {
      if (i6 >= ((m)localk.a().a().get(0)).e().a().a().size())
      {
        localArrayList.add("");
        setListAdapter(new ArrayAdapter(this, 17367043, localArrayList));
        Parametros.a(this);
        return;
        label559: StringBuilder localStringBuilder1 = new StringBuilder("  Salud # ");
        int m = k + 1;
        localArrayList.add(k);
        localArrayList.add("Régimen: " + ((ah)((m)localk.a().a().get(0)).b().a().a().get(j)).a());
        localArrayList.add("Administradora: " + ((ah)((m)localk.a().a().get(0)).b().a().a().get(j)).b());
        localArrayList.add("Fecha Afiliación: " + ((ah)((m)localk.a().a().get(0)).b().a().a().get(j)).c());
        localArrayList.add("Estado Afiliación: " + ((ah)((m)localk.a().a().get(0)).b().a().a().get(j)).d());
        localArrayList.add("Tipo Afiliado: " + ((ah)((m)localk.a().a().get(0)).b().a().a().get(j)).e());
        localArrayList.add("Ubicación Afiliación: " + ((ah)((m)localk.a().a().get(0)).b().a().a().get(j)).f());
        localArrayList.add("");
        j++;
        k = m;
        break;
        label986: StringBuilder localStringBuilder2 = new StringBuilder("  Pensiones # ");
        int i2 = i1 + 1;
        localArrayList.add(i1);
        localArrayList.add("Régimen: " + ((y)((m)localk.a().a().get(0)).c().a().a().get(n)).a());
        localArrayList.add("Administradora: " + ((y)((m)localk.a().a().get(0)).c().a().a().get(n)).b());
        localArrayList.add("Fecha Afiliación: " + ((y)((m)localk.a().a().get(0)).c().a().a().get(n)).d());
        localArrayList.add("Estado Afiliación: " + ((y)((m)localk.a().a().get(0)).c().a().a().get(n)).c());
        localArrayList.add("Afiliación subsidiada: " + ((y)((m)localk.a().a().get(0)).c().a().a().get(n)).e());
        localArrayList.add("");
        n++;
        i1 = i2;
        break label371;
        label1351: StringBuilder localStringBuilder3 = new StringBuilder("  Riesgos Prof. # ");
        int i5 = i4 + 1;
        localArrayList.add(i4);
        localArrayList.add("Régimen: " + ((ae)((m)localk.a().a().get(0)).d().a().a().get(i3)).f());
        localArrayList.add("Administradora: " + ((ae)((m)localk.a().a().get(0)).d().a().a().get(i3)).a());
        localArrayList.add("Fecha Afiliación: " + ((ae)((m)localk.a().a().get(0)).d().a().a().get(i3)).b());
        localArrayList.add("Estado Afiliación: " + ((ae)((m)localk.a().a().get(0)).d().a().a().get(i3)).e());
        localArrayList.add("Actividad Económica: " + ((ae)((m)localk.a().a().get(0)).d().a().a().get(i3)).c());
        localArrayList.add("Ubicación Laboral: " + ((ae)((m)localk.a().a().get(0)).d().a().a().get(i3)).d());
        localArrayList.add("");
        i3++;
        i4 = i5;
        break label433;
      }
      StringBuilder localStringBuilder4 = new StringBuilder("Compensacion Familiar # ");
      int i7 = i + 1;
      localArrayList.add(i);
      localArrayList.add("Caja Compensacion: " + ((s)((m)localk.a().a().get(0)).e().a().a().get(i6)).e());
      localArrayList.add("Fecha Afiliación: " + ((s)((m)localk.a().a().get(0)).e().a().a().get(i6)).c());
      localArrayList.add("Estado Afiliación: " + ((s)((m)localk.a().a().get(0)).e().a().a().get(i6)).d());
      localArrayList.add("Tipo Miembro: " + ((s)((m)localk.a().a().get(0)).e().a().a().get(i6)).f());
      localArrayList.add("Tipo Afiliado: " + ((s)((m)localk.a().a().get(0)).e().a().a().get(i6)).a());
      localArrayList.add("Ubicación Laboral: " + ((s)((m)localk.a().a().get(0)).e().a().a().get(i6)).b());
      localArrayList.add("");
      i6++;
      i = i7;
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
 * Qualified Name:     se.verifique.app.cedula.RUAFActivity
 * JD-Core Version:    0.6.0
 */