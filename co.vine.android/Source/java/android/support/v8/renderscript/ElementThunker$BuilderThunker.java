package android.support.v8.renderscript;

import android.renderscript.Element.Builder;

class ElementThunker$BuilderThunker
{
  Element.Builder mN;

  public ElementThunker$BuilderThunker(RenderScript paramRenderScript)
  {
    this.mN = new Element.Builder(((RenderScriptThunker)paramRenderScript).mN);
  }

  public void add(Element paramElement, String paramString, int paramInt)
  {
    ElementThunker localElementThunker = (ElementThunker)paramElement;
    this.mN.add(localElementThunker.mN, paramString, paramInt);
  }

  public Element create(RenderScript paramRenderScript)
  {
    return new ElementThunker(paramRenderScript, this.mN.create());
  }
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     android.support.v8.renderscript.ElementThunker.BuilderThunker
 * JD-Core Version:    0.6.0
 */