package net.photopay.hardware.camera;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public enum CameraType
  implements Parcelable
{
  public static final Parcelable.Creator CREATOR;

  static
  {
    CAMERA_BACKFACE = new CameraType("CAMERA_BACKFACE", 1);
    CAMERA_FRONTFACE = new CameraType("CAMERA_FRONTFACE", 2);
    CameraType[] arrayOfCameraType = new CameraType[3];
    arrayOfCameraType[0] = CAMERA_DEFAULT;
    arrayOfCameraType[1] = CAMERA_BACKFACE;
    arrayOfCameraType[2] = CAMERA_FRONTFACE;
    $VALUES = arrayOfCameraType;
    CREATOR = new CameraType.1();
  }

  public final int describeContents()
  {
    return 0;
  }

  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeInt(ordinal());
  }
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     net.photopay.hardware.camera.CameraType
 * JD-Core Version:    0.6.0
 */