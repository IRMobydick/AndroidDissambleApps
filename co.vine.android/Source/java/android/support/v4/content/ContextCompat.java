package android.support.v4.content;

import android.content.Context;
import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Environment;
import java.io.File;

public class ContextCompat
{
  private static final String DIR_ANDROID = "Android";
  private static final String DIR_CACHE = "cache";
  private static final String DIR_DATA = "data";
  private static final String DIR_FILES = "files";
  private static final String DIR_OBB = "obb";

  private static File buildPath(File paramFile, String[] paramArrayOfString)
  {
    int i = paramArrayOfString.length;
    int j = 0;
    Object localObject1 = paramFile;
    String str;
    Object localObject2;
    if (j < i)
    {
      str = paramArrayOfString[j];
      if (localObject1 == null)
        localObject2 = new File(str);
    }
    while (true)
    {
      j++;
      localObject1 = localObject2;
      break;
      if (str != null)
      {
        localObject2 = new File((File)localObject1, str);
        continue;
        return localObject1;
      }
      localObject2 = localObject1;
    }
  }

  public static File[] getExternalCacheDirs(Context paramContext)
  {
    int i = Build.VERSION.SDK_INT;
    File[] arrayOfFile;
    if (i >= 19)
    {
      arrayOfFile = ContextCompatKitKat.getExternalCacheDirs(paramContext);
      return arrayOfFile;
    }
    if (i >= 8);
    File localFile1;
    String[] arrayOfString;
    for (File localFile2 = ContextCompatFroyo.getExternalCacheDir(paramContext); ; localFile2 = buildPath(localFile1, arrayOfString))
    {
      arrayOfFile = new File[1];
      arrayOfFile[0] = localFile2;
      break;
      localFile1 = Environment.getExternalStorageDirectory();
      arrayOfString = new String[4];
      arrayOfString[0] = "Android";
      arrayOfString[1] = "data";
      arrayOfString[2] = paramContext.getPackageName();
      arrayOfString[3] = "cache";
    }
  }

  public static File[] getExternalFilesDirs(Context paramContext, String paramString)
  {
    int i = Build.VERSION.SDK_INT;
    File[] arrayOfFile;
    if (i >= 19)
    {
      arrayOfFile = ContextCompatKitKat.getExternalFilesDirs(paramContext, paramString);
      return arrayOfFile;
    }
    if (i >= 8);
    File localFile1;
    String[] arrayOfString;
    for (File localFile2 = ContextCompatFroyo.getExternalFilesDir(paramContext, paramString); ; localFile2 = buildPath(localFile1, arrayOfString))
    {
      arrayOfFile = new File[1];
      arrayOfFile[0] = localFile2;
      break;
      localFile1 = Environment.getExternalStorageDirectory();
      arrayOfString = new String[5];
      arrayOfString[0] = "Android";
      arrayOfString[1] = "data";
      arrayOfString[2] = paramContext.getPackageName();
      arrayOfString[3] = "files";
      arrayOfString[4] = paramString;
    }
  }

  public static File[] getObbDirs(Context paramContext)
  {
    int i = Build.VERSION.SDK_INT;
    File[] arrayOfFile;
    if (i >= 19)
    {
      arrayOfFile = ContextCompatKitKat.getObbDirs(paramContext);
      return arrayOfFile;
    }
    if (i >= 11);
    File localFile1;
    String[] arrayOfString;
    for (File localFile2 = ContextCompatHoneycomb.getObbDir(paramContext); ; localFile2 = buildPath(localFile1, arrayOfString))
    {
      arrayOfFile = new File[1];
      arrayOfFile[0] = localFile2;
      break;
      localFile1 = Environment.getExternalStorageDirectory();
      arrayOfString = new String[3];
      arrayOfString[0] = "Android";
      arrayOfString[1] = "obb";
      arrayOfString[2] = paramContext.getPackageName();
    }
  }

  public static boolean startActivities(Context paramContext, Intent[] paramArrayOfIntent)
  {
    return startActivities(paramContext, paramArrayOfIntent, null);
  }

  public static boolean startActivities(Context paramContext, Intent[] paramArrayOfIntent, Bundle paramBundle)
  {
    int i = 1;
    int j = Build.VERSION.SDK_INT;
    if (j >= 16)
      ContextCompatJellybean.startActivities(paramContext, paramArrayOfIntent, paramBundle);
    while (true)
    {
      return i;
      if (j >= 11)
      {
        ContextCompatHoneycomb.startActivities(paramContext, paramArrayOfIntent);
        continue;
      }
      i = 0;
    }
  }
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     android.support.v4.content.ContextCompat
 * JD-Core Version:    0.6.0
 */