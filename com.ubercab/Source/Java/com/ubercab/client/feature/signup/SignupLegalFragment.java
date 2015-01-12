package com.ubercab.client.feature.signup;

import com.ubercab.client.core.ui.SimpleListItem;
import com.ubercab.client.feature.legal.LegalFragment;
import java.util.Arrays;
import java.util.List;

public class SignupLegalFragment extends LegalFragment
{
  public static SignupLegalFragment newInstance()
  {
    return new SignupLegalFragment();
  }

  protected List<SimpleListItem> getListItems()
  {
    SimpleListItem[] arrayOfSimpleListItem = new SimpleListItem[2];
    arrayOfSimpleListItem[0] = new SimpleListItem(1, getString(2131559108));
    arrayOfSimpleListItem[1] = new SimpleListItem(2, getString(2131559012));
    return Arrays.asList(arrayOfSimpleListItem);
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.client.feature.signup.SignupLegalFragment
 * JD-Core Version:    0.6.2
 */