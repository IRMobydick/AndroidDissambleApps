package mobi.pdf417.activity;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import mobi.pdf417.Pdf417MobiSettings;
import net.photopay.base.BaseBarcodeActivity;
import net.photopay.hardware.orientation.Orientation;
import net.photopay.recognition.Right;
import net.photopay.recognition.RightsManager;
import net.photopay.secured.IlIIlllIIl;
import net.photopay.util.FakeR;
import net.photopay.view.viewfinder.AbstractViewFinder;

public class Pdf417ScanActivity extends BaseBarcodeActivity
{
  private IlIIlllIIl llIIlIlIIl;

  protected boolean isOrientationAllowed(Orientation paramOrientation)
  {
    return true;
  }

  public void onBackPressed()
  {
    setResult(0, null);
    finish();
  }

  protected AbstractViewFinder onCreateViewFinder()
  {
    ViewGroup localViewGroup = (ViewGroup)getLayoutInflater().inflate(this.jdField_llIIlIlIIl_of_type_NetPhotopayUtilFakeR.getId("layout", "default_barcode_camera_overlay"), null);
    RightsManager localRightsManager = getRightsManager();
    Pdf417MobiSettings localPdf417MobiSettings = getScanningSettings();
    if ((!localRightsManager.llIIlIlIIl(Right.IlIllIlIIl)) || ((localRightsManager.llIIlIlIIl(Right.IlIllIlIIl)) && (!localPdf417MobiSettings.isRemoveOverlayEnabled())));
    for (boolean bool = true; ; bool = false)
    {
      this.jdField_llIIlIlIIl_of_type_NetPhotopaySecuredIlIIlllIIl = new IlIIlllIIl(this, localViewGroup, bool);
      return this.jdField_llIIlIlIIl_of_type_NetPhotopaySecuredIlIIlllIIl;
    }
  }

  protected void onSetupViewFinder(AbstractViewFinder paramAbstractViewFinder)
  {
    super.onSetupViewFinder(paramAbstractViewFinder);
    this.jdField_llIIlIlIIl_of_type_NetPhotopaySecuredIlIIlllIIl.IIIIIIIIII();
  }
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     mobi.pdf417.activity.Pdf417ScanActivity
 * JD-Core Version:    0.6.0
 */