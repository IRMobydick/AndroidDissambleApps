package net.photopay.nineoldandroids.view;

import java.util.ArrayList;

class ViewPropertyAnimatorPreHC$PropertyBundle
{
  ArrayList mNameValuesHolder;
  int mPropertyMask;

  ViewPropertyAnimatorPreHC$PropertyBundle(int paramInt, ArrayList paramArrayList)
  {
    this.mPropertyMask = paramInt;
    this.mNameValuesHolder = paramArrayList;
  }

  boolean cancel(int paramInt)
  {
    int k;
    if (((paramInt & this.mPropertyMask) != 0) && (this.mNameValuesHolder != null))
    {
      int j = this.mNameValuesHolder.size();
      k = 0;
      if (k < j)
        if (((ViewPropertyAnimatorPreHC.NameValuesHolder)this.mNameValuesHolder.get(k)).mNameConstant == paramInt)
        {
          this.mNameValuesHolder.remove(k);
          this.mPropertyMask &= (paramInt ^ 0xFFFFFFFF);
        }
    }
    for (int i = 1; ; i = 0)
    {
      return i;
      k++;
      break;
    }
  }
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     net.photopay.nineoldandroids.view.ViewPropertyAnimatorPreHC.PropertyBundle
 * JD-Core Version:    0.6.0
 */