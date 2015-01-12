package uk.co.chrisjenx.calligraphy;

import android.content.Context;
import android.content.ContextWrapper;
import android.view.LayoutInflater;

public class CalligraphyContextWrapper extends ContextWrapper
{
  private final int mAttributeId;
  private LayoutInflater mInflater;

  public CalligraphyContextWrapper(Context paramContext)
  {
    super(paramContext);
    this.mAttributeId = CalligraphyConfig.get().getAttrId();
  }

  public CalligraphyContextWrapper(Context paramContext, int paramInt)
  {
    super(paramContext);
    this.mAttributeId = paramInt;
  }

  public Object getSystemService(String paramString)
  {
    if ("layout_inflater".equals(paramString))
    {
      if (this.mInflater == null)
        this.mInflater = new CalligraphyLayoutInflater(LayoutInflater.from(getBaseContext()), this, this.mAttributeId);
      return this.mInflater;
    }
    return super.getSystemService(paramString);
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper
 * JD-Core Version:    0.6.2
 */