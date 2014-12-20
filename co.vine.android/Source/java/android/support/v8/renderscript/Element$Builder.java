package android.support.v8.renderscript;

public class Element$Builder
{
  int[] mArraySizes;
  int mCount;
  String[] mElementNames;
  Element[] mElements;
  RenderScript mRS;
  int mSkipPadding;
  ElementThunker.BuilderThunker mT;

  public Element$Builder(RenderScript paramRenderScript)
  {
    if (RenderScript.isNative)
    {
      ((RenderScriptThunker)paramRenderScript);
      this.mT = new ElementThunker.BuilderThunker(paramRenderScript);
    }
    this.mRS = paramRenderScript;
    this.mCount = 0;
    this.mElements = new Element[8];
    this.mElementNames = new String[8];
    this.mArraySizes = new int[8];
  }

  public Builder add(Element paramElement, String paramString)
  {
    return add(paramElement, paramString, 1);
  }

  public Builder add(Element paramElement, String paramString, int paramInt)
  {
    if (this.mT != null)
      this.mT.add(paramElement, paramString, paramInt);
    while (true)
    {
      return this;
      if (paramInt < 1)
        throw new RSIllegalArgumentException("Array size cannot be less than 1.");
      if ((this.mSkipPadding == 0) || (!paramString.startsWith("#padding_")))
        break;
      this.mSkipPadding = 0;
    }
    if (paramElement.mVectorSize == 3);
    for (this.mSkipPadding = 1; ; this.mSkipPadding = 0)
    {
      if (this.mCount == this.mElements.length)
      {
        Element[] arrayOfElement = new Element[8 + this.mCount];
        String[] arrayOfString = new String[8 + this.mCount];
        int[] arrayOfInt = new int[8 + this.mCount];
        System.arraycopy(this.mElements, 0, arrayOfElement, 0, this.mCount);
        System.arraycopy(this.mElementNames, 0, arrayOfString, 0, this.mCount);
        System.arraycopy(this.mArraySizes, 0, arrayOfInt, 0, this.mCount);
        this.mElements = arrayOfElement;
        this.mElementNames = arrayOfString;
        this.mArraySizes = arrayOfInt;
      }
      this.mElements[this.mCount] = paramElement;
      this.mElementNames[this.mCount] = paramString;
      this.mArraySizes[this.mCount] = paramInt;
      this.mCount = (1 + this.mCount);
      break;
    }
  }

  public Element create()
  {
    if (this.mT != null);
    Element[] arrayOfElement;
    String[] arrayOfString;
    int[] arrayOfInt1;
    int[] arrayOfInt2;
    for (Element localElement = this.mT.create(this.mRS); ; localElement = new Element(this.mRS.nElementCreate2(arrayOfInt2, arrayOfString, arrayOfInt1), this.mRS, arrayOfElement, arrayOfString, arrayOfInt1))
    {
      return localElement;
      this.mRS.validate();
      arrayOfElement = new Element[this.mCount];
      arrayOfString = new String[this.mCount];
      arrayOfInt1 = new int[this.mCount];
      System.arraycopy(this.mElements, 0, arrayOfElement, 0, this.mCount);
      System.arraycopy(this.mElementNames, 0, arrayOfString, 0, this.mCount);
      System.arraycopy(this.mArraySizes, 0, arrayOfInt1, 0, this.mCount);
      arrayOfInt2 = new int[arrayOfElement.length];
      for (int i = 0; i < arrayOfElement.length; i++)
        arrayOfInt2[i] = arrayOfElement[i].getID(this.mRS);
    }
  }
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     android.support.v8.renderscript.Element.Builder
 * JD-Core Version:    0.6.0
 */