package com.baidu.location;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;

class aw
{
  private static aw a = null;
  private a jdField_do = null;
  private boolean jdField_for = false;
  private String jdField_if = null;

  public static aw jdField_do()
  {
    if (a == null)
      a = new aw();
    return a;
  }

  public String a()
  {
    return this.jdField_if;
  }

  public void jdField_for()
  {
    f.getServiceContext().registerReceiver(this.jdField_do, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
  }

  public void jdField_if()
  {
    if (this.jdField_do != null)
      f.getServiceContext().unregisterReceiver(this.jdField_do);
    this.jdField_do = null;
  }

  public boolean jdMethod_int()
  {
    return this.jdField_for;
  }

  public class a extends BroadcastReceiver
  {
    public a()
    {
    }

    public void onReceive(Context paramContext, Intent paramIntent)
    {
      String str = paramIntent.getAction();
      int j;
      while (true)
      {
        try
        {
          if (!str.equals("android.intent.action.BATTERY_CHANGED"))
            return;
          aw.a(aw.this, false);
          int i = paramIntent.getIntExtra("status", 0);
          j = paramIntent.getIntExtra("plugged", 0);
          switch (i)
          {
          default:
            aw.a(aw.this, null);
            break label186;
            if (!aw.a(aw.this))
              break;
            ai.bA().bz();
            return;
          case 2:
            aw.a(aw.this, "4");
          case 3:
          case 4:
          }
        }
        catch (Exception localException)
        {
          aw.a(aw.this, null);
          return;
        }
        aw.a(aw.this, "3");
        break label186;
        aw.a(aw.this, "6");
        aw.a(aw.this, true);
        continue;
        aw.a(aw.this, "5");
        aw.a(aw.this, true);
      }
      ai.bA().bB();
      return;
      label186: switch (j)
      {
      default:
      case 1:
      case 2:
      }
    }
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.baidu.location.aw
 * JD-Core Version:    0.6.2
 */