package net.photopay.hardware;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Build.VERSION;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import net.photopay.util.FakeR;

public class DeviceManager
{
  private static int IIlIIIllIl;
  private static final Set IlIllIlIIl;
  private static final Set IllIIIIllI;
  private static final Set IllIIIllII;
  private static final Set lIlIIIIlIl;
  private static final Set llIIIlllll;
  private static int llIIlIIlll;
  private static final Set jdField_llIIlIlIIl_of_type_JavaUtilSet;
  private FakeR jdField_llIIlIlIIl_of_type_NetPhotopayUtilFakeR;
  private Context mContext;

  static
  {
    if (!DeviceManager.class.desiredAssertionStatus());
    for (boolean bool = true; ; bool = false)
    {
      lIlllIlIlI = bool;
      HashSet localHashSet1 = new HashSet();
      localHashSet1.add(new llIIlIlIIl("", "LG-P350"));
      localHashSet1.add(new llIIlIlIIl("", "HTC Wildfire"));
      jdField_llIIlIlIIl_of_type_JavaUtilSet = Collections.unmodifiableSet(localHashSet1);
      HashSet localHashSet2 = new HashSet();
      localHashSet2.add(new llIIlIlIIl("LT26i", "LT26i"));
      localHashSet2.add(new llIIlIlIIl("manta", "Nexus 10"));
      localHashSet2.add(new llIIlIlIIl("mako", "Nexus 4"));
      localHashSet2.add(new llIIlIlIIl("mako", "SHW-M250"));
      localHashSet2.add(new llIIlIlIIl("geehdc", "L-01E"));
      localHashSet2.add(new llIIlIlIIl("", "LG-E970"));
      localHashSet2.add(new llIIlIlIIl("", "SGH-T889"));
      localHashSet2.add(new llIIlIlIIl("", "SGH-T889V"));
      localHashSet2.add(new llIIlIlIIl("", "GT-N7100"));
      localHashSet2.add(new llIIlIlIIl("", "SGH-T889"));
      localHashSet2.add(new llIIlIlIIl("", "SGH-T889V"));
      localHashSet2.add(new llIIlIlIIl("", "GT-N8000"));
      localHashSet2.add(new llIIlIlIIl("m0", "GT-I9300"));
      localHashSet2.add(new llIIlIlIIl("m0", "GT-I9300T"));
      localHashSet2.add(new llIIlIlIIl("", "GT-N7100"));
      localHashSet2.add(new llIIlIlIIl("", "GT-P7100"));
      localHashSet2.add(new llIIlIlIIl("", "GT-N8000"));
      localHashSet2.add(new llIIlIlIIl("", "HTC One X"));
      localHashSet2.add(new llIIlIlIIl("", "HTC One XL"));
      localHashSet2.add(new llIIlIlIIl("", "One X"));
      localHashSet2.add(new llIIlIlIIl("", "HTC One S"));
      localHashSet2.add(new llIIlIlIIl("", "HTC One S Special Edition"));
      localHashSet2.add(new llIIlIlIIl("", "ADR6410LVW"));
      localHashSet2.add(new llIIlIlIIl("", "LG-F160K"));
      localHashSet2.add(new llIIlIlIIl("", "LG-F160L"));
      localHashSet2.add(new llIIlIlIIl("", "LG-F160LV"));
      localHashSet2.add(new llIIlIlIIl("", "LG-F160S"));
      localHashSet2.add(new llIIlIlIIl("", "SPH-L300"));
      localHashSet2.add(new llIIlIlIIl("", "DROID RAZR HD"));
      localHashSet2.add(new llIIlIlIIl("", "Galaxy Nexus"));
      localHashSet2.add(new llIIlIlIIl("", "GT-i9100"));
      localHashSet2.add(new llIIlIlIIl("", "GT-I9100"));
      localHashSet2.add(new llIIlIlIIl("", "GT-I9100M"));
      localHashSet2.add(new llIIlIlIIl("", "GT-I9100P"));
      localHashSet2.add(new llIIlIlIIl("", "GT-I9100T"));
      localHashSet2.add(new llIIlIlIIl("", "SC-02C"));
      localHashSet2.add(new llIIlIlIIl("", "SHW-M250K"));
      localHashSet2.add(new llIIlIlIIl("", "SPH-D710BST"));
      localHashSet2.add(new llIIlIlIIl("", "Nexus 7"));
      localHashSet2.add(new llIIlIlIIl("", "GT-I81150"));
      localHashSet2.add(new llIIlIlIIl("GT-P7500", "GT-P7500"));
      IlIllIlIIl = Collections.unmodifiableSet(localHashSet2);
      HashSet localHashSet3 = new HashSet();
      localHashSet3.add(new llIIlIlIIl("", ""));
      IllIIIllII = Collections.unmodifiableSet(localHashSet3);
      HashSet localHashSet4 = new HashSet();
      localHashSet4.add(new llIIlIlIIl("umts_jordan", "MB526"));
      localHashSet4.add(new llIIlIlIIl("victor", "LG-E730"));
      localHashSet4.add(new llIIlIlIIl("passion", "Nexus One"));
      llIIIlllll = Collections.unmodifiableSet(localHashSet4);
      HashSet localHashSet5 = new HashSet();
      localHashSet5.add(new llIIlIlIIl("", ""));
      IllIIIIllI = Collections.unmodifiableSet(localHashSet5);
      HashSet localHashSet6 = new HashSet();
      localHashSet6.add(new llIIlIlIIl("GT-S5570I", "GT-S5570I"));
      localHashSet6.add(new llIIlIlIIl("GT-S5830i", "GT-S5830i"));
      lIlIIIIlIl = Collections.unmodifiableSet(localHashSet6);
      llIIlIIlll = IlIllIlIIl();
      IIlIIIllIl = IllIIIllII();
      return;
    }
  }

  public DeviceManager(Context paramContext)
  {
    this.mContext = paramContext;
    this.jdField_llIIlIlIIl_of_type_NetPhotopayUtilFakeR = new FakeR(this.mContext);
  }

  private static int IlIllIlIIl()
  {
    try
    {
      i = new File("/sys/devices/system/cpu/").listFiles(new DeviceManager.1()).length;
      return i;
    }
    catch (Exception localException)
    {
      while (true)
        int i = 1;
    }
  }

  private static int IllIIIllII()
  {
    int j;
    for (int i = -1; ; i = j)
      while (true)
      {
        RandomAccessFile localRandomAccessFile;
        String[] arrayOfString;
        try
        {
          localRandomAccessFile = new RandomAccessFile("/sys/devices/system/cpu/cpu0/cpufreq/stats/time_in_state", "r");
          String str = localRandomAccessFile.readLine();
          if (str == null)
            break label92;
          arrayOfString = str.split("\\s+");
          if ((!lIlllIlIlI) && (arrayOfString.length != 2))
            throw new AssertionError();
        }
        catch (IOException localIOException)
        {
          localIOException.printStackTrace();
          return i;
        }
        if (Integer.parseInt(arrayOfString[1]) > 0)
        {
          j = Integer.parseInt(arrayOfString[0]) / 1000;
          if (j > i)
          {
            break;
            label92: localRandomAccessFile.close();
            continue;
          }
        }
        j = i;
      }
  }

  public static String getAndroidRelease()
  {
    return Build.VERSION.RELEASE;
  }

  public static String getDevice()
  {
    return Build.DEVICE;
  }

  public static String getManufacturer()
  {
    return Build.MANUFACTURER;
  }

  public static int getMaxCPUFrequency()
  {
    return IIlIIIllIl;
  }

  public static String getModel()
  {
    return Build.MODEL;
  }

  public static int getNumberOfCores()
  {
    return llIIlIIlll;
  }

  public static String getProcessorABI()
  {
    return Build.CPU_ABI;
  }

  public static int getSdkVersion()
  {
    return Build.VERSION.SDK_INT;
  }

  public static boolean isDeviceHQ()
  {
    llIIlIlIIl localllIIlIlIIl = new llIIlIlIIl(getDevice(), getModel());
    return IlIllIlIIl.contains(localllIIlIlIIl);
  }

  public static boolean isDeviceOnBarcodeBlackList()
  {
    llIIlIlIIl localllIIlIlIIl = new llIIlIlIIl(getDevice(), getModel());
    return IllIIIIllI.contains(localllIIlIlIIl);
  }

  public static boolean isDeviceOnBlackList()
  {
    llIIlIlIIl localllIIlIlIIl = new llIIlIlIIl(getDevice(), getModel());
    return jdField_llIIlIlIIl_of_type_JavaUtilSet.contains(localllIIlIlIIl);
  }

  public static boolean isDeviceOnOCRBlackList()
  {
    llIIlIlIIl localllIIlIlIIl = new llIIlIlIIl(getDevice(), getModel());
    return llIIIlllll.contains(localllIIlIlIIl);
  }

  public static boolean isDeviceOnWhiteList()
  {
    llIIlIlIIl localllIIlIlIIl = new llIIlIlIIl(getDevice(), getModel());
    return IllIIIllII.contains(localllIIlIlIIl);
  }

  public static boolean isDisplayOrientationBlacklisted()
  {
    llIIlIlIIl localllIIlIlIIl = new llIIlIlIIl(getDevice(), getModel());
    localllIIlIlIIl.llIIIlllll();
    return lIlIIIIlIl.contains(localllIIlIlIIl);
  }

  public boolean deviceHasAutofocus()
  {
    return this.mContext.getPackageManager().hasSystemFeature("android.hardware.camera.autofocus");
  }

  public boolean deviceHasCamera()
  {
    boolean bool;
    if (Build.VERSION.SDK_INT >= 9)
      if ((this.mContext.getPackageManager().hasSystemFeature("android.hardware.camera")) || (this.mContext.getPackageManager().hasSystemFeature("android.hardware.camera.front")))
        bool = true;
    while (true)
    {
      return bool;
      bool = false;
      continue;
      bool = this.mContext.getPackageManager().hasSystemFeature("android.hardware.camera");
    }
  }

  public Context getContext()
  {
    return this.mContext;
  }

  public String getReasonForLackOfSupport(boolean paramBoolean1, boolean paramBoolean2)
  {
    String str;
    if (getSdkVersion() < 7)
      str = this.mContext.getString(this.jdField_llIIlIlIIl_of_type_NetPhotopayUtilFakeR.getId("string", "FeatureUnsuportedAndroidVersion"));
    while (true)
    {
      return str;
      if (!deviceHasCamera())
      {
        str = this.mContext.getString(this.jdField_llIIlIlIIl_of_type_NetPhotopayUtilFakeR.getId("string", "FeatureUnsuportedDevice"));
        continue;
      }
      if ((paramBoolean2) && (!deviceHasAutofocus()))
      {
        str = this.mContext.getString(this.jdField_llIIlIlIIl_of_type_NetPhotopayUtilFakeR.getId("string", "FeatureUnsuportedAutofocus"));
        continue;
      }
      if (isDeviceOnBlackList())
      {
        str = this.mContext.getString(this.jdField_llIIlIlIIl_of_type_NetPhotopayUtilFakeR.getId("string", "FeatureUnsuportedDevice"));
        continue;
      }
      if (!paramBoolean1)
      {
        str = this.mContext.getString(this.jdField_llIIlIlIIl_of_type_NetPhotopayUtilFakeR.getId("string", "InvalidLicense"));
        continue;
      }
      str = null;
    }
  }

  public boolean isDeviceSupported()
  {
    int i = 1;
    int j;
    int k;
    if (getSdkVersion() >= 7)
    {
      j = i;
      if ((!deviceHasCamera()) || (!deviceHasAutofocus()))
        break label55;
      k = i;
      label28: if ((j == 0) || ((!isDeviceOnWhiteList()) && ((k == 0) || (isDeviceOnBlackList()))))
        break label60;
    }
    while (true)
    {
      return i;
      j = 0;
      break;
      label55: k = 0;
      break label28;
      label60: i = 0;
    }
  }
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     net.photopay.hardware.DeviceManager
 * JD-Core Version:    0.6.0
 */