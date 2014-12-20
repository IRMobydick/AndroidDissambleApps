package net.photopay.hardware.camera;

import android.hardware.Camera.Parameters;
import android.hardware.Camera.PreviewCallback;
import java.util.Iterator;
import java.util.List;
import net.photopay.hardware.DeviceManager;
import net.photopay.hardware.camera.focus.AutofocusStatusView;
import net.photopay.hardware.camera.focus.IlIllIlIIl;
import net.photopay.secured.IllIIlIIII;
import net.photopay.util.Log;

public final class lIlIIIIlIl extends llIIlIlIIl
{
  private final Camera.PreviewCallback jdField_IlIllIlIIl_of_type_AndroidHardwareCamera$PreviewCallback = new lIlIIIIlIl.1(this);
  private net.photopay.secured.IllIIIllII jdField_IlIllIlIIl_of_type_NetPhotopaySecuredIllIIIllII;
  private AutofocusStatusView llIIlIlIIl;

  public lIlIIIIlIl(net.photopay.secured.llIIlIlIIl paramllIIlIlIIl, IllIIlIIII paramIllIIlIIII, llIIIlllll paramllIIIlllll, net.photopay.secured.lIlIIIIlIl paramlIlIIIIlIl, AutofocusStatusView paramAutofocusStatusView)
  {
    super(paramllIIlIlIIl, paramIllIIlIIII, paramllIIIlllll, paramlIlIIIIlIl);
    this.jdField_IlIllIlIIl_of_type_NetPhotopaySecuredIllIIIllII = paramlIlIIIIlIl.llIIlIlIIl();
    this.llIIlIlIIl = paramAutofocusStatusView;
  }

  public final void IlIllIlIIl()
  {
    super.IlIllIlIIl();
    if (this.jdField_IlIllIlIIl_of_type_NetPhotopaySecuredIllIIIllII != null)
      this.jdField_IlIllIlIIl_of_type_NetPhotopaySecuredIllIIIllII.IlIllIlIIl();
  }

  protected final Camera.PreviewCallback llIIlIlIIl()
  {
    return this.jdField_IlIllIlIIl_of_type_AndroidHardwareCamera$PreviewCallback;
  }

  protected final IlIllIlIIl llIIlIlIIl(Camera.Parameters paramParameters)
  {
    Object[] arrayOfObject1 = new Object[1];
    arrayOfObject1[0] = paramParameters.flatten();
    Log.v(this, "Original camera parameters: {}", arrayOfObject1);
    List localList1 = paramParameters.getSupportedFocusModes();
    Object localObject;
    List localList2;
    if (this.jdField_IlIllIlIIl_of_type_NetPhotopaySecuredLIlIIIIlIl.lllIlIlIIl())
      if ((localList1 != null) && (localList1.contains("auto")))
      {
        paramParameters.setFocusMode("auto");
        Log.v(this, "Activated autofocus", new Object[0]);
        localObject = new net.photopay.hardware.camera.focus.llIIlIlIIl(this.llIIlIlIIl);
        Object[] arrayOfObject2 = new Object[1];
        arrayOfObject2[0] = paramParameters.flatten();
        Log.v(this, "Parameters after setting focus mode: {}", arrayOfObject2);
        localList2 = paramParameters.getSupportedFlashModes();
        if ((localList2 == null) || (!localList2.contains("off")))
          break label498;
        paramParameters.setFlashMode("off");
        Log.i(this, "Setting flash mode to OFF!", new Object[0]);
        label139: Object[] arrayOfObject3 = new Object[1];
        arrayOfObject3[0] = paramParameters.flatten();
        Log.v(this, "Parameters after setting flash mode: {}", arrayOfObject3);
        List localList3 = paramParameters.getSupportedWhiteBalance();
        if ((localList3 == null) || (!localList3.contains("auto")))
          break label563;
        paramParameters.setWhiteBalance("auto");
        Log.v(this, "Activated automatic white balance correction", new Object[0]);
        label200: Object[] arrayOfObject4 = new Object[1];
        arrayOfObject4[0] = paramParameters.flatten();
        Log.v(this, "Parameters after setting white balance mode: {}", arrayOfObject4);
        if (!"Nexus 4".equals(DeviceManager.getModel()))
          break label576;
        paramParameters.setRecordingHint(true);
        paramParameters.setPictureSize(3264, 2448);
      }
    while (true)
    {
      Object[] arrayOfObject5 = new Object[1];
      arrayOfObject5[0] = paramParameters.flatten();
      Log.v(this, "Final parameters: {}", arrayOfObject5);
      return localObject;
      if ((localList1 != null) && (localList1.contains("macro")))
      {
        paramParameters.setFocusMode("macro");
        Log.v(this, "Activated macro focus mode", new Object[0]);
        localObject = new net.photopay.hardware.camera.focus.llIIlIlIIl(this.llIIlIlIIl);
        break;
      }
      Log.e(this, "Autofocus not supported", new Object[0]);
      if (this.jdField_IlIllIlIIl_of_type_NetPhotopaySecuredLIlIIIIlIl.lIIIIIllll())
        throw new RuntimeException("Autofocus is required, but not supported on this device");
      localObject = new net.photopay.hardware.camera.focus.IllIIIllII();
      break;
      if ((localList1 != null) && (localList1.contains("macro")))
      {
        paramParameters.setFocusMode("macro");
        Log.v(this, "Activated macro focus mode", new Object[0]);
        localObject = new net.photopay.hardware.camera.focus.llIIlIlIIl(this.llIIlIlIIl);
        break;
      }
      if ((localList1 != null) && (localList1.contains("auto")))
      {
        paramParameters.setFocusMode("auto");
        Log.v(this, "Activated autofocus", new Object[0]);
        localObject = new net.photopay.hardware.camera.focus.llIIlIlIIl(this.llIIlIlIIl);
        break;
      }
      Log.e(this, "Autofocus not supported", new Object[0]);
      if (this.jdField_IlIllIlIIl_of_type_NetPhotopaySecuredLIlIIIIlIl.lIIIIIllll())
        throw new RuntimeException("Autofocus is required, but not supported on this device");
      localObject = new net.photopay.hardware.camera.focus.IllIIIllII();
      break;
      label498: Log.e(this, "Flash mode OFF not supported!!!!", new Object[0]);
      if (localList2 == null)
        break label139;
      Log.i(this, "Supported flash modes:", new Object[0]);
      Iterator localIterator = localList2.iterator();
      while (localIterator.hasNext())
        Log.i(this, (String)localIterator.next(), new Object[0]);
      break label139;
      label563: Log.w(this, "Automatic white balance not supported!!!", new Object[0]);
      break label200;
      label576: if (DeviceManager.getModel().contains("Glass"))
      {
        paramParameters.setPreviewFpsRange(30000, 30000);
        continue;
      }
      paramParameters.setPreviewFrameRate(30);
    }
  }

  public final void llIIlIlIIl()
  {
    super.llIIlIlIIl();
    if (this.jdField_IlIllIlIIl_of_type_NetPhotopaySecuredIllIIIllII != null)
      this.jdField_IlIllIlIIl_of_type_NetPhotopaySecuredIllIIIllII.llIIlIlIIl();
  }
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     net.photopay.hardware.camera.lIlIIIIlIl
 * JD-Core Version:    0.6.0
 */