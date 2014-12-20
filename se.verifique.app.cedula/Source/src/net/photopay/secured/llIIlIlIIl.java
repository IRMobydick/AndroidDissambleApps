package net.photopay.secured;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import net.photopay.util.Log;

public final class llIIlIlIIl
  implements SensorEventListener
{
  private static float IlIllIlIIl = 0.47F;
  private static float IllIIIllII = 0.2F;
  private static float llIIIlllll = 0.66F;
  private int lIIIIIllll;
  private long jdField_llIIlIlIIl_of_type_Long = -1L;
  private Sensor jdField_llIIlIlIIl_of_type_AndroidHardwareSensor;
  private SensorManager jdField_llIIlIlIIl_of_type_AndroidHardwareSensorManager;
  private IllIIIllII jdField_llIIlIlIIl_of_type_NetPhotopaySecuredIllIIIllII = null;
  private llIIIlllll jdField_llIIlIlIIl_of_type_NetPhotopaySecuredLlIIIlllll = null;
  private volatile boolean lllIIlIIlI = true;

  public llIIlIlIIl(Context paramContext, llIIIlllll paramllIIIlllll)
  {
    this.jdField_llIIlIlIIl_of_type_AndroidHardwareSensorManager = ((SensorManager)paramContext.getSystemService("sensor"));
    this.jdField_llIIlIlIIl_of_type_NetPhotopaySecuredLlIIIlllll = paramllIIIlllll;
    this.jdField_llIIlIlIIl_of_type_AndroidHardwareSensor = this.jdField_llIIlIlIIl_of_type_AndroidHardwareSensorManager.getDefaultSensor(1);
    this.lIIIIIllll = (1000 * Math.round(83.333336F));
  }

  private float llIIlIlIIl()
  {
    float f1 = this.jdField_llIIlIlIIl_of_type_NetPhotopaySecuredLlIIIlllll.getX();
    float f2 = this.jdField_llIIlIlIIl_of_type_NetPhotopaySecuredLlIIIlllll.getY();
    float f3 = this.jdField_llIIlIlIIl_of_type_NetPhotopaySecuredLlIIIlllll.getZ();
    return (float)Math.sqrt(f1 * f1 + f2 * f2 + f3 * f3);
  }

  public final boolean IlIllIlIIl()
  {
    return this.lllIIlIIlI;
  }

  public final void IllIIIIllI()
  {
    if (!this.jdField_llIIlIlIIl_of_type_AndroidHardwareSensorManager.registerListener(this, this.jdField_llIIlIlIIl_of_type_AndroidHardwareSensor, this.lIIIIIllll))
    {
      Object[] arrayOfObject = new Object[1];
      arrayOfObject[0] = Integer.valueOf(this.lIIIIIllll);
      Log.w(this, "unable to register accelerometer sensor with sample period {} microseconds. Trying SENSOR_DELAY_NORMAL...", arrayOfObject);
      if (!this.jdField_llIIlIlIIl_of_type_AndroidHardwareSensorManager.registerListener(this, this.jdField_llIIlIlIIl_of_type_AndroidHardwareSensor, 3))
      {
        Log.w(this, "unable to register accelerometer sensor at all", new Object[0]);
        this.lllIIlIIlI = false;
        this.jdField_llIIlIlIIl_of_type_NetPhotopaySecuredIllIIIllII.llIIlIlIIl();
      }
    }
  }

  public final void lIlIIIIlIl()
  {
    this.jdField_llIIlIlIIl_of_type_AndroidHardwareSensorManager.unregisterListener(this);
  }

  public final void llIIlIlIIl(IllIIIllII paramIllIIIllII)
  {
    this.jdField_llIIlIlIIl_of_type_NetPhotopaySecuredIllIIIllII = paramIllIIIllII;
  }

  public final void onAccuracyChanged(Sensor paramSensor, int paramInt)
  {
  }

  public final void onSensorChanged(SensorEvent paramSensorEvent)
  {
    boolean bool = true;
    if (this.jdField_llIIlIlIIl_of_type_Long >= 0L)
    {
      long l = System.currentTimeMillis() - this.jdField_llIIlIlIIl_of_type_Long;
      this.lIIIIIllll = (int)(this.lIIIIIllll * llIIIlllll + (float)(l * 1000L) * (1.0F - llIIIlllll));
      this.jdField_llIIlIlIIl_of_type_NetPhotopaySecuredLlIIIlllll.llIIlIlIIl(this.lIIIIIllll / 1000.0F / 1000.0F);
    }
    this.jdField_llIIlIlIIl_of_type_NetPhotopaySecuredLlIIIlllll.llIIlIlIIl(paramSensorEvent.values[0], paramSensorEvent.values[bool], paramSensorEvent.values[2]);
    int i;
    if ((!this.lllIIlIIlI) && (llIIlIlIIl() > IlIllIlIIl))
    {
      i = bool;
      if (i == 0)
        break label147;
      this.lllIIlIIlI = bool;
      this.jdField_llIIlIlIIl_of_type_NetPhotopaySecuredIllIIIllII.IlIllIlIIl();
    }
    label147: label189: 
    while (true)
    {
      this.jdField_llIIlIlIIl_of_type_Long = System.currentTimeMillis();
      return;
      i = 0;
      break;
      if ((this.lllIIlIIlI) && (llIIlIlIIl() < IllIIIllII));
      while (true)
      {
        if (!bool)
          break label189;
        this.lllIIlIIlI = false;
        this.jdField_llIIlIlIIl_of_type_NetPhotopaySecuredIllIIIllII.llIIlIlIIl();
        break;
        bool = false;
      }
    }
  }
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     net.photopay.secured.llIIlIlIIl
 * JD-Core Version:    0.6.0
 */