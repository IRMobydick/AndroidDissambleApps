package se.verifique.app.cedula.c;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import se.verifique.app.cedula.a.g;
import se.verifique.app.cedula.util.Parametros;
import se.verifique.app.cedula.util.c;

public class a
{
  public static List a = new ArrayList();
  public static Map b = new HashMap();
  private static boolean c = false;

  private static String a()
  {
    return c.b().a();
  }

  private static Map a(String paramString)
  {
    HashMap localHashMap = new HashMap();
    try
    {
      JSONArray localJSONArray = new JSONObject(paramString).getJSONArray("opciones");
      for (int i = 0; i < localJSONArray.length(); i++)
      {
        JSONObject localJSONObject = localJSONArray.getJSONObject(i);
        g localg = new g();
        localg.a(localJSONObject.getString("codigo"));
        localg.b(localJSONObject.getString("tipo"));
        localg.c(localJSONObject.getString("descripcion"));
        localg.d(localJSONObject.getString("error"));
        localg.e(localJSONObject.getString("url"));
        localg.f(localJSONObject.getString("urlBinario"));
        localHashMap.put(localg.a(), localg);
        a(new b(localg.a(), localg.c()));
      }
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
    }
    return localHashMap;
  }

  private static void a(b paramb)
  {
    a.add(paramb);
    b.put(paramb.a, paramb);
  }

  public static void a(Parametros paramParametros)
  {
    if (!c)
    {
      String str = a();
      paramParametros.a(str);
      paramParametros.a(a(str));
      c = true;
    }
  }

  public static void b(Parametros paramParametros)
  {
    if (!c)
    {
      paramParametros.a(a(paramParametros.c()));
      c = true;
    }
  }
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     se.verifique.app.cedula.c.a
 * JD-Core Version:    0.6.0
 */