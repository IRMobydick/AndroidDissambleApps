package android.support.v8.renderscript;

public enum Sampler$Value
{
  int mID;

  static
  {
    LINEAR = new Value("LINEAR", 1, 1);
    LINEAR_MIP_LINEAR = new Value("LINEAR_MIP_LINEAR", 2, 2);
    LINEAR_MIP_NEAREST = new Value("LINEAR_MIP_NEAREST", 3, 5);
    WRAP = new Value("WRAP", 4, 3);
    CLAMP = new Value("CLAMP", 5, 4);
    MIRRORED_REPEAT = new Value("MIRRORED_REPEAT", 6, 6);
    Value[] arrayOfValue = new Value[7];
    arrayOfValue[0] = NEAREST;
    arrayOfValue[1] = LINEAR;
    arrayOfValue[2] = LINEAR_MIP_LINEAR;
    arrayOfValue[3] = LINEAR_MIP_NEAREST;
    arrayOfValue[4] = WRAP;
    arrayOfValue[5] = CLAMP;
    arrayOfValue[6] = MIRRORED_REPEAT;
    $VALUES = arrayOfValue;
  }

  private Sampler$Value(int paramInt)
  {
    this.mID = paramInt;
  }
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     android.support.v8.renderscript.Sampler.Value
 * JD-Core Version:    0.6.0
 */