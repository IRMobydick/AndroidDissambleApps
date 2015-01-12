package com.baidu.location;

import android.os.Bundle;
import android.os.Message;
import android.os.Messenger;
import java.util.ArrayList;
import java.util.List;
import org.apache.http.message.BasicNameValuePair;

class ak
{
  private static ak jdField_goto;
  private boolean a = false;
  private String jdField_byte = null;
  private String jdField_case = null;
  private long jdField_char = 0L;
  private String jdField_do = null;
  private String jdField_else = null;
  private long jdField_for = 0L;
  private long jdField_if = 0L;
  private String jdField_int = null;
  public String jdField_new = null;
  private a jdField_try = null;

  public static ak a()
  {
    if (jdField_goto == null)
      jdField_goto = new ak();
    return jdField_goto;
  }

  public void a(Message paramMessage)
  {
    if ((this.jdField_case == null) || (this.jdField_do == null))
    {
      this.jdField_case = this.jdField_int;
      this.jdField_do = this.jdField_byte;
    }
    this.jdField_try.jdField_try(paramMessage);
  }

  public void a(String paramString)
  {
    this.jdField_else = paramString;
    this.a = true;
    this.jdField_for = System.currentTimeMillis();
  }

  public void jdField_do()
  {
    this.jdField_case = this.jdField_int;
    this.jdField_do = this.jdField_byte;
    this.jdField_char = System.currentTimeMillis();
  }

  public void jdField_if()
  {
    this.jdField_case = null;
    this.jdField_do = null;
    this.jdField_char = 0L;
  }

  public void jdField_if(String paramString)
  {
    if (this.a)
    {
      this.jdField_int = this.jdField_else;
      this.a = false;
      this.jdField_if = this.jdField_for;
    }
    this.jdField_byte = paramString;
  }

  class a extends s
  {
    String dA = null;
    Messenger dB = null;
    boolean dC = false;

    public a()
    {
      this.cT = new ArrayList();
    }

    void T()
    {
      this.cR = c.jdMethod_try();
      if (ak.a(ak.this) == null)
        ak.jdMethod_if(ak.this, Jni.i("none"));
      this.cT.add(new BasicNameValuePair("erpt[0]", ak.a(ak.this)));
      if (ak.jdMethod_if(ak.this) == null)
        ak.a(ak.this, "none");
      this.cT.add(new BasicNameValuePair("erpt[1]", Jni.i(ak.jdMethod_if(ak.this))));
      if (this.dA == null)
        this.dA = "none";
      this.cT.add(new BasicNameValuePair("erpt[2]", Jni.i(this.dA)));
      StringBuffer localStringBuffer = new StringBuffer(512);
      localStringBuffer.append("&t1=");
      localStringBuffer.append(ak.jdMethod_do(ak.this));
      localStringBuffer.append("&t2=");
      localStringBuffer.append(ak.jdMethod_for(ak.this));
      String str = x.a4().aY();
      if (str != null)
        localStringBuffer.append(str);
      this.cT.add(new BasicNameValuePair("erpt[3]", Jni.i(localStringBuffer.toString())));
      ak.jdMethod_if(ak.this, null);
      ak.a(ak.this, null);
      ak.a(ak.this, 0L);
    }

    void jdMethod_do(boolean paramBoolean)
    {
      if (this.cT != null)
        this.cT.clear();
      Message localMessage;
      if (paramBoolean)
        localMessage = Message.obtain(null, 205);
      try
      {
        while (true)
        {
          this.dB.send(localMessage);
          label36: this.dC = false;
          return;
          localMessage = Message.obtain(null, 204);
        }
      }
      catch (Exception localException)
      {
        break label36;
      }
    }

    public void jdMethod_try(Message paramMessage)
    {
      this.dB = paramMessage.replyTo;
      Message localMessage;
      if (this.dC)
        localMessage = Message.obtain(null, 204);
      try
      {
        this.dB.send(localMessage);
        return;
        this.dC = true;
        this.dA = paramMessage.getData().getString("errInfo");
        N();
        return;
      }
      catch (Exception localException)
      {
      }
    }
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.baidu.location.ak
 * JD-Core Version:    0.6.2
 */