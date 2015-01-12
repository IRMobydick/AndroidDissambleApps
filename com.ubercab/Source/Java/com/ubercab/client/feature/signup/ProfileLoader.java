package com.ubercab.client.feature.signup;

import android.content.AsyncTaskLoader;
import android.content.Context;
import android.database.Cursor;
import android.text.TextUtils;
import com.ubercab.library.util.PhoneNumberUtils;
import java.util.Locale;

class ProfileLoader extends AsyncTaskLoader<Profile>
{
  private static final String PERMISSION_READ_PROFILE = "android.permission.READ_PROFILE";

  ProfileLoader(Context paramContext)
  {
    super(paramContext);
  }

  private void loadContactData(Cursor paramCursor, Profile paramProfile)
  {
    while (paramCursor.moveToNext())
    {
      String str1 = paramCursor.getString(paramCursor.getColumnIndex("mimetype"));
      int i = -1;
      switch (str1.hashCode())
      {
      default:
      case -1569536764:
      case -1079224304:
      case 684173810:
      case 1828520899:
      }
      while (true)
        switch (i)
        {
        default:
          break;
        case 0:
          paramProfile.addEmail(paramCursor.getString(paramCursor.getColumnIndex("data1")));
          break;
          if (str1.equals("vnd.android.cursor.item/email_v2"))
          {
            i = 0;
            continue;
            if (str1.equals("vnd.android.cursor.item/name"))
            {
              i = 1;
              continue;
              if (str1.equals("vnd.android.cursor.item/phone_v2"))
              {
                i = 2;
                continue;
                if (str1.equals("vnd.android.cursor.item/identity"))
                  i = 3;
              }
            }
          }
          break;
        case 1:
        case 2:
        case 3:
        }
      paramProfile.addName(paramCursor.getString(paramCursor.getColumnIndex("data2")), paramCursor.getString(paramCursor.getColumnIndex("data3")));
      continue;
      String str4 = paramCursor.getString(paramCursor.getColumnIndex("data1"));
      String str5 = PhoneNumberUtils.getCountryIso2ForPhoneNumber(str4, Locale.getDefault().getCountry());
      if (!TextUtils.isEmpty(str5))
      {
        paramProfile.addPhone(PhoneNumberUtils.getDisplayPhoneNumber(str4, str5), str5);
        continue;
        String str2 = paramCursor.getString(paramCursor.getColumnIndex("data2"));
        String str3 = paramCursor.getString(paramCursor.getColumnIndex("account_name"));
        if (str2.equals("com.google"))
          paramProfile.addEmail(str3);
      }
    }
  }

  // ERROR //
  public Profile loadInBackground()
  {
    // Byte code:
    //   0: new 41	com/ubercab/client/feature/signup/Profile
    //   3: dup
    //   4: invokespecial 104	com/ubercab/client/feature/signup/Profile:<init>	()V
    //   7: astore_1
    //   8: aload_0
    //   9: invokevirtual 108	com/ubercab/client/feature/signup/ProfileLoader:getContext	()Landroid/content/Context;
    //   12: ldc 110
    //   14: invokevirtual 116	android/content/Context:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
    //   17: checkcast 118	android/telephony/TelephonyManager
    //   20: astore_3
    //   21: aload_3
    //   22: invokevirtual 121	android/telephony/TelephonyManager:getLine1Number	()Ljava/lang/String;
    //   25: invokestatic 87	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   28: ifne +22 -> 50
    //   31: aload_1
    //   32: aload_3
    //   33: invokevirtual 121	android/telephony/TelephonyManager:getLine1Number	()Ljava/lang/String;
    //   36: aload_3
    //   37: invokevirtual 124	android/telephony/TelephonyManager:getSimCountryIso	()Ljava/lang/String;
    //   40: invokestatic 90	com/ubercab/library/util/PhoneNumberUtils:getDisplayPhoneNumber	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   43: aload_3
    //   44: invokevirtual 124	android/telephony/TelephonyManager:getSimCountryIso	()Ljava/lang/String;
    //   47: invokevirtual 93	com/ubercab/client/feature/signup/Profile:addPhone	(Ljava/lang/String;Ljava/lang/String;)V
    //   50: aload_0
    //   51: invokevirtual 108	com/ubercab/client/feature/signup/ProfileLoader:getContext	()Landroid/content/Context;
    //   54: ldc 126
    //   56: invokevirtual 116	android/content/Context:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
    //   59: checkcast 128	android/accounts/AccountManager
    //   62: ldc 97
    //   64: invokevirtual 132	android/accounts/AccountManager:getAccountsByType	(Ljava/lang/String;)[Landroid/accounts/Account;
    //   67: astore 4
    //   69: aload 4
    //   71: arraylength
    //   72: istore 5
    //   74: iconst_0
    //   75: istore 6
    //   77: iload 6
    //   79: iload 5
    //   81: if_icmpge +21 -> 102
    //   84: aload_1
    //   85: aload 4
    //   87: iload 6
    //   89: aaload
    //   90: getfield 137	android/accounts/Account:name	Ljava/lang/String;
    //   93: invokevirtual 45	com/ubercab/client/feature/signup/Profile:addEmail	(Ljava/lang/String;)V
    //   96: iinc 6 1
    //   99: goto -22 -> 77
    //   102: aload_0
    //   103: invokevirtual 108	com/ubercab/client/feature/signup/ProfileLoader:getContext	()Landroid/content/Context;
    //   106: invokevirtual 141	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   109: astore 7
    //   111: aload_0
    //   112: invokevirtual 108	com/ubercab/client/feature/signup/ProfileLoader:getContext	()Landroid/content/Context;
    //   115: ldc 9
    //   117: invokevirtual 144	android/content/Context:checkCallingOrSelfPermission	(Ljava/lang/String;)I
    //   120: ifne +49 -> 169
    //   123: getstatic 150	android/provider/ContactsContract$Profile:CONTENT_URI	Landroid/net/Uri;
    //   126: ldc 152
    //   128: invokestatic 158	android/net/Uri:withAppendedPath	(Landroid/net/Uri;Ljava/lang/String;)Landroid/net/Uri;
    //   131: astore 17
    //   133: aconst_null
    //   134: astore 18
    //   136: aload 7
    //   138: aload 17
    //   140: aconst_null
    //   141: aconst_null
    //   142: aconst_null
    //   143: ldc 160
    //   145: invokevirtual 166	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   148: astore 18
    //   150: aload_0
    //   151: aload 18
    //   153: aload_1
    //   154: invokespecial 168	com/ubercab/client/feature/signup/ProfileLoader:loadContactData	(Landroid/database/Cursor;Lcom/ubercab/client/feature/signup/Profile;)V
    //   157: aload 18
    //   159: ifnull +10 -> 169
    //   162: aload 18
    //   164: invokeinterface 171 1 0
    //   169: aload_1
    //   170: invokevirtual 175	com/ubercab/client/feature/signup/Profile:getEmails	()Ljava/util/Set;
    //   173: invokeinterface 179 1 0
    //   178: ifne +267 -> 445
    //   181: aload_1
    //   182: invokevirtual 182	com/ubercab/client/feature/signup/Profile:getNames	()Ljava/util/Set;
    //   185: invokeinterface 179 1 0
    //   190: ifeq +255 -> 445
    //   193: iconst_m1
    //   194: istore 8
    //   196: getstatic 187	android/provider/ContactsContract$Contacts:CONTENT_FILTER_URI	Landroid/net/Uri;
    //   199: aload_1
    //   200: invokevirtual 190	com/ubercab/client/feature/signup/Profile:getTopEmail	()Ljava/lang/String;
    //   203: invokestatic 158	android/net/Uri:withAppendedPath	(Landroid/net/Uri;Ljava/lang/String;)Landroid/net/Uri;
    //   206: astore 9
    //   208: aconst_null
    //   209: astore 10
    //   211: aload 7
    //   213: aload 9
    //   215: aconst_null
    //   216: aconst_null
    //   217: aconst_null
    //   218: aconst_null
    //   219: invokevirtual 166	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   222: astore 10
    //   224: aload 10
    //   226: invokeinterface 193 1 0
    //   231: ifeq +25 -> 256
    //   234: aload 10
    //   236: aload 10
    //   238: ldc 195
    //   240: invokeinterface 27 2 0
    //   245: invokeinterface 199 2 0
    //   250: istore 16
    //   252: iload 16
    //   254: istore 8
    //   256: aload 10
    //   258: ifnull +13 -> 271
    //   261: aload 10
    //   263: invokeinterface 171 1 0
    //   268: aconst_null
    //   269: astore 10
    //   271: iload 8
    //   273: iflt +172 -> 445
    //   276: iconst_1
    //   277: anewarray 33	java/lang/String
    //   280: astore 13
    //   282: aload 13
    //   284: iconst_0
    //   285: iload 8
    //   287: invokestatic 202	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   290: aastore
    //   291: aload 7
    //   293: getstatic 205	android/provider/ContactsContract$Data:CONTENT_URI	Landroid/net/Uri;
    //   296: aconst_null
    //   297: ldc 207
    //   299: aload 13
    //   301: aconst_null
    //   302: invokevirtual 166	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   305: astore 10
    //   307: aload_0
    //   308: aload 10
    //   310: aload_1
    //   311: invokespecial 168	com/ubercab/client/feature/signup/ProfileLoader:loadContactData	(Landroid/database/Cursor;Lcom/ubercab/client/feature/signup/Profile;)V
    //   314: aload 10
    //   316: ifnull +129 -> 445
    //   319: aload 10
    //   321: invokeinterface 171 1 0
    //   326: aload_1
    //   327: areturn
    //   328: astore 20
    //   330: aload 18
    //   332: ifnull -163 -> 169
    //   335: aload 18
    //   337: invokeinterface 171 1 0
    //   342: goto -173 -> 169
    //   345: astore_2
    //   346: aload_2
    //   347: ldc 209
    //   349: iconst_0
    //   350: anewarray 211	java/lang/Object
    //   353: invokestatic 217	timber/log/Timber:e	(Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   356: aload_1
    //   357: areturn
    //   358: astore 19
    //   360: aload 18
    //   362: ifnull +10 -> 372
    //   365: aload 18
    //   367: invokeinterface 171 1 0
    //   372: aload 19
    //   374: athrow
    //   375: astore 12
    //   377: aload 10
    //   379: ifnull -108 -> 271
    //   382: aload 10
    //   384: invokeinterface 171 1 0
    //   389: aconst_null
    //   390: astore 10
    //   392: goto -121 -> 271
    //   395: astore 11
    //   397: aload 10
    //   399: ifnull +10 -> 409
    //   402: aload 10
    //   404: invokeinterface 171 1 0
    //   409: aload 11
    //   411: athrow
    //   412: astore 15
    //   414: aload 10
    //   416: ifnull +29 -> 445
    //   419: aload 10
    //   421: invokeinterface 171 1 0
    //   426: aload_1
    //   427: areturn
    //   428: astore 14
    //   430: aload 10
    //   432: ifnull +10 -> 442
    //   435: aload 10
    //   437: invokeinterface 171 1 0
    //   442: aload 14
    //   444: athrow
    //   445: aload_1
    //   446: areturn
    //
    // Exception table:
    //   from	to	target	type
    //   136	157	328	java/lang/Exception
    //   8	50	345	java/lang/Exception
    //   50	74	345	java/lang/Exception
    //   84	96	345	java/lang/Exception
    //   102	133	345	java/lang/Exception
    //   162	169	345	java/lang/Exception
    //   169	193	345	java/lang/Exception
    //   196	208	345	java/lang/Exception
    //   261	268	345	java/lang/Exception
    //   276	291	345	java/lang/Exception
    //   319	326	345	java/lang/Exception
    //   335	342	345	java/lang/Exception
    //   365	372	345	java/lang/Exception
    //   372	375	345	java/lang/Exception
    //   382	389	345	java/lang/Exception
    //   402	409	345	java/lang/Exception
    //   409	412	345	java/lang/Exception
    //   419	426	345	java/lang/Exception
    //   435	442	345	java/lang/Exception
    //   442	445	345	java/lang/Exception
    //   136	157	358	finally
    //   211	252	375	java/lang/Exception
    //   211	252	395	finally
    //   291	314	412	java/lang/Exception
    //   291	314	428	finally
  }

  protected void onStartLoading()
  {
    super.onStartLoading();
    forceLoad();
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.client.feature.signup.ProfileLoader
 * JD-Core Version:    0.6.2
 */