package uk.co.chrisjenx.calligraphy;

import android.content.Context;
import android.view.LayoutInflater;

class CalligraphyLayoutInflater extends LayoutInflater
{
  private final int mAttributeId;

  protected CalligraphyLayoutInflater(Context paramContext, int paramInt)
  {
    super(paramContext);
    this.mAttributeId = paramInt;
    setUpLayoutFactory();
  }

  protected CalligraphyLayoutInflater(LayoutInflater paramLayoutInflater, Context paramContext, int paramInt)
  {
    super(paramLayoutInflater, paramContext);
    this.mAttributeId = paramInt;
    setUpLayoutFactory();
  }

  private void setUpLayoutFactory()
  {
    if (!(getFactory() instanceof CalligraphyFactory))
      setFactory(new CalligraphyFactory(getFactory(), this.mAttributeId));
  }

  public LayoutInflater cloneInContext(Context paramContext)
  {
    return new CalligraphyLayoutInflater(this, paramContext, this.mAttributeId);
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     uk.co.chrisjenx.calligraphy.CalligraphyLayoutInflater
 * JD-Core Version:    0.6.2
 */