package android.support.v7.internal.widget;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.database.DataSetObservable;
import android.os.AsyncTask;
import android.os.Build.VERSION;
import android.text.TextUtils;
import android.util.Log;
import android.util.Xml;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executor;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

public class ActivityChooserModel extends DataSetObservable
{
  private static final String ATTRIBUTE_ACTIVITY = "activity";
  private static final String ATTRIBUTE_TIME = "time";
  private static final String ATTRIBUTE_WEIGHT = "weight";
  private static final boolean DEBUG = false;
  private static final int DEFAULT_ACTIVITY_INFLATION = 5;
  private static final float DEFAULT_HISTORICAL_RECORD_WEIGHT = 1.0F;
  public static final String DEFAULT_HISTORY_FILE_NAME = "activity_choser_model_history.xml";
  public static final int DEFAULT_HISTORY_MAX_LENGTH = 50;
  private static final String HISTORY_FILE_EXTENSION = ".xml";
  private static final int INVALID_INDEX = -1;
  private static final String LOG_TAG = ActivityChooserModel.class.getSimpleName();
  private static final String TAG_HISTORICAL_RECORD = "historical-record";
  private static final String TAG_HISTORICAL_RECORDS = "historical-records";
  private static final Map<String, ActivityChooserModel> sDataModelRegistry;
  private static final Object sRegistryLock = new Object();
  private final List<ActivityResolveInfo> mActivities = new ArrayList();
  private OnChooseActivityListener mActivityChoserModelPolicy;
  private ActivitySorter mActivitySorter = new ActivityChooserModel.DefaultSorter(this, null);
  private boolean mCanReadHistoricalData = true;
  private final Context mContext;
  private final List<HistoricalRecord> mHistoricalRecords = new ArrayList();
  private boolean mHistoricalRecordsChanged = true;
  private final String mHistoryFileName;
  private int mHistoryMaxSize = 50;
  private final Object mInstanceLock = new Object();
  private Intent mIntent;
  private boolean mReadShareHistoryCalled = false;
  private boolean mReloadActivities = false;

  static
  {
    sDataModelRegistry = new HashMap();
  }

  private ActivityChooserModel(Context paramContext, String paramString)
  {
    this.mContext = paramContext.getApplicationContext();
    if ((!TextUtils.isEmpty(paramString)) && (!paramString.endsWith(".xml")));
    for (this.mHistoryFileName = (paramString + ".xml"); ; this.mHistoryFileName = paramString)
      return;
  }

  private boolean addHisoricalRecord(HistoricalRecord paramHistoricalRecord)
  {
    boolean bool = this.mHistoricalRecords.add(paramHistoricalRecord);
    if (bool)
    {
      this.mHistoricalRecordsChanged = true;
      pruneExcessiveHistoricalRecordsIfNeeded();
      persistHistoricalDataIfNeeded();
      sortActivitiesIfNeeded();
      notifyChanged();
    }
    return bool;
  }

  private void ensureConsistentState()
  {
    boolean bool = loadActivitiesIfNeeded() | readHistoricalDataIfNeeded();
    pruneExcessiveHistoricalRecordsIfNeeded();
    if (bool)
    {
      sortActivitiesIfNeeded();
      notifyChanged();
    }
  }

  private void executePersistHistoryAsyncTaskBase()
  {
    PersistHistoryAsyncTask localPersistHistoryAsyncTask = new PersistHistoryAsyncTask(null);
    Object[] arrayOfObject = new Object[2];
    arrayOfObject[0] = new ArrayList(this.mHistoricalRecords);
    arrayOfObject[1] = this.mHistoryFileName;
    localPersistHistoryAsyncTask.execute(arrayOfObject);
  }

  private void executePersistHistoryAsyncTaskSDK11()
  {
    PersistHistoryAsyncTask localPersistHistoryAsyncTask = new PersistHistoryAsyncTask(null);
    Executor localExecutor = AsyncTask.SERIAL_EXECUTOR;
    Object[] arrayOfObject = new Object[2];
    arrayOfObject[0] = new ArrayList(this.mHistoricalRecords);
    arrayOfObject[1] = this.mHistoryFileName;
    localPersistHistoryAsyncTask.executeOnExecutor(localExecutor, arrayOfObject);
  }

  public static ActivityChooserModel get(Context paramContext, String paramString)
  {
    synchronized (sRegistryLock)
    {
      ActivityChooserModel localActivityChooserModel = (ActivityChooserModel)sDataModelRegistry.get(paramString);
      if (localActivityChooserModel == null)
      {
        localActivityChooserModel = new ActivityChooserModel(paramContext, paramString);
        sDataModelRegistry.put(paramString, localActivityChooserModel);
      }
      return localActivityChooserModel;
    }
  }

  private boolean loadActivitiesIfNeeded()
  {
    int i = 0;
    if ((this.mReloadActivities) && (this.mIntent != null))
    {
      this.mReloadActivities = false;
      this.mActivities.clear();
      List localList = this.mContext.getPackageManager().queryIntentActivities(this.mIntent, 0);
      int j = localList.size();
      for (int k = 0; k < j; k++)
      {
        ResolveInfo localResolveInfo = (ResolveInfo)localList.get(k);
        this.mActivities.add(new ActivityResolveInfo(localResolveInfo));
      }
      i = 1;
    }
    return i;
  }

  private void persistHistoricalDataIfNeeded()
  {
    if (!this.mReadShareHistoryCalled)
      throw new IllegalStateException("No preceding call to #readHistoricalData");
    if (!this.mHistoricalRecordsChanged);
    while (true)
    {
      return;
      this.mHistoricalRecordsChanged = false;
      if (TextUtils.isEmpty(this.mHistoryFileName))
        continue;
      if (Build.VERSION.SDK_INT >= 11)
      {
        executePersistHistoryAsyncTaskSDK11();
        continue;
      }
      executePersistHistoryAsyncTaskBase();
    }
  }

  private void pruneExcessiveHistoricalRecordsIfNeeded()
  {
    int i = this.mHistoricalRecords.size() - this.mHistoryMaxSize;
    if (i <= 0);
    while (true)
    {
      return;
      this.mHistoricalRecordsChanged = true;
      for (int j = 0; j < i; j++)
        ((HistoricalRecord)this.mHistoricalRecords.remove(0));
    }
  }

  private boolean readHistoricalDataIfNeeded()
  {
    boolean bool = true;
    if ((this.mCanReadHistoricalData) && (this.mHistoricalRecordsChanged) && (!TextUtils.isEmpty(this.mHistoryFileName)))
    {
      this.mCanReadHistoricalData = false;
      this.mReadShareHistoryCalled = bool;
      readHistoricalDataImpl();
    }
    while (true)
    {
      return bool;
      bool = false;
    }
  }

  private void readHistoricalDataImpl()
  {
    try
    {
      FileInputStream localFileInputStream = this.mContext.openFileInput(this.mHistoryFileName);
      try
      {
        localXmlPullParser = Xml.newPullParser();
        localXmlPullParser.setInput(localFileInputStream, null);
        for (int i = 0; (i != 1) && (i != 2); i = localXmlPullParser.next());
        if (!"historical-records".equals(localXmlPullParser.getName()))
          throw new XmlPullParserException("Share records file does not start with historical-records tag.");
      }
      catch (XmlPullParserException localXmlPullParserException)
      {
        Log.e(LOG_TAG, "Error reading historical recrod file: " + this.mHistoryFileName, localXmlPullParserException);
        if (localFileInputStream != null)
        {
          try
          {
            localFileInputStream.close();
          }
          catch (IOException localIOException4)
          {
          }
          localList = this.mHistoricalRecords;
          localList.clear();
          while (true)
          {
            int j = localXmlPullParser.next();
            if (j == 1)
            {
              if (localFileInputStream != null)
                try
                {
                  localFileInputStream.close();
                }
                catch (IOException localIOException5)
                {
                }
            }
            else
            {
              if ((j == 3) || (j == 4))
                continue;
              if ("historical-record".equals(localXmlPullParser.getName()))
                break;
              throw new XmlPullParserException("Share records file not well-formed.");
            }
          }
        }
      }
      catch (IOException localIOException2)
      {
        while (true)
        {
          XmlPullParser localXmlPullParser;
          List localList;
          Log.e(LOG_TAG, "Error reading historical recrod file: " + this.mHistoryFileName, localIOException2);
          if (localFileInputStream == null)
            break;
          try
          {
            localFileInputStream.close();
          }
          catch (IOException localIOException3)
          {
          }
          localList.add(new HistoricalRecord(localXmlPullParser.getAttributeValue(null, "activity"), Long.parseLong(localXmlPullParser.getAttributeValue(null, "time")), Float.parseFloat(localXmlPullParser.getAttributeValue(null, "weight"))));
        }
      }
      finally
      {
        if (localFileInputStream != null);
        try
        {
          localFileInputStream.close();
          label324: throw localObject;
        }
        catch (IOException localIOException1)
        {
          break label324;
        }
      }
    }
    catch (FileNotFoundException localFileNotFoundException)
    {
    }
  }

  private boolean sortActivitiesIfNeeded()
  {
    if ((this.mActivitySorter != null) && (this.mIntent != null) && (!this.mActivities.isEmpty()) && (!this.mHistoricalRecords.isEmpty()))
      this.mActivitySorter.sort(this.mIntent, this.mActivities, Collections.unmodifiableList(this.mHistoricalRecords));
    for (int i = 1; ; i = 0)
      return i;
  }

  public Intent chooseActivity(int paramInt)
  {
    Intent localIntent1;
    synchronized (this.mInstanceLock)
    {
      if (this.mIntent == null)
      {
        localIntent1 = null;
      }
      else
      {
        ensureConsistentState();
        ActivityResolveInfo localActivityResolveInfo = (ActivityResolveInfo)this.mActivities.get(paramInt);
        ComponentName localComponentName = new ComponentName(localActivityResolveInfo.resolveInfo.activityInfo.packageName, localActivityResolveInfo.resolveInfo.activityInfo.name);
        localIntent1 = new Intent(this.mIntent);
        localIntent1.setComponent(localComponentName);
        if (this.mActivityChoserModelPolicy != null)
        {
          Intent localIntent2 = new Intent(localIntent1);
          if (this.mActivityChoserModelPolicy.onChooseActivity(this, localIntent2))
          {
            localIntent1 = null;
            break label162;
          }
        }
        addHisoricalRecord(new HistoricalRecord(localComponentName, System.currentTimeMillis(), 1.0F));
      }
    }
    label162: return localIntent1;
  }

  public ResolveInfo getActivity(int paramInt)
  {
    synchronized (this.mInstanceLock)
    {
      ensureConsistentState();
      ResolveInfo localResolveInfo = ((ActivityResolveInfo)this.mActivities.get(paramInt)).resolveInfo;
      return localResolveInfo;
    }
  }

  public int getActivityCount()
  {
    synchronized (this.mInstanceLock)
    {
      ensureConsistentState();
      int i = this.mActivities.size();
      return i;
    }
  }

  public int getActivityIndex(ResolveInfo paramResolveInfo)
  {
    while (true)
    {
      int j;
      synchronized (this.mInstanceLock)
      {
        ensureConsistentState();
        List localList = this.mActivities;
        int i = localList.size();
        j = 0;
        if (j >= i)
          continue;
        if (((ActivityResolveInfo)localList.get(j)).resolveInfo != paramResolveInfo)
          break label77;
        break label74;
        j = -1;
      }
      label74: return j;
      label77: j++;
    }
  }

  public ResolveInfo getDefaultActivity()
  {
    ResolveInfo localResolveInfo;
    synchronized (this.mInstanceLock)
    {
      ensureConsistentState();
      if (!this.mActivities.isEmpty())
        localResolveInfo = ((ActivityResolveInfo)this.mActivities.get(0)).resolveInfo;
      else
        localResolveInfo = null;
    }
    return localResolveInfo;
  }

  public int getHistoryMaxSize()
  {
    synchronized (this.mInstanceLock)
    {
      int i = this.mHistoryMaxSize;
      return i;
    }
  }

  public int getHistorySize()
  {
    synchronized (this.mInstanceLock)
    {
      ensureConsistentState();
      int i = this.mHistoricalRecords.size();
      return i;
    }
  }

  public Intent getIntent()
  {
    synchronized (this.mInstanceLock)
    {
      Intent localIntent = this.mIntent;
      return localIntent;
    }
  }

  public void setActivitySorter(ActivitySorter paramActivitySorter)
  {
    synchronized (this.mInstanceLock)
    {
      if (this.mActivitySorter != paramActivitySorter)
      {
        this.mActivitySorter = paramActivitySorter;
        if (sortActivitiesIfNeeded())
          notifyChanged();
      }
    }
  }

  public void setDefaultActivity(int paramInt)
  {
    while (true)
    {
      synchronized (this.mInstanceLock)
      {
        ensureConsistentState();
        ActivityResolveInfo localActivityResolveInfo1 = (ActivityResolveInfo)this.mActivities.get(paramInt);
        ActivityResolveInfo localActivityResolveInfo2 = (ActivityResolveInfo)this.mActivities.get(0);
        if (localActivityResolveInfo2 != null)
        {
          f = 5.0F + (localActivityResolveInfo2.weight - localActivityResolveInfo1.weight);
          addHisoricalRecord(new HistoricalRecord(new ComponentName(localActivityResolveInfo1.resolveInfo.activityInfo.packageName, localActivityResolveInfo1.resolveInfo.activityInfo.name), System.currentTimeMillis(), f));
          return;
        }
      }
      float f = 1.0F;
    }
  }

  public void setHistoryMaxSize(int paramInt)
  {
    synchronized (this.mInstanceLock)
    {
      if (this.mHistoryMaxSize != paramInt)
      {
        this.mHistoryMaxSize = paramInt;
        pruneExcessiveHistoricalRecordsIfNeeded();
        if (sortActivitiesIfNeeded())
          notifyChanged();
      }
    }
  }

  public void setIntent(Intent paramIntent)
  {
    synchronized (this.mInstanceLock)
    {
      if (this.mIntent != paramIntent)
      {
        this.mIntent = paramIntent;
        this.mReloadActivities = true;
        ensureConsistentState();
      }
    }
  }

  public void setOnChooseActivityListener(OnChooseActivityListener paramOnChooseActivityListener)
  {
    synchronized (this.mInstanceLock)
    {
      this.mActivityChoserModelPolicy = paramOnChooseActivityListener;
      return;
    }
  }

  public static abstract interface ActivityChooserModelClient
  {
    public abstract void setActivityChooserModel(ActivityChooserModel paramActivityChooserModel);
  }

  public final class ActivityResolveInfo
    implements Comparable<ActivityResolveInfo>
  {
    public final ResolveInfo resolveInfo;
    public float weight;

    public ActivityResolveInfo(ResolveInfo arg2)
    {
      Object localObject;
      this.resolveInfo = localObject;
    }

    public int compareTo(ActivityResolveInfo paramActivityResolveInfo)
    {
      return Float.floatToIntBits(paramActivityResolveInfo.weight) - Float.floatToIntBits(this.weight);
    }

    public boolean equals(Object paramObject)
    {
      int i = 1;
      if (this == paramObject);
      while (true)
      {
        return i;
        if (paramObject == null)
        {
          i = 0;
          continue;
        }
        if (getClass() != paramObject.getClass())
        {
          i = 0;
          continue;
        }
        ActivityResolveInfo localActivityResolveInfo = (ActivityResolveInfo)paramObject;
        if (Float.floatToIntBits(this.weight) == Float.floatToIntBits(localActivityResolveInfo.weight))
          continue;
        i = 0;
      }
    }

    public int hashCode()
    {
      return 31 + Float.floatToIntBits(this.weight);
    }

    public String toString()
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("[");
      localStringBuilder.append("resolveInfo:").append(this.resolveInfo.toString());
      localStringBuilder.append("; weight:").append(new BigDecimal(this.weight));
      localStringBuilder.append("]");
      return localStringBuilder.toString();
    }
  }

  public static abstract interface ActivitySorter
  {
    public abstract void sort(Intent paramIntent, List<ActivityChooserModel.ActivityResolveInfo> paramList, List<ActivityChooserModel.HistoricalRecord> paramList1);
  }

  public static final class HistoricalRecord
  {
    public final ComponentName activity;
    public final long time;
    public final float weight;

    public HistoricalRecord(ComponentName paramComponentName, long paramLong, float paramFloat)
    {
      this.activity = paramComponentName;
      this.time = paramLong;
      this.weight = paramFloat;
    }

    public HistoricalRecord(String paramString, long paramLong, float paramFloat)
    {
      this(ComponentName.unflattenFromString(paramString), paramLong, paramFloat);
    }

    public boolean equals(Object paramObject)
    {
      int i = 1;
      if (this == paramObject);
      while (true)
      {
        return i;
        if (paramObject == null)
        {
          i = 0;
          continue;
        }
        if (getClass() != paramObject.getClass())
        {
          i = 0;
          continue;
        }
        HistoricalRecord localHistoricalRecord = (HistoricalRecord)paramObject;
        if (this.activity == null)
        {
          if (localHistoricalRecord.activity != null)
          {
            i = 0;
            continue;
          }
        }
        else if (!this.activity.equals(localHistoricalRecord.activity))
        {
          i = 0;
          continue;
        }
        if (this.time != localHistoricalRecord.time)
        {
          i = 0;
          continue;
        }
        if (Float.floatToIntBits(this.weight) == Float.floatToIntBits(localHistoricalRecord.weight))
          continue;
        i = 0;
      }
    }

    public int hashCode()
    {
      if (this.activity == null);
      for (int i = 0; ; i = this.activity.hashCode())
        return 31 * (31 * (i + 31) + (int)(this.time ^ this.time >>> 32)) + Float.floatToIntBits(this.weight);
    }

    public String toString()
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("[");
      localStringBuilder.append("; activity:").append(this.activity);
      localStringBuilder.append("; time:").append(this.time);
      localStringBuilder.append("; weight:").append(new BigDecimal(this.weight));
      localStringBuilder.append("]");
      return localStringBuilder.toString();
    }
  }

  public static abstract interface OnChooseActivityListener
  {
    public abstract boolean onChooseActivity(ActivityChooserModel paramActivityChooserModel, Intent paramIntent);
  }

  private final class PersistHistoryAsyncTask extends AsyncTask<Object, Void, Void>
  {
    private PersistHistoryAsyncTask()
    {
    }

    // ERROR //
    public Void doInBackground(Object[] paramArrayOfObject)
    {
      // Byte code:
      //   0: aload_1
      //   1: iconst_0
      //   2: aaload
      //   3: checkcast 35	java/util/List
      //   6: astore_2
      //   7: aload_1
      //   8: iconst_1
      //   9: aaload
      //   10: checkcast 37	java/lang/String
      //   13: astore_3
      //   14: aload_0
      //   15: getfield 14	android/support/v7/internal/widget/ActivityChooserModel$PersistHistoryAsyncTask:this$0	Landroid/support/v7/internal/widget/ActivityChooserModel;
      //   18: invokestatic 41	android/support/v7/internal/widget/ActivityChooserModel:access$200	(Landroid/support/v7/internal/widget/ActivityChooserModel;)Landroid/content/Context;
      //   21: aload_3
      //   22: iconst_0
      //   23: invokevirtual 47	android/content/Context:openFileOutput	(Ljava/lang/String;I)Ljava/io/FileOutputStream;
      //   26: astore 6
      //   28: invokestatic 53	android/util/Xml:newSerializer	()Lorg/xmlpull/v1/XmlSerializer;
      //   31: astore 7
      //   33: aload 7
      //   35: aload 6
      //   37: aconst_null
      //   38: invokeinterface 59 3 0
      //   43: aload 7
      //   45: ldc 61
      //   47: iconst_1
      //   48: invokestatic 67	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
      //   51: invokeinterface 71 3 0
      //   56: aload 7
      //   58: aconst_null
      //   59: ldc 73
      //   61: invokeinterface 77 3 0
      //   66: pop
      //   67: aload_2
      //   68: invokeinterface 81 1 0
      //   73: istore 24
      //   75: iconst_0
      //   76: istore 25
      //   78: iload 25
      //   80: iload 24
      //   82: if_icmpge +132 -> 214
      //   85: aload_2
      //   86: iconst_0
      //   87: invokeinterface 85 2 0
      //   92: checkcast 87	android/support/v7/internal/widget/ActivityChooserModel$HistoricalRecord
      //   95: astore 29
      //   97: aload 7
      //   99: aconst_null
      //   100: ldc 89
      //   102: invokeinterface 77 3 0
      //   107: pop
      //   108: aload 7
      //   110: aconst_null
      //   111: ldc 91
      //   113: aload 29
      //   115: getfield 94	android/support/v7/internal/widget/ActivityChooserModel$HistoricalRecord:activity	Landroid/content/ComponentName;
      //   118: invokevirtual 100	android/content/ComponentName:flattenToString	()Ljava/lang/String;
      //   121: invokeinterface 104 4 0
      //   126: pop
      //   127: aload 7
      //   129: aconst_null
      //   130: ldc 106
      //   132: aload 29
      //   134: getfield 109	android/support/v7/internal/widget/ActivityChooserModel$HistoricalRecord:time	J
      //   137: invokestatic 112	java/lang/String:valueOf	(J)Ljava/lang/String;
      //   140: invokeinterface 104 4 0
      //   145: pop
      //   146: aload 7
      //   148: aconst_null
      //   149: ldc 114
      //   151: aload 29
      //   153: getfield 117	android/support/v7/internal/widget/ActivityChooserModel$HistoricalRecord:weight	F
      //   156: invokestatic 120	java/lang/String:valueOf	(F)Ljava/lang/String;
      //   159: invokeinterface 104 4 0
      //   164: pop
      //   165: aload 7
      //   167: aconst_null
      //   168: ldc 89
      //   170: invokeinterface 123 3 0
      //   175: pop
      //   176: iinc 25 1
      //   179: goto -101 -> 78
      //   182: astore 4
      //   184: invokestatic 126	android/support/v7/internal/widget/ActivityChooserModel:access$300	()Ljava/lang/String;
      //   187: new 128	java/lang/StringBuilder
      //   190: dup
      //   191: invokespecial 129	java/lang/StringBuilder:<init>	()V
      //   194: ldc 131
      //   196: invokevirtual 135	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   199: aload_3
      //   200: invokevirtual 135	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   203: invokevirtual 138	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   206: aload 4
      //   208: invokestatic 144	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
      //   211: pop
      //   212: aconst_null
      //   213: areturn
      //   214: aload 7
      //   216: aconst_null
      //   217: ldc 73
      //   219: invokeinterface 123 3 0
      //   224: pop
      //   225: aload 7
      //   227: invokeinterface 147 1 0
      //   232: aload_0
      //   233: getfield 14	android/support/v7/internal/widget/ActivityChooserModel$PersistHistoryAsyncTask:this$0	Landroid/support/v7/internal/widget/ActivityChooserModel;
      //   236: iconst_1
      //   237: invokestatic 151	android/support/v7/internal/widget/ActivityChooserModel:access$502	(Landroid/support/v7/internal/widget/ActivityChooserModel;Z)Z
      //   240: pop
      //   241: aload 6
      //   243: ifnull +8 -> 251
      //   246: aload 6
      //   248: invokevirtual 156	java/io/FileOutputStream:close	()V
      //   251: goto -39 -> 212
      //   254: astore 19
      //   256: invokestatic 126	android/support/v7/internal/widget/ActivityChooserModel:access$300	()Ljava/lang/String;
      //   259: new 128	java/lang/StringBuilder
      //   262: dup
      //   263: invokespecial 129	java/lang/StringBuilder:<init>	()V
      //   266: ldc 131
      //   268: invokevirtual 135	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   271: aload_0
      //   272: getfield 14	android/support/v7/internal/widget/ActivityChooserModel$PersistHistoryAsyncTask:this$0	Landroid/support/v7/internal/widget/ActivityChooserModel;
      //   275: invokestatic 160	android/support/v7/internal/widget/ActivityChooserModel:access$400	(Landroid/support/v7/internal/widget/ActivityChooserModel;)Ljava/lang/String;
      //   278: invokevirtual 135	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   281: invokevirtual 138	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   284: aload 19
      //   286: invokestatic 144	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
      //   289: pop
      //   290: aload_0
      //   291: getfield 14	android/support/v7/internal/widget/ActivityChooserModel$PersistHistoryAsyncTask:this$0	Landroid/support/v7/internal/widget/ActivityChooserModel;
      //   294: iconst_1
      //   295: invokestatic 151	android/support/v7/internal/widget/ActivityChooserModel:access$502	(Landroid/support/v7/internal/widget/ActivityChooserModel;Z)Z
      //   298: pop
      //   299: aload 6
      //   301: ifnull -50 -> 251
      //   304: aload 6
      //   306: invokevirtual 156	java/io/FileOutputStream:close	()V
      //   309: goto -58 -> 251
      //   312: astore 22
      //   314: goto -63 -> 251
      //   317: astore 15
      //   319: invokestatic 126	android/support/v7/internal/widget/ActivityChooserModel:access$300	()Ljava/lang/String;
      //   322: new 128	java/lang/StringBuilder
      //   325: dup
      //   326: invokespecial 129	java/lang/StringBuilder:<init>	()V
      //   329: ldc 131
      //   331: invokevirtual 135	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   334: aload_0
      //   335: getfield 14	android/support/v7/internal/widget/ActivityChooserModel$PersistHistoryAsyncTask:this$0	Landroid/support/v7/internal/widget/ActivityChooserModel;
      //   338: invokestatic 160	android/support/v7/internal/widget/ActivityChooserModel:access$400	(Landroid/support/v7/internal/widget/ActivityChooserModel;)Ljava/lang/String;
      //   341: invokevirtual 135	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   344: invokevirtual 138	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   347: aload 15
      //   349: invokestatic 144	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
      //   352: pop
      //   353: aload_0
      //   354: getfield 14	android/support/v7/internal/widget/ActivityChooserModel$PersistHistoryAsyncTask:this$0	Landroid/support/v7/internal/widget/ActivityChooserModel;
      //   357: iconst_1
      //   358: invokestatic 151	android/support/v7/internal/widget/ActivityChooserModel:access$502	(Landroid/support/v7/internal/widget/ActivityChooserModel;Z)Z
      //   361: pop
      //   362: aload 6
      //   364: ifnull -113 -> 251
      //   367: aload 6
      //   369: invokevirtual 156	java/io/FileOutputStream:close	()V
      //   372: goto -121 -> 251
      //   375: astore 18
      //   377: goto -126 -> 251
      //   380: astore 11
      //   382: invokestatic 126	android/support/v7/internal/widget/ActivityChooserModel:access$300	()Ljava/lang/String;
      //   385: new 128	java/lang/StringBuilder
      //   388: dup
      //   389: invokespecial 129	java/lang/StringBuilder:<init>	()V
      //   392: ldc 131
      //   394: invokevirtual 135	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   397: aload_0
      //   398: getfield 14	android/support/v7/internal/widget/ActivityChooserModel$PersistHistoryAsyncTask:this$0	Landroid/support/v7/internal/widget/ActivityChooserModel;
      //   401: invokestatic 160	android/support/v7/internal/widget/ActivityChooserModel:access$400	(Landroid/support/v7/internal/widget/ActivityChooserModel;)Ljava/lang/String;
      //   404: invokevirtual 135	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   407: invokevirtual 138	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   410: aload 11
      //   412: invokestatic 144	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
      //   415: pop
      //   416: aload_0
      //   417: getfield 14	android/support/v7/internal/widget/ActivityChooserModel$PersistHistoryAsyncTask:this$0	Landroid/support/v7/internal/widget/ActivityChooserModel;
      //   420: iconst_1
      //   421: invokestatic 151	android/support/v7/internal/widget/ActivityChooserModel:access$502	(Landroid/support/v7/internal/widget/ActivityChooserModel;Z)Z
      //   424: pop
      //   425: aload 6
      //   427: ifnull -176 -> 251
      //   430: aload 6
      //   432: invokevirtual 156	java/io/FileOutputStream:close	()V
      //   435: goto -184 -> 251
      //   438: astore 14
      //   440: goto -189 -> 251
      //   443: astore 8
      //   445: aload_0
      //   446: getfield 14	android/support/v7/internal/widget/ActivityChooserModel$PersistHistoryAsyncTask:this$0	Landroid/support/v7/internal/widget/ActivityChooserModel;
      //   449: iconst_1
      //   450: invokestatic 151	android/support/v7/internal/widget/ActivityChooserModel:access$502	(Landroid/support/v7/internal/widget/ActivityChooserModel;Z)Z
      //   453: pop
      //   454: aload 6
      //   456: ifnull +8 -> 464
      //   459: aload 6
      //   461: invokevirtual 156	java/io/FileOutputStream:close	()V
      //   464: aload 8
      //   466: athrow
      //   467: astore 28
      //   469: goto -218 -> 251
      //   472: astore 10
      //   474: goto -10 -> 464
      //
      // Exception table:
      //   from	to	target	type
      //   14	28	182	java/io/FileNotFoundException
      //   33	176	254	java/lang/IllegalArgumentException
      //   214	232	254	java/lang/IllegalArgumentException
      //   304	309	312	java/io/IOException
      //   33	176	317	java/lang/IllegalStateException
      //   214	232	317	java/lang/IllegalStateException
      //   367	372	375	java/io/IOException
      //   33	176	380	java/io/IOException
      //   214	232	380	java/io/IOException
      //   430	435	438	java/io/IOException
      //   33	176	443	finally
      //   214	232	443	finally
      //   256	290	443	finally
      //   319	353	443	finally
      //   382	416	443	finally
      //   246	251	467	java/io/IOException
      //   459	464	472	java/io/IOException
    }
  }
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     android.support.v7.internal.widget.ActivityChooserModel
 * JD-Core Version:    0.6.0
 */