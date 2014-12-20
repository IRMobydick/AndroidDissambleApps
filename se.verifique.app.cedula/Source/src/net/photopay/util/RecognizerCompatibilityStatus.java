package net.photopay.util;

public enum RecognizerCompatibilityStatus
{
  static
  {
    RECOGNIZER_BARCODE_SUPPORTED = new RecognizerCompatibilityStatus("RECOGNIZER_BARCODE_SUPPORTED", 1);
    RECOGNIZER_OCR_SUPPORTED = new RecognizerCompatibilityStatus("RECOGNIZER_OCR_SUPPORTED", 2);
    PROCESSOR_ARCHITECTURE_NOT_SUPPORTED = new RecognizerCompatibilityStatus("PROCESSOR_ARCHITECTURE_NOT_SUPPORTED", 3);
    NO_CAMERA = new RecognizerCompatibilityStatus("NO_CAMERA", 4);
    NO_AUTOFOCUS_CAMERA = new RecognizerCompatibilityStatus("NO_AUTOFOCUS_CAMERA", 5);
    CAMERA_RESOLUTION_TOO_SMALL = new RecognizerCompatibilityStatus("CAMERA_RESOLUTION_TOO_SMALL", 6);
    DEVICE_BLACKLISTED = new RecognizerCompatibilityStatus("DEVICE_BLACKLISTED", 7);
    UNSUPPORTED_ANDROID_VERSION = new RecognizerCompatibilityStatus("UNSUPPORTED_ANDROID_VERSION", 8);
    CAMERA_NOT_READY = new RecognizerCompatibilityStatus("CAMERA_NOT_READY", 9);
    RECOGNIZER_NOT_SUPPORTED = new RecognizerCompatibilityStatus("RECOGNIZER_NOT_SUPPORTED", 10);
    RecognizerCompatibilityStatus[] arrayOfRecognizerCompatibilityStatus = new RecognizerCompatibilityStatus[11];
    arrayOfRecognizerCompatibilityStatus[0] = RECOGNIZER_FULLY_SUPPORTED;
    arrayOfRecognizerCompatibilityStatus[1] = RECOGNIZER_BARCODE_SUPPORTED;
    arrayOfRecognizerCompatibilityStatus[2] = RECOGNIZER_OCR_SUPPORTED;
    arrayOfRecognizerCompatibilityStatus[3] = PROCESSOR_ARCHITECTURE_NOT_SUPPORTED;
    arrayOfRecognizerCompatibilityStatus[4] = NO_CAMERA;
    arrayOfRecognizerCompatibilityStatus[5] = NO_AUTOFOCUS_CAMERA;
    arrayOfRecognizerCompatibilityStatus[6] = CAMERA_RESOLUTION_TOO_SMALL;
    arrayOfRecognizerCompatibilityStatus[7] = DEVICE_BLACKLISTED;
    arrayOfRecognizerCompatibilityStatus[8] = UNSUPPORTED_ANDROID_VERSION;
    arrayOfRecognizerCompatibilityStatus[9] = CAMERA_NOT_READY;
    arrayOfRecognizerCompatibilityStatus[10] = RECOGNIZER_NOT_SUPPORTED;
    $VALUES = arrayOfRecognizerCompatibilityStatus;
  }

  public final boolean isPhotopaySupported()
  {
    if ((this == RECOGNIZER_FULLY_SUPPORTED) || (this == RECOGNIZER_OCR_SUPPORTED) || (this == RECOGNIZER_BARCODE_SUPPORTED));
    for (int i = 1; ; i = 0)
      return i;
  }
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     net.photopay.util.RecognizerCompatibilityStatus
 * JD-Core Version:    0.6.0
 */