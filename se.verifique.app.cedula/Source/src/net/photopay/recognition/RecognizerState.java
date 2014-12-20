package net.photopay.recognition;

public enum RecognizerState
{
  static
  {
    IllIIIIllI = new RecognizerState("WORKING", 3);
    lIlIIIIlIl = new RecognizerState("DONE", 4);
    RecognizerState[] arrayOfRecognizerState = new RecognizerState[5];
    arrayOfRecognizerState[0] = IlIllIlIIl;
    arrayOfRecognizerState[1] = IllIIIllII;
    arrayOfRecognizerState[2] = llIIIlllll;
    arrayOfRecognizerState[3] = IllIIIIllI;
    arrayOfRecognizerState[4] = lIlIIIIlIl;
    llIIlIlIIl = arrayOfRecognizerState;
  }
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     net.photopay.recognition.RecognizerState
 * JD-Core Version:    0.6.0
 */