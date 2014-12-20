package net.photopay.settings;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

final class IlIllIlIIl
{
  public static final Set IIlIIIllIl;
  public static final Set IlIllIlllI;
  public static final Set lIIIIIllll;
  public static final Set lllIIIlIlI;

  static
  {
    HashSet localHashSet1 = new HashSet();
    localHashSet1.add("ausslip");
    localHashSet1.add("beslip");
    localHashSet1.add("croslip");
    localHashSet1.add("deslip");
    localHashSet1.add("huslip");
    localHashSet1.add("nlocrline");
    localHashSet1.add("nlslip");
    localHashSet1.add("ocronly");
    localHashSet1.add("serbbill");
    localHashSet1.add("sloslip");
    localHashSet1.add("ukgiro");
    IIlIIIllIl = Collections.unmodifiableSet(localHashSet1);
    HashSet localHashSet2 = new HashSet();
    localHashSet2.add("aztec");
    localHashSet2.add("code128");
    localHashSet2.add("code39");
    localHashSet2.add("datamatrix");
    localHashSet2.add("ean13");
    localHashSet2.add("ean8");
    localHashSet2.add("itf");
    localHashSet2.add("pdf417");
    localHashSet2.add("qrcode");
    localHashSet2.add("upca");
    localHashSet2.add("upce");
    lIIIIIllll = Collections.unmodifiableSet(localHashSet2);
    HashSet localHashSet3 = new HashSet();
    localHashSet3.addAll(lIIIIIllll);
    localHashSet3.add("ausqrcode");
    localHashSet3.add("cropdf417");
    localHashSet3.add("croqrcode");
    localHashSet3.add("deqrcode");
    localHashSet3.add("paybull");
    localHashSet3.add("usdl");
    lllIIIlIlI = Collections.unmodifiableSet(localHashSet3);
    HashSet localHashSet4 = new HashSet();
    localHashSet4.addAll(IIlIIIllIl);
    localHashSet4.addAll(lllIIIlIlI);
    IlIllIlllI = localHashSet4;
  }
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     net.photopay.settings.IlIllIlIIl
 * JD-Core Version:    0.6.0
 */