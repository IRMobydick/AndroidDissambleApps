package net.photopay.util;

import android.content.Context;
import android.hardware.Camera;
import net.photopay.hardware.DeviceManager;
import net.photopay.recognition.NativeRecognizerWrapper;
import net.photopay.secured.IllIIlIIII;
import net.photopay.secured.lIlIIIIlIl;
import net.photopay.secured.llIIlIIlll;
import net.photopay.secured.lllIlIlIIl;
import net.photopay.settings.RecognizerSettingsStatus;
import net.photopay.settings.llIIlIlIIl;

public class RecognizerCompatibility
{
  private static RecognizerCompatibilityStatus llIIlIlIIl = null;

  public static RecognizerCompatibilityStatus getRecognizerCompatibilityStatus(Context paramContext)
  {
    if (llIIlIlIIl == null)
    {
      if (NativeRecognizerWrapper.IlIIlllIIl())
        break label43;
      Object[] arrayOfObject = new Object[1];
      arrayOfObject[0] = "PhotoPayBarcode";
      Log.e(RecognizerCompatibility.class, "Unable to load lib{}.so. Native recognizer will not be supported!", arrayOfObject);
      llIIlIlIIl = RecognizerCompatibilityStatus.PROCESSOR_ARCHITECTURE_NOT_SUPPORTED;
    }
    while (true)
    {
      return llIIlIlIIl;
      label43: DeviceManager localDeviceManager = new DeviceManager(paramContext);
      if (DeviceManager.isDeviceOnBlackList())
      {
        llIIlIlIIl = RecognizerCompatibilityStatus.DEVICE_BLACKLISTED;
        continue;
      }
      if (DeviceManager.getSdkVersion() < 7)
      {
        llIIlIlIIl = RecognizerCompatibilityStatus.UNSUPPORTED_ANDROID_VERSION;
        continue;
      }
      if (DeviceManager.isDeviceOnWhiteList())
      {
        llIIlIlIIl = RecognizerCompatibilityStatus.RECOGNIZER_FULLY_SUPPORTED;
        continue;
      }
      if (DeviceManager.isDeviceOnOCRBlackList())
      {
        llIIlIlIIl = RecognizerCompatibilityStatus.RECOGNIZER_BARCODE_SUPPORTED;
        continue;
      }
      if (DeviceManager.isDeviceOnBarcodeBlackList())
      {
        llIIlIlIIl = RecognizerCompatibilityStatus.RECOGNIZER_OCR_SUPPORTED;
        continue;
      }
      if (DeviceManager.isDeviceHQ())
      {
        llIIlIlIIl = RecognizerCompatibilityStatus.RECOGNIZER_FULLY_SUPPORTED;
        continue;
      }
      Object localObject;
      if (localDeviceManager.deviceHasCamera())
        if (localDeviceManager.deviceHasAutofocus())
          localObject = null;
      try
      {
        Camera localCamera = Camera.open();
        localObject = localCamera;
        label168: if (localObject != null)
        {
          if (new lllIlIlIIl().llIIlIlIIl(new DeviceManager(paramContext), localObject, new lIlIIIIlIl()).lIIIIIlIlI())
            llIIlIlIIl = RecognizerCompatibilityStatus.CAMERA_RESOLUTION_TOO_SMALL;
          while (true)
          {
            localObject.release();
            break;
            llIIlIlIIl localllIIlIlIIl = new llIIlIlIIl();
            localllIIlIlIIl.lllIIlIIlI();
            if (DeviceManager.isDeviceOnBarcodeBlackList())
              localllIIlIlIIl.IlllIIIllI();
            if (DeviceManager.isDeviceOnOCRBlackList())
              localllIIlIlIIl.IlIIlIIIII();
            RecognizerSettingsStatus localRecognizerSettingsStatus = localllIIlIlIIl.llIIlIlIIl();
            if (localRecognizerSettingsStatus == RecognizerSettingsStatus.llIIlIlIIl)
            {
              llIIlIlIIl = RecognizerCompatibilityStatus.RECOGNIZER_FULLY_SUPPORTED;
              continue;
            }
            if (localRecognizerSettingsStatus == RecognizerSettingsStatus.IllIIIllII)
            {
              llIIlIlIIl = RecognizerCompatibilityStatus.RECOGNIZER_BARCODE_SUPPORTED;
              continue;
            }
            if (localRecognizerSettingsStatus == RecognizerSettingsStatus.IlIllIlIIl)
            {
              llIIlIlIIl = RecognizerCompatibilityStatus.RECOGNIZER_OCR_SUPPORTED;
              continue;
            }
            llIIlIlIIl = RecognizerCompatibilityStatus.RECOGNIZER_NOT_SUPPORTED;
          }
        }
        llIIlIlIIl = RecognizerCompatibilityStatus.CAMERA_NOT_READY;
        continue;
        llIIlIlIIl = RecognizerCompatibilityStatus.NO_AUTOFOCUS_CAMERA;
        continue;
        llIIlIlIIl = RecognizerCompatibilityStatus.NO_CAMERA;
      }
      catch (RuntimeException localRuntimeException)
      {
        break label168;
      }
    }
  }
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     net.photopay.util.RecognizerCompatibility
 * JD-Core Version:    0.6.0
 */