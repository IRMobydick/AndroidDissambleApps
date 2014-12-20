package android.support.v4.text;

import android.util.Log;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

class ICUCompatIcs
{
  private static final String TAG = "ICUCompatIcs";
  private static Method sAddLikelySubtagsMethod;
  private static Method sGetScriptMethod;

  static
  {
    try
    {
      Class localClass = Class.forName("libcore.icu.ICU");
      if (localClass != null)
      {
        Class[] arrayOfClass1 = new Class[1];
        arrayOfClass1[0] = String.class;
        sGetScriptMethod = localClass.getMethod("getScript", arrayOfClass1);
        Class[] arrayOfClass2 = new Class[1];
        arrayOfClass2[0] = String.class;
        sAddLikelySubtagsMethod = localClass.getMethod("addLikelySubtags", arrayOfClass2);
      }
      return;
    }
    catch (Exception localException)
    {
      while (true)
        Log.w("ICUCompatIcs", localException);
    }
  }

  public static String addLikelySubtags(String paramString)
  {
    try
    {
      if (sAddLikelySubtagsMethod != null)
      {
        Object[] arrayOfObject = new Object[1];
        arrayOfObject[0] = paramString;
        str = (String)sAddLikelySubtagsMethod.invoke(null, arrayOfObject);
        return str;
      }
    }
    catch (IllegalAccessException localIllegalAccessException)
    {
      while (true)
      {
        Log.w("ICUCompatIcs", localIllegalAccessException);
        String str = paramString;
      }
    }
    catch (InvocationTargetException localInvocationTargetException)
    {
      while (true)
        Log.w("ICUCompatIcs", localInvocationTargetException);
    }
  }

  public static String getScript(String paramString)
  {
    try
    {
      if (sGetScriptMethod != null)
      {
        Object[] arrayOfObject = new Object[1];
        arrayOfObject[0] = paramString;
        str = (String)sGetScriptMethod.invoke(null, arrayOfObject);
        return str;
      }
    }
    catch (IllegalAccessException localIllegalAccessException)
    {
      while (true)
      {
        Log.w("ICUCompatIcs", localIllegalAccessException);
        String str = null;
      }
    }
    catch (InvocationTargetException localInvocationTargetException)
    {
      while (true)
        Log.w("ICUCompatIcs", localInvocationTargetException);
    }
  }
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     android.support.v4.text.ICUCompatIcs
 * JD-Core Version:    0.6.0
 */