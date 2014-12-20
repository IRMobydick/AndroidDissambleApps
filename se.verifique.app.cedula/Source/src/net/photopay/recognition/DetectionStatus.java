package net.photopay.recognition;

public abstract interface DetectionStatus
{
  public static final int DETECTION_STATUS_BLURRY_FRAME = 256;
  public static final int DETECTION_STATUS_CAMERA_AT_ANGLE = 128;
  public static final int DETECTION_STATUS_CAMERA_TOO_HIGH = 4;
  public static final int DETECTION_STATUS_FAIL = 2;
  public static final int DETECTION_STATUS_FALLBACK_SUCCESS = 16;
  public static final int DETECTION_STATUS_PARTIAL_FORM = 64;
  public static final int DETECTION_STATUS_PDF417_SUCCESS = 32;
  public static final int DETECTION_STATUS_QR_SUCCESS = 8;
  public static final int DETECTION_STATUS_SUCCESS = 1;
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     net.photopay.recognition.DetectionStatus
 * JD-Core Version:    0.6.0
 */