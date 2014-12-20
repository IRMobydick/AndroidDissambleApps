package se.verifique.app.cedula;

import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.webkit.MimeTypeMap;
import java.io.PrintStream;
import java.util.List;
import se.verifique.app.cedula.a.h;
import se.verifique.app.cedula.util.c;

public class v extends AsyncTask
{
  private boolean b = false;

  public v(PrincipalActivity paramPrincipalActivity)
  {
  }

  protected Boolean a(Void[] paramArrayOfVoid)
  {
    boolean bool = true;
    this.b = false;
    if ("3".equals(PrincipalActivity.a(this.a)));
    while (true)
    {
      Boolean localBoolean;
      try
      {
        PrincipalActivity.b(this.a).a(null);
        PrincipalActivity.a(this.a, c.b().a(PrincipalActivity.b(this.a)));
        i2 = 0;
        if ((this.b) || (i2 != 0) || (PrincipalActivity.b(this.a).g() == null))
          continue;
        Intent localIntent7 = new Intent(PrincipalActivity.c(this.a), PuestoVotacionActivity.class);
        localIntent7.putExtra("se.verifique.app.cedula.PERSONA", PrincipalActivity.b(this.a));
        this.a.startActivity(localIntent7);
        localBoolean = Boolean.valueOf(bool);
        return localBoolean;
      }
      catch (se.verifique.app.cedula.b.a locala9)
      {
        String str10 = locala9.a();
        PrincipalActivity.c(this.a).runOnUiThread(new w(this, str10));
        int i2 = bool;
        continue;
        localBoolean = Boolean.valueOf(false);
        continue;
      }
      if ("4".equals(PrincipalActivity.a(this.a)))
      {
        try
        {
          PrincipalActivity.b(this.a).m();
          PrincipalActivity.a(this.a, c.b().b(PrincipalActivity.b(this.a)));
          i1 = 0;
          if ((this.b) || (i1 != 0))
            break label858;
          if ((PrincipalActivity.b(this.a).h() != null) && (PrincipalActivity.b(this.a).h().size() > 0))
          {
            Intent localIntent6 = new Intent(PrincipalActivity.c(this.a), SimitActivity.class);
            localIntent6.putExtra("se.verifique.app.cedula.PERSONA", PrincipalActivity.b(this.a));
            this.a.startActivity(localIntent6);
            localBoolean = Boolean.valueOf(bool);
          }
        }
        catch (se.verifique.app.cedula.b.a locala8)
        {
          while (true)
          {
            String str9 = locala8.a();
            PrincipalActivity.c(this.a).runOnUiThread(new af(this, str9));
            int i1 = bool;
          }
          PrincipalActivity.c(this.a).runOnUiThread(new ag(this));
          localBoolean = Boolean.valueOf(false);
        }
        continue;
      }
      if ("5".equals(PrincipalActivity.a(this.a)))
      {
        try
        {
          PrincipalActivity.b(this.a).a(null);
          PrincipalActivity.a(this.a, c.b().c(PrincipalActivity.b(this.a)));
          n = 0;
          if ((this.b) || (n != 0))
            break label858;
          if ((PrincipalActivity.b(this.a).i().a() != null) && (PrincipalActivity.b(this.a).i().a() != ""))
          {
            Intent localIntent5 = new Intent(PrincipalActivity.c(this.a), BDUAActivity.class);
            localIntent5.putExtra("se.verifique.app.cedula.PERSONA", PrincipalActivity.b(this.a));
            this.a.startActivity(localIntent5);
            localBoolean = Boolean.valueOf(bool);
          }
        }
        catch (se.verifique.app.cedula.b.a locala7)
        {
          while (true)
          {
            String str8 = locala7.a();
            PrincipalActivity.c(this.a).runOnUiThread(new ah(this, str8));
            int n = bool;
          }
          PrincipalActivity.c(this.a).runOnUiThread(new ai(this));
          localBoolean = Boolean.valueOf(false);
        }
        continue;
      }
      if ("6".equals(PrincipalActivity.a(this.a)))
      {
        try
        {
          PrincipalActivity.b(this.a).d(null);
          PrincipalActivity.a(this.a, c.b().d(PrincipalActivity.b(this.a)));
          m = 0;
          if ((this.b) || (m != 0))
            break label858;
          if ((PrincipalActivity.b(this.a).j() != null) && (PrincipalActivity.b(this.a).j() != ""))
          {
            Intent localIntent4 = new Intent(PrincipalActivity.c(this.a), CopniaActivity.class);
            localIntent4.putExtra("se.verifique.app.cedula.PERSONA", PrincipalActivity.b(this.a));
            this.a.startActivity(localIntent4);
            localBoolean = Boolean.valueOf(bool);
          }
        }
        catch (se.verifique.app.cedula.b.a locala6)
        {
          while (true)
          {
            String str7 = locala6.a();
            PrincipalActivity.c(this.a).runOnUiThread(new aj(this, str7));
            int m = bool;
          }
          PrincipalActivity.c(this.a).runOnUiThread(new ak(this));
          localBoolean = Boolean.valueOf(false);
        }
        continue;
      }
      if ("7".equals(PrincipalActivity.a(this.a)));
      while (true)
      {
        while (true)
        {
          while (true)
          {
            while (true)
            {
              try
              {
                PrincipalActivity.a(this.a, c.b().e(PrincipalActivity.b(this.a)));
                bool = false;
                if ((this.b) || (bool))
                  continue;
                PrincipalActivity.c(this.a).finish();
                label858: localBoolean = Boolean.valueOf(false);
              }
              catch (se.verifique.app.cedula.b.a locala5)
              {
                String str6 = locala5.a();
                PrincipalActivity.c(this.a).runOnUiThread(new al(this, str6));
                continue;
                PrincipalActivity.c(this.a).runOnUiThread(new am(this));
                localBoolean = Boolean.valueOf(false);
              }
              break;
              if (!"8".equals(PrincipalActivity.a(this.a)))
                break label1132;
              try
              {
                PrincipalActivity.b(this.a).n();
                PrincipalActivity.a(this.a, c.b().f(PrincipalActivity.b(this.a)));
                k = 0;
                if ((this.b) || (k != 0))
                  continue;
                if ((PrincipalActivity.b(this.a).k() != null) && (PrincipalActivity.b(this.a).k().size() > 0))
                {
                  Intent localIntent3 = new Intent(PrincipalActivity.c(this.a), LicenciaTransitoActivity.class);
                  localIntent3.putExtra("se.verifique.app.cedula.PERSONA", PrincipalActivity.b(this.a));
                  this.a.startActivity(localIntent3);
                  localBoolean = Boolean.valueOf(bool);
                }
              }
              catch (se.verifique.app.cedula.b.a locala4)
              {
                while (true)
                {
                  String str5 = locala4.a();
                  PrincipalActivity.c(this.a).runOnUiThread(new x(this, str5));
                  int k = bool;
                }
                PrincipalActivity.c(this.a).runOnUiThread(new y(this));
                localBoolean = Boolean.valueOf(false);
              }
            }
            break;
            label1132: if (!"10".equals(PrincipalActivity.a(this.a)))
              break label1345;
            try
            {
              PrincipalActivity.b(this.a).a(null);
              PrincipalActivity.a(this.a, c.b().g(PrincipalActivity.b(this.a)));
              j = 0;
              if ((this.b) || (j != 0))
                continue;
              if (PrincipalActivity.b(this.a).l() != null)
              {
                Intent localIntent2 = new Intent();
                localIntent2.setAction("android.intent.action.VIEW");
                localIntent2.setDataAndType(Uri.fromFile(PrincipalActivity.c(this.a).getFileStreamPath(PrincipalActivity.b(this.a).l().a())), MimeTypeMap.getSingleton().getMimeTypeFromExtension(".PDF"));
                this.a.startActivity(localIntent2);
                localBoolean = Boolean.valueOf(bool);
              }
            }
            catch (se.verifique.app.cedula.b.a locala3)
            {
              while (true)
              {
                String str4 = locala3.a();
                PrincipalActivity.c(this.a).runOnUiThread(new z(this, str4));
                int j = bool;
              }
              PrincipalActivity.c(this.a).runOnUiThread(new aa(this));
              localBoolean = Boolean.valueOf(false);
            }
          }
          break;
          label1345: if (!"12".equals(PrincipalActivity.a(this.a)))
            break label1535;
          try
          {
            PrincipalActivity.b(this.a).o();
            PrincipalActivity.a(this.a, c.b().h(PrincipalActivity.b(this.a)));
            i = 0;
            if ((this.b) || (i != 0))
              continue;
            if (PrincipalActivity.b(this.a).b() != null)
            {
              Intent localIntent1 = new Intent(PrincipalActivity.c(this.a), RUAFActivity.class);
              localIntent1.putExtra("se.verifique.app.cedula.PERSONA", PrincipalActivity.b(this.a));
              this.a.startActivity(localIntent1);
              localBoolean = Boolean.valueOf(bool);
            }
          }
          catch (se.verifique.app.cedula.b.a locala2)
          {
            while (true)
            {
              String str3 = locala2.a();
              PrincipalActivity.c(this.a).runOnUiThread(new ab(this, str3));
              int i = bool;
            }
            PrincipalActivity.c(this.a).runOnUiThread(new ac(this));
            localBoolean = Boolean.valueOf(false);
          }
        }
        break;
        label1535: if (!"13".equals(PrincipalActivity.a(this.a)))
          continue;
        try
        {
          String str2 = c.b().d(PrincipalActivity.b(this.a).f());
          PrincipalActivity.a(this.a, str2);
          bool = false;
          if ((!this.b) && (!bool))
            PrincipalActivity.c(this.a).finish();
        }
        catch (se.verifique.app.cedula.b.a locala1)
        {
          while (true)
          {
            String str1 = locala1.a();
            PrincipalActivity.c(this.a).runOnUiThread(new ad(this, str1));
          }
          PrincipalActivity.c(this.a).runOnUiThread(new ae(this));
          localBoolean = Boolean.valueOf(false);
        }
      }
    }
  }

  void a()
  {
    this.b = true;
  }

  protected void a(Boolean paramBoolean)
  {
    PrincipalActivity.a(null);
    PrincipalActivity.a(this.a, false);
    System.out.println("TEST PostExecute TASK");
    paramBoolean.booleanValue();
  }

  protected void onCancelled()
  {
    PrincipalActivity.a(null);
    PrincipalActivity.a(this.a, false);
    System.out.println("TEST Cancelled TASK");
  }
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     se.verifique.app.cedula.v
 * JD-Core Version:    0.6.0
 */