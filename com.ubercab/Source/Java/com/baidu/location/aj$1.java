package com.baidu.location;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;

class aj$1
  implements SensorEventListener
{
  aj$1(aj paramaj)
  {
  }

  public void onAccuracyChanged(Sensor paramSensor, int paramInt)
  {
  }

  public void onSensorChanged(SensorEvent paramSensorEvent)
  {
    switch (paramSensorEvent.sensor.getType())
    {
    default:
    case 1:
    }
    double d;
    do
    {
      do
      {
        float[] arrayOfFloat2;
        do
        {
          return;
          float[] arrayOfFloat1 = (float[])paramSensorEvent.values.clone();
          aj.jdMethod_if(this.a, (float[])arrayOfFloat1.clone());
          arrayOfFloat2 = aj.jdMethod_if(this.a, arrayOfFloat1[0], arrayOfFloat1[1], arrayOfFloat1[2]);
        }
        while (aj.jdMethod_do(this.a) < 20);
        d = arrayOfFloat2[0] * arrayOfFloat2[0] + arrayOfFloat2[1] * arrayOfFloat2[1] + arrayOfFloat2[2] * arrayOfFloat2[2];
        if (aj.jdMethod_for(this.a) != 0)
          break;
      }
      while (d <= 4.0D);
      aj.jdMethod_if(this.a, 1);
      return;
    }
    while (d >= 0.009999999776482582D);
    aj.jdMethod_if(this.a, 0);
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.baidu.location.aj.1
 * JD-Core Version:    0.6.2
 */