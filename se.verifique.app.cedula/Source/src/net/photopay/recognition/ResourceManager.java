package net.photopay.recognition;

import android.content.Context;
import android.content.res.Resources;
import java.nio.ByteBuffer;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import net.photopay.util.IlIllIlIIl;
import net.photopay.util.Log;

public enum ResourceManager
{
  private Map IllIIIllII = null;

  static
  {
    jdField_llIIlIlIIl_of_type_NetPhotopayRecognitionResourceManager = new ResourceManager("INSTANCE");
    ResourceManager[] arrayOfResourceManager = new ResourceManager[1];
    arrayOfResourceManager[0] = jdField_llIIlIlIIl_of_type_NetPhotopayRecognitionResourceManager;
    jdField_llIIlIlIIl_of_type_ArrayOfNetPhotopayRecognitionResourceManager = arrayOfResourceManager;
  }

  private ResourceManager()
  {
  }

  private void llIIlIlIIl(Context paramContext, String paramString)
  {
    monitorenter;
    try
    {
      int i = paramContext.getResources().getIdentifier(paramString, "raw", paramContext.getPackageName());
      if (i != 0)
      {
        Object[] arrayOfObject = new Object[1];
        arrayOfObject[0] = paramString;
        Log.v(this, "Loading raw resource {}", arrayOfObject);
        ByteBuffer localByteBuffer = IlIllIlIIl.llIIlIlIIl(paramContext.getResources(), i);
        this.IllIIIllII.put(paramString, localByteBuffer);
      }
      monitorexit;
      return;
    }
    finally
    {
      localObject = finally;
      monitorexit;
    }
    throw localObject;
  }

  public final void lIllIIlIIl()
  {
    monitorenter;
    try
    {
      if (this.IllIIIllII == null)
        break label59;
      Iterator localIterator = this.IllIIIllII.values().iterator();
      while (localIterator.hasNext())
        ((ByteBuffer)localIterator.next()).clear();
    }
    finally
    {
      monitorexit;
    }
    this.IllIIIllII = null;
    label59: monitorexit;
  }

  public final Map llIIlIlIIl(Context paramContext)
  {
    monitorenter;
    try
    {
      if (this.IllIIIllII == null)
      {
        this.IllIIIllII = new HashMap();
        llIIlIlIIl(paramContext, "deblzlut");
        llIIlIlIIl(paramContext, "european");
        llIIlIlIIl(paramContext, "license");
        llIIlIlIIl(paramContext, "ocr_model");
        llIIlIlIIl(paramContext, "aus_confusions");
        llIIlIlIIl(paramContext, "aus_dictionary");
        llIIlIlIIl(paramContext, "cro_confusions");
        llIIlIlIIl(paramContext, "cro_dictionary");
        llIIlIlIIl(paramContext, "de_confusions");
        llIIlIlIIl(paramContext, "de_dictionary");
        llIIlIlIIl(paramContext, "slo_dictionary");
        llIIlIlIIl(paramContext, "slo_confusions");
      }
      Map localMap = this.IllIIIllII;
      monitorexit;
      return localMap;
    }
    finally
    {
      localObject = finally;
      monitorexit;
    }
    throw localObject;
  }
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     net.photopay.recognition.ResourceManager
 * JD-Core Version:    0.6.0
 */