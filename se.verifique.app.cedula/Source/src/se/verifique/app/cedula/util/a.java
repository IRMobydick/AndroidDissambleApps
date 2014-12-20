package se.verifique.app.cedula.util;

import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class a
{
  private static String a()
  {
    return c.b().c();
  }

  private static List a(String paramString)
  {
    ArrayList localArrayList = new ArrayList();
    try
    {
      JSONArray localJSONArray = new JSONObject(paramString).getJSONArray("cedulas");
      for (int i = 0; i < localJSONArray.length(); i++)
        localArrayList.add(localJSONArray.getJSONObject(i).getString("numero"));
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
      localArrayList = null;
    }
    return localArrayList;
  }

  public static boolean a(Parametros paramParametros)
  {
    String str = a();
    if (str != null);
    for (boolean bool = paramParametros.b(str); ; bool = false)
      return bool;
  }

  public static List b(Parametros paramParametros)
  {
    return a(paramParametros.d());
  }
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     se.verifique.app.cedula.util.a
 * JD-Core Version:    0.6.0
 */