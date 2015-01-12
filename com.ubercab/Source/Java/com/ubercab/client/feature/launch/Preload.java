package com.ubercab.client.feature.launch;

import android.content.Context;
import android.os.Environment;
import com.ubercab.client.core.analytics.AnalyticsManager;
import com.ubercab.common.collect.ImmutableList;
import java.io.File;
import java.util.List;
import java.util.UUID;

public final class Preload
{
  public static final List<File> CONFIG_PATHS = ImmutableList.of(new File("/vendor/lib", "ub__preload.jar"), new File("/system/framework", "ub__preload.jar"), new File(getDownloadDirectory(), "ub__preload.jar"));
  public static final String FILENAME = "ub__preload.jar";
  private final AnalyticsManager mAnalyticsManager;
  private final Context mContext;
  private final PreloadPreferences mPreloadPreferences;

  public Preload(Context paramContext, AnalyticsManager paramAnalyticsManager)
  {
    this.mContext = paramContext;
    this.mAnalyticsManager = paramAnalyticsManager;
    this.mPreloadPreferences = new PreloadPreferences(this.mContext);
  }

  private static File getDownloadDirectory()
  {
    return Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS);
  }

  void dropBreadcrumbs()
  {
    this.mPreloadPreferences.setPreloadUuid(UUID.randomUUID().toString());
  }

  boolean isFirstLaunch()
  {
    return !this.mPreloadPreferences.hasBeenOpened();
  }

  // ERROR //
  void sendAppOpenEvent()
  {
    // Byte code:
    //   0: getstatic 44	com/ubercab/client/feature/launch/Preload:CONFIG_PATHS	Ljava/util/List;
    //   3: invokeinterface 96 1 0
    //   8: astore_1
    //   9: aload_1
    //   10: invokeinterface 101 1 0
    //   15: ifeq +117 -> 132
    //   18: aload_1
    //   19: invokeinterface 105 1 0
    //   24: checkcast 21	java/io/File
    //   27: astore_2
    //   28: aload_2
    //   29: invokevirtual 108	java/io/File:exists	()Z
    //   32: ifeq -23 -> 9
    //   35: aload_0
    //   36: getfield 49	com/ubercab/client/feature/launch/Preload:mContext	Landroid/content/Context;
    //   39: ldc 110
    //   41: iconst_0
    //   42: invokevirtual 116	android/content/Context:getDir	(Ljava/lang/String;I)Ljava/io/File;
    //   45: astore_3
    //   46: aload_0
    //   47: invokevirtual 120	java/lang/Object:getClass	()Ljava/lang/Class;
    //   50: invokevirtual 126	java/lang/Class:getClassLoader	()Ljava/lang/ClassLoader;
    //   53: astore 4
    //   55: new 128	dalvik/system/DexClassLoader
    //   58: dup
    //   59: aload_2
    //   60: invokevirtual 131	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   63: aload_3
    //   64: invokevirtual 131	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   67: aconst_null
    //   68: aload 4
    //   70: invokespecial 134	dalvik/system/DexClassLoader:<init>	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/ClassLoader;)V
    //   73: ldc 136
    //   75: invokevirtual 140	dalvik/system/DexClassLoader:getResourceAsStream	(Ljava/lang/String;)Ljava/io/InputStream;
    //   78: astore 5
    //   80: new 142	java/io/StringWriter
    //   83: dup
    //   84: invokespecial 143	java/io/StringWriter:<init>	()V
    //   87: astore 6
    //   89: aload 5
    //   91: aload 6
    //   93: invokestatic 149	com/ubercab/common/io/IOUtils:copy	(Ljava/io/InputStream;Ljava/io/Writer;)V
    //   96: aload 6
    //   98: invokevirtual 150	java/io/StringWriter:toString	()Ljava/lang/String;
    //   101: astore 9
    //   103: aload_0
    //   104: getfield 51	com/ubercab/client/feature/launch/Preload:mAnalyticsManager	Lcom/ubercab/client/core/analytics/AnalyticsManager;
    //   107: invokevirtual 156	com/ubercab/client/core/analytics/AnalyticsManager:appEvent	()Lcom/ubercab/client/core/analytics/event/AppEvent;
    //   110: aload 9
    //   112: aload_0
    //   113: getfield 58	com/ubercab/client/feature/launch/Preload:mPreloadPreferences	Lcom/ubercab/client/feature/launch/PreloadPreferences;
    //   116: invokevirtual 159	com/ubercab/client/feature/launch/PreloadPreferences:getPreloadUuid	()Ljava/lang/String;
    //   119: invokevirtual 164	com/ubercab/client/core/analytics/event/AppEvent:open	(Ljava/lang/String;Ljava/lang/String;)V
    //   122: aload 5
    //   124: invokestatic 168	com/ubercab/common/io/IOUtils:closeQuietly	(Ljava/io/InputStream;)V
    //   127: aload 6
    //   129: invokestatic 171	com/ubercab/common/io/IOUtils:closeQuietly	(Ljava/io/Writer;)V
    //   132: return
    //   133: astore 8
    //   135: aload 5
    //   137: invokestatic 168	com/ubercab/common/io/IOUtils:closeQuietly	(Ljava/io/InputStream;)V
    //   140: aload 6
    //   142: invokestatic 171	com/ubercab/common/io/IOUtils:closeQuietly	(Ljava/io/Writer;)V
    //   145: return
    //   146: astore 7
    //   148: aload 5
    //   150: invokestatic 168	com/ubercab/common/io/IOUtils:closeQuietly	(Ljava/io/InputStream;)V
    //   153: aload 6
    //   155: invokestatic 171	com/ubercab/common/io/IOUtils:closeQuietly	(Ljava/io/Writer;)V
    //   158: aload 7
    //   160: athrow
    //
    // Exception table:
    //   from	to	target	type
    //   89	122	133	java/io/IOException
    //   89	122	146	finally
  }

  void setHasRunOnce()
  {
    this.mPreloadPreferences.setHasBeenOpened(true);
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.client.feature.launch.Preload
 * JD-Core Version:    0.6.2
 */