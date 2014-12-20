package net.photopay.nineoldandroids.animation;

import android.util.Log;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import net.photopay.nineoldandroids.util.IntProperty;
import net.photopay.nineoldandroids.util.Property;

class PropertyValuesHolder$IntPropertyValuesHolder extends PropertyValuesHolder
{
  int mIntAnimatedValue;
  IntKeyframeSet mIntKeyframeSet;
  private IntProperty mIntProperty;

  public PropertyValuesHolder$IntPropertyValuesHolder(String paramString, IntKeyframeSet paramIntKeyframeSet)
  {
    super(paramString, null);
    this.mValueType = Integer.TYPE;
    this.mKeyframeSet = paramIntKeyframeSet;
    this.mIntKeyframeSet = ((IntKeyframeSet)this.mKeyframeSet);
  }

  public PropertyValuesHolder$IntPropertyValuesHolder(String paramString, int[] paramArrayOfInt)
  {
    super(paramString, null);
    setIntValues(paramArrayOfInt);
  }

  public PropertyValuesHolder$IntPropertyValuesHolder(Property paramProperty, IntKeyframeSet paramIntKeyframeSet)
  {
    super(paramProperty, null);
    this.mValueType = Integer.TYPE;
    this.mKeyframeSet = paramIntKeyframeSet;
    this.mIntKeyframeSet = ((IntKeyframeSet)this.mKeyframeSet);
    if ((paramProperty instanceof IntProperty))
      this.mIntProperty = ((IntProperty)this.mProperty);
  }

  public PropertyValuesHolder$IntPropertyValuesHolder(Property paramProperty, int[] paramArrayOfInt)
  {
    super(paramProperty, null);
    setIntValues(paramArrayOfInt);
    if ((paramProperty instanceof IntProperty))
      this.mIntProperty = ((IntProperty)this.mProperty);
  }

  void calculateValue(float paramFloat)
  {
    this.mIntAnimatedValue = this.mIntKeyframeSet.getIntValue(paramFloat);
  }

  public IntPropertyValuesHolder clone()
  {
    IntPropertyValuesHolder localIntPropertyValuesHolder = (IntPropertyValuesHolder)super.clone();
    localIntPropertyValuesHolder.mIntKeyframeSet = ((IntKeyframeSet)localIntPropertyValuesHolder.mKeyframeSet);
    return localIntPropertyValuesHolder;
  }

  Object getAnimatedValue()
  {
    return Integer.valueOf(this.mIntAnimatedValue);
  }

  void setAnimatedValue(Object paramObject)
  {
    if (this.mIntProperty != null)
      this.mIntProperty.setValue(paramObject, this.mIntAnimatedValue);
    while (true)
    {
      return;
      if (this.mProperty != null)
      {
        this.mProperty.set(paramObject, Integer.valueOf(this.mIntAnimatedValue));
        continue;
      }
      if (this.mSetter == null)
        continue;
      try
      {
        this.mTmpValueArray[0] = Integer.valueOf(this.mIntAnimatedValue);
        this.mSetter.invoke(paramObject, this.mTmpValueArray);
      }
      catch (InvocationTargetException localInvocationTargetException)
      {
        Log.e("PropertyValuesHolder", localInvocationTargetException.toString());
      }
      catch (IllegalAccessException localIllegalAccessException)
      {
        Log.e("PropertyValuesHolder", localIllegalAccessException.toString());
      }
    }
  }

  public void setIntValues(int[] paramArrayOfInt)
  {
    super.setIntValues(paramArrayOfInt);
    this.mIntKeyframeSet = ((IntKeyframeSet)this.mKeyframeSet);
  }

  void setupSetter(Class paramClass)
  {
    if (this.mProperty != null);
    while (true)
    {
      return;
      super.setupSetter(paramClass);
    }
  }
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     net.photopay.nineoldandroids.animation.PropertyValuesHolder.IntPropertyValuesHolder
 * JD-Core Version:    0.6.0
 */