package android.support.v8.renderscript;

public class Script$FieldBase
{
  protected Allocation mAllocation;
  protected Element mElement;

  public Allocation getAllocation()
  {
    return this.mAllocation;
  }

  public Element getElement()
  {
    return this.mElement;
  }

  public Type getType()
  {
    return this.mAllocation.getType();
  }

  protected void init(RenderScript paramRenderScript, int paramInt)
  {
    this.mAllocation = Allocation.createSized(paramRenderScript, this.mElement, paramInt, 1);
  }

  protected void init(RenderScript paramRenderScript, int paramInt1, int paramInt2)
  {
    this.mAllocation = Allocation.createSized(paramRenderScript, this.mElement, paramInt1, paramInt2 | 0x1);
  }

  public void updateAllocation()
  {
  }
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     android.support.v8.renderscript.Script.FieldBase
 * JD-Core Version:    0.6.0
 */