package com.ubercab.client.feature.employeeupgrade;

import android.app.Activity;
import android.app.Dialog;
import android.app.DownloadManager;
import android.app.DownloadManager.Query;
import android.app.DownloadManager.Request;
import android.content.IntentFilter;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.text.Html;
import android.text.method.LinkMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView.BufferType;
import android.widget.Toast;
import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;
import com.ubercab.client.core.app.RiderDialogFragment;
import com.ubercab.client.core.app.RiderPreferences;
import com.ubercab.client.core.model.EmployeeUpgrade;
import com.ubercab.ui.UberButton;
import com.ubercab.ui.UberTextView;
import java.io.File;
import javax.inject.Inject;

public class EmployeeUpgradeFragment extends RiderDialogFragment
{
  private static final String ARG_EMPLOYEE_UPGRADE = "employee_upgrade";
  private static final int CHANGELOG_LINE_SPACING_EXTRA_PIXELS = 0;
  private static final float CHANGELOG_LINE_SPACING_MULTIPLIER = 1.25F;
  public static final String TAG = EmployeeUpgradeFragment.class.getName();

  @InjectView(2131427432)
  UberButton mButtonSkip;

  @InjectView(2131427433)
  UberButton mButtonUpdate;
  private DownloadManager mDownloadManager;
  private EmployeeUpgrade mEmployeeUpgrade;

  @Inject
  RiderPreferences mRiderPreferences;

  @InjectView(2131427431)
  UberTextView mTextViewChangelog;

  @InjectView(2131427430)
  UberTextView mTextViewSubtitle;

  @InjectView(2131427927)
  UberTextView mTextViewTitle;

  private void downloadUpdate()
  {
    Uri localUri1 = Uri.parse(this.mEmployeeUpgrade.getDownloadUrl());
    Uri localUri2 = Uri.fromFile(getActivity().getExternalFilesDir(Environment.DIRECTORY_DOWNLOADS));
    DownloadManager.Request localRequest = new DownloadManager.Request(localUri1);
    localRequest.setNotificationVisibility(0);
    localRequest.setDestinationUri(localUri2);
    long l = this.mDownloadManager.enqueue(localRequest);
    getActivity().registerReceiver(new EmployeeUpgradeDownloadReceiver(l), new IntentFilter("android.intent.action.DOWNLOAD_COMPLETE"));
    Toast.makeText(getActivity(), getString(2131559084), 1).show();
    getDialog().dismiss();
    this.mRiderPreferences.setLastDownloadedEmployeeUpgradeUri(this.mEmployeeUpgrade.getDownloadUrl());
  }

  private void installCachedUpdate()
  {
    DownloadManager.Query localQuery = new DownloadManager.Query().setFilterByStatus(8);
    Cursor localCursor = this.mDownloadManager.query(localQuery);
    while (localCursor.moveToNext())
      if (localCursor.getString(localCursor.getColumnIndex("uri")).equals(this.mRiderPreferences.getLastDownloadedEmployeeUpgradeUri()))
      {
        File localFile = new File(localCursor.getString(localCursor.getColumnIndex("local_filename")));
        EmployeeUpgradeUtils.startInstallIntent(getActivity(), Uri.fromFile(localFile));
        return;
      }
    downloadUpdate();
  }

  public static EmployeeUpgradeFragment newInstance(EmployeeUpgrade paramEmployeeUpgrade)
  {
    Bundle localBundle = new Bundle();
    localBundle.putParcelable("employee_upgrade", paramEmployeeUpgrade);
    EmployeeUpgradeFragment localEmployeeUpgradeFragment = new EmployeeUpgradeFragment();
    localEmployeeUpgradeFragment.setArguments(localBundle);
    return localEmployeeUpgradeFragment;
  }

  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.mEmployeeUpgrade = ((EmployeeUpgrade)getArguments().getParcelable("employee_upgrade"));
    this.mDownloadManager = ((DownloadManager)getActivity().getSystemService("download"));
    setStyle(1, 2131624112);
  }

  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    View localView = paramLayoutInflater.inflate(2130903076, paramViewGroup, false);
    ButterKnife.inject(this, localView);
    return localView;
  }

  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    super.onViewCreated(paramView, paramBundle);
    this.mButtonSkip.setText(getString(2131558944));
    this.mButtonUpdate.setText(getString(2131559320));
    this.mTextViewTitle.setText(getString(2131558449) + " - " + this.mEmployeeUpgrade.getVersion());
    this.mTextViewSubtitle.setText(getString(2131558832));
    this.mTextViewChangelog.setText(Html.fromHtml(this.mEmployeeUpgrade.getReleaseNotes()), TextView.BufferType.SPANNABLE);
    this.mTextViewChangelog.setLineSpacing(0.0F, 1.25F);
    this.mTextViewChangelog.setMovementMethod(LinkMovementMethod.getInstance());
  }

  @OnClick({2131427432})
  public void skipTapped()
  {
    getDialog().dismiss();
  }

  @OnClick({2131427433})
  public void updateTapped()
  {
    if (this.mEmployeeUpgrade.getDownloadUrl().equals(this.mRiderPreferences.getLastDownloadedEmployeeUpgradeUri()))
    {
      installCachedUpdate();
      return;
    }
    downloadUpdate();
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.client.feature.employeeupgrade.EmployeeUpgradeFragment
 * JD-Core Version:    0.6.2
 */