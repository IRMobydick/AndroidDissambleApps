package net.photopay.view.viewfinder;

import android.graphics.Matrix;
import android.view.animation.Animation;
import android.view.animation.Transformation;

final class llIIlIlIIl$llIIlIlIIl extends Animation
{
  private float IlIIlllIIl;
  private float IlIlllllII;
  private float lIIIIIlIlI;
  private float llIIlIIIll;
  private float llIllIIlll;
  private float lllllIlIll;

  public llIIlIlIIl$llIIlIlIIl(llIIlIlIIl paramllIIlIlIIl, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, boolean paramBoolean)
  {
    this.lIIIIIlIlI = paramFloat1;
    this.IlIlllllII = paramFloat2;
    if (paramBoolean)
    {
      this.llIIlIIIll = (0.5F * (paramFloat3 - paramFloat4));
      this.IlIIlllIIl = (0.5F * (paramFloat4 - paramFloat3));
      if (!paramBoolean)
        break label85;
      this.llIllIIlll = (0.5F * paramFloat4);
    }
    for (this.lllllIlIll = (0.5F * paramFloat3); ; this.lllllIlIll = (0.5F * paramFloat4))
    {
      return;
      this.llIIlIIIll = 0.0F;
      this.IlIIlllIIl = 0.0F;
      break;
      label85: this.llIllIIlll = (0.5F * paramFloat3);
    }
  }

  protected final void applyTransformation(float paramFloat, Transformation paramTransformation)
  {
    paramTransformation.getMatrix().preTranslate(this.llIIlIIIll, this.IlIIlllIIl);
    paramTransformation.getMatrix().preRotate(this.lIIIIIlIlI + paramFloat * (this.IlIlllllII - this.lIIIIIlIlI), this.llIllIIlll, this.lllllIlIll);
  }
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     net.photopay.view.viewfinder.llIIlIlIIl.llIIlIlIIl
 * JD-Core Version:    0.6.0
 */