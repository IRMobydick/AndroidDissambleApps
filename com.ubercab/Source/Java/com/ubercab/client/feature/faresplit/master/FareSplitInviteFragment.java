package com.ubercab.client.feature.faresplit.master;

import android.app.ActionBar;
import android.app.Activity;
import android.content.res.Resources;
import android.database.Cursor;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import butterknife.ButterKnife;
import butterknife.InjectView;
import com.squareup.otto.Bus;
import com.squareup.otto.Subscribe;
import com.ubercab.client.core.analytics.AnalyticsManager;
import com.ubercab.client.core.analytics.event.FareSplitEvent;
import com.ubercab.client.core.app.RiderFragment;
import com.ubercab.client.core.content.PingProvider;
import com.ubercab.client.core.content.event.PingEvent;
import com.ubercab.client.core.model.Client;
import com.ubercab.client.core.model.FareSplit;
import com.ubercab.client.core.model.Ping;
import com.ubercab.client.core.model.RecentFareSplitter;
import com.ubercab.client.core.network.RiderClient;
import com.ubercab.client.core.network.events.FareSplitInviteResponseEvent;
import com.ubercab.client.core.ui.ChipEditText;
import com.ubercab.client.core.ui.ChipEditText.Chip;
import com.ubercab.client.core.ui.ChipEditText.Listener;
import com.ubercab.client.core.ui.MergedSectionAdapter;
import com.ubercab.client.feature.faresplit.master.event.FareSplitInvitesSentEvent;
import com.ubercab.library.util.KeyboardUtils;
import com.ubercab.library.util.PhoneNumberUtils;
import com.ubercab.ui.UberTextView;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import javax.inject.Inject;

public class FareSplitInviteFragment extends RiderFragment
  implements ChipEditText.Listener, AdapterView.OnItemClickListener
{

  @Inject
  ActionBar mActionBar;
  private FareSplitContactsAdapter mAdapterContacts;
  private MergedSectionAdapter mAdapterMerged;
  private FareSplitRecentAdapter mAdapterRecents;

  @Inject
  AnalyticsManager mAnalyticsManager;

  @Inject
  Bus mBus;
  private FareSplitChipAdapter mChipAdapter;

  @InjectView(2131427454)
  ChipEditText mEditTextInvitees;

  @InjectView(2131427455)
  ListView mListView;
  private MenuItem mMenuItemSend;

  @Inject
  PingProvider mPingProvider;

  @Inject
  RiderClient mRiderClient;

  @InjectView(2131427456)
  UberTextView mTextViewFeeNotice;

  @InjectView(2131427453)
  UberTextView mTextViewLimitReached;

  private void onClickedSend()
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.mEditTextInvitees.getChips().iterator();
    while (localIterator.hasNext())
      localArrayList.add(((ChipEditText.Chip)localIterator.next()).getData().getString("number"));
    KeyboardUtils.hideKeyboard(getActivity(), this.mEditTextInvitees);
    sendFareSplitInviteRequest(localArrayList);
  }

  private void refreshUi(Ping paramPing)
  {
    int i = paramPing.getMaxFareSplits();
    int j = Math.max(1, paramPing.getFareSplit().getClients().size());
    this.mEditTextInvitees.setMaxChips(i - j);
    boolean bool = paramPing.canInviteMoreToFareSplit(1 + this.mEditTextInvitees.getChips().size());
    UberTextView localUberTextView = this.mTextViewLimitReached;
    if (bool);
    for (int k = 8; ; k = 0)
    {
      localUberTextView.setVisibility(k);
      getActivity().invalidateOptionsMenu();
      return;
    }
  }

  private void sendFareSplitInviteRequest(List<String> paramList)
  {
    showLoadingDialogSticky(getString(2131558900), null);
    this.mRiderClient.fareSplitInvite(paramList);
    this.mAnalyticsManager.fareSplitEvent().send(paramList.size());
  }

  public void onChipsChanged(Collection<ChipEditText.Chip> paramCollection)
  {
    this.mAdapterRecents.setChips(paramCollection);
    this.mAdapterContacts.setChips(paramCollection);
    Ping localPing = this.mPingProvider.get();
    if (localPing == null)
      return;
    refreshUi(localPing);
  }

  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setHasOptionsMenu(true);
  }

  public void onCreateOptionsMenu(Menu paramMenu, MenuInflater paramMenuInflater)
  {
    paramMenuInflater.inflate(2131689472, paramMenu);
    this.mMenuItemSend = paramMenu.findItem(2131427934);
    this.mMenuItemSend.setTitle(getString(2131559049));
  }

  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    View localView = paramLayoutInflater.inflate(2130903084, paramViewGroup, false);
    ButterKnife.inject(this, localView);
    return localView;
  }

  public void onDestroyView()
  {
    super.onDestroyView();
    ButterKnife.reset(this);
  }

  @Subscribe
  public void onFareSplitInviteResponse(FareSplitInviteResponseEvent paramFareSplitInviteResponseEvent)
  {
    hideLoadingDialog();
    if (!paramFareSplitInviteResponseEvent.isSuccess())
      return;
    this.mEditTextInvitees.setText("");
    this.mBus.post(new FareSplitInvitesSentEvent());
  }

  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    Object localObject = this.mAdapterMerged.getItem(paramInt);
    String str1;
    if ((localObject instanceof RecentFareSplitter))
    {
      RecentFareSplitter localRecentFareSplitter = (RecentFareSplitter)localObject;
      String str2 = localRecentFareSplitter.getMobileDigits();
      String str3 = localRecentFareSplitter.getMobileCountryIso2();
      boolean bool2 = TextUtils.isEmpty(str2);
      str1 = null;
      if (!bool2)
      {
        boolean bool3 = TextUtils.isEmpty(str3);
        str1 = null;
        if (!bool3)
          str1 = PhoneNumberUtils.getE164PhoneNumber(str2, str3);
      }
    }
    while (true)
    {
      ChipEditText.Chip localChip = this.mEditTextInvitees.findChipByText(str1);
      if (localChip == null)
        break;
      this.mEditTextInvitees.removeChip(localChip);
      return;
      boolean bool1 = localObject instanceof Cursor;
      str1 = null;
      if (bool1)
      {
        Cursor localCursor = (Cursor)localObject;
        str1 = localCursor.getString(localCursor.getColumnIndex("data1"));
      }
    }
    this.mEditTextInvitees.addChip(str1);
  }

  public boolean onOptionsItemSelected(MenuItem paramMenuItem)
  {
    if ((paramMenuItem.getItemId() == 2131427934) && (!this.mEditTextInvitees.commitPendingText()))
    {
      onClickedSend();
      return true;
    }
    return false;
  }

  @Subscribe
  public void onPingEvent(PingEvent paramPingEvent)
  {
    Ping localPing = paramPingEvent.getPing();
    this.mTextViewFeeNotice.setText(localPing.getClient().getFareSplitFeeString());
    this.mAdapterContacts.update(localPing);
    this.mAdapterRecents.update(localPing);
    this.mChipAdapter.update(localPing);
    refreshUi(localPing);
  }

  public void onPrepareOptionsMenu(Menu paramMenu)
  {
    super.onPrepareOptionsMenu(paramMenu);
    if (this.mEditTextInvitees.getMaxChips() == -1)
    {
      this.mMenuItemSend.setEnabled(false);
      return;
    }
    if (!TextUtils.isEmpty(this.mEditTextInvitees.getPendingText()));
    for (int i = 1; ; i = 0)
    {
      int j = this.mEditTextInvitees.getMaxChips();
      int k = this.mEditTextInvitees.getChips().size();
      MenuItem localMenuItem = this.mMenuItemSend;
      boolean bool;
      if (k <= 0)
      {
        bool = false;
        if (i == 0);
      }
      else
      {
        bool = false;
        if (k <= j)
          bool = true;
      }
      localMenuItem.setEnabled(bool);
      return;
    }
  }

  public void onResume()
  {
    super.onResume();
    this.mActionBar.setTitle(getString(2131559078));
  }

  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    super.onViewCreated(paramView, paramBundle);
    this.mAdapterContacts = new FareSplitContactsAdapter(getActivity(), true);
    this.mAdapterRecents = new FareSplitRecentAdapter(getActivity());
    this.mChipAdapter = new FareSplitChipAdapter(getActivity());
    this.mTextViewLimitReached.setText(getString(2131558870));
    this.mEditTextInvitees.setHint(getString(2131558867));
    this.mEditTextInvitees.setAdapter(new FareSplitContactsAdapter(getActivity(), false));
    this.mEditTextInvitees.setChipAdapter(this.mChipAdapter);
    this.mEditTextInvitees.setListener(this);
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(this.mAdapterRecents);
    localArrayList.add(this.mAdapterContacts);
    List localList = Arrays.asList(new String[] { getString(2131559022), getString(2131558523) });
    this.mAdapterMerged = new MergedSectionAdapter(getActivity(), localArrayList, localList);
    this.mAdapterMerged.setItemPaddingHorizontal(getResources().getDimensionPixelSize(2131361892));
    this.mListView.setFastScrollEnabled(true);
    this.mListView.setDrawSelectorOnTop(true);
    this.mListView.setDivider(null);
    this.mListView.setDividerHeight(0);
    this.mListView.setAdapter(this.mAdapterMerged);
    this.mListView.setOnItemClickListener(this);
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.client.feature.faresplit.master.FareSplitInviteFragment
 * JD-Core Version:    0.6.2
 */