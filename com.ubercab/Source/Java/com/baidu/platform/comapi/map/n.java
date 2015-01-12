package com.baidu.platform.comapi.map;

import android.os.Handler;
import com.baidu.mapapi.utils.b;
import com.baidu.platform.comapi.a.d;
import com.baidu.platform.comapi.c.c;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class n
{
  private static final String a = n.class.getSimpleName();
  private static n c;
  private com.baidu.platform.comjni.map.basemap.a b;
  private s d;
  private Handler e;

  public static n a()
  {
    if (c == null)
    {
      c = new n();
      c.g();
    }
    return c;
  }

  private void g()
  {
    h();
    this.d = new s();
    this.e = new o(this);
    com.baidu.platform.comjni.engine.a.a(65289, this.e);
  }

  private void h()
  {
    b.a(com.baidu.mapapi.a.a().d());
    this.b = new com.baidu.platform.comjni.map.basemap.a();
    this.b.a();
    String str1 = c.o();
    String str2 = b.a();
    String str3 = b.b();
    String str4 = b.c();
    int i = b.d();
    int j = b.e();
    int k = b.f();
    if (c.n() >= 180);
    for (String str5 = "/h/"; ; str5 = "/l/")
    {
      String str6 = str1 + "/cfg";
      String str7 = str2 + "/vmp";
      String str8 = str6 + str5;
      String str9 = str6 + "/a/";
      String str10 = str7 + str5;
      String str11 = str7 + str5;
      String str12 = str3 + "/tmp/";
      String str13 = str4 + "/tmp/";
      this.b.a(str8, str10, str12, str13, str11, str9, c.j(), c.l(), c.n(), i, j, k, 0);
      this.b.e();
      return;
    }
  }

  public ArrayList<m> a(String paramString)
  {
    if ((paramString.equals("")) || (this.b == null));
    ArrayList localArrayList1;
    while (true)
    {
      return null;
      String str = this.b.b(paramString);
      if ((str != null) && (!str.equals("")))
      {
        localArrayList1 = new ArrayList();
        try
        {
          JSONObject localJSONObject1 = new JSONObject(str);
          if ((localJSONObject1 != null) && (localJSONObject1.length() != 0))
          {
            JSONArray localJSONArray1 = localJSONObject1.optJSONArray("dataset");
            if (localJSONArray1 != null)
              for (int i = 0; i < localJSONArray1.length(); i++)
              {
                m localm1 = new m();
                JSONObject localJSONObject2 = localJSONArray1.getJSONObject(i);
                localm1.a = localJSONObject2.optInt("id");
                localm1.b = localJSONObject2.optString("name");
                localm1.c = localJSONObject2.optInt("size");
                localm1.d = localJSONObject2.optInt("cty");
                if (localJSONObject2.has("child"))
                {
                  JSONArray localJSONArray2 = localJSONObject2.optJSONArray("child");
                  ArrayList localArrayList2 = new ArrayList();
                  for (int j = 0; j < localJSONArray2.length(); j++)
                  {
                    m localm2 = new m();
                    JSONObject localJSONObject3 = localJSONArray2.optJSONObject(j);
                    localm2.a = localJSONObject3.optInt("id");
                    localm2.b = localJSONObject3.optString("name");
                    localm2.c = localJSONObject3.optInt("size");
                    localm2.d = localJSONObject3.optInt("cty");
                    localArrayList2.add(localm2);
                  }
                  localm1.a(localArrayList2);
                }
                localArrayList1.add(localm1);
              }
          }
        }
        catch (JSONException localJSONException)
        {
          localJSONException.printStackTrace();
          return null;
        }
      }
    }
    return localArrayList1;
  }

  public void a(r paramr)
  {
    if (this.d != null)
      this.d.a(paramr);
  }

  public boolean a(int paramInt)
  {
    if ((this.b == null) || (paramInt < 0))
      return false;
    return this.b.d(paramInt);
  }

  public boolean a(boolean paramBoolean)
  {
    if (this.b == null)
      return false;
    return this.b.c(paramBoolean);
  }

  public void b()
  {
    com.baidu.platform.comjni.engine.a.b(65289, this.e);
    this.b.b();
    c = null;
  }

  public void b(r paramr)
  {
    if (this.d != null)
      this.d.b(paramr);
  }

  public boolean b(int paramInt)
  {
    if ((this.b == null) || (paramInt < 0))
      return false;
    return this.b.a(paramInt, false, 0);
  }

  public ArrayList<m> c()
  {
    if (this.b == null)
      return null;
    String str = this.b.i();
    ArrayList localArrayList1 = new ArrayList();
    try
    {
      JSONArray localJSONArray1 = new JSONObject(str).optJSONArray("dataset");
      for (int i = 0; i < localJSONArray1.length(); i++)
      {
        m localm1 = new m();
        JSONObject localJSONObject1 = localJSONArray1.optJSONObject(i);
        localm1.a = localJSONObject1.optInt("id");
        localm1.b = localJSONObject1.optString("name");
        localm1.c = localJSONObject1.optInt("size");
        localm1.d = localJSONObject1.optInt("cty");
        if (localJSONObject1.has("child"))
        {
          JSONArray localJSONArray2 = localJSONObject1.optJSONArray("child");
          ArrayList localArrayList2 = new ArrayList();
          for (int j = 0; j < localJSONArray2.length(); j++)
          {
            m localm2 = new m();
            JSONObject localJSONObject2 = localJSONArray2.optJSONObject(j);
            localm2.a = localJSONObject2.optInt("id");
            localm2.b = localJSONObject2.optString("name");
            localm2.c = localJSONObject2.optInt("size");
            localm2.d = localJSONObject2.optInt("cty");
            localArrayList2.add(localm2);
          }
          localm1.a(localArrayList2);
        }
        localArrayList1.add(localm1);
      }
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
      return null;
    }
    return localArrayList1;
  }

  public boolean c(int paramInt)
  {
    if ((this.b == null) || (paramInt < 0))
      return false;
    return this.b.b(paramInt, false, 0);
  }

  public ArrayList<m> d()
  {
    if (this.b == null)
      return null;
    String str = this.b.b("");
    ArrayList localArrayList1 = new ArrayList();
    try
    {
      JSONArray localJSONArray1 = new JSONObject(str).optJSONArray("dataset");
      for (int i = 0; i < localJSONArray1.length(); i++)
      {
        m localm1 = new m();
        JSONObject localJSONObject1 = localJSONArray1.optJSONObject(i);
        localm1.a = localJSONObject1.optInt("id");
        localm1.b = localJSONObject1.optString("name");
        localm1.c = localJSONObject1.optInt("size");
        localm1.d = localJSONObject1.optInt("cty");
        if (localJSONObject1.has("child"))
        {
          JSONArray localJSONArray2 = localJSONObject1.optJSONArray("child");
          ArrayList localArrayList2 = new ArrayList();
          for (int j = 0; j < localJSONArray2.length(); j++)
          {
            m localm2 = new m();
            JSONObject localJSONObject2 = localJSONArray2.optJSONObject(j);
            localm2.a = localJSONObject2.optInt("id");
            localm2.b = localJSONObject2.optString("name");
            localm2.c = localJSONObject2.optInt("size");
            localm2.d = localJSONObject2.optInt("cty");
            localArrayList2.add(localm2);
          }
          localm1.a(localArrayList2);
        }
        localArrayList1.add(localm1);
      }
      return localArrayList1;
    }
    catch (Exception localException)
    {
      return null;
    }
    catch (JSONException localJSONException)
    {
    }
    return null;
  }

  public boolean d(int paramInt)
  {
    if (this.b == null)
      return false;
    return this.b.b(0, true, paramInt);
  }

  public ArrayList<q> e()
  {
    int i = 0;
    if (this.b == null);
    String str;
    do
    {
      return null;
      str = this.b.h();
    }
    while ((str == null) || (str.equals("")));
    ArrayList localArrayList = new ArrayList();
    while (true)
    {
      p localp;
      try
      {
        JSONObject localJSONObject1 = new JSONObject(str);
        if (localJSONObject1.length() == 0)
          break;
        JSONArray localJSONArray = localJSONObject1.optJSONArray("dataset");
        if (i >= localJSONArray.length())
          break label319;
        q localq = new q();
        localp = new p();
        JSONObject localJSONObject2 = localJSONArray.optJSONObject(i);
        localp.a = localJSONObject2.optInt("id");
        localp.b = localJSONObject2.optString("name");
        localp.c = localJSONObject2.optString("pinyin");
        localp.h = localJSONObject2.optInt("size");
        localp.i = localJSONObject2.optInt("ratio");
        localp.l = localJSONObject2.optInt("status");
        localp.g = new d();
        localp.g.a(localJSONObject2.optInt("x"));
        localp.g.b(localJSONObject2.optInt("y"));
        if (localJSONObject2.optInt("up") == 1)
        {
          localp.j = true;
          localp.e = localJSONObject2.optInt("lev");
          if (!localp.j)
            break label310;
          localp.k = localJSONObject2.optInt("svr_size");
          localq.a(localp);
          localArrayList.add(localq);
          i++;
          continue;
        }
        localp.j = false;
        continue;
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        return null;
      }
      label310: localp.k = 0;
    }
    label319: return localArrayList;
  }

  public boolean e(int paramInt)
  {
    if ((this.b == null) || (paramInt < 0))
      return false;
    return this.b.b(paramInt, false);
  }

  public q f(int paramInt)
  {
    if ((this.b == null) || (paramInt < 0));
    while (true)
    {
      return null;
      String str = this.b.e(paramInt);
      if ((str != null) && (!str.equals("")))
      {
        q localq = new q();
        p localp = new p();
        try
        {
          JSONObject localJSONObject = new JSONObject(str);
          if (localJSONObject.length() != 0)
          {
            localp.a = localJSONObject.optInt("id");
            localp.b = localJSONObject.optString("name");
            localp.c = localJSONObject.optString("pinyin");
            localp.d = localJSONObject.optString("headchar");
            localp.h = localJSONObject.optInt("size");
            localp.i = localJSONObject.optInt("ratio");
            localp.l = localJSONObject.optInt("status");
            localp.g = new d();
            localp.g.a(localJSONObject.optInt("x"));
            localp.g.b(localJSONObject.optInt("y"));
            if (localJSONObject.optInt("up") == 1);
            for (localp.j = true; ; localp.j = false)
            {
              localp.e = localJSONObject.optInt("lev");
              localp.f = localJSONObject.optInt("ver");
              localq.a(localp);
              return localq;
            }
          }
        }
        catch (JSONException localJSONException)
        {
          localJSONException.printStackTrace();
        }
      }
    }
    return null;
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.baidu.platform.comapi.map.n
 * JD-Core Version:    0.6.2
 */