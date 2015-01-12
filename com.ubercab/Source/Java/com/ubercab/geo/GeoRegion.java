package com.ubercab.geo;

import android.content.Context;
import com.cocoahero.android.geojson.Feature;
import com.cocoahero.android.geojson.FeatureCollection;
import com.cocoahero.android.geojson.GeoJSON;
import com.cocoahero.android.geojson.Geometry;
import com.cocoahero.android.geojson.MultiPolygon;
import com.cocoahero.android.geojson.Polygon;
import com.cocoahero.android.geojson.Position;
import com.cocoahero.android.geojson.Ring;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONException;

public class GeoRegion
{
  private static final String DEFAULT_DIRECTORY = "geo/";
  private static final String FILE_EXTENSION = ".geojson";
  private static final String MULTI_POLYGON = "MultiPolygon";
  private static final String POLYGON = "Polygon";
  private final Context mContext;
  private final Map<String, List<Ring>> mRegions = new ConcurrentHashMap();

  public GeoRegion(Context paramContext)
  {
    this.mContext = paramContext;
  }

  private static boolean contains(Ring paramRing, double paramDouble1, double paramDouble2)
  {
    boolean bool = false;
    List localList = paramRing.getPositions();
    Position[] arrayOfPosition = (Position[])localList.toArray(new Position[localList.size()]);
    int i = 0;
    int j = -1 + arrayOfPosition.length;
    if (i < arrayOfPosition.length)
    {
      int k;
      label65: int m;
      if (arrayOfPosition[i].getLongitude() > paramDouble2)
      {
        k = 1;
        if (arrayOfPosition[j].getLongitude() <= paramDouble2)
          break label179;
        m = 1;
        label81: if ((k != m) && (paramDouble1 < (arrayOfPosition[j].getLatitude() - arrayOfPosition[i].getLatitude()) * (paramDouble2 - arrayOfPosition[i].getLongitude()) / (arrayOfPosition[j].getLongitude() - arrayOfPosition[i].getLongitude()) + arrayOfPosition[i].getLatitude()))
          if (bool)
            break label185;
      }
      label179: label185: for (bool = true; ; bool = false)
      {
        int n = i + 1;
        j = i;
        i = n;
        break;
        k = 0;
        break label65;
        m = 0;
        break label81;
      }
    }
    return bool;
  }

  private static boolean contains(List<Ring> paramList, double paramDouble1, double paramDouble2)
  {
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext())
      if (contains((Ring)localIterator.next(), paramDouble1, paramDouble2))
        return true;
    return false;
  }

  private static String convertStreamToString(InputStream paramInputStream)
  {
    Scanner localScanner = new Scanner(paramInputStream).useDelimiter("\\A");
    if (localScanner.hasNext())
      return localScanner.next();
    return "";
  }

  // ERROR //
  private void loadRegionFromFileIntoMap(Context paramContext, String paramString1, String paramString2)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: aload_1
    //   4: invokevirtual 111	android/content/Context:getAssets	()Landroid/content/res/AssetManager;
    //   7: aload_3
    //   8: invokevirtual 117	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   11: astore 4
    //   13: aload 4
    //   15: invokestatic 119	com/ubercab/geo/GeoRegion:convertStreamToString	(Ljava/io/InputStream;)Ljava/lang/String;
    //   18: astore 10
    //   20: aload_0
    //   21: getfield 32	com/ubercab/geo/GeoRegion:mRegions	Ljava/util/Map;
    //   24: aload_2
    //   25: aload_0
    //   26: aload 10
    //   28: invokespecial 123	com/ubercab/geo/GeoRegion:parseGeoJson	(Ljava/lang/String;)Ljava/util/List;
    //   31: invokeinterface 129 3 0
    //   36: pop
    //   37: aload 4
    //   39: ifnull +8 -> 47
    //   42: aload 4
    //   44: invokevirtual 134	java/io/InputStream:close	()V
    //   47: return
    //   48: astore 9
    //   50: aload 4
    //   52: ifnull -5 -> 47
    //   55: aload 4
    //   57: invokevirtual 134	java/io/InputStream:close	()V
    //   60: return
    //   61: astore 6
    //   63: return
    //   64: astore 7
    //   66: aload 4
    //   68: ifnull +8 -> 76
    //   71: aload 4
    //   73: invokevirtual 134	java/io/InputStream:close	()V
    //   76: aload 7
    //   78: athrow
    //   79: astore 12
    //   81: return
    //   82: astore 8
    //   84: goto -8 -> 76
    //   87: astore 5
    //   89: goto -39 -> 50
    //
    // Exception table:
    //   from	to	target	type
    //   3	37	48	org/json/JSONException
    //   55	60	61	java/io/IOException
    //   3	37	64	finally
    //   42	47	79	java/io/IOException
    //   71	76	82	java/io/IOException
    //   3	37	87	java/io/IOException
  }

  private List<Ring> parseGeoJson(String paramString)
    throws JSONException
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator1 = ((FeatureCollection)GeoJSON.parse(paramString)).getFeatures().iterator();
    while (localIterator1.hasNext())
    {
      Geometry localGeometry = ((Feature)localIterator1.next()).getGeometry();
      if (localGeometry.getType().equals("Polygon"))
      {
        localArrayList.addAll(((Polygon)localGeometry).getRings());
      }
      else if (localGeometry.getType().equals("MultiPolygon"))
      {
        Iterator localIterator2 = ((MultiPolygon)localGeometry).getPolygons().iterator();
        while (localIterator2.hasNext())
          localArrayList.addAll(((Polygon)localIterator2.next()).getRings());
      }
    }
    return localArrayList;
  }

  protected String getRegionDir()
  {
    return "geo/";
  }

  Map<String, List<Ring>> getRegions()
  {
    return this.mRegions;
  }

  public boolean isInRegion(String paramString, double paramDouble1, double paramDouble2)
  {
    List localList = (List)this.mRegions.get(paramString);
    if (localList == null)
    {
      loadRegionFromFileIntoMap(this.mContext, paramString, getRegionDir() + paramString + ".geojson");
      localList = (List)this.mRegions.get(paramString);
      if (localList == null)
        throw new IllegalStateException("region: " + paramString + " not found!");
    }
    return contains(localList, paramDouble1, paramDouble2);
  }

  public void recycle()
  {
    this.mRegions.clear();
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.geo.GeoRegion
 * JD-Core Version:    0.6.2
 */