package net.photopay.hardware.camera;

import android.graphics.ImageFormat;
import android.hardware.Camera;
import android.hardware.Camera.CameraInfo;
import android.hardware.Camera.Parameters;
import android.hardware.Camera.PreviewCallback;
import android.hardware.Camera.Size;
import android.os.Build.VERSION;
import android.os.Handler;
import android.view.SurfaceHolder;
import java.util.List;
import net.photopay.hardware.DeviceManager;
import net.photopay.secured.IllIIlIIII;
import net.photopay.secured.lIlIIIIlIl;
import net.photopay.secured.llIIlIIlll;
import net.photopay.util.Log;

public abstract class llIIlIlIIl
  implements net.photopay.secured.IllIIIllII
{
  protected boolean IlIIlIIIII = false;
  protected boolean IlIlIlIIlI = true;
  protected lIlIIIIlIl IlIllIlIIl = null;
  protected volatile boolean IlllIIIllI = false;
  protected byte[] llIIIlllll = null;
  private Camera.Size jdField_llIIlIlIIl_of_type_AndroidHardwareCamera$Size = null;
  protected Camera llIIlIlIIl;
  private CameraType jdField_llIIlIlIIl_of_type_NetPhotopayHardwareCameraCameraType = null;
  protected IllIIIllII llIIlIlIIl;
  private net.photopay.hardware.camera.focus.IlIllIlIIl jdField_llIIlIlIIl_of_type_NetPhotopayHardwareCameraFocusIlIllIlIIl = null;
  protected llIIIlllll llIIlIlIIl;
  private IllIIlIIII jdField_llIIlIlIIl_of_type_NetPhotopaySecuredIllIIlIIII = null;
  protected llIIlIIlll llIIlIlIIl;
  protected net.photopay.secured.llIIlIlIIl llIIlIlIIl;
  protected Handler mHandler = new Handler();

  public llIIlIlIIl(net.photopay.secured.llIIlIlIIl paramllIIlIlIIl, IllIIlIIII paramIllIIlIIII, llIIIlllll paramllIIIlllll, lIlIIIIlIl paramlIlIIIIlIl)
  {
    this.jdField_llIIlIlIIl_of_type_AndroidHardwareCamera = null;
    this.jdField_llIIlIlIIl_of_type_NetPhotopaySecuredLlIIlIlIIl = null;
    this.jdField_llIIlIlIIl_of_type_NetPhotopayHardwareCameraLlIIIlllll = null;
    this.jdField_llIIlIlIIl_of_type_NetPhotopaySecuredLlIIlIIlll = null;
    this.jdField_llIIlIlIIl_of_type_NetPhotopayHardwareCameraIllIIIllII = null;
    this.jdField_llIIlIlIIl_of_type_NetPhotopaySecuredLlIIlIlIIl = paramllIIlIlIIl;
    this.jdField_llIIlIlIIl_of_type_NetPhotopayHardwareCameraLlIIIlllll = paramllIIIlllll;
    this.IlIllIlIIl = paramlIlIIIIlIl;
    this.jdField_llIIlIlIIl_of_type_NetPhotopaySecuredIllIIlIIII = paramIllIIlIIII;
    if ((this.jdField_llIIlIlIIl_of_type_NetPhotopaySecuredLlIIlIlIIl == null) || (this.jdField_llIIlIlIIl_of_type_NetPhotopaySecuredIllIIlIIII == null))
      throw new NullPointerException("Camera manager requires accelerometer manager and camera strategy factory to be non-null");
    if (this.jdField_llIIlIlIIl_of_type_NetPhotopayHardwareCameraLlIIIlllll == null)
      throw new NullPointerException("Camera delegate can't be null.");
    if (this.IlIllIlIIl == null)
      this.IlIllIlIIl = new lIlIIIIlIl();
    this.jdField_llIIlIlIIl_of_type_NetPhotopaySecuredLlIIlIlIIl.llIIlIlIIl(this);
  }

  public final void IIlIIIllIl()
  {
    llIIlIIlll();
    this.jdField_llIIlIlIIl_of_type_NetPhotopayHardwareCameraIllIIIllII = null;
  }

  public void IlIllIlIIl()
  {
    Log.v(this, "shaking started", new Object[0]);
    this.IlIlIlIIlI = true;
    if (this.jdField_llIIlIlIIl_of_type_NetPhotopayHardwareCameraFocusIlIllIlIIl != null)
      this.jdField_llIIlIlIIl_of_type_NetPhotopayHardwareCameraFocusIlIllIlIIl.lIIIIIlIlI();
  }

  public void IlIllIlllI()
  {
    lllIIIlIlI();
  }

  public final boolean IllIIIIllI()
  {
    if (this.jdField_llIIlIlIIl_of_type_NetPhotopayHardwareCameraFocusIlIllIlIIl != null);
    for (boolean bool = this.jdField_llIIlIlIIl_of_type_NetPhotopayHardwareCameraFocusIlIllIlIIl.isCameraFocused(); ; bool = false)
      return bool;
  }

  protected boolean IllIIIllII()
  {
    if (Build.VERSION.SDK_INT >= 8);
    for (int i = 1; ; i = 0)
      return i;
  }

  public final boolean isDeviceShaking()
  {
    return this.IlIlIlIIlI;
  }

  public final void lIIIIIllll()
  {
    Camera.Size localSize2;
    if (this.IlIIlIIIII)
    {
      localSize2 = this.jdField_llIIlIlIIl_of_type_AndroidHardwareCamera.getParameters().getPreviewSize();
      if ((this.jdField_llIIlIlIIl_of_type_AndroidHardwareCamera$Size.width <= localSize2.width) && (this.jdField_llIIlIlIIl_of_type_AndroidHardwareCamera$Size.height <= localSize2.height))
        break label280;
      Object[] arrayOfObject6 = new Object[4];
      arrayOfObject6[0] = Integer.valueOf(this.jdField_llIIlIlIIl_of_type_AndroidHardwareCamera$Size.width);
      arrayOfObject6[1] = Integer.valueOf(this.jdField_llIIlIlIIl_of_type_AndroidHardwareCamera$Size.height);
      arrayOfObject6[2] = Integer.valueOf(localSize2.width);
      arrayOfObject6[3] = Integer.valueOf(localSize2.height);
      Log.v(this, "Preview is already active and new preview size ({}x{}) is larger than current one ({}x{}). Will restart the preview.", arrayOfObject6);
      this.IlIIlIIIII = false;
      this.jdField_llIIlIlIIl_of_type_AndroidHardwareCamera.stopPreview();
    }
    Camera.Parameters localParameters;
    while (true)
    {
      if ((this.jdField_llIIlIlIIl_of_type_NetPhotopayHardwareCameraIllIIIllII == null) || (!this.jdField_llIIlIlIIl_of_type_NetPhotopayHardwareCameraIllIIIllII.llIIlIIlll()) || (this.IlIIlIIIII) || (this.jdField_llIIlIlIIl_of_type_AndroidHardwareCamera == null))
        break label580;
      this.jdField_llIIlIlIIl_of_type_AndroidHardwareCamera.setPreviewDisplay(this.jdField_llIIlIlIIl_of_type_NetPhotopayHardwareCameraIllIIIllII.llIIlIlIIl());
      if (net.photopay.util.llIIlIlIIl.isPortrait())
      {
        Log.i(this, "Rotating camera preview by 90 degrees!", new Object[0]);
        net.photopay.util.llIIlIlIIl.llIIlIlIIl(this.jdField_llIIlIlIIl_of_type_AndroidHardwareCamera);
      }
      localParameters = this.jdField_llIIlIlIIl_of_type_AndroidHardwareCamera.getParameters();
      this.jdField_llIIlIlIIl_of_type_NetPhotopayHardwareCameraFocusIlIllIlIIl = llIIlIlIIl(localParameters);
      Object[] arrayOfObject2 = new Object[1];
      arrayOfObject2[0] = this.jdField_llIIlIlIIl_of_type_NetPhotopayHardwareCameraFocusIlIllIlIIl;
      Log.v(this, "Focus manager: {}", arrayOfObject2);
      if (this.jdField_llIIlIlIIl_of_type_NetPhotopayHardwareCameraFocusIlIllIlIIl != null)
      {
        this.jdField_llIIlIlIIl_of_type_NetPhotopayHardwareCameraFocusIlIllIlIIl.setCamera(this.jdField_llIIlIlIIl_of_type_AndroidHardwareCamera);
        this.jdField_llIIlIlIIl_of_type_NetPhotopayHardwareCameraFocusIlIllIlIIl.IllIIlIIII();
        if (this.jdField_llIIlIlIIl_of_type_AndroidHardwareCamera$Size != null)
          break;
        throw new IlIllIlIIl("Camera resolution is too small!");
        label280: this.jdField_llIIlIlIIl_of_type_AndroidHardwareCamera$Size = localSize2;
        continue;
      }
      else
      {
        throw new IllegalStateException("Method prepareCameraParametersAndFocusManager did not prepare focus manager!");
      }
    }
    Object[] arrayOfObject3 = new Object[2];
    arrayOfObject3[0] = Integer.valueOf(this.jdField_llIIlIlIIl_of_type_AndroidHardwareCamera$Size.width);
    arrayOfObject3[1] = Integer.valueOf(this.jdField_llIIlIlIIl_of_type_AndroidHardwareCamera$Size.height);
    Log.d(this, "Resuming camera with preview size {}x{}", arrayOfObject3);
    localParameters.setPreviewSize(this.jdField_llIIlIlIIl_of_type_AndroidHardwareCamera$Size.width, this.jdField_llIIlIlIIl_of_type_AndroidHardwareCamera$Size.height);
    try
    {
      Object[] arrayOfObject5 = new Object[1];
      arrayOfObject5[0] = localParameters.flatten();
      Log.v(this, "Setting following parameters to camera: {}", arrayOfObject5);
      this.jdField_llIIlIlIIl_of_type_AndroidHardwareCamera.setParameters(localParameters);
      if (IllIIIllII())
      {
        Camera.Size localSize1 = this.jdField_llIIlIlIIl_of_type_AndroidHardwareCamera$Size;
        int i = ImageFormat.getBitsPerPixel(localParameters.getPreviewFormat());
        if (i == -1)
          i = 24;
        int j = i * (localSize1.width * localSize1.height) / 8;
        this.llIIIlllll = null;
        this.llIIIlllll = new byte[j];
        this.jdField_llIIlIlIIl_of_type_AndroidHardwareCamera.addCallbackBuffer(this.llIIIlllll);
        this.jdField_llIIlIlIIl_of_type_AndroidHardwareCamera.startPreview();
        this.IlIIlIIIII = true;
        this.IlllIIIllI = false;
        this.mHandler.postDelayed(new llIIlIlIIl.1(this), this.jdField_llIIlIlIIl_of_type_NetPhotopaySecuredLlIIlIIlll.llIIlIIlll());
        return;
      }
    }
    catch (RuntimeException localRuntimeException)
    {
      while (true)
      {
        Log.e(this, localRuntimeException, "Setting camera parameters failed!", new Object[0]);
        Object[] arrayOfObject4 = new Object[2];
        arrayOfObject4[0] = Integer.valueOf(this.jdField_llIIlIlIIl_of_type_AndroidHardwareCamera$Size.width);
        arrayOfObject4[1] = Integer.valueOf(this.jdField_llIIlIlIIl_of_type_AndroidHardwareCamera$Size.height);
        Log.e(this, "Preview width: {} height: {}", arrayOfObject4);
        continue;
        this.jdField_llIIlIlIIl_of_type_AndroidHardwareCamera.setOneShotPreviewCallback(llIIlIlIIl());
      }
    }
    label580: Log.v(this, "Camera still hasn't got surface or preview already active. Cannot start preview!", new Object[0]);
    Object[] arrayOfObject1 = new Object[2];
    if (this.jdField_llIIlIlIIl_of_type_NetPhotopayHardwareCameraIllIIIllII != null);
    for (boolean bool = true; ; bool = false)
    {
      arrayOfObject1[0] = Boolean.valueOf(bool);
      arrayOfObject1[1] = Boolean.valueOf(this.IlIIlIIIII);
      Log.v(this, "has surface: {}; previewActive: {}", arrayOfObject1);
      break;
    }
  }

  public final boolean lIlIIIIlIl()
  {
    int i = 0;
    if (this.jdField_llIIlIlIIl_of_type_AndroidHardwareCamera != null)
    {
      List localList = this.jdField_llIIlIlIIl_of_type_AndroidHardwareCamera.getParameters().getSupportedFlashModes();
      if ((localList != null) && (localList.contains("torch")))
      {
        Log.i(this, "Camera supports torch!", new Object[0]);
        i = 1;
      }
    }
    while (true)
    {
      return i;
      Log.i(this, "Camera does not support torch!", new Object[0]);
      continue;
      Log.e(this, "Camera not yet initialized. Unable to determine if torch is supported!", new Object[0]);
    }
  }

  public final boolean llIIIlllll()
  {
    if (this.jdField_llIIlIlIIl_of_type_NetPhotopayHardwareCameraIllIIIllII != null);
    for (int i = 1; ; i = 0)
      return i;
  }

  public final void llIIlIIlll()
  {
    this.IlllIIIllI = true;
    if (this.jdField_llIIlIlIIl_of_type_NetPhotopayHardwareCameraFocusIlIllIlIIl != null)
    {
      this.jdField_llIIlIlIIl_of_type_NetPhotopayHardwareCameraFocusIlIllIlIIl.lIIIIIlIlI();
      this.jdField_llIIlIlIIl_of_type_NetPhotopayHardwareCameraFocusIlIllIlIIl.setCamera(null);
    }
    if (this.jdField_llIIlIlIIl_of_type_NetPhotopaySecuredLlIIlIlIIl != null)
      this.jdField_llIIlIlIIl_of_type_NetPhotopaySecuredLlIIlIlIIl.lIlIIIIlIl();
    if (this.jdField_llIIlIlIIl_of_type_AndroidHardwareCamera != null)
    {
      if (IllIIIllII())
        this.jdField_llIIlIlIIl_of_type_AndroidHardwareCamera.setPreviewCallbackWithBuffer(null);
      this.jdField_llIIlIlIIl_of_type_AndroidHardwareCamera.stopPreview();
      this.IlIIlIIIII = false;
      this.jdField_llIIlIlIIl_of_type_AndroidHardwareCamera.release();
      this.jdField_llIIlIlIIl_of_type_AndroidHardwareCamera = null;
    }
    this.jdField_llIIlIlIIl_of_type_NetPhotopaySecuredLlIIlIIlll = null;
  }

  protected abstract Camera.PreviewCallback llIIlIlIIl();

  public final Camera.Size llIIlIlIIl()
  {
    return this.jdField_llIIlIlIIl_of_type_AndroidHardwareCamera$Size;
  }

  public final CameraType llIIlIlIIl()
  {
    return this.jdField_llIIlIlIIl_of_type_NetPhotopayHardwareCameraCameraType;
  }

  protected final net.photopay.hardware.camera.focus.IlIllIlIIl llIIlIlIIl()
  {
    return this.jdField_llIIlIlIIl_of_type_NetPhotopayHardwareCameraFocusIlIllIlIIl;
  }

  protected abstract net.photopay.hardware.camera.focus.IlIllIlIIl llIIlIlIIl(Camera.Parameters paramParameters);

  public void llIIlIlIIl()
  {
    Log.v(this, "shaking stopped", new Object[0]);
    if (this.jdField_llIIlIlIIl_of_type_NetPhotopayHardwareCameraFocusIlIllIlIIl != null)
    {
      this.jdField_llIIlIlIIl_of_type_NetPhotopayHardwareCameraFocusIlIllIlIIl.IllIIlIIII();
      this.jdField_llIIlIlIIl_of_type_NetPhotopayHardwareCameraFocusIlIllIlIIl.llIIlIlIIl(true);
    }
    this.IlIlIlIIlI = false;
  }

  public final void llIIlIlIIl(SurfaceHolder paramSurfaceHolder, int paramInt1, int paramInt2)
  {
    if ((this.jdField_llIIlIlIIl_of_type_NetPhotopayHardwareCameraIllIIIllII == null) || (!this.jdField_llIIlIlIIl_of_type_NetPhotopayHardwareCameraIllIIIllII.llIIlIIlll()) || (paramInt1 > this.jdField_llIIlIlIIl_of_type_NetPhotopayHardwareCameraIllIIIllII.getWidth()) || (paramInt2 > this.jdField_llIIlIlIIl_of_type_NetPhotopayHardwareCameraIllIIIllII.getHeight()))
      this.jdField_llIIlIlIIl_of_type_NetPhotopayHardwareCameraIllIIIllII = new IllIIIllII(paramSurfaceHolder, paramInt1, paramInt2);
    if (this.jdField_llIIlIlIIl_of_type_NetPhotopayHardwareCameraIllIIIllII.llIIlIIlll())
    {
      this.jdField_llIIlIlIIl_of_type_AndroidHardwareCamera$Size = this.jdField_llIIlIlIIl_of_type_NetPhotopaySecuredLlIIlIIlll.llIIlIlIIl(this.jdField_llIIlIlIIl_of_type_NetPhotopayHardwareCameraIllIIIllII.getWidth(), this.jdField_llIIlIlIIl_of_type_NetPhotopayHardwareCameraIllIIIllII.getHeight());
      if (this.jdField_llIIlIlIIl_of_type_AndroidHardwareCamera$Size == null)
        throw new net.photopay.recognition.IlIllIlIIl("Camera preview size could not be chosen!");
      Object[] arrayOfObject = new Object[4];
      arrayOfObject[0] = Integer.valueOf(this.jdField_llIIlIlIIl_of_type_NetPhotopayHardwareCameraIllIIIllII.getWidth());
      arrayOfObject[1] = Integer.valueOf(this.jdField_llIIlIlIIl_of_type_NetPhotopayHardwareCameraIllIIIllII.getHeight());
      arrayOfObject[2] = Integer.valueOf(this.jdField_llIIlIlIIl_of_type_AndroidHardwareCamera$Size.width);
      arrayOfObject[3] = Integer.valueOf(this.jdField_llIIlIlIIl_of_type_AndroidHardwareCamera$Size.height);
      Log.i(this, "For surface size {}x{}, selected preview size is {}x{}", arrayOfObject);
      lIIIIIllll();
    }
  }

  public final void llIIlIlIIl(DeviceManager paramDeviceManager, lIlIIIIlIl paramlIlIIIIlIl)
  {
    int i = -1;
    CameraType localCameraType = paramlIlIIIIlIl.getCameraType();
    Camera localCamera;
    if (Build.VERSION.SDK_INT < 9)
    {
      this.jdField_llIIlIlIIl_of_type_NetPhotopayHardwareCameraCameraType = CameraType.CAMERA_BACKFACE;
      localCamera = Camera.open();
      this.jdField_llIIlIlIIl_of_type_AndroidHardwareCamera = localCamera;
      this.jdField_llIIlIlIIl_of_type_NetPhotopaySecuredLlIIlIIlll = this.jdField_llIIlIlIIl_of_type_NetPhotopaySecuredIllIIlIIII.llIIlIlIIl(paramDeviceManager, this.jdField_llIIlIlIIl_of_type_AndroidHardwareCamera, paramlIlIIIIlIl);
      Object[] arrayOfObject = new Object[1];
      arrayOfObject[0] = this.jdField_llIIlIlIIl_of_type_NetPhotopaySecuredLlIIlIIlll;
      Log.v(this, "Camera strategy: {}", arrayOfObject);
      if (!IllIIIllII())
        break label314;
      this.jdField_llIIlIlIIl_of_type_AndroidHardwareCamera.setPreviewCallbackWithBuffer(llIIlIlIIl());
      if (this.llIIIlllll != null)
        this.jdField_llIIlIlIIl_of_type_AndroidHardwareCamera.addCallbackBuffer(this.llIIIlllll);
    }
    while (true)
    {
      return;
      Camera.CameraInfo localCameraInfo = new Camera.CameraInfo();
      int j = Camera.getNumberOfCameras();
      int k = 0;
      int m = i;
      if (k < j)
      {
        Camera.getCameraInfo(k, localCameraInfo);
        if (localCameraInfo.facing == 1)
          m = k;
        while (true)
        {
          k++;
          break;
          if (localCameraInfo.facing != 0)
            continue;
          i = k;
        }
      }
      if (localCameraType == CameraType.CAMERA_BACKFACE)
      {
        if (i >= 0)
        {
          this.jdField_llIIlIlIIl_of_type_NetPhotopayHardwareCameraCameraType = CameraType.CAMERA_BACKFACE;
          localCamera = Camera.open(i);
          break;
        }
        throw new RuntimeException("Device does not have back facing camera!");
      }
      if (localCameraType == CameraType.CAMERA_FRONTFACE)
      {
        if (m >= 0)
        {
          this.jdField_llIIlIlIIl_of_type_NetPhotopayHardwareCameraCameraType = CameraType.CAMERA_FRONTFACE;
          localCamera = Camera.open(m);
          break;
        }
        throw new RuntimeException("Device does not have front facing camera!");
      }
      if (i >= 0)
      {
        this.jdField_llIIlIlIIl_of_type_NetPhotopayHardwareCameraCameraType = CameraType.CAMERA_BACKFACE;
        localCamera = Camera.open(i);
        break;
      }
      if (m >= 0)
      {
        this.jdField_llIIlIlIIl_of_type_NetPhotopayHardwareCameraCameraType = CameraType.CAMERA_FRONTFACE;
        localCamera = Camera.open(m);
        break;
      }
      throw new RuntimeException("Device does not have cameras!");
      label314: this.jdField_llIIlIlIIl_of_type_AndroidHardwareCamera.setOneShotPreviewCallback(llIIlIlIIl());
    }
  }

  public final boolean llIIlIlIIl(boolean paramBoolean)
  {
    int i = 0;
    if (!lIlIIIIlIl())
      Log.e(this, "Camera does not support torch! Cannot change torch state!", new Object[0]);
    while (true)
    {
      return i;
      boolean bool;
      label46: Camera.Parameters localParameters;
      if (this.jdField_llIIlIlIIl_of_type_AndroidHardwareCamera != null)
        if (this.jdField_llIIlIlIIl_of_type_NetPhotopayHardwareCameraFocusIlIllIlIIl != null)
        {
          bool = this.jdField_llIIlIlIIl_of_type_NetPhotopayHardwareCameraFocusIlIllIlIIl.IIlIIIllIl();
          if (bool)
            this.jdField_llIIlIlIIl_of_type_NetPhotopayHardwareCameraFocusIlIllIlIIl.lllIlIlIIl();
          localParameters = this.jdField_llIIlIlIIl_of_type_AndroidHardwareCamera.getParameters();
          if (!paramBoolean)
            break label103;
          localParameters.setFlashMode("torch");
        }
      try
      {
        while (true)
        {
          this.jdField_llIIlIlIIl_of_type_AndroidHardwareCamera.setParameters(localParameters);
          lllIIIlIlI();
          i = 1;
          break;
          bool = false;
          break label46;
          label103: List localList = localParameters.getSupportedFlashModes();
          if ((localList == null) || (!localList.contains("off")))
            continue;
          localParameters.setFlashMode("off");
        }
        Log.e(this, "Camera not yet initialized. Unable to change torch state!", new Object[0]);
      }
      catch (RuntimeException localRuntimeException)
      {
      }
    }
  }

  public final void lllIIIlIlI()
  {
    if (this.jdField_llIIlIlIIl_of_type_NetPhotopayHardwareCameraFocusIlIllIlIIl != null)
      this.jdField_llIIlIlIIl_of_type_NetPhotopayHardwareCameraFocusIlIllIlIIl.llIIlIlIIl(true);
  }

  public final void pauseFrameGrabbing()
  {
    this.IlllIIIllI = true;
  }

  public void resumeFrameGrabbing(ResumeGrabberCaller paramResumeGrabberCaller)
  {
    this.IlllIIIllI = false;
    if (paramResumeGrabberCaller == ResumeGrabberCaller.IlIllIlIIl)
      this.jdField_llIIlIlIIl_of_type_NetPhotopayHardwareCameraFocusIlIllIlIIl.llIIlIlIIl(false);
    if (this.jdField_llIIlIlIIl_of_type_AndroidHardwareCamera != null)
    {
      if (!IllIIIllII())
        break label55;
      if (this.llIIIlllll != null)
        this.jdField_llIIlIlIIl_of_type_AndroidHardwareCamera.addCallbackBuffer(this.llIIIlllll);
    }
    while (true)
    {
      return;
      label55: this.jdField_llIIlIlIIl_of_type_AndroidHardwareCamera.setOneShotPreviewCallback(llIIlIlIIl());
    }
  }
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     net.photopay.hardware.camera.llIIlIlIIl
 * JD-Core Version:    0.6.0
 */