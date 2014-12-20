package net.photopay.nineoldandroids.animation;

import android.util.Log;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import net.photopay.nineoldandroids.util.FloatProperty;
import net.photopay.nineoldandroids.util.Property;

class PropertyValuesHolder$FloatPropertyValuesHolder extends PropertyValuesHolder
{
  float mFloatAnimatedValue;
  FloatKeyframeSet mFloatKeyframeSet;
  private FloatProperty mFloatProperty;

  public PropertyValuesHolder$FloatPropertyValuesHolder(String paramString, FloatKeyframeSet paramFloatKeyframeSet)
  {
    super(paramString, null);
    this.mValueType = Float.TYPE;
    this.mKeyframeSet = paramFloatKeyframeSet;
    this.mFloatKeyframeSet = ((FloatKeyframeSet)this.mKeyframeSet);
  }

  public PropertyValuesHolder$FloatPropertyValuesHolder(String paramString, float[] paramArrayOfFloat)
  {
    super(paramString, null);
    setFloatValues(paramArrayOfFloat);
  }

  public PropertyValuesHolder$FloatPropertyValuesHolder(Property paramProperty, FloatKeyframeSet paramFloatKeyframeSet)
  {
    super(paramProperty, null);
    this.mValueType = Float.TYPE;
    this.mKeyframeSet = paramFloatKeyframeSet;
    this.mFloatKeyframeSet = ((FloatKeyframeSet)this.mKeyframeSet);
    if ((paramProperty instanceof FloatProperty))
      this.mFloatProperty = ((FloatProperty)this.mProperty);
  }

  public PropertyValuesHolder$FloatPropertyValuesHolder(Property paramProperty, float[] paramArrayOfFloat)
  {
    super(paramProperty, null);
    setFloatValues(paramArrayOfFloat);
    if ((paramProperty instanceof FloatProperty))
      this.mFloatProperty = ((FloatProperty)this.mProperty);
  }

  void calculateValue(float paramFloat)
  {
    this.mFloatAnimatedValue = this.mFloatKeyframeSet.getFloatValue(paramFloat);
  }

  public FloatPropertyValuesHolder clone()
  {
    FloatPropertyValuesHolder localFloatPropertyValuesHolder = (FloatPropertyValuesHolder)super.clone();
    localFloatPropertyValuesHolder.mFloatKeyframeSet = ((FloatKeyframeSet)localFloatPropertyValuesHolder.mKeyframeSet);
    return localFloatPropertyValuesHolder;
  }

  Object getAnimatedValue()
  {
    return Float.valueOf(this.mFloatAnimatedValue);
  }

  void setAnimatedValue(Object paramObject)
  {
    if (this.mFloatProperty != null)
      this.mFloatProperty.setValue(paramObject, this.mFloatAnimatedValue);
    while (true)
    {
      return;
      if (this.mProperty != null)
      {
        this.mProperty.set(paramObject, Float.valueOf(this.mFloatAnimatedValue));
        continue;
      }
      if (this.mSetter == null)
        continue;
      try
      {
        this.mTmpValueArray[0] = Float.valueOf(this.mFloatAnimatedValue);
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

  public void setFloatValues(float[] paramArrayOfFloat)
  {
    super.setFloatValues(paramArrayOfFloat);
    this.mFloatKeyframeSet = ((FloatKeyframeSet)this.mKeyframeSet);
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
 * Qualified Name:     net.photopay.nineoldandroids.animation.PropertyValuesHolder.FloatPropertyValuesHolder
 * JD-Core Version:    0.6.0
 */