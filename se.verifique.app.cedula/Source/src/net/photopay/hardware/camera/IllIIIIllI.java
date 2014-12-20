package net.photopay.hardware.camera;

import android.hardware.Camera;
import android.hardware.Camera.Parameters;
import android.hardware.Camera.PictureCallback;
import android.hardware.Camera.PreviewCallback;
import android.hardware.Camera.ShutterCallback;
import android.hardware.Camera.Size;
import android.os.Build.VERSION;
import android.os.Handler;
import java.util.List;
import net.photopay.hardware.camera.focus.AutofocusStatusView;
import net.photopay.hardware.camera.focus.IlIllIlIIl;
import net.photopay.secured.IllIIlIIII;
import net.photopay.secured.lIlIIIIlIl;
import net.photopay.secured.llIIlIIlll;
import net.photopay.secured.lllIIIlIlI;
import net.photopay.util.Log;

public final class IllIIIIllI extends llIIlIlIIl
{
  protected volatile boolean IlIIIIIlll = false;
  protected final Camera.PictureCallback llIIlIlIIl;
  protected final Camera.PreviewCallback llIIlIlIIl;
  protected final Camera.ShutterCallback llIIlIlIIl;
  protected AutofocusStatusView llIIlIlIIl;

  public IllIIIIllI(net.photopay.secured.llIIlIlIIl paramllIIlIlIIl, IllIIlIIII paramIllIIlIIII, llIIIlllll paramllIIIlllll, lIlIIIIlIl paramlIlIIIIlIl, AutofocusStatusView paramAutofocusStatusView)
  {
    super(paramllIIlIlIIl, paramIllIIlIIII, paramllIIIlllll, paramlIlIIIIlIl);
    this.jdField_llIIlIlIIl_of_type_AndroidHardwareCamera$ShutterCallback = new IllIIIIllI.3(this);
    this.jdField_llIIlIlIIl_of_type_AndroidHardwareCamera$PictureCallback = new IllIIIIllI.4(this);
    this.jdField_llIIlIlIIl_of_type_AndroidHardwareCamera$PreviewCallback = new IllIIIIllI.5(this);
    this.jdField_llIIlIlIIl_of_type_NetPhotopayHardwareCameraFocusAutofocusStatusView = paramAutofocusStatusView;
  }

  public final void IlIllIlllI()
  {
    this.mHandler.post(new IllIIIIllI.1(this));
  }

  protected final boolean IllIIIllII()
  {
    return false;
  }

  protected final Camera.PreviewCallback llIIlIlIIl()
  {
    return null;
  }

  protected final IlIllIlIIl llIIlIlIIl(Camera.Parameters paramParameters)
  {
    List localList1 = paramParameters.getSupportedFocusModes();
    Object localObject;
    if ((localList1 != null) && (localList1.contains("macro")))
    {
      paramParameters.setFocusMode("macro");
      Log.i(this, "Activated macro focus mode", new Object[0]);
      localObject = new net.photopay.hardware.camera.focus.llIIlIlIIl(this.jdField_llIIlIlIIl_of_type_NetPhotopayHardwareCameraFocusAutofocusStatusView);
      List localList2 = paramParameters.getSupportedFlashModes();
      if ((localList2 != null) && (localList2.contains("auto")))
        paramParameters.setFlashMode("auto");
      List localList3 = paramParameters.getSupportedWhiteBalance();
      if ((localList3 == null) || (!localList3.contains("auto")))
        break label317;
      paramParameters.setWhiteBalance("auto");
      Log.i(this, "Activated automatic white balance correction", new Object[0]);
    }
    while (true)
    {
      if (Build.VERSION.SDK_INT >= 8)
        paramParameters.setPictureFormat(256);
      paramParameters.setJpegQuality(40);
      if (!(this.jdField_llIIlIlIIl_of_type_NetPhotopaySecuredLlIIlIIlll instanceof lllIIIlIlI))
        break label330;
      Camera.Size localSize = ((lllIIIlIlI)this.jdField_llIIlIlIIl_of_type_NetPhotopaySecuredLlIIlIIlll).IlIllIlIIl(this.jdField_llIIlIlIIl_of_type_NetPhotopayHardwareCameraIllIIIllII.getWidth(), this.jdField_llIIlIlIIl_of_type_NetPhotopayHardwareCameraIllIIIllII.getHeight());
      Log.i(this, "Picture size is: " + localSize.width + "x" + localSize.height, new Object[0]);
      paramParameters.setPictureSize(localSize.width, localSize.height);
      return localObject;
      if ((localList1 != null) && (localList1.contains("auto")))
      {
        paramParameters.setFocusMode("auto");
        Log.i(this, "Activated autofocus", new Object[0]);
        localObject = new net.photopay.hardware.camera.focus.llIIlIlIIl(this.jdField_llIIlIlIIl_of_type_NetPhotopayHardwareCameraFocusAutofocusStatusView);
        break;
      }
      Log.i(this, "Autofocus not supported", new Object[0]);
      if (this.IlIllIlIIl.lIIIIIllll())
        throw new RuntimeException("Autofocus is required, but not supported on this device");
      localObject = new net.photopay.hardware.camera.focus.IllIIIllII();
      break;
      label317: Log.w(this, "Automatic white balance not supported!!!", new Object[0]);
    }
    label330: Log.e(this, "PhotoCameraManager should have a camera strategy that is instance of PhotoPreviewCameraStrategy in order to be able to calculate photo image size. Without this, PhotoPay will most likely crash!", new Object[0]);
    throw new IllegalStateException("PhotoCameraManager should have a camera strategy that is instance of PhotoPreviewCameraStrategy in order to be able to calculate photo image size.");
  }

  public final void llIIlIlIIl()
  {
    super.llIIlIlIIl();
  }

  public final void resumeFrameGrabbing(ResumeGrabberCaller paramResumeGrabberCaller)
  {
    if ((paramResumeGrabberCaller == ResumeGrabberCaller.IllIIIllII) && (this.jdField_llIIlIlIIl_of_type_AndroidHardwareCamera != null) && (!this.IlIIlIIIII))
      this.IlIIlIIIII = true;
    try
    {
      this.jdField_llIIlIlIIl_of_type_AndroidHardwareCamera.startPreview();
      this.mHandler.postDelayed(new IllIIIIllI.2(this), this.jdField_llIIlIlIIl_of_type_NetPhotopaySecuredLlIIlIIlll.llIIlIIlll());
      super.resumeFrameGrabbing(paramResumeGrabberCaller);
      return;
    }
    catch (RuntimeException localRuntimeException)
    {
      while (true)
        Log.e(this, localRuntimeException, "Unable to restart camera preview", new Object[0]);
    }
  }
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     net.photopay.hardware.camera.IllIIIIllI
 * JD-Core Version:    0.6.0
 */