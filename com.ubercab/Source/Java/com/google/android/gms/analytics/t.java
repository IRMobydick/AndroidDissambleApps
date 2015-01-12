package com.google.android.gms.analytics;

import java.util.SortedSet;
import java.util.TreeSet;

class t
{
  private static final t ze = new t();
  private SortedSet<a> zb = new TreeSet();
  private StringBuilder zc = new StringBuilder();
  private boolean zd = false;

  public static t ep()
  {
    return ze;
  }

  public void B(boolean paramBoolean)
  {
    try
    {
      this.zd = paramBoolean;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public void a(a parama)
  {
    try
    {
      if (!this.zd)
      {
        this.zb.add(parama);
        this.zc.append("ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789-_".charAt(parama.ordinal()));
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public String eq()
  {
    try
    {
      StringBuilder localStringBuilder = new StringBuilder();
      int i = 6;
      int j = 0;
      while (this.zb.size() > 0)
      {
        a locala = (a)this.zb.first();
        this.zb.remove(locala);
        int k = locala.ordinal();
        while (k >= i)
        {
          localStringBuilder.append("ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789-_".charAt(j));
          i += 6;
          j = 0;
        }
        j += (1 << locala.ordinal() % 6);
      }
      if ((j > 0) || (localStringBuilder.length() == 0))
        localStringBuilder.append("ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789-_".charAt(j));
      this.zb.clear();
      String str = localStringBuilder.toString();
      return str;
    }
    finally
    {
    }
  }

  public String er()
  {
    try
    {
      if (this.zc.length() > 0)
        this.zc.insert(0, ".");
      String str = this.zc.toString();
      this.zc = new StringBuilder();
      return str;
    }
    finally
    {
    }
  }

  public static enum a
  {
    static
    {
      zA = new a("BLANK_21", 21);
      zB = new a("BLANK_22", 22);
      zC = new a("BLANK_23", 23);
      zD = new a("BLANK_24", 24);
      zE = new a("BLANK_25", 25);
      zF = new a("BLANK_26", 26);
      zG = new a("BLANK_27", 27);
      zH = new a("BLANK_28", 28);
      zI = new a("BLANK_29", 29);
      zJ = new a("SET_EXCEPTION_PARSER", 30);
      zK = new a("GET_EXCEPTION_PARSER", 31);
      zL = new a("CONSTRUCT_TRANSACTION", 32);
      zM = new a("CONSTRUCT_EXCEPTION", 33);
      zN = new a("CONSTRUCT_RAW_EXCEPTION", 34);
      zO = new a("CONSTRUCT_TIMING", 35);
      zP = new a("CONSTRUCT_SOCIAL", 36);
      zQ = new a("BLANK_37", 37);
      zR = new a("BLANK_38", 38);
      zS = new a("GET_TRACKER", 39);
      zT = new a("GET_DEFAULT_TRACKER", 40);
      zU = new a("SET_DEFAULT_TRACKER", 41);
      zV = new a("SET_APP_OPT_OUT", 42);
      zW = new a("GET_APP_OPT_OUT", 43);
      zX = new a("DISPATCH", 44);
      zY = new a("SET_DISPATCH_PERIOD", 45);
      zZ = new a("BLANK_46", 46);
      Aa = new a("REPORT_UNCAUGHT_EXCEPTIONS", 47);
      Ab = new a("SET_AUTO_ACTIVITY_TRACKING", 48);
      Ac = new a("SET_SESSION_TIMEOUT", 49);
      Ad = new a("CONSTRUCT_EVENT", 50);
      Ae = new a("CONSTRUCT_ITEM", 51);
      Af = new a("BLANK_52", 52);
      Ag = new a("BLANK_53", 53);
      Ah = new a("SET_DRY_RUN", 54);
      Ai = new a("GET_DRY_RUN", 55);
      Aj = new a("SET_LOGGER", 56);
      Ak = new a("SET_FORCE_LOCAL_DISPATCH", 57);
      Al = new a("GET_TRACKER_NAME", 58);
      Am = new a("CLOSE_TRACKER", 59);
      An = new a("EASY_TRACKER_ACTIVITY_START", 60);
      Ao = new a("EASY_TRACKER_ACTIVITY_STOP", 61);
      Ap = new a("CONSTRUCT_APP_VIEW", 62);
      a[] arrayOfa = new a[63];
      arrayOfa[0] = zf;
      arrayOfa[1] = zg;
      arrayOfa[2] = zh;
      arrayOfa[3] = zi;
      arrayOfa[4] = zj;
      arrayOfa[5] = zk;
      arrayOfa[6] = zl;
      arrayOfa[7] = zm;
      arrayOfa[8] = zn;
      arrayOfa[9] = zo;
      arrayOfa[10] = zp;
      arrayOfa[11] = zq;
      arrayOfa[12] = zr;
      arrayOfa[13] = zs;
      arrayOfa[14] = zt;
      arrayOfa[15] = zu;
      arrayOfa[16] = zv;
      arrayOfa[17] = zw;
      arrayOfa[18] = zx;
      arrayOfa[19] = zy;
      arrayOfa[20] = zz;
      arrayOfa[21] = zA;
      arrayOfa[22] = zB;
      arrayOfa[23] = zC;
      arrayOfa[24] = zD;
      arrayOfa[25] = zE;
      arrayOfa[26] = zF;
      arrayOfa[27] = zG;
      arrayOfa[28] = zH;
      arrayOfa[29] = zI;
      arrayOfa[30] = zJ;
      arrayOfa[31] = zK;
      arrayOfa[32] = zL;
      arrayOfa[33] = zM;
      arrayOfa[34] = zN;
      arrayOfa[35] = zO;
      arrayOfa[36] = zP;
      arrayOfa[37] = zQ;
      arrayOfa[38] = zR;
      arrayOfa[39] = zS;
      arrayOfa[40] = zT;
      arrayOfa[41] = zU;
      arrayOfa[42] = zV;
      arrayOfa[43] = zW;
      arrayOfa[44] = zX;
      arrayOfa[45] = zY;
      arrayOfa[46] = zZ;
      arrayOfa[47] = Aa;
      arrayOfa[48] = Ab;
      arrayOfa[49] = Ac;
      arrayOfa[50] = Ad;
      arrayOfa[51] = Ae;
      arrayOfa[52] = Af;
      arrayOfa[53] = Ag;
      arrayOfa[54] = Ah;
      arrayOfa[55] = Ai;
      arrayOfa[56] = Aj;
      arrayOfa[57] = Ak;
      arrayOfa[58] = Al;
      arrayOfa[59] = Am;
      arrayOfa[60] = An;
      arrayOfa[61] = Ao;
      arrayOfa[62] = Ap;
    }
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.google.android.gms.analytics.t
 * JD-Core Version:    0.6.2
 */