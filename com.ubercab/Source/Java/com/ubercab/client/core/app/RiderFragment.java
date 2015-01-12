package com.ubercab.client.core.app;

import com.ubercab.library.app.UberFragment;

public abstract class RiderFragment extends UberFragment
{
  protected final RiderActivity getRiderActivity()
  {
    return (RiderActivity)getActivity();
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.client.core.app.RiderFragment
 * JD-Core Version:    0.6.2
 */