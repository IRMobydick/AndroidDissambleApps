package com.baidu.location;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;

class af
  implements ax, n, SensorEventListener
{
  private static float g5;
  private static af g9;
  private boolean g3;
  float[] g4;
  SensorManager g6;
  float[] g7 = new float[9];
  float[] g8;

  public static af bw()
  {
    if (g9 == null)
      g9 = new af();
    return g9;
  }

  public float bu()
  {
    return g5;
  }

  public void bv()
  {
    try
    {
      if (this.g6 != null)
      {
        this.g6.unregisterListener(this);
        this.g6 = null;
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public void bx()
  {
    try
    {
      if (this.g6 == null)
        this.g6 = ((SensorManager)f.getServiceContext().getSystemService("sensor"));
      this.g6.registerListener(this, this.g6.getDefaultSensor(1), 3);
      this.g6.registerListener(this, this.g6.getDefaultSensor(2), 3);
      return;
    }
    finally
    {
    }
  }

  public boolean by()
  {
    return this.g3;
  }

  public void onAccuracyChanged(Sensor paramSensor, int paramInt)
  {
  }

  public void onSensorChanged(SensorEvent paramSensorEvent)
  {
    switch (paramSensorEvent.sensor.getType())
    {
    default:
      if ((this.g4 != null) && (this.g8 != null))
      {
        float[] arrayOfFloat1 = new float[9];
        if (SensorManager.getRotationMatrix(arrayOfFloat1, null, this.g4, this.g8))
        {
          float[] arrayOfFloat2 = new float[3];
          SensorManager.getOrientation(arrayOfFloat1, arrayOfFloat2);
          g5 = (float)Math.toDegrees(arrayOfFloat2[0]);
          if (g5 < 0.0F)
            break label130;
        }
      }
      break;
    case 1:
    case 2:
    }
    label130: for (double d = g5; ; d = 360.0F + g5)
    {
      g5 = (float)Math.floor(d);
      return;
      this.g4 = paramSensorEvent.values;
      break;
      this.g8 = paramSensorEvent.values;
      break;
    }
  }

  public void jdMethod_try(boolean paramBoolean)
  {
    this.g3 = paramBoolean;
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.baidu.location.af
 * JD-Core Version:    0.6.2
 */